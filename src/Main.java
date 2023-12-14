import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        //getting input for number of rows and columns in the farm
        Scanner scan = new Scanner(System.in);
        System.out.print("How many rows of acres are in your farm? ");
        int acreRows = scan.nextInt();
        System.out.print("How many columns of acres are in your farm? ");
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
            System.out.print("What would you like to do? ");
            int in = scan.nextInt();
            scan.nextLine();

            switch(in)
            {
                case 1:
                    System.out.println(yourFarm.toString());
                    break;
                case 2:
                    //count acres of a crop
                    int count = 0;
                    Crops input = yourFarm.getCrop("Which crop would you like to count: ");
                    for(int i = 0; i < yourFarm.cropAcre.length; i++)
                    {
                        for(int j = 0; j < yourFarm.cropAcre[i].length; j++)
                        {
                            if(yourFarm.cropAcre[i][j].getCrop() == input.cropType)
                            {
                                count++;
                            }
                        }
                    }
                    System.out.println(input.cropType + " is planted in " + count + " acres.");
                    break;
                case 3:
                    //Change crop to bad
                    System.out.println(yourFarm.toString());
                    System.out.println("Which row and column went bad?");
                    System.out.print("Row: ");
                    int row = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Column: ");
                    int column = scan.nextInt();
                    scan.nextLine();
                    if(((row > yourFarm.cropAcre.length) || (column > yourFarm.cropAcre[0].length)) ||
                       ((row == 0) || (column == 0)))
                    {
                        System.out.println("Please enter a valid acre location.");
                    }
                    else
                    {
                        yourFarm.cropAcre[row-1][column-1] = new Acre();
                    }
                    break;
                case 4:
                    //check what crops will be harvested in a number of days
                    System.out.print("How many days: ");
                    int days = scan.nextInt();
                    scan.nextLine();
                    for(int i = 0; i < yourFarm.cropAcre.length; i++)
                    {
                        for(int j = 0; j < yourFarm.cropAcre[i].length; j++)
                        {
                            System.out.print("Row: " + (i+1) + " Column: " + (j+1) + "\t" + yourFarm.cropAcre[i][j].getCrop() + " ");
                            if(yourFarm.cropAcre[i][j].enoughDays(days) == true)
                            {
                                System.out.println("will harvest in " + days + " days.");
                            }
                            else
                            {
                                System.out.println("will NOT harvest in " + days + " days.");
                            }
                        }
                    }
                    break;
                case 5:
                    //income per harvest
                    for(int i = 0; i < yourFarm.cropAcre.length; i++)
                    {
                        for(int j = 0; j < yourFarm.cropAcre[i].length; j++)
                        {
                            //System.out.println("Row: " + (i+1) + " Column: " + (j+1) + "\t" + yourFarm.cropAcre[i][j].getCrop() + " will make $" + yourFarm.cropAcre[i][j].income());
                            System.out.println(String.format("Row: %d Column: %d\t%s will make $%.2f", 
                                               i+1, j+1, yourFarm.cropAcre[i][j].getCrop(), yourFarm.cropAcre[i][j].income()));
                        }
                    }
                    break;
                case 6:
                    //total income per crop over a number of days
                    System.out.print("How many days: ");
                    days = scan.nextInt();
                    scan.nextLine();
                    for(int i = 0; i < yourFarm.cropAcre.length; i++)
                    {
                        for(int j = 0; j < yourFarm.cropAcre[i].length; j++)
                        {
                            //System.out.println("Row: " + (i+1) + " Column: " + (j+1) + "\t" + yourFarm.cropAcre[i][j].getCrop() + " will make $" + yourFarm.cropAcre[i][j].income(days));
                            System.out.println(String.format("Row: %d Column: %d\t%s will make $%.2f", 
                                               i+1, j+1, yourFarm.cropAcre[i][j].getCrop(), yourFarm.cropAcre[i][j].income(days)));
                        }
                    }
                    break;
                case 9:
                    //quit
                    run = false;
                    System.out.println("You have quit 2D farm your progress was not saved.");
                    break;
                default:
                    System.out.println("The option you entered was not on the list please try again.");
            }
        }
        scan.close();
    }
    public static void showMenu()
    {
        System.out.println("1. Print all crops.");
        System.out.println("2. Count acres of a crop.");
        System.out.println("3. Change an acre to bad.");
        System.out.println("4. Check what crops will be harvested in a number of days.");
        System.out.println("5. Income per harvest.");
        System.out.println("6. Total income per crop over a number of days.");
        System.out.println("9. Quit.");
    }
}