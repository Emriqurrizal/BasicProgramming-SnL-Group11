public class Ladder{
    //state
    private int fromPosition;
    private int toPosition;

    //constructor
    Ladder(int from, int to){
        this.fromPosition = from;
        this.toPosition = to;
    }

    //setter
    void setFromPosition(int from){
        this.fromPosition = from;
    }
    void setToPosition(int to){
        this.fromPosition = to;
    }

    //getter
    int getFromPosition(){
        return this.fromPosition;
    }
    int getToPosition(){
        return this.toPosition;
    }
}

