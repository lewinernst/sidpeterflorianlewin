import java.util.HashMap;


public class Warehouse {

	public int id;
	public int x;
	public int y;
	
	public int[] storage;
	
	public boolean hasInStore(int itemId, int count) {
		return storage[itemId] >= count;
	}

	public void removeOrderedItems(Order obj) {
		HashMap<Integer, Integer> items = obj.items;

		for (Integer key : items.keySet()) {
			storage[key] = storage[key] - items.get(key);
		}
		
	}
}
