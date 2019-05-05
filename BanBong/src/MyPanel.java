import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel {
	Bongmuctieu ball;
	Timer t;
	public static int demvacham = 0;
	private int score = 0;
	private int sobong = 21;
	boolean trai, phai, play = false;
	Bong bong;
	ThanhDo thanhdo;

	public MyPanel() {
		this.setPreferredSize(new Dimension(700, 600));
		this.setBackground(Color.BLACK);
		TimerHandler timerHandler = new TimerHandler();
		PlayerHandler player = new PlayerHandler();
		this.addKeyListener(player);
		this.setFocusable(true);
		ball = new Bongmuctieu(3, 7);
		bong = new Bong(350, 570);
		thanhdo = new ThanhDo(310);
		t = new Timer(8, timerHandler);
		t.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);
		if (!play) {
			sobong = 21;
			// win = false;
			ball = new Bongmuctieu(3, 7);
			thanhdo.setX(310);
			g.setColor(Color.RED);
			bong.setX(350);
			bong.setY(570);
			ball.draw((Graphics2D) g);
			thanhdo.drawThanhDo(g);
			bong.drawBong(g);
			
		} else {
			if (bong.getY() <= 600) {
				g.setColor(Color.RED);
				ball.draw((Graphics2D) g);
				bong.drawBong(g);

				xacdinhhuong();
				thanhdo.drawThanhDo(g);
			} else {
				if (play) {
					g.setColor(Color.WHITE);
					thanhdo.drawThanhDo(g);
					ball.draw((Graphics2D) g);
					g.setFont(new Font("serif", Font.BOLD, 25));
					g.drawString("You Loss!! ", 260, 300);
					g.setFont(new Font("serif", Font.BOLD, 25));
					g.drawString("Press Space to Restart", 230, 350);
				}

			}
		}
		if (sobong <= 0) {
			bong.setX(350);
			bong.setY(610);
			thanhdo.setX(-100);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("You Won!! ", 260, 300);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Space to Restart", 230, 350);
		}

	}

	public class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			diChuyenThanhDo();
			if (play) {
				bong.diChuyen(thanhdo);
				
			}

			repaint();
		}

		public void diChuyenThanhDo() {
			if (trai)
				thanhdo.dichuyenTrai();
			if (phai)
				thanhdo.dichuyenPhai();
		}

//		
	}

	public void xacdinhhuong() {
		if (play) {
			A: for (int i = 0; i < ball.map.length; i++) {
				for (int j = 0; j < ball.map[0].length; j++) {
					if (ball.map[i][j] > 0) {
						int brickX = j * ball.daibong + 80;
						int brickY = i * ball.rongbong + 50;
						int brickwidth = ball.daibong;
						int brickheight = ball.rongbong;

						Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
						Rectangle ballRect = new Rectangle(bong.getX(), bong.getY(), 20, 20);
						Rectangle brickRect = rect;

						if (ballRect.intersects(brickRect)) {
							ball.setBrickValue(0, i, j);
							sobong--;
							score += 5;
							if (bong.getX() + 19 <= brickRect.x || bong.getX() + 1 >= brickRect.x + brickRect.width) {
								bong.setHuongX(-bong.getHuongX());
							} else {
								bong.setHuongY(-bong.getHuongY());
							}
							break A;
						}

					}
				}
			}
		}
	}

	

	public class PlayerHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent suKien) {

			int code = suKien.getKeyCode();
			if (code == KeyEvent.VK_LEFT) {
				trai = true;
				phai = false;
			} else if (code == KeyEvent.VK_RIGHT) {
				trai = false;
				phai = true;
			}
			if (code == KeyEvent.VK_SPACE) {
				play = !play;
				score = 0;
			}
		}

		public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
				trai = false;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				phai = false;
		}

		public void keyTyped(KeyEvent e) {
		}

	}

}
