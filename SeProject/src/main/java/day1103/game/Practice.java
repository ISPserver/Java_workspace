package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Practice extends JPanel{
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	Hero hero;
	Bullet bullet;
	Thread thread;
	
	public Practice() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		thread=new Thread() {
			public void run() {
				while(true) {
					gameLoop();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
					
				}
			};
		};
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	public void gameLoop() {
		tick();
		render();
	}
	
	public static void main(String[] args) {
		new Practice();
	}
}



//1 ) JFrame 생성 , 크기는 패널만큼, 키 리스너 추가
//2 ) JPanel 생성, 상수이용 패널 크기 지정 
/*GamePanel panel;

public Practice() {
	panel = new GamePanel();
	
	setLayout(new FlowLayout());
	add(panel);		
			
	pack(); //JFrame.pack == 
	setDefaultCloseOperation(EXIT_ON_CLOSE); //X버튼 클릭시 종료
	setLocationRelativeTo(null); //setLocationRelativeTo = null
	setVisible(true);
	
	this.addKeyListener(new KeyAdapter() {
		public void  KeyPressed(KeyEvent e) {
			e.getKeyCode();
		}
		
		public void KeyReleased(KeyEvent e) {
			e.getKeyCode();
		}
	});
}*/