
public class MyList {
	protected Maillon first;
	protected Maillon last;
	protected int listLength;
	protected boolean listEmpty = true;
	
    public MyList(){
	first = null;
	listLength = 0;
}
    
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
 
    public boolean isEmpty(){
    	if(first == null) {
    		listEmpty = false;
    	}  	
		return listEmpty; 	
    }
    
    public int getLength(){
    	return listLength;
    }
    
    public void triAireCroissant(){
    	for(int i = 0; i < listLength - 1; i++){
    		int temp = i;
    		for(int j = i + 1; j < listLength - 1; j++){
    			if(((Forme) getItem(j)).getAire() < ((Forme) getItem(temp)).getAire()){
    			   getMaillon(temp).setObject(getItem(j));
    			   getMaillon(j).setObject(getItem(i));
    			   getMaillon(i).setObject(getItem(temp));
    			}
    		}
    	}
    }
}