
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class Bongmuctieu {
	public int map[][];
	public int daibong;
	public int rongbong;
	public Bongmuctieu(int row,int col) {
		//Tạo bảng (3 dòng 7 cột)
		map=new int [row][col];
		for(int i=0;i<map.length;i++) {
			for (int j=0;j<map[0].length;j++ ) {
				map[i][j]=1;
			}
		}
		daibong=490/col;
		rongbong=210/row;
	}
	public void  draw(Graphics2D g) {
		for(int i=0;i<map.length;i++) {
			for (int j=0;j<map[0].length;j++ ) {
				if(map[i][j]>0) {
					g.setColor(Color.red);
					g.fillOval(j*daibong+80, i*rongbong+50, daibong, rongbong);
		
					g.setStroke(new BasicStroke(2));
					g.setColor(Color.white);
					g.drawOval(j*daibong+80, i*rongbong+50, daibong, rongbong);
				}
			}
		}
	}
	public void setBrickValue( int value, int row, int col) {
		map[row][col]=value;
	}

}
