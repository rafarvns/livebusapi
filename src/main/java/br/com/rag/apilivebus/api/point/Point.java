package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.abstraction.AbstractEntity;
import br.com.rag.apilivebus.api.line.Line;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "POINT")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Point extends AbstractEntity {

    @Column(unique = true)
    @NotNull(message = "MarkerId é obrigatório!")
    @NotEmpty(message = "MarkerId é obrigatório!")
    @NotBlank(message = "MarkerId é obrigatório!")
    @Size(max=5, message = "MarkerId não pode possuir mais de 5 caracteres!")
    private String markerId;

    @Column
    @NotNull(message = "Latitude é obrigatória!")
    private BigDecimal latitude;

    @Column
    @NotNull(message = "Longitude é obrigatória!")
    private BigDecimal longitude;

    @Column
    @NotNull(message = "Título é obrigatório!")
    @NotEmpty(message = "Título é obrigatório!")
    @NotBlank(message = "Título é obrigatório!")
    @Size(max=40, message = "Título não pode possuir mais de 40 caracteres!")
    private String title;

    @Column
    @NotNull(message = "Descrição é obrigatório!")
    @NotEmpty(message = "Descrição é obrigatório!")
    @NotBlank(message = "Descrição é obrigatório!")
    @Size(max=200, message = "Descrição não pode possuir mais de 200 caracteres!")
    private String snippets;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private PointType pointType;

    @Column
    @NotNull(message = "Caminho do ícone é obrigatório!")
    @NotEmpty(message = "Caminho do ícone é obrigatório!")
    @NotBlank(message = "Caminho do ícone é obrigatório!")
    @Size(max=100, message = "Caminho do ícone não pode possuir mais de 100 caracteres!")
    private String iconPath;

    @Column
    @NotNull(message = "Tamanho do ícone é obrigatório!")
    @Positive(message = "Tamanho do ícone precisa ser positivo!")
    private Long iconSize;

    @ManyToMany(mappedBy="points", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Line> lines;
}
