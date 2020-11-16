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
/**
 *
 * @author aron
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        drawhelp();
        
        CarClass[] cars = {new CarClass()};
        
        // TODO code application logic here
        while(true){
            try{                
                Scanner userinput = new Scanner(System.in);
                if (userinput.hasNextLine()){
                    switch(userinput.nextLine()){
                        //display input commandss
                        case "h":
                            drawhelp();
                            break;

                        //Create car object
                        case "c":
                            CarClass inputCar = new CarClass();
                            inputCar.inputinit();
                            cars = CarClass.appendCarArray(cars, inputCar);                           
                            break;
                        
                        case "cnull":
                            CarClass nullCar = new CarClass();
                            nullCar.nullInit();
                            cars = CarClass.appendCarArray(cars, nullCar); 
                            break;
                            
                        //Delete car object
                        case "d":
                            for(CarClass x : cars){
                                x.printID();
                            }                            
                            break;
                        
                        //show car object attributes
                        case "s":
                            for(CarClass x : cars){
                                x.printcontents();
                            }
                            break;
                        //clear terminal
                        case "clear":
                            //Runtime.getRuntime().exec("clear");
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
    public static void drawhelp(){
        System.out.println("h: help");
        System.out.println("c: create car");
        System.out.println("s: show cars");
        System.out.println("clear: clear console");
    }
    
}
