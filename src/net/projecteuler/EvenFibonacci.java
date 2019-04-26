package net.projecteuler;

import java.util.Iterator;
import java.util.function.Consumer;

public class EvenFibonacci {
    private static final int LIMIT = 4000000;

    public static void main(String[] args) {
        int sumEvenFibonacci = 0;

        FibonacciIterator fibonacciIterator = new FibonacciIterator(LIMIT);
        while (fibonacciIterator.hasNext()){
            int nextFibonacci = fibonacciIterator.next();
            if (nextFibonacci % 2 != 0) {
                sumEvenFibonacci += nextFibonacci;
            }
        }

        System.out.println(sumEvenFibonacci);
    }

    private static class FibonacciIterator implements Iterator<Integer> {
        private int previous1 = 1;
        private int bleedingEdge = 0;
        private final int LIMIT;


        public FibonacciIterator(int limit) {
            this.LIMIT = limit;
        }

        @Override
        public boolean hasNext() {
            return bleedingEdge + previous1 <= LIMIT;
        }

        @Override
        public Integer next() {
            int temp = bleedingEdge;
            bleedingEdge += previous1;
            previous1 = temp;
            return bleedingEdge;
        }

        @Override
        public void remove() {
            throw new IllegalAccessError("NOT IMPLEMENTED");
        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {
            throw new IllegalAccessError("NOT IMPLEMENTED");
        }
    }
}
