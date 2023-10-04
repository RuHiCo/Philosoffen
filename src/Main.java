
public class Main {
    public static Gabel[] gabeln_erstellen(int n){
        Gabel[] gabeln = new Gabel[n];
        for(int i=0;i<n;i++){
            gabeln[i]=new Gabel(i);
        }
        return gabeln;
    }

    public static Philosoph[] philosophen_erstellen(long t_warten,long t_verhungern,long t_essen,Gabel[] gabeln){
        int n=gabeln.length;
        Philosoph[] philosophen = new Philosoph[n];
        for(int i=0;i<n;i++){
            philosophen[i] = new Philosoph(i,t_verhungern,t_warten,t_essen,gabeln[i],gabeln[(i+1)%n]);
        }
        return philosophen;
    }

    public static void main(String[] args) {
        int n = 5;
        Gabel[] gabeln = Main.gabeln_erstellen(n);
        Philosoph[] philosophen = new Philosoph[n];
        for(int i=0;i<n;i++){
            philosophen[i] = new Philosoph(i,3000,500,1000,gabeln[i],gabeln[(i+1)%n]);
        }
        for(Philosoph philosoph:philosophen){
            philosoph.start();
        }
    }
}
