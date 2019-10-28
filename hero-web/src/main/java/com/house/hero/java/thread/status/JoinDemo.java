package com.house.hero.java.thread.status;
/**
 * join:合并线程
 * @author User
 */
public class JoinDemo extends Thread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		JoinDemo demo = new JoinDemo();
		//新生
		Thread t = new Thread(demo);
		//就绪
		t.start();
		//cpu调度 运行

		for(int i=0;i<100;i++){
			if(50==i){
				t.join(); //main阻塞...优先执行t线程
			}
			System.out.println("main...."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("join...."+i);
		}
	}

}
