package src;

// реализация правил
public record Rule(State oldState, LexClass lexClass, State newState) {
}
