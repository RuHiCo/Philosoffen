package model;

public class Gabel {
    int id;
    boolean frei;
    public Gabel(int id){
        this.id=id;
        this.frei=true;
    }

    public synchronized boolean gabelNehmen(){
        if(this.frei) {
            this.frei = false;
            return true;
        }else{
            return false;
        }

    }

    public synchronized void gabelZuruecklegen(){
        this.frei=true;
    }
}
