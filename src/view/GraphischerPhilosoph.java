package view;

public class GraphischerPhilosoph{
    int x;
    int y;
    int r;
    boolean links;
    boolean rechts;
    boolean lebt;
    public GraphischerPhilosoph(int x, int y, int r){
        this.x=x;
        this.y=y;
        this.r=r;
        this.links = false;
        this.rechts = false;
        this.lebt=true;
    }

    public void nimmGabel(String gabel){
        if (gabel.equals("links")){
            this.links=true;
        }
        if (gabel.equals("rechts")){
            this.rechts=true;
        }
    }

    public void legGabelAb(String gabel){
        if (gabel.equals("links")){
            this.links=false;
        }
        if (gabel.equals("rechts")){
            this.rechts=false;
        }
    }

    public void stirbt(){
        this.lebt=false;
    }

}