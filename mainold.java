//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.io.PrintStream;
//
//
//
//
//public class main {
//	
//static int max=5;
// public static void main(String[] args) throws FileNotFoundException {
//  boolean img[][];
//  boolean [][] test = {
//			 {false,false,false,false,false,false,false},
//			 {false,true,true,true,true,true,false},
//			 {false,true,true,true,true,true,false},
//			 {false,true,true,true,true,true,false},
//			 {false,true,true,true,true,true,false},
//			 {false,true,true,true,true,true,false},
//			 {false,false,false,false,false,false,false},
//			 
//	 };
//  System.out.println(check_square(test, 0,0,0));
//  Scanner sc = new Scanner(new File("learn_and_teach.in"));
//  int height = sc.nextInt();
//  int width = sc.nextInt();
//  
//  img = new boolean[width][height];
//  sc.nextLine();
//  
//  int y = 0;
//  while(sc.hasNextLine()) {
//   String s = sc.nextLine();
//   for(int x=0; x<width; x++) {
//    img[x][y] = (s.charAt(x) == '#');
//   }
//   y++;
//  }
//  
//  for(y = 0; y < height; y++) {
//   for(int x = 0; x < width; x++) {
//    System.out.print(img[x][y] ? '#' : '.');
//   }
//   System.out.println();
//  }
//  square(img, new PrintStream(new File("learn_and_teach"+".out")), width, height);
//  
// }
// 
// public static void square (boolean [][] img, PrintStream out, int width, int height){
//	 int max = 0;
//	 int xmax = 0;
//	 int ymax = 0;
//	 int count = 0;
//	 
//	 boolean [][] target;
//	 
//	 target = new boolean [width][height];
//	 
//	 for (int y=0; y<img[0].length; y++){
//		 for (int x=0; x<img.length; x++){
//			 for(int linecount = 0; linecount <=max; linecount++){
//				 if (img[x+linecount][y]) xmax = x+linecount;
//				 else break;
//			 }
//			 for(int linecount = 0; linecount <=max; linecount++){
//				 if (img[x][y+linecount]) ymax = y+linecount;
//				 else break;
//			 } 
//			 
//			 for (int maxnow = Math.max(xmax, ymax); maxnow>=0; maxnow--){
//			 if (check_square(img,x,y,maxnow) && x+maxnow<width && y+maxnow<height && x-maxnow>=0 && y-maxnow>=0){
//				 out.printf("PAINT_SQUARE %d %d %d", y, x, maxnow);
//				 out.println();
//				 count++;
//				 xmax=0;
//				 ymax=0;
//				 break;
//				
//			 }			 
//			 }
//		 }
//	 }
//	 
//	System.out.println(count); 
// }
// 
// public static boolean check_square(boolean [][] img, int x, int y, int size){
//	 for (int ycheck = y-size;  ycheck <= (y+size); ycheck++){
//		 for (int xcheck = x-size;  xcheck <= (x+size) ; xcheck++){
//			 if (xcheck < 0 || ycheck < 0 || xcheck>= img.length || ycheck >= img[0].length) return false;
//			 if (!img[xcheck][ycheck]) return false;
//		 }
//	 }
//	 return true;
// }
// 
// 
//}