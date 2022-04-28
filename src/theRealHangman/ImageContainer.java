package theRealHangman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageContainer extends JPanel {
	
	private Image image;

	public ImageContainer() {
		
		super();
	}

	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null)
			g.drawImage(image, 0, 0, (int) (685 * 0.5), (int) (344 * 0.5), null);
	}


	public void setIcon(String imagePath) {
		try {
		    image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.repaint();
	}
}
