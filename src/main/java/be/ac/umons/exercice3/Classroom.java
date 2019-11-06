package be.ac.umons.exercice3;
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Utilise des fonctions de la classe student (exercice 2) !!!

import be.ac.umons.exercice2.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Classroom {
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student) {
        Objects.requireNonNull(student, "student may not be null");

        if (students.contains(student)) {
            throw new DuplicateStudentException(student.getRegistrationNumber());
        } else {
            students.add(student);
        }

    }

    public double averageScore() {

        double sum = 0;
        int cpt = 0;
        for (Student student : students) {
            for (Map.Entry<String, Integer> courses : student.getScoreByCourse().entrySet()) {
                sum += courses.getValue();
                cpt++;
            }
        }
        return (sum / cpt);
    }

    public double averageScoreStream(){
        //on commence par faire un flux d'étudiants, on crée un autre flux, pour chaque étudiant on récupère une map
        // De cette map, on extrait que les valeurs (les int) ; de ces valeurs, on crée un nouveau stream
        // On transforme les éléments de map en entiers
        // On revient en arrière : le résultat est un entier, à chaque étudiant correspond un entier
        // On a une collection d'entiers, on veut calculer la moyenne
        return students.stream()
                .flatMapToInt(student -> student.getScoreByCourse().values().stream().mapToInt(Integer::intValue))
                .average()
                .orElse(0.0);
    }

    public int countStudents() {
        return students.size();
    }

    public List<Student> topScorers(String course, int n) {

        Map<Student, OptionalInt> scoreByStudent = students.stream()
            .collect(Collectors.toMap(Function.identity(), student -> student.getScore(course)));
        return scoreByStudent.entrySet().stream()
            .filter(entry -> entry.getValue().isPresent())
            .sorted(Map.Entry.comparingByValue((o1, o2) -> -Integer.compare(o1.getAsInt(), o2.getAsInt())))
            .limit(n)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public List<Student> successfulStudents() {

        Set<Student> studentSet = new TreeSet<>(
                Comparator.comparingDouble(student -> -student.averageScore()));

        for (Student s : students) {
            if (s.isSuccessful()) {
                studentSet.add(s);
            }
        }

        List<Student> studentList = new ArrayList<>();
        for (Student s : studentSet)
            studentList.add(s);
        return studentList;

    }

    public List<Student> successfulStudentsStream() {

        return students.stream()
                .filter(Student::isSuccessful)
                .sorted(Comparator.comparingDouble (student -> -student.averageScore())) // signe moins car tri décroissant
                .collect(Collectors.toList());
    }
}
