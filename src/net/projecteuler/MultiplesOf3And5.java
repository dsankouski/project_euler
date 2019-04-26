package net.projecteuler;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class MultiplesOf3And5 {
    private static final int[] dividers = {3, 5};

    public static void main(String[] args) {
        Integer sumOfMultiples = IntStream.range(1, 1000).filter(isMultiplierOf(dividers)).sum();

        System.out.println(sumOfMultiples);
    }

    private static IntPredicate isMultiplierOf(int... dividers) {
        return (int multiplier) -> Arrays.stream(dividers)
                .mapToObj(divider -> multiplier % divider == 0).reduce(Boolean::logicalOr)
                .orElseThrow(() -> new IllegalStateException(
                        "Failed to determine, if number " + multiplier + " can be divided by " + Arrays.toString(dividers)
                ));
    }
}
