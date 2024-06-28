public class Snake{
    //state
    private int head;
    private int tail;

    //constructor
    Snake(int head, int tail){
        this.head=head;
        this.tail=tail;
    }

    //setter
    void setTail(int tail){
        this.tail=tail;
    }
    void setHead(int head){
        this.head=head;
    }

    //getter
    int getTail(){
        return this.tail;
    }
    int getHead(){
        return this.head;
    }
}
