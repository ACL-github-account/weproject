/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject.commands;

import weproject.Main;
import java.io.Externalizable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import weproject.CarClass;
import static weproject.Main.cars;
//import java.io.FileWriter;

/**
 *
 * @author aron
 */
public class save {
    public static void save(){
            if(!cars.isEmpty()){
            try{
                FileOutputStream outStream = new FileOutputStream(Main.filename);           
                for(CarClass x : cars){
                    ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
                    x.writeExternal(objectOutStream);
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
}
