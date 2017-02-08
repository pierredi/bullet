import java.awt.*;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_three extends TirMissile {
    private int compteur=0;

    public Tir_rectiligne_three(int posx, int posy, int direction) {
        this.init(posx,posx,3,45, 13, direction,false,1,15);
        setColorShoot(Color.blue);
        ajoutBalles();
    }

}
