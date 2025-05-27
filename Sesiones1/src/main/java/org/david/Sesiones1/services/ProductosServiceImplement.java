package org.david.Sesiones1.services;

import org.david.Sesiones1.models.Productos;

import java.util.Arrays;
import java.util.List;
// Implementación de la interfaz ProductoService
public class ProductosServiceImplement implements ProductoService {

    @Override
    public List<Productos> listar() {
        // Retorna una lista inmutable con tres productos de ejemplo
        return Arrays.asList(new Productos(1L, "laptop", "computacion", 523.21),
                new Productos(2L, "Mouse", "inalambrico", 15.25),
                new Productos(3L, "Impresora", "tinta continua", 256.25));
    }
}