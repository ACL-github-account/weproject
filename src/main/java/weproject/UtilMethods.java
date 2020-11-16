/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;
import weproject.CarClass;
import java.util.Arrays;

/**
 *
 * @author aron
 */
public class UtilMethods {
    public static CarClass[] appendArray(CarClass[] arr, CarClass apobj){
        CarClass[] rarr = Arrays.copyOf(arr, arr.length + 1);
        rarr[rarr.length - 1] = apobj;
        return rarr;
    }    
}
