package org.eclipse.qvt.declarative.compilation.ide;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.qvt.declarative.compilation.CompilationService;
import org.eclipse.qvt.declarative.core.ide.EclipseServiceConfiguator;

public class EclipseCompilationServiceConfigurator extends EclipseServiceConfiguator{
	
	private final static Map<String, String> parameters = new HashMap<String, String>();
	
	static {
		parameters.put(NAMESPACE, org.eclipse.qvt.declarative.compilation.ide.Activator.PLUGIN_ID);
		parameters.put(EXTENSION_POINT_NAME, "compilationProvider"); //$NON-NLS-1$
	}
	
	public EclipseCompilationServiceConfigurator() {
		super(CompilationService.getInstance(), parameters);
	}
	
}
