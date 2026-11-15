import java.util.ArrayList;

/**
 * Nurse, subclass of HealthProfessional
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class Nurse extends HealthProfessional{
    // The affiliated ward department
    private String ward;

    /**
     * Parameter-free construction
     */
    public Nurse(){
        super();
    }

    /**
     * Parameteried construction
     * @param id
     * @param name
     * @param specialty
     * @param workingDays
     * @param gender
     * @param title
     * @param ward
     */
    public Nurse(int id, String name, String specialty, ArrayList<String> workingDays, String gender, String title, String ward) {
        super(id, name, specialty, workingDays, gender, title);
        this.ward = ward;
    }

    // Getter & Setter

    // Obtain the assigned ward
    public String getWard() {
        return ward;
    }

    // Set the assigned ward
    public void setWard(String ward) {
        this.ward = ward;
    }

    /**    (non-Javadoc)
     * Implement the abstract method to print the complete information of the nurse
     * @see HealthProfessional#printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("Nurse");
        System.out.println(super.toString());
        System.out.println("Assigned ward: " + ward);
    }

    @Override
    public String toString() {
        return super.toString() + " | Ward: " + ward;
    }
}
