import java.util.Map;

public class Action {
	public static int LOAD = 0;
	public static int DELIVER = 1;
	
	public Action(Drone drone, Warehouse warehouse, Order order, int time) {
		this.time = time + Util.distance(drone.x, drone.y, warehouse.x, warehouse.y) + order.items.size();
		this.makeAvailable = drone;
		this.warehouse = warehouse;
		this.order = order;
		this.type = LOAD;
	}

	public Action(Drone drone, Order order, int time) {
		this.time = time + Util.distance(drone.x, drone.y, order.x, order.y) + order.items.size();
		this.makeAvailable = drone;
		this.order = order;
		this.type = DELIVER;
	}

	public Action(Drone drone, int time) {
		this.time = time + Simulation.MAX_ROUNDS;
	}

	public String toString() {
		// LOAD
		String res = makeAvailable.id;
		if (this.type == LOAD) {
			for (Map.Entry<Integer, Integer> entry : order.items.entrySet()) {
				res += res + " L " + this.warehouse.id + " " + entry.getKey() + " " + entry.getValue() + "\n";
			}
		}
		else {
			for (Map.Entry<Integer, Integer> entry : order.items.entrySet()) {
				res += res + " L " + this.order.id + " " + entry.getKey() + " " + entry.getValue() + "\n";
			}
		}
		return res;
	}
	
	public int type;
	
	public int time;
	
	public Drone makeAvailable;
	public Order order;
	public Warehouse warehouse;
	
	
}
