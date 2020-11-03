package day1103.thread;

import javax.swing.JProgressBar;

public class barThread extends Thread{
	int n;
	int intervar;
	JProgressBar bar;
	
	public barThread(JProgressBar bar,int interval) {
		this.bar=bar;
		this.intervar=interval;
	}
	@Override
	public void run() {
		while(true) {				
			n++;
			bar.setValue(n);			
			try {
				Thread.sleep(intervar);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}
}
