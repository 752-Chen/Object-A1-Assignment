import java.util.ArrayList;
/**
 * Dietitian, gives personalised diet and nutrition advice for patients.
 * Patients can book consultation for chronic disease or weight management.
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class Dietitian extends HealthProfessional{
    private String nutritionFocus;

    public Dietitian(){
        super();
    }

    public Dietitian(int id, String name, String specialty, ArrayList<String> workingDays, String nutritionFocus) {
        super(id, name, specialty, workingDays);
        this.nutritionFocus = nutritionFocus;
    }

    public String getNutritionFocus() {
        return nutritionFocus;
    }

    public void setNutritionFocus(String nutritionFocus) {
        this.nutritionFocus = nutritionFocus;
    }

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
