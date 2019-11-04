package br.com.rag.apilivebus.api.live;

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
@Table(name = "LIVE")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Live extends AbstractEntity {

    @Column(precision = 19, scale = 6)
    @NotNull(message = "Latitude é obrigatória!")
    private BigDecimal latitude;

    @Column(precision = 19, scale = 6)
    @NotNull(message = "Longitude é obrigatória!")
    private BigDecimal longitude;

    @Column
    @NotNull(message = "Nível de confiança é obrigatório")
    private Long trustLevel;

    @ManyToOne
    @JoinColumn(name = "ID_LINE", referencedColumnName = "ID")
    private Line line;

}
