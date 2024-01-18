public class Aeronave {

    private String marca;
    private String model;

    public Aeronave(String marca, String model) {
        this.marca = marca;
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Aeronava " +
                marca + ' ' + model + ' ';
    }
}
