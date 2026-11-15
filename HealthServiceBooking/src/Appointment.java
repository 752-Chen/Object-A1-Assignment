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
     * Compare two reservations and sort them in ascending order by time period for grouping.
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot.compareTo(other.timeSlot);
    }

    @Override
    public String toString() {
        return "Patient:" + patientName 
                + " | Mobile:" + patientMobile 
                + " | Time:" + timeSlot
                + " | StaffID:" + assignedProfessional.getId();
    }
}
