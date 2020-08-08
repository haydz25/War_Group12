/*
 * Suit.java
 * Author: Haydyn Barreto
 * Date: 08/08/2020
 *
 * Description:
 * This enumeration creates an Enum type for a card Suit
 */
package ca.sheridancollege.project;


public enum Suit
{
   //Initiate Enum constants using the private constructor
   SPADES("Spades"),
   DIAMONDS("Diamonds"),
   CLUBS("Clubs"),
   HEARTS("Hearts");

   // data members for this Enum
   private final String suitName;

   /**
    * Constructor for initiating a Suit
    * using suitName.
    *
    * @param suitName - The Suit name
    */
   private Suit (String suitName)
   {
      this.suitName = suitName;
   }

   /**
    * Accessor for getting the suit name.
    *
    * @return - suit name from the available suits
    */
   public String getSuit ()
   {
      return suitName;
   }
}
