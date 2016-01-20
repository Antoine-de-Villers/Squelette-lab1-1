package formes;
import java.awt.Color;

public abstract class Forme{
    protected Color color;
	protected int nseq;
	protected String nom;
	protected int x1;
	protected int x2;
	protected int x3;
	protected int x4;
	
	
	/**
	 * Constructeur formes sauf cercle
	 */
	public Forme(int nseq, String nom, int x1, int x2, int x3, int x4){
		this.nseq=nseq;
		this.nom=nom;
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
		this.x4=x4;
	}
	/**
	 * Constructeur du cercle
	 */
	public Forme(int nseq, String nom, int x1, int x2, int x3){
		this.nseq=nseq;
		this.nom=nom;
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
	}	
}

	
	
	

	
	