import java.awt.*;

/**
 * Created by osboxes on 06/02/17.
 */
public class Tir_rectiligne_two extends TirMissile {

    public Tir_rectiligne_two(int posx, int posy, int direction) {
        this.init(posx,posx,2,90, 17, direction,false,1,15, Color.GREEN);
        ajoutBalles();
    }
}
