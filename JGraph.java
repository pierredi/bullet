import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by osboxes on 30/01/17.
 */
public class JGraph extends JPanel implements ActionListener {

    Timer timer;
    private List<TirMissile> canon = new ArrayList<>();
    private TirMissile tir,tir1,tir2,tir3;

    public JGraph (int tempo){
        super();
        init();
        timer = new Timer(tempo, this);
        timer.start();
    }

    public void init(){
        setBounds(0,0,800,600);
        tir = new Tir_rectiligne_one(100,100, 0);
        tir1 = new Tir_rectiligne_two(200,100, 90);
        tir2 = new Tir_rectiligne_three(300,100, 90);
        tir3 = new Tir_etoile_spin_8(600,200);
        canon.add(tir);
        canon.add(tir1);
        canon.add(tir2);
        canon.add(tir3);
    }

    public void paint(Graphics g){
        super.paint(g);
        Color c = g.getColor();
        affichage(g);
        g.setColor(c);
    }

    private void affichage(Graphics g){
        Iterator<TirMissile> iter = canon.iterator();
        while(iter.hasNext()){
            TirMissile coudDeFeu = iter.next();
            coudDeFeu.affichage(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == timer){
            repaint();
        }
    }
}
