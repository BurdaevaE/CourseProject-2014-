package MyPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

class ContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	Image bgimage = null;

	public ContentPanel(String name) {
		String path="assets/backs/"+name+".png";
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage(path);
		mt.addImage(bgimage, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage, 0, 0, null);
	}
}