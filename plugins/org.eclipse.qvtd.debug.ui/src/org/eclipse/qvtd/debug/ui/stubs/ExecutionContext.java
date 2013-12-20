package org.eclipse.qvtd.debug.ui.stubs;

import java.util.List;

import org.eclipse.qvtd.debug.utils.Log;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EvaluationMonitor;

public interface ExecutionContext {

	Log getLog();

	EvaluationMonitor getMonitor();

	List<String> getConfigPropertyNames();

	String getConfigProperty(String key);

}
