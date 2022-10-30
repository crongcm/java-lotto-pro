package lotto.domain;

import java.util.Objects;

public class LottoPurchaseQuantity {
    public static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";

    private final int quantity;

    private LottoPurchaseQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoPurchaseQuantity of(int quantity) {
        return new LottoPurchaseQuantity(quantity);
    }

    public String getMessage() {
        return String.format(PRINT_QUANTITY_FORMAT, this.quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchaseQuantity that = (LottoPurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}