package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

public interface MultiValueKey<K, T> {

	@NonNull
	K get(int index);

	@NonNull
	K[] get();
	
	List<T> getKeyIds();

	int size();

}