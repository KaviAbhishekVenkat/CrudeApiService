package com.kav.CrudeApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Synchronized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    String name, address, email, bloodGroup, grade;
    int age;
    List<String> contact = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        List<StudentDto> students = Stream.of(
                new StudentDto("Ram", "chennai", "Ram@gmail.com", "N+", "S+", 34, Arrays.asList(new String[]{"cds", "abc"})),
                new StudentDto("abhishek", "chennai", "abhishek@gmail.com", "C-", "Z+", 66, Arrays.asList(new String[]{"bcd", "abc"})),
                new StudentDto("Shyam", "chennai", "Shyam@gmail.com", "O+", "A+", 22, Arrays.asList(new String[]{"evf", "abc"})),
                new StudentDto("Zebra", "chennai", "Zebra@gmail.com", "O+", "B+", 90, Arrays.asList(new String[]{"ghj", "abc"}))

        ).collect(Collectors.toList());
        System.out.println(
                students.parallelStream().filter(p -> p.age > 20).
                        sorted(Comparator.comparing(StudentDto::getAge, Comparator.reverseOrder()))
                        .collect(Collectors.toList()));

        System.out.println(
                students.stream().map(StudentDto::getBloodGroup).collect(Collectors.toList())
        );
        System.out.println(
                students.stream().flatMap(s -> s.getContact().stream()).collect(Collectors.toList())
        );

        System.out.println(
                students.stream().collect(Collectors.groupingBy(StudentDto::getBloodGroup))
        );
        System.out.println(
                students.stream().collect(Collectors.groupingBy(StudentDto::getBloodGroup, Collectors.counting()))
        );

        System.out.println(
                students.stream().collect(Collectors.groupingBy(StudentDto::getBloodGroup, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .skip(1)
                        .collect(Collectors.toList())
        );
        System.out.println(
                students.stream().collect(Collectors.groupingBy(StudentDto::getBloodGroup, Collectors.averagingInt(StudentDto::getAge)))
        );

        System.out.println(
                students.stream().collect(Collectors.groupingBy(StudentDto::getBloodGroup, Collectors.maxBy(Comparator.comparing(StudentDto::getAge))))
        );
        students.parallelStream().forEach(p -> System.out.println("Parallel Thread is " + Thread.currentThread().getName() + " user name " + p.getName()));
        students.stream().forEach(p -> System.out.println("Thread is " + Thread.currentThread().getName() + " user name " + p.getName()));
        students.stream().parallel().forEach(p -> System.out.println("Parallel 2 Thread is " + Thread.currentThread().getName() + " user name " + p.getName()));


        CompletableFuture.runAsync(() -> StudentDto.printNumber(oddN));
        CompletableFuture.runAsync(() -> StudentDto.printNumber(evenN));
        Thread.sleep(1000);
    }

    private static Object obj = new Object();
    private static IntPredicate evenN = e -> e % 2 == 0;
    private static IntPredicate oddN = e -> e % 2 != 0;

    public static void printNumber(IntPredicate p) {
        IntStream.rangeClosed(1, 10).filter(p).forEach(StudentDto::execute);
    }

    public static void execute(int i) {
        synchronized (obj) {

            try {
                System.out.println("Thread name = " + Thread.currentThread().getName() + " : " + i);
                obj.notify();
                obj.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
