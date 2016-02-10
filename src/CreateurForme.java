/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: CreateurForme.java
Date crÃ©Ã©: 2016-01-15
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Antoine de Villers
 *@author Étienne Rousseau
2016-01-15 Version initiale
 *******************************************************/  
import java.awt.Color;
import ca.etsmtl.log.util.IDLogger;

public class CreateurForme {
	private int nseq;
	private String name;
	private int x1;
	private int x2;
	private int x3;
	private int x4;
    private IDLogger logger = IDLogger.getInstance(); //Méthode statique
    private DecomposerChaine chaine = new DecomposerChaine();

	/**
	 * constructeur
	 */
	public CreateurForme (){

	}

	/**
	 * Crée une nouvelle forme. Cette méthode reçoit la chaîne de
	 * caractères provenant du serveur de formes, elle détermine de quelle
	 * forme il s'agit et applique l'opérateur new sur le constructeur de
	 * la forme désirée.
	 *
	 * @param info un objet String contenant la chaîne de caractères
	 *                    qui décrit une forme et provenant du serveur de
	 *                    formes.
	 *
	 * @return une instance d'une des sous-classes de la classe abstraite
	 *         Forme avec les paramètres passés par la chaîne d'entrée.
	 */
	public Forme splitInfo(String info){
		
        chaine.Split(info);
		
		
		nseq = chaine.getNSEQ();
		name = chaine.getName();
		x1= chaine.getX1();
		x2= chaine.getX2();
		x3= chaine.getX3();

		
		
		try{
			x4= chaine.getX4();
		}catch(Exception e){
			//C'est un cercle
		}
		Forme forme = create();
		
		logger.logID(forme.getID());
		return forme;
	}

	/**
	 * Crée les objet forme selon les infos envoyé par le serveur
	 * @return la forme en question
	 */
	public Forme create(){
		Forme forme = null;
		
		if(name.equals("RECTANGLE")){
			forme = new Rectangle(nseq,name,x1,x2,x3,x4);
			forme.setType(2);
		}
		
		if(name.equals("OVALE")){
			forme = new Ovale(nseq,name,x1,x2,x3,x4);
			forme.setType(4);
		}
		
		if(name.equals("CARRE")){
			forme = new Carre(nseq,name,x1,x2,x3,x4);
			forme.setType(1);
		}
		
		if(name.equals("CERCLE")){
			forme = new Cercle(nseq,name,x1,x2,x3);
			forme.setType(3);
		}
		
		if(name.equals("LIGNE")){
			forme = new Ligne(nseq,name,x1,x2,x3,x4);
			forme.setType(5);
		}
		return forme;
	}




	/**
	 * Classe rectangle
	 * @author Etienne
	 * @author Antoine
	 *
	 */
	public class Rectangle extends Forme{
		/**
		 * Constructeur
		 * @param nseq
		 * @param name
		 * @param x1
		 * @param x2
		 * @param x3
		 * @param x4
		 */
		public Rectangle(int nseq,String name, int x1, int x2, int x3, int x4){
			super(nseq,name,x1,x2,x3,x4);
			color=new Color(112,222,232,128);
		}

		@Override
		public double getAire() {		
			aire = height*width;
			return aire;
		}

		@Override
		public double getDistanceMax() {
			distanceMax = Math.sqrt(((Math.pow(height,2)) + (Math.pow(width,2))));
			return distanceMax;
		}

		@Override
		public int getHeight() {
			height = x2 - x4;
			height = Math.abs(height);
			return height;
		}

		@Override
		public int getWidth() {
			width = x3 - x1;
			width = Math.abs(width);
			return width;
		}

	}

	/**
	 * Classe ovale
	 * @author Etienne
	 * @author Antoine
	 */
	public class Ovale extends Forme{

		/**
		 * Constructeur
		 * @param nseq
		 * @param name
		 * @param x1
		 * @param x2
		 * @param x3
		 * @param x4
		 */
		public Ovale(int nseq,String name, int x1, int x2, int x3, int x4){
			super(nseq,name,x1,x2,x3,x4);
			color=new Color(222,34,32,128);
		}

		@Override
		public double getAire() {
			aire = x4*x3*Math.PI;
			return aire;		
		}

		@Override
		public double getDistanceMax() {
			if((x3) > (x4)){
				distanceMax = x3;
			}
			else distanceMax = x4;
			return distanceMax;
		}

		@Override
		public int getHeight() {
			height = x4 * 2;
			return height;
		}

		@Override
		public int getWidth() {
			width = x3 * 2;
			return width;
		}
	}
	/**
	 * Classe carre
	 * @author Etienne
	 * @author Antoine
	 *
	 */
	public class Carre extends Forme{

		/**
		 * Constructeur
		 * @param nseq
		 * @param name
		 * @param x1
		 * @param x2
		 * @param x3
		 * @param x4
		 */
		public Carre(int nseq,String name, int x1, int x2, int x3, int x4){
			super(nseq,name,x1,x2,x3,x4);
			color=new Color(255,0,255,128);
		}

		@Override
		public double getAire() {			
			aire = height*width;
			return aire;
		}

		@Override
		public double getDistanceMax() {
			distanceMax = Math.sqrt(((Math.pow(height,2)) + (Math.pow(width,2))));
			return distanceMax;
		}

		@Override
		public int getHeight() {
			height = x2 - x4;
			height = Math.abs(height);
			return height;
		}

		@Override
		public int getWidth() {
			width = x3 - x1;
			width = Math.abs(width);
			return width;
		}
	}
	/**
	 * Classe cercle
	 * @author Etienne
	 * @author Antoine
	 *
	 */
	public class Cercle extends Forme{

		/**
		 * Constructeur
		 * @param nseq
		 * @param name
		 * @param x1
		 * @param x2
		 * @param x3
		 */
		public Cercle(int nseq,String name, int x1, int x2, int x3){
			super(nseq,name,x1,x2,x3);
			color=new Color(12,7,255,128);
		}

		@Override
		public double getAire() {
			aire = Math.abs(x3*x3)*Math.PI;
			return aire;
		}

		@Override
		public double getDistanceMax() {
			distanceMax = x3*2;
			return distanceMax;
		}

		@Override
		public int getHeight() {
			height = x3 * 2;
			return height;
		}

		@Override
		public int getWidth() {
			width = x3 * 2;
			return width;
		}
	}
	/**
	 * Classe ligne
	 * @author Etienne
	 * @author Antoine
	 *
	 */
	public class Ligne extends Forme{

		/**
		 * Constructeur
		 * @param nseq
		 * @param name
		 * @param x1
		 * @param x2
		 * @param x3
		 * @param x4
		 */
		public Ligne(int nseq,String name, int x1, int x2, int x3, int x4){
			super(nseq,name,x1,x2,x3,x4);
			color=new Color(9,234,33,128);
		}

		@Override
		public double getAire() {		
			aire = Math.sqrt(((Math.pow(height,2)) + (Math.pow(width,2))));
			return aire;
		}

		@Override
		public double getDistanceMax() {
			distanceMax = Math.sqrt(((Math.pow(height,2)) + (Math.pow(width,2))));
			return distanceMax;
		}

		@Override
		public int getHeight() {
			height = x2 - x4;
			height = Math.abs(height);
			return height;
		}

		@Override
		public int getWidth() {
			width = x3 - x1;
			width = Math.abs(width);
			return width;
		}
	}
}