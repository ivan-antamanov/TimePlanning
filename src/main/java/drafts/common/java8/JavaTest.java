package drafts.common.java8;


import java.util.function.Consumer;
import java.util.function.Function;

public class JavaTest {

    Sumator<String, Integer> sumator = ((value, addValue) -> value+ addValue);

    String summ = sumator.toSum("ololo", 666);

    Consumer<Object> consumer = System.out::print;

    public static void main(String[] args) {
        Sumator<String, Integer> sumator = ((value, addValue) -> value+ addValue);
        String summ = sumator.toSum("ololo", 666);
        Consumer<Object> consumer = System.out::print;
        consumer.accept(summ);
    }
}
