
public class Maillon {
	public Object object;
   public Maillon next;	
	
public Maillon(Object o, Maillon m){
	this.object = o;
	this.next = m;

}
public Object getObjet(){
	return object;
}
public void setObject(Object o){
    this.object = o;
}
}
