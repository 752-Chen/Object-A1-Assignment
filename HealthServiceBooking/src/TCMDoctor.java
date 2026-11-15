import java.util.ArrayList;
/**
 * TCMDoctor(Traditional Chinese Medicine Doctor).
 * Provides treatments such as herbal medicine, acupuncture and tuina.
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class TCMDoctor extends HealthProfessional{
    // Traditional Chinese Medicine Treatment Approach
    private String mainTherapy;

    /**
     * Parameter-free construction
     */
    public TCMDoctor(){
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
     * @param mainTherapy
     */
    public TCMDoctor(int id, String name, String specialty, ArrayList<String> workingDays, String gender, String title, String mainTherapy) {
        super(id, name, specialty, workingDays, gender, title);
        this.mainTherapy = mainTherapy;
    }

    // Getter & Setter

    // Obtain the main treatment method
    public String getMainTherapy() {
        return mainTherapy;
    }

    // Set the main treatment method
    public void setMainTherapy(String mainTherapy) {
        this.mainTherapy = mainTherapy;
    }

    /**    (non-Javadoc)
     * Implement the abstract method and print the complete information of traditional Chinese medicine.
     * @see HealthProfessional#printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("===== TCM Doctor =====");
        System.out.println(super.toString());
        System.out.println("Good at therapy: " + mainTherapy);
    }

    @Override
    public String toString() {
        return super.toString() + " | Main Therapy: " + mainTherapy;
    }
}
