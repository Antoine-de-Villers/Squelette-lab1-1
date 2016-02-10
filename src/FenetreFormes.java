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
2016-01-28 Version finale
 *******************************************************/  

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JComponent;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @author Antoine
 * @author Etienne
 * @date 2016/26/01
 * @author AM30890
 * @author AM93710
 *
 */
public class FenetreFormes extends JComponent{

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	public CreateurForme createur;
	private int x,y = 0;
	private boolean origine;
	private Forme forme = null;
	private MyList listFormes = new MyList();


	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		createur = new CreateurForme();
	}


	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		for(int i=listFormes.getLength()-1;i>=0;i--){
			if(listFormes.getItem(i) instanceof Forme && listFormes.getItem(i) != null){
				if (origine){
					x=((Forme)listFormes.getItem(i)).getX1();
					y=((Forme)listFormes.getItem(i)).getX2();
				}
				switch(((Forme)listFormes.getItem(i)).getName()){
				case "RECTANGLE" :
					paintRectangle(g,i);
					break;
				case "OVALE" :
					paintOvale(g,i);
					break;
				case "CARRE" :
					paintCarre(g,i);
					break;
				case "CERCLE" :
					paintCercle(g,i);
					break;
				case "LIGNE" :
					paintLigne(g,i);
					break;
				}
				paintPointille((Graphics2D)g,i);
			}
		}
		x=1;
		y=1;
	}

	public void paintPointille(Graphics2D g1, int i){
		Graphics2D g = (Graphics2D) g1.create();
		float dash1[] = {10.0f};
		BasicStroke pointille = new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, dash1, 0.0f);
		g.setStroke(pointille);
		g.setColor(Color.BLACK);
		g.drawRect(x-1, y-1,((Forme)listFormes.getItem(i)).getWidth()+2 , ((Forme)listFormes.getItem(i)).getHeight()+2);
		if(!origine){
				x+=40;
				y+=40;
		}
	}
	
	
	/**
	 * Paint un rectangle
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintRectangle(Graphics g,int i){
		int width = ((Forme)listFormes.getItem(i)).getWidth();
		int height = ((Forme)listFormes.getItem(i)).getHeight();
		g.setColor(Color.BLACK);
		g.drawRect(x,y,width,height);
		g.setColor(((Forme)listFormes.getItem(i)).getColor());
		g.fillRect(x,y,width,height);
		
	}
	
	/**
	 * Paint un ovale
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintOvale(Graphics g, int i){
		int width = ((Forme)listFormes.getItem(i)).getWidth();
		int height = ((Forme)listFormes.getItem(i)).getHeight();
		g.setColor(Color.BLACK);
		g.drawOval(x,y,width,height);
		g.setColor(((Forme)listFormes.getItem(i)).getColor());
		g.fillOval(x,y,width,height);
	}

	/**
	 * Paint un carr�
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintCarre(Graphics g, int i){
		int width = ((Forme)listFormes.getItem(i)).getWidth();
		int height = ((Forme)listFormes.getItem(i)).getHeight();
		g.setColor(Color.BLACK);
		g.drawRect(x,y,width,height);
		g.setColor(((Forme)listFormes.getItem(i)).getColor());
		g.fillRect(x,y,width,height);
	}

	/**
	 * Paint un cercle
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintCercle(Graphics g, int i){
		g.setColor(Color.BLACK);
		g.drawOval(x,y,((Forme)listFormes.getItem(i)).getWidth(),((Forme)listFormes.getItem(i)).getHeight());
		g.setColor(((Forme)listFormes.getItem(i)).getColor());
		g.fillOval(x,y,((Forme)listFormes.getItem(i)).getWidth(),((Forme)listFormes.getItem(i)).getHeight());
	}

	/**
	 * Paint une ligne
	 * @param g = Graphics
	 * @param i = l'index du tableau
	 */
	public void paintLigne(Graphics g, int i){
		g.setColor(((Forme)listFormes.getItem(i)).getColor());
		g.drawLine(x,y, x+((Forme)listFormes.getItem(i)).getWidth(),y+((Forme)listFormes.getItem(i)).getHeight());
	}

	
	public void creerFormes(String info){
		if(listFormes.getLength()!=10){
		forme = createur.splitInfo(info);		
		listFormes.addItem(forme);
		}
		else{
			listFormes = new MyList();
			x=0;
			y=0;
			forme = createur.splitInfo(info);		
			listFormes.addItem(forme);
		}
		repaint();
	}
	
	public void tri(String type){
		switch(type){
		case "originel":
			origine = true;
			break;
		case "sequence Croissante":
			origine = false;
			listFormes.triCroissant();
			break;
		case "sequence Decroissante":
			origine = false;
			listFormes.triCroissant();
			listFormes.triInverse();
			break;
		case "aire Croissante":
			origine = false;
			listFormes.triAireCroissant();
			break;
		case "aire Decroissante":
			origine = false;
			listFormes.triAireCroissant();
			listFormes.triInverse();
			break;
		case "forme":
			origine = false;
			listFormes.triType();
			break;
		case "forme Inverse":
			origine = false;
			listFormes.triType();
			listFormes.triInverse();
			break;
		case "distance":
			origine = false;
			listFormes.triDistanceMax();
			break;
		default:
			origine = false;
			listFormes.triCroissant();
			break;
			
		}
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
