import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by osboxes on 30/01/17.
 */
public class JGraph extends JPanel implements ActionListener {

    Timer timer;
    private TirMissile testtir;

    public JGraph (int tempo){
        super();
        init();
        timer = new Timer(tempo, this);
        timer.start();
    }

    public void init(){
        setBounds(0,0,800,600);
        //testtir = new Tir_rectiligne_one(100,100, 30);
        //testtir2 = new Tir_rectiligne_two(200,100, 30);
        //testtir3 = new Tir_rectiligne_three(300,100, 30);
        testtir = new Tir_etoile_spin_8(200,200);
    }

    public void paint(Graphics g){
        super.paint(g);
        Color c = g.getColor();
        affichage(g);
        g.setColor(c);
    }

    private void affichage(Graphics g){
        this.testtir.affichage(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == timer){
            repaint();
        }
    }
}
