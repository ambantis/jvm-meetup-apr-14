public class ZMain {

  public static void main(String[] args) {
    OpenAFile6 worker = new OpenAFile6();
    String fileName = "Main.java";
    int n = 5;
    try {
      String result = worker.getLine(fileName, n);
      if (result == null) {
        System.out.println("Sorry, the line you requested: " + n +
            ", doesn't exist");
      } else {
        System.out.println("Okay, here's the line you requested:\n\t" + result);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Sorry, the file you requested: " + fileName +
          " , doesn't exist");
    } catch (IOException ioe) {
      System.out.println("Sorry, there was a problem with IO, " +
          "please try again later");
    } catch (NullPointerException npe) {
      System.out.println("Sorry, but the file name you provided is null");
    } catch (Exception e) {
      System.out.println("Sorry, there was an Internal Server Error, please try again later");
    }
  }
}
