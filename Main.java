import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new File("redundancy.in"));
	  int height = sc.nextInt();
	  int width = sc.nextInt();
	  int drones = sc.nextInt();
	  int turns = sc.nextInt();
	  int maxpayload = sc.nextInt();
	  
	  int types = sc.nextInt();
	  int [] weights = new int [types];
	  for (int i=0; i<weights.length; i++){
		  weights[i]=sc.nextInt();
	  }
	  
	  int warehouses = sc.nextInt();
	  int [][] warehousecoordinates = new int [warehouses][2];
	  int [][] stored = new int [warehouses][types];
	  for (int i = 0; i<warehouses; i++){
		  warehousecoordinates[i][0] = sc.nextInt();
		  warehousecoordinates[i][1] = sc.nextInt();
		  for (int j=0; j<types; j++){
			  stored[i][j] = sc.nextInt();
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
		  Order o = new Order();
		  o.x = sc.nextInt();
		  o.y = sc.nextInt();
		  o.items = new ArrayList<>();
		  int numItems = sc.nextInt();
		  
		  for (int j=0; j<numItems; j++){
			  o.items.add(sc.nextInt());
		  }
		  orderList.add(o);

	  }
	}
}
