package task2;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class WordCounter {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCounter() {
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        resultLabel = new JLabel();

        panel.add(scrollPane);
        panel.add(countButton);
        panel.add(resultLabel);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void countWords() {
        String userInput = textArea.getText();
        String text = readInput(userInput);

        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (!isStopWord(lowerCaseWord)) {
                wordCount++;
                wordFrequency.put(lowerCaseWord, wordFrequency.getOrDefault(lowerCaseWord, 0) + 1);
            }
        }

        resultLabel.setText("Total words: " + wordCount + " | Unique words: " + wordFrequency.size());
    }

    private String readInput(String userInput) {
        String text = "";
        if (userInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Input is empty.");
        } else {
            try {
                File file = new File(userInput);
                if (file.exists()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        text += fileScanner.nextLine() + " ";
                    }
                    fileScanner.close();
                } else {
                    text = userInput;
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(frame, "Error reading file.");
            }
        }
        return text;
    }

    private boolean isStopWord(String word) {
        String[] stopWords = {"the", "and", "is", "in", "it", "to", "of", "for", "with", "on"};
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounter();
            }
        });
    }
    
}



