package h;

public class H07_threadEx7 {
/*
 * 
 * 스레드 그룹 
				스레드 그룹은 관련되어 있는 스레드 별로 그룹핑해서 다루기 위해서 사용.
				그룹 안에 또다른 그룹을 생성하는것도 가능함.
				보안상 이유로자신과하위 그룹은 변경이 가능함 . 하지만 다른 그룹은 불가능함.
				
				[관련 메서드들]
				activeCount() :현재 그룹 및 하위 그룹의 모든 스레드 수 리
				activeGruoupCount() : 현재 그룹의 모든 하위 그룹 수를리
				checkAccess() 		:스레드 그룹을 변경할 건한이 있는지 여부 리턴
								
				destroy()			:현재 그룹의 모든 하위 그룹 삭제
				isDestroyed()		:현재 그룹이 삭제되었는지 여부 확인
				getMaxPriority		:현재 그룹의 스레드가 가질 수 있는 최대 우선 순위값 리
				s
				
				
 * 
 * 
 */
	public static void main(String[] args) {
			//그룹 스레드 설정
			//1. 그룹 객체 생성
		ThreadGroup group = new ThreadGroup("Group1");
		//2.t스레드 그룹에 스레드 추
		MyThread t1 = new MyThread(group, "First");
		MyThread t2 = new MyThread(group, "Second");
		MyThread t3 = new MyThread(group, "Third");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {}
		//모든 스레드 중지
		group.interrupt();
		
		System.out.println("그룹 스레드 숫자: "+group.activeCount());
		System.out.println("하위 그룹 숫자 : "+group.activeGroupCount());
		
		System.out.println(group.getParent());
	}

}

class MyThread extends Thread{
	
	public MyThread(ThreadGroup group, String name) {
		super(group, name);
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(getName());
			try {
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println(getName() + "interrupted발생");
				break;
			}
		}
		System.out.println(getName()+"종료");
	}
}
