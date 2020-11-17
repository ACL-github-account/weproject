/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject.commands;

import java.util.Scanner;
import weproject.CarClass;
import static weproject.Main.cars;

/**
 *
 * @author aron
 */
public class delete {
    public static void Delete(){
        System.out.println("PLEASE TYPE THE INDEX OF THE CAR YOU WANT TO DELETE:");
        int i = 0;
        for(CarClass x : cars){
            System.out.print(String.valueOf(i) + ": ");
            x.printID();
            i++;
        }
        Scanner dinput = new Scanner(System.in);
        cars.remove(Integer.parseInt(dinput.nextLine()));
    }
}
