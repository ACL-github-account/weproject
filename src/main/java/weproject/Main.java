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
                        case "h":
                            drawhelp();
                            break;
                        case "c":
                            CarClass car = new CarClass();
                            car.inputinit();
                            cars = UtilMethods.appendArray(cars, car);                           
                            break;
                        case "s":
                            for(CarClass x : cars){
                                x.printcontents();
                            }
                        case "clear":
                            //Runtime.getRuntime().exec("clear");
                            System.out.print("\033[H\033[2J");
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e){System.out.println(e.toString());}
        }
    } 
    //end of main function
    public static void drawhelp(){
        System.out.println("h: help");
        System.out.println("c: create car");
        System.out.println("s: show cars");
        System.out.println("clear: clear console");
    }
    
}
