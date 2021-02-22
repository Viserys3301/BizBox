package sample.controllers;

public class Rebooks {
    private String PatNameColumnId;
    private String DateCreatePatientColumnId;
    private String DateRebookColumnId;
    private String NewDatePatientColumnId;
    private String computerNameColumnId;

    public Rebooks(String patNameColumnId, String dateCreatePatientColumnId, String dateRebookColumnId, String newDatePatientColumnId, String computerNameColumnId) {
        PatNameColumnId = patNameColumnId;
        DateCreatePatientColumnId = dateCreatePatientColumnId;
        DateRebookColumnId = dateRebookColumnId;
        NewDatePatientColumnId = newDatePatientColumnId;
        this.computerNameColumnId = computerNameColumnId;
    }

    public String getPatNameColumnId() {
        return PatNameColumnId;
    }

    public void setPatNameColumnId(String patNameColumnId) {
        PatNameColumnId = patNameColumnId;
    }

    public String getDateCreatePatientColumnId() {
        return DateCreatePatientColumnId;
    }

    public void setDateCreatePatientColumnId(String dateCreatePatientColumnId) {
        DateCreatePatientColumnId = dateCreatePatientColumnId;
    }

    public String getDateRebookColumnId() {
        return DateRebookColumnId;
    }

    public void setDateRebookColumnId(String dateRebookColumnId) {
        DateRebookColumnId = dateRebookColumnId;
    }

    public String getNewDatePatientColumnId() {
        return NewDatePatientColumnId;
    }

    public void setNewDatePatientColumnId(String newDatePatientColumnId) {
        NewDatePatientColumnId = newDatePatientColumnId;
    }

    public String getComputerNameColumnId() {
        return computerNameColumnId;
    }

    public void setComputerNameColumnId(String computerNameColumnId) {
        this.computerNameColumnId = computerNameColumnId;
    }
}
