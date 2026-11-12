import java.util.ArrayList;

/**
 * Nurse, subclass of HealthProfessional
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class Nurse extends HealthProfessional{
    private String ward;

    public Nurse(){
        super();
    }

    public Nurse(int id, String name, String specialty, ArrayList<String> workingDays, String ward) {
        super(id, name, specialty, workingDays);
        this.ward = ward;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

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
