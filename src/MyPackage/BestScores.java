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
import javax.swing.JTextArea;

public class BestScores extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextArea bests=new JTextArea();
	StringBuilder sb = new StringBuilder();

	BestScores() {
		init();
	}
	

	private void parser() {
		try {
			BufferedReader rfile = new BufferedReader(new FileReader(
					"assets/best.txt"));
			String line;

			while ((line = rfile.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			;
			String b=sb.toString();
			b=b.replace(" ", "\t");
			bests.setText(b);
			rfile.close();

		} catch (IOException e) {
			System.exit(0);
		}
	}


	private void init() {
		setTitle("FlyHigh");
		setSize(470, 560);
		setResizable(false);
		parser();

		Box box = Box.createVerticalBox();
		Font font = new Font("Algerian", Font.PLAIN, 14);
		box.add(Box.createVerticalStrut(260));
		bests.setFont(font);
		bests.setForeground(Color.WHITE);
		bests.setOpaque(false);
		bests.setEditable(false);
        bests.setFocusable(false);
		box.add(bests);
		
		ContentPanel pa = new ContentPanel("record_back");
		pa.add(box, java.awt.BorderLayout.CENTER);
		box.setOpaque(false);
		add(pa);
		setVisible(true);

		addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				clos();
				new MyDialog(3);
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

	private void clos() {
		this.dispose();
	}
}
