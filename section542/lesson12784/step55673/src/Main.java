import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Main {
    //Stepik code: start

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here

        Reader reader = new InputStreamReader(inputStream,charset);
        int i;
        StringBuilder sb = new StringBuilder();
        while ( (i = reader.read()) != -1) {
             sb.append( Character.toChars(i));
        }

        return sb.toString();
    }
//Stepik code: end
}
