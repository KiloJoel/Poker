import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck(){
        setUpDeck();
    }

    private void setUpDeck(){
        for(int number = 0; number < 13; number++){
            for(int suit = 0; suit < 4; suit++){
                cards.add(new Card(number, suit));
            }
        }
        shuffle();
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

    public Card dealCard(){
        if (cards.isEmpty()) {
            setUpDeck();
        }
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public void replaceCard(Card card){
        cards.add(card);
    }
}
