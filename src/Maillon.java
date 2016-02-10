
/**
 * @author Etienne
 * @author Antoine de Villers
 */
public class Maillon {
	public Object object;
   public Maillon next;	
	
/**
 * Constructeur
 * @param o
 * @param m
 */
public Maillon(Object o, Maillon m){
	this.object = o;
	this.next = m;

}
/**
 * @return l'objet associé au maillon
 */
public Object getObjet(){
	return object;
}
/**
 * Ajoute un objet
 * @param o
 */
public void setObject(Object o){
    this.object = o;
}
}
