package MyPackage;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class LevelMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private static int level;

	private static JButton firstbtn = new JButton();
	private static JButton secondbtn = new JButton();
	private static JButton thirdbtn = new JButton();
	private static JButton fourthbtn = new JButton();
	private static JButton fifthbtn = new JButton();
	
	private int level_type;

	public LevelMenu(final int level_type) {
		this.level_type = level_type;
		init();
	}
	
	void init() {

		ImageIcon first_btn = new ImageIcon("buttons/level1.png");
		ImageIcon second_btn = new ImageIcon("buttons/level2.png");
		ImageIcon third_btn = new ImageIcon("buttons/level3.png");
		ImageIcon fourth_btn = new ImageIcon("buttons/level4.png");
		ImageIcon fifth_btn = new ImageIcon("buttons/level5.png");

		ImageIcon first_btn_p = new ImageIcon("buttons/level1_m.png");
		ImageIcon second_btn_p = new ImageIcon("buttons/level2_m.png");
		ImageIcon third_btn_p = new ImageIcon("buttons/level3_m.png");
		ImageIcon fourth_btn_p = new ImageIcon("buttons/level4_m.png");
		ImageIcon fifth_btn_p = new ImageIcon("buttons/level5_m.png");

		setTitle("FlyHigh");
		setSize(900, 490);
		setResizable(false);

		Box box = Box.createHorizontalBox();

		firstbtn.setAlignmentY(Component.CENTER_ALIGNMENT);
		firstbtn.setIcon(first_btn);
		firstbtn.setRolloverIcon(first_btn_p);
		firstbtn.setBorderPainted(false);
		firstbtn.setFocusPainted(false);
		firstbtn.setContentAreaFilled(false);
		box.add(firstbtn);

		secondbtn.setAlignmentY(Component.TOP_ALIGNMENT);
		secondbtn.setIcon(second_btn);
		secondbtn.setRolloverIcon(second_btn_p);
		secondbtn.setBorderPainted(false);
		secondbtn.setFocusPainted(false);
		secondbtn.setContentAreaFilled(false);
		box.add(secondbtn);

		thirdbtn.setAlignmentY(Component.CENTER_ALIGNMENT);
		thirdbtn.setIcon(third_btn);
		thirdbtn.setRolloverIcon(third_btn_p);
		thirdbtn.setBorderPainted(false);
		thirdbtn.setFocusPainted(false);
		thirdbtn.setContentAreaFilled(false);
		box.add(thirdbtn);

		fourthbtn.setAlignmentY(Component.TOP_ALIGNMENT);
		fourthbtn.setIcon(fourth_btn);
		fourthbtn.setRolloverIcon(fourth_btn_p);
		fourthbtn.setBorderPainted(false);
		fourthbtn.setFocusPainted(false);
		fourthbtn.setContentAreaFilled(false);
		box.add(fourthbtn);

		fifthbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		fifthbtn.setIcon(fifth_btn);
		fifthbtn.setRolloverIcon(fifth_btn_p);
		fifthbtn.setBorderPainted(false);
		fifthbtn.setFocusPainted(false);
		fifthbtn.setContentAreaFilled(false);
		box.add(fifthbtn);

		ContentPanel pa = new ContentPanel("level_menu");
		pa.add(box, java.awt.BorderLayout.CENTER);
		box.setOpaque(false);
		add(pa);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		firstbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 1;
				clos();
				new NewGame().start_game(level_type, level);
			}
		});
		secondbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 2;
				clos();
				new NewGame().start_game(level_type, level);
			}
		});

		thirdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 3;
				clos();
				new NewGame().start_game(level_type, level);
			}
		});

		fourthbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 4;
				clos();
				new NewGame().start_game(level_type, level);
			}
		});

		fifthbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 5;
				clos();
				new NewGame().start_game(level_type, level);
			}
		});
	}
	
	private void clos() {
		this.dispose();
	}
}
