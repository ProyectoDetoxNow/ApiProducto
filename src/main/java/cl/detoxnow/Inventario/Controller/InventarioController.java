package cl.detoxnow.Inventario.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.detoxnow.Inventario.Model.Inventario;
import cl.detoxnow.Inventario.Service.InventarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Api/v1/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> getInventarios() {
        return inventarioService.getInventarios();
    }

    @PostMapping
    public Inventario saveInventario(@RequestBody Inventario inventario) {
        return inventarioService.saveInventario(inventario);
    }

    @GetMapping("/{id}")
    public Inventario getInventarioId(@PathVariable("id") int id) {
        return inventarioService.getInventarioId(id);
    }
    @PutMapping("/{id}")
    public Inventario updateInventario(@PathVariable("id") int id, @RequestBody Inventario inventario) {
        return inventarioService.updateInventario(id, inventario);
    }

    @PutMapping("/descontar/{id}/{cantidad}")
    public Inventario descontarStock(
        @PathVariable int id,
        @PathVariable int cantidad) {
        return inventarioService.descontarStock(id, cantidad);
    }

    @DeleteMapping("/{id}")
    public String deleteInventario(@PathVariable("id") int id) {
        return inventarioService.deleteInventario(id);
    }

}
