/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject.commands;

import java.util.Scanner;
import weproject.CarClass;
import static weproject.Main.cars;
import static weproject.Main.scanner;

/**
 *
 * @author aron
 */
public class search {
    public static void Search(){
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
    }
}
