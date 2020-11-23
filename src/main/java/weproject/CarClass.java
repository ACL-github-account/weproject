/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;

import java.util.Arrays;
import java.util.Scanner;
import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;
import static weproject.Main.cars;

/**
 *
 * @author aron
 */
public class CarClass implements Externalizable{
    
    //declare attributes
    public String brand, model, colour;
    public int year, carID, enginesize;
    public double price;
    //static int carIDnum = 0; 
    
    //to be used by other classes for listing CarClass attributes.
    public static enum attributelist{
        brand, enginesize, model, colour, year, carID, price;
    }
    
    //assignID on creation
    public CarClass(){
        this.carID = Main.cars.size();
    }
    
    //------------------------------------------------
    //      EXTERNALIZABLE OVEERRIDES
    //------------------------------------------------
    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeObject(this);
        out.writeDouble(this.price);
        out.writeUTF(this.brand);
        out.writeUTF(this.model);
        out.writeUTF(this.colour);
        out.writeInt(this.year);
        out.writeInt(this.carID);
        out.writeInt(this.enginesize);
    }
    
    @Override
    public void readExternal(ObjectInput in)
        throws ClassNotFoundException, IOException{
        CarClass loadedcar = (CarClass) in.readObject();        
        loadedcar.price = in.readDouble();
        loadedcar.brand = in.readUTF();
        loadedcar.model = in.readUTF();
        loadedcar.colour = in.readUTF();
        loadedcar.year = in.readInt();
        loadedcar.carID = in.readInt();
        loadedcar.enginesize = in.readInt();
        Main.cars.add(loadedcar);
    }
    //------------------------------------------------
    //------------------------------------------------
    //   INPUT CONVERSION AND VALIDATION FUNCTIONS
    //-------------------------------------------------
    public static int inputInt(String inputFieldName){
        //IF INPUT THROWS NOT EXCEPTION THIS BECOMES TRUE TO BREAK LOOP
        boolean validinput = false;
        //RETURN VALUE
        int returnVal = -1;
        
        
        Scanner carspecuserinput;
        do {
            System.out.print(inputFieldName);
            carspecuserinput = new Scanner(System.in);
            try{
                returnVal = Integer.parseInt(carspecuserinput.nextLine()); 
                validinput = true;
            } catch(NumberFormatException e) {
                System.out.println("Not an integer, please try again.");
            }
        } while(validinput == false);
        return returnVal;
    }
    public static double inputDouble(String inputFieldName){
        //IF INPUT THROWS NOT EXCEPTION THIS BECOMES TRUE TO BREAK LOOP
        boolean validinput = false;
        //RETURN VALUE
        double returnVal = -1;
        
        
        Scanner carspecuserinput;
        do {
            System.out.print(inputFieldName);
            carspecuserinput = new Scanner(System.in);
            try{
                returnVal = Double.parseDouble(carspecuserinput.nextLine()); 
                validinput = true;
            } catch(NumberFormatException e) {
                System.out.println("Not an integer, please try again.");
            }
        } while(validinput == false);
        return returnVal;
    }
    
    public static String inputStr(String inputFieldName){
        //IF INPUT THROWS NOT EXCEPTION THIS BECOMES TRUE TO BREAK LOOP
        boolean validinput = false;
        //RETURN VALUE
        String returnVal = "";
        
        
        Scanner carspecuserinput;
        do {
            System.out.print(inputFieldName);
            carspecuserinput = new Scanner(System.in);
            String input = carspecuserinput.nextLine();
            if (!input.isEmpty()){
                returnVal = input;
                validinput = true;
            } else {
                System.out.println("no empty strings are allowed");
            }
        } while(validinput == false);
        return returnVal;
    }
    
    
    //------------------------------------------------
    //------------------------------------------------
    
    //------------------------------------------------
    //          INITIALIZATION METHODS
    //-------------------------------------------------
    //initialise attributes from user input
    public void brandinit(){
        System.out.println("input brand");
        this.brand = inputStr("brand: ");
    }
    public void enginesizeinit(){
        System.out.println("input enginesize");
        this.enginesize = inputInt("size: ");
    }    
    public void yearinit(){
        System.out.println("input year");
        this.year = inputInt("year: ");     
    }    
    public void priceinit(){
        System.out.println("input price");
        this.price = inputDouble("price: ");
    }    
    public void colourinit(){
        System.out.println("input colour");
        this.colour = inputStr("colour: ");
    }    
    public void modelinit(){
        System.out.println("input model");
        this.model = inputStr("model: ");
    }
    
    //-------------------------------------------------
    //-------------------------------------------------
    
    
    //initialise variables, calls methods initialising each variable from
    //input, they are seperate so they may be called individiauly to edit
    //existing objects
    public void inputinit(){    
        brandinit();
        enginesizeinit();
        modelinit();
        colourinit();
        yearinit();
        priceinit();
    }
    
    //initialise variables as null, used for fast creation of an object for debug
    public void noneInit(){
        this.brand = "s";
        this.enginesize = 0;
        this.model = "s";
        this.colour = "s";
        this.year = 0;
        this.price = 0.00;
    }
    
    //printsID's and more human readable attributes on one line.
    public void printID(){
        System.out.print(this.carID + " ");
        System.out.print(this.brand + " ");
        System.out.println(this.model);
    }
    
    //prints attributes of a car
    public void printcontents(){
        System.out.println("ID:" + this.carID);
        System.out.println("brand: " + this.brand);
        System.out.println("enginesize: " + this.enginesize + "cc");
        System.out.println("model: " + this.model);
        System.out.println("year: " + this.year);
        System.out.println("price: £" + this.price);
        System.out.println("colour: " + this.colour);
        System.out.println();
    }
}
