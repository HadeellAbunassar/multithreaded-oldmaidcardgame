import java.util.ArrayList;

public class PlayerTask implements Runnable {
    private ArrayList<Player> Players;
    int id;
    private Object prevLock;
    private Object nextLock;
    private boolean isGameOver = false;



    public PlayerTask(int id , ArrayList<Player> Players, Object prevLock , Object nextLock , boolean isGameOver){
       this.id = id;
       this.Players = Players;
       this.prevLock = prevLock;
       this.nextLock = nextLock;
       this.isGameOver = isGameOver;
   }


    public void run() {

       Player p = Players.get(id);
       p.throwMatching();

        while (!isGameOver()) {
            synchronized (prevLock) {
                try {
                    prevLock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }

            GameOver();

            if (p.getPlayerCardsSize() != 0) {

                System.out.println("Player " + p.id + " has started his turn");
                System.out.println("Player " + p.id + " Cards before playing the round");
                p.printPlayerCards();

                if(isGameOver()==false) {
                    takeCard(p, Players);
                }

                System.out.println("Player " + p.id + " Cards After playing the round");
                p.printPlayerCards();

                System.out.println("new Hand size is: " + p.getPlayerCardsSize());
            }

            synchronized (nextLock) {
                nextLock.notify();
            }
        }

    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public  void takeCard(Player p, ArrayList<Player> Players) {
        int dealFrom = 0;
        dealFrom= p.dealFrom(id, Players.size(),Players);
        int selectedCard = p.pickRandomCard(Players.get(dealFrom).getPlayerCards().size());
        Card c = Players.get(dealFrom).removeCard(selectedCard);
        p.addCard(c);
        p.throwMatching();
        System.out.println(p.id + " took form player " + (dealFrom+1) + " Card : " + c);

        GameOver();
    }

    public void GameOver(){
        int totalCardsLeft = 0;

        for (Player player : Players) {
            totalCardsLeft += player.getPlayerCardsSize();
        }
        if (totalCardsLeft == 1) {
            isGameOver = true;
        }
    }
    }


