import javax.swing.*;

/**
 * The main class that launches the compact Fortune Teller GUI.
 */
public class FortuneTellerViewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
