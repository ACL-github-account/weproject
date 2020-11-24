/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;
import weproject.*;
import java.util.Scanner;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.Console;
import java.lang.Runtime;
import java.util.ArrayList;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;
import weproject.commands.*;
import java.awt.*;
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
