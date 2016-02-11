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
	  Scanner sc = new Scanner(new File("redundancy.in"));
	  int height = sc.nextInt();
	  int width = sc.nextInt();
	  int drones = sc.nextInt();
	  int turns = sc.nextInt();
	  Drone.maxPayload = sc.nextInt();
	  
	  int types = sc.nextInt();
	  int [] weights = new int [types];
	  for (int i=0; i<weights.length; i++){
		  weights[i]=sc.nextInt();
	  }
	  
	  Items items = new Items();
	  items.weights = weights;
	  
	  List<Warehouse> warehousesList = new ArrayList<>();
	  
	  int warehouses = sc.nextInt();
	  int [][] warehousecoordinates = new int [warehouses][2];
	  int [][] stored = new int [warehouses][types];
	  for (int i = 0; i<warehouses; i++){
		  /*
		  warehousecoordinates[i][0] = sc.nextInt();
		  warehousecoordinates[i][1] = sc.nextInt();
		  for (int j=0; j<types; j++){
			  stored[i][j] = sc.nextInt();
		  }
		  */
		  
		  Warehouse wh = new Warehouse();
		  wh.x = sc.nextInt();
		  wh.y = sc.nextInt();
		  
		  wh.storage = new int[types];
		  for (int j=0; j<types; j++){
			  wh.storage[j] = sc.nextInt();
		  }
	  }
	  
	  /*
	  int orders = sc.nextInt();
	  int[][] ordercoordinates = new int [orders][2];
	  int[] ordernumbers = new int [orders];
	  int[][] itemsinorder = new int [orders][types];
	  */
	  
	  int numOrders = sc.nextInt();
	  List<Order> orderList = new ArrayList<>();
	  
	  for (int i=0; i< numOrders; i++ ){
		  /*
		  ordercoordinates[i][0] = sc.nextInt();
		  ordercoordinates[i][1] = sc.nextInt();
		  ordernumbers[i] = sc.nextInt();
		  for (int j=0; j<ordernumbers[i]; j++){
			  itemsinorder[i][sc.nextInt()] = 1;
		  }
		  */
		  Order o = new Order(sc.nextInt(), sc.nextInt());
		  int numItems = sc.nextInt();
		  for (int j=0; j<numItems; j++){
			  o.addItem(sc.nextInt());
		  }
		  orderList.add(o);
	  }
	  
	  
	  // Initialize simulation
	  Simulation simulation = new Simulation();
	  simulation.outstandingOrders = orderList;
	  simulation.items = items;
	  simulation.availableDrones = new ArrayList<Drone>();
	  
	  for (int j=0; j < drones; j++) {
		  Drone d = new Drone();
		  // TODO set initial drone position
		  simulation.availableDrones.add(d);
	  }
	}
}
