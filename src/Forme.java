/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: Forme.java
Date créé: 2016-01-15
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Antoine de Villers
 *@author �tienne Rousseau
2016-01-15 Version initiale
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
}