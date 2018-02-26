package views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class JPImageMain extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image image;

	public JPImageMain(String urlImage){
		init(urlImage);
	}

	private void init(String urlImage){
		image = new ImageIcon(getClass().getResource(urlImage)).getImage();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int width = this.getSize().width;
		int height = this.getSize().height;
		g.drawImage(image, 0, 0, width, height, this);
//		this.setOpaque(false);
	}
	
	public void changeImage(String urlImage){
		image = new ImageIcon(getClass().getResource(urlImage)).getImage();
		this.repaint();
	}
	
	public void cleanImage() {
		image = null;
		repaint();
	}
}
