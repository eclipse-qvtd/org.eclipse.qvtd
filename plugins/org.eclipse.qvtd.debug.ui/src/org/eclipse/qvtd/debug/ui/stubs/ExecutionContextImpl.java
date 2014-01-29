package org.eclipse.qvtd.debug.ui.stubs;

import java.util.List;

import org.eclipse.qvtd.debug.utils.Log;
import org.eclipse.qvtd.debug.utils.WriterLog;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EvaluationMonitor;

public class ExecutionContextImpl implements ExecutionContext {

	public void setConfigProperty(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void setLog(WriterLog writerLog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Log getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluationMonitor getMonitor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getConfigPropertyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfigProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
