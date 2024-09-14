import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Singers {
    // Instance variables
    private int singerId;
    private String singerName;
    private String singerAddress;
    private LocalDate dateOfBirth;
    private int numberOfAlbumsPublished;

    // No-argument constructor
    public Singers() {
        this.singerId = 0;
        this.singerName = "Unknown";
        this.singerAddress = "Unknown";
        this.dateOfBirth = null;
        this.numberOfAlbumsPublished = 0;
    }

    // 1-argument constructor
    public Singers(int singerId) {
        this.singerId = singerId;
    }

    // 2-argument constructor
    public Singers(int singerId, String singerName) {
        this.singerId = singerId;
        this.singerName = singerName;
    }

    // 3-argument constructor
    public Singers(int singerId, String singerName, String singerAddress) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
    }

    // 4-argument constructor
    public Singers(int singerId, String singerName, String singerAddress, LocalDate dateOfBirth) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
    }

    // 5-argument constructor
    public Singers(int singerId, String singerName, String singerAddress, LocalDate dateOfBirth, int numberOfAlbumsPublished) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    // GETTERS AND SETTERS

    //SingerID
    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    //SingerName
    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    //SingerAddress
    public String getSingerAddress() {
        return singerAddress;
    }

    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }

    //DateOfBirth
    public LocalDate getDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //NumberOfAlbumsPublished
    public int getNumberOfAlbumsPublished() {
        return numberOfAlbumsPublished;
    }

    public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished) {
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    // Set with all values at once
    public void setSingerAllInfo(int singerId, String singerName, String singerAddress, LocalDate dateOfBirth, int numberOfAlbumsPublished) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    // Method to show Singer Information
    public void displaySingerInfo() {
        System.out.println("Singer ID: " + singerId);
        System.out.println("Singer Name: " + singerName);
        System.out.println("Singer Address: " + singerAddress);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Number of Albums Published: " + numberOfAlbumsPublished);
        System.out.println();
    }
}

