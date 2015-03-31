package MyPackage;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class Help extends JFrame {
	private static final long serialVersionUID = 1L;

	Help() {
		init();
	}

	private void init() {
		setTitle("FlyHigh");
		setSize(915, 515);
		setResizable(false);

		ContentPanel pa = new ContentPanel("help_back");
		add(pa);	
		setVisible(true);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				//new MyDialog(2);	
				new Menu();
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

	
	private void clos()
	{
		this.dispose();
	}

}
