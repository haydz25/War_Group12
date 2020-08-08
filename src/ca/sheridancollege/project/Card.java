/*
 * Card.java
 * Author: Haydyn Barrero
 * Date: 08/08/2020
 *
 * Description:
 * The card class gets the suit and rank of a card
 * and returns a formatted string of the card's
 * rank and suit
 */
package ca.sheridancollege.project;

public class Card
{
   private final Suit suit;
   private final Rank rank;

   /**
    * Constructor for initiating a card
    *
    * @param rank - The Rank available in the enumerator class
    * @param suit - The Suit available in the enumerator class
    */
   public Card (Rank rank, Suit suit)
   {
      this.rank = rank;
      this.suit = suit;
   }

   /**
    * Accessor for getting the Suit of the card
    *
    * @return - The Suit of the Card.
    */
   public String getSuit ()
   {
      return suit.getSuit();
   }

   /**
    * Accessor for getting the Rank of the card
    *
    * @return - The Rank of the Card.
    */
   public int getRank ()
   {
      return rank.getRank();
   }

   /**
    * Method to display the suit and rank of a card
    *
    * @return - The formatted string output of Card's rank and suit.
    */
   public String displayCard ()
   {
      String card = rank.getRank() + " of " + suit.getSuit();
      return card;
   }
}
