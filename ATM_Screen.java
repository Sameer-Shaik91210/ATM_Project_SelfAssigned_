import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class ATM_Screen {

	public static void main(String[] args) throws FileNotFoundException, IllegalAccessException {
		Scanner scanner=new Scanner(System.in);
		Console con=System.console();
		
	
		
		
		System.out.println("\t\t\tWELCOME TO ATM\n");
		System.out.println("Enter your Card Number: ");
		
		Long enteredCN=scanner.nextLong();
		ATM_Model model=new ATM_Model(enteredCN);
		
        model.getCHDetails();
        
		System.out.println("\t\tSelect a transaction "+model.getName());
		System.out.println(" \t1.Deposit\t\t4.Fast Cash\n"
				+ "\t2.Transfer\t\t5.Cash Withdrawal\n"
				+ "\t3.PIN Exchange\t\t6.Balance Enquiry\n"
				);
		System.out.println("Enter corresponding Number: ");
	

		scanner.nextLine();
			int ChosenTransaction=scanner.nextInt();
			switch (ChosenTransaction) {
			case 1:
				System.out.print("Enter PIN: ");
				model.checkpwd(new String(con.readPassword()));
				System.out.print("\nEnter Amount to deposit :");
				model.deposit(scanner.nextDouble());
				
				
				break;
			case 2:
				System.out.print("Enter The Receipient's Bank Account Number ");
				Long receipientAccNum=scanner.nextLong();
				System.out.print("\nEnter His\\Her Name:");scanner.nextLine();
				String recNameString=scanner.nextLine();
				System.out.print("\n Enter amount to Transfer: ");
				Double txamount=scanner.nextDouble();
				System.out.print("Enter PIN: ");
				model.checkpwd(new String(con.readPassword()));
				model.transfer(recNameString,receipientAccNum,txamount);
				break;
			case 3:
				System.out.print("Enter PIN: ");
				model.checkpwd(new String(con.readPassword()));
				System.out.print("\n Enter new Pin: ");scanner.nextLine();
				model.changePin(scanner.nextLine());
				break;
			case 4:
				System.out.print("Enter PIN: ");
				model.checkpwd(new String(con.readPassword()));
				System.out.print("\n\t1. 200\n\t2. 500\n\t3. 1000\n\t4. 2000\n\nEnter Corresponding Number: ");
				loopwhile:while(true) {
				 switch(scanner.nextInt()) {
				case 1:
					model.withdraw(200d);
					break loopwhile;
					
				case 2:
					model.withdraw(500d);
					break loopwhile;
				case 3:
					model.withdraw(1000d);
					break loopwhile;
				case 4:
					model.withdraw(2000d);
					break loopwhile;
				default:
					System.out.println( "Enter valid Corrresponding digit ");
				 }
				}
				break;
			
			case 5:
				System.out.print("Enter PIN: ");
				model.checkpwd(new String(con.readPassword()));
				System.out.print("\nEnter Amount to Withdraw: ");
				model.withdraw(scanner.nextDouble());
				break;	
			case 6:
				System.out.print("Enter PIN: ");
				model.checkpwd(new String(con.readPassword()));
				System.out.println("The Balance Amount is "+model.getBalance());
				break;
			
		          
			default:
				throw new IllegalArgumentException("Unexpected value: " + ChosenTransaction);
			}
		}
		 

	}


