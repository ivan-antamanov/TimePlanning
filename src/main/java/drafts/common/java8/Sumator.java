package drafts.common.java8;

@FunctionalInterface
public interface Sumator<V, D> {
    String toSum(V value, D addValue);
}
