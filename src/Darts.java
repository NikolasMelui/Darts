import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Darts {

    private static class Player {
        String playerName;
        int playerScore;
    }

    // Function_parse_String_to_int
    private static int toNumber(String string) {
        return Integer.parseInt(string);
    } 

    // Function_exit
    private static void isExit(String string) {
        if ("exit".equals(string)) {
            System.out.println("Ok, bye bye.");
            System.exit(1);
        }
    }
	
	// Function_show_scores
    private static void showScore(int amountOfPlayers, Player[] players) { 
        for (int i = 0; i < amountOfPlayers; i++) {
            Player curPlayer = players[i];
            System.out.printf("%10s%n10s%n", curPlayer.playerName, curPlayer.playerScore); //TODO: make "beautiful" format of player scores
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 'exit' to quit.\n");
        System.out.println("Please enter the amount of the players");

        int amountOfPlayers;

        while (true) {
            String amountOfPlayersString;
            isExit(amountOfPlayersString = reader.readLine());
            try {
                amountOfPlayers = toNumber(amountOfPlayersString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This is not a number! Please enter again.");
            }
        }
        Player[] players = new Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println(("Enter the name of Player ") + (i + 1));
            String curName = reader.readLine();
            isExit(curName);
            Player curPlayer = new Player();
            curPlayer.playerName = curName;
            curPlayer.playerScore = 501;
            players[i] = curPlayer;
        }

        boolean play = true;
        while (play) {
            for (int i = 0; i < amountOfPlayers; i++) {
                System.out.println();
                Player curPlayer = players[i];
                int curMove;
                String curInput;
                while (true) {
                    try {
                        System.out.println(curPlayer.playerName + " throws:");
                        curInput = reader.readLine();
                        isExit(curInput);
                        curMove = toNumber(curInput);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error, please enter number format.");
                    }
                }
                if (curMove == curPlayer.playerScore) {
                    curPlayer.playerScore = curPlayer.playerScore - curMove;
                    System.out.println("\n" + curPlayer.playerName + " WINS!!! Congratulations!!!\n");
                    showScore(amountOfPlayers, players);
                    play = false;
                    break;
                } else if (curMove > curPlayer.playerScore) {
                    System.out.println("Too much!");
                    showScore(amountOfPlayers, players);
                    System.out.println();
                } else if (curMove < curPlayer.playerScore) {
                    curPlayer.playerScore = curPlayer.playerScore - curMove;
                    showScore(amountOfPlayers, players);
                }
            }
        }
    }
}