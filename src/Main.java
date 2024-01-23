import controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller c = new Controller(1000,1000,60,50);
        c.createView();
        c.showView();
        c.startePhilosophie();
    }
}
