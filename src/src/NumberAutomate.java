package src;

import static src.AutomateComponents.*;

public class NumberAutomate {
    // создание автомата
    public final static Automate NUMBER_AUTOMATE = new Automate(
            // начальное состояние
            S0,

            //S0 - начальное состояние
            //S1 - состояние после ввода знака (+/-)
            //S2 - состояние после ввода цифры в целой части
            //S3 - состояние после ввода точки в числе
            //S4 - состояние после ввода цифры в дробной части
            //S5 - состояние после ввода точки без предшествующей цифры

            new Rule(S0, DIGIT, S2),
            new Rule(S0, SIGN, S1),
            new Rule(S0, DOT, S5),

            new Rule(S1, DIGIT, S2),
            new Rule(S1, DOT, S5),

            new Rule(S2, DIGIT, S2),
            new Rule(S2, DOT, S3),

            new Rule(S3, DIGIT, S4),

            new Rule(S4, DIGIT, S4),

            new Rule(S5, DIGIT, S4)
    );
}