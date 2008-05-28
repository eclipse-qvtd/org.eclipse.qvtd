package org.eclipse.qvt.declarative.compilation;

import java.util.Map;

import org.eclipse.qvt.declarative.common.Provider;

public interface CompilationProvider extends Provider{
	
	public String getName ();
	public Object compile (Object source, Map<String, String> parameters);

}
