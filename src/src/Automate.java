package src;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// реализация автомата из лекции
public class Automate implements Predicate<String> {
    private record Key(State state, LexClass lexClass) {}

    private final State initState;
    private final Set<LexClass> classSet;
    private final Map<Key, State> transitions;

    public Automate(State initState, Rule... rules) {
        this.initState = initState;
        classSet = Arrays.stream(rules)
                .map(Rule::lexClass)
                .collect(Collectors.toSet());
        transitions = Arrays.stream(rules)
                .collect(Collectors.toMap(
                        rule -> new Key(rule.oldState(), rule.lexClass()),
                        Rule::newState,
                        (a, b) -> b
                ));
    }

    @Override
    public boolean test(String source) {
        State state = initState;
        for (char c : source.toCharArray()) {
            LexClass lexClass = findClass(c);
            if (lexClass == null) return false;
            Key key = new Key(state, lexClass);
            state = transitions.get(key);
            if (state == null) return false;
        }
        return state.isFinal();
    }

    private LexClass findClass(char c) {
        return classSet.stream()
                .filter(lc -> lc.has(c))
                .findFirst().orElse(null);
    }
}
