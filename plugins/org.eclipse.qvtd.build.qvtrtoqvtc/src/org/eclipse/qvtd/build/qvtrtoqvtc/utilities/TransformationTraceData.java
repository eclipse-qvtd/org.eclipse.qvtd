package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import java.util.List;

import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public interface TransformationTraceData {

	public abstract TraceRecord getRecord(ConstrainedRule rule, List<Object> args);

	public abstract void deleteRecord(TraceRecord record);
	
}