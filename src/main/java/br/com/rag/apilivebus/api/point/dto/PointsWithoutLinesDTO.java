package br.com.rag.apilivebus.api.point.dto;

import br.com.rag.apilivebus.abstraction.AbstractDTO;
import br.com.rag.apilivebus.api.point.PointType;
import br.com.rag.apilivebus.api.point.QPoint;
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
public class PointsWithoutLinesDTO extends AbstractDTO {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String title;
    private String snippets;
    private PointType pointType;

    @Builder
    @QueryProjection
    public PointsWithoutLinesDTO(
            Long id,
            BigDecimal latitude,
            BigDecimal longitude,
            String title,
            String snippets,
            PointType pointType) {
        super(id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.snippets = snippets;
        this.pointType = pointType;
    }

    public static ConstructorExpression<PointsWithoutLinesDTO> constructor(QPoint point) {
        return new QPointsWithoutLinesDTO(
                point.id,
                point.latitude,
                point.longitude,
                point.title,
                point.snippets,
                point.pointType
        );
    }

}
