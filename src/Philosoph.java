
public class Philosoph extends Thread {
    long t_verhungern;
    long t_warten;
    long t_essen;
    Gabel gabel_links;
    Gabel gabel_rechts;
    int id;

    public Philosoph(int id, long t_verhungern, long t_warten, long t_essen, Gabel links, Gabel rechts){
        this.gabel_links =links;
        this.gabel_rechts =rechts;
        this.t_verhungern=t_verhungern;
        this.t_warten=t_warten;
        this.t_essen=t_essen;
        this.id=id;
    }

    public void gabel_nehmen(String gabel){
        if(gabel.equals("links")){
            this.gabel_links.gabel_nehmen(this);
        } else if(gabel.equals("rechts")) {
            this.gabel_rechts.gabel_nehmen(this);
        }
    }

    public void gabeln_zuruecklegen(){
        if(this.gabel_links.inhaber!=null && this.gabel_links.inhaber.id==this.id) {
            this.gabel_links.gabel_zuruecklegen();
        }
        if(this.gabel_rechts.inhaber!=null && this.gabel_rechts.inhaber.id==this.id) {
            this.gabel_rechts.gabel_zuruecklegen();
        }
    }

    public boolean essen(){
        if(this.gabel_links.inhaber!=null && this.gabel_rechts.inhaber!=null && this.gabel_links.inhaber.id==this.id&&this.gabel_rechts.inhaber.id==this.id) {
            try {
                sleep(this.t_essen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.id+" isst mit Gabel "+this.gabel_links.id+" und "+this.gabel_rechts.id);
            this.gabeln_zuruecklegen();
            return true;
        }
        return false;
    }

    public void run() {
        int i=0;
        System.out.println("Ich bin"+this.id);
        long t0 = System.currentTimeMillis();
        while (t0 + this.t_verhungern >= System.currentTimeMillis()) {
            try {
                sleep(this.t_warten);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.gabel_nehmen("links");
            this.gabel_nehmen("rechts");
            if (this.essen()) {
                t0 = System.currentTimeMillis();
            }
            if (i++%5==this.id){
                this.gabeln_zuruecklegen();
            }
        }
        this.gabeln_zuruecklegen();
        System.out.println("Ich, "+this.id+", gebe den Löffel ab ");
    }
}
