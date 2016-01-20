package formes;

import java.awt.Color;

public class Ligne extends Forme{
	public Ligne(int nseq, String nom, int x1, int x2, int x3, int x4){
		super(nseq,nom,x1,x2,x3,x4);
		this.color=new Color(10,10,10);
	}
}