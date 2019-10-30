package br.com.rag.apilivebus.abstraction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
