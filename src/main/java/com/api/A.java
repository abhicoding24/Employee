package com.api;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A {
    public static void main(String[]args){
        Predicate<Integer> val1= a1->a1>20;
        boolean test = val1.test(10);
        System.out.println(test);

        Function<String,Integer> val2 = a2->a2.length();
        Integer apply = val2.apply("Kolkata");
        System.out.println(apply);

        Consumer<String> val3= a3->System.out.println(a3);
        val3.accept("hello world");

        List<Integer> nums = Arrays.asList(10,20,5,20,6,1,10,9,5,7,20);
        List<Integer> removeDuplicate = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(removeDuplicate);
        List<Integer> sortedList = nums.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        List<Integer> distinctSorted = nums.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(distinctSorted);
        Integer sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        Optional<Integer> maxNum = nums.stream().max(Integer::compareTo);
        System.out.println(maxNum.get());
        Optional<Integer> minNum = nums.stream().min(Integer::compareTo);
        System.out.println(maxNum.get());
        Map<Integer,List<Integer>> occurance = nums.stream().collect(Collectors.groupingBy(Integer::intValue));
        System.out.println(occurance);
        Map<Integer,Long> countOccurances = nums.stream().collect(Collectors.groupingBy(d->d,Collectors.counting()));
        System.out.println(countOccurances);
        Optional<Integer> nextMaxNum = nums.stream().filter(x->x>20).findFirst();
        System.out.println(nextMaxNum);
        List<Integer> squareOfNums = nums.stream().map(a->a*a).collect(Collectors.toList());
        System.out.println(squareOfNums);
        List<Integer> oddNums = nums.stream().filter(b->b%2!=0).collect(Collectors.toList());
        System.out.println(oddNums);
        Consumer<Integer> printNums = c->System.out.println(c);
        nums.forEach(printNums);

        List<String> names = Arrays.asList("mike","eddy","navin","raj","mahi","pravin","ritika","mike","eddy","mahesh");
        List<String> namees = names.stream().filter(a->a.startsWith("m")).collect(Collectors.toList());
        System.out.println(namees);
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);
        List<String> duplicateRemove = names.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicateRemove);
        List<String> duplicateRemoveSort = names.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(duplicateRemove);
        List<String> length = names.stream().filter(x->x.length()>3).collect(Collectors.toList());
        System.out.println(length);
        List<Integer> lengthOfNames = names.stream().map(x->x.length()).collect(Collectors.toList());
        System.out.println(length);
        Map<String,Long> namesOccurance = names.stream().collect(Collectors.groupingBy(a->a,Collectors.counting()));
        System.out.println(namesOccurance);
        Map<Integer,List<String>> groupByLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupByLength);

        List<Student> students = Arrays.asList(
                new Student(1,"mike",20),
                new Student(2,"stallin",18),
                new Student(3,"eddy",24),
                new Student(4,"will",19)
        );
        List<Student> newStudentList=students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        for(Student ns:newStudentList) {
            System.out.println(ns.getId());
            System.out.println(ns.getName());
            System.out.println(ns.getAge());
        }
        List<Student> select = students.stream().filter(a->a.getAge()>20).collect(Collectors.toList());
        for(Student ns:select) {
            System.out.println(ns.getId());
            System.out.println(ns.getName());
            System.out.println(ns.getAge());
        }
        Optional<Student> student = students.stream().max(Comparator.comparing(a->a.getAge()));
        System.out.println(student.get().getId());
        System.out.println(student.get().getName());
        System.out.println(student.get().getAge());

        List<StudentDto> dtos = students.stream().map(a->mapToDto(a)).collect(Collectors.toList());
        for(StudentDto ns:dtos) {
            System.out.println(ns.getId());
            System.out.println(ns.getName());
        }

    }

    static StudentDto mapToDto(Student student){
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        return dto;


    }

}
