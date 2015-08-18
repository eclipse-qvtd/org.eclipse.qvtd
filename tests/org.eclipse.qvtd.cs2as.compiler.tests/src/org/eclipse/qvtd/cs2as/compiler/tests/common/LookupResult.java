package org.eclipse.qvtd.cs2as.compiler.tests.common;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface LookupResult<NE> {
	
	@Nullable
	NE getSingleResult();
	
	@NonNull
	List<NE> getAllResult();
	
	int size();
}
