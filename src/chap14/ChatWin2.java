package chap14;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

class ChatWin2 extends Frame {
	String nickname = "";
	TextArea ta = new TextArea();
	Panel p = new Panel();
	TextField tf = new TextField(30);
	Button bSave = new Button("저장");

	ChatWin2(String nickname) {
		super("Chatting");
		this.nickname = nickname;
		setBounds(200, 100, 300, 200);
		p.setLayout(new FlowLayout());
		p.add(tf, "Center");
		p.add(bSave, "Center");
		add(ta, "Center");
		add(p, "South");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		bSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				FileDialog fileSave = new FileDialog(ChatWin2.this, "파일저장",
						FileDialog.SAVE);
				fileSave.setVisible(true);
				String fileName = fileSave.getDirectory() + fileSave.getFile();
				try {
					saveAs(fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		ta.setText("#" + nickname + "님 즐거운 채팅되세요.");
		ta.setEditable(false);
		setResizable(false);
		setVisible(true);
		tf.requestFocus();
	}

	void saveAs(String fileName) throws IOException {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(ta.getText());
		System.out.println(tf.getText());
		
	} // saveAs메서드의 끝

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java ChatWin2 NICKNAME");
			System.exit(0);
		}
		new ChatWin2(args[0]);
	} // main

	class EventHandler extends FocusAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String msg = tf.getText();
			if ("".equals(msg))
				return;
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
		}

		public void focusGained(FocusEvent e) {
			tf.requestFocus();
		}
	} // class EventHandler
} // class