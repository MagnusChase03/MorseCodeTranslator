import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Runner extends JFrame {

	JPanel panel;
	JTextField text;
	JButton encode;
	JButton decode;
	MorseTree mt;
	
	void encode() {
		
		text.setText(mt.encode(text.getText().toUpperCase()));
		
	}
	
	void decode() {
		
		text.setText(mt.translate(text.getText()));
		
	}
	
	void setDefaults() {
		
		setTitle("Morse Translator");
		setSize(800, 630);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 0));
		add(panel);
		
	}
	
	void addGUI() {
		
		text = new JTextField();
		JScrollPane textScroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textScroll.setBounds(250, 250, 300, 50);
		text.setFont(new Font("monospace", Font.PLAIN, 20));
		text.setMargin(new Insets(0, 10, 0, 0));
		text.setBackground(new Color(50, 0, 80));
		text.setForeground(new Color(180, 180, 180));
		panel.add(textScroll);
		
		encode = new JButton("Encode");
		encode.setBounds(250, 310, 150, 50);
		encode.setFont(new Font("monospace", Font.PLAIN, 20));
		encode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                encode();

            }
        });
		encode.setBackground(new Color(50, 0, 80));
		encode.setForeground(new Color(180, 180, 180));
		panel.add(encode);
		
		decode = new JButton("Decode");
		decode.setBounds(400, 310, 150, 50);
		decode.setFont(new Font("monospace", Font.PLAIN, 20));
		decode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                decode();

            }
        });
		decode.setBackground(new Color(50, 0, 80));
		decode.setForeground(new Color(180, 180, 180));
		panel.add(decode);
		
	}
	
	Runner() {
	
		setDefaults();		
		addGUI();
		setVisible(true);
		
		mt = new MorseTree("", new MorseTree("E", new MorseTree("I", new MorseTree("S", new MorseTree("H"), new MorseTree("V")), new MorseTree("U", new MorseTree("F"), new MorseTree(""))), new MorseTree("A", new MorseTree("R", new MorseTree("L"), new MorseTree("")), new MorseTree("W", new MorseTree("P"), new MorseTree("J")))), new MorseTree("T", new MorseTree("N", new MorseTree("D", new MorseTree("B"), new MorseTree("X")), new MorseTree("K", new MorseTree("C"), new MorseTree("Y"))), new MorseTree("M", new MorseTree("G", new MorseTree("Z"), new MorseTree("Q")), new MorseTree("O"))));
		
	}
	
	public static void main(String[] args) {
	
		new Runner();
		
		
	}

}
