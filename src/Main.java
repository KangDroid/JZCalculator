import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9188896338975716816L;
	private JPanel contentPane;
	private JTextField average;
	private JTextField score;
	private JTextField deviation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void calculateZScore() { //score - average / deviation
		if ( average.getText().length() != 0 && score.getText().length() != 0 && deviation.getText().length() != 0) {
			double averageString = Double.parseDouble(average.getText());
			double scoreString = Double.parseDouble(score.getText());
			double deviationString = Double.parseDouble(deviation.getText());
			double n = (scoreString-averageString)/deviationString;
			JOptionPane.showMessageDialog(this, "Your Z score is:" + n, null, JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "One or more field is empty. please fill it in.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
    }

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTesting = new JLabel("Z score calculator");
		lblTesting.setBounds(5, 5, 440, 16);
		contentPane.add(lblTesting);
		
		JButton btnChoiceTwo = new JButton("calculate");
		btnChoiceTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateZScore();
			}
		});
		btnChoiceTwo.setBounds(256, 169, 189, 80);
		btnChoiceTwo.setMnemonic('a');
		contentPane.add(btnChoiceTwo);
		
		// Average
		average = new JTextField();
		average.setBounds(88, 28, 130, 26);
		contentPane.add(average);
		average.setColumns(10);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setBounds(15, 33, 61, 16);
		contentPane.add(lblAverage);
		
		// Score
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(15, 76, 61, 16);
		contentPane.add(lblScore);
		
		score = new JTextField();
		score.setBounds(88, 71, 130, 26);
		contentPane.add(score);
		score.setColumns(10);
		
		// Deviation
		JLabel lblStandarddeviation = new JLabel("Deviation");
		lblStandarddeviation.setBounds(15, 118, 66, 16);
		contentPane.add(lblStandarddeviation);
		
		deviation = new JTextField();
		deviation.setBounds(88, 113, 130, 26);
		contentPane.add(deviation);
		deviation.setColumns(10);
		
		// Announcement??
		JLabel lblNewLabel = new JLabel("<html>Only numbers are available. Otherwise, app <br> will force close.</html>");
		lblNewLabel.setBounds(269, 45, 176, 87);
		contentPane.add(lblNewLabel);
	}
}
