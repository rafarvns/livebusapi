package br.com.rag.apilivebus.abstraction;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collections;
import java.util.List;

public abstract class QueryDslSupport extends QuerydslRepositorySupport {
	
	private final Class<?> domainClass;

	public QueryDslSupport(Class<?> domainClass) {
		super(domainClass);
		this.domainClass = domainClass;
	}
	
	protected Page readPage(JPAQuery query, Pageable pageable, Long total) {
		if (pageable == null)
			return readPage(query, new QPageRequest(0, Integer.MAX_VALUE));

		if (total == null)
			total = query.clone(super.getEntityManager()).fetchCount();

		JPQLQuery pagedQuery = getQuerydsl().applyPagination(pageable, query);
		List      content    = total > pageable.getOffset() ? pagedQuery.fetch() : Collections.emptyList();
		return new PageImpl<>(content, pageable, total);
	}

	protected Page readPage(JPAQuery query, Pageable pageable) {
		return readPage(query, pageable, null);
	}

	protected Page readPageWithGroup(JPAQuery query, Pageable pageable, long total) {
		if (pageable == null) {
			return readPage(query, new QPageRequest(0, Integer.MAX_VALUE));
		}
		JPQLQuery pagedQuery = getQuerydsl().applyPagination(pageable, query);
		List      content    = total > pageable.getOffset() ? pagedQuery.fetch() : Collections.emptyList();
		return new PageImpl<>(content, pageable, total);
	}

}
