package process;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner number;
	Login lg = new Login();
	public Menu() {
		
		int choice =0;
        do{
            number = new Scanner(System.in);
            lg.printMenu();
            try {
            		choice = number.nextInt();
            }catch(InputMismatchException e) {
            		System.out.println("Wrong format!! please input a number!!");
            		choice = 0;
            }
            switch(choice){
                case 1:
                    lg.login();
                    break;
                case 2:
                		lg.register();
                    break;
                default:
                		break;
            }

        }while(choice != 3);
	}
}
