import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creating singer1 object using no-argument constructor
        Singers singer1 = new Singers();

        // Display default values of singer1
        System.out.println("\nDefault values of singer1:\n");
        singer1.displaySingerInfo();

        // Setting values using setters
        singer1.setSingerId(101);
        singer1.setSingerName("Shakira Isabel Mebarak Ripoll");
        singer1.setSingerAddress("3140 North Bay Road Drive en Miami Beach, Florida");
        singer1.setDateOfBirth(LocalDate.of(1997, 2, 2));
        singer1.setNumberOfAlbumsPublished(100);

        // Display updated values of singer1
        System.out.println("Updated values of singer1:\n");
        singer1.displaySingerInfo();
    }
}