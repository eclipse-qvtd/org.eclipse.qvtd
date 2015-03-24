package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RuleBindings;

/* Keeps  track of variable values, output model and traces needed for 
 * the transformation */
public class TransformationTraceDataImpl implements TransformationTraceData
{
//	private final @NonNull Map<AbstractBindings, List<TraceRecord>> bindings2traceRecords = new HashMap<AbstractBindings, List<TraceRecord>>();
	private final @NonNull Map<RuleBindings, Rule> traceRecords = new HashMap<RuleBindings, Rule>();
	
	public TransformationTraceDataImpl() {}

	@Override
	public void deleteRecord(@NonNull Rule rule) {
		traceRecords.remove(rule.getRuleBindings());
	}

	@Override
	public void addRecord(@NonNull Rule rule) {
		traceRecords.put(rule.getRuleBindings(), rule);
	}

	@Override
	public Rule getRecord(@NonNull RuleBindings relationsBindings) {
		return traceRecords.get(relationsBindings);
	}
	
	

}
