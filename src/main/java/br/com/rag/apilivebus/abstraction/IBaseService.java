package br.com.rag.apilivebus.abstraction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IBaseService<T> {
	
	Page<T> findAll(Pageable pageable);
	
	Optional<T> findOne(Long id);

	@Transactional
	T insert(T entity);
	
	T update(T entity);
	
	void remove(T entity);
	
	void removeByID(Long id);
}
