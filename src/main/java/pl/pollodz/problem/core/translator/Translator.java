package pl.pollodz.problem.core.translator;

public interface Translator<Input, Output> {

    Output translate(Input object);
}
