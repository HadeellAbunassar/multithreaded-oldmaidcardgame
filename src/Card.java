public abstract class Card {
    private String color;
    private String suit;


    public Card(String color , String suit) {
        this.color = color;
        this.suit = suit;
    }

    public String getColor() {
        return color;
    }

    public String getSuit(){
        return suit;
    }

    public abstract int returnedValue();


}
