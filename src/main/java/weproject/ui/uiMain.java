package weproject.ui;

import weproject.CarClass;
import weproject.commands.*;

import javax.swing.border.Border;

import static weproject.Main.cars;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class uiMain {
    private static int checkToConvertToInt(String inputString) {
        System.out.print(inputString);
        int returnVal = 0;
        try {
            returnVal = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer, defaulting to 0");
        }
        return returnVal;
    }
    private static double checkToConvertToDouble(String inputString) {
        System.out.print(inputString);
        double returnVal = 0;
        try {
            returnVal = Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer, defaulting to 0");
        }
        return returnVal;
    }
    public static int currentActionID = 0;
    public static int currentAttributeIndex = 0;
    public static String currentAttributeValue = null;

    public static Frame myFrame = new Frame("CarsDatabase");
    public static void GUI(){
        myFrame.setMinimumSize(new Dimension(450,350));
        myFrame.setLayout(new BorderLayout());
        myFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        //--------------------
        // MAIN PANNELS
        //--------------------
        //ButtonsPanel
        Panel buttonPanel = new Panel(new GridBagLayout());
        buttonPanel.setBackground(Color.gray);
        GridBagConstraints buttonsConstraint = new GridBagConstraints();


        //main pannel
        //cars data
        //carsTable.carsTable(currentActionID, currentAttributeIndex, currentAttributeValue);
        carsTable.initializeCarsData();
        myFrame.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent componentEvent){
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });

        Button[] buttons = new Button[5];

        //Button Creation
        // 0=help, 1=createCar, 2=printCars, 3=search, 4=delete, 5=edit, 6=SAVE, 7=clear
        buttons[0] = (Button) new Button("Help");
        buttons[1] = (Button) new Button("New Car");
        buttons[2] = (Button) new Button("Search");
        buttons[3] = (Button) new Button("Delete Car");
        buttons[4] = (Button) new Button("SAVE");
        int bi=0;
        GridBagConstraints bGB = new GridBagConstraints();
        bGB.weighty = 1;
        bGB.weightx = 1;
        bGB.fill = GridBagConstraints.BOTH;
        for(Button b : buttons){
            bGB.gridy = bi;
            buttonPanel.add(b, bGB);
            bi++;
        }
        GridBagConstraints bpGB = new GridBagConstraints();
        bpGB.fill = GridBagConstraints.VERTICAL;
        bpGB.weighty = 1;
        bpGB.gridx = 0;
        bpGB.anchor = GridBagConstraints.LINE_START;
        myFrame.add(buttonPanel, BorderLayout.WEST);

        //GUI's
        Frame helpFrame = new Frame();
        Frame createFrame = new Frame();
        Frame searchFrame = new Frame();

        //Create GUI
        createFrame.setLayout(new BorderLayout());
        createFrame.setMinimumSize(new Dimension(175,200));
        createFrame.setResizable(false);
        Panel createPanel = new Panel(new GridLayout(7, 2));
        Button createButton = new Button("Create");
        createButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CarClass newCar = new CarClass();
                //System.out.println(newCar.carID);
                ArrayList newCarAttributes = new ArrayList<Object>();
                newCarAttributes.add(newCar.brand);
                newCarAttributes.add(newCar.enginesize);
                newCarAttributes.add(newCar.model);
                newCarAttributes.add(newCar.colour);
                newCarAttributes.add(newCar.year);
                newCarAttributes.add(newCar.price);
                int itterator = 0;
                for (Component c : createPanel.getComponents()){
                    int remainder = itterator%2;
                    if(remainder == 1 && itterator != (3 | 9 | 11)){
                        //System.out.println(c + " " + remainder);
                        newCarAttributes.set(itterator/2, ((TextField) c).getText());
                    } else if (remainder == 1 && itterator != 11){
                        //System.out.println(c + " " + remainder);
                        newCarAttributes.set(itterator/2, ((TextField) c).getText());
                    } else if (itterator == 11) {
                        //System.out.println(c + " " + remainder);
                        newCarAttributes.set(itterator/2, ((TextField) c).getText());
                    }
                    itterator++;
                }
                newCar.brand = (String) newCarAttributes.get(0);
                newCar.enginesize = checkToConvertToInt((String) newCarAttributes.get(1));
                newCar.model = (String)newCarAttributes.get(2);
                newCar.colour = (String)newCarAttributes.get(3);
                newCar.year = checkToConvertToInt((String)newCarAttributes.get(4));
                newCar.price = checkToConvertToDouble((String) newCarAttributes.get(5));
                itterator = 0;

                //THE REASON WHY THIS IS FAILING TO DISPLAY, IS BECAUSE THE COMPONENT INDEX THAT IS BEING REFRENCED
                //IS NULL, AND IS SO BECAUSE OF WHEN EMPTY ROWS WERE DELTED FOR RELOADING. THE SOLUTION TO NOT DELETE EMPTY ROWS
                //BUT ONLY ADD NEW ONES WHEN NECESARY, THIS MAY TAKE SOME TIME TO IMMPLEMENT AS IT WILL INVOLVE KNOWING EXACTLY WHEN
                //A NEW ROW SHOULD BE CREATED.

                //A MESSY SOLUTION WOULD BE TO DELETE THE ENTIRE PANEL AND REINITIALIZE, HOWEVER THIS INTRODUCES OLD BUGS AND PREVENTS EDITING OF NEWLY
                //ADDED CARS

                cars.add(newCar);
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        createPanel.add(new Label("brand"));
        createPanel.add(new TextField("-"));
        createPanel.add(new Label("enginesize"));
        createPanel.add(new TextField("-"));
        createPanel.add(new Label("model"));
        createPanel.add(new TextField("-"));
        createPanel.add(new Label("colour"));
        createPanel.add(new TextField("-"));
        createPanel.add(new Label("year"));
        createPanel.add(new TextField("-"));
        createPanel.add(new Label("price"));
        createPanel.add(new TextField("-"));
        createFrame.add(createPanel, BorderLayout.CENTER);
        createFrame.add(createButton, BorderLayout.SOUTH);
        createFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                createFrame.setVisible(false);
            }
        });


        //Help GUI
        helpFrame.setLayout(new FlowLayout());
        Label helpText = new Label();
        helpText.setText("Help Text Here");
        helpFrame.add(helpText);
        helpFrame.setMinimumSize(new Dimension(300,300));
        helpFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                helpFrame.setVisible(false);
            }
        });

        //searchFrame GUI
        searchFrame.setLayout(new GridLayout(7,2));
        //carID, brand, enginesize, model, colour, year, price;
        Button searchByCarId = new Button("searchByCarId");
        Button searchByBrand = new Button("searchByBrand");
        Button searchByEngineSize = new Button("searchByEngineSize");
        Button searchByModel = new Button("searchByModel");
        Button searchByColour = new Button("searchByColour");
        Button searchByYear = new Button("searchByYear");
        Button searchByPrice = new Button("searchByPrice");

        TextField searchByCarIdField = new TextField();
        TextField searchByBrandField  = new TextField();
        TextField searchByEngineSizeField  = new TextField();
        TextField searchByModelField  = new TextField();
        TextField searchByColourField  = new TextField();
        TextField searchByYearField  = new TextField();
        TextField searchByPriceField  = new TextField();

        searchFrame.add(searchByCarId);searchFrame.add(searchByCarIdField);
        searchFrame.add(searchByBrand);searchFrame.add(searchByBrandField);
        searchFrame.add(searchByEngineSize);searchFrame.add(searchByEngineSizeField);
        searchFrame.add(searchByModel);searchFrame.add(searchByModelField);
        searchFrame.add(searchByColour);searchFrame.add(searchByColourField);
        searchFrame.add(searchByYear);searchFrame.add(searchByYearField);
        searchFrame.add(searchByPrice);searchFrame.add(searchByPriceField);

        //Delete Car
        Frame deleteCar = new Frame();
        deleteCar.setLayout(new BorderLayout());
        deleteCar.setMinimumSize(new Dimension(200, 150));
        deleteCar.setResizable(false);
        deleteCar.add(new Label("Input Car ID:"), BorderLayout.NORTH);
        TextField carIdBox = new TextField();
        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idToDelete = Integer.parseInt(carIdBox.getText());
                int indexToDelete = 0;
                for(CarClass x : cars){
                    if(x.carID == idToDelete){
                        break;
                    }
                    indexToDelete++;
                }
                cars.remove(indexToDelete);
                carsTable.mainPanel.removeAll();
                carsTable.initializeCarsData();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        deleteButton.setBackground(Color.RED);
        deleteCar.add(carIdBox, BorderLayout.CENTER);
        deleteCar.add(deleteButton, BorderLayout.SOUTH);
        deleteCar.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                deleteCar.setVisible(false);
            }
        });

        searchByCarId.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 0;
                currentAttributeValue = searchByCarIdField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        searchByBrand.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 1;
                currentAttributeValue = searchByBrandField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        searchByEngineSize.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                currentActionID = 1;
                currentAttributeIndex = 2;
                currentAttributeValue = searchByEngineSizeField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        searchByModel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 3;
                currentAttributeValue = searchByModelField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        searchByColour.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 4;
                currentAttributeValue = searchByColourField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        searchByYear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 5;
                currentAttributeIndex = 0;
                currentAttributeValue = searchByYearField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });
        searchByPrice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 6;
                currentAttributeValue = searchByPriceField.getText();
                currentAttributeValue = searchByPriceField.getText();
                carsTable.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsTable.mainPanel.validate();
            }
        });

        searchFrame.setMinimumSize(new Dimension(200,400));
        searchFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                searchFrame.setVisible(false);
            }
        });

        //--------------------------------------
        //  BUTTONS PANNEL ON CLICK EVENTS
        //------------------------------------
        //Button Event Listeners
        // 0=help, 1=createCar, 2=printCars, 3=search, 4=delete, 5=edit, 6=SAVE, 7=clear
        buttons[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                helpFrame.setVisible(true);
            }
        });
        buttons[1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                createFrame.setVisible(true);
                //CarClass inputCar = new CarClass();
                //inputCar.inputinit();
                //cars.add(inputCar);
            }
        });
        buttons[2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                searchFrame.setVisible(true);
            }
        });
        buttons[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteCar.setVisible(true);
            }
        });
        buttons[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                for(int ii = 0; ii < cars.size(); ii++){
                    System.out.println("here 1");
                    Panel att = (Panel) carsTable.tablePanelList.get(ii);
                    if (!String.valueOf(cars.get(ii).carID).equals(((TextField)att.getComponent(0)).getText())){
                        System.out.print("notSame carID");
                        cars.get(ii).carID = Integer.parseInt(((TextField)att.getComponent(0)).getText());
                    }
                    System.out.println("here 2");
                    if (!String.valueOf(cars.get(ii).brand).equals(((TextField)att.getComponent(1)).getText())){
                        System.out.print("notSame brand");
                        cars.get(ii).brand = ((TextField)att.getComponent(1)).getText();
                    }
                    System.out.println("here 3");
                    if (!String.valueOf(cars.get(ii).enginesize).equals(((TextField)att.getComponent(2)).getText())){
                        System.out.print("notSame enginesize");
                        cars.get(ii).enginesize = Integer.parseInt(((TextField)att.getComponent(2)).getText());
                    }
                    System.out.println("here 4");
                    if (!String.valueOf(cars.get(ii).model).equals(((TextField)att.getComponent(3)).getText())){
                        System.out.print("notSame Model");
                        cars.get(ii).model = ((TextField)att.getComponent(3)).getText();
                    }
                    System.out.println("here 5");
                    if (!String.valueOf(cars.get(ii).colour).equals(((TextField)att.getComponent(4)).getText())){
                        System.out.print("notSame Colour");
                        cars.get(ii).colour = ((TextField)att.getComponent(4)).getText();
                    }
                    System.out.println("here 6");
                    if (!String.valueOf(cars.get(ii).year).equals(((TextField)att.getComponent(5)).getText())){
                        System.out.print("notSame year");
                        cars.get(ii).year = Integer.parseInt(((TextField)att.getComponent(5)).getText());
                    }
                    System.out.println("here 7");
                    if (!String.valueOf(cars.get(ii).price).equals(((TextField)att.getComponent(6)).getText())){
                        System.out.print("notSame price");
                        cars.get(ii).price = Double.parseDouble(((TextField)att.getComponent(6)).getText());
                    }

                    System.out.println();
                }
                System.out.println("here final");
                save.save();
                System.out.println("here finished");
            }
        });
        //--------------------------------------------
        myFrame.setVisible(true);
    }
}
