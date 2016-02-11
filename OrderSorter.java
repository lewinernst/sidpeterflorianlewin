import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


public class OrderSorter {
	/*public static void OrderSorter(List<Order> orders, List<Warehouse> warehouses) {
		Iterator<Order> iter = orders.iterator();
		while(iter.hasNext()) {
			Order order = iter.next();
			
			if(order.items.isEmpty()) {
				order.cost = 0;
				iter.remove();
			}
			
			for(Warehouse warehouse : warehouses) {
				if(canFulfill(order, warehouse)) {
					int cost = (int) Math.ceil(Math.sqrt((order.x-warehouse.x)^2 + (order.y-warehouse.y)^2));
					order.cost = Math.min(cost, order.cost);
				}
			}
		}
		
		Collections.sort(orders, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				return Integer.compare(o1.score, o2.score);
			}
		});
	}
	
	public static boolean canFulfill(Order order, Warehouse warehouse) {
		if(order.items.size() > warehouse.items.size()) {
			return false;
		}
		
		for(Entry<Integer, Integer> prod : order.items.entrySet()) {
			if(warehouse.items.get(prod.getKey()) < prod.getValue()) {
				return false;
			}
		}
		
		return true;
	}
	*/
}
