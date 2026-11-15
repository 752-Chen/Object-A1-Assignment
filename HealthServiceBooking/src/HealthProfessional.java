import java.util.ArrayList;
/**
 * Abstract class representing a health professional
 * It defines common attributes and abstract methods for all medical staff.
 * @author Ruochen Huang
 * @studentId 25258761
 */
public abstract class HealthProfessional {
    // The unique identification number of the medical staff
    private int id;
    // Name of medical staff
    private String name;
    // Gender
    private String gender;
    // Title and Rank
    private String title;
    // Weekiy workday assembly
    private ArrayList<String> workingDays;

    public HealthProfessional(){
        workingDays = new ArrayList<>();
    }

    /**
     * Parameterized construction,initializing all public attributes of medical staff
     * @param id
     * @param name
     * @param gender
     * @param title
     * @param workingDays
     */
    public HealthProfessional(int id, String name, String specialty, ArrayList<String> workingDays, String gender, String title){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.title = title;
        this.workingDays = workingDays;
    }

    // Getter & Setter

    // Obtain the medical staff identification number
    public int getId(){
        return id;
    }

    // Set the medical staff number
    public void setId(int id){
        this.id = id;
    }

    // Obtain the names of the medical staff
    public String getName(){
        return name;
    }

    // Set the names of the medical staff
    public void setName(String name){
        this.name = name;
    }

    // Obtain available appointment dates
    public ArrayList<String> getWorkingDays(){
        return workingDays;
    }

    // Set Available Visit Dates
    public void setWorkingDays(ArrayList<String> workingDays){
        this.workingDays = workingDays;
    }

    // Obtain the gender of the medical staff
    public String getGender(){
        return gender;
    }

    // Set the gender of medical staff
    public void setGender(String gender){
        this.gender = gender;
    }

    // Obtain the professional title
    public String getTitle(){
        return title;
    }

    // Set the professional title
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Abstract method for printing details. All subclasses must implement it and output their complete information
     */
    public abstract void printDetails();

    /**    (non-Javadoc)
     * Two health professionals are equal if they share the same ID
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HealthProfessional other = (HealthProfessional) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override 
    public String toString(){
        return "ID: " + id
                + " | Name: " + name
                + " | Title: " + title
                + " | Gender: " + gender
                + " | WorkingDays: " + workingDays;
    }
}
