package h;

public class H02_threadEx {
	
	/*
	 * 
	 * 스레드를 생성하는 방법
	 * 1. Thread zmffotmfmf tkdthrgksms qkdqjq
	 * 2. Runnable 인터페이스를 구현한 객체를 Thread객체에 넣어주는 방식
	 * 
	 * thread클래스 속 -tun() 메서드
	 * Runnable구현 - run()추상메서드
	 * 
	 * 
	 */
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//쓰레드 상속
		
		TheadExtend t1 = new TheadExtend();
		
		//Runnable구현
		
		Runnable r = new RunnableImp1();
		Thread t2 = new Thread(r);
		
		
		
		//익명함수를 이용해서 구현...
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
					System.out.println("t3 쓰레스 시");	
					for(int i = 0 ; i < 50; i++) {
						System.out.println("Thread3 : "+i);
					}
			}
		});
		
		
		//람다식 표
		
		Thread t4 = new Thread(()->{
			for(int i = 0 ; i < 50; i++) {
				System.out.println("Thread4 : "+i);
			}
		});
		
		//쓰레드 우선순위
		//스레드가 가질 수 있는 우선 순위는 1 ~10 사이의 숫자로 10이 가장 높은 우선순위이임.
		//중요! 스레드의 우선순위는 절대적 수치가아닌 상대적 수치
		//우선 순위에 따라서 점유시간과 자원이 주어지게 된다.
		//
		//우선순위 	적용방법 - setProperty(int) 1~10 사이의 숫자를 넣어주면 된다.
		
		//	 적용시 주의사항
		
		//1.우선순위는 상대적 값이다.
		//2.스레드를 실행하기 전에 지정해야 한다.
		//3.main 메서드 에서 실행하는 스레드의 경우 기본값5
		// 직접 스레드의우선 순위값을 설정하는것보다 thread의 static final필드 값을 이용하는 것이 더 좋
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t3.setPriority(Thread.NORM_PRIORITY);
		t4.setPriority(Thread.NORM_PRIORITY );
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		

	}

}


//Tread를 상속하는 방식
class TheadExtend extends Thread{
	
	@Override //
	public void run() {
		System.out.println("Thread상속 받는 방법으로 실행");
		for(int i = 0 ; i < 50; i++) {
			System.out.println("ThreadExtends : "+i);
		}
	}
	
	
}

//Runnable

class RunnableImp1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnable을구현하는 방법으로 실");
		for(int i = 0 ; i < 50; i++) {
			System.out.println("RunnableImp : "+i);
		}
	}
}