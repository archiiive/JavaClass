package g;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class G17_collect_gruopBy {
	
	//collect()메서드는 스트림의 요소들을 필터링ㅇ하거나 매핑한궁 새로운 객체로 생성한다.
	//groupingBy()메서드는  map객체를 생성할수있다.
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		      Shape s1 = new Rectangle(10, 3);
		      Shape s2 = new Circle(10);
		      Shape s3 = new Rectangle(20, 2);
		      Shape s4 = new Circle(11);
		      
		      
		     List<Shape> list = Arrays.asList(s1,s2,s3,s4);
		     
		     //요소가 렉탱글 객체인 경우 콜렉트 메서드로 리스트로 변환
		     List<Shape> rectList = list.stream()
		    		 .filter(s -> s instanceof Rectangle).collect(Collectors.toList());
		     
		     rectList.stream().forEach(f -> System.out.println(f));
		     System.out.println(); 
		     
		     
		     //요소가 Rectangle 객체인 경우 collect 메서드로 set으로 변환
		     Set<Shape> rectSet = list.stream()
		    		 .filter(s -> s instanceof Rectangle).collect(Collectors.toSet());
		     rectSet.stream().forEach(System.out::println);
		     
		     
		     //gruopingBy() Map객체 생성
		     try {//객체 타입으로 그루핑(Rectangle, Circle)
		    	 Map<Object, List<Shape>> map = list.stream().collect(Collectors.groupingBy(f -> f.getClass()));
		    			 System.out.println("사각형 출력");
		    			 map.get(Class.forName("G13_.Rectangle")).stream().forEach(f->System.out.println(f));
		    			 
		    			 map.get(Class.forName("Circle")).stream().forEach(f -> System.out.println(f));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}

}
