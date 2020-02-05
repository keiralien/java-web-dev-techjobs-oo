package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //Constructors
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

//Methods
    public static void resetIdCounter() {
        nextId = 1;
    }

    private boolean isNotEmpty(String stringIn) {
        return stringIn != null && !stringIn.isEmpty();
    }

    private boolean isAnyNotEmpty(String ... stringInput) {
        for(String s : stringInput) {
            if(isNotEmpty(s))
                return true;
        }
        return false;
    }

    private String defaultString(String stringIn, String defaultString) {
        return isNotEmpty(stringIn) ? stringIn : defaultString;
    }

    //Override Methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

     String dataNot = "Data not available";
        if(id != 0 && isAnyNotEmpty(name,
                employer == null ? null : employer.getValue(),
                location == null ? null : location.getValue(),
                positionType == null ? null : positionType.getValue(),
                positionType == null ? null : coreCompetency.getValue())) {
            return String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n",
                    id,
                    defaultString(name, dataNot),
                    employer == null ? dataNot : defaultString(employer.getValue(), dataNot),
                    location == null ? dataNot : defaultString(location.getValue(), dataNot),
                    positionType == null ? dataNot : defaultString(positionType.getValue(), dataNot),
                    coreCompetency == null ? dataNot : defaultString(coreCompetency.getValue(), dataNot));
        } else {
            return "OOPS! This job does not seem to exist.";
        }
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

}
