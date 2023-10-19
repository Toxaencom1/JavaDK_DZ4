/*
    Создать справочник сотрудников
    Необходимо:
    Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников -
    каждый сотрудник должен иметь следующие атрибуты:
    Табельный номер
    Номер телефона
    Имя
    Стаж
    Добавить метод, который ищет сотрудника по стажу (может быть список)
    Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    Добавить метод, который ищет сотрудника по табельному номеру
    Добавить метод добавление нового сотрудника в справочник
 */

/**
 * The `Main` class represents a program that demonstrates the use of the employee directory.
 * The program creates an employee directory, adds employees to it, and performs various operations on the directory.
 */
public class Main {
    public static void main(String[] args) {
        Directory directory = getDirectory();
        System.out.println("Start program=================Directory=======================================");
        System.out.println(directory);
        System.out.println("Filter by Experience======='>=7<=20'==========================================");
        System.out.println(directory.filterByYearsExperience(7, 20));
        System.out.println("Filter by Experience==========5===============================================");
        System.out.println(directory.filterByYearsExperience(5));
        System.out.println("Filter by name========\"Anton\"=================================================");
        System.out.println(directory.filterByName("Anton"));
        System.out.print("Filter by number============3=================================================");
        System.out.println(directory.findByPersonnelNumber(3));
        System.out.print("Filter by number============15================================================");
        Employee toFind = directory.findByPersonnelNumber(15);
        System.out.print(toFind != null ? toFind : "\nEmployee not founded");
        System.out.println();
    }

    /**
     * Creates an instance of the `Directory` class and populates it with sample employees.
     *
     * @return The populated `Directory` instance.
     */
    private static Directory getDirectory() {
        Employee e1 = new Employee(7071561900L, "Anton", 10);
        Employee e2 = new Employee(7071571900L, "Tatiana", 5);
        Employee e3 = new Employee(7071561900L, "Kirill", 5);
        Employee e4 = new Employee(7017654903L, "Yuriy", 20);
        Employee e5 = new Employee(7771363665L, "Ira", 19);
        // next for equals check
        Employee e6 = new Employee(7071561900L, "Anton", 10);
        // next for same-name check
        Employee e7 = new Employee(7071571900L, "Anton", 7);
        Directory directory = new Directory();
        directory.addEmployee(e1);
        directory.addEmployee(e2);
        directory.addEmployee(e3);
        directory.addEmployee(e4);
        directory.addEmployee(e5);
        directory.addEmployee(e6);
        directory.addEmployee(e7);
        return directory;
    }
}
