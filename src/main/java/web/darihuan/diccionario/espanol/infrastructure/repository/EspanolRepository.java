package web.darihuan.diccionario.espanol.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.darihuan.diccionario.espanol.domain.Espanol;

import java.util.Optional;

@Repository
public interface EspanolRepository extends JpaRepository<Espanol, Integer> {

    Optional<Espanol> findByPalabra(String palabra);

    boolean existsByPalabra(String palabra);


}
