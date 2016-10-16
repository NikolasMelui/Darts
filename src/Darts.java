import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Darts {

    private static class Player {
        String playerName;
        int playerScore;
    }

    private static int toNumber(String string) {
        return Integer.parseInt(string);
    }

    private static void isExit(String s) {
        if ("exit".equals(s)) {
            System.out.println("Ok, bye.");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 'exit' to quit.\n");
        System.out.println("Please enter the amount of the players");

        int amountOfPlayers;

        while (true) {
            String amountOfPlayersS = reader.readLine();
            isExit(amountOfPlayersS);
            try {
                amountOfPlayers = toNumber(amountOfPlayersS);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This is not a number! Please enter again.");
            }
        }
        Player players[] = new Player[amountOfPlayers];
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
                int curMove = 0;
                String curInput;
                while (true) {
                    try {
                        System.out.println(curPlayer.playerName + " throws:");
                        curInput = reader.readLine();
                        isExit(curInput);
                        curMove = toNumber(curInput);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("This is not a number! Please enter again.");
                    }
                }
                if (curMove > curPlayer.playerScore) {
                    System.out.println("Too much! Brr...");
                    System.out.println("You steel need " + curPlayer.playerScore);
                } else if (curMove < curPlayer.playerScore) {
                    curPlayer.playerScore = curPlayer.playerScore - curMove;
                    System.out.println("Now " + curPlayer.playerName + " need " + curPlayer.playerScore);
                } else if (curMove == curPlayer.playerScore) {
                    curPlayer.playerScore = curPlayer.playerScore - curMove;
                    System.out.println();
                    System.out.println(curPlayer.playerName + " WINS!!! Congratulations!!!");
                    System.out.println();
                    play = false;
                    break;
                }
            }
            System.out.println();
            for (int i = 0; i < amountOfPlayers; i++) {
                Player curPlayer = players[i];
                System.out.print(curPlayer.playerName);
                System.out.print("    ");
            }
            System.out.println();
            for (int i = 0; i < amountOfPlayers; i++) {
                Player curPlayer = players[i];
                System.out.print(curPlayer.playerScore);
                System.out.print("      ");
            }
            System.out.println();
        }
    }
}
