package weproject.ui;

import weproject.CarClass;
import weproject.Main;
import weproject.commands.*;
import static weproject.Main.cars;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class uiMain {
    public static Frame myFrame = new Frame("CarsDatabase");
    public static void GUI(){
        myFrame.setMinimumSize(new Dimension(450,350));
        myFrame.setLayout(new GridBagLayout());

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
        carsData.carsData();

        Button[] buttons = new Button[Main.commandEnum.values().length];

        //Button Creation
        int i = 0;
        for(Main.commandEnum x : Main.commandEnum.values()){
            buttons[i] = (Button) new Button(Main.commandEnum.values()[i].toString());
            buttonPanel.add(buttons[i]);
            i++;
        }

        //--------------------------------------
        //  BUTTONS PANNEL ON CLICK EVENTS
        //------------------------------------
        //Button Event Listeners
        // 0=help, 1=createCar, 2=printCars, 3=search, 4=delete, 5=edit, 6=SAVE, 7=clear
        buttons[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                help.Help();
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
                search.Search();
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
