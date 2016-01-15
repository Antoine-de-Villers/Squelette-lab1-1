import java.awt.Color;

public abstract class Forme{
    protected static Color color;
	protected int nseq;
	protected String name;
	protected int x1;
	protected int x2;
	protected int x3;
	protected int x4;
	
	
	
	/**
	 * Constructeur default
	 */
	public Forme() {	
	}
	/**
	 * Constructeur formes sauf cercle
	 */
	public Forme(int nseq,String name, int x1, int x2, int x3, int x4){
		this.nseq=nseq;
		this.name=name;
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
		this.x4=x4;
	}
	/**
	 * Constructeur du cercle
	 */
	public Forme(int nseq,String name, int x1, int x2, int x3){
		this.nseq=nseq;
		this.name=name;
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
	}
	public String getName(){
		return this.name;
	}
	public Color getColor(){
		return this.color;
	}
	public int getX1(){
		return this.x1;
	}
	public int getX2(){
		return this.x2;
	}
	public int getX3(){
		return this.x3;
	}
	public int getX4(){
		return this.x4;
	}
}
