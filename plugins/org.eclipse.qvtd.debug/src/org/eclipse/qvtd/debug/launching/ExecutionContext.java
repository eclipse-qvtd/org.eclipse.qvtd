package org.eclipse.qvtd.debug.launching;

import java.util.List;

import org.eclipse.ocl.examples.debug.utils.Log;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EvaluationMonitor;

public interface ExecutionContext {

	Log getLog();

	EvaluationMonitor getMonitor();

	List<String> getConfigPropertyNames();

	String getConfigProperty(String key);

}
