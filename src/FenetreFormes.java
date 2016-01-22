/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *@author Antoine de Villers
 *@author �tienne Rousseau
2016-01-22 Version finale
 *******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 * @author AM30890
 *
 */
public class FenetreFormes extends JComponent{

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	public CreateurForme createur;
	private Forme forme = null;
	private Forme[] formeArray = new Forme[10];


	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		createur = new CreateurForme();
		formeArray = new Forme[10];
	}


	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		for(int i=formeArray.length-1;i>=0;i--){
			if(formeArray[i] instanceof Forme && formeArray[i] != null){
				switch(formeArray[i].getName()){
				case "<RECTANGLE>" :
					paintRectangle(g,i);
					break;
				case "<OVALE>" :
					paintOvale(g,i);
					break;
				case "<CARRE>" :
					paintCarre(g,i);
					break;
				case "<CERCLE>" :
					paintCercle(g,i);
					break;
				case "<LIGNE>" :
					paintLigne(g,i);
					break;
				}
			}
		}
	}

	/**
	 * Paint un rectangle
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintRectangle(Graphics g,int i){
		int width = formeArray[i].getX1()-formeArray[i].getX3();
		int height = formeArray[i].getX2()-formeArray[i].getX4();
		g.setColor(formeArray[i].getColor());
		g.fillRect(formeArray[i].getX1(),formeArray[i].getX2(),width,height);
	}
	
	/**
	 * Paint un ovale
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintOvale(Graphics g, int i){
		int width = formeArray[i].getX3()*2;
		int height = formeArray[i].getX4()*2;
		g.setColor(formeArray[i].getColor());
		g.fillOval(formeArray[i].getX1(),formeArray[i].getX2(),width,height);
	}

	/**
	 * Paint un carr�
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintCarre(Graphics g, int i){
		int width = formeArray[i].getX1()-formeArray[i].getX3();
		int height = formeArray[i].getX2()-formeArray[i].getX4();
		g.setColor(formeArray[i].getColor());
		g.fillRect(formeArray[i].getX1(),formeArray[i].getX2(),width,height);
	}

	/**
	 * Paint un cercle
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintCercle(Graphics g, int i){
		g.setColor(formeArray[i].getColor());
		g.fillOval(formeArray[i].getX1(),formeArray[i].getX2(),formeArray[i].getX3(),formeArray[i].getX3());
	}

	/**
	 * Paint une ligne
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintLigne(Graphics g, int i){
		g.setColor(formeArray[i].getColor());
		g.drawLine(formeArray[i].getX1(), formeArray[i].getX2(), formeArray[i].getX3(), formeArray[i].getX4());
	}

	
	public void creerFormes(String info){
		forme = createur.splitInfo(info);		
		for(int i=formeArray.length-1;i>0;i--){			
			formeArray[i]=formeArray[i-1];
		}	
		formeArray[0] = forme;	
		repaint();
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
}
