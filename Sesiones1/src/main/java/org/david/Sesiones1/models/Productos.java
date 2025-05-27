package org.david.Sesiones1.models;

// Clase que representa un producto con sus atributos básicos
public class Productos {
    // Identificador único del producto
    private Long id;
    // Nombre del producto
    private String nombre;
    // Tipo o categoría del producto
    private String tipo;
    // Precio del producto
    private double precio;

    // Constructor vacío necesario para algunos frameworks o serialización
    public Productos() {
    }

    // Constructor con parámetros para crear un producto completo
    public Productos(Long id, String nombre, String tipo, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Método getter para obtener el ID del producto
    public Long getId() {
        return id;
    }

    // Método setter para establecer el ID del producto
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método setter para asignar el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el tipo de producto
    public String getTipo() {
        return tipo;
    }

    // Método setter para asignar el tipo de producto
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método getter para obtener el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Método setter para asignar el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}