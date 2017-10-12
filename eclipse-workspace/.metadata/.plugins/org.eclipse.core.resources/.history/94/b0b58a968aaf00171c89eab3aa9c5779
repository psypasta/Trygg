import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UIFrame extends JFrame {
	
	//konstanter för fönster storlek
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;
	
	private JPanel panel, radioPanel;
	
	private ButtonGroup bg;
	
	private JRadioButton plusRB, minusRB, multiRB, divisionRB;

	private JLabel lblA, lblB;

	private JTextField inputA, inputB;
	private JButton calcBtn;
	
	private Calculator calc;
	
	public UIFrame() {
		calc = new Calculator();
		setTitle("Calculator");
		
		createTextFields();
		createRB();
		createBtn();
		createPanels();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); //center frame
	}
	
	private void createTextFields() {
		lblA = new JLabel("A: ");
		lblB = new JLabel("B: ");
		inputA = new JTextField(3);
		inputB = new JTextField(3);
	}
	
	private void createRB() {
		bg = new ButtonGroup();
		plusRB = new JRadioButton("+");
		minusRB = new JRadioButton("-");
		multiRB = new JRadioButton("*");
		divisionRB = new JRadioButton("/");
		
		bg.add(plusRB);
		bg.add(minusRB);
		bg.add(multiRB);
		bg.add(divisionRB);
	}
	
	private void createBtn() {
		calcBtn = new JButton("Calculate");
		
		class CalcListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calc.setData(Double.parseDouble(inputA.getText()), Double.parseDouble(inputB.getText()));
				
				int decision = 0;

				if(plusRB.isSelected()) decision = 1;
				if(minusRB.isSelected()) decision = 2;
				if(multiRB.isSelected()) decision = 3;
				if(divisionRB.isSelected()) decision = 4;
				
				calc.calculate(decision);	
				
				JOptionPane.showMessageDialog(null, "Result is: " + calc.getResult());
			
			}
			
		}
		
		ActionListener listen = new CalcListener();
		calcBtn.addActionListener(listen);
		
	}
	
	private void createPanels() {
		radioPanel = new JPanel();
		radioPanel.add(plusRB);
		radioPanel.add(minusRB);
		radioPanel.add(multiRB);
		radioPanel.add(divisionRB);
		
		panel = new JPanel();
		panel.add(lblA);
		panel.add(inputA);
		panel.add(lblB);
		panel.add(inputB);
		panel.add(radioPanel);
		panel.add(calcBtn);
		add(panel);
	}
}
