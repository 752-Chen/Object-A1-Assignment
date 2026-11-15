import java.util.ArrayList;
/**
 * Dietitian, gives personalised diet and nutrition advice for patients.
 * Patients can book consultation for chronic disease or weight management.
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class Dietitian extends HealthProfessional{
    // Nutrition research direction
    private String nutritionFocus;

    /**
     * Parameter-free construction
     */
    public Dietitian(){
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
     * @param nutritionFocus
     */
    public Dietitian(int id, String name, String specialty, ArrayList<String> workingDays, String gender, String title, String nutritionFocus) {
        super(id, name, specialty, workingDays, gender, title);
        this.nutritionFocus = nutritionFocus;
    }

    // Getter & Setter

    // Obtain a major in nutrition direction
    public String getNutritionFocus() {
        return nutritionFocus;
    }

    // Set a major in nutrition direction
    public void setNutritionFocus(String nutritionFocus) {
        this.nutritionFocus = nutritionFocus;
    }

    /**    (non-Javadoc)
     * Implement the abstract method to print the complete information of the nutritionist
     * @see HealthProfessional#printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("===== Dietitian =====");
        System.out.println(super.toString());
        System.out.println("Nutrition Focus: " + nutritionFocus);
    }

    @Override
    public String toString() {
        return super.toString() + " | Nutrition Focus: " + nutritionFocus;
    }
}
