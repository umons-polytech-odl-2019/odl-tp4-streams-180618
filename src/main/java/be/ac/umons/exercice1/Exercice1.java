package be.ac.umons.exercice1;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice 1 : Collections and Lambdas.
 *
 */
public class Exercice1 {

    public static void main(String args[]) {
        List<Employee> peoples = new ArrayList<>();
        peoples.add(new Employee(101, "Victor", 23));
        peoples.add(new Employee(102, "Rick", 21));
        peoples.add(new Employee(103, "Sam", 25));
        peoples.add(new Employee(104, "John", 27));
        peoples.add(new Employee(105, "Grover", 23));
        peoples.add(new Employee(106, "Adam", 22));
        peoples.add(new Employee(107, "Samy", 224));
        peoples.add(new Employee(108, "Duke", 29));

        double average = calculateAverage(peoples);
        System.out.println("Average age of employees are (classic way) : "
                + average);

        average = lambda(peoples);
        System.out.println("Average age of employees are (lambda way) : "
                + average);
    }

    /**
     * Java Method to calculate average from a list of object without using
     * lambdas, doing it on classical java way.
     * @param employees
     * @return average age of given list of Employee
     */
    private static double calculateAverage(List<? extends Employee> employees){
        int totalEmployee = employees.size();
        double sum = 0;
        for(Employee e : employees){
            sum += e.getAge();
        }

        double average = sum/totalEmployee;
        return average;
    }

    /**
     * Java method which uses map reduce to calculate average of list of
     * employees in JDK 8.
     * @param peoples
     * @return average age of given list of Employees
     */
    private static double lambda(List<? extends Employee> peoples){
        // Compléter le code par le traitement d'un stream équivalent
        // à celui de la fonction calculateAverage

        return 0;
    }

}