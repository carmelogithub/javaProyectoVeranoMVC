package org.tarea.controller;

import org.tarea.model.Pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PedidoController {
    List<Pedido> pedidos = new ArrayList<>();

    public void listarPedidos() {
        System.out.println("Listar pedidos");
       for(Pedido pedido: pedidos){
             // System.out.println(pedido);
           System.out.println(pedido.info());

                System.out.println("-----------------------");
       }
    }

    public void anadirPedido() {
        System.out.println("Añadir pedido");
        System.out.println("dime el código del pedido");
        Scanner scanner = new Scanner(System.in);
        int codigo= scanner.nextInt();

        System.out.println("dime el nombre de cliente");
        Scanner scanner2 = new Scanner(System.in);
        String cliente= scanner2.nextLine();
        System.out.println("dime el producto");
        Scanner scanner3 = new Scanner(System.in);
        String producto= scanner3.nextLine();//permite almacenar como producto una fila completa, no sólo una palabra
        System.out.println("dime las unidades");
        int unidades=0;
        try{
            Scanner scanner4 = new Scanner(System.in);
            unidades=scanner4.nextInt();
        }
        catch(Exception e){
            System.out.println("Las unidades deben ser número entero");
            return;
        }

        System.out.println("dime el precio");
        Scanner scanner5 = new Scanner(System.in);
        double precio=scanner5.nextDouble();

        Pedido pedido= new Pedido(codigo, new Date(), cliente, producto, unidades, precio);
        pedidos.add(pedido);//añadir pedido a la lista de pedidos
        System.out.println("Pedido añadido: "+pedido.getCodigo());

        //configurar la conexión con Mysql y insertar en la tabla pedidos
        Connection conn = null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendajava","root","");
            String sql = "INSERT INTO pedidos (codigo,fecha,cliente,producto,unidades,precio) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,pedido.getCodigo());
            ps.setString(2,pedido.getFechaPedido());
            ps.setString(3,pedido.getNombreCliente());
            ps.setString(4,pedido.getProducto());
            ps.setInt(5,pedido.getUnidades());
            ps.setDouble(6,pedido.getPrecio());
            int nuevo_pedido=ps.executeUpdate();
            System.out.println("Nuevo pedido: "+nuevo_pedido);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//cierra catch
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }//cierra finally


    }//cierra añadir

    public void modificarPedido() {
        System.out.println("Modificar pedido las unidades del pedido");
        System.out.println("dime el código del pedido");
        Scanner scanner = new Scanner(System.in);
        int codigo= scanner.nextInt();
        for(Pedido pedido: pedidos){
            if(pedido.getCodigo()==codigo){
                System.out.println("dime las nuevas unidades");
                int unidades=scanner.nextInt();
                pedido.setUnidades(unidades);
                System.out.println("Pedido modificado: "+pedido.getCodigo());
                break;
            }
        }
    }//cierra modificar

    public void eliminarPedido() {
        System.out.println("Eliminar pedido");
        System.out.println("dime el código del pedido");
        Scanner scanner = new Scanner(System.in);
        int codigo= scanner.nextInt();
        for(Pedido pedido: pedidos){
            if(pedido.getCodigo()==codigo) {
                System.out.println("¿estás seguro de eliminar definitivamente? (Y/n)");
                String opcion = scanner.next();
                if (opcion.equalsIgnoreCase("Y")) {
                    pedidos.remove(pedido);
                    System.out.println("Pedido eliminado: " + pedido.getCodigo());
                    break;
                }//cierra if
                else {
                    System.out.println("Pedido no eliminado: " + pedido.getCodigo());
                    break;
                }//cierra else
            }//cierra if
        }//cierra for
    }//cierra eliminar
}//cierra class PedidoController
