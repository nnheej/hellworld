import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
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

class Hello {

	public static void main(String[] args) throws ParseException{
		DecimalFormat df = new DecimalFormat();
		Number num = df.parse("123,456.78");
		System.out.println(num.doubleValue());
		
		
		double number = 123456.37;
		DecimalFormat df2 = new DecimalFormat("0000,0000.00"); //만자리
		DecimalFormat df3 = new DecimalFormat("000,000.00"); //천자리 - 0
		DecimalFormat df4 = new DecimalFormat("###,###.##"); //천자리 - #
		DecimalFormat df5 = new DecimalFormat("###.#"); //소수점 둘째자리에서 반올림
		System.out.println("number : "+number);
		System.out.println("0000,0000.00 : "+df2.format(number));
		System.out.println("000,000.00 : " +df3.format(number));
		System.out.println("###,###.## : "+df4.format(number));
		System.out.println("###.# : " + df5.format(number));
		
		
		
	} // main

}
