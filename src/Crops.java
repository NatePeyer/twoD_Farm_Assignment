public class Crops 
{
    public String cropType;
    public double sellPrice;
    public double costToGrow;
    public int daysToGrow;
    
    public Crops(String cropTypeIn, double sellPriceIn, double costToGrowIn, int daysToGrowIn)
    {
        cropType = cropTypeIn;
        sellPrice = sellPriceIn;
        costToGrow = costToGrowIn;
        daysToGrow = daysToGrowIn;
    }
}
