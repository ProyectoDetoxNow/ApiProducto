package cl.detoxnow.Inventario.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cl.detoxnow.Inventario.Model.Inventario;
import cl.detoxnow.Inventario.Repository.InventarioRepository;
import jakarta.transaction.Transactional;

@Service
public class InventarioService {
    
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario getInventarioId(int id) {
    return inventarioRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventario no encontrado con ID " + id));
    }

  @Transactional
public Inventario updateInventario(int id, Inventario inventario) {
    Inventario existing = inventarioRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventario no encontrado con ID " + id));

    // Aquí actualizas los campos necesarios
    existing.setNombreProducto(inventario.getNombreProducto());
    existing.setDescripcion(inventario.getDescripcion());
    existing.setCategoria(inventario.getCategoria());
    existing.setPrecio(inventario.getPrecio());
    existing.setCantidad(inventario.getCantidad());
    existing.setImagen(inventario.getImagen());
    
    return inventarioRepository.save(existing);
}

    public String deleteInventario(int id) {
        inventarioRepository.deleteById(id);
        return "El producto con id " + id + " ha sido eliminado";
    }





}
