import java.awt.*;
import java.util.Iterator;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_ring_50 extends TirMissile {
    private int compteur =0;

    public Tir_ring_50(int posx, int posy, int direction) {
        this.init(posx,posx,50,380, 17, direction,false,1,15);
        ajoutBalles();
    }

    public void update(){
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!isAlive(courant)){
                iter.remove();
            }
        }
    }

}
