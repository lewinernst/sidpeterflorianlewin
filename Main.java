import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("redundancy.in"));
		int height = sc.nextInt();
		int width = sc.nextInt();
		int drones = sc.nextInt();
		int turns = sc.nextInt();
		Drone.maxPayload = sc.nextInt();

		int types = sc.nextInt();
		int[] weights = new int[types];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = sc.nextInt();
		}

		Items items = new Items();
		items.weights = weights;

		List<Warehouse> warehousesList = new ArrayList<>();

		int warehouses = sc.nextInt();
		int[][] warehousecoordinates = new int[warehouses][2];
		int[][] stored = new int[warehouses][types];
		for (int i = 0; i < warehouses; i++) {
			Warehouse wh = new Warehouse();
			wh.x = sc.nextInt();
			wh.y = sc.nextInt();

			wh.storage = new int[types];
			for (int j = 0; j < types; j++) {
				wh.storage[j] = sc.nextInt();
			}
		}

		int numOrders = sc.nextInt();
		List<Order> orderList = new ArrayList<>();

		for (int i = 0; i < numOrders; i++) {
			Order o = new Order(sc.nextInt(), sc.nextInt());
			int numItems = sc.nextInt();
			for (int j = 0; j < numItems; j++) {
				o.addItem(sc.nextInt());
			}
			orderList.add(o);
		}

		// Initialize simulation
		Simulation simulation = new Simulation();
		simulation.outstandingOrders.addAll(orderList);
		simulation.items = items;

		for (int j = 0; j < drones; j++) {
			Drone d = new Drone();
			simulation.availableDrones.add(d);
		}
	}
}
