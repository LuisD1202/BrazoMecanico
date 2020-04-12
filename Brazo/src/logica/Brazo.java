/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
/**
 *
 * @author Oswaldo
 */
public class Brazo {
    public  int w, h,gA1,gA2,gA3,gA4,gp; 
    public Brazo() {
        //asignar los valores iniciales de las articulaciones 
        w = 280;
        h = 300;
        gA1 =0;
        gA2 =45;
        gA3 =0;
        gA4 =0;
        gp =0;
    }

    public int getgA1() {
        return gA1;
    }
    public int getgA2() {
     
         return gA2;
    }
    public int getgA3() {
        return gA3;
    }
    public int getgA4() {
        return gA4;
    }
    public int getGp() {
        return gp;
    }
    public int getW() {
        return w;
    }
    public int getH() {
        return h;
    }   
}