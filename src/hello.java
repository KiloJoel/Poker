import java.util.ArrayList;

public class hello {
    
    public static void main(String []args) {

        ArrayList<Hand> hands = new ArrayList<>();
        hands.add(new Hand());
        hands.add(new Hand());
        Deck deck = new Deck();

        /*hands.get(0).addCard(new Card(12, 1));
        hands.get(0).addCard(new Card(11, 1));
        hands.get(0).addCard(new Card(10, 1));
        hands.get(0).addCard(new Card(9, 1));
        hands.get(0).addCard(new Card(8, 1));

        hands.get(1).addCard(new Card(12, 0));
        hands.get(1).addCard(new Card(11, 0));
        hands.get(1).addCard(new Card(10, 0));
        hands.get(1).addCard(new Card(9, 0));
        hands.get(1).addCard(new Card(8, 0));*/

        for (Hand h: hands) {
            for (int i = 0; i < 5; i++) {
                Card card = deck.dealCard();
                if (!h.addCard(card)){
                    deck.replaceCard(card);
                }
            }
        }

        hands.get(0).describe_hand();
        hands.get(1).describe_hand();

        System.out.println(compareHands(hands.get(0), hands.get(1)));
    }

    private static String compareHands(Hand h1, Hand h2){
        int check1 = h1.checkHand();
        int check2 = h2.checkHand();
        if (check1 == check2)
        {
            ArrayList<Integer> high1 = h1.getHighCard();
            ArrayList<Integer> high2 = h2.getHighCard();
            int i = 1;
            while (i <= high1.size() && i <= high2.size()) {
                int difference = high1.get(high1.size() - i) - high2.get(high2.size() - i);
                if (difference > 0)
                {
                    return "Hand 1 wins!";
                } else if (difference < 0) {
                    return "Hand 2 wins!";
                }
                i++;
            }
            return "It's a draw!";
        } else if (check1 > check2){
            return "Hand 1 wins!";
        } else {
            return "Hand 2 wins!";
        }
    }

}