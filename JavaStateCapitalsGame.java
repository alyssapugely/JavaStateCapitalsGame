import java.util.*;

public class Main {
   public static void main (String [] args) {
       /* Creates a 2D array of states (row 0) and their capitals (row 1), alphabetically ordered by state */
       String[][] statesAndCapitals = {
               {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
               {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
       };
       // Displays intro to program
       System.out.println("How well do you know the US state capitals? Let's find out!");
       // Creates scanner object to accept user input
       Scanner scanner = new Scanner(System.in);
       // Prompts the user to enter any state capital
       System.out.print("Enter a capital of any of the 50 states: ");
       // Creates string variable from user input
       String userInput = scanner.nextLine();
       // Initializes boolean variable to begin while loop
       boolean correctCapital = false;
       /* Creates a sub array of the capitals from row 1 of the initial 2D array to check if the user input exists within the sub array */
       String[] capitalCities = statesAndCapitals[1];
       /* Uses a for loop to traverse the sub array and check if a capital city matches the user's input */
       for (String city:capitalCities) {
           /* Compares string from capital array to user input string, ignoring case differences */
           if (city.equalsIgnoreCase(userInput)) {
               correctCapital = true;
               break;}
       }
       /* Informs user they were correct if their input exists within the sub array */
       if (correctCapital) {
           System.out.println("Nice job! " + userInput + " is a US state capital.");
       }
       /* Informs user they were incorrect if their input does not exist within the sub array */
       else
           System.out.println("Nice try, but " + userInput + " is not a US state capital.");
       /* Displays the contents of the initial 2D array of states and their capitals */
       System.out.println("The following shows the current contents of the array of US states and their capitals.");
       /* Uses a for loop to iterate through all elements of each array */
       for (int i = 0; i < 50; i++) {
           /* Displays each state (row 0) and capital (row 1) in the array */
           System.out.println("The capital of " + statesAndCapitals[0][i] + " is " + statesAndCapitals[1][i] + ".");
       }
       // Informs the user a bubble sort will be performed
       System.out.println("I'm now going to perform a bubble sort to alphabetically sort the array by capital, rather than state.");
       /* Performs a bubble sort by iterating through two nested for loops */
       for (int j = 0; j < statesAndCapitals[0].length; j++) {
           for (int i = j + 1; i < statesAndCapitals[0].length; i++) {
               /* Creates temporary variables for capital cities and states */
               String tempCapital;
               String tempState;
               /* If next capital [i] is less than current capital [j], then values are swapped */
               if (statesAndCapitals[1][i].compareTo(statesAndCapitals[1][j]) < 0) {
                   tempCapital = statesAndCapitals[1][j];
                   statesAndCapitals[1][j] = statesAndCapitals[1][i];
                   statesAndCapitals[1][i] = tempCapital;
                   /* Performs same operation on states, so state and capital pairs are maintained within array */
                   tempState = statesAndCapitals[0][j];
                   statesAndCapitals[0][j] = statesAndCapitals[0][i];
                   statesAndCapitals[0][i] = tempState;
               }
           }
       }
       // Prompts the user to enter as many state capitals as they can
       System.out.println("Let's see how many capitals you remember! Don't look at what I just told you ;)");
       System.out.println("Type as many capitals as you can, hitting 'enter' between each.");
       System.out.println("Type 'quit' when you're done.");
       // Initializes boolean variable to begin while loop
       boolean endLoop = false;
       // Creates scanner object to accept user input
       Scanner userInput2 = new Scanner(System.in);
       /* Creates array list to store user's capital guesses, which will be checked for correctness later */
       ArrayList<String> guessList = new ArrayList<>();
       /* Creates while loop to accept user's capital guesses, which are stored in above array list. Loop ends if user types quit */
       while (!endLoop) {
           // Creates string variable from user input
           String capitalGuess = userInput2.nextLine();
           // Loop ends if user types quit, ignoring case
           if (capitalGuess.equalsIgnoreCase("quit")) {
               System.out.println("Let's see how you did.");
               endLoop = true;
           }
           /* If not, adds user's capital guess to the guess list array list */
           else {
               guessList.add(capitalGuess);
           }
       }
       // Creates counter to calculate total correct answers
       int correctAnswers = 0;
       /* Uses nested for loop to iterate through the arrays of user guesses and capital cities. If a user guess matches a capital city, the correct answers counter increases by 1 */
       for (String guess : guessList) {
           for (String city : capitalCities) {
               if (guess.equalsIgnoreCase(city))
                   correctAnswers += 1;
           }
       }
       /* Displays the total count of correct user guesses for capital cities */
       System.out.println(correctAnswers + " out of " + guessList.size() + " total guesses were correct!");
       System.out.println("I'm now going to store the pairs of each state and its capital in a Map using the HashMap function.");
       // Converts 2D array of states and capitals to a Hashmap
       HashMap<String, String> capitalHashMap = new HashMap<>(statesAndCapitals[0].length);
       /* Uses for loop to iterate through all elements of the 2D array,placing state [0] and capital [1] values into the HashMap */
       for (int i = 0; i < statesAndCapitals[0].length; i++) {
           capitalHashMap.put(statesAndCapitals[0][i], statesAndCapitals[1][i]);
       }
       // Displays the contents of the new HashMap
       System.out.println("Here are the contents of the HashMap! The states and their corresponding capitals are not sorted in any particular order because HashMaps are unordered.");
       /* Uses for loop to iterate through all keys (states), to display the key and its corresponding value (capital)*/
       for (String state : capitalHashMap.keySet()) {
           System.out.println("The capital of " + state + " is " + capitalHashMap.get(state) + ".");
       }
       /* Uses the TreeMap class to sort the HashMap. A built-in feature of the TreeMap data structure is using a binary search tree for storage */
       TreeMap<String, String> capitalTreeMap = new TreeMap<>(capitalHashMap);
       /* Prompts the user to input a state, and returns the state's capital */
       System.out.println("Now it's my turn to guess! Enter a state (capitalized please), and I'll tell you what the capital is.");
       System.out.println("Type 'quit' when you're done.");
       // Initialize boolean variable to begin while loop
       endLoop = false;
       while (!endLoop) {
           // Prompts the user to input a state
           System.out.println("Enter a state: ");
           // Creates string variable from user input
           String stateEntry = userInput2.nextLine();
           // Loop ends if user types quit, ignoring case
           if (stateEntry.equalsIgnoreCase("quit")) {
               System.out.println("Goodbye!");
               endLoop = true;
               continue;
           }
           /* If not, check if the user input matches a key (state) in the TreeMap */
           if (capitalTreeMap.containsKey(stateEntry)) {
               /* Displays the corresponding capital of the state the user entered */
               System.out.println("The capital of " + stateEntry + " is " + capitalTreeMap.get(stateEntry) + ".");
           }
           else {
               /* Displays message below if the user types something other than a state or quit */
               System.out.println("I don't recognize that! Try again, or type 'quit' to exit.");
           }
       }
   }
}
