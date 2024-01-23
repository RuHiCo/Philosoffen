import controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller c = new Controller(5,2000,400,240);
        c.createView();
        c.showView();
        c.startePhilosophie();
    }
}
