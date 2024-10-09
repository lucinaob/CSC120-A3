import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Conversation {

  /* Strings that store ChatBot output */
  private static String RSOut; //Output with switched pronouns
  private static String CROut; //Output of canned responses
  //Canned responses the bot can respond with
  private static String[] responses = {
    "Wow! That's so cool. Tell me more!", 
    "I'd never heard of that, because I'm a robot. Help me understand!",
    "This is crazy. Keep going.", 
    "I can't believe this. You're a riveting story teller. Tell me more.",
    "Go on.",
    "Understood. Tell me more!",
    "No one else has ever told me this. Go on, please!",
    "Say more!",
    "This is enlightening. Go on!",
    "Tell me more!"};

  /**
   * Canned response method
   * Spits out a random canned response to user input
   * @return Random response to be added to transcript
   */
  static String cannedResponse(){ 
    Random rand = new Random(); //Generates random number of # of responses
    int number = rand.nextInt(10); //Random number between 0 and 10
    CROut = responses[number]; //Grabs the random response from the responses above
    //Prints and returns the canned response
    System.out.println(CROut); 
    return CROut;
  }

  
  /**
   * Method that switches pronouns and other key words inputted by the user
   * @param topic - takes in the topic the user gives
   * @return - the same sentence inputted, but with pronouns switched from first to second person
   */
  static String RepeatSwitch(String topic){
    //Removing punctuation from the user inputted
    if (topic.contains(".")){
      topic = topic.replace(".", "");
    } else if (topic.contains("!")){
      topic = topic.replace("!", "");
    }
    //Splits the user input into individual words
    String [] words = topic.split(" ");
    //For each word,
    for (int i = 0; i < words.length; i++){
      //Replace relevant key words
      if (words[i].equals("me")){
        words[i] = "you";
      } else if (words[i].equals("I")){
        words[i] = "you";
      } else if (words[i].equals("am")){
        words[i] = "are";
      } else if (words[i].equals("you")){
        words[i] = "me";
      } else if (words[i].equals("my")){
        words[i] = "your";
      } else if (words[i].equals("your")){
        words[i] = "my";
      } else if (words[i].equals("I'm")){
        words[i] = "you're";
      } else if (words[i].equals("Im")){
        words[i] = "you're";
      } else if (words[i].equals("im")){
        words[i] = "you're";
      } else if (words[i].equals("i")){
        words[i] = "you";
      }
    }
    //Rejoins words into one sentence
    RSOut = String.join(" ", words);
    //Ensures that the first letter of the sentence is uppercase
    RSOut = RSOut.substring(0, 1).toUpperCase() + RSOut.substring(1);
    //Adds a question to make the conversation flow
    RSOut = RSOut + "? Tell me more!";
    //Prints and returns the sentence
    System.out.println(RSOut);
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
    } else if (i == 1) { //Second round
      String topic = input.nextLine(); //Takes in the topic the user is thinking about
      transcript.add(topic); //Adds user input to transcript
      transcript.add(RepeatSwitch(topic)); //Puts user input through RepeatSwitch and adds this output to the transcript
      String response = input.nextLine(); //Takes user response to RepeatSwitch output
      transcript.add(response); //Adds above response to transcript
    } else if (i >= 2 && i < rounds) { //Following rounds
      transcript.add(cannedResponse()); //Calls canned response and adds to transcript
      String response = input.nextLine(); //Takes user response to canned response
      transcript.add(response); //Adds user response to transcript
    }
  }
  String goodbye = "That's so interesting. Thank you for telling me about this. Have a nice day!"; //Exit message
  transcript.add(goodbye); //Adds exit message to transcript
  System.out.println(goodbye); //Prints exit message
  System.out.println("Below is the transcript of this conversation");
  System.out.println("\nTRANSCRIPT:");
  for (String message: transcript){ //Prints each line of the transcript as it's own line, rather than in a single row
    System.out.println(message);
  }
  input.close();
}
}
