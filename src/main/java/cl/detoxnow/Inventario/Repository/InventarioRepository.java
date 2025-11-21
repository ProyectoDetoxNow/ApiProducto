package cl.detoxnow.Inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.detoxnow.Inventario.Model.Inventario;


@Repository
public interface  InventarioRepository extends JpaRepository<Inventario, Integer> {

}
