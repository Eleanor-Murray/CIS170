import java.util.ArrayList;
import java.text.DecimalFormat;
public class Invoice
{
   private double purchasePriceTotal;
   protected ArrayList <Piano> purchaseArray = new ArrayList<Piano>(10);
   protected ArrayList <Double> purchasePriceTotalArray = new ArrayList <Double>(10);
   private Double[] shippingFeesArray = {10.0,20.0,30.0,40.0};
   private Double[] installationFeesArray = {10.0,11.0,12.0,13.0,14.0};
   protected double totalAmountDue, shippingFeeDue, installationFeeDue;
   protected Customer aCustomer;
   private String shippingInvoiceLine;
   protected String installationInvoiceLine=" ";
   
   public Invoice()
   {
         
   }
   
   DecimalFormat dec = new DecimalFormat("#,###,##0.00");
   
   public void setCustomer(Customer c){aCustomer = c;}
   public Customer getCustomer(){return aCustomer;}
   public double getShippingFees(){return shippingFeeDue;}
   public double getInstallationFees(){return installationFeeDue;}
   
   int x = 0;
   public void calculatePurchasePrice()
   {  
      purchasePriceTotalArray.clear();
      for(Piano aPiano: purchaseArray)
      {
         if(aPiano != null)
         {
            purchasePriceTotal = aPiano.getPianoPrice()*aPiano.getQuantity();
            purchasePriceTotalArray.add(purchasePriceTotal);
         }
         x++;      
      }
   }

   
   int y = 0;
   public double calculateTotalAmountDue()
   {
      totalAmountDue = 0;
      for(Double anAmount: purchasePriceTotalArray)
      {
         if(anAmount != null)
            totalAmountDue += anAmount;
         y++;
      }
      return totalAmountDue;
   } 
   
   public void add(Piano aPiano)
   {
      purchaseArray.add(aPiano);
   }
   
   String gradualInvoice = " ";
   
   public String getRunningInvoice()
   {  
      gradualInvoice = "Item                  Price   Quantity          Total\n\n";
      int y = 0;
      for(Piano aPiano: purchaseArray)
      {
         if(aPiano != null)
            gradualInvoice+=aPiano.toString()+ "\t\t$" + dec.format(purchasePriceTotalArray.get(y))+"\n";
         y++;
      }
      
      return gradualInvoice;
   }
   int shipAndInstallRank;
   public String calculateShippingFees()
   {  
      for(Piano aPiano: purchaseArray)
      {
         if(aPiano != null)
         {
            shipAndInstallRank+=(int)(aPiano.getPianoPrice()/1000)*aPiano.getQuantity();
         }     
      }
      switch(aCustomer.getDistance())
      {
         
         case "Up to 10 miles":
            shippingFeeDue = shippingFeesArray[0]*shipAndInstallRank;
            break;
         case "Up to 25 miles":
            shippingFeeDue = shippingFeesArray[1]*shipAndInstallRank;
            break;
         case "Up to 50 miles":
            shippingFeeDue = shippingFeesArray[2]*shipAndInstallRank;
            break;
         case "Over fifty miles":
            shippingFeeDue = shippingFeesArray[3]*shipAndInstallRank;
            break;
      }
      shippingInvoiceLine = "\nShipping Fees: $"+ dec.format(shippingFeeDue);
      return shippingInvoiceLine;
   }
   
   public String calculateInstallationFees()
   {  
      installationFeeDue = (shipAndInstallRank*10);
      installationInvoiceLine = "\nInstallation Fees: $"+ dec.format(installationFeeDue);
      return installationInvoiceLine;
   }
   
   public String finalOnScreenInvoice()
   {
      gradualInvoice = "Thank you for shopping at Murray's Music\n\nItem                  Price   Quantity          Total\n\n";
      int y = 0;
      for(Piano aPiano: purchaseArray)
      {
         if(aPiano != null)
            gradualInvoice+=aPiano.toString()+ "\t\t$" + dec.format(purchasePriceTotalArray.get(y))+"\n";
         y++;
      }
      
      
      return gradualInvoice;
   }
   
   public void clearInvoice()
   {
      purchasePriceTotalArray.clear();
      purchaseArray.clear();
   }
}