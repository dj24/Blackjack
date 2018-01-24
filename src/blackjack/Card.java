
package blackjack;

import java.util.Comparator;




public class Card implements Comparable<Card>{
    
    enum Suit{
        CLUBS,DIAMONDS,HEARTS,SPADES;
    }

    enum Rank{
        TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),
        NINE(9),TEN(10),JACK(10),QUEEN(10),KING(10),ACE(11);

        private final int value;

        Rank(int value){
            this.value = value;
        }

        int getValue(){
            return value;
        }

        String getName(){
            return this.name();
        }

        public Rank getPrevious() {
        return this.ordinal() < Rank.values().length - 1 ? Rank.values()[this.ordinal()-1] 
        : null;
        }

    }
    private Rank rank;
    private Suit suit;
    
   
    Card(Suit suit, Rank rank) {
      this.suit = suit;
      this.rank = rank;
    }
    
    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }
    
    @Override
    public String toString() { return rank + " of " + suit; }
    
    static int sum(Card a, Card b){
        return a.getRank().getValue() + b.getRank().getValue();
    }
    
    static boolean isBlackJack(Card a, Card b){
        return sum(a,b) == 21;
    }
    
    @Override
    public int compareTo(Card card) {
        return (this.rank.ordinal() - card.rank.ordinal());
    }
    
    public static class RankComparator implements Comparator<Card>{
        public int compare(Card c1, Card c2) {
            return c1.compareTo(c2);
        }
    };

}
