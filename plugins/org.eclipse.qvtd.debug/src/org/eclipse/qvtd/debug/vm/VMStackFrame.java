/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.utils.DebugUtils;

public class VMStackFrame implements Serializable {
	
	private static final long serialVersionUID = -9084603067226851028L;

	private static class Loc implements VMLocation {
		private static final long serialVersionUID = 6628362004248726386L;
		
		private final VMStackFrame frame;
		
		private Loc(VMStackFrame frame) {
			this.frame = frame;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getLineNum()
		 */
		public int getLineNum() {
			return frame.lineNum;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getURI()
		 */
		public String getURI() {
			return frame.uri;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getModule()
		 */
		public String getModule() {
			return frame.module;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getOperationSignature()
		 */
		public String getOperationSignature() {
			return frame.operationSignature;
		}
	}
	
	
	public long id;
	private String uri;
	private int lineNum;	
	public String module;
	public String operationSignature;	
	public VMVariable[] visibleVariables;
	
	private transient VMLocation location;	
	
	private VMStackFrame(long id, String uri, String module, String operationSignature, int line, VMVariable[] vars) {
		if(vars != null && (vars.length == 0 || Arrays.asList(vars).contains(null))) {
			throw new IllegalArgumentException();
		}

		this.id = id;
		this.uri = uri;
		this.module = module;
		this.operationSignature = operationSignature;
		this.visibleVariables = vars;
		this.lineNum = line;
	}
	
	public synchronized VMLocation getLocation() {
		if(location == null) {
			location = new Loc(this);
		}
		return location;
	}	
	
	public List<VMVariable> getVisibleVariables() {
		if(visibleVariables == null) {
			return Collections.emptyList();
		}
		return Arrays.asList(visibleVariables);
	}
	
	public static VMStackFrame createFrame(long frameID, List<UnitLocation> stack) {	
		UnitLocation location = lookupEnvironmentByID(frameID, stack);
		if (location != null) {
			return VMStackFrame.create(location);
		}

		// invalid stack frame
		return null;
	}
	
	public static VMStackFrame create(UnitLocation location) {
		return create(location, true);
	}
	
	public static VMStackFrame create(UnitLocation location, boolean includeVars) {
		EvaluationEnvironment evalEnv = location.getEvalEnv();
		Type module = location.getModule();
		String moduleName = (module != null) ? module.getName() : "<null>"; //$NON-NLS-1$
		
		Operation operation = location.getOperation();
		String operSignature = (operation != null) ? getOperationSignature(operation)
				: MessageFormat.format("<{0}>", moduleName); //$NON-NLS-1$
		
		List<VMVariable> vars = VariableFinder.getVariables(evalEnv);
		VMStackFrame vmStackFrame = new VMStackFrame(DebugUtils.getID(evalEnv), location.getURI().toString(), moduleName, 
					operSignature, location.getLineNum(), vars.toArray(new VMVariable[vars.size()]));
		return vmStackFrame;
	}
	
	static VMStackFrame[] create(List<UnitLocation> stack) {
		List<VMStackFrame> result = new ArrayList<VMStackFrame>();
		
		int i = 0;
		for (UnitLocation location : stack) {
			// include variables only for the current (top level) stack
			result.add(create(location, i++ == 0));
		}

		return result.toArray(new VMStackFrame[result.size()]);
	}
	
	static UnitLocation lookupEnvironmentByID(long id, List<UnitLocation> stack) {
		for (UnitLocation location : stack) {
			org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment evalEnv = location.getEvalEnv();
//			if(evalEnv instanceof DebugEvaluationEnvironment) {
//				DebugEvaluationEnvironment debugEvalEnv = (DebugEvaluationEnvironment) evalEnv;
//				if(debugEvalEnv.getID() == id) {
//					return location;
//				}
//			}
		}

		return null;
	}
	
	private static String getOperationSignature(Operation operation) {
        StringBuffer buf = new StringBuffer();
/*    	EClassifier ctxType = QvtOperationalParserUtil.getContextualType(operation);        
        if (ctxType != null) {
            buf.append(ctxType.getName()).append("::"); //$NON-NLS-1$            
        }

        buf.append(operation.getName());        
        buf.append('(');
        
        int i = 0, n = operation.getEParameters().size();
        for (EParameter param : operation.getEParameters()) {
            EClassifier type = param.getEType();
            buf.append(type.getName());            
            if (i+1 < n) {
                buf.append(", "); //$NON-NLS-1$
            }
            ++i;
        }
        buf.append(')'); */
        
        return buf.toString();
    }
}
