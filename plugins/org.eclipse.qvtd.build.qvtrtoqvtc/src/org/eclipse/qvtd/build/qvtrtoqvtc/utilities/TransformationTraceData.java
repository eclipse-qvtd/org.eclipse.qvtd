package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public interface TransformationTraceData {

	public abstract TraceRecord getRecord(ConstrainedRule rule, Bindings bindings);

	public abstract void deleteRecord(TraceRecord record);
	
}