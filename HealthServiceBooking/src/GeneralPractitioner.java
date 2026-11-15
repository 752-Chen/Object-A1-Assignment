import java.util.ArrayList;

/**
 * GeneralPractitioner, the primary care doctor for patients.
 * They handle common illnesses and make referrals to specialists.
 * @author Ruochen Huang
 * @studentId 25258761
 */

public class GeneralPractitioner extends HealthProfessional{
    // Set the professional title
    private String serviceArea;

    /**
     * Parameter-free construction
     */
    public GeneralPractitioner(){
        super();
    }

    /**
     * Parameterized construction
     * @param id
     * @param name
     * @param specialty
     * @param workingDays
     * @param gender
     * @param title
     * @param serviceArea
     */
    public GeneralPractitioner(int id, String name, String specialty, ArrayList<String> workingDays, String gender, String title, String serviceArea) {
        super(id, name, specialty, workingDays, gender, title);
        this.serviceArea = serviceArea;
    }

    //Obtain the service area of a general practitioner
    public String getServiceArea(){
        return serviceArea;
    }

    // Set up service areas for general practitioners
    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    /**    (non-Javadoc)
     * Implement the abstract method to print the complete information of the general practitioner.
     * @see HealthProfessional#printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("General Practitioner");
        System.out.println(super.toString());
        System.out.println("Service Community: " + serviceArea);
    }

    @Override 
    public String toString() {
        return super.toString() + " | Service Area: " + serviceArea;
    }
}
