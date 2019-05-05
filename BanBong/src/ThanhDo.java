import java.awt.Color;
import java.awt.Graphics;

public class ThanhDo {
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public ThanhDo() {
		this.x = this.y = 0;
	}

	public ThanhDo(int x) {
		this.x= x;
		this.y= 590;
	}
	
	public void drawThanhDo(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 100, 10);
	}
	
	public void dichuyenPhai() {
		if(x<700 - 100) {
			x+=10;
		}
	}
	public void dichuyenTrai() {
		if(x>0) {
			x-=10;
		}
	}

}
