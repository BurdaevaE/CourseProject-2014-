package MyPackage;

import java.awt.Graphics;
import java.awt.Image;

public class Background {
	Sprite back;
	private Image background;

	Background(int level_type) {
		init_back(level_type);
	}

	private void init_back(int level_type) {
		Sprite spr = new Sprite(null, "back");
		String back_name = "assets/backs/back" + Integer.toString(level_type) + ".png";
		back = spr.getSprite(back_name);
		this.background = Sprite.image;
	}


	public void draw(Graphics g) // рисуем картинку
	{
		g.drawImage(background, 0, 0, null);
	}
}
