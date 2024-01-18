import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Aero_View extends JFrame {

    /// TEXT FIELDS ///
    private JTextField t_nume = new JTextField(20);
    private JTextField t_nr_avioane = new JTextField(11);
    private JTextField t_nr_elicoptere = new JTextField(10);


    /// LABELS ///
    private JLabel nume = new JLabel("Numele :");
    private JLabel nr_avioane = new JLabel("Numarul de avioane :");
    private JLabel nr_elicoptere = new JLabel("Numarul de eicoptere :");


    /// BUTTON ///
    private JButton ok = new JButton("Subbmit");

    public Aero_View(){

        //... Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout(FlowLayout.CENTER,10, 10));
        content.add(nume);
        content.add(t_nume);
        content.add(nr_avioane);
        content.add(t_nr_avioane);
        content.add(nr_elicoptere);
        content.add(t_nr_elicoptere);

        content.add(ok);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createAndOperateAirport();
            }
        });

        //... finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("Aeroport APP");
        this.setSize(350, 200);

        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    String get_Name(){
        return t_nume.getText();
    }

    String get_Avioane(){
        return t_nr_avioane.getText();
    }

    String get_Elicoptere(){
        return t_nr_elicoptere.getText();
    }

    private void createAndOperateAirport() {
        String nume = get_Name();
        String nr_avioane = get_Avioane();
        String nr_elicoptere = get_Elicoptere();

        int avioane = Integer.parseInt(nr_avioane);
        int elicoptere = Integer.parseInt(nr_elicoptere);

        Aeroport Aeroport_Nou = new Aeroport(nume, avioane, elicoptere);

        List<Aeronave> listaAeronave = new ArrayList<>();

        Avioane A1501 = new Avioane("RyanAir", "Boeing757", 100);
        Avioane A1601 = new Avioane("RyanAir", "AirBus", 200);
        Avioane A1791 = new Avioane("FlyEmirates", "Boeing757", 150);
        Avioane A1131 = new Avioane("FlyEmirates", "AirBus", 250);
        Avioane A1231 = new Avioane("AmericanAirlines", "Boeing757", 175);
        Avioane A1541 = new Avioane("AmericanAirlines", "AirBus", 300);
        Avioane A1651 = new Avioane("AmericanAirlines", "SuperJet", 25);

        Elicoptere E1101 = new Elicoptere("MAI", "BlackHawk", 12);
        Elicoptere E1201 = new Elicoptere("MAI", "EuroFighter", 15);
        Elicoptere E1141 = new Elicoptere("USMC", "BlackHawk", 20);
        Elicoptere E1541 = new Elicoptere("USMC", "EuroFighter", 10);
        Elicoptere E1651 = new Elicoptere("USMC", "Typhoon", 15);

        listaAeronave.add(A1501);
        listaAeronave.add(A1601);
        listaAeronave.add(A1791);
        listaAeronave.add(A1131);
        listaAeronave.add(A1231);
        listaAeronave.add(A1541);
        listaAeronave.add(A1651);
        listaAeronave.add(E1101);
        listaAeronave.add(E1201);
        listaAeronave.add(E1141);
        listaAeronave.add(E1541);
        listaAeronave.add(E1651);

        for (Aeronave aeronava : listaAeronave) {
            try {
                Aeroport_Nou.aterizeazaAeronava(aeronava);
                System.out.println(aeronava.toString() + " a aterizat cu succes!");
            } catch (Exception e) {
                System.out.println("Eroare la aterizare: " + e.getMessage());
            }
        }

        System.out.println("\nNumarul total de aeronave parcate : " + Aeroport_Nou.getNrAeronaveParcate() + "\n");

        Aeroport_Nou.decoleazaAeronava(A1601);
        Aeroport_Nou.decoleazaAeronava(A1231);
        Aeroport_Nou.decoleazaAeronava(A1541);

        Aeroport_Nou.decoleazaAeronava(E1651);
        Aeroport_Nou.decoleazaAeronava(E1101);

        System.out.println("\nNumarul total de aeronave parcate : " + Aeroport_Nou.getNrAeronaveParcate() + "\n");

        Aeroport_Nou.numarMaximPasageri();

        System.out.println("\nElicoptere la sol: \n");

        Aeroport_Nou.ElicoptereParcate();

    }

}
