package MyPackage;

import java.awt.Graphics;
import java.awt.Image;

public class Hero {
	private static Sprite hero;
	private Image img;

	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean rightPressed = false;
	
	private int x = 10;
	private int y = 130;
	private int y_lim = 200;
	private int speed = 1;

	Hero() {
		init_hero();
	}

	private void init_hero() {
		Sprite spr = new Sprite(null, "hero");
		hero = spr.getSprite("assets/hero.png");
		this.img = Sprite.image;
	}

	public void draw(Graphics g, int x, int y) // рисуем картинку
	{
		g.drawImage(img, x, y, null);
	}

	public void set_upPressed(boolean up) {
		upPressed = up;
	}

	public void set_downPressed(boolean down) {
		downPressed = down;
	}
	
	public void set_rightPressed(boolean right) {
		rightPressed = right;
	}

	public int get_x() {
		return x;
	}

	public int get_y() {
		return y;
	}

	public int get_width() {
		return hero.getWidth(img);
	}

	public int get_height() {
		return hero.getHeight(img);
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int Speed) {
		this.speed = Speed;
	}

	public void update(long delta) {
		if (upPressed == true && y > 0) {
			y--;
		}
		if (downPressed == true && y <= y_lim) {
			y++;
		}
		if (rightPressed && speed <5){
			speed++;
		}
	}
}
