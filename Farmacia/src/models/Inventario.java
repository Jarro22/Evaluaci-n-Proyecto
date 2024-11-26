package models;

import java.time.LocalDate;

public class Inventario {
    private int inventarioId;
    private int productoId;
    private int cantidad;
    private LocalDate fechaActualizacion;

    public Inventario(int inventarioId, int productoId, int cantidad, LocalDate fechaActualizacion) {
        this.inventarioId = inventarioId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(int inventarioId) {
        this.inventarioId = inventarioId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
