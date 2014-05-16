/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

public class QVTiVMVirtualMachine extends VMVirtualMachine
{
	private static boolean appendElementSignature(@NonNull StringBuilder s, @Nullable EObject eObject) {
        if (eObject instanceof Root) {
        	return false;
        }
        else if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((org.eclipse.ocl.examples.pivot.Package)eObject).getName());        
			return true;
        }
        else if (eObject instanceof Type) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((Type)eObject).getName());
			return true;
        }
        else if (eObject instanceof Mapping) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((Mapping)eObject).getName());
			return true;
        }
        else if (eObject instanceof Domain) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((Domain)eObject).getName());
			return true;
        }
        else if (eObject instanceof MappingCall) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((MappingCall)eObject).getReferredMapping().getName());
			return true;
        }
        else if (eObject instanceof Operation) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        Operation operation = (Operation)eObject;
			s.append(operation.getName());        
	        s.append("(");        
	        boolean isFirst = true;;
	        for (Parameter param : operation.getOwnedParameter()) {
	            if (!isFirst) {
	                s.append(", ");
	            }
	            Type type = param.getType();
	            s.append(type.getName());            
	            isFirst = false;
	        }
	        s.append(")");        
			return true;
        }
        else if (eObject instanceof Feature) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((Feature)eObject).getName());        
			return true;
        }
        else if (eObject instanceof Constraint) {
        	if (appendElementSignature(s, eObject.eContainer())) {
    	        s.append("::");
        	}
	        s.append(((Constraint)eObject).getName());        
			return true;
        }
        else if (eObject != null) {
        	return appendElementSignature(s, eObject.eContainer());
        }
        else {
        	return false;
        }
    }

	public static @NonNull VMStackFrameData[] createStackFrame(List<UnitLocation> stack) {
		List<VMStackFrameData> result = new ArrayList<VMStackFrameData>();
		
		int i = 0;
		for (UnitLocation location : stack) {
			// include variables only for the current (top level) stack
			if (location != null) {
				result.add(createStackFrame(location, i++ == 0));
			}
		}

		return result.toArray(new VMStackFrameData[result.size()]);
	}
	
	public VMStackFrameData createStackFrame(@NonNull UnitLocation location) {
		return createStackFrame(location, true);
	}

	private static @NonNull VMStackFrameData createStackFrame(@NonNull UnitLocation location, boolean includeVars) {
		IVMEvaluationEnvironment<?> evalEnv = location.getEvalEnv();
		NamedElement module = location.getModule();
		String moduleName = (module != null) ? module.getName() : "<null>"; //$NON-NLS-1$
		
		Element element = location.getElement();
		StringBuilder s = new StringBuilder();
		appendElementSignature(s, element);
		String operSignature = s.toString(); //MessageFormat.format("<{0}>", moduleName); //$NON-NLS-1$
		
		List<VMVariableData> vars = VariableFinder.getVariables(evalEnv);
		VMStackFrameData vmStackFrame = new VMStackFrameData(evalEnv.getID(), location.getURI().toString(), moduleName, 
					operSignature, location.getLineNum(), location.getStartPosition(), location.getEndPosition(), vars.toArray(new VMVariableData[vars.size()]));
		return vmStackFrame;
	}
	
	
	public QVTiVMVirtualMachine(@NonNull DebuggableRunner runner, @NonNull QVTiEvaluationContext evaluationContext) {
		super(runner, runner.createDebuggableAdapter(evaluationContext));
	}

	@Override
	public @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}	
}
