package streamExamples;

import interviewQues.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {


    public static void main(String[] args) {

        Integer[] arr = {12,34,45,6,32,25,45};
        int res = Arrays.stream(arr).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(res);
        List<interviewQues.Employee> employees = Stream.of(new interviewQues.Employee(1, "Basant", "DEV", 50000),
                        new interviewQues.Employee(1, "Santosh", "DEV", 80000),
                        new interviewQues.Employee(1, "Pratik", "QA", 60000),
                        new interviewQues.Employee(1, "Dipak", "QA", 90000),
                        new interviewQues.Employee(1, "Vikas", "DEVOPS", 40000)).
                collect(Collectors.toList());

        // Highest salary by each department
        Map<String, Optional<interviewQues.Employee>> employeeMap = employees.stream().collect(Collectors.
                groupingBy(interviewQues.Employee::getDept,
                        Collectors.reducing(BinaryOperator.maxBy((Comparator.comparingDouble(Employee::getSalary))))));

        System.out.println(employeeMap);

        // Increase the salary by 10% if Dept is DEV.
        employees.stream().map(e -> {
            if (e.getDept().equalsIgnoreCase("DEV")) {
                e.setSalary(e.getSalary() * 1.1);
            }
            return e;
        }).forEach(System.out::println);
    }
}
