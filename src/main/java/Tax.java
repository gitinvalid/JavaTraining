import java.math.BigDecimal;

public class Tax {
    static public BigDecimal run(BigDecimal amount, BigDecimal taxRate) {
        BigDecimal tax = amount.multiply(taxRate);
        return amount.add(tax);
    }
}
