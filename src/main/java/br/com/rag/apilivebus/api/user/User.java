package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.line.Line;
import br.com.rag.apilivebus.api.point.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "USER")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

    @Column
    private Boolean isConnected;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnect;

    @Column
    @NotNull(message = "Nome é obrigatório!")
    @NotEmpty(message = "Nome é obrigatório!")
    @NotBlank(message = "Nome é obrigatório!")
    @Size(max=20, message = "Nome não pode possuir mais de 20 caracteres!")
    private String name;

    @Column(precision = 19, scale = 6)
    @NotNull(message = "Latitude é obrigatória!")
    private BigDecimal latitude;

    @Column(precision = 19, scale = 6)
    @NotNull(message = "Longitude é obrigatória!")
    private BigDecimal longitude;

    @Column
    private Boolean isTraveling;

    @ManyToOne
    @JoinColumn(name = "WAITING_A_LINE", referencedColumnName = "ID")
    private Point waitingLine;

    @ManyToOne
    @JoinColumn(name = "ENTERED_THE_LINE", referencedColumnName = "ID")
    private Point enteredLine;

    @ManyToOne
    @JoinColumn(name = "POSSIBLE_LINE", referencedColumnName = "ID")
    private Line possibleLine;

    @ManyToOne
    @JoinColumn(name = "CONFIRMED_LINE", referencedColumnName = "ID")
    private Line confirmedLine;

}
