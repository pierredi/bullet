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
    private TirMissile tir,tir1,tir2,tir3,tir4,tir5,tir6,tir7,tir8, tirSin, tirSin2,tirSin3;

    public JGraph (int tempo){
        super();
        init();
        timer = new Timer(tempo, this);
        timer.start();
    }

    public void init(){
        setBounds(0,0,800,600);
        tir = new Tir_rectiligne_one(100,100, 60);
        tir1 = new Tir_rectiligne_two(200,100, 0);
        tir2 = new Tir_rectiligne_three(300,100, 270);
        tir3 = new Tir_etoile_spin_8(400,200);
        tir4 = new Tir_spirale_one_left(400,300,10);
        tir5 = new Tir_spirale_two_left(100,300,10);
        tir6 = new Tir_spirale_three_left(300,300,10);
        tir7 = new Tir_ring_50(400,400,10);
        tir8 = new Tir_rectiligne_explo(100,100,0);
        tirSin =  new Tir_sin_one( 200,200,45);
        tirSin2 =  new Tir_sin_two( 300,400,270);
        tirSin3 =  new Tir_sin_three( 300,400,270);
        //canon.add(tir);
        //canon.add(tir1);
        //canon.add(tir2);
        canon.add(tir3);
        //canon.add(tir4);
        //canon.add(tir5);
        //canon.add(tir6);
        //canon.add(tir7);
        //canon.add(tirSin);
        //canon.add(tirSin2);
        //canon.add(tirSin3);
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
