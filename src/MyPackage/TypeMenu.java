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

public class TypeMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private static int level_type;

	private static JButton desertbtn = new JButton();
	private static JButton seabtn = new JButton();
	private static JButton countrybtn = new JButton();
	private static JButton fieldbtn = new JButton();
	private static JButton comingbtn = new JButton();

	private void clos() {
		this.dispose();
	}

	public TypeMenu() {
		init();
	}
	
	void init() {
		ImageIcon desert_btn = new ImageIcon("buttons/desert_level.png");
		ImageIcon sea_btn = new ImageIcon("buttons/sea_level.png");
		ImageIcon country_btn = new ImageIcon("buttons/country_level.png");
		ImageIcon field_btn = new ImageIcon("buttons/field_level.png");
		ImageIcon coming_btn = new ImageIcon("buttons/coming_btn.png");

		ImageIcon desert_btn_p = new ImageIcon("buttons/desert_level_m.png");
		ImageIcon sea_btn_p = new ImageIcon("buttons/sea_level_m.png");
		ImageIcon country_btn_p = new ImageIcon("buttons/country_level_m.png");
		ImageIcon field_btn_p = new ImageIcon("buttons/field_level_m.png");

		setTitle("FlyHigh");
		setSize(915, 500);
		setResizable(false);

		Box box = Box.createHorizontalBox();
		Box box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalStrut(125));

		desertbtn.setAlignmentY(Component.CENTER_ALIGNMENT);
		desertbtn.setIcon(desert_btn);
		desertbtn.setRolloverIcon(desert_btn_p);
		desertbtn.setBorderPainted(false);
		desertbtn.setFocusPainted(false);
		desertbtn.setContentAreaFilled(false);
		box.add(desertbtn);

		seabtn.setAlignmentY(Component.TOP_ALIGNMENT);
		seabtn.setIcon(sea_btn);
		seabtn.setRolloverIcon(sea_btn_p);
		seabtn.setBorderPainted(false);
		seabtn.setFocusPainted(false);
		seabtn.setContentAreaFilled(false);
		box.add(seabtn);

		countrybtn.setAlignmentY(Component.CENTER_ALIGNMENT);
		countrybtn.setIcon(country_btn);
		countrybtn.setRolloverIcon(country_btn_p);
		countrybtn.setBorderPainted(false);
		countrybtn.setFocusPainted(false);
		countrybtn.setContentAreaFilled(false);
		box.add(countrybtn);

		fieldbtn.setAlignmentY(Component.TOP_ALIGNMENT);
		fieldbtn.setIcon(field_btn);
		fieldbtn.setRolloverIcon(field_btn_p);
		fieldbtn.setBorderPainted(false);
		fieldbtn.setFocusPainted(false);
		fieldbtn.setContentAreaFilled(false);
		box.add(fieldbtn);

		comingbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		comingbtn.setIcon(coming_btn);
		comingbtn.setBorderPainted(false);
		comingbtn.setFocusPainted(false);
		comingbtn.setContentAreaFilled(false);
		box.add(comingbtn);

		box2.add(box, java.awt.BorderLayout.CENTER);

		ContentPanel pa = new ContentPanel("type_menu");
		pa.add(box2);
		box.setOpaque(false);
		add(pa, java.awt.BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);

		desertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level_type = 1;
				clos();
				new LevelMenu(level_type);
			}
		});
		seabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level_type = 2;
				clos();
				new LevelMenu(level_type);
			}
		});
		countrybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level_type = 3;
				clos();
				new LevelMenu(level_type);
				
			}
		});
		fieldbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level_type = 4;
				clos();
				new LevelMenu(level_type);
			}
		});
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				clos();
				new My_Dialog(2);	
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
