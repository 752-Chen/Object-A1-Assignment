/**
 * Appointment: stores single booking record for current‑day booking
 * Implements Comparable for sorting appointments by time slot
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class Appointment implements Comparable<Appointment>{
    // Patient's name
    private final String patientName;
    // Patient's contact mobile phone number
    private final String patientMobile;
    // Appointment time slot, example format: 09:00
    private final String timeSlot;
    // The specific medical staff corresponding to this appointment 
    private final HealthProfessional assignedProfessional;

    /**
     * Constructor method, creating a complete appointment object
     * @param patientName
     * @param patientMobile
     * @param timeSlot
     * @param assignedProfessional
     */
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional assignedProfessional) {
        if (patientName == null || patientName.isBlank()){
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if(patientMobile == null || patientMobile.isBlank()){
            throw new IllegalArgumentException("Mobile number cannot be empty.");
        }
        if(timeSlot == null || timeSlot.isBlank()){
            throw new IllegalArgumentException("Time slot cannot be empty.");
        }
        if(assignedProfessional == null){
            throw new IllegalArgumentException("Health professional cannot be null.");
        }
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.assignedProfessional = assignedProfessional;
    }

    // Getter 

    // Obtain the patient's name
    public String getPatientName() { 
        return patientName; 
    }

    // Obtain the patient's mobile phone number
    public String getPatientMobile() { 
        return patientMobile; 
    }

    // Obtain the appointment time slot
    public String getTimeSlot() { 
        return timeSlot; 
    }

    // Obtain the medical staff corresponding to this appointment
    public HealthProfessional getAssignedProfessional() { 
        return assignedProfessional; 
    }

    /**
     * Print full appointment details
     */
    public void printAppointment() {
        System.out.println("Appointment Record");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Booking Time Slot: " + timeSlot);
        System.out.println("Attending staff info:");
        assignedProfessional.printDetails();
    }

    /**    (non-Javadoc)
     * Compare appointments by time slot for sorting
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot.compareTo(other.timeSlot);
    }

    /**    (non-Javadoc)
     * Output FULL health professional details
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==== Appointment Record ====\n");
        sb.append("Patient Name: ").append(patientName).append("\n");
        sb.append("Patient Mobile: ").append(patientMobile).append("\n");
        sb.append("Booking Time Slot: ").append(timeSlot).append("\n");
        sb.append("Attending staff info:\n");
        sb.append("ID: ").append(assignedProfessional.getId()).append("\n");
        sb.append("Name: ").append(assignedProfessional.getName()).append("\n");
        sb.append("Title: ").append(assignedProfessional.getTitle()).append("\n");
        sb.append("Gender: ").append(assignedProfessional.getGender()).append("\n");
        return sb.toString();
    }
}
