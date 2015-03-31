package MyPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class BestScores extends JFrame {
	private static final long serialVersionUID = 1L;

	JLabel label_t1 = new JLabel();
	JLabel label_t2 = new JLabel();
	JLabel label_t3 = new JLabel();
	JLabel label_t4 = new JLabel();
	JLabel label_t5 = new JLabel();

	StringBuilder sb = new StringBuilder();
	JScrollPane scrollPane;

	BestScores() {
		init();
	}

	private void init() {
		setTitle("FlyHigh");
		setSize(470, 560);
		setResizable(false);
		parser();

		Box box = Box.createVerticalBox();

		Font font = new Font("Algerian", Font.PLAIN, 24);

		box.add(Box.createVerticalStrut(260));
		label_t1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_t1.setFont(font);
		label_t1.setForeground(Color.WHITE);
		box.add(label_t1);
		box.add(Box.createVerticalStrut(15));
		label_t2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_t2.setFont(font);
		label_t2.setForeground(Color.WHITE);
		box.add(label_t2);
		box.add(Box.createVerticalStrut(15));
		label_t3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_t3.setFont(font);
		label_t3.setForeground(Color.WHITE);
		box.add(label_t3);
		box.add(Box.createVerticalStrut(15));
		label_t4.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_t4.setFont(font);
		label_t4.setForeground(Color.WHITE);
		box.add(label_t4);
		box.add(Box.createVerticalStrut(15));
		label_t5.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_t5.setFont(font);
		label_t5.setForeground(Color.WHITE);
		box.add(label_t5);

		ContentPanel pa = new ContentPanel("record_back");
		pa.add(box, java.awt.BorderLayout.CENTER);
		box.setOpaque(false);
		add(pa);
		setVisible(true);

		addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				clos();
				// new MyDialog(2);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void parser() {
		try {
			BufferedReader rfile = new BufferedReader(new FileReader(
					"assets/best.txt"));
			String line;

			int str_cnt = 0;
			while ((line = rfile.readLine()) != null) {
				str_cnt += 1;
				make_label(str_cnt, line);
			}
			;

			rfile.close();

		} catch (IOException e) {
			System.exit(0);
		}
	}

	private void clos() {
		this.dispose();
	}

	private void make_label(int i, String line) {
		if (i == 1) {
			label_t1.setText(line);
		} else if (i == 2) {
			label_t2.setText(line);
		}
		if (i == 3) {
			label_t3.setText(line);
		}
		if (i == 4) {
			label_t4.setText(line);
		}
		if (i == 5) {
			label_t5.setText(line);
		}

	}
}
