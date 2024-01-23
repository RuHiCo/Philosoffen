package controller;

import model.Gabel;
import model.Philosoph;
import view.App;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    int anzahl;
    Philosoph[] philosophen;
    Gabel[] gabeln;
    App app;
    public Controller(int anzahl,int verhungern,int warten,int essen){
        this.anzahl=anzahl;
        gabeln = gabeln_erstellen(anzahl);
        philosophen = philosophen_erstellen(verhungern,warten,essen,gabeln);
    }


    public void createView(){
        app=new App(950,950,anzahl);
    }

    public void showView() {
        SwingUtilities.invokeLater(() -> {
            app.setVisible(true);
        });
    }

    public void startePhilosophie() {
        for (Philosoph philosoph : philosophen) {
            philosoph.addObserver(this);
            Thread philosophThread = new Thread(philosoph);
            philosophThread.start();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Events events = (Events) arg;
        int event = events.event();
        int philosoph = events.philosoph();
        String gabel = events.gabel();
        if (event == 0) {
            this.app.philophStirbt(philosoph);
        } else if (event == 1) {
            this.app.philosopherGrabsFork(philosoph, gabel);
        } else if (event == 2) {
            this.app.philosopherDropsFork(philosoph, gabel);
        }else if (event==3){
            this.app.philosophIsst(philosoph);
        }else if (event==4){
            this.app.philosophIsstNichtMehr(philosoph);
        }
    }

    public static Gabel[] gabeln_erstellen(int n){
        Gabel[] gabeln = new Gabel[n];
        for(int i=0;i<n;i++){
            gabeln[i]=new Gabel(i);
        }
        return gabeln;
    }

    public static Philosoph[] philosophen_erstellen(long t_verhungern,long t_warten,long t_essen,Gabel[] gabeln){
        int n=gabeln.length;
        Philosoph[] philosophen = new Philosoph[n];
        for(int i=0;i<n;i++){
            philosophen[i] = new Philosoph(i,t_verhungern,t_warten,t_essen,gabeln[i],gabeln[(i+1)%n]);
        }
        return philosophen;
    }
}
