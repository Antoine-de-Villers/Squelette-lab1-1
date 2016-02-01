
public class MyList {
	protected Maillon first;
	protected Maillon last;
	protected int ListLength = 0;
	protected boolean listEmpty = true;
	
    public MyList(){
	first = null;
}
    
    public void addItem(Object o){
    	ListLength++;
    	Maillon m = new Maillon(o, null, ListLength-1);
    	if(first == null){
    		first = m;
    	}
    	else if(first != null){
    		last.next = m;
    	}
    	last = m;   	
    }
    
    public Object getItem(int ind){
    	Maillon checkIndex = first;
    	boolean done = false;
    	int countToIndex = 0;
    	
    	  while(!done){
    		  if(countToIndex == ind){
      			done = true;
      		}
      		if(!done){
      			checkIndex = checkIndex.next;
          		countToIndex++;
      		}
    	  }    		    		   	
		return checkIndex;
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