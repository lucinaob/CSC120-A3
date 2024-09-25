import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Conversation {

  /* Strings that store ChatBot output */
  private static String RSOut; //Output with switched pronouns
  private static String NBOut; //Output of canned responses

  /**
   * Constructor
   * Spits out a random canned response to user input
   * @return Random response to be added to transcript
   */
  static String NothingBrain(){ 
    Random rand = new Random();
    int number = rand.nextInt(10);
    if (number == 1){
      NBOut = "Wow! That's so cool. Tell me more!"; // Canned response
      System.out.println(NBOut); // Printing canned response
      return NBOut; //Returning canned response to be added to transcript
      // Above comments apply to every if condition in this constructor
    } else if (number == 2){
      NBOut = "I'd never heard of that, because I'm a robot. Help me understand!";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 3){
      NBOut = "This is crazy. Keep going.";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 4){
      NBOut = "I can't believe this. You're a riveting story teller. Tell me more.";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 5){
      NBOut = "Go on.";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 6) {
      NBOut = "Understood. Tell me more!";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 7) {
      NBOut = "No one else has ever told me this. Go on, please!";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 8) {
      NBOut = "Say more!";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 9) {
      NBOut = "This is enlightening. Go on!";
      System.out.println(NBOut);
      return NBOut;
    } else if (number == 10) {
      NBOut = "Tell me more!";
      System.out.println(NBOut);
      return NBOut;
    }
    return NBOut;
  }

  
  /**
   * Constructor
   * @param topic - User input in response to "What are you thinking about today"
   * @return User's answer, with relevant words switched, made into a question, and "Tell me more!" added
   */
  static String RepeatSwitch(String topic){
    String punctuation = topic.replaceAll("." + "!", ""); //ERROR HERE //Takes out any punctuation in the user's input
    if (punctuation.contains("I'm")){ 
      String replaced = punctuation.replace("I'm", "You're"); //Switches pronoun
      String RSOut = replaced + "? Tell me more!"; //Turns statement into question and prompt
      System.out.println(RSOut); //Prints question/prompt
      return RSOut; //Returns text to be added to transcript
      //Following conditionals do this same process for different inputs
    } else if (punctuation.contains("I am")) {
      String replaced = punctuation.replace("I am", "You are");
      String RSOut = replaced + "? Tell me more!";
      System.out.println(RSOut);
      return RSOut;
    } else if (!punctuation.contains("I'm") && !punctuation.contains("I am")){
      String RSOut = "You're thinking about " + punctuation + "? Tell me more!";
      System.out.println(RSOut);
      return RSOut;
    }
    return RSOut;
  }
    public static void main(String[] arguments) {
    ArrayList<String> transcript = new ArrayList<>(); //Creates an empty array for the transcript
    System.out.println("How many rounds would you like to play today?: "); //Prompts user for set number of rounds
    Scanner input = new Scanner(System.in); //Creates new scanner
    int rounds = input.nextInt(); //Takes in answer to question in line 92
    input.nextLine(); //Fixes bug in scanner
    for (int i = 0; i < rounds; i++){ //Sets ChatBot to run for number of lines inputted
      if (i == 0){ //Initial round
        String greeting = "Hello! What are you thinking about today?"; //Prompts user to start discussion
        transcript.add(greeting); // Adds above to transcript
        System.out.println(greeting); //Prints above
      }
      else if (i == 1) { //Second round
        String topic = input.nextLine(); //Takes in the topic the user is thinking about
        transcript.add(topic); //Adds user input to transcript
        transcript.add(RepeatSwitch(topic)); //Puts user input through RepeatSwitch and adds this output to the transcript
        String response = input.nextLine(); //Takes user response to RepeatSwitch output
        transcript.add(response); //Adds above response to transcript
      }
      else if (i >= 2 && i < rounds-1) { //Following rounds
        transcript.add(NothingBrain()); //Calls canned response and adds to transcript
        String response = input.nextLine(); //Takes user response to canned response
        transcript.add(response); //Adds user response to transcript
      } else if (i == rounds-1){ //Final round
        String goodbye = "That's so interesting. Thank you for telling me about this."; //Exit message
        transcript.add(goodbye); //Adds exit message to transcript
        System.out.println(goodbye); //Prints exit message
      }
    }
    System.out.println("Have a nice day!"); 
    System.out.println("Below is the transcript of this conversation");
    System.out.println("\nTRANSCRIPT:");
    for (String message: transcript){ //Prints each line of the transcript as it's own line, rather than in a single row
      System.out.println(message);
    }
    input.close();
  }
}
