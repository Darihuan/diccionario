package web.darihuan.diccionario.ingles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.darihuan.diccionario.espanol.domain.Espanol;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "palabra", nullable = false, unique = true)
    String palabra;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "palabraEspanol")
    Espanol palabraEspanol;

    @Column(name = "fecha_alta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date fechaAlta;

    @Column(name = "fecha_modif")
    @Temporal(TemporalType.DATE)
    Date fechaModif;


}
