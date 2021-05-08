package sample.controllers;



public class ChangeFrame {
    String frameName;
    public String changeFrame(int frameId){
            switch (frameId){
                //////////////////////////////////////////////////////////////////////////////////////////
                case 1 : frameName ="/sample/fxmlFiles/ZeroingAmbulatory.fxml";break;
                case 2 : frameName ="/sample/fxmlFiles/ChangePayment.fxml";break;
                case 3 : frameName ="/sample/fxmlFiles/ChangeDoctor.fxml";break;
                case 4 : frameName ="/sample/fxmlFiles/ChangeAmbulatoryDate.fxml";break;
                case 5 : frameName ="/sample/fxmlFiles/ChangeBirthdate.fxml";break;
                case 6 : frameName ="/sample/fxmlFiles/EnabledUltrasound.fxml";break;
                case 7 : frameName ="/sample/fxmlFiles/RecoveryUltrasound.fxml";break;
                //////////////////////////////////////////////////////////////////////////////////////
                case 8 : frameName ="/sample/fxmlFiles/AddCorpClient.fxml";break;
                case 9 : frameName ="/sample/fxmlFiles/ZeroingCorpClient.fxml";break;
                ///////////////////////////////////////////////////////////////////////////////////////
                case 10 : frameName ="/sample/fxmlFiles/DeletAmbulatory.fxml";break;
                case 11 : frameName ="/sample/fxmlFiles/DeleteDiscount.fxml";break;
                case 12 : frameName ="/sample/fxmlFiles/DeletPayment.fxml";break;
                case 13 : frameName ="/sample/fxmlFiles/RecordReturn.fxml";break;
                //////////////////////////////////////////////////////////////////////////////////////////
                case 14 : frameName ="/sample/fxmlFiles/Account.fxml";break;
                case 15 : frameName ="/sample/fxmlFiles/CheckLogs.fxml";break;
                case 16 : frameName ="/sample/fxmlFiles/Users.fxml";break;
                case 17 : frameName ="/sample/fxmlFiles/Rebook.fxml";break;
                case 18 : frameName ="/sample/fxmlFiles/About.fxml";break;
                case 19 : frameName ="/sample/fxmlFiles/Exception.fxml";break;
            }
            return frameName;
    }
}


