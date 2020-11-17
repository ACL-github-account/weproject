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

import weproject.commands.*;
/**
 *
 * @author aron
 */
public class Main {
    //where car objects are stored
    public static ArrayList<CarClass> cars = new ArrayList<CarClass>();
    public static Scanner scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //draw inputs for user
        help.Help();
        //for reading user input
        
        //program does not stop
        while(true){
            try{                
                scanner = new Scanner(System.in);
                if (scanner.hasNextLine()){
                    //input processing
                    switch(scanner.nextLine()){
                        //display input commandss
                        case "h":
                            help.Help();
                            break;

                        //Create car object
                        case "c":
                            CarClass inputCar = new CarClass();
                            inputCar.inputinit();
                            cars.add(inputCar);
                            break;
                        
                        case "cnull":
                            CarClass nullCar = new CarClass();
                            nullCar.nullInit();
                            cars.add(nullCar);
                            break;
                            
                        //Delete car object
                        case "d":
                            delete.Delete();
                            break;
                        
                        //show car object attributes
                        case "p":
                            for(CarClass x : cars){
                                x.printcontents();
                            }
                            break;
                            
                        //edit object
                        case "e":
                            edit.Edit();
                            break;
                            
                        case "s":
                            search.Search();
                            break;
                        
                        //clear terminal
                        case "clear":
                            System.out.println("\033[H\033[2J");
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e){System.out.println(e.toString());}
        }
    } 
    //end of main function
}
