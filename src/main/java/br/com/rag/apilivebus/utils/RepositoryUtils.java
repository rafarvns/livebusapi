package br.com.rag.apilivebus.utils;

import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

public class RepositoryUtils {
	
	public static String ignoreAccentsTemplate = "lower(translate({0}, 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'aaaaaaaaeeeeiioooooouuuucc'))";
	
	public static BooleanExpression getStringContainsIgnoreCaseAndAccents(StringPath path, String stringToVerify) {
		return Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, path)
			.contains(Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, stringToVerify));
	}
	
	public static BooleanExpression getStringStartWithIgnoreCaseAndAccents(StringPath path, String stringToVerify) {
		return Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, path)
			.startsWith(Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, stringToVerify));
	}
	
	public static Predicate between(Object value, NumberPath<?> path1, NumberPath<?> path2) {
		return Expressions.booleanOperation(Ops.BETWEEN, Expressions.constant(value), path1, path2);
	}
	
	public static Predicate between(Object value, Object initialValue, NumberPath<?> finalValue) {
		return Expressions
			.booleanOperation(Ops.BETWEEN, Expressions.constant(value), Expressions.constant(initialValue), finalValue);
	}
	
	public static Predicate between(Object value, NumberPath<?> initialValue, Object finalValue) {
		return Expressions
			.booleanOperation(Ops.BETWEEN, Expressions.constant(value), initialValue, Expressions.constant(finalValue));
	}
}
