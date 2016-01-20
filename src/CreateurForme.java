import java.awt.Color;
import java.awt.Graphics;

public class CreateurForme {
	private String[] parts;
	private int nseq;
	private String name;
	private int x1;
	private int x2;
	private int x3;
	private int x4;
	
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
		nseq = Integer.parseInt(parts[0]);
		name = parts[1];
		x1= Integer.parseInt(parts[2]);
		x2= Integer.parseInt(parts[3]);
		x3= Integer.parseInt(parts[4]);
		try{
			x4= Integer.parseInt(parts[5]);
		}catch(Exception e){
			//C'est un cercle
		}
		Forme forme = create();
		return forme;
	}

	public Forme create(){
		Forme forme=null;
		switch(name){
		case "<RECTANGLE>" :
			forme = new Rectangle(nseq,name,x1,x2,x3,x4);
			break;
		case "<OVALE>" :
			forme = new Ovale(nseq,name,x1,x2,x3,x4);
			break;
		case "<CARRE>" :
			forme = new Carre(nseq,name,x1,x2,x3,x4);
			break;
		case "<CERCLE>" :
			forme = new Cercle(nseq,name,x1,x2,x3);
			break;
		case "<LIGNE>" :
			forme = new Ligne(nseq,name,x1,x2,x3,x4);
			break;
		}
		return forme;
	}

	
	
	
	public class Rectangle extends Forme{
	public Rectangle(int nseq,String name, int x1, int x2, int x3, int x4){
		super(nseq,name,x1,x2,x3,x4);
		color=new Color(12,24,32);
	}

	}
	
	public class Ovale extends Forme{
		
	public Ovale(int nseq,String name, int x1, int x2, int x3, int x4){
		super(nseq,name,x1,x2,x3,x4);
		color=new Color(34,34,32);
	}
	}
	public class Carre extends Forme{
		
		public Carre(int nseq,String name, int x1, int x2, int x3, int x4){
			super(nseq,name,x1,x2,x3,x4);
			color=new Color(0,0,0);
		}
		}
	public class Cercle extends Forme{
		
		public Cercle(int nseq,String name, int x1, int x2, int x3){
			super(nseq,name,x1,x2,x3);
			color=new Color(12,7,2);
		}
		}
	public class Ligne extends Forme{
		
		public Ligne(int nseq,String name, int x1, int x2, int x3, int x4){
			super(nseq,name,x1,x2,x3,x4);
			color=new Color(9,234,33);
		}
		}
}