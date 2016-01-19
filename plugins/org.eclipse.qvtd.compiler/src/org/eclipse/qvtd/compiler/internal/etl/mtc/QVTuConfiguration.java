/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation as MtcUtil
 *     E.D.Willink - initial API and re-implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

/**
 * QVTuConfiguration captures the configuration to be imposed by a QVTc2QVTu transformation
 * and provides configuration related utilities.
 */
public class QVTuConfiguration
{
	public enum Mode {
		CHECK,
		ENFORCE
	}
	
	private final @NonNull Mode mode;
	private final @NonNull List<@NonNull String> inputs;		// FIXME Names rather than TypedModel until c/u TypedModel ambiguity eliminated
	private final @NonNull List<@NonNull String> outputs;
	
	public QVTuConfiguration(@NonNull Mode mode, @NonNull List<@NonNull String> inputs, @NonNull List<@NonNull String> outputs) {
		this.mode = mode;
		this.inputs = inputs;
		this.outputs = outputs;
	}

	/**
	 * Gets the area.
	 */
	private @Nullable Area getArea(@Nullable OCLExpression exp) {
		if (exp instanceof VariableExp) {
			Variable expV = (Variable) ((VariableExp)exp).getReferredVariable(); 
			return getArea(expV);
		} else if (exp instanceof CallExp) {
			return getArea(((CallExp) exp).getOwnedSource());
		} else if (exp instanceof IfExp) {
			return getArea(((IfExp) exp).getOwnedCondition());
		} else if (exp instanceof LiteralExp) {
			return null;
		}
		return null;
	}

	/**
	 * Gets the area.
	 */
	private @Nullable Area getArea(Variable expV) {
		if (expV.getType() != null) {
			CorePattern cp = oppositePattern(expV);
			if (cp!= null)
			return cp.getArea();
		}
		return null;
	}

	/**
	 * Checks if is check mode.
	 */
	public boolean isCheckMode() {
    	return mode == Mode.CHECK;
    }
	
	public boolean isEnforceMode() {
		return mode == Mode.ENFORCE;
	}

	/**
	 * Checks if is from input domain.
	 */
	public boolean isFromInputDomain(@Nullable OCLExpression exp) {
		return isInputDomain(getArea(exp));
	}
	
	/**
	 * Checks if is from middle domain.
	 */
	public boolean isFromMiddleDomain(@Nullable OCLExpression exp) {
		return isMiddleDomain(getArea(exp));
	}

	/**
	 * Checks if is input domain.
	 */
	public boolean isInputDomain(@Nullable Area area) {
        return (area instanceof CoreDomain) && inputs.contains(((CoreDomain)area).getTypedModel().getName());
	}
	
	/**
	 * Is a local variable to M .
	 */
	public boolean isLocaltoM(@NonNull PropertyAssignment a) {
		OCLExpression value = a.getValue();
		if (isFromMiddleDomain(value) && (value instanceof VariableExp)) {
			Variable var = (Variable) ((VariableExp)value).getReferredVariable();
			Area area = getArea(var);
			return isMiddleDomain(area) && (area instanceof BottomPattern);
		}
		return false;
				
	}
	
	/**
	 * Checks if is middle domain.
	 */
	public boolean isMiddleDomain(@Nullable Area area) {
		return area instanceof Mapping;
	}
	
	/**
	 * Is a Middle to Left assignment.
	 */
	public boolean isMtoL(@NonNull PropertyAssignment a) {
		return isFromInputDomain(a.getSlotExpression()) && anyReferencedMiddleDomainVariables(a.getValue());
	}

	/**
	 * Checks if is middle to left.
	 */
	public boolean isMtoL(@NonNull VariableAssignment a) {
		return isInputDomain(getArea(a.getTargetVariable())) && anyReferencedMiddleDomainVariables(a.getValue());
	}
	private boolean anyReferencedMiddleDomainVariables(OCLExpression value) {
		for (Variable v : MtcUtil.findReferencedVariables(value)) {
			if (isMiddleDomain(getArea(v))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if is middle to middle.
	 */
	public boolean isMtoM(VariableAssignment a) {
		return isMiddleDomain(getArea(a.getTargetVariable())) &&
				anyReferencedBottomMiddleDomainVariables(a.getValue());
	}
	private boolean anyReferencedBottomMiddleDomainVariables(OCLExpression value) {
		for (Variable v : MtcUtil.findReferencedVariables(value)) {
			if (isMiddleDomain(getArea(v)) && (oppositePattern(v) instanceof BottomPattern)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is output domain.
	 */
	public boolean isOutputDomain(Area area) {
        return (area instanceof CoreDomain) && outputs.contains(((CoreDomain)area).getTypedModel().getName());
	}

	/**
	 * Is a Right to Middle assignment.
	 */
	public boolean isRtoM(PropertyAssignment a) {
		return isFromMiddleDomain(a.getSlotExpression()) &&
				!(a.getValue() instanceof VariableExp) &&
				!(a.getValue() instanceof NullLiteralExp) &&
				allMatchReferencedOutputDomainVariables(a.getValue());
	}
	private boolean allMatchReferencedOutputDomainVariables(OCLExpression value) {
		for (Variable v : MtcUtil.findReferencedVariables(value)) {
			if (!isOutputDomain(getArea(v))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if is rto m.
	 */
	public boolean isRtoM(VariableAssignment a) {
		return isMiddleDomain(getArea(a.getTargetVariable())) &&
				!(a.getValue() instanceof VariableExp) &&
				// TODO variable assignments to null? !(a.getValue() instanceof NullLiteralExp) &&
				allMatchReferencedOutputDomainVariables(a.getValue());
	}

    /**
     * Opposite pattern.
     */
    private CorePattern oppositePattern(Variable expV) {
		if (expV.eContainer() instanceof CorePattern)
			return (CorePattern) expV.eContainer();
		return null;
	}
	
}
