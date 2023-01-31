import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;


public class Delfintranet {
    public static JTextField textField;
    public static JTextArea textArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Delfintranet Administrationssystem");
        JButton button1 = new JButton("Click click");
        JButton button2 = new JButton("Click click------");
        JButton button3 = new JButton("Åben Fil");
        JButton button4 = new JButton("Gem -> CSV");
        JButton button5 = new JButton("Gem -> txt");
        JButton button6 = new JButton("Ryd");
        //JButton button7 = new JButton("Skyd");
        textField = new JTextField(35);
        textArea = new JTextArea(18, 35);
        button1.addActionListener(new ButtonClickListener1());
        button2.addActionListener(new ButtonClickListener2());
        button3.addActionListener(new ButtonClickListener3());
        button4.addActionListener(new ButtonClickListener4());
        button5.addActionListener(new ButtonClickListener5());
        button6.addActionListener(new ButtonClickListener6());
        frame.setLayout(new FlowLayout());
        frame.add(button1); //Konverterer tal til binær kode
        frame.add(button2); //Skriver click click i konsollen og textarea
        frame.add(textField);
        frame.add(button3); //Åbner stifinder user home folder
        frame.add(button4); //Gem textarea som csv fil
        frame.add(button5); //Gem textarea som txt fil 
        frame.add(button6); //Ryd textarea
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 800); //Application window size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

class ButtonClickListener1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //Delfintranet.textArea.append("you clicked me!\n");
        String input = Delfintranet.textField.getText();
        try {
            int num = Integer.parseInt(input);
            String binary = Integer.toBinaryString(num);
            Delfintranet.textArea.append("Binary representation: " + binary + "\n");
        } catch (NumberFormatException ex) {
            Delfintranet.textArea.append("Please enter a valid integer.\n");
        }
    }
}

class ButtonClickListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Delfintranet.textArea.append("Click click\n");
    }
}

class ButtonClickListener3 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Delfintranet.textArea.append("Click click\n");
        try {
            //Desktop.getDesktop().open(new File(System.getProperty("user.home")));
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
               File selectedFile = fileChooser.getSelectedFile();
               BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
               String line;
               while ((line = reader.readLine()) != null) {
                  Delfintranet.textArea.append(line);
               }
               reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ButtonClickListener4 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Delfintranet.textArea.append("\n");
        try {
            String path = System.getProperty("user.dir");
            String fileName = "output.csv";
            System.out.println(path);
            FileWriter writer = new FileWriter(fileName);
            Delfintranet.textArea.append("Path: " + path + "\n");
            Delfintranet.textArea.append("Filename: " + fileName);
            writer.write(Delfintranet.textArea.getText());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ButtonClickListener5 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Delfintranet.textArea.append("\n");
        try {
            String path = System.getProperty("user.dir");
            String fileName = "output.txt";
            System.out.println(path);
            FileWriter writer = new FileWriter(fileName);
            Delfintranet.textArea.append("Path: " + path + "\n");
            Delfintranet.textArea.append("Filename: " + fileName);
            writer.write(Delfintranet.textArea.getText());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ButtonClickListener6 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Delfintranet.textArea.setText("");
    }
}
