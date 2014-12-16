package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RuleBindings;

public interface TransformationTraceData {

	public void addRecord(@NonNull Rule rule);

	public abstract void deleteRecord(@NonNull Rule rule);
	
	public abstract @Nullable Rule getRecord(@NonNull RuleBindings relationsBindings);
	
}