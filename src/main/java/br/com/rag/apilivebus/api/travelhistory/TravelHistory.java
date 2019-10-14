package br.com.rag.apilivebus.api.travelhistory;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.line.Line;
import br.com.rag.apilivebus.api.point.Point;
import br.com.rag.apilivebus.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TRAVEL_HISTORY")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class TravelHistory extends AbstractEntity {

    @Column
    @NotNull(message = "Data não pode ser nula!")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    @NotNull(message = "Horário de embarque não pode ser nulo!")
    @Temporal(TemporalType.TIME)
    private Date timeOfBoarding;

    @Column
    @NotNull(message = "Horário de demembarque não pode ser nulo!")
    @Temporal(TemporalType.TIME)
    private Date timeOfLanding;

    @NotNull(message = "Usuário não pode ser nulo!")
    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private User user;

    @NotNull(message = "Linha não pode ser nula!")
    @ManyToOne
    @JoinColumn(name = "ID_LINE", referencedColumnName = "ID")
    private Line line;

    @NotNull(message = "Ponto de embarque não pode ser nulo!")
    @ManyToOne
    @JoinColumn(name = "BOARDING", referencedColumnName = "ID")
    private Point boarding;

    @NotNull(message = "Ponto de desembarque não pode ser nulo!")
    @ManyToOne
    @JoinColumn(name = "LANDING", referencedColumnName = "ID")
    private Point landing;
}
