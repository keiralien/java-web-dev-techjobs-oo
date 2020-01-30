package org.launchcode.techjobs_oo.Tests;

import org.junit.*;
import org.launchcode.techjobs_oo.Job;

import static org.junit.Assert.assertTrue;

public class JobTest {

    private static int testCount = 0;
    Job job1;
    Job job2;

    @Before
    public void init() {
        job1 = new Job();
        job2 = new Job();
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
}
