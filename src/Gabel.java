public class Gabel {
    int id;
    Philosoph inhaber;
    public Gabel(int id){
        this.id=id;
        this.inhaber=null;
    }

    synchronized public void gabel_nehmen(Philosoph inhaber){
        if(this.inhaber==null){
            this.inhaber=inhaber;
            System.out.println(this.inhaber.id+" nimmt Gabel "+this.id);
        }
    }

    synchronized public void gabel_zuruecklegen(){
        System.out.println(this.inhaber.id+" legt Gabel "+this.id+" ab");
        this.inhaber=null;
    }
}
