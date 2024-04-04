package g;


public class G01_lamdaFunctionEx {
   //람다식 (간결한 코드 사용)
   //고전적인 방식인 객체지향적인 프로그램 방식이 아닌 함수적 프로그래밍을 위한 기법에 사용
   //람다는 익명함수를 위한 방식, 람다는 기존방식보다 자바코드를 간결하게 표현할 수 있다
   //다만, 처음에는 익숙하지 않아 혼란스러울 수 있다.
   
   //람다식은 함수적 인터페이스를 자료형으로 사용.
   //-함수적 인터페이스 : 추상 메소드가 한개만 존재하는 인터페이스
   
   //람다식의 표현 
   //(타입매개변수) - > {실행문}
   //매개변수가 없는 경우 () -> {} 식으로 표현
   //매개변수가 하나인경우 ()생략가능 
   
   //인터페이스 변수  =  람다식;
   
   public static void main(String[] args) {
      // 첫번째 람다
   InterFaceEx ie = (int x, int y) -> x+y;
   System.out.println(ie.sum(10,20));
   // 함수적 인터페이스
   LamdaInterface li = () -> {
      String st = "메서드 출력";
      System.out.println(st);
   };
   li.print();
   
   LambdaInterFace3 li3 =(name) -> {
		  System.out.println("제이름"+name+"입니");
	  };
	  li3.print("홍길");
	  
	  
	  
	  LambdaInterFace4 li4 = (x,y) -> {
		  return x*y;
	  };
	  System.out.println(li4.cal(3,2));
	  System.out.println("두수의 곱 : "+ li4.cal(3, 2));
	  
	  li4 = (x, y) -> x + y ;
		  System.out.println("두수의 합 : "+li4.cal(3,2));
		
	 li4 = (x,y) -> {return x/y;};
	 System.out.println(li4.cal(5, 2));
	 
	 //람다식에 사용되는 this
	 //람다식은 내부클래스의 익명객체로 인식하므로,내부에 this는 람다 객체 그 자신을 의미한
	 //즉,내부 클래스와 같이 람다 표현식 내에서 지역변수접근시 지역변수는 상수화 해야함.
	 
	 Outer o = new Outer();
	 o.method();
	 
   
   }

   
  
//   void print(); 메소드가 두개라서 오류 발생
}
@FunctionalInterface
interface LamdaInterFace5{
	void method();
}


class Outer{
	public int iv =10;
	void method() {
		final int iv = 40; //지역변
		//this.iv = 70;
		LamdaInterFace5 f5 = ()->{
			System.out.println("Outer.this.iv : "+Outer.this.iv);
			System.out.println("this.iv : "+this.iv);
			System.out.println("iv : "+iv);
		};
		f5.method();
	}
}



@FunctionalInterface///함수적 인터페이
interface LambdaInterFace3{ //매개변수는 있고 반환타입은없는경우
	void print(String name);
	}




interface InterFaceEx {
	public int sum(int x, int y);
	   
	}

@FunctionalInterface
interface LambdaInterFace4{
	int cal (int x, int y);
}


@FunctionalInterface   //해당 인터페이스가 함수적 인터페이스 임을 알림
interface LamdaInterface {
	   void print();

	}








