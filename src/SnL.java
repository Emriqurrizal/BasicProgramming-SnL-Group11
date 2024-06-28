import java.util.ArrayList;
import java.util.Collections;

public class SnL{
    Bombed bombedFeat = new Bombed();
    LuckyTile luckyFeat = new LuckyTile();

    private int boardSize;
    private ArrayList<Player> players;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private ArrayList<Integer> bombTiles;
    private ArrayList<Integer> luckyTiles;
    private int gameStatus;
    private int currentTurn;

    //constructor
    public SnL(int boardSize){
        this.boardSize = boardSize;
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.players = new ArrayList<Player>();
        this.bombTiles = new ArrayList<Integer>();
        this.luckyTiles = new ArrayList<Integer>();
        this.gameStatus = 0;
        this.currentTurn = 0;
    }

    //add
    public void initiateGame(){
        setLuckyTiles(luckyFeat.getLuckyTile());
        System.out.print("Lucky tile is at: ");
        for(int i = 0; i < luckyTiles.size(); i++){
            System.out.print(luckyTiles.get(i) + " ");
        }
        System.out.println("tile");

        setBombTiles(bombedFeat.getBombedTile());
        System.out.print("Bomb is at: ");
        for(int i = 0; i < bombTiles.size(); i++){
            System.out.print(bombTiles.get(i) + " ");
        }
        System.out.println("tile");
        System.out.println();

        int[][] ladders = {
                {2, 23},
                {8, 34},
                {20,77},
                {32, 68},
                {41,78},
                {74,88},
                {82,100},
                {85,95}
        };
        setLadders(ladders);

        int[][] snakes = {
                {47, 5},
                {29, 9},
                {38, 15},
                {97, 25},
                {53, 33},
                {92, 70},
                {86, 54},
                {97, 25}
        };
        setSnakes(snakes);
    }

    public Player getTurn(){
        if(this.gameStatus == 0){
            double r = Math.random();
            if(r < 0.5){
                this.currentTurn = 0;
                return this.players.get(0);
            }
            else{
                this.currentTurn = 1;
                return this.players.get(1);
            }
        }
        else{
            if(currentTurn == 0){
                this.currentTurn = 1;
                return this.players.get(1);
            }
            else{
                this.currentTurn = 0;
                return this.players.get(0);
            }
        }
    }

    //setter methods
    public void setSizeBoard(int size){
        this.boardSize = size;
    }

    public void addPlayer(Player p){
        this.players.add(p);
    }

    public void setLadders(int[][] ladders){
        int s = ladders.length;
        for(int i=0; i<s; i++){
            this.ladders.add(new Ladder(ladders[i][0], ladders[i][1]));
        }
    }

    public void setSnakes(int[][] snakes){
        int s = snakes.length;
        for(int i = 0; i<s; i++){
            this.snakes.add(new Snake(snakes[i][0], snakes[i][1]));
        }
    }

    public void setBombTiles(int[] bombTiles){
        int b = bombTiles.length;
        for(int i = 0; i<b; i++){
            this.bombTiles.add(bombTiles[i]);
        }
        Collections.sort(this.bombTiles);
    }

    public void setLuckyTiles(int[] mysteryTiles){
        int m = mysteryTiles.length;
        for(int i = 0; i<m; i++){
            this.luckyTiles.add(mysteryTiles[i]);
        }
        Collections.sort(this.luckyTiles);
    }

    // getter methhod

    //bomb feature
    boolean bombed = false;
    public String getWinner(){
        if(bombed){
            System.out.println(bombedFeat.getBombedPlayer() + " hit a BOMB and EXPLODED!");
            if(this.currentTurn == 1){
                return this.players.get(0).getName();
            }
            else{
                return this.players.get(1).getName();
            }
        }
        if(this.gameStatus == 0){
            return "The game is not over yet";
        }
        else{
            if(this.players.get(0).getPosition() == 100){
                return this.players.get(0).getName();
            }
            else {
                return this.players.get(1).getName();
            }
        }
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public ArrayList<Snake> getSnakes(){
        return this.snakes;
    }

    public ArrayList<Ladder> getLadders(){
        return this.ladders;
    }

    public int getBoardSize(){
        return this.boardSize;
    }

    public int getGameStatus(){
        return this.gameStatus;
    }

    public void movePlayer(Player p, int x){
        this.gameStatus = 1;
        p.moveAround(x);

        for(Ladder l: this.ladders){
            if(l.getFromPosition() == p.getPosition()){
                p.setPosition(l.getToPosition());
                System.out.println(p.getName() + " got ladder so jumps to " + p.getPosition());
            }
        }

        for(Snake s: this.snakes){
            if(s.getHead() == p.getPosition()){
                p.setPosition(s.getTail());
                System.out.println(p.getName() + " got snake so slides to " + p.getPosition());
            }
        }

        for(int i = 0; i<bombTiles.size(); i++){
            if(p.getPosition() == bombTiles.get(i)){
                this.gameStatus = 2;
                p.setBombed(true);
                bombed = true;
                bombedFeat.setBombedPlayer(p);
            }
        }

        for(int i = 0; i<luckyTiles.size(); i++){
            if(p.getPosition() == luckyTiles.get(i)){
                LuckyTile mysteryTile = new LuckyTile();
                mysteryTile.getMystery(p);
            }
        }

        if(p.getPosition() == this.boardSize){
            this.gameStatus = 2;
        }
    }
}
