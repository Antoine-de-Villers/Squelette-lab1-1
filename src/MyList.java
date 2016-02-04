
public class MyList {
	protected Maillon first;
	protected Maillon last;
	protected int ListLength;
	protected boolean listEmpty = true;
	
    public MyList(){
	first = null;
	ListLength = 0;
}
    
    public void addItem(Object o){
    	ListLength++;
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
  
    	return maillonSearched;
    }
    
    public boolean isEmpty(){
    	if(first == null) {
    		listEmpty = false;
    	}  	
		return listEmpty; 	
    }
    
    public int getLength(){
    	return ListLength;
    }
}