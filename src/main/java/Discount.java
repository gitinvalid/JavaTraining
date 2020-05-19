import java.math.BigDecimal;

public class Discount {
    static public BigDecimal run(BigDecimal amount, BigDecimal discountRate) {
        BigDecimal discount = amount.multiply(discountRate);
        return amount.subtract(discount);
    }
}
