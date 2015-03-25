package MyPackage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;

	private static JButton newbtn = new JButton();
	private static JButton scorebtn = new JButton();
	private static JButton helpbtn = new JButton();
	private static JButton exitbtn = new JButton();

	public Menu() {
			init();
	}

	private void clos() {
		this.dispose();
	}

	public static void main(String[] args) {
		new Menu();
	}
	

	void init()
	{
		setTitle("FlyHigh");
		setSize(470, 530);

		ImageIcon start_btn = new ImageIcon("buttons/start_btn.png");
		ImageIcon score_btn = new ImageIcon("buttons/best_btn.png");
		ImageIcon help_btn = new ImageIcon("buttons/help_btn.png");
		ImageIcon exit_btn = new ImageIcon("buttons/exit_btn.png");

		ImageIcon start_btn_p = new ImageIcon("buttons/start_btn_m.png");
		ImageIcon score_btn_p = new ImageIcon("buttons/best_btn_m.png");
		ImageIcon help_btn_p = new ImageIcon("buttons/help_btn_m.png");
		ImageIcon exit_btn_p = new ImageIcon("buttons/exit_btn_m.png");

		Box box = Box.createVerticalBox();

		box.add(Box.createVerticalStrut(160));
		newbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		newbtn.setIcon(start_btn);
		newbtn.setRolloverIcon(start_btn_p);
		newbtn.setBorderPainted(false);
		newbtn.setFocusPainted(false);
		newbtn.setContentAreaFilled(false);
		box.add(newbtn);

		scorebtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		scorebtn.setIcon(score_btn);
		scorebtn.setRolloverIcon(score_btn_p);
		scorebtn.setBorderPainted(false);
		scorebtn.setFocusPainted(false);
		scorebtn.setContentAreaFilled(false);
		box.add(scorebtn);

		helpbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		helpbtn.setIcon(help_btn);
		helpbtn.setRolloverIcon(help_btn_p);
		helpbtn.setBorderPainted(false);
		helpbtn.setFocusPainted(false);
		helpbtn.setContentAreaFilled(false);
		box.add(helpbtn);

		exitbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitbtn.setIcon(exit_btn);
		exitbtn.setRolloverIcon(exit_btn_p);
		exitbtn.setBorderPainted(false);
		exitbtn.setFocusPainted(false);
		exitbtn.setContentAreaFilled(false);
		box.add(exitbtn);

		newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clos();
				new TypeMenu();
				
			}
		});
		scorebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clos();
				new BestScores();
			}
		});
		helpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clos();
				new Help();
			}
		});
		
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clos();
				new My_Dialog(1);
			}
		});

		ContentPanel pa = new ContentPanel("menu_back");
		pa.add(box, java.awt.BorderLayout.CENTER);
		box.setOpaque(false);
		add(pa);
		setResizable(false);
		setVisible(true);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				clos();
				new My_Dialog(1);
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
}
