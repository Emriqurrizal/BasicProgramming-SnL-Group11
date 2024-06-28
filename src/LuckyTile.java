public class LuckyTile{
    private String[] mystery = {"Move 3 tiles forward", "Move 3 tiles backwards", "Goes to JAIL! (skipped 1 turn)"};
    private int index = (int)(Math.random()* 3) + 0;
    private int[] luckyTile = new int[7];

    public void setLuckyTile(){
        for(int i = 0; i<7; i++){
            this.luckyTile[i] = (int)(Math.random()* (99-5)) + 5;
        }
    }

    public int[] getLuckyTile(){
        setLuckyTile();
        return this.luckyTile;
    }

    public void getMystery(Player p){
        if(!p.getBombed()){
            if(this.index == 0){
                System.out.println(p.getName() + " got LUCKY, so " + mystery[this.index]);
                p.setPosition(p.getPosition() + 3);
            }
            else if(this.index == 1){
                System.out.println(p.getName() + " got LUCKY, so " + mystery[this.index]);
                p.setPosition(p.getPosition() - 3);
            }
            else if(this.index == 2){
                System.out.println(p.getName() + " got LUCKY, so " + mystery[this.index]);
                p.setJailed(true);
            }
        }
    }
}
