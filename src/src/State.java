package src;

// интерфейс состояний
@FunctionalInterface
public interface State {
    boolean isFinal();
}
