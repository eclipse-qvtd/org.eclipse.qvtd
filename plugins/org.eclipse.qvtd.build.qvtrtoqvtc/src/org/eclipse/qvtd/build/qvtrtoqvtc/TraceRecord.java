package org.eclipse.qvtd.build.qvtrtoqvtc;

import org.eclipse.jdt.annotation.NonNull;


// TODO: Auto-generated Javadoc
/**
 * The Interface TraceRecord.
 */
public interface TraceRecord {
	
	
	@NonNull CoreBindings getCoreBindings();

	@NonNull PrimitivesBindings getPrimitivesBindings();

	@NonNull RelationsBindings getRelationsBindings();
	/**
	 * Was executed.
	 *
	 * @return true, if successful
	 */
	boolean hasExecuted();
	
	/**
	 * Was executed.
	 *
	 * @param executed the executed
	 */
	void setExecuted(boolean executed);
	
}
