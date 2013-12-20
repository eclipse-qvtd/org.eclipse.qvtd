package org.eclipse.qvtd.debug.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvtd.debug.vm.VMVariable;
import org.eclipse.qvtd.debug.vm.Value;
import org.eclipse.qvtd.debug.vm.protocol.VMDetailRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMDetailResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableResponse;

public class QVTOValue extends QVTODebugElement implements IValue {
			
	final VMVariable vmVar;
	private Value vmValue;
	private long frameID;

	QVTOValue(IQVTODebugTarget debugTarget, VMVariable vmVar, long frameID) {
		super(debugTarget);
		this.vmVar = vmVar;
		this.vmValue = vmVar.value;
		this.frameID = frameID;
	}
	
	public boolean hasVariables() throws DebugException {
		return vmValue != null && vmValue.hasVariables;
	}

	public IVariable[] getVariables() throws DebugException {
		List<VMVariable> variables = requestVariables();
		List<IVariable> result = new ArrayList<IVariable>();
		
		for (VMVariable nextVar : variables) {
			result.add(new QVTOVariable(getQVTODebugTarget(), nextVar, this.frameID));
		}					
		
		return result.toArray(new IVariable[result.size()]);
	}

	public String getValueString() throws DebugException {
		return (vmValue != null) ? String.valueOf(vmValue.value) : "null"; //$NON-NLS-1$
	}

	public String getReferenceTypeName() throws DebugException {
		return this.vmVar.type.actualType;
	}		
	
    public String computeDetail() throws DebugException {
    	URI varURI = URI.createURI(getVariableURIForVMRequest());
    	VMDetailRequest request = new VMDetailRequest(varURI);
    	
    	VMResponse response = getQVTODebugTarget().sendRequest(request);
    	if(response instanceof VMDetailResponse) {
    		VMDetailResponse detailResponse = (VMDetailResponse) response;
    		return detailResponse.getDetail();
    	}
    	return ""; //$NON-NLS-1$
    }
	
    private String getVariableURIForVMRequest() {
		String variableURI = vmVar.name;
		if(!vmVar.isRootVariable()) {
			variableURI = vmVar.variableURI;
		}
		return variableURI;
    }
    
	List<VMVariable> requestVariables() throws DebugException {
		String variableURI = getVariableURIForVMRequest();
		
		VMVariableRequest request = new VMVariableRequest(
				frameID, variableURI, true);
		
		VMResponse response = getQVTODebugTarget().sendRequest(request);

		if(response instanceof VMVariableResponse) {
			VMVariableResponse variableResponse = (VMVariableResponse) response;
			if(variableResponse.childVariables != null) {
				return Arrays.asList(variableResponse.childVariables);
			}
		}
		
		return Collections.emptyList();
	}
	
	public boolean isAllocated() throws DebugException {
		return true;
	}
	
}