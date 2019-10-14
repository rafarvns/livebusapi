package br.com.rag.apilivebus.api.route;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.line.Line;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ROUTE")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Route extends AbstractEntity {

    @Column
    @NotNull(message = "Latitude é obrigatória!")
    private BigDecimal latitude;

    @Column
    @NotNull(message = "Longitude é obrigatória!")
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "ID_LINE", referencedColumnName = "ID")
    @NotNull(message = "Linha é obrigatório!")
    private Line line;
}
