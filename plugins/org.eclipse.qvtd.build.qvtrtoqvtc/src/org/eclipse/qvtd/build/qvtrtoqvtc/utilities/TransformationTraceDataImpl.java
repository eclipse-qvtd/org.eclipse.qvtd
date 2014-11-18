package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;



/* Keeps  track of variable values, output model and traces needed for 
 * the transformation */
public class TransformationTraceDataImpl implements TransformationTraceData
{
//	private final @NonNull Map<AbstractBindings, List<TraceRecord>> bindings2traceRecords = new HashMap<AbstractBindings, List<TraceRecord>>();
	private final @NonNull List<TraceRecord> traceRecords = new ArrayList<TraceRecord>();
	
	public TransformationTraceDataImpl() {}

	public TraceRecord getRecord(@NonNull RelationsBindings bindings) {		// FIXME is this necessary?
/*		ConstrainedRule rule = bindings.getRule();
		List<TraceRecord> traceRecords = bindings2traceRecords.get(bindings);
		if (traceRecords != null) {
			for (TraceRecord tr : traceRecords) {
				if ((tr != null) && rule.matchBindings(tr, bindings)) {
					return tr;
				}
			}
		}
		else {
			traceRecords = new ArrayList<TraceRecord>();
			bindings2traceRecords.put(bindings, traceRecords);
		} */
		TraceRecord record = bindings.getTraceRecord();
		traceRecords.add(record);
		return record;
		
	}
	/*
	public List<EObject> getRootOutputELements() {
		
		List<EObject> rootElements = new ArrayList<EObject>();
		for (TraceRecord record : traceRecords) {
			for (EObject output : record.getOutputs()) {
				if (output.eContainer() == null) {
					rootElements.add(output);
				}
			}
		}
		return rootElements;
	}
	*/

	@Override
	public void deleteRecord(@NonNull TraceRecord record) {
/*		AbstractBindings bindings = record.getCoreBindings();
		List<TraceRecord> traceRecords = bindings2traceRecords.get(bindings);
		if (traceRecords != null) {
			traceRecords.remove(record);
			if (traceRecords.isEmpty()) {
				bindings2traceRecords.remove(bindings);
			}
		} */
		traceRecords.remove(record);
	}

}
