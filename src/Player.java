import java.util.ArrayList;
import java.util.Random;

class Player  {
    public int id;
    private ArrayList<Card> playerCards;

    Player(int id,ArrayList<Card> cards )
    {
       playerCards=cards;
       this.id=id;
    }

    public void throwMatching() {
        for (int i = 0; i < playerCards.size(); i++) {
            for (int j = i + 1; j < playerCards.size(); j++) {
                if (playerCards.get(i).returnedValue() == playerCards.get(j).returnedValue()
                        && playerCards.get(i).getColor() == playerCards.get(j).getColor()) {
                    playerCards.remove(j);
                    playerCards.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    public int dealFrom(int currentPlayerIndex, int numberOfPlayers, ArrayList<Player> players) {
        int dealFromIndex = (currentPlayerIndex == 0) ? numberOfPlayers - 1 : currentPlayerIndex - 1;

        while (players.get(dealFromIndex).getPlayerCardsSize() == 0) {
            dealFromIndex = (dealFromIndex == 0) ? numberOfPlayers - 1 : dealFromIndex - 1;
        }
        return dealFromIndex;
    }


    public int pickRandomCard(int otherPlayerCards){
        Random random = new Random();
        int randomNumber = random.nextInt(otherPlayerCards);

        return randomNumber;
    }
    public void addCard(Card c)
    {
        playerCards.add(c);
    }

    public Card removeCard(int i){
        return playerCards.remove(i);
    }

    public ArrayList<Card> getPlayerCards()
    {
        return playerCards;
    }

    public int getPlayerCardsSize()
    {
        return playerCards.size();
    }

    public void printPlayerCards(){
        for(int i=0; i <playerCards.size() ; i++){
            System.out.println(playerCards.get(i));
        }
    }

}





