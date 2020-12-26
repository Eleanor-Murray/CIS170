# Piano-Store
Eleanor Murray
Murray's Music: Piano Store Program
____________________________________

------------
DESCRIPTION:
------------
	Murray's Music simulates a piano store.  The customer is presented with an interactive pane in which they may make piano purchases.  
The customer will first input personal data, including their name, phone number, address, and approximate distance from the store (used for calculating shipping charges).  
After the user inputs their data, they may refer to the display of items and corresponding prices located in the center of their screen when deciding their purchase(s).  
When they decide to make a purchase, they select the item and the quantity they would like to purchase.  In addition, they can elect to have their entire purchase order shipped and installed for additional fees.  Their shipping charges will vary based on approximate distance from the store, the installation fees vary based on price and quantity of items (to account for installation burden).  If the customer would like to have a printed receipt, they select the “Print-out receipt” checkbox.  When the user has entered their purchase, they press the “enter purchase” button, which will add their purchase to their invoice. The customer may refer to the area located below the purchase section to find a gradual invoice system where they may see each line appear as they make their purchase.  Therefore, if the customer finds a purchase error, they may select the “Clear Invoice” button, which will clear their entire invoice.  
When the user is completed entering their purchases, they select the “Finish Order” button, which will complete their order.  
At this time, if the customer had selected the “Print-out receipt” checkbox, a file containing their completed invoice will be created.
	When deciding their purchase(s), the customer may test out the various pianos available for sale by pressing the “Test Out Pianos” button located at the bottom left of their screen.  This button will take the customer to an interactive piano display hosting two octaves of a piano whose keys interact with the customer’s keyboard to simulate them playing the piano.  Here, the customer may select which piano they would like to test out at the bottom of the screen, where they will find buttons pertaining to each type of piano.  The piano will then produce sound representing their selection.

--------------------------
INCORPORATION OF ELEMENTS:
--------------------------
Five classes are incorporated: piano, customer, invoice, printedReceipt, and main.  
Throughout the program, key concepts including objects and classes, files, exceptions, event driven programming, overriding, inheritance, and graphical user interfaces are utilized.

INHERITANCE:
	+ The printedReceipt class inherits from the invoice class to create an output file of the customer's information and purchases.

FILE INPUT/OUTPUT
	+ The printedReceipt class and Main class utilize file output to create an output file containing the customer's information and purchases organized in invoice format.

EXCEPTION HANDLING:
	+ Exception handling was incorporated in the Printed Reciept class to handle fileNotFound exceptions, as this class is responsible for creating output files.

DATA VALIDATION:
	+ In the PianoStoreMainProgram class, data validation is repeatedly used to handle incorrectly- inputted 
	customer and purchase information.  For instance, data validation was used to catch numerical customer first
	and last name values, alpha character(s) inputted as a phone number.  In addition, data validation was used
	in the purchase information panel to catch alpha character(s) inputted for quantity and quantities less than
	or equal to zero or over twenty. 

OVERRIDING:
	+ The Piano class and Customer class both override the built - in toString() method.

POLYMORPHISM:
	+ After determining which piano type radio button was selected in the PianoStoreMainProgram class, and the sending the appropriate media file was sent to the playPiano() function which utilized polymorphism to determine the correct media file to play and therefore represent the correct piano sounds. 

EVENT DRIVEN PROGRAMMING:
	+ The main class utilizes event driven programming to create an interactive store simulation. KeyEvents and setOnAction Events are repeatedly incorporated to check whether buttons, checkboxes, and choice boxes are selected to determine when data validation needs to occur, when a purchase shall be added to 	the invoice, which fees to include, and whether a printed reciept is necessary. 

CLASSES AND OBJECTS:
	+ The piano store program includes five classes: piano, customer, invoice, printedReceipt, and main.
	Objects of each class are utilized to store customer data, piano data, invoice data, and printed invoice contents. 
	The various classes contain methods to calculate invoice items, organize data, calculate fees, alter the on-screen gradual invoice system, create files, and format the customer invoice. 
	Both default and non-default constructors are used across the classes.

ARRAYS:
	+ The Invoice class utilizes two parallel array lists to store customer purchases and the total costs for each purchase, as well as an arrays to store shipping fees to represent each distance
	option.
	+ The Piano class incorporates a single - dimensional array which contians piano prices corresponding to the 	various pianos available for sale.

GRAPHICAL USER INTERFACE:
	+ The graphical user interface presented in the main class allows the user to input their customer information, displays the products available for sale and corresponding prices, 
and contains input fields necessary for the customer to make their purchases and designate their shipping/installation needs.  The main class also contains a feature for the customer to test 
out the varying types of pianos with their computer keyboard.  The customer may select which piano they would like to test out at the bottom of the screen, and the piano will then produce 
sound representing their selection. To do this, multimedia files will be used which contain the key sounds for each type of piano (one media file containing two octaves worth of key sounds for 
each type of piano) Through key events, the keyboard will omit the corresponding key sound and highlight the particular key pressed.  
	
----------------------
OTHER TOPICS LEARNED:
----------------------

MULTIMEDIA:
	+ To demonstrate a working piano, I recorded individual notes from my keyboard in four different types of piano sounds, used a video editing tool to produce four different mp3 files containing two octaves worth of notes in each sound which are exactly one second apart. In a method, I then made an array containing keycodes for the computer keyboard keys in order, and used a loop to identify which key was pressed and play the mp3 file at the duration of the keypress's position for exactly one second. The main program stored the different files for each sound, and passes through the corresponding file to the method, which uses polymorphism, and thence the appropriate sound and note is played. Please play the piano slowly one key at a time.

OTHER EVENTS:
	+ enabled user to switch to and return back to a scene with a button
	+ disable buttons until appropriate customer information is entered, disabled areas to disallow the user to edit / delete invoice data or alter information after it has been processed.

STYLING:
	+ Wrote a CSS Stylesheet to format scenes, panes, buttons, text areas, text fields, comboboxes, and tooltips.
	+ Created an application icon on the main screen.
	+ researched the DecimalFormat.format() method to professionally style the on-screen and file invoices
	
TOOLTIPS:
	+ Researched and incorporated tooltips to aid the user through the purchase process. These enable the customer to receive further instruction when hovering over an area of interest on the display.

DATA VALIDATION:
	+ Researched the use of matches() regrex for data validation to determine whether text field values were alpha character or of numerical value.

--------
CREDITS:
--------
- Player Piano Song: Maple Leaf Rag by Kevin MacLeod Link: https://incompetech.filmmusic.io/song/5762-maple-leaf-rag  License: http://creativecommons.org/licenses/by/4.0/ 
