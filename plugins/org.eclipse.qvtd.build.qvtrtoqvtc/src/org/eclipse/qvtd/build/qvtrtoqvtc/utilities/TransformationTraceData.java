package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public interface TransformationTraceData {

	public abstract TraceRecord getRecord(@NonNull RelationsBindings bindings);

	public abstract void deleteRecord(@NonNull TraceRecord record);
	
}