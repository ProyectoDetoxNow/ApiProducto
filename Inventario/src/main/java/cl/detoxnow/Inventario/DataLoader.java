package cl.detoxnow.Inventario;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cl.detoxnow.Inventario.Model.Inventario;
import cl.detoxnow.Inventario.Repository.InventarioRepository;
import net.datafaker.Faker;

@Profile("dont_run") 
@Component
public class DataLoader implements CommandLineRunner {

    // Inyección del repositorio
    private final InventarioRepository inventarioRepository;

    @Autowired
    public DataLoader(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Inventario inventario = new Inventario();
            inventario.setNombreProducto(faker.commerce().productName());
            inventario.setPrecio(random.nextDouble() * 100);
            inventario.setCantidad(random.nextInt(100));

            // guardar el inventario en la base de datos
            inventarioRepository.save(inventario);
        }
    }
}