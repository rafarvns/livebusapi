package br.com.rag.apilivebus.abstraction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public abstract class AbstractService<T extends AbstractEntity> implements IBaseService<T> {
	
	private final IBaseRepository<T> repository;
	
	public AbstractService(IBaseRepository<T> repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<T> findOne(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Override
	public T insert(T entity) {
		return repository.saveAndFlush(entity);
	}
	
	@Override
	public T update(T entity) {
		return repository.save(entity);
	}
	
	@Override
	public void remove(T entity) {
		repository.delete(entity);
	}
	
	@Override
	public void removeByIDO(Long id) {
		repository.deleteById(id);
	}


}
