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

import java.awt.Color;
import java.awt.Container;
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
	public Forme[] formes;
	public Forme forme= null;
	public int i=0;
	public CreateurForme createur;

	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		createur = new CreateurForme();
		formes = new Forme[10];
	}


	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		System.out.println("HERRE");
		if(forme instanceof Forme){
			int width = forme.getX1()-forme.getX3();
			int height = forme.getX2()-forme.getX4();
			g.setColor(forme.getColor());
			g.fillRect(forme.getX1(),forme.getX2(),width,height);
		}
	}


	public void setForme(String info){
		forme = createur.splitInfo(info);
		formes[i]=forme;
		i++;
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
