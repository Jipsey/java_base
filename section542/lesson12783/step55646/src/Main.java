import java.io.*;

public class Main {

    public static void main(String... args) throws IOException {
        int prev;
        int next;

            prev = System.in.read();
            do {
                if (prev != -1) {
                    next = System.in.read();
                    if (prev != 13 || next != 10)
                        System.out.write(prev);

                    prev = next;
                }
            } while (prev != -1);
            System.out.flush();
    }
}