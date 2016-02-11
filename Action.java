
public class Action {
	public Action(Drone drone, Warehouse warehouse, int time) {
		this.time = time + Util.distance(drone.x, drone.y, warehouse.x, warehouse.y);
	}

	public Action(Drone drone, Order order, int time) {
		this.time = time + Util.distance(drone.x, drone.y, order.x, order.y);
		this.makeAvailable = drone;
	}

	public int time;
	
	public Drone makeAvailable;
}
