package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for PatientHistogram.
 */
public class PatientHistogramTest
{
    @Test
    public void addPatientToRegion_validIndex_true(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertTrue(patientHistogram.addAPatientToRegion(15,5));
    }
    @Test
    public void addPatientToRegion_invalidVIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.addAPatientToRegion(20,1));
    }
    @Test
    public void addPatientToRegion_invalidHIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.addAPatientToRegion(1,10));
    }
    @Test
    public void deleteAPatientFromRegion_invalidDecrement_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.deleteAPatientFromRegion(15,5));
    }
    @Test
    public void deleteAPatientFromRegion_validDecrement_true(){
        PatientHistogram patientHistogram = new PatientHistogram();
        patientHistogram.addAPatientToRegion(15,5); // 1 patient in region
        assertTrue(patientHistogram.deleteAPatientFromRegion(15,5));
    }
    @Test
    public void deleteAPatientFromRegion_invalidVIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.deleteAPatientFromRegion(20,1));
    }
    @Test
    public void deleteAPatientFromRegion_invalidHIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.deleteAPatientFromRegion(1,10));
    }
    @Test
    public void getPatientsCountInRegion_invalidVIndex_throws(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            patientHistogram.getPatientsCountInRegion(20,1);
        });
    }
    @Test
    public void getPatientsCountInRegion_invalidHIndex_throws(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            patientHistogram.getPatientsCountInRegion(1,10);
        });
    }

}
