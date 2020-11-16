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
/**
 *
 * @author aron
 */
public class Main {
    //where car objects are stored
    public static ArrayList<CarClass> cars = new ArrayList<CarClass>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //draw inputs for user
        drawhelp();
        //program does not stop
        while(true){
            try{                
                Scanner userinput = new Scanner(System.in);
                if (userinput.hasNextLine()){
                    //input processing
                    //TODO: implement an an enumerator to make this look better, 
                    switch(userinput.nextLine()){
                        //display input commandss
                        case "h":
                            drawhelp();
                            break;

                        //Create car object
                        case "c":
                            CarClass inputCar = new CarClass();
                            inputCar.inputinit();
                            //cars = CarClass.appendCarArray(cars, inputCar); 
                            cars.add(inputCar);
                            break;
                        
                        case "cnull":
                            CarClass nullCar = new CarClass();
                            nullCar.nullInit();
                            //cars = CarClass.appendCarArray(cars, nullCar); 
                            cars.add(nullCar);
                            break;
                            
                        //Delete car object
                        case "d":
                            System.out.println("PLEASE TYPE THE INDEX OF THE CAR YOU WANT TO DELETE:");
                            int i = 0;
                            for(CarClass x : cars){
                                System.out.print(String.valueOf(i) + ": ");
                                x.printID();
                                i++;
                            }
                            Scanner dinput = new Scanner(System.in);
                            cars.remove(Integer.parseInt(dinput.nextLine()));
                            //cars = CarClass.removeCarObject(cars, Integer.parseInt(dinput.nextLine()));
                            break;
                        
                        //show car object attributes
                        case "s":
                            for(CarClass x : cars){
                                x.printcontents();
                            }
                            break;
                            
                        //edit object
                        case "e":
                            //print objects with an itterator for aray index refrence
                            int l = 0;
                            for(CarClass x : cars){
                                System.out.print(String.valueOf(l) + ": ");
                                x.printID();
                                l++;
                            }
                            
                            //input array index
                            System.out.println("INPUT INDEX");
                            Scanner editScanner = new Scanner(System.in);
                            CarClass editCar = cars.get(Integer.parseInt(editScanner.nextLine()));
                            
                            //input attribute
                            System.out.println("Input Attribute:");
                            System.out.println("brand, enginesize, model, year, price, colour");
                            Scanner editAttributeScanner = new Scanner(System.in);
                            
                            //execute functions depending on input
                            //TODO: implement an an enumerator to make this look better
                            switch(editAttributeScanner.nextLine()){
                                case "brand":
                                    editCar.brandinit();
                                break;
                                case "enginesize":
                                    editCar.enginesizeinit();
                                break;
                                case "model":
                                    editCar.modelinit();
                                break;
                                case "year":
                                    editCar.yearinit();
                                break;
                                case "price":
                                    editCar.priceinit();
                                break;
                                case "colour":
                                    editCar.colourinit();
                                break;
                            }
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
    
    //user commands
    //TODO: create a class for storeing these command names and definitions
    public static void drawhelp(){
        System.out.println("h: help");
        System.out.println("c: create car");
        System.out.println("s: show cars");
        System.out.println("d: delete car");
        System.out.println("clear: clear console");
    }
    
}
