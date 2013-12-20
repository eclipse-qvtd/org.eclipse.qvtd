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

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.utils.IModuleSourceInfo;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class UnitLocation {
	
	private static final int UNDEF_LINE_NUM = -2;
	
/*	private static int calcStackDepth(IDebugEvaluationEnvironment currentEvalEnv) {
		// FIXME - move to core QVTO into EvaluationEnv
		int depth = 0;
		IDebugEvaluationEnvironment evalEnv = currentEvalEnv;
		while (evalEnv != null) {			
			depth += evalEnv.getDepth();
			evalEnv = null; //EvaluationUtil.getAggregatingContext(evalEnv);
		}
		return depth;
	} */
	
	private int fLineNum = UNDEF_LINE_NUM;
	private final int fOffset;
	private final int fDepth;	
	
    private final Element fElement;
    private final Transformation fModule;    
    private final NamedElement fOperation;
    private final IDebugEvaluationEnvironment fEvalEnv;    
	private IModuleSourceInfo fSrcInfo;
	
	public UnitLocation(int position, @NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element) {
		fEvalEnv = evalEnv;
		fElement = element;
		fOffset = position;
		fDepth = evalEnv.getDepth();
		fOperation = evalEnv.getOperation();
		
		fModule = fEvalEnv.getTransformation();
//		if (currentInstance != null) {
//			fModule = currentInstance.getInstantiatedType();			 
//		} else if (element instanceof Type) {
//			// TODO - debugging before module instance get created & initialized into evaluation
//			// environment => for now, derive from the past AST element
//			fModule = (Type) element;
//		} else {
//			throw new IllegalArgumentException("Module-less evaluation environment"); //$NON-NLS-1$
//		}
	}

	public boolean isDeferredExecution() {
		return fEvalEnv.isDeferredExecution();
	}

    public URI getURI() {
    	return getSourceInfo().getSourceURI();
	}
    
    public Type getModule() {
    	return fModule;
    }
    
    public NamedElement getOperation() {
        return fOperation;
    }
    
	public IDebugEvaluationEnvironment getEvalEnv() {
		return fEvalEnv;
	} 
	
	public int getLineNum() {
		if(fLineNum == UNDEF_LINE_NUM) {
			int newLine = -1;
			if(fOffset >= 0) {
				newLine = getSourceInfo().getLineNumberProvider().getLineNumber(fOffset);				
			}
			
			return fLineNum = newLine;
		}

		return fLineNum;
	}
	
	public int getOffset() {
		return fOffset;
	}
	
	public int getStackDepth() {
		return fDepth;
	}
	
    public Element getElement() {
        return fElement;
    }
	
    public boolean isTheSameLine(UnitLocation location) {
    	return (fEvalEnv == location.fEvalEnv) && (getLineNum() == location.getLineNum());
    }
	
    public boolean isTheSameLocation(UnitLocation location) {
    	return (fEvalEnv == location.fEvalEnv) && (getLineNum() == location.getLineNum()) && (fOffset == location.fOffset);
    }
    
	@Override
	public boolean equals(Object another) {
		if(another instanceof UnitLocation == false) {
			return false;
		}
		
		UnitLocation location = (UnitLocation) another;
		return this == location || 
				(fOffset == location.fOffset
				&& fDepth == location.fDepth
				&& fEvalEnv == location.fEvalEnv
				&& fElement.equals(location.fElement));
	}	
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 37 * hash + fOffset;
		hash = 37 * hash + fDepth;		
		hash = 37 * hash + fElement.hashCode();		
		return hash;
	}
	
	@Override
	public String toString() {
		return fModule.getName() + ":" + getLineNum() + ":" + fOffset  + ":" + fDepth; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private IModuleSourceInfo getSourceInfo() {
    	if(fSrcInfo == null) {
    		fSrcInfo = ASTBindingHelper.getModuleSourceBinding(getModule());
    	}
    	return fSrcInfo;
	}
	
/*	private static int calcStackDepth(QvtOperationalEvaluationEnv currentEvalEnv) {
		// FIXME - move to core QVTO into EvaluationEnv
		int depth = 0;
		QvtOperationalEvaluationEnv evalEnv = currentEvalEnv;
		while(evalEnv != null) {			
			depth += evalEnv.getDepth();
			evalEnv = EvaluationUtil.getAggregatingContext(evalEnv);
		}
		return depth;
	} */
}
