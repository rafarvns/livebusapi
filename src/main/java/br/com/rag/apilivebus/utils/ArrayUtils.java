package br.com.rag.apilivebus.utils;

import java.util.Optional;
import java.util.function.Predicate;

public class ArrayUtils {

	public static <T> Optional<T> get(T[] array, int pos) {
		if (ArrayUtils.arrayPositionIsEmpty(array, pos))
			return Optional.empty();
		else
			return Optional.of(array[pos]);
	}

	public static <T> Optional<T> get(T[] array, int pos, Predicate<T> filter) {
		if (ArrayUtils.arrayPositionIsEmpty(array, pos))
			return Optional.empty();
		else
			return Optional.of(array[pos]).filter(filter);
	}

	public static boolean arrayIsEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	public static boolean arrayPositionIsEmpty(Object[] array, int pos) {
		return ArrayUtils.arrayIsEmpty(array) || array.length <= pos;
	}

	public static boolean hasPosition(Object[] array, int pos) {
		return array != null && array.length > pos;
	}
}
