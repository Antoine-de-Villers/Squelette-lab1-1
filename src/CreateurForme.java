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
	/*
	 * Constructeur
	 */
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
	/**
	 * Appelle la méthode de la classe DecomposerChaine pour obtenir les différentes infos sur la forme
	 * @param info
	 * @return la forme en question
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
			
		}
		
		if(name.equals("OVALE")){
			forme = new Ovale(nseq,name,x1,x2,x3,x4);
		}
		
		if(name.equals("CARRE")){
			forme = new Carre(nseq,name,x1,x2,x3,x4);
		}
		
		if(name.equals("CERCLE")){
			forme = new Cercle(nseq,name,x1,x2,x3);
		}
		
		if(name.equals("LIGNE")){
			forme = new Ligne(nseq,name,x1,x2,x3,x4);
		}
		return forme;
	}




	/**
	 * Classe rectangle
	 * @author Etienne
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
			color=new Color(112,222,232);
		}

	}

	/**
	 * Classe ovale
	 * @author Etienne
	 *
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
			color=new Color(222,34,32);
		}
	}
	/**
	 * Classe carre
	 * @author Etienne
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
			color=new Color(0,0,0);
		}
	}
	/**
	 * Classe cercle
	 * @author Etienne
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
			color=new Color(12,7,255);
		}
	}
	/**
	 * Classe ligne
	 * @author Etienne
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
			color=new Color(9,234,33);
		}
	}
}