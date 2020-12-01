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
        Panel buttonPanel = new Panel(new GridLayout(0 ,1));
        buttonPanel.setBackground(Color.gray);
        GridBagConstraints buttonsConstraint = new GridBagConstraints();
        buttonsConstraint.fill = GridBagConstraints.VERTICAL;
        buttonsConstraint.anchor = GridBagConstraints.LINE_START;
        buttonsConstraint.ipady = buttonPanel.getSize().height;
        buttonsConstraint.weighty = 1;
        myFrame.add(buttonPanel, buttonsConstraint);


        //main pannel
        //cars data
        carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
        myFrame.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent componentEvent){
                carsData.mainPanel.removeAll();
                carsData.carsData(currentActionID, currentAttributeIndex, currentAttributeValue);
                carsData.mainPanel.validate();
                //carsData.mainPanel.repaint();
            }
        });

        Button[] buttons = new Button[Main.commandEnum.values().length];

        //Button Creation
        int i = 0;
        for(Main.commandEnum x : Main.commandEnum.values()){
            buttons[i] = (Button) new Button(Main.commandEnum.values()[i].toString());
            buttonPanel.add(buttons[i]);
            i++;
        }
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
                carsData.mainPanel.removeAll();
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
                carsData.mainPanel.removeAll();
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
                carsData.mainPanel.removeAll();
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
                carsData.mainPanel.removeAll();
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
                carsData.mainPanel.removeAll();
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
                carsData.mainPanel.removeAll();
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
                carsData.mainPanel.removeAll();
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
                for (CarClass x : cars) {
                    x.printcontents();
                }
            }
        });
        buttons[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                searchFrame.setVisible(true);
            }
        });
        buttons[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                delete.Delete();
            }
        });
        buttons[5].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                edit.Edit();
            }
        });
        buttons[6].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                save.save();
            }
        });
        buttons[7].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("\033[H\033[2J");
            }
        });
        //--------------------------------------------
        myFrame.setVisible(true);

    }
}
