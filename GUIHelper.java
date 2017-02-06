import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by osboxes on 30/01/17.
 */
public class GUIHelper {

    public static void showOnFrame(JComponent component, String framName){
        JFrame frame = new JFrame(framName);
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        };
        frame.addWindowListener(wa);
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);
    }
}
