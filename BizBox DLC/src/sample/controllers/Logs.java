package sample.controllers;

public class Logs {
    private String regIdListId;
    private String DataListId;
    private String TranID_FK_TRXNOListId;
    private String TranID_PK_psPatledgersListId;
    private String DateListId;

    @Override
    public String toString() {
        return "Logs{" +
                "regIdListId='" + regIdListId + '\'' +
                ", DataListId='" + DataListId + '\'' +
                ", TranID_FK_TRXNOListId='" + TranID_FK_TRXNOListId + '\'' +
                ", TranID_PK_psPatledgersListId='" + TranID_PK_psPatledgersListId + '\'' +
                ", DateListId='" + DateListId + '\'' +
                '}';
    }

    public Logs(String regIdListId, String dataListId, String tranID_FK_TRXNOListId, String tranID_PK_psPatledgersListId, String dateListId) {
        this.regIdListId = regIdListId;
        DataListId = dataListId;
        TranID_FK_TRXNOListId = tranID_FK_TRXNOListId;
        TranID_PK_psPatledgersListId = tranID_PK_psPatledgersListId;
        DateListId = dateListId;
    }

    public String getRegIdListId() {
        return regIdListId;
    }

    public void setRegIdListId(String regIdListId) {
        this.regIdListId = regIdListId;
    }

    public String getDataListId() {
        return DataListId;
    }

    public void setDataListId(String dataListId) {
        DataListId = dataListId;
    }

    public String getTranID_FK_TRXNOListId() {
        return TranID_FK_TRXNOListId;
    }

    public void setTranID_FK_TRXNOListId(String tranID_FK_TRXNOListId) {
        TranID_FK_TRXNOListId = tranID_FK_TRXNOListId;
    }

    public String getTranID_PK_psPatledgersListId() {
        return TranID_PK_psPatledgersListId;
    }

    public void setTranID_PK_psPatledgersListId(String tranID_PK_psPatledgersListId) {
        TranID_PK_psPatledgersListId = tranID_PK_psPatledgersListId;
    }

    public String getDateListId() {
        return DateListId;
    }

    public void setDateListId(String dateListId) {
        DateListId = dateListId;
    }
}
