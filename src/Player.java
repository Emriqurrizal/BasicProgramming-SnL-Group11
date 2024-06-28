public class Player{

    //states
    private String name;
    private int position = 0;
    private boolean bombed = false;
    private boolean jailed = false;

    //constructor
    public Player(String name){
        this.name = name;
    }

    //setter
    public void setName(String name){
        this.name=name;
    }
    public void setPosition(int position){
        this.position=position;
    }
    public void setJailed(boolean jailed){
        this.jailed=jailed;
    }
    public void setBombed(boolean bombed){
        this.bombed=bombed;
    }

    //getter
    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public boolean getJailed(){
        return this.jailed;
    }

    public boolean getBombed(){
        return this.bombed;
    }

    //behavior
    public int rollDice(){
        return (int)(Math.random()*6)+1;
    }

    public void moveAround(int x){
        if(this.position + x > 100){
            this.position = (100 - this.position) + (100 - x);
        }
        else{
            this.position += x;
        }
    }
}