public class Main {
    public static void main(String[] args) {

        // Створення співробітників
        Employee dev1 = new IndividualEmployee("Ivan", "Developer");
        Employee dev2 = new IndividualEmployee("Maria", "Developer");
        Employee hr1 = new IndividualEmployee("Olha", "HR");

        // Відділи
        Department devDept = new Department("Development", "Department");
        Department hrDept = new Department("HR", "Department");
        Department company = new Department("Company", "Organization");

        // Формуємо структуру
        devDept.add(dev1);
        devDept.add(dev2);

        hrDept.add(hr1);

        company.add(devDept);
        company.add(hrDept);

        // Вивід структури
        System.out.println("=== Company Structure ===");
        company.printDetails();

        // Підрахунок
        System.out.println("\nTotal employees: " + company.getTotalEmployees());

        // Пошук
        System.out.println("\nSearching for Maria...");
        Employee found = company.findByName("Maria");

        if (found != null) {
            found.printDetails();
        } else {
            System.out.println("Not found");
        }
    }
}