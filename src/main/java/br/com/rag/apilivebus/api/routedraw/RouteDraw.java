package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.line.Line;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "ROUTE_DRAW")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class RouteDraw extends AbstractEntity {

    @Column(precision = 19, scale = 6)
    @NotNull(message = "Latitude é obrigatória!")
    private BigDecimal latitude;

    @Column(precision = 19, scale = 6)
    @NotNull(message = "Longitude é obrigatória!")
    private BigDecimal longitude;

    @Column(name = "index_pos")
    @NotNull(message = "Indexação é obrigatória!")
    @Positive(message = "Indexação precisa ser positiva!")
    private Long indexPos;

    @ManyToOne
    @JoinColumn(name = "ID_LINE", referencedColumnName = "ID")
    @NotNull(message = "Linha é obrigatório!")
    private Line line;

}
