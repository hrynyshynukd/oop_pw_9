import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department implements Employee {

    private final String name;
    private final String position;
    private final List<Employee> subordinates = new ArrayList<>();

    public Department(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void add(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        boolean exists = subordinates.stream()
                .anyMatch(e -> Objects.equals(e.getName(), employee.getName()));

        if (exists) {
            throw new IllegalArgumentException("Employee with this name already exists in department");
        }

        subordinates.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>(subordinates);
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
        printDetails(0);
    }

    private void printDetails(int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "Department: " + name + " (" + position + ")");

        for (Employee e : subordinates) {
            if (e instanceof Department dept) {
                dept.printDetails(level + 1);
            } else {
                System.out.println(indent + "  Employee: " + e.getName() + " (" + e.getPosition() + ")");
            }
        }
    }

    @Override
    public int getTotalEmployees() {
        int total = 0;
        for (Employee e : subordinates) {
            total += e.getTotalEmployees();
        }
        return total;
    }

    @Override
    public Employee findByName(String name) {
        if (this.name.equalsIgnoreCase(name)) {
            return this;
        }

        for (Employee e : subordinates) {
            Employee found = e.findByName(name);
            if (found != null) {
                return found;
            }
        }

        return null;
    }
}