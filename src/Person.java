public class Person {
    private String lastName;
    private String firstName;
    private String CNP;

    public Person(String lastName, String firstName, String CNP) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
    }

    public String getName() { return lastName; }
    public void setName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getCNP() { return CNP; }
    public void setCNP(String CNP) { this.CNP = CNP; }
}
