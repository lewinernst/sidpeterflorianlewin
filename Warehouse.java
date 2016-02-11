
public class Warehouse {

	public int x;
	public int y;
	
	public int[] storage;
	
	public boolean hasInStore(int itemId, int count) {
		return storage[itemId] >= count;
	}
}
