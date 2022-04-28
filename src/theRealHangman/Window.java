package theRealHangman;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	private JPanel contentPane;
	public static JTextField letter;
	public static String typeAnswer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hangman");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 0, 164, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("type a letter and guess the word");
		lblNewLabel_1.setBounds(10, 78, 200, 19);
		contentPane.add(lblNewLabel_1);
	
		Hangman hangman = new Hangman();
		String sterne = hangman.getAsterisk();
		
		JLabel lblNewLabel_2 = new JLabel(sterne);
		lblNewLabel_2.setBounds(10, 39, 103, 19);
		contentPane.add(lblNewLabel_2);
		
		letter = new JTextField(2);
		letter.setBounds(10, 117, 96, 20);
		contentPane.add(letter);
		letter.setColumns(10);
		
		AbstractAction action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bla bla bla");
			}
		};
				
		letter.addActionListener( action );
			
		

		String images = hangman.hangmanImage();
		ImageContainer feedback = new ImageContainer();
		feedback.setBounds(382, 80, 328, 250);
		contentPane.add(feedback);
		
		
		JButton btnNewButton = new JButton("submit");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeAnswer = letter.getText().toUpperCase();
				hangman.hang(typeAnswer);
				letter.setText("");
				System.out.println(typeAnswer);
				
				String images = hangman.hangmanImage();
				if(images != null) {
					feedback.setIcon(images);
				}
				
				String sterne = hangman.getAsterisk();
				lblNewLabel_2.setText(sterne);
			}
		
		});
		btnNewButton.setBounds(127, 116, 96, 23);
		contentPane.add(btnNewButton);
		
		
		
		Hangman words = new Hangman();
		String hello = words.getWord().toUpperCase();
		System.out.println(hello);
		
		
	
			  
	}
}
