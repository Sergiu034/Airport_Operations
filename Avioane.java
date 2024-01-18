public class Avioane extends Aeronave{

    private int nr_locuri;
    public Avioane(String marca, String model, int nr_locuri) {
        super(marca, model);
        this.nr_locuri = nr_locuri;
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    @Override
    public String toString() {
        return "Avion " +
                this.getMarca() + ' ' + this.getModel() + ' ';
    }
}
