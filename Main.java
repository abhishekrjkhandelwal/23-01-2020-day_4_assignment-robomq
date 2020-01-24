package DataBase;

import java.util.Scanner;

public class Main extends Customer
{
	   public static void main(String[] args)
	   {
		   Customer c1 = new Customer();
		   
		   System.out.println("1.Add Customer Details\n2.Edit Customer Details\n3.Delete Customer Details\n4.Print Customer Details\n");
		  
		   while(true)
		   {
			   Scanner input = new Scanner(System.in);
			   int in = input.nextInt();
			   switch(in) 
			   {
				   case 1: c1.addCustomer(); break;
				   case 2: c1.editCustomerDetails(); break;
				   case 3: c1.deleteCustomerDetails(); break;
				   case 4: c1.printCustomerData(); break;
				   default: System.exit(0);
			   }
		   }
	   }
}
