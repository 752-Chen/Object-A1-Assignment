import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * AssignmentOne main entry point
 * Script‑based simulation, no scanner menu as per assignment brief requirement
 * @author Ruochen Huang
 * @studentId 25258761
 */
public class AssignmentOne {
    public static void main(String[] args) {
        //Work with HealthProfessional objects
        System.out.println("Health Professional Objects \n");
        ArrayList<String> gpDays = new ArrayList<>();
        gpDays.add("Monday"); 
        gpDays.add("Wednesday");

        ArrayList<String> specDays = new ArrayList<>();
        specDays.add("Tuesday"); 
        specDays.add("Thursday");

        ArrayList<String> nurseDays = new ArrayList<>();
        nurseDays.add("Friday");

        ArrayList<String> dietDays = new ArrayList<>();
        dietDays.add("Monday"); 
        dietDays.add("Thursday");

        ArrayList<String> tcmDays = new ArrayList<>();
        tcmDays.add("Wednesday"); 
        tcmDays.add("Friday");

        // General Practitioner
        GeneralPractitioner gp1 = new GeneralPractitioner(
        1001,
        "Dr. Amy White",
        "General Practice",
        gpDays,
        "Female",
        "Senior GP",
        "Community Health Service"
        );

        // Specialist Doctor
        SpecialistDoctor spec1 = new SpecialistDoctor(
        2001,
        "Dr. Bob Lee",
        "Cardiology",
        new ArrayList<>(List.of("Monday", "Wednesday", "Firday")),
        "Male",
        "Senior Specialist",
        "Heart Failure Clinic"
        );

        // Nurse
        Nurse nurse1 = new Nurse(
        3001,
        "Nurse Sara",
        "Emergency Care",
        new ArrayList<>(List.of("Tuesday", "Thursday", "Saturday")),
        "Female",
        "Registered Nurse",
        "Emergency Ward"
        );

        // Dietitian
        Dietitian diet1 = new Dietitian(
        4001,
        "Ms. Tim Chen",
        "Clinical Nutrition",
        dietDays,
        "Female",
        "Clinical Dietitian",
        "Weight Management"
        );

        // TCM Doctor
        TCMDoctor tcmDoc1 = new TCMDoctor(
        5001,
        "Dr. Lin",
        "Traditional Chinese Medicine",
        tcmDays,
        "Male",
        "Chief TCM Physician",
        "Acupuncture Therapy"
        );

        // Polymorphism: store all sub‑class instances inside ArrayList<HealthProfessional> parent type
        ArrayList<HealthProfessional> allStaffList = new ArrayList<>();
        allStaffList.add(gp1);
        allStaffList.add(spec1);
        allStaffList.add(nurse1);
        allStaffList.add(diet1);
        allStaffList.add(tcmDoc1);

        // Loop and print all staff details (polymorphic printDetails())
        for (HealthProfessional hp : allStaffList) {
            hp.printDetails();
            System.out.println(" ");
        }

        // Appointment System Simulation
        System.out.println("\n\n PART4-PART6 APPOINTMENT SYSTEM DEMO \n");
        // Initialise manager, simulation clock set to "08:10" (current hospital simulated time)
        AppointmentManager manager = new AppointmentManager("08:10");

        // Create sample appointment objects
        Appointment aptPatientA1 = new Appointment("Tom Smith", "0411111111", "09:00", gp1);
        Appointment aptPatientA2 = new Appointment("Tom Smith", "0411111111", "10:30", spec1);
        Appointment aptPatientB1 = new Appointment("Lucy Brown", "0422222222", "09:00", diet1);

        System.out.println("Add valid appointments");
        manager.addAppointment(aptPatientA1);
        manager.addAppointment(aptPatientA2);
        manager.addAppointment(aptPatientB1);

        // Teat for repeated appointment failed
        System.out.println("\n Test error case 1: double-booking same staff same slot");
        Appointment conflictApt = new Appointment("Fake Patient", "0433333333", "09:00", gp1);
        manager.addAppointment(conflictApt);

        // Error occurred during the illegal time period test
        System.out.println("\n Test error case2: invalid time slot (07:00 out of clinic hours)");
        Appointment badSlotApt = new Appointment("Fake Patient2", "0444444444", "07:00", nurse1);
        manager.addAppointment(badSlotApt);

        // The patient checks their appointment
        System.out.println("\n [Patient Tom mobile:0411111111] View ONLY his OWN appointments");
        manager.printPatientOwnAppointmentView("0411111111");
        
        // Administrator views all reservations
        System.out.println("\n Admin view: print ALL appointments in whole system");
        manager.printAllAppointmentsAdminView();

        // Arrange appointments by time period.
        System.out.println("\n Sort all appointments by time-slot");
        manager.sortAllAppointmentsByTime();
        manager.printAllAppointmentsAdminView();

        // Required demo: filter by staff ID and sort subset
        System.out.println("\n[DEMO] Filter appointments for specialist doctor (ID:2001), then sort this subset");
        ArrayList<Appointment> doctorAppts = manager.filterByHealthProfessionalId(2001);
        manager.sortAppointmentSubset(doctorAppts);
        System.out.println("Appointments belong to this specialist after sorting:");
        for(Appointment apt : doctorAppts){
            apt.printAppointment();
        }

        // Cancel the appointment normally
        System.out.println("\n Test normal cancel: patient Tom cancel one appointment (time not passed yet)");
        manager.cancelByPatientMobile("0411111111");

        System.out.println("\n After cancel, Tom view his own appointments");
        manager.printPatientOwnAppointmentView("0411111111");

        // Simulate time passes: clock jumps to "11:00", appointment "10:30" time is already past
        System.out.println("\n Simulate time passes, simulation clock becomes 11:00");
        manager.setSimulationCurrentTime("11:00");
        System.out.println("Try to cancel Tom remaining appointment (slot is 10:45 which is earlier than now 11:00):");
        manager.cancelByPatientMobile("0411111111");

        // Cancel the non-existent reservation
        System.out.println("\n Test cancel non-existent appointment");
        manager.cancelByPatientMobile("9999999999");

        System.out.println("\n ALL DEMONSTRATION FINISHED ");
        System.out.println("\n Now entering patient interactive booking menu");

        // Interactive console menu
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("\n PATIENT BOOKING MENU ");
            System.out.println("1. View all medical staff (departments)");
            System.out.println("2. Create new appointment");
            System.out.println("3. Check my appointments (enter mobile number)");
            System.out.println("4. Cancel my appointment (enter mobile number)");
            System.out.println("5. Exit system");
            System.out.print("Please enter your choice(1-5): ");

            int menuChoice = -1;
            try {
                String rawInput = scanner.nextLine().trim();
                menuChoice = Integer.parseInt(rawInput);
            } catch (Exception e) {
                System.out.println("Invalid input, please input number 1-5");
                continue;
            }

            switch (menuChoice){
                case 1:
                    // View All Medical Departments
                    System.out.println("\n--- All available medical staff ---");
                    for(HealthProfessional hp : allStaffList){
                        hp.printDetails();
                    }
                    break;

                case 2:{
                    // Create Appointment
                    System.out.print("Enter patient name: ");
                    String pName = scanner.nextLine();

                    System.out.print("Enter staff ID you want to book: ");
                    int selectStaffId = -1;
                    // Exception occurred: Invalid input for capture ID, which is not a number.
                    try{
                        String idStr = scanner.nextLine().trim();
                        selectStaffId = Integer.parseInt(idStr);
                    }catch (Exception e){
                        System.out.println("ID must be number, create appointment failed.");
                        break;
                    }

                    // Search for medical staff based on the ID.
                    HealthProfessional selectedHp = null;
                    for(HealthProfessional hp : allStaffList){
                        if(hp.getId() == selectStaffId){
                            selectedHp = hp;
                            break;
                        }
                    }
                    if(selectedHp == null){
                        System.out.println("Cannot find this staff ID!");
                        break;
                    }

                    System.out.print("Enter booking time slot(e.g 09:30): ");
                    String timeSlot = scanner.nextLine();

                    System.out.print("Enter your mobile phone number: ");
                    String mobile = scanner.nextLine();

                    // Check mobile length: exactiy 10 digits
                    if(mobile.length()!= 10 || !mobile.matches("[0-9]+")){
                        System.out.println("[WARNING] Invalid mobile number! It must be exactly to digits.");
                        continue;
                    }
                    Appointment newApt = new Appointment(pName,mobile,timeSlot,selectedHp);
                    boolean ok = manager.addAppointment(newApt);
                    if(ok){
                        System.out.println(" Appointment saved successfully!");
                    }
                    break;
                }

                case 3: {
                    // Enter your mobile phone number to view your reservations
                    System.out.print("Please input your mobile number to look up: ");
                    String mobile = scanner.nextLine();
                    manager.printPatientOwnAppointmentView(mobile);
                    if (mobile.length() != 10 || !mobile.matches("[0-9]{10}")){
                        System.out.println("[WARNING] Invalid mobile number! It must be exactly 10 digits.");
                        continue;
                    }
                    break;
                }

                case 4: {
                    // Cancel the reservation based on the mobile phone number
                    System.out.print("Input your mobile number for cancel appointment: ");
                    String mobile = scanner.nextLine();
                    boolean cancelOk = manager.cancelByPatientMobile(mobile);
                    if (mobile.length() != 10 || !mobile.matches("[0-9]+")){
                        System.out.println("[WARNING] Invalid mobile number! It must be exactly 10 digits");
                        continue;
                    }
                    if(cancelOk){
                        System.out.println("Cancel operation finished.");
                    }
                    break;
                }

                case 5:
                    running = false;
                    System.out.println("System exit. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose number between 1-5");
            }
        }
        scanner.close();
    }
}
