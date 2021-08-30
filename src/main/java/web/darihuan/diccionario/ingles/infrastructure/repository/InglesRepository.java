package web.darihuan.diccionario.ingles.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.darihuan.diccionario.ingles.domain.Ingles;

import java.util.Optional;

@Repository
public interface InglesRepository extends JpaRepository<Ingles, Integer> {

    Optional<Ingles> findByPalabra(String palabra);

    boolean existsByPalabra(String palabra);
}
