package MyPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class My_Dialog extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static JButton btn1;
	private static JButton btn2;
	private static JLabel message;
	String btn1_text;
	String btn2_text;
	String mes;
	static int i;
	static int type;
	static int level;

	My_Dialog(int i)
	{
		set_i(i);
		init();
	}
	
	My_Dialog(int type, int level, int i)
	{
		this.type=type;
		this.level=level;
		this.i=i;
		init();
	}
	
	private void set_i(int i)
	{
		this.i=i;
	}
	
	private void init()
	{
		setTitle("FlyHigh");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(300, 250);
 
		ImageIcon dialog_btn1=null;
		ImageIcon dialog_btn1_p=null;
		ImageIcon dialog_btn2=null;
		ImageIcon dialog_btn2_p=null;
		
		if(i==1) //1 форма
		{
			mes="Leave us?";
			dialog_btn1 = new ImageIcon("buttons/dialogs/dialog_yes.png");
			dialog_btn1_p = new ImageIcon("buttons/dialogs/dialog_yes_m.png");
			dialog_btn2 = new ImageIcon("buttons/dialogs/dialog_no.png");
			dialog_btn2_p = new ImageIcon("buttons/dialogs/dialog_no_m.png");
		}
		if(i==2) //2 форма
		{
			mes="Back to Menu?";
			dialog_btn1 = new ImageIcon("buttons/dialogs/dialog_yes.png");
			dialog_btn1_p = new ImageIcon("buttons/dialogs/dialog_yes_m.png");
			dialog_btn2 = new ImageIcon("buttons/dialogs/dialog_no.png");
			dialog_btn2_p = new ImageIcon("buttons/dialogs/dialog_no_m.png");
		}
//		if(i==3) //3 форма
//		{
//			mes="Back to ...?";
//			dialog_btn1 = new ImageIcon("buttons/dialogs/dialog_menu.png");
//			dialog_btn1_p = new ImageIcon("buttons/dialogs/dialog_menu_m.png");
//			dialog_btn2 = new ImageIcon("buttons/dialogs/dialog_prev.png");
//			dialog_btn2_p = new ImageIcon("buttons/dialogs/dialog_prev_m.png");
//		}
//		if(i==4) //4 форма - exit
//		{
//			dialog_btn1 = new ImageIcon("buttons/dialogs/dialog_menu.png");
//			dialog_btn1_p = new ImageIcon("buttons/dialogs/dialog_menu_m.png");
//			dialog_btn2 = new ImageIcon("buttons/dialogs/dialog_back.png");
//			dialog_btn2_p = new ImageIcon("buttons/dialogs/dialog_back_m.png");
//		}
//		
//		if(i==5) //bad end
//		{
//			dialog_btn1 = new ImageIcon("buttons/dialogs/dialog_menu.png");
//			dialog_btn1_p = new ImageIcon("buttons/dialogs/dialog_menu_m.png");
//			dialog_btn2 = new ImageIcon("buttons/dialogs/dialog_try.png");
//			dialog_btn2_p = new ImageIcon("buttons/dialogs/dialog_try_m.png");
//		}

		
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(10));
		
		Font font = new Font("Algerian", Font.PLAIN, 24);
		message=new JLabel(mes);
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		message.setFont(font);
		message.setForeground(Color.BLACK);
		box.add(message);
		
		box.add(Box.createVerticalStrut(10));
		
		btn1=new JButton();
		btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn1.setIcon(dialog_btn1);
		btn1.setRolloverIcon(dialog_btn1_p);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.setContentAreaFilled(false);
		box.add(btn1);

		btn2=new JButton();
		btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn2.setIcon(dialog_btn2);
		btn2.setRolloverIcon(dialog_btn2_p);
		btn2.setBorderPainted(false);
		btn2.setFocusPainted(false);
		btn2.setContentAreaFilled(false);
		box.add(btn2);

		ContentPanel pa = new ContentPanel("dialog_menu");
		pa.add(box, java.awt.BorderLayout.CENTER);
		box.setOpaque(false);
		add(pa);
		setResizable(false);
		setVisible(true);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i==1)
				{
					System.exit(0);
				}
				if(i==2)
				{
					clos();
					new Menu();
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i==1)
				{
					clos();
					new Menu();
				}
				if(i==2)
				{
					clos();
					new TypeMenu();
				}
//				if(i==4)
//				{
//					clos();
//					NewGame game = new NewGame();
//					game.start_game(type, level);
//				}
//				if(i==5)
//				{
//					clos();
//					NewGame game = new NewGame();
//					game.start_game(type, level);
//				}
			}
		});
	}
	
	private void clos()
	{
		this.dispose();
	}
}

