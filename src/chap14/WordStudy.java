package chap14;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class WordStudy extends Frame {
	Button first = new Button("<<");
	Button prev = new Button("<");
	Button next = new Button(">");
	Button last = new Button(">>");
	Panel buttons = new Panel();
	TextArea ta = new TextArea();
	ArrayList wordList = new ArrayList();
	final String WORD_FILE = "word_data.txt";
	final String CR_LF = System.getProperty("line.separator");
	int pos = 0;

	WordStudy(String title) {
		super(title);
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		add("South", buttons);
		add("Center", ta);
		EventHandler handler = new EventHandler();
		addWindowListener(handler);
		first.addActionListener(handler);
		prev.addActionListener(handler);
		next.addActionListener(handler);
		last.addActionListener(handler);
		loadFile(WORD_FILE);
		setBackground(Color.BLACK);
		setSize(300, 200);
		setLocation(200, 200);
		setResizable(true);
		setVisible(true);
		showFirst();
	}

	void showFirst() {
		pos = 0;
		display(pos);
	}

	void showPrevious() {
		pos = (pos > 0) ? --pos : 0;
		display(pos);
	}

	void showNext() {
		int size = wordList.size();
		pos = (pos < size - 1) ? ++pos : size - 1;
		display(pos);
	}

	void showLast() {
		pos = wordList.size() - 1;
		display(pos);
	}

	void display(int pos) { // pos위치에 있는 라인의 내용을 보여준다.
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. wordList에서 pos번째의 위치에 있는 데이터를 읽어온다. 2.
		 * StringTokenizer를 이용해서 ‘|’를 구분자로 자른다. 3. 잘라진 Token에 개행문자(CR_LF)를 붙여서
		 * StringBuffer에 붙인다.(append) 4. StringBuffer의 내용을 뽑아서 TextArea에 보여준다.
		 */
		String list = (String) wordList.get(pos);
		System.out.println(list);
		StringTokenizer st = new StringTokenizer(list, "|");
		StringBuffer word = new StringBuffer();
		while (st.hasMoreTokens()) {
			word.append(st.nextToken());
			word.append(CR_LF);
			ta.setText(word.toString());
		}

	}

	void loadFile(String fileName) {
		/*
		 * (2) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. BuffredReader와 FileReader를 이용해서 파일의 내용을
		 * 라인 단위로 읽는다. 2. 읽어온 라인을 wordList에 저장한다. 3. 만일 예외가 발생하면 프로그램을 종료한다.
		 */
		FileReader fr = null;
		BufferedReader br = null;
		String path = WordStudy.class.getResource("").getPath();
		String line = null;
		try {
			fr = new FileReader(path + fileName);
			br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {
				wordList.add(line);
			}
		} catch (IOException ie) {
			ie.getStackTrace();
			System.exit(-1);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ie) {
			}
		}
	}

	public static void main(String args[]) {
		WordStudy mainWin = new WordStudy("Word Study");
	}

	class EventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button b = (Button) ae.getSource();
			if (b == first) {
				showFirst();
			} else if (b == prev) {
				showPrevious();
			} else if (b == next) {
				showNext();
			} else if (b == last) {
				showLast();
			}
		}

		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	} // class EventHandler
}
