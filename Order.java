import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
	public int x;
	public int y;
	public int id;
	
	public HashMap<Integer, Integer> items;
	
	
	public Order(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
		
		items = new HashMap<>();
	}

	public void addItem(int itemId) {		
		items.put(itemId, items.getOrDefault(itemId, 0) + 1);
	}
	
	public int getWeight() {
		int w = 0;
		for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
			w += Items.getWeight(entry.getKey()) * entry.getValue();
		}
		return w;
	}
}
