public class Bombed{
    private int[] bombedTile = new int[3];
    private String bombedPlayer;

    public void setBombedTile(){
        for(int i = 0; i<3; i++){
            this.bombedTile[i] = (int)(Math.random()*99);
        }
    }

    public int[] getBombedTile(){
        setBombedTile();
        return this.bombedTile;
    }

    public void setBombedPlayer(Player p){
        this.bombedPlayer = p.getName();
    }

    public String getBombedPlayer(){
        return this.bombedPlayer;
    }
}
