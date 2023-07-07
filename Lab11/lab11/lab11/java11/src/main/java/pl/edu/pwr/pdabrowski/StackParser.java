package pl.edu.pwr.pdabrowski;

import main.java.pl.edu.pwr.pdabrowski.StackInfo;

import java.util.stream.Collectors;

public class StackParser implements StackInfo {

    @Override
    public String getStackCount() {
        return "Java 9: " + StackWalker.getInstance()
                .walk(stream -> String.valueOf(stream.count()));
    }

    @Override
    public String getStack() {
        return StackWalker.getInstance()
                .walk(frames -> frames.map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }
}