/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_etoile_spin_8 extends TirMissile {

    public Tir_etoile_spin_8(int posx, int posy) {
        this.init(posx,posx,8,360, 7, 0,true,1,15);
        ajoutBalles();
    }
}
