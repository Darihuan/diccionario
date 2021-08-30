package web.darihuan.diccionario.espanol.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import web.darihuan.diccionario.ingles.domain.Ingles;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "espanol")
@Data
@NoArgsConstructor
public class Espanol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "palabra", nullable = false, unique = true)
    String palabra;

    @Column(name = "descripcion", nullable = false)
    String descripcion;

    @OneToMany(mappedBy = "palabraEspanol", orphanRemoval = true, cascade = CascadeType.REMOVE)
    List<Ingles> palabrasIngles;

    @Column(name = "fecha_alta")
    Date fechaAlta;

    @Column(name = "fecha_modif")
    @Temporal(TemporalType.DATE)
    Date fecha_modif;


}
