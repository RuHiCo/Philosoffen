import javax.swing.*;

public class App{
    int radius;
    public App(int radius){
        this.radius=radius;
    }

    public int[] getLocation(int anzahl,int id){
        int x= Double.valueOf(Math.cos(2*Math.PI/anzahl*id)*this.radius*1.8).intValue()+200;
        int y= Double.valueOf(Math.sin(2*Math.PI/anzahl*id)*this.radius*1.8).intValue()+200;
        return new int[]{x,y};
    }


    public static void main(String[] args) {
        JFrame f=new JFrame("Philosoffen");//creating instance of JFrame
        JPanel p=new JPanel();
        App app=new App(100);
        f.setSize(800,800);//400 width and 500 height
        f.setLocation(100,100);
        int[][] philosophen=new int[5][4];
        int[] erg;
        int n=5;
        for(int i=0;i<n;i++){
            erg=app.getLocation(n,i);
            philosophen[i]= new int[]{erg[0], erg[1],10,10};
        }
        Tisch t=new Tisch(new int[]{200, 200, 10,10},philosophen);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(t);//adding Tisch in JFrame
        f.setVisible(true);//making the frame visible
    }
}