package org.eclipse.qvtd.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.core.QVTOLocalValue.LocalValue;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.vm.VariableFinder;
import org.eclipse.qvtd.debug.vm.protocol.VMVariable;

public class QVTOLocalVariable extends QVTOVariable {
	QVTOLocalVariable(IQVTODebugTarget debugTarget, VMVariable vmVar, long frameID, @NonNull IDebugEvaluationEnvironment evaluationEnvironment) {
		super(debugTarget, vmVar, frameID);
		myFrameID = frameID;
		this.evaluationEnvironment = evaluationEnvironment;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		if (fValue == null) {
			LocalValue lv = new LocalValue();
			lv.valueObject = vmVar.valueObject;
			lv.valueType = null; // FIXME vmVar.valueObject instanceof EObject ? ((EObject) vmVar.valueObject).eClass() : null;
			fValue = new QVTOLocalValue(getQVTODebugTarget(), myFrameID,
					VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), lv, evaluationEnvironment);
		}
		return fValue;
	}
	
	private final long myFrameID;
	private final @NonNull IDebugEvaluationEnvironment evaluationEnvironment;
}
