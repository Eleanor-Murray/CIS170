import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.text.DecimalFormat;
public class PrintedReceipt extends Invoice
{
   java.io.File aFile;
   DecimalFormat dec = new DecimalFormat("#,###,##0.00");
   double finalAmountDue;
   PrintedReceipt()
   {
      super();
      aFile = new java.io.File("aFile.txt");
   }
    
   //make file name the customer's name
   public void createFile(boolean ship, boolean install)
   {
      java.io.PrintWriter outputfile;
      java.io.File aFile = new java.io.File("Receipt.txt");
      try
          {
              outputfile = new java.io.PrintWriter(aFile); 
              outputfile.println("\t\tThank you for shopping at Murray's Music");
              outputfile.println(aCustomer.toString());
              outputfile.println("Item            Price         Quantity          Total\n\n");
               int y = 0;
               for(Piano aPiano: purchaseArray)
               {
                  if(aPiano != null)
                     outputfile.println(aPiano.toString()+ "\t\t$" + dec.format(purchasePriceTotalArray.get(y))+"\n");
                  y++;
               }
 
               outputfile.println("Total before fees: $"+ dec.format(calculateTotalAmountDue()));
               
               if(ship)
                  outputfile.println(calculateShippingFees());
               
               if (install)
                  outputfile.println(calculateInstallationFees());
              
              outputfile.println("\n-----------------\nTotal Amount Due: $"+dec.format(calculateTotalAmountDue()+shippingFeeDue+ installationFeeDue));

              outputfile.close(); 
          }
      catch(FileNotFoundException e) 
          {
              System.out.println("-----> FILE NOT FOUND");  
          }
   }
}