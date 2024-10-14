package org.tarea.view;

import org.tarea.controller.PedidoController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//punto de entrada en programa Java - Thread principal
        //array de String args - argumentos de la línea de comandos
        if(args.length > 0) {
            System.out.println("Argumentos de la línea de comandos:");
            for(String arg : args) {
                System.out.println(arg);
            }
        }else{
            System.out.println("Proyecto de tarea de verano");
            System.out.println("Dime qué operación quieres realizar:");
            System.out.println("1. Listar pedidos");
            System.out.println("2. Añadir pedido");
            System.out.println("3. Modificar pedido");
            System.out.println("4. Eliminar pedido");
            System.out.println("5. Salir");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            //seguir pidiendo opciones hasta que pulsas 5
            PedidoController pedidoController = new PedidoController();
            while(opcion != 5){
                switch(opcion){
                    case 1:
                        pedidoController.listarPedidos();
                        break;
                    case 2:
                        pedidoController.anadirPedido();
                        break;
                    case 3:
                        pedidoController.modificarPedido();
                        break;
                    case 4:
                        pedidoController.eliminarPedido();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }//cierra switch
                System.out.println("Dime qué operación quieres realizar:");
                System.out.println("1. Listar pedidos");
                System.out.println("2. Añadir pedido");
                System.out.println("3. Modificar pedido");
                System.out.println("4. Eliminar pedido");
                System.out.println("5. Salir");
                opcion = scanner.nextInt();
            }//cierra while

        }//cierra else


    }//cierra main
}//cierra class Main
