package org.eclipse.qvtd.cs2as.compiler.tests.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class LookupResultImpl<NE> implements LookupResult<NE> {
	
	private List<NE> results = new ArrayList<NE>();
	
	public LookupResultImpl(List<NE> results){
		this.results.addAll(results);
	}
	
	@Override
	@NonNull
	public List<NE> getAllResult() {
		return Collections.unmodifiableList(results);
	}
	
	@Override
	@Nullable
	public NE getSingleResult() {
		return results.size() == 0 ? null : results.get(0);
	}
	
	@Override
	public int size() {
		return results.size();
	}
}