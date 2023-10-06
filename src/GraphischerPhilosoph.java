
public class GraphischerPhilosoph{
    int x,y,r;
    boolean isAlive;
    public GraphischerPhilosoph(int x,int y,int r){
        this.x=x;
        this.y=y;
        this.r=r;
        this.isAlive=true;
    }
    public void die(){
        this.isAlive=false;
    }
}