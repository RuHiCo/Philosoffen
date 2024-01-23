package model;

import controller.Events;
import java.util.Observable;

public class Philosoph extends Observable implements Runnable {
    long tVerhungern;
    long tWarten;
    long tEssen;
    Gabel gabelLinks;
    Gabel gabelRechts;
    boolean links;
    boolean rechts;
    int id;

    public Philosoph(int id, long verhungern, long warten, long essen, Gabel links, Gabel rechts){
        this.gabelLinks =links;
        this.gabelRechts =rechts;
        this.links=false;
        this.rechts=false;
        this.tVerhungern=verhungern;
        this.tWarten=warten;
        this.tEssen=essen;
        this.id=id;
    }

    public boolean gabelNehmen(String gabel){
        if(gabel.equals("links")){
            this.links=this.gabelLinks.gabelNehmen();
            if(this.links){
                notifyObservers(new Events(1, this.id,"links"));
                setChanged();
                //System.out.printf("%d nimmt linke Gabel\n",this.id);
            }
        } else if(gabel.equals("rechts")) {
            this.rechts=this.gabelRechts.gabelNehmen();
            if(this.rechts) {
                notifyObservers(new Events(1, this.id,"rechts"));
                setChanged();
                //System.out.printf("%d nimmt rechte Gabel\n", this.id);
            }
        }
        return false;
    }

    public void gabelZuruecklegen(String gabel){
        if (gabel.equals("links")) {
            this.gabelLinks.gabelZuruecklegen();
            notifyObservers(new Events(2, this.id, "links"));
            setChanged();
            //System.out.printf("%d legt linke Gabel ab\n", this.id);
            this.links = false;
        }else if (gabel.equals("rechts")) {
            this.gabelRechts.gabelZuruecklegen();
            notifyObservers(new Events(2, this.id,"rechts"));
            setChanged();
            //System.out.printf("%d legt rechte Gabel ab\n", this.id);
            this.rechts=false;
        }
    }

    public void gabelnZuruecklegen(){
        gabelZuruecklegen("links");
        gabelZuruecklegen("rechts");
    }

    public boolean essen(){
        if(links && rechts) {
            notifyObservers(new Events(3, this.id,""));
            setChanged();
            try {
                Thread.sleep(this.tEssen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyObservers(new Events(4, this.id,""));
            setChanged();
            //System.out.println(this.id + " isst mit Gabel " + this.gabelLinks.id + " und " + this.gabelRechts.id);
            return true;
        }
        return false;
    }

    public void run() {
        int i=0;
        System.out.println("Ich bin"+this.id);
        long t0 = System.currentTimeMillis();
        while (t0 + this.tVerhungern >= System.currentTimeMillis()) {
            try {
                Thread.sleep(this.tWarten);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.gabelNehmen("links");
            this.gabelNehmen("rechts");
            i=(i+1)%5;
            if (this.essen()) {
                t0 = System.currentTimeMillis();
            }
            this.gabelnZuruecklegen();

        }
        this.gabelnZuruecklegen();
        notifyObservers(new Events(0, this.id,""));
        setChanged();
        System.out.println("Ich, "+this.id+", gebe den Löffel ab ");
    }
}
