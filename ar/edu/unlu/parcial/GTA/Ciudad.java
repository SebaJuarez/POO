package ar.edu.unlu.parcial.GTA;

import java.util.ArrayList;

public class Ciudad {

    public ArrayList<Propiedad> propiedades = new ArrayList<>();

    public void main(String[] args) {
        // instancio las propiedades
        Propiedad auto1 = new Auto(100, "marca1", "rojo", 4, "1");
        propiedades.add(auto1);
        Propiedad auto2 = new Auto(100, "marca2", "blanco", 3, "2");
        propiedades.add(auto2);
        Propiedad auto3 = new Auto(100, "marca3", "azul", 2, "3");
        propiedades.add(auto3);
        Propiedad auto4 = new Auto(100, "marca4", "negro", 1, "4");
        propiedades.add(auto4);
        Propiedad casa1 = new Inmueble(100, 1);
        propiedades.add(casa1);
        Propiedad casa2 = new Inmueble(200, 2);
        propiedades.add(casa2);
        // ---------------------------------------------------------------

        Handy handyPolicial = new Handy();
        
        TommyVercetti tommy = new TommyVercetti(this);
        tommy.setHandy(handyPolicial);

        Carl carl = new Carl(this);
        carl.agregarPropiedad(auto1);
        carl.agregarPropiedad(auto2);
        carl.agregarPropiedad(auto3);
        carl.agregarPropiedad(auto4);

        // no hay espacio (no tiene casa)
        System.out.println(carl.buscarAuto(tommy));
        System.out.println(tommy.getEfectivo());

        // REFACTOR HASTA ACA
        // DOY VUELTA LAS RESPONSABILIDADES

        // no hay dinero (no tiene efectivo)
        System.out.println(tommy.comprarInmueble(casa1));
        System.out.println(tommy.getEfectivo());

        tommy.cobrarDinero(400); // cargo 200 pesos

        // compra correcta
        System.out.println(tommy.comprarInmueble(casa1)); // 95 capital
        System.out.println(tommy.getEfectivo());

        // compra correcta
        System.out.println(tommy.solicitarAuto(carl)); // 80 capital
        System.out.println(tommy.getEfectivo());

        // no hay espacio (la primer casa solo tiene lugar para un auto)
        System.out.println(tommy.solicitarAuto(carl));
        System.out.println(tommy.getEfectivo());

        // compra correcta
        System.out.println(tommy.comprarInmueble(casa2)); // 190 capital
        System.out.println(tommy.getEfectivo());

        // no hay dinero disponible (400 - 100 - 100 - 200 = 0)
        System.out.println(tommy.solicitarAuto(carl));
        System.out.println(tommy.getEfectivo());

        tommy.cobrarDinero(400); // cargo 400 pesos
        System.out.println(tommy.getEfectivo());

        // no se encontro auto requerido
        System.out.println(tommy.solicitarAuto(carl, 7, "rojo", "marca1"));

        // compra correcta (incorrecta si es que ya me lo vendio antes)
        System.out.println(tommy.solicitarAuto(carl, 4, "rojo", "marca1")); // 10 pesos (robado)
        System.out.println(tommy.getEfectivo()); // 100 pesos porque son 200 de los requerimientos y 100 del auto

        // tenemos 375 pesos de capital
        handyPolicial.declararRobado("1");
        System.out.println(tommy.calcularCapital());

    }

}
