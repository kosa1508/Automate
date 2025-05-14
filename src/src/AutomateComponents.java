package src;

// задаю необходимые для решения задачи Состояние и LexClass
public class AutomateComponents {
    // LexClass определения
    public static final LexClass DIGIT = c -> c >= '0' && c <= '9';
    public static final LexClass SIGN = c -> c == '+' || c == '-';
    public static final LexClass DOT = c -> c == '.';

    // Состояния
    public static final State S0 = () -> false;
    public static final State S1 = () -> false;
    public static final State S2 = () -> true;
    public static final State S3 = () -> true;
    public static final State S4 = () -> true;
    public static final State S5 = () -> false;
}
