import java.util.List;

public interface Employee {

    void add(Employee employee);

    void remove(Employee employee);

    List<Employee> getSubordinates();

    String getName();

    String getPosition();

    void printDetails();

    int getTotalEmployees();

    Employee findByName(String name);
}