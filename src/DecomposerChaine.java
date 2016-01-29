import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui decompose la chaine de caractère du serveur
 * @author Etienne
 * @author Antoine
 */
public class DecomposerChaine {
	private String[] parts;
		private int nseq;
		private String name;
		String coordonnees;
		private int x1;
		private int x2;
		private int x3;
		private int x4;
		
	    /**
	     * Constructeur
	     */
	    public DecomposerChaine(){
		
	}
	    
	    /**
	     * Méthode qui sépare les infos de la chaine selon un "pattern"
	     * @param info
	     */
	    public void Split(String info){
	    	Pattern p = Pattern.compile("(.*)<(.*)>(.*)</\\2>");  	
	    	findtag(p, info);			
	    }
	    
	    /**
	     * Méthode qui instanci les différentes infos dans des attributs
	     * @param p
	     * @param info
	     */
	    private void findtag(Pattern p, String info) {
	    	Matcher m = p.matcher(info);
	    	m.find();
			
			String mseqString = m.group(1).trim();

			nseq = Integer.parseInt(mseqString);
			name = m.group(2).trim();
			
			coordonnees = m.group(3);
			parts=coordonnees.split(" ");			
			
			x1= Integer.parseInt(parts[1]);
			x2= Integer.parseInt(parts[2]);
			x3= Integer.parseInt(parts[3]);
			try{
			x4= Integer.parseInt(parts[4]);
			}catch(Exception e){
				//C'est un cercle
			}
			
		}
	
		/**
		 * @return le nom de la forme
		 */
		public String getName(){
	    	return name;
	    }
	    
	    /**
	     * @return la position x1
	     */
	    public int getX1(){
	    	return x1;
	    }
	    
	    /**
	     * @return la position x2
	     */
	    public int getX2(){
	    	return x2;
	    }
	    
	    /**
	     * @return la position x3
	     */
	    public int getX3(){
	    	return x3;
	    }
	    
	    /**
	     * @return la position x4
	     */
	    public int getX4(){
	    	return x4;
	    }
	    
	    /**
	     * @return le code de la forme
	     */
	    public int getNSEQ(){
		  return nseq;
	  }

}
