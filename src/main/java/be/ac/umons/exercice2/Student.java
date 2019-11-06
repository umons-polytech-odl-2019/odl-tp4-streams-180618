package be.ac.umons.exercice2;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class Student {

    private final String name;
    private final String registrationNumber;
    private Map<String, Integer> scoreByCourse = new HashMap<>();

    public Student(String name, String registrationNumber) {
        this.name = requireNonNull(name, "name may not be null");
        this.registrationNumber = requireNonNull(registrationNumber, "registration number may not be null");
    }

    public void setScore(String course, int score) {
        requireNonNull(course, "course may not be null");
        if (score < 0 || score > 20)
            throw new IllegalArgumentException("score must be between 0 and 20");
        scoreByCourse.put(course, score);
    }

    public OptionalInt getScore(String course) {
        Integer nullableScore = scoreByCourse.get(course);
        return nullableScore != null ? OptionalInt.of(nullableScore) : OptionalInt.empty();
    }

    public double averageScore() {

        int count = 0;
        double totalScore = 0.0;
        for (Integer score : scoreByCourse.values()) {
            count++;
            totalScore += score;
        }
        return totalScore / count;
    }

    public String bestCourse() {

        String bestCourse = "";
        Integer bestScore = 0;

        for (Map.Entry<String, Integer> e : scoreByCourse.entrySet()) {
            if (e.getValue() > bestScore) {
                bestCourse = e.getKey();
                bestScore = e.getValue();
            }
        }

        return bestCourse;
    }

    public int bestScore() {

        int bestScore = 0;
        for (Map.Entry<String, Integer> entry : scoreByCourse.entrySet()) {
            if (entry.getValue() > bestScore)
                bestScore = entry.getValue();
        }
        return bestScore;

    }

    public Set<String> failedCourses() {

        List<Map.Entry<String, Integer>> filteredEntries = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scoreByCourse.entrySet()) {
            if (entry.getValue() < 12) {
                filteredEntries.add(entry);
            }
        }
        Collections.sort(filteredEntries, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        LinkedHashSet<String> failedCourses = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : filteredEntries) {
            failedCourses.add(entry.getKey());
        }
        return failedCourses;
    }

    public boolean isSuccessful() {
        return averageScore() >= 12 && failedCourses().size() < 3;
    }

    public Set<String> attendedCourses() {

        Set<String> courses = new LinkedHashSet<String>();
        for (String courseName : scoreByCourse.keySet())
            courses.add(courseName);
        return courses;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Map<String, Integer> getScoreByCourse() {
        return scoreByCourse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getName());
        sb.append(" (").append(getRegistrationNumber()).append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(registrationNumber, student.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
