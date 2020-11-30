package weproject.ui;

import java.awt.*;
import java.rmi.activation.ActivationGroupDesc;

import weproject.ui.*;
import static weproject.ui.uiMain.myFrame;
import weproject.*;
import weproject.commands.*;

public class carsData {
    public static void carsData() {
        //Main Pannel
        Panel mainPanel = (Panel) new Panel(new GridBagLayout());
        GridBagConstraints mainPanelConstraint = new GridBagConstraints();
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
        GridBagConstraints attributePanelConstraints = new GridBagConstraints();
        attributePanelConstraints.weighty = 1;
        attributePanelConstraints.weightx = 1;
        int i = 0;
        for (CarClass.attributelist x : CarClass.attributelist.values()) {
            attributePanelConstraints.gridx = i;
            Label newLabel = new Label(CarClass.attributelist.values()[i].toString());
            newLabel.setBackground(Color.lightGray);
            attributePanel.add(newLabel, attributePanelConstraints);
            i++;
        }
        attributePanelConstraints.fill = GridBagConstraints.BOTH;
        mainPanelContent.add(attributePanel, attributePanelConstraints);
        i = 2;


        for (CarClass x : Main.cars) {
            attributePanelConstraints.gridy = i;
            Panel newPanel = new Panel(new GridLayout(1, CarClass.attributelist.values().length));
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
                        break;
                }
                f++;
            }
            mainPanelContent.add(newPanel, attributePanelConstraints);
            i++;
        }
        mainPanel.add(mainPanelContent, contentConstraint);
        myFrame.add(mainPanel, mainPanelConstraint);
    }
}
