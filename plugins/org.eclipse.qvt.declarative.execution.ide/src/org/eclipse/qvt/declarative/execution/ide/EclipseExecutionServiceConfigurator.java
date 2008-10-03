package org.eclipse.qvt.declarative.execution.ide;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.qvt.declarative.core.ide.EclipseServiceConfiguator;
import org.eclipse.qvt.declarative.execution.ExecutionService;

public class EclipseExecutionServiceConfigurator extends
		EclipseServiceConfiguator {
	
	private final static Map<String, String> parameters = new HashMap<String, String>();
	
	static {
		parameters.put(NAMESPACE, org.eclipse.qvt.declarative.execution.ide.Activator.PLUGIN_ID);
		parameters.put(EXTENSION_POINT_NAME, "executionProvider"); //$NON-NLS-1$
	}
	
	public EclipseExecutionServiceConfigurator(){
		super(ExecutionService.getInstance(), parameters);
	}
}
