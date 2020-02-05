package org.launchcode.techjobs_oo.Tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static int testCount = 0;

    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;

    @Before
    public void init() {
        Job.resetIdCounter();
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job3 = new Job();
        job4 = new Job("Web Developer", new Employer(""),new Location("Kansas City"), new PositionType(""), new CoreCompetency(""));
        job5 = new Job("", new Employer("TestCorp"),new Location(""), new PositionType("Data"), new CoreCompetency("SQL"));
    }

    @BeforeClass
    public static void setup() {
        System.out.println("Unit tests starting:");
    }

    @After
    public void message() {
        System.out.println("Test " + ++testCount + " complete.");
    }

    @AfterClass
    public static void closing() {
        System.out.println("Total of " + testCount + " tests complete.");
    }

    @Test
    public void testSettingJobId() {assertTrue(job1.getId() == job2.getId()-1);}

    @Test
    public void testJobConstructorSetsAllFields() {assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getName(),"Product tester");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(), "Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testToStringStartAndEnd() {
        assertTrue(job1.toString().startsWith("\n"));
        assertTrue(job1.toString().endsWith("\n"));
    }

    @Test
    public void testToStringFieldNames() {
        assertTrue(job1.toString().contains("ID: 1\nName: Product tester\nEmployer: ACME\n" +
                "Location: Desert\nPosition Type: Quality control\nCore Competency: " +
                "Persistence\n"));
    }

//    @Test
//    public void testToStringOnlyJobID() {
//        System.out.println(job3.getId() + " " + job3.getEmployer());
//        System.out.println(job3.getEmployer().isNotEmpty(job3.getEmployer().getValue()));
//        System.out.println(job3.toString());
//        assertTrue(job3.toString().contains("OOPS! This job does not seem to exist."));
//    }

    @Test
    public void testToStringWithSomeEmptyStrings() {
        assertTrue(job4.toString().contains("ID: 4\nName: Web Developer\nEmployer: Data not available.\n" +
                "Location: Kansas City\nPosition Type: Data not available.\nCore Competency: Data not available.\n"));
        assertTrue(job5.toString().contains("ID: 5\nName: Data not available.\nEmployer: TestCorp\n" +
                "Location: Data not available.\nPosition Type: Data\nCore Competency: SQL\n"));
    }


}
