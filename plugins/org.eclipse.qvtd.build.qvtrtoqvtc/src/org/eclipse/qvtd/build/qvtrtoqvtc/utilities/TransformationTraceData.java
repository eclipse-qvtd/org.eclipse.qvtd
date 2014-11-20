package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;

public interface TransformationTraceData {

	public void addRecord(Rule rule);

	public abstract void deleteRecord(@NonNull Rule rule);
	
	public abstract Rule getRecotd(@NonNull RelationsBindings relationsBindings);
	
}