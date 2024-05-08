/**
 * 
 */
package Punto;

/**
 * 
 */
public class UsaFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		public static int fibonacci(int n) {
			if(n == 0) {
				return 0;
			}
			if(n == 1) {
				return 1;
			}
			return n + fibonacci(n-1);
		}

	}

}
