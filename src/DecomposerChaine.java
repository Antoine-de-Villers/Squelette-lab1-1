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
			
			
			
			String mseqString = m.group(1).trim();
			System.out.println(mseqString);

			nseq = Integer.parseInt(mseqString);
			name = m.group(2).trim();
			
			System.out.println(name);
			coordonnees = m.group(3);
			parts=coordonnees.split(" ");			
			
			System.out.println(parts[1]);
			System.out.println(parts[2]);
			System.out.println(parts[3]);
			try{
			System.out.println(parts[4]);
			}catch(Exception e){
				//C'est un cercle
			}
			
			x1= Integer.parseInt(parts[1]);
			x2= Integer.parseInt(parts[2]);
			x3= Integer.parseInt(parts[3]);
			try{
			x4= Integer.parseInt(parts[4]);
			}catch(Exception e){
				//C'est un cercle
			}
			
		}
	
		public String getName(){
	    	return name;
	    }
	    
	    public int getX1(){
	    	return x1;
	    }
	    
	    public int getX2(){
	    	return x2;
	    }
	    
	    public int getX3(){
	    	return x3;
	    }
	    
	    public int getX4(){
	    	return x4;
	    }
	    
	    public int getNSEQ(){
		  return nseq;
	  }

}
