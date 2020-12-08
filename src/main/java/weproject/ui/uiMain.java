package weproject.ui;

import weproject.CarClass;
import weproject.Main;
import weproject.commands.*;
import static weproject.Main.cars;

import java.awt.*;
import java.awt.event.*;

public class uiMain{
    public static int currentActionID = 0;
    public static int currentAttributeIndex = 0;
    public static String currentAttributeValue = null;

    public static Frame myFrame = new Frame("CarsDatabase");
    public static void GUI(){
        myFrame.setMinimumSize(new Dimension(450,350));
        myFrame.setLayout(new GridBagLayout());
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
        buttonsConstraint.fill = GridBagConstraints.VERTICAL;
        buttonsConstraint.anchor = GridBagConstraints.LINE_START;
        buttonsConstraint.ipady = buttonPanel.getSize().height;
        buttonsConstraint.weighty = 1;
        myFrame.add(buttonPanel, buttonsConstraint);


        //main pannel
        //cars data
        //carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
        carsData.initializeCarsData();
        myFrame.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent componentEvent){
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
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
        myFrame.add(buttonPanel, bpGB);

        //GUI's
        Frame helpFrame = new Frame();
        Frame createFrame = new Frame();
        Frame searchFrame = new Frame();

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



        searchByCarId.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 0;
                currentAttributeValue = searchByCarIdField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
            }
        });
        searchByBrand.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 1;
                currentAttributeValue = searchByBrandField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
            }
        });
        searchByEngineSize.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 2;
                currentAttributeValue = searchByEngineSizeField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
            }
        });
        searchByModel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 3;
                currentAttributeValue = searchByModelField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
            }
        });
        searchByColour.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 4;
                currentAttributeValue = searchByColourField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
            }
        });
        searchByYear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 5;
                currentAttributeIndex = 0;
                currentAttributeValue = searchByYearField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
            }
        });
        searchByPrice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currentActionID = 1;
                currentAttributeIndex = 6;
                currentAttributeValue = searchByPriceField.getText();
                currentAttributeValue = searchByPriceField.getText();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
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
                CarClass inputCar = new CarClass();
                inputCar.inputinit();
                cars.add(inputCar);
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
                delete.Delete();
            }
        });
        buttons[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                for(int ii = 0; ii < cars.size(); ii++){
                    Panel att = (Panel)carsData.tablePanelList.get(ii);
                    if (!String.valueOf(cars.get(ii).carID).equals(((TextField)att.getComponent(0)).getText())){
                        System.out.print("notSame carID");
                        cars.get(ii).carID = Integer.parseInt(((TextField)att.getComponent(0)).getText());
                    }
                    if (!String.valueOf(cars.get(ii).brand).equals(((TextField)att.getComponent(1)).getText())){
                        System.out.print("notSame brand");
                        cars.get(ii).brand = ((TextField)att.getComponent(1)).getText();
                    }
                    if (!String.valueOf(cars.get(ii).enginesize).equals(((TextField)att.getComponent(2)).getText())){
                        System.out.print("notSame enginesize");
                        cars.get(ii).enginesize = Integer.parseInt(((TextField)att.getComponent(2)).getText());
                    }
                    if (!String.valueOf(cars.get(ii).model).equals(((TextField)att.getComponent(3)).getText())){
                        System.out.print("notSame Model");
                        cars.get(ii).model = ((TextField)att.getComponent(3)).getText();
                    }
                    if (!String.valueOf(cars.get(ii).colour).equals(((TextField)att.getComponent(4)).getText())){
                        System.out.print("notSame Colour");
                        cars.get(ii).colour = ((TextField)att.getComponent(4)).getText();
                    }
                    if (!String.valueOf(cars.get(ii).year).equals(((TextField)att.getComponent(5)).getText())){
                        System.out.print("notSame year");
                        cars.get(ii).year = Integer.parseInt(((TextField)att.getComponent(5)).getText());
                    }
                    if (!String.valueOf(cars.get(ii).price).equals(((TextField)att.getComponent(6)).getText())){
                        System.out.print("notSame price");
                        cars.get(ii).price = Double.parseDouble(((TextField)att.getComponent(6)).getText());
                    }

                    System.out.println();
                }
                save.save();
            }
        });
        //--------------------------------------------
        myFrame.setVisible(true);
    }
}
