package org.tarea.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido
{
    //codigo---fecha pedido --nombre de cliente ---- producto -- unidades --- precio
    private int codigo;
    private Date fechaPedido;
    private String nombreCliente;
    private String producto;
    private int unidades;
    private double precio;

    public Pedido(int codigo, Date fechaPedido, String nombreCliente, String producto, int unidades, double precio) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.nombreCliente = nombreCliente;
        this.producto = producto;
        this.unidades = unidades;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaPedido() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(fechaPedido);
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String info() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", fechaPedido=" + this.getFechaPedido() +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", producto='" + producto + '\'' +
                ", unidades=" + unidades +
                ", precio=" + precio +
                '}';
    }
}//cierra clase Pedido
