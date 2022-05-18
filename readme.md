# Stream연산자와 for문 벤치마크를 위한 프로젝트

프로젝트 환경
---
cpu : Apple M1 Max

memory : 32GB

jdk : Oracle Open Jdk 17

---

### 순차적 스트림을 사용해 10,000,000개의 숫자를 더하는 벤치마크 결과

```
Benchmark                              Mode  Cnt   Score   Error  Units
ParallelStreamBenchmark.sequentialSum  avgt   40  56.770 ± 0.409  ms/op
```

---

### 전통적인 for 루프를 사용해 10,000,000개의 숫자를 더하는 벤치마크 결과

```
Benchmark                             Mode  Cnt  Score   Error  Units
ParallelStreamBenchmark.iterativeSum  avgt   40  3.394 ± 0.025  ms/op
```

---

### 특화된 스트림(LongStream)을 사용해 10,000,000개의 숫자를 더하는 벤치마크 결과

```
Benchmark                          Mode  Cnt  Score   Error  Units
ParallelStreamBenchmark.rangedSum  avgt   40  3.351 ± 0.016  ms/op
```

---

### 특화된 스트림(LongStream)에 병렬 스트림을 적용하여 10,000,000개의 숫자를 더하는 벤치마크 결과

```
Benchmark                                  Mode  Cnt  Score   Error  Units
ParallelStreamBenchmark.parallelRangedSum  avgt   40  0.527 ± 0.018  ms/op
```
