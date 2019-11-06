package be.ac.umons.exercice3;

/**
 * Indicates that you're trying to store a Student with the same registration number.
 */
public class DuplicateStudentException extends RuntimeException {
    private final String registrationNumber;

    /**
     * @param registrationNumber the registration number that is duplicated.
     */
    public DuplicateStudentException(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}