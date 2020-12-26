public class Customer
{
   private String customerName, phoneNumber, billingAddress, approximateDistance;
   private String customerInformation;
   
   public Customer(String cN, String pN, String bA, String aD)
   {
      customerName = cN;
      phoneNumber = "("+pN.substring(0,3)+") "+pN.substring(3,6) + "-" +pN.substring(6,10);
      billingAddress = bA;
      approximateDistance = aD;
   }
   public String getPhoneNumber(){return phoneNumber;}
   public String getDistance(){return approximateDistance;}
   
   @Override
   public String toString()
   {
      customerInformation = customerName + "\nPN:" + phoneNumber + "\nBilling Address: "+ billingAddress + "\nApproximate Distance From Store: " + approximateDistance+"\n";
      return customerInformation;
   }
}