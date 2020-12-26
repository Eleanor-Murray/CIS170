public class Piano extends PianoStoreMainProgram
{
   private String description;
   private double pianoPrice;
   private int quantity;
   String pianoLine;
   private double [] pianoPrices = {6000.00,2000.0,4000.0,100.0,4000.0,15.0};
   
   public Piano(String d, int q)
   {
      description = d;
      quantity = q;
      switch(description)
      {
         case "Grand Piano":
            pianoPrice = pianoPrices[0];
            break;
         case "Upright Piano":
            pianoPrice = pianoPrices[1];
            break;
         case "Player Piano":
            pianoPrice = pianoPrices[2];
            break;
         case "Keyboard":
            pianoPrice = pianoPrices[3];
            break;
         case "Pump Organ":
            pianoPrice = pianoPrices[4];
            break;
         case "Headphones":
            pianoPrice = pianoPrices[5];
            break;
      }
   }
   
   public String getDescription()   { return description;}
   public Double getPianoPrice()   { return pianoPrice;}
   public int getQuantity()   { return quantity;}
   
   public void setPrice(double p){pianoPrice = p;}
   
   @Override
   public String toString()
   {  
      pianoLine = description + " \t $" + pianoPrice + " \t " + quantity;
      
      return pianoLine;
   }
}