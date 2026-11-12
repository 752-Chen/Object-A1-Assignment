import java.util.ArrayList;
/**
 * Astract class representing a health professional
 * @author Ruochen Huang
 * @studentId 25258761
 * HealthProfessional
 */
public abstract class HealthProfessional {
    // Unique identification number of the health professional
    private int id;
    // Full name of the health professional
    private String name;
    // Specialty or medical field of the health professional
    private String specialty;
    // A list storing the working days of this professional
    private ArrayList<String> workingDays;

    public HealthProfessional(){
    }

    public HealthProfessional(int id, String name, String specialty){
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Getter & Setter
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSpecialty(){
        return specialty;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    public ArrayList<String> getWorkingDats(){
        return workingDays;
    }

    public void setWorkingDays(ArrayList<String> workingDays){
        this.workingDays = workingDays;
    }

    public abstract void printDetails();

    @Override 
    public String toString(){
        return "ID: " + id
                + " | Name: " + name
                + " | Specialty: " + specialty
                + " | Working days: " + workingDays;
    }
}
