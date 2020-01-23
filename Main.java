package DataBase;

import java.util.Scanner;

public class Main extends Customer
{
	   public static void main(String[] args)
	   {
		   Customer c1 = new Customer();
		   
		   System.out.println("1.Insert\n2.Update\n3.Delete\n4.Print Data");
		   Scanner input = new Scanner(System.in);
		   int in = input.nextInt();
		   switch(in) {
		   case 1: c1.insert();
		   case 2: c1.update();
		   case 3: c1.delete();
		   case 4: c1.printdata();
		   default: break;
		   }
	   }
}
