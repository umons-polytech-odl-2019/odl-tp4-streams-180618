package be.ac.umons.exercice3;

import be.ac.umons.exercice2.Student;

import java.util.List;

/**
 * Exercice 3 : Collections and Streams (Classroom).
 *
 * @author Adriano Guttadauria
 * @author Olivier Debauche
 */
public class Exercice3 {

    public static void fillClassroom(Classroom classroom) {
        Student hodor = new Student("Hodor", "001003");
        hodor.setScore("hunting", 12);
        hodor.setScore("figthing", 14);
        hodor.setScore("running", 10);
        classroom.addStudent(hodor);
        Student osha = new Student("Osha", "001005");
        osha.setScore("fighting", 14);
        osha.setScore("cooking", 4);
        osha.setScore("swimming", 4);
        classroom.addStudent(osha);
        Student branStark = new Student("Bran Stark", "001006");
        branStark.setScore("running", 0);
        branStark.setScore("archery", 14);
        classroom.addStudent(branStark);
        Student gregorClegane = new Student("Gregor Clegane", "001008");
        gregorClegane.setScore("fighting", 18);
        gregorClegane.setScore("running", 10);
        gregorClegane.setScore("hunting", 16);
        classroom.addStudent(gregorClegane);
        Student myrcellaBaratheon = new Student("Myrcella Baratheon", "001011");
        myrcellaBaratheon.setScore("cooking", 14);
        myrcellaBaratheon.setScore("swimming", 16);
        myrcellaBaratheon.setScore("archery", 8);
        classroom.addStudent(myrcellaBaratheon);
        Student maesterAemon = new Student("Maester Aemon", "001019");
        maesterAemon.setScore("running", 2);
        maesterAemon.setScore("cooking", 16);
        maesterAemon.setScore("hunting", 17);
        classroom.addStudent(maesterAemon);
        Student yaraGreyjoy = new Student("Yara Greyjoy", "001028");
        yaraGreyjoy.setScore("swimming", 18);
        yaraGreyjoy.setScore("fighting", 19);
        yaraGreyjoy.setScore("hunting", 16);
        classroom.addStudent(yaraGreyjoy);
        Student thorosOfMyr = new Student("Thoros of Myr", "001037");
        thorosOfMyr.setScore("fighting", 15);
        thorosOfMyr.setScore("archery", 10);
        thorosOfMyr.setScore("cooking", 19);
        classroom.addStudent(thorosOfMyr);
    }

    public static void main(String[] args) {
        System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┣ Collections and Streams (Classroom) ┫" );
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        Classroom classroom = new Classroom();
        fillClassroom(classroom);

        System.out.println("Average of the classroom : " + classroom.averageScore());

        List<Student> topScorersInFighting = classroom.topScorers("fighting", 3);
        System.out.println("Best students in fighting :");
        for (Student winners : topScorersInFighting)
            System.out.println(winners);

        System.out.println("Best students : " + classroom.successfulStudents());
    }
}
