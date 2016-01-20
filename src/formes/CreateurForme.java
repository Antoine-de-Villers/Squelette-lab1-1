package formes;
import java.awt.Graphics;

public class CreateurForme {
	private String[] parts;
	private int nseq;
	private String name;
	private int x1;
	private int x2;
	private int x3;
	private int x4;
	private Forme forme = null;
	
	/*
	* Constructeur
	*/
	public CreateurForme (){
	}
	
	public Forme splitInfo(String info){
		parts=info.split(" ");
		for(int i=0;i<parts.length;i++){
		System.out.println(parts[i]);
		}
		create();
		createForme();
		return forme;
	}
	
	public void create(){
		nseq = Integer.parseInt(parts[0]);
		name = parts[1];
		x1= Integer.parseInt(parts[2]);
		x2= Integer.parseInt(parts[3]);
		x3= Integer.parseInt(parts[4]);
		x4= Integer.parseInt(parts[5]);
	}
	
	public void createForme(){
		switch (name){
		case "CARRE":
			forme = new Rectangle(nseq,name,x1,x2,x3,x4);
			break;
		case "RECTANGLE":
			forme = new Rectangle(nseq,name,x1,x2,x3,x4);
			break;
		case "LIGNE":
			forme = new Ligne(nseq,name,x1,x2,x3,x4);
			break;
		case "OVALE":
			forme = new Ovale(nseq,name,x1,x2,x3,x4);
			break;
		case "Cercle":
			forme = new Cercle(nseq,name,x1,x2,x3);
			break;
		}
		
	}
}
