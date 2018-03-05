package JOptionPaneBlackJack;

import javax.swing.JOptionPane;

public class Naytto {
    
    // määritetään kontrolleri, johon näyttö yhteydessä
    private Kontrolleri kontrolleri;
    
    
    
    // metodi luo näytön, joka sisältää perusvalikon.
    public void aloitusNaytto() {
        String valintaK;      // käyttäjän valinta merkkijonona
        int valinta;            // valinta numerona

        // päävalikko
        valintaK = JOptionPane.showInputDialog(null,
                "Tervetuloa kasinolle pelaamaan BlackJackiä! \n" +
                "Valitse toiminto (1-4) seuraavista: \n" +
                "       1:  Pelaa \n" +
                "       2:  Tarkastele taskujasi \n" +
                "       3:  Kassa \n" +
                "       4:  Poistu kasinolta \n" );

        // käyttäjän antama vastaus muutetaan numeroksi
        valinta = Integer.parseInt(valintaK);

        // ilmoitetaan kontrollerille käyttäjän valitsema toiminto
        switch (valinta) {
            case 1:
                kontrolleri.pelaa();
                break;
            case 2:
                kontrolleri.saldo();
                break;
            case 3:
                kontrolleri.kassa();
                break;
            case 4:
                kontrolleri.lopetus();
                break;
            default:
                aloitusNaytto();
        }

    }

    // näytön toimintoja
    public void naytaViesti(String viesti) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, viesti);
    }
    
    public String kysyTieto(String kysymys) {
        // kysymys toimii parametrina, metodi palauttaa käyttäjän antaman vastauksen 
        return JOptionPane.showInputDialog(kysymys);
    }
                                        

    public void rekisteroiOhjain(Kontrolleri ohjain) {
        // näyttö saa tiedon kontrollerista, jolle se välittää pyyntöjä
        this.kontrolleri = ohjain;
    }

}