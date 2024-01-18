import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class    Aeroport {

    private String nume;
    private int nr_avioane;
    private int nr_elicoptere;
    private List<Aeronave> AeronaveParcate;

    public Aeroport(String nume, int nr_avioane, int nr_elicoptere) {
        this.nume = nume;
        this.nr_avioane = nr_avioane;
        this.nr_elicoptere = nr_elicoptere;
        this.AeronaveParcate = new ArrayList<>();
    }

    public void aterizeazaAeronava(Aeronave aeronava) throws Exception {
        if (aeronava instanceof Avioane && this.nr_avioane > 0) {
            this.nr_avioane--;
            AeronaveParcate.add(aeronava);

        } else if (aeronava instanceof Elicoptere && nr_elicoptere > 0) {
            this.nr_elicoptere--;
            AeronaveParcate.add(aeronava);

        } else {
            throw new Exception("Nu există locuri de parcare disponibile pentru " + aeronava.toString());

        }
    }

    public void decoleazaAeronava(Aeronave aeronava) {
        if (AeronaveParcate.contains(aeronava)) {
            AeronaveParcate.remove(aeronava);
            if (aeronava instanceof Avioane) {
                nr_avioane++;
            } else if (aeronava instanceof Elicoptere) {
                nr_elicoptere++;
            }
            System.out.println(aeronava + " a decolat cu succes din aeroportul " + nume);
        } else {
            System.out.println(aeronava + " nu se află în aeroportul " + nume + ". Decolare eșuată.");
        }
    }

    public void numarMaximPasageri(){
        if (AeronaveParcate.isEmpty()) {
            System.out.println("Nu exista aeronave la sol!");
            return;
        }

        int nr_maxim = 0;
        Avioane avionMaximLocuri = null;

        for(Aeronave aeronava : AeronaveParcate){
            if(aeronava instanceof Avioane){
                if(((Avioane) aeronava).getNr_locuri() > nr_maxim){
                    nr_maxim = ((Avioane) aeronava).getNr_locuri();
                    avionMaximLocuri = (Avioane) aeronava;
                }
            }
        }

        if (avionMaximLocuri != null) {
            System.out.println("Avionul cu cele mai multe locuri este: ");
            System.out.println(avionMaximLocuri.toString() + "locuri : " + nr_maxim);
        } else {
            System.out.println("Nu exista avioane la sol!");
        }
    }

    public void ElicoptereParcate(){
        if (AeronaveParcate.isEmpty()) {
            System.out.println("Nu exista aeronave la sol!");
            return;
        }

        List<Elicoptere> ElicoptereParcate = new ArrayList<>();

        for(Aeronave aeronava : AeronaveParcate){
            if(aeronava instanceof Elicoptere){
                ElicoptereParcate.add((Elicoptere) aeronava);
            }
        }

        if(ElicoptereParcate.isEmpty()){
            System.out.println("Nu exista elicoptere la sol!");
            return;
        }

        // DESC
        Collections.sort(ElicoptereParcate, Comparator.reverseOrder());

        for (Elicoptere elicopter : ElicoptereParcate) {
            System.out.println(elicopter);
        }
    }

    public int getNrAeronaveParcate(){
        return AeronaveParcate.size();
    }


}
