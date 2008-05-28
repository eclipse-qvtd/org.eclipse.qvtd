package org.eclipse.qvt.declarative.compilation;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.qvt.declarative.common.Operation;
import org.eclipse.qvt.declarative.common.Provider;

public class CompileOperation implements Operation {
	
	protected Object source;
	protected Map<String, String> parameters;
	
	public CompileOperation(IAdaptable source, Map<String, String> parameters) {
		this.source = source;
		this.parameters = parameters;
	}

	@Override
	public Object execute(Provider provider) {
		Object result = null;
		if (provider instanceof CompilationProvider) {
			CompilationProvider compilationProvider = (CompilationProvider) provider;
			result = compilationProvider.compile(source, parameters);
		}
		return result;
	}

	public Object getSource() {
		return source;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

}
