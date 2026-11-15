import java.util.ArrayList;
/**
 * SpecialistDoctor, e.g. cardiologist, paediatrician, radiologist
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class SpecialistDoctor extends HealthProfessional{
    // Subspecialization of fields
    private String subField;

    /**
     * Parameter-free construction
     */
    public SpecialistDoctor(){
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
     * @param subField
     */
    public SpecialistDoctor(int id, String name, String specialty, ArrayList<String> workingDays, String gender, String title, String subField) {
        super(id, name, specialty, workingDays, gender, title);
        this.subField = subField;
    }

    // Getter & Setter

    // Obtain specialized subfields
    public String getSubField() {
        return subField;
    }

    // Set up specialized subfields
    public void setSubField(String subField) {
        this.subField = subField;
    }

    /**    (non-Javadoc)
     * Implement the abstract method to print the complete information of the specialist doctor.
     * @see HealthProfessional#printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("Specialist Doctor");
        System.out.println(super.toString());
        System.out.println("Sub-specialty field: " + subField);
    }

    @Override
    public String toString() {
        return super.toString() + " | Sub-specialty: " + subField;
    }
}
