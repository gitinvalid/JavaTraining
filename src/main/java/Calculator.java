import java.math.BigDecimal;
import java.util.function.Function;

public class Calculator {
    static Function<BigDecimal, BigDecimal> apply(BigDecimal discountRate, BigDecimal taxRate) {
        return (amount) -> {
            if (amount.compareTo(BigDecimal.valueOf(100)) > 0) {
                BigDecimal discountAmount = Discount.run(amount, discountRate);
                return Tax.run(discountAmount, taxRate);
            }
            return Tax.run(amount, taxRate);
        };
    }
}
