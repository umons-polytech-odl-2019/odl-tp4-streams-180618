package be.ac.umons;

import be.ac.umons.exercice1.Exercice1;
import be.ac.umons.exercice2.Exercice2;
import be.ac.umons.exercice3.Exercice3;
import be.ac.umons.exercice4.Exercice4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main class of the project.
 *
 * @author Adriano Guttadauria
 * @author Olivier Debauche
 */
public class App
{

    public int menu() {
        System.out.println("");
        return 0;
    }

    public static void main( String[] args )
    {

        System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┣ Collections and Streams ┫" );
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        System.out.println("Menu");

        Scanner scanner = new Scanner(System.in);
        String choiceString;
        int choice = 0;

        do {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┣ Collections and Streams ┫" );
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            System.out.println("1. Lambdas (Employee)");
            System.out.println("2. Streams (Student)");
            System.out.println("3. Streams (Classroom)");
            System.out.println("4. Map Reduce example : Word Count");
            System.out.println("5. Quit");
            System.out.print("Your choice ? ");

            try {
                choiceString = scanner.next();
                choice = Integer.parseInt(choiceString);

            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");

            }


            switch (choice) {
                case 1:
                    Exercice1.main(args);
                    break;
                case 2:
                    Exercice2.main(args);
                    break;
                case 3:
                    Exercice3.main(args);
                    break;
                case 4:
                    Exercice4.main(args);
                    //Exercice4.main(new String[] {"frwiki-20191101-pages-articles1-3M.txt"});
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter a number between 1 and 5.");
            }

        } while (choice != 5);
    }


}
