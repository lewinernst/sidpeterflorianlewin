import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//can find the nearest Warehouse based on target coordinates, availability of items
public class WareHouseFinder {
    
    public static List<Warehouse> getList(List<Warehouse> warehouses, HashMap<Integer,Integer> items){
    	List<Warehouse> returnList = new ArrayList<>();
    	for(Warehouse wh : warehouses) {
        	boolean viable = true;
        	for(Entry<Integer,Integer> item : items.entrySet()) {
                if (!wh.hasInStore(item.getKey(), item.getValue())){
                    viable=false;
                }
                if (viable) returnList.add(wh);
                viable = true;
            }
            
        }
        return returnList;
    }
   
    
    public static Warehouse findNearest (List<Warehouse> warehouses, Order order){
    	List<Warehouse> checkDistanceTo = getList(warehouses, order.items);
    	int currentmindistance = Integer.MAX_VALUE;
    	Warehouse currentlyClosest = new Warehouse();
    	for (int i = 0; i< checkDistanceTo.size();i++){
    		int cost =(int) Math.ceil(Math.sqrt((order.x-checkDistanceTo.get(i).x)^2 + (order.y-checkDistanceTo.get(i).y)^2));
    		if (currentmindistance < cost) {
    			currentlyClosest = checkDistanceTo.get(i);
    			currentmindistance = cost;
    		}
    	}
    	return currentlyClosest;
    }
}
