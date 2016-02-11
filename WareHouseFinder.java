import java.util.ArrayList;
import java.util.List;

//can find the nearest Warehouse based on target coordinates, availability of items
public class WareHouseFinder {
    private Warehouse[] W;
    
    public WareHouseFinder(int number, Warehouse[] W){
    	this.W = W;
    }
    
    private List<Warehouse> getList(int [] items, int [] numberNeeded){
    	List<Warehouse> returnList = new ArrayList<>();
        for (int i = 0; i <W.length; i++){
        	boolean viable = true;
            for (int j = 0; j< items.length; j++){
                if (!W[i].hasInStore(items[j], numberNeeded[j])){
                    viable=false;
                }
                if (viable) returnList.add(W[i]);
                viable = true;
            }
            
        }
        return returnList;
    }
   
    
    public Warehouse findNearest (int [] coordinates, int []items, int[] numberNeeded){
    	List<Warehouse> checkDistanceTo = getList(items,numberNeeded);
    	int currentmindistance = Integer.MAX_VALUE;
    	Warehouse currentlyClosest = new Warehouse();
    	for (int i = 0; i< checkDistanceTo.size();i++){
    		int cost =(int) Math.ceil(Math.sqrt((coordinates[0]-checkDistanceTo.get(i).x)^2 + (coordinates[1]-checkDistanceTo.get(i).y)^2));
    		if (currentmindistance < cost) {
    			currentlyClosest = checkDistanceTo.get(i);
    			currentmindistance = cost;
    		}
    		
    			
    			
    	}
    	return currentlyClosest;
    	
    }
}
