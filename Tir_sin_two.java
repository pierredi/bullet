import java.awt.*;
import java.util.Iterator;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_sin_two extends TirMissile {
    private int compteur=0;


    public Tir_sin_two(int posx, int posy, int direction) {
        this.init(posx,posy,2,20, 5, direction,false,1,15,true);
        setColorShoot(Color.red);
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
        if(compteur%getFrequence()==0){
            ajoutBalles();
        }
    }

}
