//Eleanor Murray
//FA-20 CIS-171-01: Final Project
//Murray's Music: Piano Store Program

import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.stage.Screen;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.text.*; 
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.media.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.geometry.*;
import javafx.event.*;
import javafx.util.Duration;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class PianoStoreMainProgram extends Application 
{   
   private static final String MEDIA_URL = (new File("Maple.mp3")).toURI().toString(); 
   private static final String GRANDPIANO_URL = (new File("GrandPiano.mp3")).toURI().toString();
   private static final String KEYBOARD_URL = (new File("Keyboard.mp3")).toURI().toString();
   private static final String SALOON_URL = (new File("Saloon.mp3")).toURI().toString();
   private static final String ORGAN_URL = (new File("Organ.mp3")).toURI().toString();
 
    @Override
    public void start(Stage primaryStage) throws Exception
    {    
         //____________________________________________________________________________________________  
         //-------------------------STAGE ONE:PIANO-STORE---------------------------------------------

         primaryStage.setTitle("Murray's Music");
                   
         GridPane organizeAllOne = new GridPane();
         organizeAllOne.setPadding(new Insets(1,1,1,1));
         
         Image bannerImage = new Image("Banner.jpg");
         ImageView banner = new ImageView(bannerImage);
          banner.setFitHeight(100); 
          banner.setFitWidth(415);         
          banner.setPreserveRatio(true);
         
         Label header = new Label(" ", banner);
         header.setFont(Font.font("Copperplate Gothic Light", 20)); 
         header.setAlignment(Pos.CENTER);
         
         VBox displaySelection = new VBox();
         displaySelection.setAlignment(Pos.TOP_CENTER);
         
         ImageView imageView1 = new ImageView(new Image("PianoChoices.jpg"));
         
         Label lb1 = new Label("\nOur Selection", imageView1);
         lb1.setTextFill(Color.WHITE);
         lb1.setFont(Font.font("Copperplate Gothic Light", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
         lb1.setContentDisplay(ContentDisplay.BOTTOM);
         
          
          imageView1.setFitHeight(400); 
          imageView1.setFitWidth(400);         
          imageView1.setPreserveRatio(true); 
           
         displaySelection.getChildren().addAll(banner,lb1);
         
          
         FlowPane leftPane = new FlowPane();
         leftPane.getStyleClass().add("flow-tile");
         
         
         GridPane data = new GridPane();
         data.setVgap(5);
         data.setPadding(new Insets(10,5,5,5));
         
         TextField fldFirstName = new TextField();      
         TextField fldLastName = new TextField();
         TextField fldAddress = new TextField();
         TextField fldPhoneNumber = new TextField();

        
         ImageView infoView = new ImageView(new Image("info.png"));
         infoView.setFitHeight(15);
         infoView.setFitWidth(15);
         Label customerInformationInstructions = new Label("   Customer Information", infoView);
            customerInformationInstructions.setFont(Font.font("Copperplate Gothic Light", FontPosture.REGULAR, 16));
            customerInformationInstructions.setAlignment(Pos.CENTER); 
            customerInformationInstructions.setTextAlignment(TextAlignment.CENTER);
            customerInformationInstructions.setTooltip(new Tooltip("Must enter customer information before making purchase(s)"));
         Label lblFirstName = new Label("First Name: ");
         Label lblLastName = new Label("Last Name: ");
         Label lblAddress = new Label("Address: ");
         Label lblPhoneNumber = new Label("Phone Number: ");
         Label lblDistance = new Label("Distance from store: ");
        

         String[] distanceList = {"Up to 10 miles", "Up to 25 miles", "Up to 50 miles", "Over fifty miles"};      
         ComboBox <String> distances = new ComboBox<String>();
         distances.getItems().addAll(distanceList);   
                
         TextArea welcomeMessage = new TextArea("Please enter customer information before continuing.");
         welcomeMessage.setPrefWidth(30);
         welcomeMessage.setPrefHeight(10);
         welcomeMessage.setWrapText(true);
         welcomeMessage.setEditable(false); 
        
         Button submit = new Button("Submit");
         submit.setAlignment(Pos.CENTER);
         submit.setTooltip(new Tooltip("Submit information"));
         
         data.addRow(5, lblDistance, distances);
         data.addRow(6, submit);
         data.setMinSize(300,80);
         data.setMaxSize(300,80);

         lblFirstName.setLabelFor(fldFirstName);
         lblLastName.setLabelFor(fldLastName);
         data.add(customerInformationInstructions,0,0,2,1);
         data.addRow(1, lblFirstName, fldFirstName);
         data.addRow(2, lblLastName, fldLastName);
         data.addRow(3, lblPhoneNumber, fldPhoneNumber);
         data.addRow(4, lblAddress, fldAddress);
         data.add(welcomeMessage,0,9,2,1);
         
          
         leftPane.getChildren().add(data);
         StackPane testPianoDisplay = new StackPane();
         
         ImageView testPianoPicture = new ImageView(new Image("TestPianoPicture.jpg"));
         testPianoPicture.setFitWidth(300);
         testPianoPicture.setFitHeight(120);           
         data.add(testPianoPicture, 0, 12,2,1);
         
         Label LblTestPianos = new Label("Try out our pianos below");
         LblTestPianos.setFont(Font.font("Copperplate Gothic Light", FontPosture.REGULAR, 12));
         Button switchToPiano = new Button("Play Pianos");
         testPianoDisplay.getChildren().addAll(testPianoPicture, switchToPiano);
         

         data.add(testPianoDisplay,0,13,2,1);
         
         leftPane.setPadding(new Insets(2,2,2,2));
         leftPane.setMaxWidth(250);
         leftPane.setMaxHeight(500);
                  
         
         FlowPane buyPiano = new FlowPane();
         buyPiano.setMaxWidth(260);
         buyPiano.setMaxHeight(400);
         buyPiano.getStyleClass().add("flow-tile");
         
         GridPane purchase = new GridPane();
         purchase.setPadding(new Insets(10,2,2,5));
         purchase.setVgap(5);
         purchase.setMinSize(270,400);
         purchase.setMaxSize(270,400);
         
         
         Label purchasePaneLabel = new Label("\tPurchase Information");
            purchasePaneLabel.setFont(Font.font("Copperplate Gothic Light", FontPosture.REGULAR, 16));
            purchasePaneLabel.setAlignment(Pos.CENTER);
         purchase.add(purchasePaneLabel,0,1,2,1);
         
         Label lblPianoType = new Label("Enter Piano Type: ");
         String[] PianoList = {"Grand Piano", "Upright Piano", "Player Piano", "Keyboard", "Pump Organ", "Headphones"}; 
         ComboBox <String> pianos = new ComboBox<>();
         pianos.getItems().addAll(PianoList);
         purchase.addRow(2,lblPianoType,pianos);
         
         Label lblPianoQuantity = new Label("Quantity: ");
         TextField quantity = new TextField("0");
         quantity.setTooltip(new Tooltip("Enter a quantity between 1 and 20. Enter item amounts in excess of 20 as another purchase."));
         quantity.setMaxWidth(25);
         purchase.addRow(3,lblPianoQuantity,quantity);
         
         CheckBox ship = new CheckBox();
         Label lblShip = new Label("Shipping", ship);
         ship.setTooltip(new Tooltip("Will ship entire order when 'finalize purchase' is selected"));
         
         CheckBox install = new CheckBox(); 
         Label lblInstall = new Label("Installation", install);
         install.setTooltip(new Tooltip("Will install entire order when 'finalize purchase' is selected"));
         
         purchase.add(lblShip,0,4);
         purchase.add(lblInstall,1,4);
         
         TextArea runningInvoice = new TextArea();
         runningInvoice.setStyle(
                  	"-fx-background-color:gainsboro;"+
                  	"-fx-border-color:gray;"+
                  	"-fx-border-weight:1;");
         runningInvoice.setMaxWidth(280);
         
         runningInvoice.setEditable(false);
         purchase.add(runningInvoice,0,5,2,1);
         
         Button enterPurchase = new Button("Enter Purchase");
         enterPurchase.setTooltip(new Tooltip("Submit information"));
         Button deletePurchase = new Button("Clear Invoice");
         deletePurchase.setTooltip(new Tooltip("Clicking here will clear the entire invoice."));
         
         CheckBox btnPrintReciept = new CheckBox();
         Label lblPrintInvoice = new Label("Print - out reciept? ", btnPrintReciept);
         btnPrintReciept.setTooltip(new Tooltip("If this is selected when you click 'finalize purchase', you will receive a printed receipt."));
         
         Button finalizePurchase = new Button("Finish Order");
         finalizePurchase.setTooltip(new Tooltip("Click here to complete your full order."));
         purchase.addRow(6, enterPurchase, deletePurchase);
         purchase.addRow(7, lblPrintInvoice, finalizePurchase);
         
         TextArea printReceiptInstructions = new TextArea("");
         printReceiptInstructions.setPrefWidth(280);
         printReceiptInstructions.setPrefHeight(5);
         printReceiptInstructions.setDisable(true);
         
         buyPiano.getChildren().add(purchase);
         buyPiano.getChildren().add(printReceiptInstructions);

         Image backimage = new Image("background.png"); 
         BackgroundImage backgroundimage = new BackgroundImage(backimage,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                             new BackgroundSize(1.0, 1.0, true, true, false, false)); 
  
         StackPane coverEverything = new StackPane();
                      

         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
         
         organizeAllOne.add(leftPane,0,1);
         organizeAllOne.add(displaySelection,1,1);
         organizeAllOne.add(buyPiano,2,1); 
         organizeAllOne.setPadding(new Insets(5,5,5,5));
         organizeAllOne.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                          + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                          + "-fx-border-radius: 5;" + "-fx-border-color: black;");
         
         Background background = new Background(backgroundimage); 
         organizeAllOne.setBackground(background);
         
         
         coverEverything.getChildren().add(organizeAllOne);
         
         Scene scene = new Scene(coverEverything,1050,500); 

         
         scene.getStylesheets().add("PianoCSS.css");
         
         primaryStage.setScene(scene); 
         primaryStage.getIcons().add(new Image("file:Favicon.png"));  
         primaryStage.show(); 
         
         btnPrintReciept.setDisable(true);
         ship.setDisable(true);
         install.setDisable(true);
         deletePurchase.setDisable(true);
         enterPurchase.setDisable(true);
         finalizePurchase.setDisable(true);
    
    PrintedReceipt invoiceOne = new PrintedReceipt();
    DecimalFormat dec = new DecimalFormat("#,###,##0.00");
   
    submit.setOnAction(e-> 
                              {
                                 fldFirstName.setStyle("-fx-border-color:gray");
                                 fldLastName.setStyle("-fx-border-color:gray");
                                 fldPhoneNumber.setStyle("-fx-border-color:gray");
                                 if(fldFirstName.getText().matches("[A-Za-z\\s]+")==false)                                 
                                 {
                                    fldFirstName.setStyle("-fx-border-color:red;");
                                    welcomeMessage.setText("Enter a non-numerical first name.");
                                 }
                                 
                                 else if(fldLastName.getText().matches("[A-Za-z\\s]+")==false)                                 
                                  {
                                     welcomeMessage.setText("Enter a non-numerical last name.");
                                     fldLastName.setStyle("-fx-border-color:red;");
                                  }
                                 else if(fldPhoneNumber.getText().matches("[0-9\\s]+")==false||fldPhoneNumber.getText().length()!=10)
                                  {
                                     System.out.print(fldPhoneNumber.getText().getClass().getSimpleName());
                                     fldPhoneNumber.setStyle("-fx-border-color:red;");
                                     welcomeMessage.setText("Enter a ten-digit numerical phone number.");
                                  }
                                  else
                                  {
                                     welcomeMessage.setText("Welcome  "+ fldFirstName.getText()+ " " + fldLastName.getText()+ ". Enter purchase information to the right.");
                                     Customer aCustomer = new Customer(fldFirstName.getText()+" "+ fldLastName.getText(), fldPhoneNumber.getText(), fldAddress.getText(), distances.getValue());
                                     invoiceOne.setCustomer(aCustomer);
                                     btnPrintReciept.setDisable(false);
                                     ship.setDisable(false);
                                     install.setDisable(false);
                                     deletePurchase.setDisable(false);
                                     enterPurchase.setDisable(false);
                                     finalizePurchase.setDisable(false);
                                     submit.setDisable(true);
                                     fldFirstName.setDisable(true);
                                     fldLastName.setDisable(true);
                                     fldPhoneNumber.setDisable(true);
                                     fldAddress.setDisable(true);
                                     distances.setDisable(true);
                                  }
                              });
                          
    enterPurchase.setOnAction(e->
                              {
                                 quantity.setStyle("-fx-border-color:gray;");
                                 printReceiptInstructions.setText("");
                                 if(quantity.getText().matches("[A-Za-z//s]+")||Integer.parseInt(quantity.getText())<=0||Integer.parseInt(quantity.getText())>20)
                                 {
                                    printReceiptInstructions.setText("Enter a numerical quantity between 1 and 20");
                                    quantity.setStyle("-fx-border-color:red;");
                                 }
                                 else
                                 {
                                    Piano aPiano = new Piano(pianos.getValue(), Integer.parseInt(quantity.getText()));
                                    invoiceOne.add(aPiano);
                                    invoiceOne.calculatePurchasePrice();
                                    runningInvoice.setText(invoiceOne.getRunningInvoice()+"\n"+"Running Total: $"+ dec.format(invoiceOne.calculateTotalAmountDue()));
                                    quantity.setText("0");
                                 }
                                 
                              });
                              
    deletePurchase.setOnAction(e->
                              {
                                 invoiceOne.clearInvoice();
                                 runningInvoice.setText("");
                              }); 
                              
    
    finalizePurchase.setOnAction(e->
                              {
                                 double totalBeforeFees=0, finalAmountDue=0;

                                 if (btnPrintReciept.isSelected()==true)
                                 {
                                       printReceiptInstructions.setText("Find your receipt in the output file.");
                                       invoiceOne.createFile(ship.isSelected(), install.isSelected());
                                       totalBeforeFees += invoiceOne.calculateTotalAmountDue();
                                       finalAmountDue+=totalBeforeFees;
                                       runningInvoice.setText(invoiceOne.finalOnScreenInvoice()+"\n"+"Total before fees: $"+ totalBeforeFees);
                                 }
                                 
                                 if(ship.isSelected()==true)
                                 {
                                    runningInvoice.appendText(invoiceOne.calculateShippingFees());
                                    finalAmountDue+=invoiceOne.getShippingFees();
                                 }
                                 if(install.isSelected()==true)
                                 {
                                    runningInvoice.appendText(invoiceOne.calculateInstallationFees());
                                    finalAmountDue+=invoiceOne.getInstallationFees();
                                 }
   
                                 runningInvoice.appendText("\n-----------------\nTotal Amount Due: $"+dec.format(finalAmountDue));

                                 btnPrintReciept.setDisable(true);
                                 ship.setDisable(true);
                                 install.setDisable(true);
                                 deletePurchase.setDisable(true);
                                 enterPurchase.setDisable(true);
                                 finalizePurchase.setDisable(true);
                                 
                              });
        
    // _____________________________________________________________________________          
    // ---------------------------TEST PIANO----------------------------------------
        
         Pane paneTwo = new Pane();
         Scene scene2 = new Scene(paneTwo);
         
         Label pianoHeader = new Label("Use the keys on the top row of letters on your computer keyboard (Starting with Q up until PgUp to control the piano.");
         HBox keyboardPicture = new HBox(-15);

         ImageView firstOctView = new ImageView(new Image("piano.png"));
         ImageView secondOctView = new ImageView(new Image("piano.png"));
         
         Label lblfirstOct = new Label(" ", firstOctView);
         Label lblsecondOct = new Label(" ", secondOctView);
               firstOctView.setX(0); 
               firstOctView.setY(20);  
               firstOctView.setFitHeight(400); 
               firstOctView.setFitWidth(400);         
               firstOctView.setPreserveRatio(true); 
               secondOctView.setFitHeight(400); 
               secondOctView.setFitWidth(400);         
               secondOctView.setPreserveRatio(true);
          
         keyboardPicture.getChildren().addAll(lblfirstOct, lblsecondOct);
         
         HBox paneForButtons = new HBox(20);
               Button c = new Button("  C  ");
               Button d = new Button("  D  ");
               Button eNote = new Button("  E  ");
               Button f = new Button("  F  ");
               Button g = new Button("  G  ");
               Button a = new Button("  A  ");
               Button b = new Button("  B  ");
               Button c2 = new Button("  C  ");
               Button d2 = new Button("  D  ");
               Button eNote2 = new Button("  E  ");
               Button f2 = new Button("  F  ");
               Button g2 = new Button("  G  ");
               Button a2 = new Button("  A  ");
               Button b2 = new Button("  B  ");
         
         paneForButtons.setPadding(new Insets(5,5,5,5));
         Button[] buttonArray = {c,d,eNote,f,g,a,b,c2,d2,eNote2,f2,g2,a2,b2};
         paneForButtons.getChildren().addAll(c,d,eNote,f,g,a,b,c2,d2,eNote2,f2,g2,a2,b2);
         
         HBox changePianoType = new HBox(20);
         
            ToggleGroup pianoTypes = new ToggleGroup(); 
               RadioButton grand = new RadioButton("Grand Piano");
               RadioButton saloon = new RadioButton("Upright (Saloon) Piano");
               RadioButton organ = new RadioButton("Pump Organ");
               RadioButton keyboard = new RadioButton("Keyboard");
               RadioButton player = new RadioButton("Player Piano");
               Button returnToStore = new Button("Return to the Store");      
               grand.setToggleGroup(pianoTypes);
               saloon.setToggleGroup(pianoTypes);
               organ.setToggleGroup(pianoTypes);
               keyboard.setToggleGroup(pianoTypes);
               player.setToggleGroup(pianoTypes);
         
         changePianoType.getChildren().addAll(grand, saloon, organ, keyboard, player, returnToStore);

        GridPane grid = new GridPane();
           grid.addRow(1, keyboardPicture);
           grid.addRow(3, paneForButtons);
           grid.addRow(4, pianoHeader);
           grid.addRow(5, changePianoType);
        
        grid.setMinSize(300, 200);

        grid.setStyle("-fx-padding: 10;" +
                      "-fx-border-style: solid inside;" +
                      "-fx-border-width: 10;" +
                      "-fx-border-inset: 25;" +
                      "-fx-border-radius: 8;" +
                      "-fx-border-color: black;"    );
        
        paneTwo.getChildren().add(grid);
        
        StackPane playerPianoPane = new StackPane();
           ImageView playerPianoSign = new ImageView(new Image("playPianoSign.jpg"));
              playerPianoSign.setFitWidth(850); 
              playerPianoSign.setFitHeight(370);
              playerPianoPane.getChildren().add(playerPianoSign); 
           ImageView playerPianoImage = new ImageView(new Image("playerPiano.gif"));
              playerPianoImage.setFitHeight(250);         
              playerPianoImage.setPreserveRatio(true);
              playerPianoPane.getChildren().add(playerPianoImage);
                     

        StackPane.setAlignment(playerPianoImage, Pos.BOTTOM_CENTER);
     
         MediaPlayer grandPiano = new MediaPlayer(new Media(GRANDPIANO_URL));         
         MediaPlayer playerPiano = new MediaPlayer(new Media(MEDIA_URL));    
         MediaPlayer playKeyboard = new MediaPlayer(new Media(KEYBOARD_URL));  
         MediaPlayer playOrgan = new MediaPlayer(new Media(ORGAN_URL)); 
         MediaPlayer playSaloon = new MediaPlayer(new Media(SALOON_URL));
         
         grand.setOnAction(e->{
                 playPiano(scene2, buttonArray, grandPiano);
                 paneTwo.getChildren().remove(playerPianoPane);
                 playerPiano.stop();
                 });
                 
         saloon.setOnAction(e->{
                 playPiano(scene2, buttonArray, playSaloon);
                 paneTwo.getChildren().remove(playerPianoPane);
                 playerPiano.stop();
                 });
                 
         organ.setOnAction(e->{
                 playPiano(scene2, buttonArray, playOrgan);
                 paneTwo.getChildren().remove(playerPianoPane);
                 playerPiano.stop();
                 });
                 
         keyboard.setOnAction(e->{
                 playPiano(scene2, buttonArray, playKeyboard);
                 paneTwo.getChildren().remove(playerPianoPane);
                 playerPiano.stop();
                 });
                 
         player.setOnAction(e->{
                 paneTwo.getChildren().add(playerPianoPane);
                 playerPiano.play();
            });
    
        returnToStore.setOnAction(e->{
                                 primaryStage.setScene(scene);
                                 playerPiano.stop();
                                     });   
        switchToPiano.setOnAction(e->primaryStage.setScene(scene2));
    }
    
    public static void main(String[] args) throws java.io.IOException
    {    
        launch(args);
    } 

    public static void playPiano(Scene scene2, Button[]buttonArray, MediaPlayer mp)
    {
         KeyCode[] inputKey = {KeyCode.Q, KeyCode.W, KeyCode.E, KeyCode.R, KeyCode.T, KeyCode.Y, KeyCode.U, KeyCode.I, KeyCode.O, KeyCode.P, KeyCode.OPEN_BRACKET, KeyCode.CLOSE_BRACKET,KeyCode.BACK_SLASH, KeyCode.PAGE_UP};
         
         scene2.setOnKeyPressed(e -> 
         { 
              for(int x = 0; x<14; x++)
              {
                  if(e.getCode().equals(inputKey[x]))
                  {
                     mp.seek(Duration.seconds(x));
                     mp.setStopTime(Duration.seconds(x+1));
                     mp.play();
                     buttonArray[x].setStyle("-fx-background-color: green; ");
                     break;
                  }
              }  
         });
        
        scene2.setOnKeyReleased(e -> 
        {
             for(int x = 0; x<14; x++)
                buttonArray[x].setStyle("-fx-background-color: white; ");
        });
    }
}