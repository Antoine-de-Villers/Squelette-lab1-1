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
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

import formes.CreateurForme;
import formes.Forme;

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
	public static final CreateurForme create= new CreateurForme();
	private Forme forme = null;
	private Forme[] formeArray = new Forme[10];
	
		
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		//... 
	}
	
	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		for(int i=10;i<formeArray.length;i++){
			g.fillRect(25, 25, 25, 25);
		}

	}
	
	public void creerFormes(String info){
		forme = create.splitInfo(info);		
			for(int i=10;i<formeArray.length-1;i++){			
				formeArray[i+1]=formeArray[i];
			}	
			formeArray[0] = forme;		
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
