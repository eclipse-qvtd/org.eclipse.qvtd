package org.eclipse.qvtd.build.qvtrtoqvtc;


// TODO: Auto-generated Javadoc
/**
 * The Interface TraceRecord.
 */
public interface TraceRecord {
	
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
	
	
	Bindings getBindings();
}
