import java.util.Scanner;

public class MakeChangeProgram {

	public static void main(String[] args) {
//		Overview
//		In the cash register we will calculate the amount of change returned to a customer 
//		based on the purchase price and the amount tendered. We will also notify the attendant 
//		how many of each piece of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed 
//		to make the change for the customer. Change should be provided using the largest bill and 
//		coin denominations as possible. Denominations that are not used should not be displayed.

//	    Assumptions: 
//		1. The item will never be over $20.00 
//		2. The customer will never tender more than $20.00

		String moneyReturned = "";
//		User Story #1
//		The user is prompted asking for the price of the item.

		Scanner kb = new Scanner(System.in);

		System.out.print("Welcome to the Make Change Program!\nEnter the price of your item >> ");
		float productPrice = kb.nextFloat();
		if (productPrice >= 20) {
			System.out.println("Sorry, this program does not calculate items costing $20.00 or more.\nTerminating Program.");
		}
//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.

		System.out.print("Enter the amount of money you are tendering >> ");
		float amountTendered = kb.nextFloat();

//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.
		float chgToBeRtnd = amountTendered - productPrice;
		float tempChg = 0;

		if (amountTendered < productPrice) {
			System.out
					.println("Sorry, you've not provided enough to cover the cost of your item.\nTerminating program.");
		} else if (amountTendered < 0) {
			System.out.println("You've entered an invalide tender ammount.\nTerminating Program.");
		} else if (amountTendered == productPrice) {
			System.out.println("You've entered the exact amount. Thank you for using the Make Change Program.");
		}

//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and 
//		coins that should be given to the customer.

//		else {
//			if (chgToBeRtnd % 10 == 0) {
//				double quantity10s = chgToBeRtnd / 10;
//				if (quantity10s - (int)quantity10s == 0) {
//					moneyReturned = "" + quantity10s;
//					System.out.println("changeReturned twenties mod int, no coin" + quantity10s);
//				}
//				else if (quantity10s > 1) {
//					moneyReturned = "" + quantity10s;
//				System.out.println("changed returned more than 1 twenty" + quantity10s);
//				}
//			}
//		}
		if (chgToBeRtnd >= 10) {
			int num10s = (int)chgToBeRtnd / 10;
			if (num10s > 1) {
				moneyReturned = moneyReturned + num10s + " ten dollar bills";
			} else {
				moneyReturned = moneyReturned + num10s + " ten dollar bill";
			}
			tempChg = chgToBeRtnd - num10s * 10;
		}
		if (tempChg >= 5) {
			int num5s = (int)tempChg / 5;
			tempChg = tempChg - num5s * 5;
			if (num5s > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num5s + " five dollar bills";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num5s + " five dollar bill";
			}

		}
		if (tempChg >= 1) {
			int num1s = (int)tempChg / 1;
			tempChg = tempChg - num1s * 1;
			if (num1s > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num1s + " one dollar bills";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num1s + " one dollar bill";
			}
		}
		if (tempChg > 0 && tempChg >= 0.25f) {
			float numQrts = tempChg / 0.25f;
			tempChg = tempChg - (int)numQrts * 0.25f;
			if ((int)numQrts > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numQrts + " quarters";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numQrts + " quarter";
			}
			System.out.println("TempChg 0.25 " + tempChg);
		}
		if (tempChg > 0 && tempChg >= 0.10f) {
			float numDimes = tempChg / 0.10f;
			tempChg = tempChg - (int)numDimes * 0.10f;
			if ((int)numDimes > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numDimes + " dimes";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numDimes + " dime";
			}
			System.out.println("TempChg 0.10 " + tempChg);
		}
		if (tempChg > 0 && tempChg >= 0.05f) {
			float numNickels = tempChg / 0.05f;
			tempChg = tempChg - (int)numNickels * 0.05f;
			if ((int)numNickels > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numNickels + " nickels";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numNickels + " nickel";
			}
			System.out.println("TempChg 0.05 " + tempChg);
		}
		if (tempChg > 0 && tempChg > 0) {
			float numPen = tempChg / 0.01f;
			tempChg = tempChg - (int)numPen * 0.01f;
			if ((int)numPen > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numPen + " pennies";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numPen + " penny";
			}
			
			System.out.println("TempChg pennies " + tempChg);
		}
		
		System.out.println("TempChg at the end " + tempChg);
		System.out.println(moneyReturned + ".");

	}

}
