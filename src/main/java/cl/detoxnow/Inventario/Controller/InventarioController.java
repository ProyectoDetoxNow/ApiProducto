package cl.detoxnow.Inventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.detoxnow.Inventario.Model.Inventario;
import cl.detoxnow.Inventario.Service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Api/v1/inventario")
@Tag(name = "Inventario", description = "Operaciones relacionadas con productos del inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // LISTAR INVENTARIO
    @Operation(
        summary = "Listar todos los productos",
        description = "Devuelve una lista completa del inventario disponible."
    )
    @ApiResponse(responseCode = "200", description = "Inventario obtenido correctamente")
    @GetMapping
    public List<Inventario> getInventarios() {
        return inventarioService.getInventarios();
    }

    // CREAR PRODUCTO
    @Operation(
        summary = "Crear producto",
        description = "Registra un nuevo producto en el inventario."
    )
    @ApiResponse(responseCode = "200", description = "Producto creado correctamente")
    @PostMapping
    public Inventario saveInventario(
        @RequestBody(description = "Datos del producto a registrar")
        @org.springframework.web.bind.annotation.RequestBody Inventario inventario
    ) {
        return inventarioService.saveInventario(inventario);
    }

    // OBTENER PRODUCTO POR ID
    @Operation(
        summary = "Obtener producto por ID",
        description = "Retorna un producto específico según su ID."
    )
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @GetMapping("/{id}")
    public Inventario getInventarioId(
        @Parameter(description = "ID del producto a consultar")
        @PathVariable("id") int id
    ) {
        return inventarioService.getInventarioId(id);
    }

    // ACTUALIZAR PRODUCTO
    @Operation(
        summary = "Actualizar producto",
        description = "Actualiza los datos del producto especificado por su ID."
    )
    @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente")
    @PutMapping("/{id}")
    public Inventario updateInventario(
        @Parameter(description = "ID del producto a actualizar")
        @PathVariable("id") int id,

        @RequestBody(description = "Nuevos datos del producto")
        @org.springframework.web.bind.annotation.RequestBody Inventario inventario
    ) {
        return inventarioService.updateInventario(id, inventario);
    }

    // DESCONTAR STOCK
    @Operation(
        summary = "Descontar stock",
        description = "Reduce la cantidad disponible del producto indicado."
    )
    @ApiResponse(responseCode = "200", description = "Stock descontado correctamente")
    @PutMapping("/descontar/{id}/{cantidad}")
    public Inventario descontarStock(
        @Parameter(description = "ID del producto")
        @PathVariable int id,

        @Parameter(description = "Cantidad a descontar")
        @PathVariable int cantidad
    ) {
        return inventarioService.descontarStock(id, cantidad);
    }

    // ELIMINAR PRODUCTO
    @Operation(
        summary = "Eliminar producto",
        description = "Elimina un producto del inventario."
    )
    @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente")
    @DeleteMapping("/{id}")
    public String deleteInventario(
        @Parameter(description = "ID del producto a eliminar")
        @PathVariable("id") int id
    ) {
        return inventarioService.deleteInventario(id);
    }

}