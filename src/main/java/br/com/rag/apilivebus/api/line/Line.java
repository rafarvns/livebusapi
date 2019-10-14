package br.com.rag.apilivebus.api.line;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.point.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "LINE")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Line extends AbstractEntity {

    @Column(unique = true)
    @NotNull(message = "Número é obrigatório!")
    @Positive(message = "Número precisa ser positivo!")
    private Long number;

    @Column
    @NotNull(message = "Nome é obrigatório!")
    @NotEmpty(message = "Nome é obrigatório!")
    @NotBlank(message = "Nome é obrigatório!")
    @Size(max=60, message = "Nome não pode possuir mais de 60 caracteres!")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="lines_points",
                joinColumns={@JoinColumn(name="line_id")},
                inverseJoinColumns={@JoinColumn(name="point_id")})
    private List<Point> points;

}
