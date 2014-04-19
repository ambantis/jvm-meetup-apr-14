import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenAFile7 {

  public String getLine(String fileName, int n) 
    throws IOException, FileNotFoundException, NullPointerException {
    Path file = Paths.get(".", fileName);
    try (BufferedReader buf = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
      for (int i = 1; i < n; i++)
        buf.readLine();
      return buf.readLine();
    }
  }
}
