import java.util.Collections;
import java.util.List;

public class IndividualEmployee implements Employee {

    private final String name;
    private final String position;

    public IndividualEmployee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void add(Employee employee) {
        throw new UnsupportedOperationException("Individual employee cannot have subordinates");
    }

    @Override
    public void remove(Employee employee) {
        throw new UnsupportedOperationException("Individual employee cannot have subordinates");
    }

    @Override
    public List<Employee> getSubordinates() {
        return Collections.emptyList();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void printDetails() {
        System.out.println("Employee: " + name + " (" + position + ")");
    }

    @Override
    public int getTotalEmployees() {
        return 1;
    }

    @Override
    public Employee findByName(String name) {
        return this.name.equalsIgnoreCase(name) ? this : null;
    }
}