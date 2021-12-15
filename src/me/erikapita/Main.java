package me.erikapita;
import java.util.*;

public class Main {

    static String[] gameBoard;
    static String character;

    static String Winner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = gameBoard[0] + gameBoard[1] + gameBoard[2];
                    break;
                case 1:
                    line = gameBoard[3] + gameBoard[4] + gameBoard[5];
                    break;
                case 2:
                    line = gameBoard[6] + gameBoard[7] + gameBoard[8];
                    break;
                case 3:
                    line = gameBoard[0] + gameBoard[3] + gameBoard[6];
                    break;
                case 4:
                    line = gameBoard[1] + gameBoard[4] + gameBoard[7];
                    break;
                case 5:
                    line = gameBoard[2] + gameBoard[5] + gameBoard[8];
                    break;
                case 6:
                    line = gameBoard[0] + gameBoard[4] + gameBoard[8];
                    break;
                case 7:
                    line = gameBoard[2] + gameBoard[4] + gameBoard[6];
                    break;
            }
            //For 0 winner
            if (line.equals("000")) {
                return "0";
            }

            // For 1 winner
            else if (line.equals("111")) {
                return "1";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(gameBoard).contains(
                    String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "tie";
            }
        }

        System.out.println(
                character + "'s time. Please enter the "
                        + character + "'s in:");
        return null;
    }


    //prints the board
        static void Board(){
        System.out.println("|=====|=====|=====|");
        System.out.println("|  " + gameBoard[0] + "  |  " + gameBoard[1] + "  |  " + gameBoard[2] + "  |");
        System.out.println("|-----------------|");
        System.out.println("|  " + gameBoard[3] + "  |  " + gameBoard[4] + "  |  " + gameBoard[5] + "  |");
        System.out.println("|-----------------|");
        System.out.println("|  " + gameBoard[6] + "  |  " + gameBoard[7] + "  |  " + gameBoard[8] + "  |");
        System.out.println("|=====|=====|=====|");
        }

        public static void main (String[]args){
            Scanner in = new Scanner(System.in);
            gameBoard = new String[9];
            character = "0";
            String winner = null;

            for (int i = 0; i < 9; i++) {
                gameBoard[i] = String.valueOf(i + 1);
            }

            System.out.println("\nBib bop human! Welcome to 01010100 01101001 01100011 01010100 01100001 01100011 01010100 01101111 01100101\n");
            Board();

            System.out.println(
                    "\n0's go first. Please human enter the 0's in the proper place: ");

            while (winner == null) {
                int num;
                try {
                    num = in.nextInt();
                    if (!(num > 0 && num <= 9)) {
                        System.out.println(
                                "\nBad human! That's not a slot! Re-enter data: ");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(
                            "\nBad human! That's not a slot! Re-enter data: ");
                    continue;
                }

                if (gameBoard[num - 1].equals(
                        String.valueOf(num))) {
                    gameBoard[num - 1] = character;

                    if (character.equals("0")) {
                        character = "1";
                    } else {
                        character = "0";
                    }
                    Board();
                    winner = Winner();
                } else {
                    System.out.println(
                            "\nThat place already has 0's and 1's. Re-enter data: ");
                }
            }

            //tie case
            if (winner.equalsIgnoreCase("tie")) {
                System.out.println(
                        "\nNo binary for anyone. Bib bop sad :(");
            }

            //winner message
            else {
                Random number = new Random();
                String[] prize = {"boat", "house", "cake"};
                int index = number.nextInt(prize.length);

                System.out.println(
                        "\nCongrats human. " + winner
                                + "'s are the best!" +
                                "\nYou won an imaginary: " + prize[index].toUpperCase(Locale.ROOT) +
                                "\nBib bop!");
            }
        }
    }
