package com.algorithmsAndDataStructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Demo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "ccc", "d"); // [1, 2, 3, 1]

        System.out.println(list.stream().map(String::length).collect(new MyToListCollector())); // [1, 2, 3, 1]

        MyCollector myCollector = new MyCollector();
        MySetCollector mySetCollector = new MySetCollector();
        List<Integer> result = myCollector.getSupplier().get();

        list.stream().map(String::length).forEach(element -> {
            myCollector.getBiConsumer().accept(result, element);
        });

    }
}

class MyCollector {
    public Supplier<List<Integer>> getSupplier() {
        return ArrayList::new;
    }

    public BiConsumer<List<Integer>, Integer> getBiConsumer() {
        return List::add;
    }
}

class MyCollector1 implements Collector<Integer, List<Integer>, Void> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return null;
    }

    @Override
    public Function<List<Integer>, Void> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}

class MySetCollector {
    public Supplier<Set<Integer>> getSupplier() {
        return HashSet::new;
    }

    public BiConsumer<Set<Integer>, Integer> getBiConsumer() {
        return Set::add;
    }
}

class MySetCollector1 implements Collector<Integer, Set<Integer>, Void> {
    @Override
    public Supplier<Set<Integer>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<Integer>, Integer> accumulator() {
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<Integer>> combiner() {
        return null;
    }

    @Override
    public Function<Set<Integer>, Void> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}

class MyToListCollector implements Collector<Integer, List<Integer>, List<Integer>> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return x -> x;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.IDENTITY_FINISH);
    }
}
