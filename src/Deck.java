import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {

    private List<Card> cards = new ArrayList<Card>();

    public List<Card> getCards() {
        return cards;
    }

    protected void shuffle() {
        Collections.shuffle(cards);
    }
    public  int size(){
        return cards.size();
    }


    public ArrayList<Card> dealCards(int numOfDealtCards) {
        ArrayList<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < numOfDealtCards; i++) {
            dealtCards.add(cards.remove(0));
        }
        return dealtCards;
    }

    public Card dealOneCard(){
        return cards.remove(0);
    }
}





