import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        //getting input for number of rows and columns in the farm
        Scanner scan = new Scanner(System.in);
        System.out.println("How many rows of acres are in your farm?");
        int acreRows = scan.nextInt();
        System.out.println("How many columns of acres are in your farm?");
        int acreColumns = scan.nextInt();
        scan.nextLine();

        //Building the farm
        Farm yourFarm = new Farm(acreRows, acreColumns);

        //Planting farm
        yourFarm.plant();

        //Switch statment for the list of actions

        boolean run = true;
        while(run)
        {
            showMenu();
            System.out.println("What would you like to do?");
            int in = scan.nextInt();
            scan.nextLine();

            switch(in)
            {
                case 1:
                    yourFarm.toString();
                    break;
                case 2:
                    //count acres of a crop
                    break;
                case 3:
                    //Change crop to bad
                    break;
                case 4:
                    //check what crops will be harvested in a number of days
                    break;
                case 5:
                    //income per harvest
                    break;
                case 6:
                    //total income per crop over a number of days
                    break;
                case 9:
                    //quit
                    run = false;
                    System.out.println("You have quit 2D farm your progress was not saved");
                    break;
                default:
                    System.out.println("The option you entered was not on the list please try again");

            }

        }


    }
    public static void showMenu()
    {
        System.out.println("1. Print all crops");
        System.out.println("2. Count acres of a crop");
        System.out.println("3. Change an acre to bad");
        System.out.println("4. Check what crops will be harvested in a number of days");
        System.out.println("5. Income per harvest");
        System.out.println("6. Total income percrop over a number of days");
        System.out.println("9. Quit");
    }
}