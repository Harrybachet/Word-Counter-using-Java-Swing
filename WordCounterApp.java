import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JLabel paragraphCountLabel;

    public WordCounterApp() {
        // Set up the JFrame
        setTitle("Word Counter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea();
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");
        paragraphCountLabel = new JLabel("Paragraphs: 0");
        JButton countButton = new JButton("Count");

        // Add action listener to the button
        countButton.addActionListener(this);

        // Set up the layout
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 4));
        panel.add(wordCountLabel);
        panel.add(charCountLabel);
        panel.add(paragraphCountLabel);
        panel.add(countButton);
        add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();

        // Count words, characters, and paragraphs
        int wordCount = countWords(text);
        int charCount = countCharacters(text);
        int paragraphCount = countParagraphs(text);

        // Update the labels
        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
        paragraphCountLabel.setText("Paragraphs: " + paragraphCount);
    }

    private int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

    private int countCharacters(String text) {
        return text.length();
    }

    private int countParagraphs(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\n+").length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounterApp app = new WordCounterApp();
            app.setVisible(true);
        });
    }
}
