import java.util.ArrayList;
import java.util.Random;

public class GameController {
  private int numOfPlayers;
  public Deck d = new OldMaidDeck();
  private ArrayList<Player> players = new ArrayList<Player>();
  private ArrayList<Player> finishedPlayers = new ArrayList<Player>();
  ArrayList<Thread> threads = new ArrayList<>();
  public Object[] locks ;

  public boolean isGameOver= false;

    public GameController(int numOfPlayers)  {

        this.numOfPlayers = numOfPlayers;
        this.locks = new Object[numOfPlayers];
        for (int i = 0; i <numOfPlayers; i++) {
            locks[i] = new Object();
        }

        initializePlayerCards();

        createGameThreads();

        try{
        Thread.sleep(1000);}
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        firstLock();

        waitGameThreads();


        Result();
        endGame();
        }

        public void firstLock(){
            synchronized (locks[0]) {
                locks[0].notify();
            }
        }
        public void initializePlayerCards(){

            for (int i = 0; i <numOfPlayers; i++) {
                players.add(new Player(i+1, d.dealCards(52 / numOfPlayers)));
            }


            Random random = new Random();


            while(d.size() != 0){
                int randomNumber = random.nextInt(numOfPlayers);
                if( players.get(randomNumber).getPlayerCards().size()-1 != 52 / numOfPlayers)
                players.get(randomNumber).addCard(d.dealOneCard());
            }

        }


    public void createGameThreads(){
        for (int i = 0; i < players.size(); i++) {
            Object prevLock = locks[i];
            Object nextLock = locks[nextLock(i)];
            PlayerTask g = new PlayerTask(i,players, prevLock , nextLock , isGameOver);
            Thread t = new Thread(g);
            threads.add(t);
            t.start();
        }
    }

    public int nextLock(int i){
      if( i == numOfPlayers-1)
          return 0;
      else return  i+1;
    }

    public void waitGameThreads(){
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Result(){
        System.out.println("****************************************************");
        for (Player player : players) {
            if (player.getPlayerCards().size() == 1) {
                System.out.println("Player " + player.id + " has lost the game!");
                break;
            }
        }
    }
    public void endGame(){
        System.out.println("Game ends!");
    }


}