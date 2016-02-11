
public class Util {
	public static int distance(int x0, int y0, int x1, int y1) {
		return (int) Math.ceil(Math.sqrt((x0 - x1)^2 + (y0 - y1)^2));
	}
}
