/*
 * War.java
 * Author: Haydyn Barrero
 * Date: 08/08/2020
 *
 * Description:
 * This program asks user to enter values and
 * it validates each input before it executes the entier program.
 */
package ca.sheridancollege.project;
import java.util.Scanner;

public class War
{
   /**
    * The main method for this application.
    *
    * @param args - the array of string arguments passed.
    */
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);

      int option;

      do {
         displayMenu();
         option = validateInp(input, (String) "Enter an option: ");
         switch (option) {
            case 1:
               playGame();
               break;
         }
      }
      while (option != 0);
   }

   /**
    * Method for validating all the user inputs
    *
    * @param input - The input received from the user
    * @param text - The String to notify user to input data
    * @return - The option, after validating the input
    */
   public static int validateInp (Scanner input, String text)
   {
      int option;
      do {
         System.out.print(text);
         while (!input.hasNextInt()) {
            System.out.println("\nInvalid input.");
            System.out.print(text);
            input.next();
         }

         option = input.nextInt();
         if (option > 1 || 0 > option) {
            System.out.println("\nOption must be in the range of the menu.");
         }
      }
      while (option > 1 || 0 > option);
      return option;
   }

   /**
    * Method for displaying menu options
    */
   public static void displayMenu ()
   {
      System.out.println("Welcome to WAR - The card game");
      System.out.println("A game by Group 12");
      System.out.println("----------------------------------------------------------------------------");
      System.out.println("1. Play Game");
      System.out.println("0. Quit");
      System.out.println("----------------------------------------------------------------------------- \n");
   }

   /**
    * Method that begins the game.
    * It takes in user input after every round.
    * It generates, shuffles and deals cards
    */
   private static void playGame ()
   {
      // Two hands and a deck are created.
      Deck deck1 = new Deck();
      Hand hand1, hand2;
      hand1 = new Hand();
      hand2 = new Hand();

      int option;
      String gameOption = "Enter (1) to draw another card, press (0) to "
          + "return to the menu: ";

      Scanner input = new Scanner(System.in);

      // hands are stored in an array: hands.
      Hand[] hands = {hand1, hand2};

      // Deck cards are generated and shuffled.
      deck1.generate();
      // Deck cards are shuffled
      deck1.shuffle();

      do {
         // Card is dealt to each hand.
         deck1.dealCard(hands);

         // Each single card dealt is printed.
         System.out.print("Your card: ");
         System.out.println(hand1.showCard());

         System.out.print("Computer's card: ");
         System.out.println(hand2.showCard());

         // Hands are compared and result is returned.
         Hand compare = deck1.compareCards(hands);

         // Result is printed
         if (compare != null) {
            if (compare == hand1) {
               System.out.println("Your card is higher! The computer "
                   + "gives you it's card\n");
               hand2.giveCard(hand2.topCard(), hand1);
            }
            else {
               System.out.println("Computer's card was higher! You give "
                   + "your card to the computer's hand.\n");
               hand1.giveCard(hand1.topCard(), hand2);
            }
         }
         else {
            System.out.println("Both cards were a match, you both keep your"
                + " cards.\n");
         }

         // User is asked whether to continue or quit the game.
         option = validateInp(input, gameOption);

         if (option == 0) {
            break;
         }
         else if (deck1.cards.isEmpty()) {
            System.out.println("There are no more cards in the deck.");
         }
         // End game.
      }
      while (!deck1.cards.isEmpty());

      // Player's points are printed.
      System.out.println("\nYou had " + hand1.getPoints() + " points.");
      System.out.println("Computer had " + hand2.getPoints() + " points.\n");

      // A comparison of player's scores is printed.
      if (hand1.getPoints() == hand2.getPoints()) {
         System.out.println("The game was a draw.\n");
      }
      else if (hand1.getPoints() > hand2.getPoints()) {
         System.out.println("You won!\n");
      }
      else {
         System.out.println("The computer won. Better luck next time.\n");
      }

      // Hands and deck are cleared.
      hand1.cards.clear();
      hand2.cards.clear();
      deck1.cards.clear();
   }
}
