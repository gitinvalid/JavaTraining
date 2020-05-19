import java.math.BigDecimal;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        Function<BigDecimal, BigDecimal> calculate = Calculator.apply(
                BigDecimal.valueOf(0.2),
                BigDecimal.valueOf(0.1)
        );

        BigDecimal result1 = calculate.apply(BigDecimal.valueOf(200));
        System.out.println(result1);

        BigDecimal result2 = calculate.apply(BigDecimal.valueOf(50));
        System.out.println(result2);
    }
}
