/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject.commands;

import static weproject.Main.scanner;
import java.util.Scanner;
import weproject.CarClass;
import static weproject.Main.cars;

/**
 *
 * @author aron
 */
public class edit {
    public static void Edit(){
        //print objects with an itterator for aray index refrence
        int l = 0;
        for(CarClass x : cars){
            System.out.print(String.valueOf(l) + ": ");
            x.printID();
            l++;
        }

        //input array index
        System.out.println("INPUT INDEX");
        //Scanner scanner = Main.scanner;
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
    }
}
