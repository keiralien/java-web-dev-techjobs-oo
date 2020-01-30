package org.launchcode.techjobs_oo.Tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobTest {

    private static int testCount = 0;
    Job job1;
    Job job2;

    @Before
    public void init() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));    }

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
        assertTrue(job1.getName().equals("Product tester"));
        assertTrue(job1.getEmployer().getValue().equals("ACME"));
        assertTrue(job1.getLocation().getValue().equals("Desert"));
        assertTrue(job1.getPositionType().getValue().equals("Quality control"));
        assertTrue(job1.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }
}
