/*
 *code by Reed Dahle
 *last updated 01-31-2019 @ 21:44
 *My dad works at oracle so if you steal my code without attributing me I can have you banned kid
 */
package calcUI;

import java.awt.EventQueue;   //stupid window builder add in won't let me remove useless imports

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.script.*;

public class CalcStartNew{		//also don't ask why its called CalcStartNew

	private JFrame frame;									//create all class level evaluators
	CalcEval doEval = new CalcEval();                       //final evaluator
	ExponentEvaluator evalExp = new ExponentEvaluator();    //exponent evaluator ( actually just replaces ^ with Math.pow() )
	String evalString = ""; 								//string taken from textArea and put into evaluators

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcStartNew window = new CalcStartNew();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcStartNew(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();						          //all of this code should be pretty self explanatory; just adds a character to textArea when its button is pressed
		frame.setTitle("Calculator"); 
		frame.setBounds(100, 100, 900, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 12, 876, 138);
		frame.getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 162, 175, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			textArea.setText(textArea.getText()+"1");
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			textArea.setText(textArea.getText()+"2");
			}
		});
		panel.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"3");
			}
		});
		panel.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"4");
			}
		});
		panel.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"5");
			}
		});
		panel.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"6");
			}
		});
		panel.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"7");
			}
		});
		panel.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"8");
			}
		});
		panel.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"9");
			}
		});
		panel.add(button_8);
		
		JButton button_9 = new JButton("0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"0");
			}
		});
		panel.add(button_9);
		
		JButton button_10 = new JButton(".");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"."); 
			}
		});
		panel.add(button_10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(199, 162, 200, 246);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton button_11 = new JButton("+");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"+");
			}
		});
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("-");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"-");
			}
		});
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("*");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"*");
			}
		});
		panel_1.add(button_13);
		
		JButton btnC = new JButton("/");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"/");
			}
		});
		panel_1.add(btnC);
		
		JButton button_15 = new JButton("(");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"(");
			}
		});
		panel_1.add(button_15);
		
		JButton button_16 = new JButton(")");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+")");
			}
		});
		panel_1.add(button_16);
		
		JButton button_17 = new JButton("^");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText()+"^");
			}
		});
		panel_1.add(button_17);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(788, 162, 100, 246);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton button_14 = new JButton("=");					//here's where the good stuff happens
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evalString = textArea.getText();				//get eval string from textArea
				while (evalString.contains("^"))				//run the exponent replacer until they're all gone
				{
					evalString = evalExp.Evaluate(evalString);
				}
				double myDouble = 0;							//double that answer will be stored in. we'll touch it up a little later in the code
				try
				{
					myDouble = doEval.Calculate(evalString);
				}
				catch(ScriptException se)
				{
					textArea.setText("error");					//honestly this is just a formality. it wont ever happen and ScriptEngineManager isn't happy without catching ScriptException. If calc actually errors it displays 0
				}
				String calcOutput = Double.toString(myDouble);
				if((calcOutput.charAt(calcOutput.length()-1) == '0') && (calcOutput.charAt(calcOutput.length()-2) == '.')) //check to see if answer ends in .0
				{
					calcOutput = calcOutput.substring(0, calcOutput.indexOf('.'));                                         // if so, it removes it b4 displaying
				}
				textArea.setText(calcOutput);                                                                              //obvious
			}
		});
		panel_2.add(button_14);
		
		JButton btnC_1 = new JButton("C");						//clears textArea when C button is pressed
		btnC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		panel_2.add(btnC_1);
	}
}
