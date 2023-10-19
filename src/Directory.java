import java.util.*;
import java.util.stream.Collectors;

/*
    Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
    Добавить метод, который ищет сотрудника по стажу (может быть список)
    Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    Добавить метод, который ищет сотрудника по табельному номеру
    Добавить метод добавление нового сотрудника в справочник
 */

/**
 * The `Directory` class represents an employee directory with a collection of employees.
 * <p>
 * This class allows you to manage a directory of employees,
 * which is stored in a map using their personnel numbers as keys.
 * The class provides methods for adding new employees to the directory and searching for employees
 * based on various criteria such as years of experience, name, or personnel number.
 */
public class Directory {
    private final Map<Integer, Employee> employeeMap;

    /**
     * Constructs a new employee directory.
     */
    public Directory() {
        this.employeeMap = new HashMap<>();
    }

    /**
     * Adds a new employee to the directory.
     *
     * @param employee The employee to be added.
     */
    public void addEmployee(Employee employee) {
        if (!employeeMap.containsValue(employee)) {
            employeeMap.put(employee.getPersonnelNumber(), employee);
        } else {
            System.out.println("Add Employee with number " + employee.getPersonnelNumber()
                    + " rejected, " + employee.getName() + " already exist!");
        }
    }

    /**
     * Filters employees by years of experience within a specified range.
     *
     * @param from The minimum years of experience to filter by.
     * @param to   The maximum years of experience to filter by.
     * @return A list of employees matching the years of experience criteria.
     */
    public List<Employee> filterByYearsExperience(int from, int to) {
        return employeeMap.values().stream()
                .filter(e -> (e.getYearsExperience() >= from && e.getYearsExperience() <= to))
                .sorted(Comparator.comparingInt(Employee::getYearsExperience))
                .collect(Collectors.toList());
    }

    /**
     * Filters employees by a specific number of years of experience.
     *
     * @param number The number of years of experience to filter by.
     * @return A list of employees matching the years of experience criteria.
     */
    public List<Employee> filterByYearsExperience(int number) {
        return employeeMap.values().stream()
                .filter(e -> e.getYearsExperience() == number)
                .sorted(Comparator.comparingInt(Employee::getYearsExperience))
                .collect(Collectors.toList());
    }

    /**
     * Filters employees by name.
     *
     * @param eName The name to filter employees by.
     * @return A list of employees matching the name criteria.
     */
    public List<Employee> filterByName(String eName) {
        return employeeMap.values().stream()
                .filter(e -> e.getName().equals(eName))
                .collect(Collectors.toList());
    }

    /**
     * Finds an employee by their personnel number.
     *
     * @param number The personnel number of the employee to find.
     * @return The employee with the specified personnel number, or null if not found.
     */
    public Employee findByPersonnelNumber(Integer number) {
        for (Integer id : employeeMap.keySet()) {
            if (id.equals(number)) {
                return employeeMap.get(id);
            }
        }
        return null;
    }

    /**
     * Returns a string representation of the directory.
     *
     * @return A string representation of the directory's employees.
     */
    @Override
    public String toString() {
        return employeeMap.values().toString();
    }
}
