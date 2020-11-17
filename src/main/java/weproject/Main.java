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
        //for reading user input
        Scanner scanner;
        
        //program does not stop
        while(true){
            try{                
                scanner = new Scanner(System.in);
                if (scanner.hasNextLine()){
                    //input processing
                    //TODO: implement an an enumerator to make this look better, 
                    switch(scanner.nextLine()){
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
                        case "p":
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
                            scanner = new Scanner(System.in);
                            CarClass editCar = cars.get(Integer.parseInt(scanner.nextLine()));
                            
                            //input attribute
                            System.out.println("Input Attribute:");
                            System.out.println("brand, enginesize, model, year, price, colour");
                            scanner = new Scanner(System.in);
                            
                            //execute functions depending on input
                            //TODO: implement an an enumerator to make this look better
                            switch(CarClass.attributelist.valueOf(scanner.nextLine())){
                                case brand:
                                    editCar.brandinit();
                                break;
                                case enginesize:
                                    editCar.enginesizeinit();
                                break;
                                case model:
                                    editCar.modelinit();
                                break;
                                case year:
                                    editCar.yearinit();
                                break;
                                case price:
                                    editCar.priceinit();
                                break;
                                case colour:
                                    editCar.colourinit();
                                break;
                            }
                            break;
                            
                        case "s":
                            scanner = new Scanner(System.in);
                            Scanner searchinput;
                            System.out.println("search by?:");
                            for(CarClass.attributelist x : CarClass.attributelist.values()){
                                System.out.println(x);
                            }
                            String user_input = scanner.nextLine();

                            switch(CarClass.attributelist.valueOf(user_input)){
                                case brand:
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.brand).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
                                    break;
                                case enginesize:
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.enginesize).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
                                    break;
                                case model:
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.model).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
                                    break;
                                case colour:
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.colour).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
                                    break;
                                case year:
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.year).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
                                    break;
                                case carID:                                             System.out.println("SEARCH:");
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.carID).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
                                    break;
                                case price:
                                    searchinput = new Scanner(System.in);
                                    for(CarClass x : cars){
                                        if(String.valueOf(x.price).indexOf(searchinput.nextLine()) != -1){
                                            x.printcontents();
                                            System.out.println("PRESS ENTER FOR NEXT");
                                        }
                                    }
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
        System.out.println("p: print cars");
        System.out.println("s: search for cars");
        System.out.println("d: delete car");
        System.out.println("e: edit car");
        System.out.println("clear: clear console");
    }
    
}
