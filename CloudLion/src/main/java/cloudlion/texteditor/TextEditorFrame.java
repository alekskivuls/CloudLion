package cloudlion.texteditor;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextEditorFrame extends JDialog implements ActionListener, KeyListener {

	TextEditor parent;
	JLabel label;
	JTextField textField;
	JButton find, close;
	boolean finishedFinding = true;
	Matcher matcher;

	public TextEditorFrame(TextEditor parent, boolean modal) {
		super(parent, modal);
		this.parent = parent;
		getContentPane().addKeyListener(this);
		getContentPane().setFocusable(true);
		initComponents();
		setTitle("Find");
		setLocationRelativeTo(parent);
		pack();
	}

	public void showDialog() {
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new GridLayout(3, 1));
		JPanel panel1 = new JPanel();
		label = new JLabel("Find : ");
		label.setDisplayedMnemonic('F');
		panel1.add(label);
		textField = new JTextField(15);
		panel1.add(textField);
		label.setLabelFor(textField);
		add(panel1);
		JPanel panel3 = new JPanel();
		close = new JButton("Close");
		close.addActionListener(this);
		panel3.add(close);
		add(panel3);
		textField.addKeyListener(this);
		close.addKeyListener(this);
	}

	private void closeDialog() {
		setVisible(false);
		dispose();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			closeDialog();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Close")) {
			closeDialog();
		}
	}

}