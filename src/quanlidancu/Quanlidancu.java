/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlidancu;

import model.HoKhau;
import service.HoKhauService;

/**
 *
 * @author phamd
 */
public class Quanlidancu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HoKhau tmp = new HoKhau(1,"a","a","b");
        
        int a = HoKhauService.themHoKhau(tmp);
    }
    
}
