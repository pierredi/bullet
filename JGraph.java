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
    private Shoot tir;
    private Shoot tir2;

    public JGraph (int tempo){
        super();
        init();
        timer = new Timer(tempo, this);
        timer.start();
    }

    public void init(){
        setBounds(0,0,800,600);
        tir = new Shoot(400,300,4, 90,2, 10, true);
        tir2 = new Shoot(400,300,4, 90,2, 190, true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Color c = g.getColor();
        affichage(g);
        g.setColor(c);
    }

    private void affichage(Graphics g){
        this.tir.affichage(g);
        this.tir2.affichage(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == timer){
            repaint();
            //tir.testSpeed();
        }
    }
}
