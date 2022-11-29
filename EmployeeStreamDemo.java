package streamExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {

    static List<Employee> employees = new ArrayList<>();

    public static void method1() {
        System.out.println("How many male and female employees are present in organization");
        Map<String, Long> noOfMaleAndFemaleEmps = employees.stream().
                collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmps);
    }

    public static void method2() {
        System.out.println("Print the name of all departments in organization");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    public static void method3() {
        System.out.println("Average age of male and female employees are present in organization");
        Map<String, Double> avgAgeOfMaleAndFemaleEmps = employees.stream().
                collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmps);
        /*
            Avg age of all employees
         */
        double average = employees.stream().mapToDouble(Employee::getAge).summaryStatistics().getAverage();
        System.out.println(average);
    }

    public static void method4() {
        System.out.println("Details of highest paid employee in organization");
        Employee emp = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).
                orElse(null);
        double max = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics().getMax();
        System.out.println(emp);
        System.out.println(max);
    }

    public static void method5() {
        System.out.println("Name of all employees in organization who joined after 2015");
        employees.stream().filter(e -> e.getYearOfJoining() > 2015).
                map(Employee::getName).forEach(System.out::println);
    }

    public static void method6() {
        System.out.println("Count the number of employees in each department");
        employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).
                entrySet().forEach(System.out::println);
    }

    public static void method7() {
        System.out.println("Average salary of each department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary))).entrySet().forEach(System.out::println);
    }

    public static void method8() {
        System.out.println("Details of Youngest Male Employee in organization");
        Employee emp = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("Male")).
                min(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println(emp);
    }

    public static void method9() {
        System.out.println("Most work exp in organization");
        Employee emp = employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).orElse(null);
        System.out.println(emp);
    }

    public static void method10() {
        System.out.println("How many male and female employees are there in HR team");
        Map<String, Long> countMaleAndFemaleEmpByDept = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR")).
                collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(countMaleAndFemaleEmpByDept);
    }

    public static void method11() {
        System.out.println("Average Salary of male and female employees are present in organization");
        Map<String, Double> avgSalaryOfMaleAndFemaleEmps = employees.stream().
                collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryOfMaleAndFemaleEmps);
    }

    public static void method12() {
        System.out.println("Name of all employees in each department");

        Map<String, List<String>> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).
                entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey, o -> o.getValue().
                                stream().map(Employee::getName).collect(Collectors.toList())));
        System.out.println(map);
    }

    public static void method13() {
        System.out.println("Average and total salary of whole organization");
        double avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println(avgSalary);
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics().getSum();
        System.out.println(totalSalary);
        double min = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getMin();
        System.out.println(min);
    }

    public static void method14() {
        System.out.println("Separate the employees who are younger than 25 from those who are" +
                " older than 25");
        Map<Boolean, List<String>> map = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, o -> o.getValue().stream().map(Employee::getName).collect(Collectors.toList())));
        System.out.println(map);
    }

    public static void main(String[] args) {
        employees.add(new Employee(100, "Jiya", 32, "Female", "HR", 2011, 25000));
        employees.add(new Employee(101, "Paul", 25, "Male", "Sales", 2015, 15000));
        employees.add(new Employee(102, "Martin", 29, "Male", "Admin", 2012, 18000));
        employees.add(new Employee(103, "Murali", 28, "Male", "Product", 2014, 32500));
        employees.add(new Employee(104, "Nima", 24, "Female", "HR", 2013, 27000));
        employees.add(new Employee(105, "Iqbal", 43, "Male", "Security", 2016, 10000));

        method1();
        System.out.println("\n");
        method2();
        System.out.println("\n");
        method3();
        System.out.println("\n");
        method4();
        System.out.println("\n");
        method5();
        System.out.println("\n");
        method6();
        System.out.println("\n");
        method7();
        System.out.println("\n");
        method8();
        System.out.println("\n");
        method9();
        System.out.println("\n");
        method10();
        System.out.println("\n");
        method11();
        System.out.println("\n");
        method12();
        System.out.println("\n");
        method13();
        System.out.println("\n");
        method14();
        System.out.println("\n");
    }

}
