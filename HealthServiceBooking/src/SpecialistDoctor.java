import java.util.ArrayList;
/**
 * SpecialistDoctor, e.g. cardiologist, paediatrician, radiologist
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class SpecialistDoctor extends HealthProfessional{
    private String subField;

    public SpecialistDoctor(){
        super();
    }

    public SpecialistDoctor(int id, String name, String specialty, ArrayList<String> workingDays, String subField) {
        super(id, name, specialty, workingDays);
        this.subField = subField;
    }

    // Getter & Setter
    public String getSubField() {
        return subField;
    }

    public void setSubField(String subField) {
        this.subField = subField;
    }

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
