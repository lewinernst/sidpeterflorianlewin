import java.util.ArrayList;
import java.util.List;

public class Drone {
	public static int maxPayload;
	
	public int id;
	public int x;
	public int y;
	
	public List<Integer> loadedItems;
	
	public List<Order> outstandingOrders;
	
	public Drone() {
		loadedItems = new ArrayList<>();
		outstandingOrders = new ArrayList<>();
	}
}
