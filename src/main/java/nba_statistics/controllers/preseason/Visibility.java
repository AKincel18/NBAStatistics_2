package nba_statistics.controllers.preseason;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Visibility {

    public void setVisibleD(Text d10, Text d11, Text d12, Text d13, ComboBox<String> t10, TextField t12, TextField t13){
        d10.setVisible(true);d11.setVisible(true);d12.setVisible(true);d13.setVisible(true);
        t10.setVisible(true);t12.setVisible(true);t13.setVisible(true);

    }
    public void setInvisibleD(Text d10, Text d11, Text d12, Text d13, ComboBox<String> t10, TextField t12, TextField t13, ComboBox<String> DivE, ComboBox<String> DivW ){
        d10.setVisible(false);d11.setVisible(false);d12.setVisible(false);d13.setVisible(false);
        t10.setVisible(false);DivE.setVisible(false);DivW.setVisible(false);t12.setVisible(false);t13.setVisible(false);
    }

    public void setVisibleM(Text m10, Text m11, Text m12, Text tSeason,Text tSeason0, TextField t20, TextField t21, TextField t22){
        m10.setVisible(true);m11.setVisible(true);m12.setVisible(true); tSeason.setVisible(true);
        t20.setVisible(true);t21.setVisible(true);t22.setVisible(true); tSeason0.setVisible(true);

    }
    public void setInvisibleM(Text m10, Text m11, Text m12, Text tSeason,Text tSeason0, TextField t20, TextField t21, TextField t22){
        m10.setVisible(false);m11.setVisible(false);m12.setVisible(false); tSeason.setVisible(false);
        t20.setVisible(false);t21.setVisible(false);t22.setVisible(false); tSeason0.setVisible(false);
    }

    public void setInvisibleS(Text s10, Text s11, Text s12, Text s13, TextField t30, TextField t31, TextField t32, Button addedSeasonBtn ){
        s10.setVisible(false);s11.setVisible(false);s12.setVisible(false); s13.setVisible(false);
        t30.setVisible(false);t31.setVisible(false);t32.setVisible(false);
        addedSeasonBtn.setVisible(false);
    }

    public void setInvisibleP(Text p40,Text p41,Text p42,Text p43,Text p44,Text p45, TextField t40, TextField t41, TextField t42,TextField t43, TextField t44, TextField t45){
        p40.setVisible(false);p41.setVisible(false);p42.setVisible(false);p43.setVisible(false);p44.setVisible(false);p45.setVisible(false);
        t40.setVisible(false);t41.setVisible(false);t42.setVisible(false);t43.setVisible(false);t44.setVisible(false);t45.setVisible(false);
    }
    public void setVisibleNewPlayerT(Text p40,Text p41,Text p42,Text p43,Text p44,Text p45, TextField t40, TextField t41, TextField t42,TextField t43, TextField t44, TextField t45){
        p40.setVisible(true);p41.setVisible(true);p42.setVisible(true);p43.setVisible(true);p44.setVisible(true);p45.setVisible(true);
        t40.setVisible(true);t41.setVisible(true);t42.setVisible(true);t43.setVisible(true);t44.setVisible(true);t45.setVisible(true);
    }

    public void setVisibleTransferT(Text p40,Text p41,Text p42, TextField t40, TextField t41, TextField t42){
        p40.setVisible(true);p41.setVisible(true);p42.setVisible(true);
        t40.setVisible(true);t41.setVisible(true);t42.setVisible(true);
    }

    public void setVisibleCheckBox(CheckBox newPlayerCheckBox, CheckBox transferCheckBox){
        newPlayerCheckBox.setVisible(true);
        transferCheckBox.setVisible(true);
    }
    public void setInvisibleCheckBox(CheckBox newPlayerCheckBox, CheckBox transferCheckBox){
        newPlayerCheckBox.setVisible(false);transferCheckBox.setVisible(false);
    }

    public void clearTextFieldD(TextField t12, TextField t13){
        t12.clear();t13.clear();
    }

    public void clearTextFieldM(TextField t20, TextField t21, TextField t22){
        t20.clear(); t21.clear();t22.clear();
    }

    public void clearTextFieldNewPlayer(TextField t40, TextField t41, TextField t42,TextField t43, TextField t44, TextField t45){
        t40.clear(); t41.clear();t42.clear();t43.clear();t44.clear();t45.clear();
    }

    public void clearTextFieldTransfer(TextField t40, TextField t41, TextField t42){
        t40.clear(); t41.clear();t42.clear();
    }


}