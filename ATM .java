/**
*@Author : GAURAV
*/

package gaurav_3076;

import java.util.*;

//user defined Exception class that inherits from Exception class
class MyException extends Exception{
	
	MyException()
	{
		super();//calling constructors of the parent class
		System.out.println("In MyException Class !!");
	}
}

public class ATM 
{
	int atm_pin;
	int bank_balance;
	int exec;
	ATM(int a, int b)
	{
		bank_balance = a;
		atm_pin = b;
	}
	//function to withdraw the Amount from the bank
	void Withdraw(int amt)
	{
		if(amt>bank_balance || (bank_balance-amt<500))
		{
			exec = 0;//don't execute this action and throw exception
			throw new ArithmeticException("Can't withdraw!!!\n");
		}
		else//otherwise deduct the amount
		{
		    bank_balance = bank_balance-amt;
		    System.out.println(amt+" Has been sucessfully deducted from Your Account !! ");
		}
		    
	}
	
	void Deposit(int amt)
	{
	    if(bank_balance+amt>2500000)
		{
			exec = 0;//don't execute this action and throw exception
			throw new ArithmeticException("Can't deposit as it has reached the maximum value the Account can hold!!!\n");
		}
	    else
	    {
	        bank_balance=bank_balance+amt;
	        System.out.println(amt+" Has been sucessfully deposited in Your Account !! ");
	    }
		
	}
	void Display()
	{
		System.out.println("Your Current Balance is : " +bank_balance);
	}
	void CheckPin(int pinc) throws MyException
	{
		MyException M = new MyException();
		if(atm_pin<1000 || atm_pin>9999 || pinc!= atm_pin)
				throw new  MyException();
	}
	public static void main(String[] args) 
	{
			System.out.print("Enter bank balance and pin: ");
			Scanner sc = new Scanner(System.in);
			int balance = sc.nextInt();
			int pinc = sc.nextInt();
			int option;
			ATM a = new ATM(balance, pinc);
			while(true){
			System.out.println("Options: \n1.Withdraw\n2.Deposit\n3.Display\n4.Exit");
			option = sc.nextInt();
			switch(option)
			{
			case 1:
				
				
				try{
				System.out.println("Enter Atm pin: ");
				pinc = sc.nextInt();
				a.CheckPin(pinc);
				System.out.print("Enter the amount to withdraw: \n");
				int amt = sc.nextInt();
				a.Withdraw(amt);
				break;
				}
				catch(ArithmeticException e)
				{
					System.out.println(e.getMessage());
				}
				catch(MyException p)
				{
					System.out.println("Incorrect pin!!!\n\n");
				}
				break;
			case 2:
			       
			       try{
						
						System.out.println("Enter the Atm pin: ");
						pinc = sc.nextInt();
						a.CheckPin(pinc);
						System.out.println("Enter the amount to be deposited : \n");
			            int a1=sc.nextInt();
			            a.Deposit(a1);
						break;
						}
						catch(ArithmeticException e)
						{
							System.out.println(e.getMessage());
						}
						catch(MyException p)
						{
							System.out.println("Incorrect pin!!!\n\n");
						}
						break;
			case 3:a.Display();
				   break;
			case 4:
				break;
			}
			if(option>5)
				break;
			}
			
	}

}