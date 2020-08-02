/** File: Driver.java
 * Author: Jeffrey Xu
 * Date: 8/04/2020
 * Email: jeffreyxu@tamu.edu
 * 
 * Description: Calls the GUI constructor. Throws FileNotFoundException if 
 * input file path does not exist. 
 */

import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		new GUI();
	}
}
