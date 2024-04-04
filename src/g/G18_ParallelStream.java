package g;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class G18_ParallelStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<10;i++){
            list.add(i);
        }
        long start = System.nanoTime();
        //stream() 스트림 처리
        list.stream().forEach(a -> {
            try {
                Thread.sleep(1000); //1초정도 쉼
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println("순차 스트림 처리 시간 : "+(end-start)+"nano sec");

        start = System.nanoTime();
        //병렬stream() 스트림 처리
        list.parallelStream().forEach(a -> {
            try {
                Thread.sleep(1000); //1초정도 쉼
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        end = System.nanoTime();
        System.out.println("병렬 스트림 처리 시간 : "+(end-start)+"nano sec");
        //스트림 연결하기 : Steam .concat()

        Stream<String> stream1 = Stream.of("홍길동", "김유신","이순신","유관순" );
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6,7,8,9,10);
        //concat 메서드를 사용 위 두 개의 스트림 묶기

        Stream<Object> concat =  Stream.concat(stream1,stream2);
        concat.forEach(a->System.out.print(a+"\t"));

    }

}