import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenAFile6 {

  public String getLine(String fileName, int n)
    throws IOException, FileNotFoundException, NullPointerException {
    FileReader reader = null;
    BufferedReader buf = null;
    String result = null;
    try {
      File file = new File(".", fileName);
      reader = new FileReader(file);
      buf = new BufferedReader(reader);
      for (int i = 1; i < n; i++)
        buf.readLine();
      result = buf.readLine();
    } finally {
      try {
        if (buf != null)
          buf.close();
        if (reader != null)
          reader.close();
      } catch (Exception e) {
        // this should never happen
      }
    }
    return result;
  }
}
