package g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class G16_optionalEx {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		for(int i=0;i<100;i++) {
			arr[i] = i+1;
		}
		
		//갯수는 리턴값ㅇ long
		long count = Arrays.stream(arr).count();
		System.out.println("요소들의 갯"+count);
		
		//요소 들의 합
		int sum = Arrays.stream(arr).sum();
		System.out.println("요소들의 합 : "+sum);
		
		OptionalInt first = Arrays.stream(arr).findFirst();
		System.out.println("요소들중 첫번째 값 : "+first.getAsInt());
		
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println("요소들 중 최댓값 : "+max.getAsInt());
		
		OptionalInt min = Arrays.stream(arr).min();
		OptionalDouble avg = Arrays.stream(arr).average();
		
		System.out.println("요소들의 평균 : "+ avg.getAsDouble());
		
		
		///요소가 없는 빈ArrayList객체 생성
		List<Integer> list2 = new ArrayList<>();
		
		long count2 = list2.stream().count();
		System.out.println("요소들의갯수 : "+count2);
		
		
		int sum2 = list2.stream().mapToInt(Integer::intValue).sum();
		System.out.println("요소들의합 : " + sum2);
		
		//Optionalxxx, isPresent() - 값이 존재하는지 여부 확인
		
		
		OptionalDouble avg2 = list2.stream().mapToInt(Integer::intValue).average();
		//요소값이 있는 경우에만 출력
		if(avg2.isPresent()) {
			System.out.println("요소들의 평균 : "+avg2.getAsDouble());
 
		}
				
		//orElse(): 기본값 설정
		int max2 = list2.stream().mapToInt(Integer :: intValue).max().orElse(0);
				System.out.println("요소들 중 최대 값 : "+max);
			
		int min2 = list2.stream().mapToInt(Integer::intValue).max()	.orElse(-1);
		System.out.println("요소들 중 최소 값 : "+min2);
		//
		list2.stream().mapToInt(Integer :: intValue).findFirst().ifPresent(a -> System.out.println("요소의 첫번째 값 : "+a));
		
		//사용자 집계 메서드 - reduce()메서드
		// 사용자가 다양한 집계 결과물을 생성할 수 있는 메서드
		//reduce메서드는 매개변수 타입이 Operator를 이용하고,
		//Stream,IntStream, LongStream,DoubleStream.
		
		
		
				

	}

}
