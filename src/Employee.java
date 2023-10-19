import java.util.Objects;

/*
    Каждый сотрудник должен иметь следующие атрибуты:
    Табельный номер
    Номер телефона
    Имя
    Стаж
 */

/**
 * The `Employee` class represents an employee with the following attributes:
 * - Personnel number
 * - Telephone number
 * - Name
 * - Years of experience
 * <p>
 * This class allows you to create and manage employee information,
 * including their personnel number, telephone number, name, and years of experience.
 */
public class Employee {
    private static int id;
    private static final long TEL_DEFAULT_LENGTH = 8_000_000_00_00L;
    private final int personnelNumber;
    private long telNumber;  // У нас номера телефона такой длины и формата "8 ___ ___ __ __"
    private String name;
    private int yearsExperience;

    /**
     * Constructs a new Employee with the specified attributes.
     *
     * @param telNumber       The telephone number of the employee.
     * @param name            The name of the employee.
     * @param yearsExperience The years of experience of the employee.
     */
    public Employee(long telNumber, String name, int yearsExperience) {
        this.personnelNumber = ++id;
        this.telNumber = telNumber + TEL_DEFAULT_LENGTH;
        this.name = name;
        this.yearsExperience = yearsExperience;
    }

    /**
     * Gets the personnel number of the employee.
     *
     * @return The personnel number.
     */
    public int getPersonnelNumber() {
        return personnelNumber;
    }

    /**
     * Gets the telephone number of the employee.
     *
     * @return The telephone number.
     */
    public long getTelNumber() {
        return telNumber;
    }

    /**
     * Sets the telephone number of the employee.
     *
     * @param telNumber The new telephone number to set.
     */
    public void setTelNumber(long telNumber) {
        this.telNumber = telNumber;
    }

    /**
     * Gets the name of the employee.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the years of experience of the employee.
     *
     * @return The years of experience.
     */
    public int getYearsExperience() {
        return yearsExperience;
    }

    /**
     * Sets the years of experience of the employee.
     *
     * @param yearsExperience The new years of experience to set.
     */
    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    /**
     * Compares this employee to another object for equality.
     *
     * @param o The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return telNumber == employee.telNumber &&
                yearsExperience == employee.yearsExperience &&
                Objects.equals(name, employee.name);
    }

    /**
     * Computes the hash code for this employee.
     *
     * @return The computed hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(telNumber, name, yearsExperience);
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return A formatted string containing the personnel number, name, telephone number, and years of experience of the employee.
     */
    @Override
    public String toString() {
        return String.format("\n  №%-2d name: %-15s | Telephone:%12d | Years experience: %2d  ",
                personnelNumber, name, telNumber, yearsExperience);
    }
}
