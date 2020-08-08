/*
 * Program By Group 12
 *
 * Deck.java
 * Author: Haydyn Barrero
 * Date: 08/08/2020
 *
 * Description:
 * This Deck class extends Hand class.
 * It creates 52 cards and stores it in the ArrayList cards.
 */
package ca.sheridancollege.project;
import java.util.Random;

public class Deck extends Hand
{
   Random rand = new Random();

   /**
    * Method for generating 52 cards and
    * storing it in an ArrayList.
    */
   public void generate ()
   {
      for (Suit suit : Suit.values()) {
         for (Rank rank : Rank.values()) {
            Card card = new Card(rank, suit);
            this.addCard(card);
         }
      }
   }

   /**
    * Method for shuffling an ArrayList of cards.
    */
   public void shuffle ()
   {
      for (int i = cards.size() - 1; i > 0; i--) {
         int position = rand.nextInt(i);
         Card selectCard = cards.get(i);
         cards.set(i, cards.get(position));
         cards.set(position, selectCard);
      }
   }

   /**
    * Method for dealing / giving
    * a card to a hand.
    *
    * @param hand The single instance of hand
    */
   public void dealCard (Hand hand)
   {
      this.giveCard(cards.get(0), hand);
   }

   /**
    * Method for giving a card to many hands Hand[]
    *
    * @param hands - The array instance of a hand
    */
   public void dealCard (Hand[] hands)
   {
      for (Hand hand : hands) {
         this.dealCard(hand);
      }
   }
}
