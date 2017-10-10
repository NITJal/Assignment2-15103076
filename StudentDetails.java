
/**
*@Author :GAURAV
*/

package gaurav_3076;

import java.util.*;

//user-built Exception class
class FormException extends Exception{
	FormException()
	{
	    //calling constructor of the parent class
		super();
	}
}

public class StudentDetails {

	String Name;
	String Address;
	String Email;
	int HSCpercentage;
	int UGpercentage;
	long Phone;
	void FillDetails(String Name, String Address ,String Email, int HSCpercentage, int UGpercentage, long Phone)
	{
		this.Name  = Name;
		this.Email = Email;
		this.Address=Address;
		this.HSCpercentage = HSCpercentage;
		this.UGpercentage = UGpercentage;
		this.Phone = Phone;
	}
	void Check() throws FormException
	{
		if(HSCpercentage<60 || UGpercentage<70)
			    throw new FormException();
			    
		if(Phone<1000000000 || Phone>980000000)
		{
		    System.out.println("Invalid phone number !! ");
		    throw new NumberFormatException();   
		}
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name,Add,email;
		int A,B;
		long ph;
		System.out.println("Enter Student Name:  ");
		    name= sc.nextLine();
		System.out.println("Enter Student Address:  ");
		    Add= sc.nextLine();
		System.out.println("Enter Student email:  ");
		    email = sc.nextLine();
		System.out.println("Enter High School percentage:  ");
		    A = sc.nextInt();
		System.out.println("Enter UG percentage:  ");
		    B = sc.nextInt();
		System.out.println("Enter Phone number:  ");
		ph = sc.nextLong();
		StudentDetails stu = new StudentDetails();
		stu.FillDetails(name,Add,email,A,B,ph);
		try
		{
			stu.Check();
			System.out.println("Admission done!!\n");
		}
		catch(FormException e)
		{
			System.out.println("Not Eligible!!\n\n");
		}
		catch(NumberFormatException d)
		{
			System.out.println("Enter Details Correctly!!\n");
		}
	}

}
