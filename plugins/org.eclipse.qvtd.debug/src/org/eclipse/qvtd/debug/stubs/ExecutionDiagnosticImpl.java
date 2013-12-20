package org.eclipse.qvtd.debug.stubs;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.qvtd.debug.evaluator.QvtRuntimeException;
import org.eclipse.qvtd.debug.utils.ExecutionStackTraceElement;

public class ExecutionDiagnosticImpl extends BasicDiagnostic implements ExecutionDiagnostic
{
	public static final ExecutionDiagnosticImpl OK_INSTANCE = new ExecutionDiagnosticImpl(
			Diagnostic.OK, 0, "OK", null); //$NON-NLS-1$

	private List<ExecutionStackTraceElement> fStackTrace;

	public ExecutionDiagnosticImpl(int severity, int code, String message, Object[] data) {
		super(severity, SOURCE, code, message, data);
	}

	public ExecutionDiagnosticImpl(int severity, int code, String message) {
		super(severity, SOURCE, code, message, null);
	}

	/**
	 * Gets the stack trace that resulted from interrupted execution either by
	 * user termination request or exception thrown
	 * 
	 * @return list of trace elements or an empty list
	 */
	public List<ExecutionStackTraceElement> getStackTrace() {
		return fStackTrace != null ? Collections.unmodifiableList(fStackTrace)
				: Collections.<ExecutionStackTraceElement> emptyList();
	}

	/**
	 * Prints the execution stack-trace (if available) of this diagnostic to the
	 * specified print writer.
	 * 
	 * @param writer
	 *            <code>PrintWriter</code> to use for output
	 */
	public void printStackTrace(PrintWriter writer) {
		if (fStackTrace != null) {
			QvtRuntimeException.printQvtStackTrace(writer, fStackTrace);
		}
	}

	public void setStackTrace(List<? extends ExecutionStackTraceElement> stackElements) {
		fStackTrace = new ArrayList<ExecutionStackTraceElement>(stackElements);
	}

}
