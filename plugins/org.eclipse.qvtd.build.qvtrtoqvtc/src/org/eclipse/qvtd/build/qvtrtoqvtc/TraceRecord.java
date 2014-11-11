package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface TraceRecord.
 */
public interface TraceRecord {

	/**
	 * Matches. Verify that the record is the correct for the record and verify
	 * that the input elements match the references from the trace.
	 *
	 * @param rule the rule
	 * @param inputElements the input elements
	 * @return true, if successful
	 */
	boolean matches(ConstrainedRule rule, List<Object> inputElements);
	
	/**
	 * Was executed.
	 *
	 * @return true, if successful
	 */
	boolean wasExecuted();
	
	/**
	 * Was executed.
	 *
	 * @param executed the executed
	 */
	void wasExecuted(boolean executed);
}
