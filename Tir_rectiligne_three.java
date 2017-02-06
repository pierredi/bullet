/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_three extends TirMissile {

    public Tir_rectiligne_three(int posx, int posy, int direction) {
        this.init(posx,posx,3,90, 13, direction,false,1,15);
        ajoutBalles();
    }
}
