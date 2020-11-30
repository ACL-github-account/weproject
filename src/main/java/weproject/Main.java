/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;
import weproject.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;
import weproject.commands.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author aron
 */
public class Main {
    //where car objects are stored
    public static ArrayList<CarClass> cars = new ArrayList<CarClass>();
    public static Scanner scanner;
    
    public static Frame myFrame = new Frame("CarsDatabase");
    //for now save location is hardcoded
    public static final String filename = "./carData.ser";

    enum commandEnum{
        help, createCar, printCars, search, delete, edit, SAVE, clear
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        //-----READ CONFIG------
        //----------------------

        //-----LOAD SAVED DATA-----
        File dataFile = new File(filename);
        if(dataFile.exists()){
            FileInputStream fistream = new FileInputStream(dataFile);
            ArrayList<Object> ObjectsList = new ArrayList<>();
            boolean cont = true;

            while (cont){
                try{
                    ObjectInputStream inp = new ObjectInputStream(fistream);
                    Object obj = inp.readObject();
                    if (obj != null){
                        ObjectsList.add(obj);
                    } else {
                        cont = false;
                    }
                } catch(EOFException e){
                    break;
                }
            }
        }
        //-------------------------
        String argument = " ";
        for (String x : args){
            argument = x;
        }

        //Graphical Interface

        if (!argument.equals("--Term")) {
            myFrame.setMinimumSize(new Dimension(65,350));
            myFrame.setMaximumSize(new Dimension(65,350));

            myFrame.setLayout(new FlowLayout());
            Button[] buttons = new Button[commandEnum.values().length];

            //Button Creation
            int i = 0;
            for(commandEnum x : commandEnum.values()){
                buttons[i] = (Button) myFrame.add(new Button(commandEnum.values()[i].toString()));
                i++;
            }
            //buttons[0] = (Button) myFrame.add(new Button("Help"));
            //buttons[1] = (Button) myFrame.add(new Button("Create Car"));
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



            myFrame.setVisible(true);

            //terminal UI
        }
        if(argument.equals("--Term") || argument.equals("--GUI-Term")){
            //draw inputs for user
            help.Help();

            //-----------------------------------------------------------------
            //                  TERMINAL USER INTERFACE
            //-----------------------------------------------------------------
            //program does not stop
            while(true) {
                try {
                    scanner = new Scanner(System.in);
                    if (scanner.hasNextLine()) {
                        //input processing
                        switch (scanner.nextLine()) {
                            //display input commands
                            case "h":
                                help.Help();
                                break;

                            //Create car object
                            case "c":
                                CarClass inputCar = new CarClass();
                                inputCar.inputinit();
                                cars.add(inputCar);
                                break;

                            case "cn":
                                CarClass noneCar = new CarClass();
                                noneCar.noneInit();
                                cars.add(noneCar);
                                break;

                            //Delete car object
                            case "d":
                                delete.Delete();
                                break;

                            //show car object attributes
                            case "p":
                                for (CarClass x : cars) {
                                    x.printcontents();
                                }
                                break;

                            //edit object
                            case "e":
                                edit.Edit();
                                break;

                            //search object
                            case "s":
                                search.Search();
                                break;

                            //use externalizable to serialize cars object
                            case "SAVE":
                                save.save();
                                break;

                            //clear terminal
                            case "clear":
                                System.out.println("\033[H\033[2J");
                                break;
                            default:
                                break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
        //-----------------------------------------------
    } 
    //end of main function
}
