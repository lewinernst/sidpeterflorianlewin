import java.util.ArrayList;
import java.util.List;

public class Drone {
	public static int payload;
	
	public int x;
	public int y;
	
	public List<Integer> loadedItems;
	
	public Drone() {
		loadedItems = new ArrayList<>();
	}
}
