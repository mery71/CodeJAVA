import javax.swing.JFrame;
public class MyFrame extends JFrame {
	MyPanel p;
	public MyFrame(){
		p = new MyPanel();
		this.add(p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
		frame.setTitle("BẮN BÓNG");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
