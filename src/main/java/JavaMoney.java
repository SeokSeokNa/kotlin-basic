import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class JavaMoney implements Comparable<JavaMoney>{

    private final long amount;

    public JavaMoney(long amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(@NotNull JavaMoney o) {
        return Long.compare(this.amount , o.amount); // 괄호안에 왼쪽것이 크면 양수 , 같은값이면 0 , 왼쪽것이 더 작다면 음수를 반환환
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaMoney javaMoney = (JavaMoney) o;
        return amount == javaMoney.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "JavaMoney{" +
                "amount=" + amount +
                '}';
    }
}
