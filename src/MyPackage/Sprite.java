package MyPackage;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	public static Image image; // изображение
	private String type; // тип препятстивия

	Sprite(Image image, String type) {
		Sprite.image = image;
		this.type = type;
	}

	public String get_type() {
		return type;
	}

	public int getWidth(Image img) // ширина картинки
	{
		return img.getWidth(null);
	}

	public int getHeight(Image img) // высота картинки
	{
		return img.getHeight(null);
	}

	public Sprite getSprite(String path) {
		BufferedImage sourceImage = null;

		try {
			//java.net.URL url = this.getClass().getClassLoader()
				//	.getResource(path);
			//sourceImage = ImageIO.read(url);
			
			sourceImage=ImageIO.read(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(
				sourceImage.getSource()), type);

		return sprite;
	}
}