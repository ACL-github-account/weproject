package weproject.ui;

import java.awt.*;
import java.rmi.activation.ActivationGroupDesc;

import weproject.ui.*;
import static weproject.ui.uiMain.myFrame;
import weproject.*;
import weproject.commands.*;
import java.util.ArrayList;

public class carsTable {
    public static Panel mainPanel = (Panel) new Panel(new GridBagLayout());
    public static GridBagConstraints mainPanelConstraint = new GridBagConstraints();
    public static ArrayList tablePanelList = new ArrayList<Panel>();
    //if set to false dont load data from the cars array to the fields upon execution of carsTable.
    public static boolean _LOAD_TO_FIELD = true;


    private static Panel mainPanelContent;
    private static GridBagConstraints contentConstraint;
    private static Panel attributePanel;
    private static GridBagConstraints attributePanelConstraints;
    private static Panel newPanel;

    public static void initializeCarsData(){
        mainPanelContent = new Panel(new GridBagLayout());
        attributePanel = new Panel(new GridLayout(1, CarClass.attributelist.values().length));
        attributePanelConstraints = new GridBagConstraints();
        newPanel = new Panel(new GridLayout(1, CarClass.attributelist.values().length));


        //attributePanel.setSize(new Dimension(0,100));
        attributePanelConstraints.weighty = 1;
        attributePanelConstraints.weightx = 1;
        int i = 0;
        for (CarClass.attributelist x : CarClass.attributelist.values()) {
            attributePanelConstraints.gridx = i;
            TextField newLabel = new TextField(CarClass.attributelist.values()[i].toString());
            newLabel.setEditable(false);
            newLabel.setBackground(Color.lightGray);
            attributePanel.add(newLabel, attributePanelConstraints);
            i++;
        }
        attributePanelConstraints.fill = GridBagConstraints.BOTH;
        attributePanel.setName("CONTENT");
        mainPanelContent.add(attributePanel, attributePanelConstraints);
    }
    public static void carsData(int actionID,int attributeIndex, String attributeValue) throws IndexOutOfBoundsException{
        //Main Pannel
        contentConstraint = new GridBagConstraints();
        contentConstraint.gridy = 1;
        contentConstraint.weighty = 1;
        contentConstraint.weightx = 1;
        contentConstraint.fill = GridBagConstraints.BOTH;

        //remove all panels from the mainPanelContent to prevent duplicate panels upon resize
        int _CONTENT_COUNT = 0;
        for(Component x : mainPanelContent.getComponents()){
            if(x.getName().equals("CONTENT") == false){
                mainPanelContent.remove(x);
            } else  if(x instanceof Panel && x.getName().equals("CONTENT")){
                _CONTENT_COUNT++;
            }
        }
        //System.out.println(_CONTENT_COUNT);

        int i = 2;
        int _ROW_COUNT = myFrame.getHeight()/30;

        //for (CarClass x : Main.cars) {
        for(int ii=0 ; ii<_ROW_COUNT-_CONTENT_COUNT; ii++){
            attributePanelConstraints.gridy = i;
            newPanel = new Panel(new GridLayout(1, CarClass.attributelist.values().length));
            tablePanelList.add(newPanel);
            for (CarClass.attributelist y : CarClass.attributelist.values()) {
                    if(y == CarClass.attributelist.carID){
                        TextField idTextField = new TextField(" ");
                        idTextField.setEditable(false);
                        newPanel.add(idTextField, attributePanelConstraints);
                    }else {
                        newPanel.add(new TextField(" "), attributePanelConstraints);
                    }
            }
            mainPanelContent.add(newPanel, attributePanelConstraints);
            i++;
        }

        for(int ii=0 ; ii<_ROW_COUNT; ii++) {
            CarClass x;
            System.out.println(Main.cars.size());
            if (Main.cars.size() > ii) {
                //System.out.println(Main.cars.size());
                x = Main.cars.get(ii);
                if (actionID == 1) {
                    boolean skipPanel = false;
                    switch (attributeIndex) {
                        case 0:
                            if (String.valueOf(x.carID).indexOf(attributeValue) == -1) {
                                System.out.print(x.carID);
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                //System.out.println("-"+ii+"-"+((TextField)((Panel)mainPanelContent.getComponent(ii+1)).getComponent(0)).getText());
                                mainPanelContent.validate();
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        case 1:
                            if (x.brand.indexOf(attributeValue) == -1) {
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        case 2:
                            if (String.valueOf(x.enginesize).indexOf(attributeValue) == -1) {
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        case 3:
                            if (x.model.indexOf(attributeValue) == -1) {
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        case 4:
                            if (x.colour.indexOf(attributeValue) == -1) {
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        case 5:
                            if (String.valueOf(x.year).indexOf(attributeValue) == -1) {
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        case 6:
                            if (String.valueOf(x.price).indexOf(attributeValue) == -1) {
                                mainPanelContent.getComponent(ii+1).setVisible(false);
                                skipPanel = true;
                            } else {
                                mainPanelContent.getComponent(ii+1).setVisible(true);
                            }
                            break;
                        default:
                            break;
                    }
                    if (skipPanel == true) {
                        continue;
                    }
                }
                int f = 0;
                Panel panelAtRow;
                TextField panelText;
                for (CarClass.attributelist y : CarClass.attributelist.values()) {
                    attributePanelConstraints.gridx = f;
                    panelAtRow = (Panel) mainPanelContent.getComponent(ii + 1);
                    panelAtRow.setName("CONTENT");
                    switch (y) {
                        case brand:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.brand.ordinal());
                            //System.out.println("brand, " + x.brand);
                            panelText.setText(x.brand);
                            break;
                        case carID:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.carID.ordinal());
                            panelText.setText(String.valueOf(x.carID));
                            break;
                        case colour:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.colour.ordinal());
                            panelText.setText(x.colour);
                            break;
                        case enginesize:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.enginesize.ordinal());
                            panelText.setText(String.valueOf(x.enginesize));
                            break;
                        case model:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.model.ordinal());
                            panelText.setText(x.model);
                            break;
                        case price:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.price.ordinal());
                            panelText.setText(String.valueOf(x.price));
                            break;
                        case year:
                            panelText = (TextField) panelAtRow.getComponent(CarClass.attributelist.year.ordinal());
                            panelText.setText(String.valueOf(x.year));
                            break;
                        default:
                            break;
                    }
                    f++;
                }
            }
        }
        mainPanel.add(mainPanelContent, contentConstraint);
        myFrame.add(mainPanel, BorderLayout.CENTER);
    }
}
