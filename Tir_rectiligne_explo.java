import java.awt.*;
import java.util.Iterator;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_explo extends TirMissile {
    private int compteur = 0;

    public Tir_rectiligne_explo(int posx, int posy, int direction) {
        this.init(posx,posy,1,90, 27, direction,false,1,15);
        ajoutBalles();
    }

    public void update(){
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!isAlive(courant)||compteur==10){
                TirMissile ring =  new Tir_ring_50((int)courant.getPosx(),(int)courant.getPosy(),(int)courant.getDirection());
                setBalles(ring.getBalles());
                iter.remove();
            }
        }
    }

}
