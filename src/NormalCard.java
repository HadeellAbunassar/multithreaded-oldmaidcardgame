

public class NormalCard extends Card   {
    private int number;

    public NormalCard(String color, String suit, int number) {
        super(color , suit);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int returnedValue(){
        return getNumber();
    }

    @Override
    public String toString(){
        return "Normal Card , Color: " + getColor() + " | Number: " + getNumber() + " | Suit: " + getSuit();
    }
}
