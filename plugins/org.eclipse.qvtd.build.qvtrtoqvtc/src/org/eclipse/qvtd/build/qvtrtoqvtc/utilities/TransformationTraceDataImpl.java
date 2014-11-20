package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;



/* Keeps  track of variable values, output model and traces needed for 
 * the transformation */
public class TransformationTraceDataImpl implements TransformationTraceData
{
//	private final @NonNull Map<AbstractBindings, List<TraceRecord>> bindings2traceRecords = new HashMap<AbstractBindings, List<TraceRecord>>();
	private final @NonNull Map<RelationsBindings, Rule> traceRecords = new HashMap<RelationsBindings, Rule>();
	
	public TransformationTraceDataImpl() {}

	@Override
	public void deleteRecord(@NonNull Rule rule) {
		traceRecords.remove(rule.getRelationsBindings());
	}

	@Override
	public void addRecord(Rule rule) {
		traceRecords.put(rule.getRelationsBindings(), rule);
	}

	@Override
	public Rule getRecotd(@NonNull RelationsBindings relationsBindings) {
		return traceRecords.get(relationsBindings);
	}
	
	

}
