import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM_Model {
	private double balance;
	private String cHname="";
	private String cHpwd="";
	private String cHBankName="";
	
	 public ATM_Model(Long enteredCN) throws FileNotFoundException {
		File cardNumbersFile=new File("E:\\Eclipse\\ATM\\src\\CardNumbers");
		File cardHoldersFile=new File("E:\\Eclipse\\ATM\\src\\CardHolderNames");
		File passwordsFile=new File("E:\\Eclipse\\ATM\\src\\Passwords");
		File cHBankNameFile=new File("E:\\Eclipse\\ATM\\src\\CHBankName");
		File cHBalanceFile=new File("E:\\Eclipse\\ATM\\src\\CHBalance");
		
		Scanner CNReader=new Scanner(cardNumbersFile);
		Scanner CHReader=new Scanner(cardHoldersFile);
		Scanner pwdReader=new Scanner(passwordsFile);
		Scanner cHBNReader=new Scanner(cHBankNameFile);
		Scanner cHBalReader=new Scanner(cHBalanceFile);
		
		ArrayList<String> AllCNs =new ArrayList<String>();
		while(CNReader.hasNext()) {
			AllCNs.add(CNReader.nextLine());
		}
		ArrayList<String> AllCHs =new ArrayList<String>();
		while(CHReader.hasNext()) {
			AllCHs.add(CHReader.nextLine());
		}
		ArrayList<String> Allpwds =new ArrayList<String>();
		while(pwdReader.hasNext()) {
			Allpwds.add(pwdReader.nextLine());
		}
		ArrayList<String> AllcHBankNames =new ArrayList<String>();
		while(cHBNReader.hasNext()) {
			AllcHBankNames.add(cHBNReader.nextLine());
		}
		ArrayList<Double> AllCHsBalance =new ArrayList<Double>();
		while(cHBalReader.hasNext()) {
			AllCHsBalance.add(Double.parseDouble(cHBalReader.nextLine()));
		}
		
		
		int count=0;
		
		for(int i=0;i<AllCNs.size();i++) {
			if(Long.parseLong(AllCNs.get(i))==enteredCN) {
				
				cHname=AllCHs.get(i);
				cHpwd=Allpwds.get(i);
				cHBankName=AllcHBankNames.get(i);
				balance=AllCHsBalance.get(i);
				
				count++;
				break;
			}
		}
		if(count==0)
			throw new IllegalArgumentException("Enter a valid Card Number");
		
	}
	 
	 
	 public void getCHDetails() {
		 System.out.println("\tName: "+cHname
				 +"\n\tBank Name: "+cHBankName+"\n");
	 }
	 
	 public String getName() {
		 return cHname;
	 }
	 
	 public Double getBalance() {
		 return balance;
	 }
	 
	 public void deposit(Double amount) {
		 balance=balance+amount;
		 System.out.println("\nRs."+amount+"  credited succesfully.The updated balance is Rs."+balance);
	 }
	 
	 public void transfer(String recName,Long receipientAccNum,Double txamount) {
		 balance=balance-txamount;
		 System.out.println("\n\nRs."+txamount+" transfered succesfully to "+ recName+"\n with Account Number as "+receipientAccNum);
	 }
	 
	 public void checkpwd(String enteredpwd)throws IllegalAccessException{
		 if(enteredpwd.equals(cHpwd)) {
			 
		 }
		 else {
			throw new IllegalAccessException("\nWrong Password,cannot proceed further");
		}
	 }
	 
	 public void changePin(String newPin) {
		 
		 this.cHpwd=newPin;
		 System.out.println("\nThe PIN Change was Succesful");
	 }
	 
	 public void withdraw(Double amount) {
		 balance=balance-amount;
		 System.out.println("\nRs."+amount+"  debited.The updated balance is Rs."+balance);
	 }
	 

}
