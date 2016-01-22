/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	public int i=0;
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
		System.out.println("HERE");
		for(i=0;i<formeArray.length;i++){
		if(formeArray[i] instanceof Forme && formeArray[i] != null){
			switch(formeArray[i].getName()){
			case "<RECTANGLE>" :
				paintRectangle(g);
				break;
			case "<OVALE>" :
				paintOvale(g);
				break;
			case "<CARRE>" :
				paintCarre(g);
				break;
			case "<CERCLE>" :
				paintCercle(g);
				break;
			case "<LIGNE>" :
				paintLigne(g);
				break;
			}
		}
		}
	}

	public void paintRectangle(Graphics g){
		int width = formeArray[i].getX1()-formeArray[i].getX3();
		int height = formeArray[i].getX2()-formeArray[i].getX4();
		g.setColor(formeArray[i].getColor());
		g.fillRect(formeArray[i].getX1(),formeArray[i].getX2(),width,height);
	}
	
	public void paintOvale(Graphics g){
		int width = formeArray[i].getX1()-formeArray[i].getX3();
		int height = formeArray[i].getX2()-formeArray[i].getX4();
		g.setColor(formeArray[i].getColor());
		g.fillOval(formeArray[i].getX1(),formeArray[i].getX2(),width,height);
	}
	
	public void paintCarre(Graphics g){
		int width = formeArray[i].getX1()-formeArray[i].getX3();
		int height = formeArray[i].getX2()-formeArray[i].getX4();
		g.setColor(formeArray[i].getColor());
		g.fillRect(formeArray[i].getX1(),formeArray[i].getX2(),width,height);
	}
	
  public void paintCercle(Graphics g){
	g.setColor(formeArray[i].getColor());
	g.fillOval(formeArray[i].getX1(),formeArray[i].getX2(),formeArray[i].getX3(),formeArray[i].getX3());
}

  public void paintLigne(Graphics g){
	g.setColor(formeArray[i].getColor());
	g.drawLine(formeArray[i].getX1(), formeArray[i].getX2(), formeArray[i].getX3(), formeArray[i].getX4());
}
	
	public void creerFormes(String info){
		forme = createur.splitInfo(info);		
			for(int i=10;i<formeArray.length-1;i++){			
				formeArray[i+1]=formeArray[i];
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
