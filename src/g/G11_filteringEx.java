package g;
import java.util.Arrays;
import java.util.List;

public class G11_filteringEx {
	
	
	/*
	 * Stream 3단계 처리순서 :1) 객체생성, 2)가공 3)결과출
	 * 가공 중간 처리 단계 : 필터링 (filtering),매핑(Mappling), 정렬Sorting, 그룹핑
	 * 
	 * 필터림 : stream 내에 요소를 걸러내는 기
	 * 메서드 distinct()-중복 제거,,filter()-조건에 맞는 요소선택 (boolean) 결과에 따라 검
	 *Stream
	 *	strStream
	 * IntStream
	 * LongStream
	 * DoubleStream
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//list 객체 생성
		List<String> list = Arrays.asList(":hongKilldong","killdong",":hongKilldong","killdong");
		
		//distinct()중복제거
		System.out.println("distinct()");
		list.stream().distinct().forEach(s-> System.out.print(s+" "));
		System.out.println();
				//홍 으로 시작하는 무자열로 필터링후 내부 반복자로 출력
	System.out.println("filter()");
	list.stream().filter(n -> n.startsWith("hong"))
	.forEach(s -> System.out.println("s"));
	
	
	System.out.println();
	
	//distinct()와 filter()를 동시에 사용...
	System.out.println("distinct() + filter() ");
	list.stream().distinct().filter(n -> n.startsWith("kill")).forEach(s -> System.out.println(s+" "));
	}
	
	

}
