import java.util.*;
import java.util.stream.Collectors;

class CustomerWithId {
    private int id;
    private String firstName;
    private String lastName;

    public CustomerWithId(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "CustomerWithId{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class Customer {
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<CustomerWithId> customerWithIdList = Arrays.asList(
                new CustomerWithId(1, "Микола", "Скачко"),
                new CustomerWithId(2, "Амир", "Масри"),
                new CustomerWithId(3, "Дмитро", "Карасенко"),
                new CustomerWithId(4, "Дмитро", "Якименко"),
                new CustomerWithId(5, "Даня", "Давыдов")
        );

        Map<Integer, Customer> customerMap = customerWithIdList.stream()
                .collect(Collectors.toMap(
                        CustomerWithId::getId,
                        customer -> new Customer(customer.getFirstName(), customer.getLastName())
                ));

        System.out.println("Значений на карте:");
        customerMap.values().forEach(System.out::println);

        System.out.println("Ключей на карте:");
        customerMap.keySet().forEach(System.out::println);

        System.out.println("Ключей и значений на карте:");
        customerMap.forEach((key, value) -> System.out.println("Ключей: " + key + ", Value: " + value));
    }
}
// я трішки чат джпт використав, але все зрозумів