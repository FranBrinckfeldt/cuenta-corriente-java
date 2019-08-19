/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Francisca
 */
public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        //Instancias de clase CuentaCorriente.
        CuentaCorriente cuenta1 = new CuentaCorriente("Francisca", 33);
        CuentaCorriente cuenta2 = new CuentaCorriente("Melanie", 67, 80000);
        CuentaCorriente cuenta3 = new CuentaCorriente("Camila", 80, 100000);

        int contador = 0;
        int continuar = 0;
        boolean error = false;

        do {
            contador++;
            System.out.println(" ");
            System.out.println("MOVIMIENTO " + contador);
            System.out.println(" ");
            System.out.println("Seleccione la cuenta");
            System.out.println("1: Francisca");
            System.out.println("2: Melanie");
            System.out.println("3: Camila");

            int cuenta = 0;

            do {
                try {
                    cuenta = leer.nextInt();
                    if(cuenta == 1 || cuenta == 2 || cuenta == 3) {
                        error = false;
                    } else {
                        System.out.println("Ingrese una opción válida");
                        error = true;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    error = true;
                    leer.next();
                }
            } while(error);

            CuentaCorriente cta = null;

            switch (cuenta) {
                case 1:
                    cta = cuenta1;
                    break;
                case 2:
                    cta = cuenta2;
                    break;
                case 3:
                    cta = cuenta3;
                    break;
            }

            System.out.println(" ");
            System.out.println("Seleccione tipo de movimiento");
            System.out.println("1: Abono.");
            System.out.println("2: Cargo.");

            int tipo = 0;

            do {
                try {
                    tipo = leer.nextInt();
                    if(tipo == 1 || tipo == 2) {
                        error = false;
                    } else {
                        System.out.println("Ingrese una opción válida");
                        error = true;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    error = true;
                    leer.next();
                }
            } while(error);

            int monto = 0;

            switch(tipo) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Ingrese el monto a abonar");
                    do {
                        try {
                            monto = leer.nextInt();
                            if(monto >= 0) {
                                error = false;
                            } else {
                                System.out.println("Ingrese un monto válido");
                                error = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Ingrese un monto válido");
                            error = true;
                            leer.next();
                        }
                    } while(error);
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Ingrese el monto a cargar");
                    do {
                        try {
                            monto = leer.nextInt();
                            if(monto >= 0) {
                                error = false;
                            } else {
                                System.out.println("Ingrese un monto válido");
                                error = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Ingrese un monto válido");
                            error = true;
                            leer.next();
                        }
                    } while(error);
                    break;
            }

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            Movimientos movimientos = new Movimientos(tipo, formatter.format(date), monto, cta);

            System.out.println(" ");
            System.out.println("¿Desea realizar más movimientos?: ");
            System.out.println("1: SI");
            System.out.println("2: NO");

            continuar = leer.nextInt();



        } while (continuar == 1);

        int opcion = 0;

        do {
            System.out.println(" ");
            System.out.println("¿Qué cuenta desea revisar?: ");
            System.out.println("1: Francisca");
            System.out.println("2: Melanie");
            System.out.println("3: Camila");
            System.out.println("0: SALIR");

            do {
                try {
                    opcion = leer.nextInt();
                    if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 0) {
                        error = false;
                    } else {
                        System.out.println("Ingrese una opción válida");
                        error = true;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    error = true;
                    leer.next();
                }
            } while(error);

            switch (opcion) {
                case 1:
                    System.out.println(" ");
                    System.out.println(cuenta1.toString());
                    System.out.println(" ");
                    if (cuenta1.getMovimientos().size() < 10){
                        cuenta1.obtenerMovimientos();
                    } else {
                        cuenta1.obtener10Movimientos();
                    }
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println(cuenta2.toString());
                    System.out.println(" ");
                    if (cuenta2.getMovimientos().size() < 10){
                        cuenta2.obtenerMovimientos();
                    } else {
                        cuenta2.obtener10Movimientos();
                    }
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println(cuenta3.toString());
                    System.out.println(" ");
                    if (cuenta3.getMovimientos().size() < 10){
                        cuenta3.obtenerMovimientos();
                    } else {
                        cuenta3.obtener10Movimientos();
                    }
                    break;
            }
        } while (opcion != 0);
    }
}
