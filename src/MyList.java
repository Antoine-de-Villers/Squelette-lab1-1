
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
    
    public void triCroissant(){
    	for(int i = listLength-1; i>1;i--){
    		for(int j=i;j>0;j--){
    			if(((Forme) getItem(i)).getID() < ((Forme)getItem(j)).getID()){
        			Object temp = getItem(i);
        			(getMaillon(i)).setObject(getItem(j));
        			(getMaillon(j)).setObject(temp);
        		}
    		}
    		
    	}
    	for(int i = 0; i < listLength; i++){
    		System.out.println(((Forme)getItem(i)).getID());
    	}
    }
    
    
    public void triAireCroissant(){
    	for(int i = 0; i < listLength - 1; i++){
    		for(int j = i + 1; j < listLength; j++){
    			if(((Forme) getItem(j)).getAire() < ((Forme) getItem(i)).getAire()){
    			   Object temp=getItem(j);
    			   getMaillon(j).setObject(getItem(i));
    			   getMaillon(i).setObject(temp);
    			}
    		}
    	}
    	
    	for(int i = 0; i < listLength; i++){
    		System.out.println(((Forme)getItem(i)).getAire());
    	}
    	
    }
}