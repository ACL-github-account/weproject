package weproject.ui;

import java.awt.*;
import java.rmi.activation.ActivationGroupDesc;

import weproject.ui.*;
import static weproject.ui.uiMain.myFrame;
import weproject.*;
import weproject.commands.*;

public class carsData {
    public static Panel mainPanel = (Panel) new Panel(new GridBagLayout());
    public static GridBagConstraints mainPanelConstraint = new GridBagConstraints();
    public static void carsData(int actionID,int attributeIndex, String attributeValue) throws IndexOutOfBoundsException{
        //Main Pannel
        mainPanel.setBackground(Color.BLACK);
        mainPanelConstraint.weightx = 1;
        mainPanelConstraint.weighty = 1;
        mainPanelConstraint.gridy = 0;
        mainPanelConstraint.anchor = GridBagConstraints.ABOVE_BASELINE;
        mainPanelConstraint.fill = GridBagConstraints.BOTH;


        Panel mainPanelContent = new Panel(new GridBagLayout());
        GridBagConstraints contentConstraint = new GridBagConstraints();
        contentConstraint.gridy = 1;
        contentConstraint.weighty = 1;
        contentConstraint.weightx = 1;
        contentConstraint.fill = GridBagConstraints.BOTH;

        Panel attributePanel = new Panel(new GridLayout(1, CarClass.attributelist.values().length));
        attributePanel.setSize(new Dimension(0,100));
        GridBagConstraints attributePanelConstraints = new GridBagConstraints();
        attributePanelConstraints.weighty = 1;
        attributePanelConstraints.weightx = 1;
        int i = 0;
        for (CarClass.attributelist x : CarClass.attributelist.values()) {
            attributePanelConstraints.gridx = i;
            TextField newLabel = new TextField(CarClass.attributelist.values()[i].toString());
            newLabel.setBackground(Color.lightGray);
            attributePanel.add(newLabel, attributePanelConstraints);
            i++;
        }
        attributePanelConstraints.fill = GridBagConstraints.BOTH;
        mainPanelContent.add(attributePanel, attributePanelConstraints);
        i = 2;
        int _ROW_COUNT = myFrame.getHeight()/40;

        //for (CarClass x : Main.cars) {
        for(int ii=0 ; ii<_ROW_COUNT; ii++){
            attributePanelConstraints.gridy = i;
            Panel newPanel = new Panel(new GridLayout(1, CarClass.attributelist.values().length));

            CarClass x;
            if (Main.cars.size()>ii){
                x = Main.cars.get(ii);

                if (actionID == 1){
                    boolean skipPanel = false;
                    switch(attributeIndex){
                        case 0:
                            if(String.valueOf(x.carID).indexOf(attributeValue) == -1){
                                skipPanel = true;
                            }
                            break;
                        case 1:
                            if(x.brand.indexOf(attributeValue) == -1) {
                                skipPanel = true;
                            }
                            break;
                        case 2:
                            if(String.valueOf(x.enginesize).indexOf(attributeValue) == -1) {
                                skipPanel = true;
                            }
                            break;
                        case 3:
                            if(x.model.indexOf(attributeValue) == -1) {
                                skipPanel = true;
                            }
                            break;
                        case 4:
                            if(x.colour.indexOf(attributeValue) == -1) {
                                skipPanel = true;
                            }
                            break;
                        case 5:
                            if(String.valueOf(x.year).indexOf(attributeValue) == -1) {
                                skipPanel = true;
                            }
                            break;
                        case 6:
                            if(String.valueOf(x.price).indexOf(attributeValue) == -1) {
                                skipPanel = true;
                            }
                            break;
                        default:
                            break;
                    }
                    if (skipPanel == true){
                        continue;
                    }
                }

                int f = 0;
                for (CarClass.attributelist y : CarClass.attributelist.values()) {
                    attributePanelConstraints.gridx = f;
                    switch (y) {
                        case brand:
                            newPanel.add(new TextField(x.brand), attributePanelConstraints);
                            break;
                        case carID:
                            newPanel.add(new TextField(String.valueOf(x.carID)), attributePanelConstraints);
                            break;
                        case colour:
                            newPanel.add(new TextField(x.colour), attributePanelConstraints);
                            break;
                        case enginesize:
                            newPanel.add(new TextField(x.enginesize), attributePanelConstraints);
                            break;
                        case model:
                            newPanel.add(new TextField(x.model), attributePanelConstraints);
                            break;
                        case price:
                            newPanel.add(new TextField(String.valueOf(x.price)), attributePanelConstraints);
                            break;
                        case year:
                            newPanel.add(new TextField(String.valueOf(x.year)), attributePanelConstraints);
                            break;
                        default:
                            newPanel.add(new TextField(), attributePanelConstraints);
                            break;
                    }
                    f++;
                }
            }
            else {
                for (CarClass.attributelist y : CarClass.attributelist.values()) {
                    newPanel.add(new TextField(" "), attributePanelConstraints);
                }
            }
            mainPanelContent.add(newPanel, attributePanelConstraints);
            i++;
        }
        mainPanel.add(mainPanelContent, contentConstraint);
        myFrame.add(mainPanel, mainPanelConstraint);
    }
}
