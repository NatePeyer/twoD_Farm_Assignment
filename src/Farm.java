import java.util.*;

public class Farm 
{
    Acre cropAcre[][];
    //final String CROPS[] = {"Corn","Potatoes","Soybeans","Wheat","Tree Nuts", "Not an area we can grow crops"};
    final Crops CROPS[] = 
    {
        new Crops("No Crops", 0, 0, 0),
        new Crops("Corn", 153, 103, 60), 
        new Crops("Potatoes", 485, 336, 70),
        new Crops("Soybeans", 9.64, 3.78, 45),
        new Crops("Wheat", 827, 170, 240),
        new Crops("Tree Nuts", 7200, 5800, 365)
    };
    Scanner scan = new Scanner(System.in);

    // constuctor
    public Farm(int rowsIn, int columnsIn)
    {
        cropAcre = new Acre[rowsIn][columnsIn];
    }

    //todo range check input
    public Crops getCrop(String prompt)
    {
        int input = -1;
        while ((input < 0) || (input > CROPS.length - 1))
        {
            for(int i = 1; i < CROPS.length; i++)
            {
                System.out.println((i) + ". " + CROPS[i].cropType);
            }
            System.out.println("0. Not an area we can grow crops.");
            System.out.print(prompt);
            input = scan.nextInt();
            scan.nextLine();
            if ((input < 0) || (input > CROPS.length - 1))
            {
                System.out.println("Please input a valid crop type.");
            }
        }
        return CROPS[input];
    }
    
    public void plant()
    {
        for(int i = 0; i < cropAcre.length; i++)
        {
            for(int j = 0; j< cropAcre[i].length; j++)
            {
                Crops input = getCrop("What would you like to grow in row " + (i + 1) + ", column " + (j + 1) + ": ");
                if(input.cropType != "No Crops")
                {
                    cropAcre[i][j] = new Acre(input.cropType, input.sellPrice, input.costToGrow, input.daysToGrow, true);
                } 
                else
                {
                    cropAcre[i][j] = new Acre();
                }
            }
        }
    }
    //public void countAcres(int check)
    //{

    //}

    public String toString()
    {
        String temp = "";
        for(int i = 0; i < cropAcre.length; i++)
        {
             for(int j = 0; j < cropAcre[i].length; j++)
            {
                 temp += ("Row: " + (i+1) + " Column: " + (j+1) +"\t" + cropAcre[i][j].toString() + "\n");
            }
        }
        return temp;
    }
}
