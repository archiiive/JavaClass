package h;

public class H04_ThreadEx3 {

   public static void main(String[] args) {
      
      // 게임 객체 생성
      SmartPhoneGame game = new SmartPhoneGame();
      
      // 플레이어1 객체 생성 후 스레드 실행
      Player1 p1 = new Player1();
      p1.setSmartPhoneGame(game);
      p1.start();
      
      // 플레이어2 객체 생성 후 스레드 실행
      Player2 p2 = new Player2();
      p2.setSmartPhoneGame(game);
      p2.start();
      
   }

}

// 스마트폰게임 클래스
class SmartPhoneGame {
   private int level; // 레벨
   
   public int getLevel() {
      return this.level;
   }
   
   
   public synchronized void increaseLevel() {
      while (true) {
         this.level++; // 레벨 1씩 증가
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {}
         // 현재 스레드의 이름과 레벌 출력
         System.out.println(Thread.currentThread().getName()+" Level : " + this.level);
         if (this.level == 5) {
            notifyAll();			//현재 대기중인 모든 스레드를 실행 상태로 전
            try { 
            	//notify():현재 대기중인스레드를 한개만 실행 중으로 변환(직접 지정 불가)
               wait();		//현재 실행중인스레드를 대기 상태로 전
            } catch (InterruptedException e) {}
            break;
         }
         // 레벨이 10의 배수가 되면 종료
         if (this.level % 10 == 0) break;
      }
   }
   
   
}

// 플레이어1 스레드
class Player1 extends Thread {
   private SmartPhoneGame game;
   
   public void setSmartPhoneGame(SmartPhoneGame game) {
      this.setName("Player1");
      this.game = game;
   }
   
   @Override
   public void run() {
      game.increaseLevel();
   }
}

// 플레이어2 스레드
class Player2 extends Thread {
   private SmartPhoneGame game;
   
   public void setSmartPhoneGame(SmartPhoneGame game) {
      this.setName("Player2");
      this.game = game;
   }
   
   @Override
   public void run() {
      game.increaseLevel();
   }
}
