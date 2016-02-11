import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Simulation {
	public static int MAX_ROUNDS;
	
	public PrintStream out = System.out;
	
	public List<Order> outstandingOrders;
	
	public List<Drone> availableDrones = new LinkedList<Drone>();
	
	public List<Drone> workingDrones;
	
	public List<Warehouse> warehouses;
	
	public Items items;
	
	public HashMap<Integer, List<Action>> actions;

	public Order findOrder() {
		Warehouse first = warehouses.get(0);
		
		for (Order o: outstandingOrders) {
			if (Drone.maxPayload < o.getWeight()) {
				continue;
			}

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
	
	public void scheduleDrones(int time) {
		Iterator<Drone> iter = availableDrones.iterator();
		while(iter.hasNext()) {
			Drone drone = iter.next();
			
			Order order = findOrder();
			Warehouse warehouse = findWarehouse(order, drone);
			
			Action load = new Action(drone, warehouse, time);
			Action deliver = new Action(drone, order, time);
			deliver.makeAvailable = drone;
			
			if(!actions.containsKey(load.time)) {
				actions.put(load.time, new ArrayList<Action>());
			}
			actions.get(load.time).add(load);
			
			if(!actions.containsKey(deliver.time)) {
				actions.put(deliver.time, new ArrayList<Action>());
			}
			actions.get(deliver.time).add(deliver);
			
			fixProductCount(order, warehouse);
			
			//TODO check if drone can do something
			
			// remove current drone
			iter.remove();
		}
		
		availableDrones.removeAll(workingDrones);
	}
	
	public void performActions(int time) {
		for(Action action : actions.get(time)) {
			out.println(action);
			if(action.makeAvailable != null) {
				availableDrones.add(action.makeAvailable);
			}
		}
	}

	public void run() {
		for (int i=0; i < MAX_ROUNDS; i++) {
			performActions(i);
			scheduleDrones(i);
		}
	}
}
