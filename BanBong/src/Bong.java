import java.awt.Color;
import java.awt.Graphics;

public class Bong {
	private int x, y, huongX = -2, huongY = -3;

	public int getHuongX() {
		return huongX;
	}

	public void setHuongX(int huongX) {
		this.huongX = huongX;
	}

	public int getHuongY() {
		return huongY;
	}

	public void setHuongY(int huongY) {
		this.huongY = huongY;
	}

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
	public Bong() {
		this.x = this.y = 0;
	}

	public Bong(int a, int b) {
		this.x= a;
		this.y= b;
	}
	
	public void drawBong(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, 20, 20);
	}
	
	public void diChuyen(ThanhDo thanhdo) {
		if(x>670 || x < 0) {
			huongX=-huongX;
		}
		if((y >= 576 && thanhdo.getX() < x && x < thanhdo.getX() + 100) || y < 0) huongY=-huongY;
		x += huongX;
		if(y <= 600) {
			y += huongY;
			
		}
		
	}
}
