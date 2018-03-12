package JOptionPaneBlackJack;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Naytto {

  // määritetään kontrolleri, johon näyttö yhteydessä
  private Kontrolleri kontrolleri;
  private final License license = new License();
  private final PelinSaannot saannot = new PelinSaannot();

  ImageIcon iconA = new ImageIcon(Naytto.class.getResource("jc.gif"));
  ImageIcon iconB = new ImageIcon(Naytto.class.getResource("js.gif"));

  // metodi luo näytön, joka sisältää perusvalikon.
  public void aloitusNaytto() {
    String valintaK;      // käyttäjän valinta merkkijonona
    int valinta;            // valinta numerona

    String msg = "<html><b><font size=80>🂫</font>Tervetuloa kasinolle pelaamaan BlackJackiä<font size=80>🃛</font></b><br>"
            + "<i>Valitse toiminto <font color=#993d00>(1-6)</font> seuraavista:</i><br><br>"
            + "<b>1:  Pelaa♣<br>"
            + "2:  Tarkastele taskujasi<font color=#F11B2D>♥</font><br>"
            + "3:  Kassa♠<br>"
            + "4:  Peliohjeet<font color=#F11B2D>♦</font><br>"
            + "5:  Lisenssi♣<br>"
            + "6:  Poistu kasinolta<font color=#F11B2D>♥</font></b>"
            + "</BODY > < / html >";
    JLabel message = new JLabel(msg);
    message.setFont(new Font("Verdana", Font.PLAIN, 16));
    message.setForeground(new Color(0x2F2D2D));

    do {

      // päävalikko
      valintaK = JOptionPane.showInputDialog(null, message,
              "B  L  A  C  K    J A C K    21", JOptionPane.PLAIN_MESSAGE);
      if (valintaK == null) {
        valintaK = "6";
      }
    } while (valintaK.length() == 0);
    try {
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
          saannot.kerrosaannot();
          aloitusNaytto();
          break;
        case 5:
          license.LicenseInfo();
          aloitusNaytto();
          break;
        case 6:
          kontrolleri.lopetus();
          break;
        default:
          aloitusNaytto();
      }

    } catch (Exception e) {

      try {
        kontrolleri.lopetus();
      } catch (FileNotFoundException ex) {
        Logger.getLogger(Naytto.class.getName()).log(Level.SEVERE, null, ex);
      }

    }

  }

  // näytön toimintoja
  public void naytaViesti(String viesti) {
    // Parametrina näytettävä viesti
    JOptionPane.showMessageDialog(null, viesti, null, JOptionPane.PLAIN_MESSAGE, iconA);
  }

  public String kysyTieto(String kysymys) {
    // kysymys toimii parametrina, metodi palauttaa käyttäjän antaman vastauksen 
    return JOptionPane.showInputDialog(null, kysymys, null, JOptionPane.PLAIN_MESSAGE);
  }

  public int kassalla(String jotain) {
    Object[] napit = {"Euroja chipeiksi", "Chippejä euroiksi"};

    return JOptionPane.showOptionDialog(null,
            jotain,
            "Kassalla", //yläpalkin teksti
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, //liittyy kuvaan/ikoniin
            napit, //napit
            napit[0]);
  }

  public int otatkoKortin(String viesti) {
    Object[] napit = {"Ota kortti", "Päätä vuorosi"};

    return JOptionPane.showOptionDialog(null,
            viesti,
            null, //tähän mitä yläpalkis lukee
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, //tää liittyy kuvaan/ikoniin
            napit, //napit
            napit[0]);
  }

  public void rekisteroiOhjain(Kontrolleri ohjain) {
    // näyttö saa tiedon kontrollerista, jolle se välittää pyyntöjä
    this.kontrolleri = ohjain;
  }

}
