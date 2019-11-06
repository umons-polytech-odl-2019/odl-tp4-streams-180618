package be.ac.umons.exercice2;

import be.ac.umons.exercice3.Classroom;

import java.util.TreeMap;

/**
 * Exercice 2 : Collections and Streams (Student)
 *
 * @author Adriano Guttadauria
 * @author Olivier Debauche
 */
public class Exercice2 {

    public static void main(String[] args) {

        System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┣ Collections and Streams (Student) ┫" );
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        TreeMap<String, Student> students = new TreeMap<String, Student>();
        students.put("Stannis Baratheon", new Student("Stannis Baratheon", "012345"));
        students.put("Thyrion Lannister", new Student("Thyrion Lannister", "012348"));
        students.put("Jon Snow",new Student("Jon Snow", "998877"));
        students.put("Tywin Lannister", new Student("Tywin Lannister", "002345"));
        students.put("Gendry",new Student("Gendry", "225533"));
        students.put("Theon Greyjoy",new Student("Theon Greyjoy", "123654"));
        students.put("Sansa Stark",new Student("Sansa Stark", "425163"));
        students.put("Daenarys Targaryen",new Student("Daenarys Targaryen", "028743"));
        students.put("Loras Tyrell",new Student("Loras Tyrell", "102039"));
        students.put("Cersei Lannister",new Student("Cersei Lannister", "928657"));
        students.put("Arya Stark",new Student("Arya Stark", "987654"));
        students.put("Joffrey Baratheon",new Student("Joffrey Baratheon", "208733"));
        students.put("Davos Seaworth", new Student("Davos Seaworth", "123123"));
        students.put("Jeor Mormont", new Student("Jeor Mormont", "123123"));
        students.put("Samwell Tarly", new Student("Samwell Tarly", "334455"));
        students.put("Melisandre", new Student("Melisandre", "666999"));

        students.get("Jon Snow").setScore("temperance", 15);
        students.get("Jon Snow").setScore("loyalty", 20);
        students.get("Jon Snow").setScore("fighting", 18);
        students.get("Jon Snow").setScore("lying", 2);

        students.get("Thyrion Lannister").setScore("accountancy", 19);
        students.get("Thyrion Lannister").setScore("running", 9);
        students.get("Thyrion Lannister").setScore("reading", 19);

        students.get("Cersei Lannister").setScore("parenting", 5);
        students.get("Cersei Lannister").setScore("politics", 12);
        students.get("Cersei Lannister").setScore("poisoning", 19);

        students.get("Arya Stark").setScore("fencing", 14);
        students.get("Arya Stark").setScore("surviving", 19);
        students.get("Arya Stark").setScore("sewing", 1);

        Student arya = students.get("Arya Stark");
        System.out.println("Attended courses by " + arya.getName() + " : " + arya.attendedCourses());
        System.out.println("Average score of " + arya.getName() + " : " + arya.averageScore());
        System.out.println("Score by course for " + arya.getName() + " : " + arya.getScoreByCourse());
        System.out.println("Course failed by " + arya.getName() + " : " + arya.failedCourses());
        System.out.println("Best course of " + arya.getName() + " : " + arya.bestCourse());

        Student jon = students.get("Jon Snow");
        System.out.println("Course failed by " + jon.getName() + " : " + jon.failedCourses());
        System.out.println("Best course of " + jon.getName() + " : " + jon.bestCourse());
        System.out.println("Best score of " + jon.getName() + " : " + jon.bestScore());

        System.out.println(jon.getName() + " average score : " + jon.averageScore());

    }
}
