package org.eclipse.qvtd.debug.stubs;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.qvtd.debug.utils.ExecutionStackTraceElement;
import org.eclipse.qvtd.debug.utils.QVTStackTraceElement;

public class QvtRuntimeException extends RuntimeException {

	public QvtRuntimeException() {
		super();
	}

	public QvtRuntimeException(Exception e) {
		super(e);
	}

	public QvtRuntimeException(String string) {
		super(string);
	}

	public List<? extends ExecutionStackTraceElement> getQvtStackTrace() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void printQvtStackTrace(PrintWriter writer,
			List<ExecutionStackTraceElement> fStackTrace) {
		// TODO Auto-generated method stub
		
	}

	public void setStackQvtTrace(List<QVTStackTraceElement> stackTraceElements) {
		// TODO Auto-generated method stub
		
	}

}
