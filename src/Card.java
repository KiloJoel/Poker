public class Card
{
    private int number;
    private int suit;

    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber(){
        return number;
    }

    public int getSuit(){
        return suit;
    }

    public String getCardString() {
        String card1 = new String();
        switch (number)
        {
            case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8:
                card1 = String.valueOf(number + 2);
                break;
            case 9:
                card1 = "J";
                break;
            case 10:
                card1 = "Q";
                break;
            case 11:
                card1 = "K";
                break;
            case 12:
                card1 = "A";
                break;
        }
        String card2 = new String();
        switch (suit)
        {
            case 0:
                card2 = "h";
                break;
            case 1:
                card2 = "d";
                break;
            case 2:
                card2 = "s";
                break;
            case 3:
                card2 = "c";
                break;
        }
        return card1 + card2;
    }
}