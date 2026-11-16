import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * AppointmentManager manages collection of day‑only appointments
 * Contains business rules: double‑booking prevention, patient private view, cancel‑before‑time rule
 * Clinic valid slots: 08:00-16:00 every 30 minutes
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class AppointmentManager {
    // The system stores the entire collection of reservations
    private final ArrayList<Appointment> allAppointments;
    // The current time of the simulation system, used to detemine whether to allow the cancellation of the appointment
    private String simulationCurrentTime;
    private static final ArrayList<String> VALID_SLOTS = new ArrayList<>(
        List.of("08:00", "08:30", "09:00", "09:30",
                "10:00", "10:30", "11:00", "11:30",
                "12:00", "12:30", "13:00", "13:30",
                "14:00", "14:30", "15:00", "15:30",
                "16:00")
);

    /**
     * Construct the manager object
     * @param simulationCurrentTime
     */
    public AppointmentManager(String simulationCurrentTime) {
        allAppointments = new ArrayList<>();
        this.simulationCurrentTime = simulationCurrentTime;
    }

    /**
     * Check if time slot is valid clinic slot (08:00-16:00, 30‑min interval)
     * @param slot time string "HH:mm"
     * @return true if valid
     */
    public boolean isValidTimeSlot(String slot) { 
        return VALID_SLOTS.contains(slot);
    }

    /**
     * Check: does this health professional already have booking in this time slot (double‑booking check)
     */
    private boolean isStaffBookedAtSlot(HealthProfessional hp, String targetSlot) {
        for (Appointment apt : allAppointments) {
            if (apt.getAssignedProfessional().equals(hp) && apt.getTimeSlot().equals(targetSlot)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a time slot is available for a given staff
     * @param staffId
     * @param slot
     * @return
     */
    public boolean isSlotAvailable(int staffId, String slot) {
        for (Appointment apt : allAppointments) {
            if (apt.getAssignedProfessional().getId() == staffId && apt.getTimeSlot().equals(slot)) {
                return false;
            }
        }
        return true;
    }

    // Check if target booking time has not passed yet
    private boolean isSlotNotPast(String slot){
        return isTimeBefore(simulationCurrentTime, slot);
    }
    /**
     * Add new appointment, validate slot + no double‑booking
     * @param newApt appointment instance
     * @return true=add ok; false=rejected
     */
    public boolean addAppointment(Appointment newApt) {
        if (!isValidTimeSlot(newApt.getTimeSlot())) {
            System.out.println("[WARNING] Add failed: invalid clinic time slot " + newApt.getTimeSlot());
            return false;
        }
        // Prevent booking a time slot that has already passed
        if (!isSlotNotPast(newApt.getTimeSlot())) {
            System.out.println("[WARNING] Add failed: cannot book a time slot that has already passed.");
        return false;
        }
        HealthProfessional hp = newApt.getAssignedProfessional();
        String slot = newApt.getTimeSlot();
        if (isStaffBookedAtSlot(hp, slot)) {
            System.out.println("[WARNING] Add failed: this staff (ID: " + hp.getId() + ") already booked at " + slot + " (double-booking)");
            return false;
        }
        allAppointments.add(newApt);
        System.out.println("[INFO] New appointment added successfully.");
        return true;
    }

    /**
     * Filter appointments by health professional ID
     * @param hpId target staff id
     * @return list of matching appointments
     */
    public ArrayList<Appointment> filterByHealthProfessionalId(int hpId) {
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment apt : allAppointments) {
            if (apt.getAssignedProfessional().getId() == hpId) {
                result.add(apt);
            }
        }
        return result;
    }

    /**
     * Filter appointments BY PATIENT MOBILE: patient can ONLY see their own appointments
     * @param patientMobile patient phone number
     * @return patient‑private appointment list
     */
    public ArrayList<Appointment> filterPatientOwnAppointments(String patientMobile) {
        ArrayList<Appointment> patientOwn = new ArrayList<>();
        for (Appointment apt : allAppointments) {
            if (apt.getPatientMobile().equals(patientMobile)) {
                patientOwn.add(apt);
            }
        }
        return patientOwn;
    }

    /**
     * Sort full appointment list by time slot (earliest first)
     */
    public void sortAllAppointmentsByTime() {
        Collections.sort(allAppointments);
    }

    /**
     * Sort a filtered subset of appointments
     * @param subset list to sort
     */
    public void sortAppointmentSubset(ArrayList<Appointment> subset) {
        Collections.sort(subset);
    }

    /**
     * Helper: compare time strings, return true if current simulation time is BEFORE appointment slot
     */
    private boolean isTimeBefore(String now, String appointmentSlot) {
        return now.compareTo(appointmentSlot) < 0;
    }

    /**
     * Cancel option‑1: cancel by healthProfessionalId + timeSlot
     * Rule: CAN ONLY cancel when simulationCurrentTime is BEFORE appointment time
     * @param hpId staff id
     * @param slot target time slot
     * @return true=cancel success
     */
    public boolean cancelByStaffAndTime(int hpId, String slot) {
        for (int i = 0; i < allAppointments.size(); i++) {
            Appointment apt = allAppointments.get(i);
            if (apt.getAssignedProfessional().getId() == hpId && apt.getTimeSlot().equals(slot)) {
                if (!isTimeBefore(simulationCurrentTime, apt.getTimeSlot())) {
                    System.out.println("[WARNING] Cancel reject: cannot cancel after appointment time has passed.");
                    return false;
                }
                allAppointments.remove(i);
                System.out.println("[INFO] Appointment cancelled (staff‑id + timeslot).");
                return true;
            }
        }
        System.out.println("[WARNING] Cancel failed: cannot find matching appointment.");
        return false;
    }

    /**
     * Cancel option‑2: cancel by patient mobile phone
     * Rule: can only cancel BEFORE appointment time
     * @param patientMobile patient phone
     * @return true if one appointment removed
     */
    public boolean cancelByPatientMobile(String patientMobile) {
        for (int i = 0; i < allAppointments.size(); i++) {
            Appointment apt = allAppointments.get(i);
            if (apt.getPatientMobile().equals(patientMobile)) {
                if (!isTimeBefore(simulationCurrentTime, apt.getTimeSlot())) {
                    System.out.println("[WARNING] Cancel reject: cannot cancel after appointment time slot.");
                    return false;
                }
                allAppointments.remove(i);
                System.out.println("[INFO] Appointment cancelled (patient mobile).");
                return true;
            }
        }
        System.out.println("[WARNING] Cancel failed: no appointment found for this patient mobile.");
        return false;
    }

    /**
     * Print ALL appointments (for admin demonstration only, not for patient view)
     */
    public void printAllAppointmentsAdminView() {
        if (allAppointments.isEmpty()) {
            System.out.println("No appointments stored in system.");
            return;
        }
        for (Appointment apt : allAppointments) {
            apt.printAppointment();
        }
    }

    /**
     * Print only patient‑owned appointments (patient self‑service view)
     * @param patientMobile patient phone
     */
    public void printPatientOwnAppointmentView(String patientMobile) {
        ArrayList<Appointment> patientList = filterPatientOwnAppointments(patientMobile);
        if (patientList.isEmpty()) {
            System.out.println("No appointments found for this patient mobile number.");
            return;
        }
        System.out.println("\n===== YOUR PERSONAL APPOINTMENTS (Only you can view these) =====");
        for (Appointment apt : patientList) {
            apt.printAppointment();
        }
    }

    // Update simulated wall‑clock time for simulation testing
    public void setSimulationCurrentTime(String newSimTime) {
        this.simulationCurrentTime = newSimTime;
    }
}
