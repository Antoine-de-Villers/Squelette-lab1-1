/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: Forme.java
Date cr√©√©: 2016-01-15
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Antoine de Villers
 *@author …tienne Rousseau
2016-01-15 Version initiale
 *@author Antoine de Villers
 *@author …tienne Rousseau
2016-01-28 Version finale
 *******************************************************/  
import java.awt.Color;

public abstract class Forme{
	
	protected  Color color;
	protected int nseq;
	protected String name;
	protected int x1;
	protected int x2;
	protected int x3;
	protected int x4;
	protected double aire;
	protected double distanceMax;
	protected int height;
	protected int width;
	protected int type;



	/**
	 * Constructeur default
	 */
	public Forme() {	
	}
	
	/**
	 * @return l'aire de la forme
	 */
	public abstract double getAire();
	/**
	 * @return la distance maximal entre deux point de la forme
	 */
	public abstract double getDistanceMax();
	/**
	 * @return la hauteur
	 */
	public abstract int getHeight();
	/**
	 * @return la largeur
	 */
	public abstract int getWidth();
	
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
	/**
	 * @return le code identifiant de la forme
	 */
	public int getID(){
		return this.nseq;
	}
	/**
	 * @return le nom de la forme
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @return la couleur de la forme
	 */
	public Color getColor(){
		return this.color;
	}
	/**
	 * @return la position x1
	 */
	public int getX1(){
		return this.x1;
	}
	/**
	 * @return la position x2
	 */
	public int getX2(){
		return this.x2;
	}
	/**
	 * @return la position x3
	 */
	public int getX3(){
		return this.x3;
	}
	/**
	 * @return la position x4
	 */
	public int getX4(){
		return this.x4;
	}
	public int getType(){
		return this.type;
	}
	
	/**
	 * @param i
	 */
	public void setX1(int i){
		this.x1 = i;
	}
    /**
     * @param i
     */
    public void setX2(int i){
    	this.x2 = i;
	}
    /**
     * @param i
     */
    public void setX3(int i){
    	this.x3 = i;
    }
    /**
     * @param i
     */
    public void setX4(int i){
    	this.x4 = i;
    }
    /**
     * @param t
     */
    public void setType(int t){
    	this.type = t;
    }
}