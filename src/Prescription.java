import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Prescription {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private int daysSupply;
    private Date dateIssued;
    private String doctor;
    private List<String> remarks;

    // Constructor
    public Prescription(int id, String firstName, String lastName, String address,
                        float sphere, float cylinder, int daysSupply,
                        Date dateIssued, String doctor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.daysSupply = daysSupply;
        this.dateIssued = dateIssued;
        this.doctor = doctor;
        this.remarks = new ArrayList<>();
    }

    // Method to add a prescription
    public boolean addPrescription() {
        // Validate first name length
        if (firstName.length() < 3 || firstName.length() > 15 || 
            address.length() < 10 || 
            sphere < -20.00f || sphere > 20.00f || 
            cylinder < -10.00f || cylinder > 10.00f || 
            daysSupply <= 0) {
            return false; // Return false if any condition fails
        }
        return true; // Return true if all conditions are met
    }

    // Method to add remarks
    public boolean addRemark(String text, String type) {
        if (remarks.size() >= 2) {
            return false; // Limit to 2 remarks
        }
        if (text.length() < 5 || text.length() > 50) {
            return false; // Check remark length
        }
        if (!Character.isUpperCase(text.charAt(0))) {
            return false; // First letter must be uppercase
        }
        if (!type.equals("client") && !type.equals("optometrist")) {
            return false; // Invalid type
        }
        remarks.add(text); // Add remark if all checks pass
        return true;
    }

    // Method to get remarks
    public List<String> getRemarks() {
        return remarks;
    }
}
