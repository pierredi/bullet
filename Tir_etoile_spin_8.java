import java.awt.*;
import java.util.Iterator;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_etoile_spin_8 extends TirMissile {

    private boolean horaire = true;
    private boolean accelere = true;
    private int cpt=0;

    public Tir_etoile_spin_8(int posx, int posy) {
        this.init(posx,posx,8,360, 7, 0,true,1,15,true);
        setColorShoot(Color.green);
        ajoutBalles();
    }

    public void update(){
        cpt++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!this.isAlive(courant)){
                iter.remove();
            }
        }
        if(cpt%getFrequence()==0){
            if(this.isRotation()){
                updateRotation();
            }
            ajoutBalles();
        }
    }

    private void updateRotation(){
        if(horaire){
            setDirection(getDirection() + getSpin());
        } else {
            setDirection(getDirection() - getSpin());
        }
        if (accelere){
            setSpin(1.91d*getSpin());
        } else {
            setSpin(0.8d * getSpin());
        }
        if (getSpin() > getMaxSpin()){
            accelere=false;
        }
        if (getSpin() < getMinSpin()){
            accelere=true;
            horaire = !horaire;
        }
    }
}
