package org.eclipse.qvtd.build.qvtrtoqvtc.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;



/* Keeps  track of variable values, output model and traces needed for 
 * the transformation */
public class TransformationTraceDataImpl implements TransformationTraceData {
	
	private List<TraceRecord> traceRecords;
	
	
	public TransformationTraceDataImpl() {
		traceRecords = new ArrayList<TraceRecord>();
	}

	@Override
	public TraceRecord getRecord(ConstrainedRule rule, List<Object> inputElements) {
		TraceRecord record = null;
		for (TraceRecord tr : traceRecords) {
			if (tr.matches(rule, inputElements)) {
				record = tr;
				break;
			}
		}
		if (record == null) {
			record = rule.creareTrace();
			traceRecords.add(record);
		}
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
	public void deleteRecord(TraceRecord record) {
		traceRecords.remove(record);
	}

}
