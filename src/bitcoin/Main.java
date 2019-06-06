package bitcoin;

public class Main {
    public static void main(String[] args) {
        Corretora molina = new Corretora();
        Cliente c1 = new Cliente ("Rodrigo", molina);
        Cliente c2 = new Cliente ("Willian", molina);
        Cliente c3 = new Cliente ("Vitor V", molina);
        Cliente c4 = new Cliente ("Daniel", molina);
        Cliente c5 = new Cliente ("Thiago", molina);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
