import java.awt.*;

/**
 * Created by osboxes on 30/01/17.
 */
public class Demo {

    public static void main(String[] args){
        JGraph jg = new JGraph(10);
        jg.setBackground(Color.WHITE);
        jg.setPreferredSize(new Dimension(800,600));
        GUIHelper.showOnFrame(jg,"test");
    }
}
