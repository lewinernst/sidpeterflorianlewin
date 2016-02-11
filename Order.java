import java.util.HashMap;
import java.util.List;

public class Order {
	public int x;
	public int y;
	
	public HashMap<Integer, Integer> items;
	
	
	public Order(int x, int y) {
		this.x = x;
		this.y = y;
		
		items = new HashMap<>();
	}

	public void addItem(int itemId) {		
		items.put(itemId, items.getOrDefault(itemId, 0) + 1);
	}
}
