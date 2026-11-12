import java.util.ArrayList;
/**
 * TCMDoctor(Traditional Chinese Medicine Doctor).
 * Provides treatments such as herbal medicine, acupuncture and tuina.
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class TCMDoctor extends HealthProfessional{
    private String mainTherapy;

    public TCMDoctor(){
        super();
    }

    public TCMDoctor(int id, String name, String specialty, ArrayList<String> workingDays, String mainTherapy) {
        super(id, name, specialty, workingDays);
        this.mainTherapy = mainTherapy;
    }

    public String getMainTherapy() {
        return mainTherapy;
    }

    public void setMainTherapy(String mainTherapy) {
        this.mainTherapy = mainTherapy;
    }

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
