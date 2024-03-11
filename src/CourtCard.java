
public class CourtCard extends Card {
    public enum Face {
        Jack, Queen, King, Joker , A
    }
    private Face face;

    public CourtCard(String color, String suit, Face face) {
        super(color, suit);
        this.face = face;
    }


    public Face getFace() {
        return face;
    }


    @Override
    public int returnedValue() {
        if (face.equals(Face.Jack))
            return 11;
        if (face.equals(Face.Queen))
            return 12;
        if (face.equals(Face.King))
            return 13;
        if(face.equals(Face.A))
            return 30;
        else
            return -1; // Joker
    }

    @Override
    public String toString(){
        if(getFace().equals(Face.Joker))
            return "Joker Card";
        else
        return "Face Card , Color: " + getColor() + " | Face: " + getFace() + " | Suit: " + getSuit();
    }
}