package br.com.rag.apilivebus.api.line;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.point.Point;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LINE")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "points"})
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

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="lines_points",
                joinColumns={@JoinColumn(name="line_id")},
                inverseJoinColumns={@JoinColumn(name="point_id")})
    private Set<Point> points;

    public Line(Long id, Long number, String name, Set<Point> points) {
        super(id);
        this.number = number;
        this.name = name;
        this.points = points;
    }
}
