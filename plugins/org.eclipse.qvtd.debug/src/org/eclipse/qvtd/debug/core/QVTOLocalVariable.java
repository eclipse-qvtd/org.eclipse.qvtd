package org.eclipse.qvtd.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.qvtd.debug.core.QVTOLocalValue.LocalValue;
import org.eclipse.qvtd.debug.vm.VMFrameExecutionContext;
import org.eclipse.qvtd.debug.vm.VMVariable;
import org.eclipse.qvtd.debug.vm.VariableFinder;

public class QVTOLocalVariable extends QVTOVariable {
	QVTOLocalVariable(IQVTODebugTarget debugTarget, VMVariable vmVar, long frameID, VMFrameExecutionContext execContext) {
		super(debugTarget, vmVar, frameID);
		myFrameID = frameID;
		myExecContext = execContext;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		if (fValue == null) {
			LocalValue lv = new LocalValue();
			lv.valueObject = vmVar.valueObject;
			lv.valueType = null; // FIXME vmVar.valueObject instanceof EObject ? ((EObject) vmVar.valueObject).eClass() : null;
			fValue = new QVTOLocalValue(getQVTODebugTarget(), myFrameID,
					VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), lv, myExecContext);
		}
		return fValue;
	}
	
	private final long myFrameID;
	private final VMFrameExecutionContext myExecContext;
}
