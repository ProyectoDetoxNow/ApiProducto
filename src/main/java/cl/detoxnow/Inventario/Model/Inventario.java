package cl.detoxnow.Inventario.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;      
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_producto", length=100, unique=true, nullable=false)
    private String nombreProducto;

    @Column(name = "descripcion", length=500, nullable=false)
    private String descripcion;

    @Column(name = "categoria", length=255, nullable=false)
    private String categoria;

    @Column(name = "precio", length=5, nullable=false)
    private double precio;

    @Column(name = "cantidad", length=5, nullable=false)
    private int cantidad;

    @Column(name = "imagen", length = 255)
    private String imagen;

}
