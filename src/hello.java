import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

class Hello extends JFrame {

	public Hello() {
		setLayout(new BorderLayout());
		add("South",new JButton("test"));
		add("Center",new JLabel("label"));
	}

	public static void main(String[] args) {
		Hello hel = new Hello();
		hel.setTitle("Swing Test");
		hel.setSize(500, 700);
		hel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hel.setVisible(true);

	} // main

}
