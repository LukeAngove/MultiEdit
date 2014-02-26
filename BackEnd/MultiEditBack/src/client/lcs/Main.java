/**
 * 
 */
package lcs;

/**
 * @author luke
 *
 */
public class Main {
	
	public static void main(String[] args) {
		String[] a = {"luke", "is", "cool"};
		String[] b = {"luke", "was", "cool"};
		
		diff(a,b);
		
		Character[] x = {'a', 'b', 'c', 'd', 'e'};
		Character[] y = {'a', 'l', 'c', 'f', 'e'};
		
		diff(x,y);
		
	}
	
	public static <T> void diff(T[] a, T[] b) {
		int[][] c = lcs(a, b);
		printDiff(c, a, b);
	}

	public static <T> int[][] lcs(T[] a, T[] b) {
		int[][] c = new int[a.length+1][b.length+1];

		for(int i=0; i<a.length; i++) {
			c[i][0] = 0;
		}

		for(int j=0; j<b.length; j++) {
			c[0][j] = 0;
		}

		for( int i=1; i<=a.length; i++ ) {
			for( int j=1; j<=b.length; j++ ) {
				if(a[i-1] == b[j-1]) {
					c[i][j] = c[i-1][j-1]+1;
				} else {
					c[i][j] = max(c[i-1][j], c[i][j-1]);
				}
			}
		}
		return c;
	}
	
	public static <T> void printDiff(int[][] c, T[] x, T[] y, int i, int j) {
		int xindex = i-1;
		int yindex = j-1;
	    if( (i > 0) && (j > 0) && (x[xindex] == y[yindex]) ) {
	        printDiff(c, x, y, i-1, j-1);
	        System.out.print("  " + x[xindex].toString());
	    } else if( (j > 0) && (i == 0 || c[i][j-1] >= c[i-1][j]) ) {
	        printDiff(c, x, y, i, j-1);
	        System.out.print(" +" + y[yindex].toString());
	    } else if( (i > 0) && (j == 0 || ( c[i][j-1] < c[i-1][j] ) ) ) {
	        printDiff(c, x, y, i-1, j);
	        System.out.print(" -" + x[xindex].toString());
	    } else {
	    }
		
	}
	
	public static <T> void printDiff(int[][]c, T[] x, T[] y) {
		printDiff(c, x, y, x.length, y.length);
	}
	
	private static int max(int a, int b) {
		if(a >= b) {
			return a;
		} else {
			return b;
		}
	}
}
