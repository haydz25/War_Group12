/*
 * Program By Group 12
 *
 * Hand.java
 * Author: Haydyn Barrero
 * Date: 08/08/2020
 *
 * Description
 * [Description about the class]
 */
package ca.sheridancollege.project;
import java.util.ArrayList;

public class Hand
{
   //Declaring of the array list.
   public ArrayList<Card> cards;

   /**
    * Constructor for initiating the ArryList.
    */
   public Hand ()
   {
      cards = new ArrayList<>();
   }

   /**
    * Method adding a card to the hand.
    *
    * @param card - The instance of a card.
    */
   public void addCard (Card card)
   {
      cards.add(card);
   }

   /**
    * Method for clearing all cards from a hand.
    */
   public void clear ()
   {
      cards.clear();
   }

   /**
    * Method to return the
    * top card of the hand as a String.
    *
    * @return String top card.
    */
   public String showCard ()
   {
      return (String) topCard().displayCard();
   }

   /**
    * Method to return the
    * top Card of the hand.
    *
    * @return - Card top Card.
    */
   public Card topCard ()
   {
      return cards.get(cards.size() - 1);
   }

   /**
    * Method to give a single card to another hand.
    *
    * @param card - A card.
    * @param playerHand - A hand.
    * @return - Status using boolean value
    */
   public boolean giveCard (Card card, Hand playerHand)
   {
      if (!cards.contains(card)) {
         return false;
      }
      else {
         cards.remove(card);
         playerHand.addCard(card);
         return true;
      }
   }

   /**
    * Method for returning the
    * number of points in a hand.
    * 1 card = 1 point.
    *
    * @return - The points.
    */
   public int getPoints ()
   {
      return cards.size();
   }

   /**
    * Method for comparing the players hands
    * and returning the winning hand.
    *
    * @param hands - The array of Hand[].
    * @return - The Hand highest winning hand.
    */
   public Hand compareCards (Hand[] hands)
   {
      int highestRank = 0;
      Hand highestHand = null;
      for (Hand hand : hands) {
         if (hand.topCard().getRank() > highestRank) {
            highestRank = hand.topCard().getRank();
            highestHand = hand;
         }
         else if (hand.topCard().getRank() == highestRank) {
            highestHand = null;
         }
      }
      return highestHand;
   }
}
