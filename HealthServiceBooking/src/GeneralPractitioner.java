import java.util.ArrayList;

/**
 * GeneralPractitioner, the primary care doctor for patients.
 * They handle common illnesses and make referrals to specialists.
 * @author Ruochen Huang
 * @studentId 25258761
 */

public class GeneralPractitioner extends HealthProfessional{
    private String serviceArea;

    public GeneralPractitioner(){
        super();
    }

    public GeneralPractitioner(int id, String name, String specialty, ArrayList<String> workingDays, String serviceArea) {
        super(id, name, specialty, workingDays);
        this.serviceArea = serviceArea;
    }

    public String getServiceArea(){
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

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
