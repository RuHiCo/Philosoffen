import javax.swing.*;

public class App implements DieListener{
    int diameter;
    int center_x,center_y;
    int size_x,size_y;
    GraphischerPhilosoph[] philosophen;
    GraphischeGabel[] gabeln;
    Canvas t;
    public App(int size_x,int size_y,int n){
        this.setSize(size_x,size_y);


        this.philosophen=new GraphischerPhilosoph[n];
        this.gabeln=new GraphischeGabel[n];
        int[] erg1,erg2,erg3;
        for(int i=0;i<n;i++){
            erg1=getLocation(n,i,this.diameter /1.2, this.center_x, this.center_y,0);
            philosophen[i]= new GraphischerPhilosoph(erg1[0], erg1[1],this.diameter *3/14);
            erg2=getLocation(n,i,this.diameter /2.1, this.center_x, this.center_y,Math.PI/n);
            erg3=getLocation(n,i,this.diameter /3.5, this.center_x, this.center_y,Math.PI/n);
            gabeln[i]=new GraphischeGabel(erg2[0], erg2[1],erg3[0], erg3[1]);
        }
        this.t=new Canvas(new int[]{this.center_x, this.center_y, this.diameter /2,this.diameter /2},this.philosophen,this.gabeln);
    }
    public void setSize(int x,int y){
        this.size_x=x;
        this.size_y=y;
        this.center_x=x/2;
        this.center_y=y/2;
        this.diameter =x/3;
    }

    @Override
    public void someoneDied(int id){
        this.philosophen[id].die();
        this.t.repaint();
    }

    public static int[] getLocation(int anzahl,int id,double factor, int center_x,int center_y,double offset){
        int x= Double.valueOf(Math.cos(2*Math.PI/anzahl*id+offset)*factor).intValue()+center_x;
        int y= Double.valueOf(Math.sin(2*Math.PI/anzahl*id+offset)*factor).intValue()+center_y;
        return new int[]{x,y};
    }


    public static void main(String[] args) {
        int n=8;
        JFrame f=new JFrame("Philosoffen");//creating instance of JFrame
        App app=new App(950,950,n);
        f.setSize(app.size_x,app.size_y);//400 width and 500 height
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(app.t);//adding Canvas in JFrame
        f.setVisible(true);//making the frame visible
        app.someoneDied(5);
    }
}