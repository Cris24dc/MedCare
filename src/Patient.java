public class Patient extends Person {
    private String diagnosis;
    private String treatment;

    public Patient(String lastName, String firstName, String CNP) {
        super(lastName, firstName, CNP);
    }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }
}
