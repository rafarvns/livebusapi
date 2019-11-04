package br.com.rag.apilivebus.api.live.dto;

import br.com.rag.apilivebus.abstraction.AbstractDTO;
import br.com.rag.apilivebus.api.live.QLive;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ConstructorExpression;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class LiveSummaryDTO extends AbstractDTO {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private Long trustLevel;

    @Builder
    @QueryProjection
    public LiveSummaryDTO(
            BigDecimal latitude,
            BigDecimal longitude,
            Long trustLevel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.trustLevel = trustLevel;
    }

    public static ConstructorExpression<LiveSummaryDTO> constructor(QLive live) {
        return new QLiveSummaryDTO(
                live.latitude,
                live.longitude,
                live.trustLevel
        );
    }

}
