import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Simulation {
	public static int MAX_ROUNDS;
	
	public PrintStream out = null;
	
    public Simulation(PrintStream out) throws FileNotFoundException {
		this.out = out;
	}
	
	public List<Order> outstandingOrders = new LinkedList<Order>();
	
	public List<Drone> availableDrones = new LinkedList<Drone>();
	
	public List<Warehouse> warehouses = new ArrayList<Warehouse>();
	
	public Items items;
	
	public HashMap<Integer, List<Action>> actions = new HashMap<Integer, List<Action>>();

	public Order findOrder() {
		Warehouse first = warehouses.get(0);
		
		Iterator<Order> iter = outstandingOrders.iterator();
		while(iter.hasNext()) {
			Order o = iter.next();
			
			if (Drone.maxPayload < o.getWeight()) {
				iter.remove();
				continue;
			}

			boolean allOk = true;
			for (Map.Entry<Integer, Integer> entry : o.items.entrySet()) {
				if (!first.hasInStore(entry.getKey(), entry.getValue())) {
					allOk = false;
				}
			}
			if (allOk) {
				iter.remove();
				return o;
			}
		}
		return null;
	}

	public Warehouse findWarehouse(Order order, Drone drone) {
		return WareHouseFinder.findNearest(warehouses, order);
	}
	
	public void scheduleDrones(int time) {
		Iterator<Drone> iter = availableDrones.iterator();
		while(iter.hasNext()) {
			Drone drone = iter.next();
			
			Order order = findOrder();
			Warehouse warehouse = warehouses.get(0);//findWarehouse(order, drone);
			if(order == null || warehouse == null) {
				Action wait = new Action(drone, time);
				actions.getOrDefault(wait.time, new ArrayList<Action>()).add(wait);
				iter.remove();
				continue;
			}
			
			Action load = new Action(drone, warehouse, order, time);
			Action deliver = new Action(drone, order, load.time);
			
			if(!actions.containsKey(load.time)) {
				actions.put(load.time, new ArrayList<Action>());
			}
			actions.get(load.time).add(load);
			
			if(!actions.containsKey(deliver.time)) {
				actions.put(deliver.time, new ArrayList<Action>());
			}
			actions.get(deliver.time).add(deliver);
			
			warehouse.removeOrderedItems(order);
			
			//TODO check if drone can do something
			
			
			// remove current drone
			iter.remove();
		}
	}

	private int num = 0;
	private StringBuilder sb = new StringBuilder();
	public void performActions(int time) {
		
		for(Action action : actions.getOrDefault(time,new ArrayList<>())) {
			sb.append(action);
			num++;
			if(action.makeAvailable != null) {
				availableDrones.add(action.makeAvailable);
			}
		}
		actions.remove(time);
	}

	public void run() {
		for (int i=0; i < MAX_ROUNDS; i++) {
			System.out.println(i);
			performActions(i);
			scheduleDrones(i);
		}
		out.println(num);
		out.print(sb.toString());
	}
}
