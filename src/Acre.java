public class Acre
{
    private String cropType;
    private double sellPrice;
    private double costToGrow;
    private int daysToGrow;
    private boolean ableToGrow;
    private double income;

    // constuctor #1
    public Acre(String cropTypeIn, double sellPriceIn, double costToGrowIn, int daysToGrowIn, boolean ableToGrowIn)
    {
        cropType = cropTypeIn;
        sellPrice = sellPriceIn;
        costToGrow = costToGrowIn;
        daysToGrow = daysToGrowIn;
        ableToGrow = ableToGrowIn;
    }

    // constuctor #2
    public Acre()
    {
        cropType = "No Crops";
        sellPrice = 0;
        costToGrow = 0;
        daysToGrow = 0;
        ableToGrow = false;
    }

    // get crop type method
    public String getCrop()
    {
        return cropType;
    }

    // checks if there are enough days to grow the crop.
    public boolean enoughDays(int daysIn)
    {
        if((daysIn > daysToGrow) && (daysToGrow != 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //calulates income for one acre of a crop
    public double income()
    {
        income = sellPrice - costToGrow;
        return income;
    }

    // calculates income over a period of time.
    public double income(int numDaysIn)
    {
        //temp variable for how many times in a given period a crop can be planted and harvested
        int times = numDaysIn / daysToGrow;
        income = (sellPrice * times) - (costToGrow * times);
        return income;
    }

    //toString method.
    public String toString()
    {
        String print = "";

        if(ableToGrow == false)
        {
            print = cropType;
        }
        else
        {
            //print = ("Crop: " Corn "Sell Price: " $153.0 "Cost: "$103.0 "\tDays to Harvest: " 60)
            print = String.format("Crop: %s \tSell Price: $%.2f \tCost: $%.2f \tDays to Harvest: %d", cropType, sellPrice, costToGrow, daysToGrow);
        }
        return print;
    }
}
