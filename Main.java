import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "redundancy";
		
		PrintStream out = new PrintStream(new File(filename + ".out"));
		Simulation simulation = new Simulation(out);

		Scanner sc = new Scanner(new File(filename + ".in"));
		int height = sc.nextInt();
		int width = sc.nextInt();
		int drones = sc.nextInt();
		Simulation.MAX_ROUNDS = sc.nextInt();
		Drone.maxPayload = sc.nextInt();

		int types = sc.nextInt();
		int[] weights = new int[types];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = sc.nextInt();
		}

		Items items = new Items();
		items.weights = weights;

		int warehouses = sc.nextInt();
		for (int i = 0; i < warehouses; i++) {
			Warehouse wh = new Warehouse();
			wh.x = sc.nextInt();
			wh.y = sc.nextInt();
			wh.id = i;

			wh.storage = new int[types];
			for (int j = 0; j < types; j++) {
				wh.storage[j] = sc.nextInt();
			}
			simulation.warehouses.add(wh);
		}

		int numOrders = sc.nextInt();
		List<Order> orderList = new ArrayList<>();

		for (int i = 0; i < numOrders; i++) {
			Order o = new Order(i, sc.nextInt(), sc.nextInt());
			int numItems = sc.nextInt();
			for (int j = 0; j < numItems; j++) {
				o.addItem(sc.nextInt());
			}
			orderList.add(o);
		}

		// Initialize simulation
		simulation.outstandingOrders.addAll(orderList);
		simulation.items = items;

		for (int j = 0; j < drones; j++) {
			Drone d = new Drone();
			d.id = j;
			simulation.availableDrones.add(d);
		}
		
		simulation.run();
	}
}
