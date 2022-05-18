package com.icloud;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
@State(value = Scope.Benchmark)
public class ParallelStreamBenchmark {

    private static final Long N = 10_000_000L;

//    @Benchmark
//    public long sequentialSum() {
//        return Stream.iterate(1L, i -> i + 1).limit(N)
//                .reduce(0L, Long::sum);
//    }

//    @Benchmark
//    public long iterativeSum() {
//        long result = 0;
//        for (long i = 1L; i <= N; i++) {
//            result += i;
//        }
//        return result;
//    }

//    @Benchmark
//    public long rangedSum() {
//        return LongStream.rangeClosed(1, N)
//                .reduce(0L, Long::sum);
//    }

    @Benchmark
    public long parallelRangedSum() {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}
