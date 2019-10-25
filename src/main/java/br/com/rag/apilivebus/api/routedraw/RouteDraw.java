package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.line.Line;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ROUTE_DRAW")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class RouteDraw extends AbstractEntity {

    @Column
    @NotNull(message = "Latitude é obrigatória!")
    private BigDecimal latitude;

    @Column
    @NotNull(message = "Longitude é obrigatória!")
    private BigDecimal longitude;

    @Column
    @NotNull(message = "Indexação é obrigatória!")
    private Integer index;

    @ManyToOne
    @JoinColumn(name = "LINE", referencedColumnName = "ID")
    private Line line;

}
