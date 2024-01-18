public class Elicoptere extends Aeronave implements Comparable<Elicoptere>{

    private int autonomie;

    public Elicoptere(String marca, String model, int autonomie) {
        super(marca, model);
        this.autonomie = autonomie;
    }
    public int getAutonomie() {
        return autonomie;
    }

    @Override
    public String toString() {
        return "Elicopter " +
                this.getMarca() + ' ' + this.getModel() + ' ' + "autonomie : " + autonomie;
    }

    @Override
    public int compareTo(Elicoptere other) {
        return Integer.compare(this.autonomie, other.autonomie);
    }
}
