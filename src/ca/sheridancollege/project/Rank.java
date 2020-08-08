/*
 * Program By Group 12
 *
 * Rank.java
 * Author: Haydyn Barreto
 * Date: 08/08/2020
 *
 * Description:
 * This enumeration creates an Enum type for a card Rank
 */
package ca.sheridancollege.project;


public enum Rank
{
   //Initiate Enum constants using the private constructor
   ACE(1),
   TWO(2),
   THREE(3),
   FOUR(4),
   FIVE(5),
   SIX(6),
   SEVEN(7),
   EIGHT(8),
   NINE(9),
   TEN(10),
   JACK(11),
   QUEEN(12),
   KING(13);

   // data members for this Enum
   private final int rankInt;

   /**
    * Constructor for initiating a Rank
    * using rankInt.
    *
    * @param rankInt - The card rank
    */
   private Rank (int rankInt)
   {
      this.rankInt = rankInt;
   }

   /**
    * Accessor for getting the card rank.
    *
    * @return - The rank from the available ranks.
    */
   public int getRank ()
   {
      return rankInt;
   }
}
