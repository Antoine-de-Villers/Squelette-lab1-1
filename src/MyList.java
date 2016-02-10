public class MyList {
	protected Maillon first;
	protected Maillon last;
	protected int listLength;
	protected boolean listEmpty = true;
	
    /**
     * Constructeur
     */
    public MyList(){
	first = null;
	listLength = 0;
}
    
    /**
     * Ajoute un item a la liste
     * @param o est l'objet que lon veut ajouter
     */
    public void addItem(Object o){
    	listLength++;
    	Maillon m = new Maillon(o, null);
    	if(first == null){
    		first = m;
    	}
    	else if(first != null){
    		last.next = m;
    	}
    	last = m;   	
    }
    
    /**
     * Méthode qui retourne l'item selon sa position dans la liste
     * @param ind
     * @return l'item recherche
     */
    public Object getItem(int ind){
    	int count = 0;
    	Boolean done = false;
    	Maillon maillonSearched;
    	maillonSearched = first;
    	while(!done){
    		if(count == ind){
        		done=true;
        	}
    		else if(maillonSearched.next == null){
    			done = true;
    			maillonSearched = null;
    		}
        	else{
        		maillonSearched = maillonSearched.next;
        		count++;
        	}
    	}
       return maillonSearched.getObjet();
    }
    
    /**
     * Méthode qui retourne le maillon selon sa position dans la liste
     * @param ind
     * @return le maillon recherche
     */
    public Maillon getMaillon(int ind){
    	int count = 0;
    	Boolean done = false;
    	Maillon maillonSearched;
    	maillonSearched = first;
    	while(!done){
    		if(count == ind){
        		done=true;
        	}
    		else if(maillonSearched.next == null){
    			done = true;
    			maillonSearched = null;
    		}
        	else{
        		maillonSearched = maillonSearched.next;
        		count++;
        	}
    	}
       return maillonSearched;
    }
 
    /**
     * Vérifie si la liste est vide
     * @return vrai si la liste est vide
     */
    public boolean isEmpty(){
    	if(first == null) {
    		listEmpty = false;
    	}  	
		return listEmpty; 	
    }
    
    /**
     * Méthode qui retourne la longueur de la liste
     * @return la longueur de la liste
     */
    public int getLength(){
    	return listLength;
    }
    
    /**
     * Tri en ordre croissant selon le nseq
     */
    public void triCroissant(){
    	for(int i = listLength-1; i>0;i--){
    		for(int j=i;j>=0;j--){
    			if(((Forme) getItem(i)).getID() > ((Forme)getItem(j)).getID()){
        			Object temp = getItem(i);
        			(getMaillon(i)).setObject(getItem(j));
        			(getMaillon(j)).setObject(temp);
        		}
    		}
    		
    	}
    	for(int i = 0; i < listLength; i++){
    		System.out.println(((Forme)getItem(i)).getID());
    		System.out.println(((Forme)getItem(i)).getName());
    	}
    }
    
    /**
     * Tri en ordre croissant selon la distance maximal entre deux points de la forme
     */
    public void triDistanceMax(){
    	for(int i = listLength-1; i>0;i--){
    		for(int j=i;j>=0;j--){
    			if(((Forme) getItem(i)).getDistanceMax() > ((Forme) getItem(j)).getDistanceMax()){
    			   Object temp=getItem(i);
    			   getMaillon(i).setObject(getItem(j));
    			   getMaillon(j).setObject(temp);
    			}
    		}
    	}
    }
    
    /**
     * Tri en ordre croissant selon le type de forme
     */
    public void triType(){
    	for(int i = listLength-1; i>0;i--){
    		for(int j=i;j>=0;j--){
    			if(((Forme) getItem(i)).getType() > ((Forme) getItem(j)).getType()){
    			   Object temp=getItem(i);
    			   getMaillon(i).setObject(getItem(j));
    			   getMaillon(j).setObject(temp);
    			}
    		}   		
    	}
    	for(int i = 0; i < listLength; i++){
    		System.out.println(((Forme)getItem(i)).getType());
    	}
    }
    
    /**
     * Tri en ordre croissant selon l'aire de la forme
     */
    public void triAireCroissant(){
    	for(int i = listLength-1; i>0;i--){
    		for(int j=i;j>=0;j--){
    			if(((Forme) getItem(i)).getAire() > ((Forme) getItem(j)).getAire()){
    			   Object temp=getItem(i);
    			   getMaillon(i).setObject(getItem(j));
    			   getMaillon(j).setObject(temp);
    			}
    		}
    	}
    	
    	for(int i = 0; i < listLength; i++){
    		System.out.println(((Forme)getItem(i)).getAire());
    	}
    	
    }
    
    /**
     * Inverse les éléments de la liste
     */
    public void triInverse(){

    	int i = 0;
    	int j = listLength;
    	while (i!=j){
    		Object temp = getItem(j-1);
			getMaillon(j-1).setObject(getItem(i));
			getMaillon(i).setObject(temp);
			i++;
			j--;
    	}
    }
}