import java.util.Iterator;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_spirale_one_left extends TirMissile {
    private int compteur=0;

    public Tir_spirale_one_left(int posx, int posy, int direction) {
        this.init(posx,posy,1,90, 5, direction,true,1,15);
        ajoutBalles();
    }

    public void update() {
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while (iter.hasNext()) {
            Bullet courant = iter.next();
            courant.update();
            if (!isAlive(courant)) {
                iter.remove();
            }
        }
        if(compteur%getFrequence()==0){
            updateRotation();
            ajoutBalles();
        }
    }

       private void updateRotation(){
            setDirection(getDirection() - getSpin());
        }

}
