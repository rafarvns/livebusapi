package br.com.rag.apilivebus.abstraction;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AbstractDTO implements Serializable {

    private Long id;

    public AbstractDTO(Long id) {
        this.id = id;
    }
}
