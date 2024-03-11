public class OldMaidDeck extends Deck implements DeckInitializer{
    public static final String[] BLACK_SUITS = {"Clubs", "Spades"};
    public static String[] RED_SUITS = {"Diamonds", "Hearts"};

    public OldMaidDeck() {
        InitializeDeck();
        shuffle();
    }

    @Override
    public void InitializeDeck() {


        for (int j = 0; j < 2; j++) {
            for (int k = 2; k <= 10; k++) {
                getCards().add(new NormalCard("RED", RED_SUITS[j], k));
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int k = 2; k <= 10; k++) {
                getCards().add(new NormalCard("BLACK", BLACK_SUITS[j], k));
            }
        }

        getCards().add(new CourtCard("JOKER", "JOKER", CourtCard.Face.Joker));

        for (int j = 0; j < 2; j++) {
            for (CourtCard.Face face : CourtCard.Face.values()) {
                if (face != CourtCard.Face.Joker) {
                    getCards().add(new CourtCard("RED", RED_SUITS[j], face));
                }
            }
        }

        for (int j = 0; j < 2; j++) {
            for (CourtCard.Face face : CourtCard.Face.values()) {
                if (face != CourtCard.Face.Joker) {
                    getCards().add(new CourtCard("BLACK", BLACK_SUITS[j], face));
                }
            }
        }




    }


}
