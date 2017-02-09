import java.awt.*;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_two extends TirMissile {

    public Tir_rectiligne_two(int posx, int posy, int direction) {
        this.init(posx,posy,2,30, 17, direction,false,1,15);
        setColorShoot(Color.blue);
        ajoutBalles();
    }

}
