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
/**
 *
 * @author aron
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        CarClass[] cars = {new CarClass()};
        
        // TODO code application logic here
        while(true){
            try{                
                Scanner userinput = new Scanner(System.in);
                if (userinput.hasNextLine()){
                    switch(userinput.nextLine()){
                        case "1":
                            System.out.println("Yo dude its working yo");
                            break;
                        case "2":
                            CarClass car = new CarClass();
                            System.out.println("input brand");
                            Scanner carspecuserinput = new Scanner(System.in);
                            car.brand = carspecuserinput.nextLine();
                            
                            System.out.println("input enginesize");
                            carspecuserinput = new Scanner(System.in);
                            car.enginesize = carspecuserinput.nextLine();
                            
                            System.out.println("input model");
                            carspecuserinput = new Scanner(System.in);
                            car.model = carspecuserinput.nextLine();
                            
                            System.out.println("input year");
                            carspecuserinput = new Scanner(System.in);
                            car.year = Integer.parseInt(carspecuserinput.nextLine());
                            
                            System.out.println("input price");
                            carspecuserinput = new Scanner(System.in);
                            car.price = Double.parseDouble(carspecuserinput.nextLine());
                            
                            System.out.println("input colour");
                            carspecuserinput = new Scanner(System.in);
                            car.colour = carspecuserinput.nextLine();
                            
                            cars = UtilMethods.appendArray(cars, car);
                            
                            break;
                        case "3":
                            //if (!= null){
                                for(CarClass x : cars){
                                    System.out.println("test");
                                    System.out.println(x.toString());
                                }
                            //}
                            break;
                        default:
                            //System.out.println(x);
                            break;
                    }
                }
            } catch (Exception e){System.out.println(e.toString());}
        }
    }
    
}
