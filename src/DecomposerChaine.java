import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecomposerChaine {
	private String[] parts;
	private int nseq;
	private String name;
	String coordonnees;
	private int x1;
	private int x2;
	private int x3;
	private int x4;
	
    public DecomposerChaine(){
	
}
    
    public void Split(String info){
    	
    	Pattern p = Pattern.compile("(.*)<(.*)>(.*)</\\2>");
    	
    	findtag(p, info);
    	
		
    }
    
    private void findtag(Pattern p, String info) {
    	Matcher m = p.matcher(info);
    	m.find();
		//nseq = Integer.parseInt(m.group(1));
		name = m.group(2);
		System.out.println("groupe 1 "+m.group(1));
		System.out.println("groupe 2 "+m.group(2));
		System.out.println("groupe 3 "+m.group(3));
		coordonnees = m.group(3);
		
		parts=coordonnees.split(" ");
		x1= Integer.parseInt(parts[0]);
		x2= Integer.parseInt(parts[1]);
		x3= Integer.parseInt(parts[2]);
		try{
		x4= Integer.parseInt(parts[3]);
		}catch(Exception e){
			//C'est un cercle
		}
	}

	public String getName(){
    	return name;
    }
    
    public int GetX1(){
    	return x1;
    }
    
    public int GetX2(){
    	return x2;
    }
    
    public int GetX3(){
    	return x3;
    }
    
    public int GetX4(){
    	return x4;
    }
    
    public int getNSEQ(){
	  return nseq;
  }
}
