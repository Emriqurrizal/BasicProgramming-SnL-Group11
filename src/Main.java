import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);

        System.out.println("<=======================================>");
        System.out.println("Welcome to Snake and Ladder Game!");
        System.out.println("By Group 11: ");
        System.out.println("1. Enriqurrizal Yahya Nurramadhan - 5026231001");
        System.out.println("2. Alexander Allan - 5026231050");
        System.out.println("3. Fezih Suhaimah Jinan - 5026231055");
        System.out.println("<=======================================>");

        System.out.print("Enter player 1 name: ");
        String player1 = read.nextLine();
        System.out.print("Enter player 2 name: ");
        String player2 = read.nextLine();
        System.out.println();

        SnL g1 = new SnL(100);
        g1.initiateGame();
        Player p1 = new Player("allan");
        Player p2 = new Player("emriq");

        g1.addPlayer(p1);
        g1.addPlayer(p2);

        do{
            System.out.println("====================================================================");


            Player nowPlaying = g1.getTurn();

            //jail feature
            Player ref = nowPlaying;
            if(nowPlaying.getJailed()){
                nowPlaying = g1.getTurn();
            }
            ref.setJailed(false);

            System.out.println("Now Playing: " + nowPlaying.getName() + "'s current position is " + nowPlaying.getPosition());

            int x = nowPlaying.rollDice();
            System.out.println(nowPlaying.getName() + " is rolling dice and get number: " + x);
            g1.movePlayer(nowPlaying, x);
            System.out.println(nowPlaying.getName() + "'s current position is " + nowPlaying.getPosition());

            //knockback feature
            if(p1.getPosition() == p2.getPosition()){
                System.out.println(p1.getName() + " " + p2.getName() +" at the same position");
                System.out.println(nowPlaying.getName() + " " + "knock back to 0");
                nowPlaying.setPosition(0);
            }

        } while(g1.getGameStatus() != 2);

        System.out.println("The game is over, the winner is: " + g1.getWinner());
    }
}
