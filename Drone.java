import java.util.ArrayList;
import java.util.List;

public class Drone {
	public static int maxPayload;
	
	public int x;
	public int y;
	
	public List<Integer> loadedItems;
	
	public Drone() {
		loadedItems = new ArrayList<>();
	}
}
