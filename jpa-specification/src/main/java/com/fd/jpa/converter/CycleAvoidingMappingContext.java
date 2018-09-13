package com.fd.jpa.converter;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author furkan.danismaz
 * 10/09/2018 15:57
 */
public class CycleAvoidingMappingContext {

	/** The known instances. */
	private Map<Object, Object> knownInstances = new IdentityHashMap<>();

	/**
	 * Gets the mapped instance.
	 *
	 * @param <T>
	 *            the generic type
	 * @param source
	 *            the source
	 * @param targetType
	 *            the target type
	 * @return the mapped instance
	 */
	@SuppressWarnings("unchecked")
	@BeforeMapping
	public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
		return (T) knownInstances.get(source);
	}

	/**
	 * Store mapped instance.
	 *
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 */
	@BeforeMapping
	public void storeMappedInstance(Object source, @MappingTarget Object target) {
		knownInstances.put(source, target);
	}

}
