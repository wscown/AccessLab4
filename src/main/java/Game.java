/**
 * Created by wscown on 2/1/16.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private int roundNumber;
    private Deck deck;
    private Scanner sc;

    public static void main(String[] args) {
        Game game = new Game();
    }

    Game(){
        sc = new Scanner(System.in);
        players = new ArrayList<Player>();
        deck = new Deck();
        roundNumber = 1;
        userInterface();
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    //
    public void setPlayers(int player) {

        String postscript;

        if(player == 1){
            postscript = "st";
        }else if(player == 2){
            postscript = "nd";
        }else if(player == 3){
            postscript = "rd";
        }else{
            postscript = "th";
        }

        String name;

        while(true){
            System.out.println("Please enter the " + player + postscript + " player's name:");

            name = sc.nextLine();

            if(!name.equals("")){
                break;
            }
        }

        players.add(new Player(name));

        System.out.println("Thank you. " + name + " successfully entered into the game.");
    }

    public void userInterface(){

        boolean morePlayers = true;
        String selection;

        System.out.println("Welcome to Magpie's Fate!\n\nPlease enter at least two players to play and a maximum of 4.");

        //Game needs at least two players so this ensures they exist
        setPlayers(1);
        setPlayers(2);

        //Gives the user option to enter more players
        while(morePlayers  && players.size() < 4){
            System.out.println("Would you like to enter more players?");

            while(true){
                System.out.print("Enter 'Y' for yes and 'N' for no.");

                selection = sc.nextLine().toLowerCase();

                if(selection.equals("y") || selection.equals("n")){
                    break;
                }
            }

            if (selection.equals("y")) {
                setPlayers(players.size() + 1);
            } else if (selection.equals("n")) {
                morePlayers = false;
                break;
            }
        }

        playRound();

        boolean moreRounds = true;

        while(moreRounds ){
            System.out.println("\nWould you like to play another round?");

            while(true){
                System.out.print("Enter 'Y' for yes and 'N' for no.");

                selection = sc.nextLine().toLowerCase();

                if(selection.equals("y") || selection.equals("n")){
                    break;
                }
            }

            if (selection.equals("y")) {
                playRound();
            } else if (selection.equals("n")) {
                moreRounds = false;
                break;
            }
        }

        System.out.println("\nFinal scores are as follows: ");

        int highscorer = 0;
        int highscore = 0;

        for(int i = 0; i < players.size(); i++){

            if(highscore < players.get(i).getGameScore()){
                highscorer = i;
                highscore = players.get(i).getGameScore();
            }
            System.out.println(players.get(i).getName() + " scored " + players.get(i).getGameScore());
        }

        System.out.println("\nThe game was won by " + players.get(highscorer).getName());
    }

    public String printScores(){
        return "";
    }

    public void playRound(){

        System.out.println("\nWelcome to round " + roundNumber + " of Magpie's Fate.");

        roundNumber++;

        for(int i = 0; i < players.size(); i++){

            System.out.println("First to draw cards is " + players.get(i).getName() + ". Here we go cards were drawn as follows:");

            deck.shuffle();
            boolean acecard = false;
            int playerscore = 0, cardvalue;
            Card card;

            while(!acecard){
                card = deck.dealCard();
                cardvalue = getCardValue(card);
                playerscore += cardvalue;
                Deck.printArt(card.toCharGraphic());
                System.out.println("Card scored: " + cardvalue);

                if(card.getValue() == Value.ACE){
                    acecard = true;
                }

                deck.returntoDeck(card);
            }

            System.out.println(players.get(i).getName() + " run has finished. You scored " + playerscore);

            players.get(i).setRoundScore(playerscore);
        }

        System.out.println("\nEnd of the round. Scores were as follows: ");
        int highscorer = 0;
        int highscore = 0;

        for(int i = 0; i < players.size(); i++){

            if(highscore < players.get(i).getRoundScore()){
                highscorer = i;
                highscore = players.get(i).getRoundScore();
            }
            System.out.println(players.get(i).getName() + " scored " + players.get(i).getRoundScore());
        }

        System.out.println("\nThat round was won by " + players.get(highscorer).getName());

        players.get(highscorer).setGameScore(1 + players.get(highscorer).getGameScore());

    }

    public static int getCardValue(Card card){

        if(card.getValue() == Value.JACK){
            if(card.getSuit() == Suit.SPADES || card.getSuit() == Suit.CLUBS){
                return 10;
            }else{
                return 15;
            }
        }else if(card.getValue() == Value.QUEEN){
            if(card.getSuit() == Suit.SPADES || card.getSuit() == Suit.CLUBS){
                return 14;
            }else{
                return 18;
            }
        }else if(card.getValue() == Value.KING){
            if(card.getSuit() == Suit.SPADES || card.getSuit() == Suit.CLUBS){
                return 20;
            }else{
                return 22;
            }
        }else if(card.getValue() == Value.ACE || (card.getValue().ordinal()+1)%2 == 0){
            return 0;
        }else{
            return card.getValue().ordinal() + 1;
        }
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
