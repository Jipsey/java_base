import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double result = 0;
        Locale locale = Locale.ENGLISH;
        Scanner scanner = new Scanner(System.in);

        while ( scanner.hasNext()){

            if (scanner.hasNextDouble())
                result = Double.sum(result, scanner.nextDouble());

            else
                scanner.next();
        }

        System.out.printf(locale,"%6f",result);
    }
}