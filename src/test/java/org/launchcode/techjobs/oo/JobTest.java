package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() throws ClassNotFoundException {
        Job job1 = new Job();
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1.getId(),job2.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields() throws ClassNotFoundException {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() throws ClassNotFoundException {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () throws ClassNotFoundException {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char first = job.toString().charAt(0);
        char last = job.toString().charAt(job.toString().length()-1);
        assertEquals(first, '\n' );
        assertEquals(last, '\n' );
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () throws ClassNotFoundException {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String line = "\n";
        String returnString = line;
        returnString += "ID: " + job.getId() + line;
        returnString += "Name: " + "Product tester" + line;
        returnString += "Employer: " + "ACME" + line;
        returnString += "Location: " + "Desert" + line;
        returnString += "Position Type: " + "Quality control" + line;
        returnString += "Core Competency: " + "Persistence" + line;
//        returnString += line;

        assertEquals(job.toString(), returnString );
    }

    @Test
    public void testToStringHandlesEmptyField () throws ClassNotFoundException {
        Job job = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String line = "\n";
        String returnString = line;
        returnString += "ID: " + job.getId() + line;
        returnString += "Name: " + "Product tester" + line;
        returnString += "Employer: " + "Data not available" + line;
        returnString += "Location: " + "Data not available" + line;
        returnString += "Position Type: " + "Data not available" + line;
        returnString += "Core Competency: " + "Data not available" + line;
//        returnString += line;

        assertEquals(job.toString(), returnString );
    }
}
