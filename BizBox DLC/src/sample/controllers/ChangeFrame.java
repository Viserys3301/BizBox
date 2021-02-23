package sample.controllers;



public class ChangeFrame {
    String frameName;
    public String changeFrame(int frameId){
            switch (frameId){
                //////////////////////////////////////////////////////////////////////////////////////////
                case 1 :return frameName ="/sample/fxmlFiles/ZeroingAmbulatory.fxml";
                case 2 :return frameName ="/sample/fxmlFiles/ChangePayment.fxml";
                case 3 :return frameName ="/sample/fxmlFiles/ChangeDoctor.fxml\"";
                case 4 :return frameName ="/sample/fxmlFiles/ChangeAmbulatoryDate.fxml";
                case 5 :return frameName ="/sample/fxmlFiles/ChangeBirthdate.fxml";
                case 6 :return frameName ="/sample/fxmlFiles/EnabledUltrasound.fxml";
                case 7 :return frameName ="/sample/fxmlFiles/RecoveryUltrasound.fxml";
                //////////////////////////////////////////////////////////////////////////////////////
                case 8 :return frameName ="/sample/fxmlFiles/AddCorpClient.fxml";
                case 9 :return frameName ="/sample/fxmlFiles/ZeroingCorpClient.fxml";
                ///////////////////////////////////////////////////////////////////////////////////////
                case 10 :return frameName ="/sample/fxmlFiles/DeletAmbulatory.fxml";
                case 11 :return frameName ="/sample/fxmlFiles/DeleteDiscount.fxml";
                case 12 :return frameName ="/sample/fxmlFiles/DeletPayment.fxml";
                case 13 :return frameName ="/sample/fxmlFiles/RecordReturn.fxml";
                //////////////////////////////////////////////////////////////////////////////////////////
                case 14 :return frameName ="/sample/fxmlFiles/Account.fxml";
                case 15 :return frameName ="/sample/fxmlFiles/CheckLogs.fxml";
                case 16 :return frameName ="/sample/fxmlFiles/Users.fxml";
                case 17 :return frameName ="/sample/fxmlFiles/Rebook.fxml";
                case 18 :return frameName ="/sample/fxmlFiles/About.fxml";
            }

            return frameName;


    }
}


