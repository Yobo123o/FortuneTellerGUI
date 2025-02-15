import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * FortuneTellerFrame - A compact GUI program that provides a random fortune.
 */
public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneDisplay;
    private final ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    /**
     * Constructor to set up the Fortune Teller GUI.
     */
    public FortuneTellerFrame() {
        setTitle("The Fortune Teller");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // --- Top Panel (Title Above Image) ---
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Madam Theodosia, the Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 22));
        topPanel.add(titleLabel, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon("fortune_icon.png");
        Image scaledImage = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage), JLabel.CENTER);
        topPanel.add(iconLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // --- Middle Panel: Fortune Display ---
        fortuneDisplay = new JTextArea(10, 30);
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fortuneDisplay.setEditable(false);
        fortuneDisplay.setWrapStyleWord(true);
        fortuneDisplay.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        scrollPane.setPreferredSize(new Dimension(350, 150));
        add(scrollPane, BorderLayout.CENTER);

        // --- Bottom Panel: Buttons ---
        JPanel bottomPanel = new JPanel();
        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        fortuneButton.setFont(new Font("Arial", Font.BOLD, 14));
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        fortunes = new ArrayList<>();
        populateFortunes();

        fortuneButton.addActionListener(e -> displayNewFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    /**
     * Populates the fortune list with absurd and wacky fortunes.
     */
    private void populateFortunes() {
        fortunes.add("Your pet is plotting a coup. Watch out.");
        fortunes.add("Tomorrow, you will inexplicably crave pickles and regret nothing.");
        fortunes.add("A pigeon will steal your lunch and your dignity.");
        fortunes.add("Someone you know is secretly a time traveler.");
        fortunes.add("You will discover a hidden talent for yodeling.");
        fortunes.add("Beware of sock gnomes. They are multiplying.");
        fortunes.add("Your next sneeze will change the course of history.");
        fortunes.add("A mysterious cat will adopt you. Resistance is futile.");
        fortunes.add("Don't trust elevators today. Take the stairs.");
        fortunes.add("Your left shoe knows too much.");
        fortunes.add("A spoon will change your life. Stay alert.");
        fortunes.add("The letter Q will hold special significance today.");
    }

    /**
     * Displays a new fortune and appends it to the list.
     */
    private void displayNewFortune() {
        Random rand = new Random();
        int index;
        do {
            index = rand.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);

        lastFortuneIndex = index;
        fortuneDisplay.append(fortunes.get(index) + "\n");
    }
}
