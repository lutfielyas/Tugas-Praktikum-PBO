package PesanMakanan;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MVC {
    ViewPesanan view = new ViewPesanan();
    ModelPesanan model = new ModelPesanan();
    ControllerPesanan controller = new ControllerPesanan(model, view);
}
