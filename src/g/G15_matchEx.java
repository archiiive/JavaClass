package g;
import java.util.Arrays;
import java.util.List;

public class G15_matchEx {
   
   /*
    * 스트림 내부의 요소들이 특정 조건을 만족했는지 검사할 수 있는 메소드
    * allMatch(Predicate p) 모두 만족할때 true 리턴
    * anyMatch(Predicate p) 일부가 만족할때 true 리턴
    * noneMatch(Predicate p) 모두 만족하지 않으면  true
    * 
    */
   
   
   
   public static void main(String[] args) {
      Shape s1 = new Rectangle(10, 3);
      Shape s2 = new Circle(10);
      Shape s3 = new Rectangle(20, 2);
      Shape s4 = new Circle(11);

      List<Shape> list = Arrays.asList(s1, s2, s3, s4);
      
      //모든 요소들이 Shape의 인스턴스인지 조건 비교
      
      boolean res = list.stream().allMatch(a->(a instanceof Shape));
      System.out.println("모든 요소는 Shape의 객체이다 "+res);
      boolean res2 = list.stream().anyMatch(a->(a instanceof Rectangle));
      System.out.println("요소 중 하나 이상이 rectangle 객체이다 "+res2);
      boolean res3 = list.stream().anyMatch(a->(a instanceof Rectangle));
      System.out.println("요소 중 rectangle의 객체가 존재한 "+res3);
      
   }

}
