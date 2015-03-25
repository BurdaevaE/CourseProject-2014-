package MyPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

public class Barriers {

	private static Sprite bars;

	Sprite coin;
	Sprite airplane;
	Sprite helicopter;
	Sprite fighter;
	Sprite balloon;
	Sprite present;

	private String coin_num = "coin";
	private String airplane_num = "airplane";
	private String helicopter_num = "helicopter";
	private String fighter_num = "fighter";
	private String balloon_num = "balloon";
	private String present_num = "present";

	private Image img;
	private int list_n;

	public static ArrayList<Image> coin_image_list = new ArrayList<Image>();
	public static ArrayList<Image> airplane_image_list = new ArrayList<Image>();
	public static ArrayList<Image> helicopter_image_list = new ArrayList<Image>();
	public static ArrayList<Image> fighter_image_list = new ArrayList<Image>();
	public static ArrayList<Image> balloon_image_list = new ArrayList<Image>();
	public static ArrayList<Image> present_image_list = new ArrayList<Image>();

	Barriers(String type) {
		if (type.equals(coin_num))
			init_coin();
		if (type.equals(airplane_num))
			init_airplane();
		if (type.equals(helicopter_num))
			init_helicopter();
		if (type.equals(fighter_num))
			init_fighter();
		if (type.equals(balloon_num))
			init_balloon();
		if (type.equals(present_num))
			init_present();
	}

	private void init_coin() {
		File[] fList;
		File F = new File("coin");

		fList = F.listFiles();
		int l = fList.length;

		for (int i = 1; i <= l; i++) {
			bars = new Sprite(null, coin_num);
			String path ="coin/"+ Integer.toString(i) + coin_num + ".png";
			coin = bars.getSprite(path);
			this.img = Sprite.image;
			coin_image_list.add(img);
		}
	}

	private void init_present() {
		File[] fList;
		File F = new File("present");

		fList = F.listFiles();
		int l = fList.length;

		for (int i = 1; i <= l; i++) {
			bars = new Sprite(null, present_num);
			String path = "present/"+Integer.toString(i) + present_num + ".png";
			present = bars.getSprite(path);
			this.img = Sprite.image;
			present_image_list.add(img);
		}
	}

	private void init_airplane() {
		File[] fList;
		File F = new File("airplane");

		fList = F.listFiles();
		int l = fList.length;

		for (int i = 1; i <= l; i++) {
			bars = new Sprite(null, airplane_num);
			String path = "airplane/"+Integer.toString(i) + airplane_num + ".png";
			airplane = bars.getSprite(path);
			this.img = Sprite.image;
			airplane_image_list.add(img);
		}
	}

	private void init_helicopter() {
		File[] fList;
		File F = new File("helicopter");

		fList = F.listFiles();
		int l = fList.length;

		for (int i = 1; i <= l; i++) {
			bars = new Sprite(null, helicopter_num);
			String path = "helicopter/"+Integer.toString(i) + helicopter_num + ".png";
			helicopter = bars.getSprite(path);
			this.img = Sprite.image;
			helicopter_image_list.add(img);
		}
	}

	private void init_fighter() {
		File[] fList;
		File F = new File("fighter");

		fList = F.listFiles();
		int l = fList.length;

		for (int i = 1; i <= l; i++) {
			bars = new Sprite(null, fighter_num);
			String path = "fighter/"+Integer.toString(i) + fighter_num + ".png";
			fighter = bars.getSprite(path);
			this.img = Sprite.image;
			fighter_image_list.add(img);
		}
	}

	private void init_balloon() {
		File[] fList;
		File F = new File("balloon");

		fList = F.listFiles();
		int l = fList.length;

		for (int i = 1; i <= l; i++) {
			bars = new Sprite(null, balloon_num);
			String path = "balloon/"+Integer.toString(i) + balloon_num + ".png";
			balloon = bars.getSprite(path);
			this.img = Sprite.image;
			balloon_image_list.add(img);
		}
	}

	public int get_imlist_n(String type) {
		if (type.equals(coin_num))
			list_n = coin_image_list.size();
		if (type.equals(airplane_num))
			list_n = airplane_image_list.size();
		if (type.equals(helicopter_num))
			list_n = helicopter_image_list.size();
		if (type.equals(fighter_num))
			list_n = fighter_image_list.size();
		if (type.equals(balloon_num))
			list_n = balloon_image_list.size();
		if (type.equals(present_num))
			list_n = present_image_list.size();
		return list_n;
	}

	public void draw(Graphics g, int x, int y, int n, String type) // рисуем
																	// картинку
	{
		ArrayList<Image> image_list = new ArrayList<Image>();
		if (type.equals(coin_num)) {
			image_list = coin_image_list;
		}
		if (type.equals(airplane_num)) {
			image_list = airplane_image_list;
		}
		if (type.equals(helicopter_num)) {
			image_list = helicopter_image_list;
		}
		if (type.equals(fighter_num)) {
			image_list = fighter_image_list;
		}
		if (type.equals(balloon_num)) {
			image_list = balloon_image_list;
		}
		if (type.equals(present_num)) {
			image_list = present_image_list;
		}
		g.drawImage(image_list.get(n), x, y, null);
	}

	public int get_width() {
		return bars.getWidth(img);
	}

	public int get_height() {
		return bars.getHeight(img);
	}

	public String get_type() {
		return bars.get_type();
	}

}
