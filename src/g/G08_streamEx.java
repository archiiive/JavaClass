package g;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class G08_streamEx {

	public static void main(String[] args) {
		// TODO Auto-generated metho[d st"Bub
		String[] arr = new String[] {"a","b","c","d","e","f"};
		
		//배열ㄹ 전체 Stream 객체로 변환
		Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(s->System.out.print(s+" "));
        System.out.println();
		 
		
		Stream<String> stream2 = Arrays.stream(arr,2,5); //배열의 일부를 추
		stream2.forEach(s->System.out.println(s+" "));
		System.out.println();
		
		//문자열 배열을 컬렉션 프레임워크로 만들어서 스트림 만들기
		List<String> list = Arrays.asList(arr);
		//List객체를 stream를 이용 스트림 객체 생성
		Stream<String> stream3 = list.stream();
		stream3.forEach(s -> System.out.println(s));
		
		//스트림  객체 생성:build()메서드를 이용하기
		//Builder() 메서드롤 Builder객체 생성 이후에 add()메서드롤 리턴타입이
		//builder객체 이므로 메서드 체이닝 가능...
		Stream stream4 = Stream.builder()
				.add("무궁화")
				.add("삼천리")
				.add("회려강산")
				.add("대한사람")
				.build(); //빌드 객체를 통한 스트림 객체 생성
		stream4.forEach(s -> System.out.println(s + " "));
		System.out.println();
		
		
		//스트림 객체 생성 : 2.generator() 메서드를 이용하기
		//람다에서 Supplier<T> 인터페이스를 이용하여 값을 추가 생성합니다.'
		
		Stream<String> stream5 =Stream.generate(() -> "애국").limit(10);
		stream5.forEach(s -> System.out.println(s+" "));
		System.out.println();
		
		//스트림 객체 생성 : 3.iterate() 메서드를 이용하기
		Stream<Integer> stream6 = Stream.iterate(1, n -> n + 1).limit(10);
		stream6.forEach(s -> System.out.println(s + " "));
		
		
		
		
	}

}
