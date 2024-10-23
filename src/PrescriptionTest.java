import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class PrescriptionTest {
    private Prescription prescription;

    @BeforeEach
    void setUp() {
        // Initialize a prescription object before each test
        prescription = new Prescription(1, "John", "Doe", 
                                        "123 Main St, Springfield, 12345, USA", 
                                        1.00f, 0.50f, 90, 
                                        new Date(), "Dr. Smith");
    }

    // Test cases for addPrescription
    @Test
    void testAddValidPrescription() {
        // Valid case
        assertTrue(prescription.addPrescription());
    }

    @Test
    void testAddPrescriptionWithShortFirstName() {
        // Invalid case: Short first name
        prescription = new Prescription(1, "A", "Doe", 
                                        "123 Main St, Springfield, 12345, USA", 
                                        1.00f, 0.50f, 90, 
                                        new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testAddPrescriptionWithLongFirstName() {
        // Invalid case: Long first name
        prescription = new Prescription(1, "JonathanJonathan", "Doe", 
                                        "123 Main St, Springfield, 12345, USA", 
                                        1.00f, 0.50f, 90, 
                                        new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testAddPrescriptionWithShortAddress() {
        // Invalid case: Short address
        prescription = new Prescription(1, "John", "Doe", 
                                        "123", 
                                        1.00f, 0.50f, 90, 
                                        new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testAddPrescriptionWithInvalidSphere() {
        // Invalid case: Invalid sphere value
        prescription = new Prescription(1, "John", "Doe", 
                                        "123 Main St, Springfield, 12345, USA", 
                                        25.00f, 0.50f, 90, 
                                        new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testAddPrescriptionWithValidData() {
        // Another valid case with different data
        prescription = new Prescription(2, "Emily", "Clark", 
                                        "456 Another St, Metropolis, 54321, USA", 
                                        0.00f, -1.00f, 45, 
                                        new Date(), "Dr. Jane");
        assertTrue(prescription.addPrescription());
    }

    // Test cases for addRemark
    @Test
    void testAddValidRemark() {
        assertTrue(prescription.addRemark("Great service from the doctor", "client"));
    }

    @Test
    void testAddRemarkWithShortText() {
        // Invalid case: Short remark text
        assertFalse(prescription.addRemark("Bad", "client"));
    }

    @Test
    void testAddRemarkWithLongText() {
        // Invalid case: Long remark text
        assertFalse(prescription.addRemark("This is a very long remark that exceeds the maximum word limit", "client"));
    }

    @Test
    void testAddRemarkWithInvalidFirstLetter() {
        // Invalid case: First letter not uppercase
        assertFalse(prescription.addRemark("not uppercase start", "client"));
    }

    @Test
    void testAddRemarkWithInvalidType() {
        // Invalid case: Invalid type
        assertFalse(prescription.addRemark("Great service", "doctor"));
    }

    @Test
    void testAddMoreThanTwoRemarks() {
        // Valid case: First two remarks should succeed
        assertTrue(prescription.addRemark("Remark one", "client"));
        assertTrue(prescription.addRemark("Remark two", "optometrist"));

        // Invalid case: Adding a third remark should fail
        assertFalse(prescription.addRemark("Remark three", "client"));
    }

    // Optional: Test for getting remarks
    @Test
    void testGetRemarks() {
        prescription.addRemark("Remark one", "client");
        prescription.addRemark("Remark two", "optometrist");

        assertEquals(2, prescription.getRemarks().size());
        assertTrue(prescription.getRemarks().contains("Remark one"));
        assertTrue(prescription.getRemarks().contains("Remark two"));
    }
}
