import java.awt.*;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_one extends TirMissile {

    public Tir_rectiligne_one(int posx, int posy, int direction) {
        this.init(posx,posy,1,180, 17, direction,false,1,15);
        setColorShoot(Color.blue);
        ajoutBalles();
    }
}
