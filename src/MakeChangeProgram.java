import java.util.Scanner;

public class MakeChangeProgram {

	public static void main(String[] args) {
//		User Story #1
//		The user is prompted asking for the price of the item.
		
		Scanner kb = new Scanner(System.in);

		System.out.print("Welcome to the Make Change Program!\nEnter the price of your item >> ");
		double productPrice = kb.nextDouble();
		
//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.

		System.out.print("Enter the amount of money you are tendering >> ");
		double amountTendered = kb.nextDouble();

		
	}

}
