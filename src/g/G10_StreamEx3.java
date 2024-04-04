package g;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

//import javax.naming.directory.BasicAttribute;

public class G10_StreamEx3 {
    public static void main(String[] args) {
        try {
            // Paths.get() 메서드 사용
            Path path = Paths.get("/Users/th/Desktop/FirstJava/src/G09_streamEx2.java");
            Stream<String> stream = Files.lines(path, Charset.defaultCharset());

            stream.forEach(s -> System.out.println(s));
            stream.close();

            System.out.println();
            System.out.println();

            // BufferedReader이 lines() 메서드 사용
            File file = path.toFile();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.lines().forEach(s -> System.out.println(s)); 

            br.close(); // Close the BufferedReader

            System.out.println("==========================================");
            System.out.println("list() 메서드를 이용하여 스트림 생성하기");
            // src 디렉터리 Path 객체 생성하기

            path = Paths.get("/Users/th/Desktop/FirstJava/src"); // 디렉터리를 잡는다.

            // src 경로의 모든 디렉터리와 파일을 stream 객체로 생성한다.
            Stream<Path> sr1 = Files.list(path);

            sr1.forEach(p -> System.out.println(p.getFileName()));

            sr1.close(); 

            System.out.println("find() 메서드를 이용하여 스트림 생성하기");
            // src 디렉터를 시작해서 10단계까지 디렉터리 깊이까지 탐색

            Stream<Path> sr2 = Files.find(path, 10,
                    (p, BasicAttribute) -> {
                        File f = p.toFile();
                        // 디렉터리가 아니고 파일이름에 Stream이 포함된 파일명
                        return !f.isDirectory() && f.getName().contains("Stream");
                    });

            sr2.forEach(p -> System.out.println(p.getFileName())); // Perform action with the stream
            sr2.close(); // Close the Stream

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}