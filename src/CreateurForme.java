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
	
	public void splitInfo(String info){
		parts=info.split(" ");
		for(int i=0;i<parts.length;i++){
		System.out.println(parts[i]);
		}
	}
	public void create(){
		nseq = Integer.parseInt(parts[0]);
		name = parts[1];
		x1= Integer.parseInt(parts[2]);
		x2= Integer.parseInt(parts[3]);
		x3= Integer.parseInt(parts[4]);
		x4= Integer.parseInt(parts[5]);
	}
}
