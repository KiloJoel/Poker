import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand
{
    private String[] handDescriptions = { "High card", "Pair", "Two Pair", "Three of a kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

    private Card[] cards = new Card[5];
    private int numberOfCards = 0;

    private ArrayList<Integer> highCard = new ArrayList<>();

    public boolean addCard(Card card){
        if (numberOfCards < 5){
            cards[numberOfCards] = card;
            numberOfCards++;
            return true;
        } else {
            return false;
        }

    }

    public void describe_hand()
    {
        for (int i = 0; i < numberOfCards; i++) {
            System.out.print(" " + cards[i].getCardString());
        }
        System.out.print(" " +  handDescriptions[checkHand()] + "\n");
    }

    public int checkHand(){
        sort();
        int handQuality = 9;
        if (checkRoyalFlush())
            return handQuality;
        handQuality--;
        if (checkStraightFlush())
            return handQuality;
        handQuality--;
        if (checkFourOfAKind())
            return handQuality;
        handQuality--;
        if (checkFullHouse())
            return handQuality;
        handQuality--;
        if (checkFlush())
            return handQuality;
        handQuality--;
        if (checkStraight())
            return handQuality;
        handQuality--;
        if (checkThreeOfAKind())
            return handQuality;
        handQuality--;
        if (checkTwoPair())
            return handQuality;
        handQuality--;
        if (checkPair())
            return handQuality;
        handQuality--;
        checkHighCard();
        return handQuality;
    }

    public ArrayList<Integer> getHighCard(){
        Collections.sort(highCard);
        return highCard;
    }

    private boolean checkRoyalFlush(){
        for (int i = 0; i < 5; i++) {
            if (cards[i].getNumber() < 8){
                return false;
            }
        }
        return checkFlush();
    }

    private boolean checkStraightFlush(){
        return checkFlush() && checkStraight();
    }

    private boolean checkFourOfAKind(){
        return checkPairs() == 6;
    }

    private boolean checkFullHouse(){
        return checkPairs() == 4;
    }

    private boolean checkFlush(){
        int suit = cards[0].getSuit();
        for (int i = 1; i < 5; i++) {
            if (suit != cards[i].getSuit()){
                return false;
            }
        }
        for (int i = 0; i < 5; i++) {
            populateHighCard(cards[i].getNumber());
        }
        return true;
    }

    private boolean checkStraight() {
        int lastValue = cards[0].getNumber();
        if (lastValue == 12){
            lastValue = -1;
        }
        for (int i = 1; i < 5; i++) {
            if ((cards[i].getNumber() != lastValue + 1)){
                return false;
            }
            lastValue = cards[i].getNumber();
        }
        for (int i = 0; i < 5; i++) {
            populateHighCard(cards[i].getNumber());
        }
        return true;
    }

    private boolean checkThreeOfAKind(){
        return checkPairs() == 3;
    }

    private boolean checkTwoPair(){
        return checkPairs() == 2;
    }

    private boolean checkPair(){
        return checkPairs() == 1;
    }

    private void checkHighCard() {
        for (int i = 0; i < 5; i++) {
            populateHighCard(cards[i].getNumber());
        }
    }

    private int checkPairs(){
        int numberFound = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if((i > j) && (cards[i].getNumber() == cards[j].getNumber())){
                    numberFound++;
                    populateHighCard(cards[i].getNumber());
                }
            }
        }
        return numberFound;
    }

    private void sort(){
        Collections.sort(Arrays.asList(cards), new CardComparator());
    }

    private void populateHighCard(int n){
        if (!highCard.contains(n)) {
            highCard.add(n);
        }
    }
}