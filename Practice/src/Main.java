import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path readpath = Path.of("C:/Users/Muni Raj Singh/Desktop/AssignmentRead.txt");
        Path writepath = Path.of("C:/Users/Muni Raj Singh/Desktop/AssignmentWrite.txt");
        try {
            String read = Files.readString(readpath);
            Predicate<String> zero= line->line.contains("0");
            var modifiedData=read.lines().map(line -> line.stripLeading()).filter(Predicate.not(zero)).map(line-> String.valueOf(Integer.parseInt(line)+5)).collect(Collectors.toList());
            Files.writeString(writepath,String.join("\n",modifiedData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }
