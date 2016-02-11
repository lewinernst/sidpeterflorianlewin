import java.util.List;
import java.util.Map;

public class Simulation {
	public static int MAX_ROUNDS;
	
	public List<Order> outstandingOrders;
	
	public List<Drone> availableDrones;
	
	public List<Drone> workingDrones;
	
	public List<Warehouse> warehouses;
	
	public Items items;

	public Order findOrder() {
		Warehouse first = warehouses.get(0);
		
		for (Order o: outstandingOrders) {
			boolean allOk = true;
			for (Map.Entry<Integer, Integer> entry : o.items.entrySet()) {
				if (!first.hasInStore(entry.getKey(), entry.getValue())) {
					allOk = false;
				}
			}
			if (allOk) {
				return o;
			}
		}
		return null;
	}
	
	public void scheduleDrones() {
		for (Drone d : availableDrones) {
			Order order = findOrder();
			d.outstandingOrders.add(order);
			outstandingOrders.remove(order);
			workingDrones.add(d);
		}
		
		availableDrones.removeAll(workingDrones);
	}

	public void run() {
		for (int i=0; i < MAX_ROUNDS; i++) {
			scheduleDrones();			
		}
	}
}
