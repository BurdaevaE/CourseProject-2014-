package MyPackage;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Struct_obj {
	String type;
	int x;
	int y;
}

class Struct_act_obj {
	String type;
	ArrayList<Image> image_list;
	int x; // координаты
	int y;
	int height; // ширина и высота
	int width;
	int n;// количесвто картинок
	int paint_n = 0;
}

public class NewGame extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private Hero hero;
	private Barriers barr = new Barriers();
	private Background back;

	JFrame frame;

	private static final int WIDTH = 900; // ширина
	private static final int HEIGHT = 490; // высота
	private static final String NAME = "FlyHigh"; // заголовок окна

	// private double speed=2; //скорость
	private static int level_type; // типа фона
	private static int level; // уровень
	private String level_file; // название файла с картой

	private static ArrayList<Struct_obj> obj_list = new ArrayList<Struct_obj>(); // все
																					// объекты
	private static ArrayList<Struct_act_obj> act_obj_list = new ArrayList<Struct_act_obj>(); // объекты
																								// "поля"
	private static int cur_obj_list = 0;

	private static boolean running;

	private static int c_num = 0; // количесво монет
	private static int score = 0; // счет
	private static int life = 100; // жизнь

	private static String num_coin;
	private static String num_score = String.valueOf(c_num);
	private static JLabel label_qcoin = new JLabel(); // лейбл-кол-во монет
	// private static JLabel label_qscore = new JLabel(num_score);
	private static JLabel label_lif = new JLabel();

	private static int q_barrs; // количество преград на "столе"

	Random rand = new Random();

	public static int get_win_height() {
		return HEIGHT;
	}

	public int get_win_width() {
		return WIDTH;
	}

	public void start_game(int level_type, int level) {
		NewGame game = new NewGame();

		this.level_type = level_type;
		this.level = level;

		String text = "";
		String[] text_to_structure = { "" };

		level_file = "levels/" + Integer.toString(level_type) + "_"
				+ Integer.toString(level) + ".txt";

		try {
			BufferedReader rfile = new BufferedReader(
					new FileReader(level_file));
			if ((text = rfile.readLine()) != null) {
				String[] fir_string = text.split(" ");
				q_barrs = Integer.valueOf(fir_string[0]);
				cur_obj_list = q_barrs;
			}
			while ((text = rfile.readLine()) != null) {
				text_to_structure = text.split(" ");
				make_str(text_to_structure);
			}
			;

			rfile.close();
		} catch (IOException e) {
			System.exit(0);
		}

		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		frame = new JFrame(NewGame.NAME);

		JLabel label_coin = new JLabel("Coins:");
		JLabel label_score = new JLabel("Score:");

		JLabel label_life = new JLabel();
		ImageIcon life_img = new ImageIcon("assets/life.png");
		label_life.setIcon(life_img);
		label_lif = new JLabel(String.valueOf(life));

		JPanel p_cn = new JPanel();
		frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		p_cn.add(label_coin);
		p_cn.add(label_qcoin);
		// p_cn.add(label_score);
		// p_cn.add(label_qscore);
		p_cn.add(label_life);
		p_cn.add(label_lif);
		frame.add(p_cn, BorderLayout.NORTH);
		frame.add(game, BorderLayout.CENTER); // добавляем холст на наш фрейм
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);

		game.init_objs();
		game.start();
	}

	public void make_str(String[] text) {
		Struct_obj obj = new Struct_obj();
		obj.type = text[0]; // type
		obj.x = Integer.valueOf(text[1]); // x
		obj.y = Integer.valueOf(text[2]); // y

		obj_list.add(obj);
	}

	public void init_objs() {
		addKeyListener(new KeyInputHandler());
		back = new Background(level_type);
		hero = new Hero();

		for (int i = 0; i < q_barrs; i++) {
			Struct_act_obj obj = new Struct_act_obj();
			obj.type = obj_list.get(i).type;
			obj.image_list = get_image_list(obj.type);
			obj.x = obj_list.get(i).x;
			obj.y = obj_list.get(i).y;
			obj.height = barr.get_height(obj.image_list.get(0));
			obj.width = barr.get_width(obj.image_list.get(0));
			obj.n = obj.image_list.size();
			act_obj_list.add(obj);
		}
	}

	private ArrayList<Image> get_image_list(String type) {
		ArrayList<Image> image_list = null;
		if (type.equals("coin")) {
			image_list = barr.coin_image_list;
		}
		if (type.equals("airplane")) {
			image_list = barr.airplane_image_list;
		}
		if (type.equals("helicopter")) {
			image_list = barr.helicopter_image_list;
		}
		if (type.equals("fighter")) {
			image_list = barr.fighter_image_list;
		}
		if (type.equals("balloon")) {
			image_list = barr.balloon_image_list;
		}
		if (type.equals("present")) {
			image_list = barr.present_image_list;
		}
		return image_list;
	}

	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void run() {
		long lastTime = System.currentTimeMillis();
		long delta;

		while (running) {
			delta = System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			hero.update(delta);
			render();
			do_game();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2); // BufferStrategy для холста
			requestFocus();
			return;
		}
		Graphics g = bs.getDrawGraphics(); // получаем Graphics из буфера
		back.draw(g);
		hero.draw(g, hero.get_x(), hero.get_y());

		for (int i = 0; i < act_obj_list.size(); i++) {
			draw_barr(
					g,
					act_obj_list.get(i).x,
					act_obj_list.get(i).y,
					act_obj_list.get(i).image_list.get(act_obj_list.get(i).paint_n));
			if (act_obj_list.get(i).paint_n < ((act_obj_list.get(i).n) - 1)) {
				act_obj_list.get(i).paint_n++;
			} else {
				act_obj_list.get(i).paint_n = 0;
			}
		}
		g.dispose();
		bs.show(); // показать
	}

	void draw_barr(Graphics g, int x, int y, Image image) // рисуем картинку
	{
		g.drawImage(image, x, y, null);
	}

	private void do_game() {
		if (act_obj_list.size() == 0) {
			act_obj_list.clear();
			obj_list.clear();
			score = level * c_num * 10 + level * life;
			String str = "Level completed:)\nCoins: " + c_num + "\nLife: "
					+ life + "\nYour score is " + score;
			JOptionPane.showMessageDialog(null, str);
			running = false;
			// int reply = JOptionPane.showConfirmDialog(null, str ,
			// "Congratulations", JOptionPane.YES_NO_OPTION);
			// if (reply == JOptionPane.YES_OPTION){
			// start_game(level_type, level+1);
			// frame.dispose();
			// }
			save_best();
			// new Menu();
			return;
		} else {
			for (int i = 0; i < act_obj_list.size(); i++) {
				int flag = 0;
				flag = game(i);

				if (flag == 1 || flag == 2) {
					if (flag == 1) // coin
					{
						c_num++;
						// score += level * 10;
					}
					if (flag == 2) // pot=10coins
					{
						c_num += 10;
						// score += (level * 50);
					}
					num_coin = String.valueOf(c_num);
					num_score = String.valueOf(score);
					label_qcoin.setText(num_coin);
					// label_qscore.setText(num_score);
					act_obj_list.remove(i);
					create_barr();
					cur_obj_list++;
				}
				if (flag >= 3 && flag <= 7) {
					if (flag == 3) // airplane
					{
						life -= 50;
					}
					if (flag == 4) // helicopter
					{
						life -= 20;
					}
					if (flag == 5) // fighter
					{
						life -= 25;
					}
					if (flag == 6) // balloon
					{
						life -= 10;
					}
					if (flag == 7) // health
					{
						if (life >= 50) {
							life = 100;
						} else {
							life += 50;
						}
					}
					if (life <= 0) {
						life = 0;
						label_lif.setText(String.valueOf(life));
						JOptionPane.showMessageDialog(null, "Level failed:(");
						running = false;
						// save_best();
						// new Menu();
					}
					label_lif.setText(String.valueOf(life));
					act_obj_list.remove(i);
					create_barr();
					cur_obj_list++;
				}
				if (flag == 8) {
					act_obj_list.remove(i);
					create_barr();
					cur_obj_list++;
				}
			}

			// try {
			// Thread.sleep(0,3);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// for (int i = 0; i < 2000000; i++) {
			// }
		}
		for (int i = 0; i < act_obj_list.size(); i++) {
			make_move(i, act_obj_list.get(i).type);
		}

	}

	private void save_best() {
		try {
			BufferedReader rfile = new BufferedReader(new FileReader(
					"assets/best.txt"));
			String line;

			while ((line = rfile.readLine()) != null) {
				// text_to_structure = text.split(" ");
				// make_str(text_to_structure);
			}

			rfile.close();

		} catch (IOException e) {
			System.exit(0);
		}
	}

	void make_move(int i, String type) {
		if (type.equals("coin"))
			act_obj_list.get(i).x--;
		if (type.equals("airplane")) {
			act_obj_list.get(i).x--;
			act_obj_list.get(i).y--;
		}
		if (type.equals("helicopter"))
			act_obj_list.get(i).x--;
		if (type.equals("fighter"))
			act_obj_list.get(i).x -= 5;
		if (type.equals("balloon")) {
			int rand_num = rand.nextInt(100);
			if (rand_num % 2 == 0
					&& act_obj_list.get(i).y >= 0
					&& act_obj_list.get(i).y <= (265 - act_obj_list.get(i).height)) {
				act_obj_list.get(i).x--;
				act_obj_list.get(i).y++;
			} else {
				act_obj_list.get(i).x--;
				act_obj_list.get(i).y--;
			}
		}
		if (type.equals("present"))
			act_obj_list.get(i).x -= 2;
	}

	public void create_barr() {
		if (cur_obj_list < obj_list.size()) {
			Struct_act_obj obj = new Struct_act_obj();
			obj.type = obj_list.get(cur_obj_list).type;
			obj.image_list = get_image_list(obj.type);
			obj.x = obj_list.get(cur_obj_list).x;
			obj.y = obj_list.get(cur_obj_list).y;
			obj.height = barr.get_height(obj.image_list.get(0));
			obj.width = barr.get_width(obj.image_list.get(0));
			obj.n = obj.image_list.size();
			act_obj_list.add(obj);
		}
	}

	public int game(int i) {
		int hero_x = hero.get_x() + hero.get_width();
		int hero_y_st = hero.get_y(); // начало hero
		int hero_y_fin = hero.get_y() + hero.get_height(); // конец hero

		int bar_x = act_obj_list.get(i).x;
		int bar_y_st = act_obj_list.get(i).y;
		int bar_y_fin = act_obj_list.get(i).y + act_obj_list.get(i).height;

		int flag = 0;

		if ((hero_x >= bar_x && hero_y_st <= bar_y_st && hero_y_fin >= bar_y_fin)
				|| (hero_x >= bar_x && hero_y_st > bar_y_st && hero_y_st < bar_y_fin)
				|| (hero_x >= bar_x && hero_y_fin > bar_y_st && hero_y_fin < bar_y_fin)) {
			if (act_obj_list.get(i).type.equals("coin")) {
				flag = 1;
			}
			if (act_obj_list.get(i).type.equals("airplane")) {
				flag = 3;
			}
			if (act_obj_list.get(i).type.equals("helicopter")) {
				flag = 4;
			}
			if (act_obj_list.get(i).type.equals("fighter")) {
				flag = 5;
			}
			if (act_obj_list.get(i).type.equals("balloon")) {
				flag = 6;
			}

			if (act_obj_list.get(i).type.equals("present")) {
				int rand_num = rand.nextInt(100);
				if (rand_num % 2 == 0) {
					flag = 2; // pot
				} else {
					flag = 7; // health
				}
			}
		}
		if (((bar_x + act_obj_list.get(i).width) <= 0) || (bar_y_fin <= 0)) {
			flag = 8;
		}
		return flag;
	}

	private class KeyInputHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				hero.set_upPressed(true);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				hero.set_downPressed(true);
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				hero.set_upPressed(false);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				hero.set_downPressed(false);
			}
		}
	}
}