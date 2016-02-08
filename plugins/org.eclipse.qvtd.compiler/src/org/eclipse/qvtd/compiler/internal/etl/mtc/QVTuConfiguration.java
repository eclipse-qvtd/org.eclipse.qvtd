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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

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
	private @Nullable Area getArea(@Nullable Variable expV) {
		if ((expV != null) && (expV.getType() != null)) {
			CorePattern cp = parentPattern(expV);
			if (cp != null) {
				return cp.getArea();
			}
		}
		return null;
	}

	private @Nullable VariableDeclaration getReferredVariable(@NonNull OCLExpression oclExpression) {
		if (oclExpression instanceof VariableExp) {
			return ((VariableExp)oclExpression).getReferredVariable();
		}
//		if (oclExpression instanceof TemplateExp) {
//			return ((TemplateExp)oclExpression).getBindsTo();
//		}
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
	 * Return true if oclExpression uses only the input domain variables.
	 */
	public boolean isInputDomainExpression(@NonNull OCLExpression oclExpression) {
		VariableDeclaration referredVariable = getReferredVariable(oclExpression);
		if ((referredVariable != null) && !isInputDomainVariable(referredVariable)) {
			return false;
		}
		for (EObject eObject : oclExpression.eContents()) {
			if (eObject instanceof OCLExpression) {
				if (!isInputDomainExpression((OCLExpression)eObject)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Return true if variable is declared in the input domain.
	 */
	public boolean isInputDomainVariable(@NonNull VariableDeclaration variable) {
		Area area = QVTcoreBaseUtil.getContainingArea(variable);
		return isInputDomain(area);
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
	 * Return the non-null PropertyCallExp if oclExpression is a PropertyCallExp in the middle domain.
	 */
	public @Nullable PropertyCallExp isMiddleDomainPropertyAccess(@NonNull OCLExpression oclExpression) {
		if (!(oclExpression instanceof PropertyCallExp)) {
			return null;
		}
		PropertyCallExp propertyCallExp = (PropertyCallExp)oclExpression;
		OCLExpression sourceExpression = propertyCallExp.getOwnedSource();
		if (!(sourceExpression instanceof VariableExp)) {
			return null;
		}
		VariableExp variableExp = (VariableExp)sourceExpression;
		VariableDeclaration variable = variableExp.getReferredVariable();
		if (!(variable instanceof Variable)) {
			return null;
		}
		if (!isMiddleDomainVariable(variable)) {
			return null;
		}
		return propertyCallExp;
	}

	/**
	 * Return true if variable is declared in the middle domain.
	 */
	public boolean isMiddleDomainVariable(@NonNull VariableDeclaration variable) {
		Area area = QVTcoreBaseUtil.getContainingArea(variable);
		return isMiddleDomain(area);
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
	public boolean isMtoM(@NonNull VariableAssignment a) {
		return isMiddleDomain(getArea(a.getTargetVariable())) &&
				anyReferencedBottomMiddleDomainVariables(a.getValue());
	}
	private boolean anyReferencedBottomMiddleDomainVariables(OCLExpression value) {
		for (Variable v : MtcUtil.findReferencedVariables(value)) {
			if (isMiddleDomain(getArea(v)) && (parentPattern(v) instanceof BottomPattern)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is output domain.
	 */
	public boolean isOutputDomain(@Nullable Area area) {
        return (area instanceof CoreDomain) && outputs.contains(((CoreDomain)area).getTypedModel().getName());
	}

	/**
	 * Is a Right to Middle assignment.
	 */
	public boolean isRtoM(@NonNull PropertyAssignment a) {
		OCLExpression value = a.getValue();
		assert value != null;
		return isFromMiddleDomain(a.getSlotExpression()) &&
				!(value instanceof VariableExp) &&
				!(value instanceof NullLiteralExp) &&
				allMatchReferencedOutputDomainVariables(value);
	}
	private boolean allMatchReferencedOutputDomainVariables(@NonNull OCLExpression value) {
		for (Variable v : MtcUtil.findReferencedVariables(value)) {
			if (!isOutputDomain(getArea(v))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if is to m.
	 */
	public boolean isRtoM(@NonNull VariableAssignment a) {
		OCLExpression value = a.getValue();
		assert value != null;
		return isMiddleDomain(getArea(a.getTargetVariable())) &&
				!(value instanceof VariableExp) &&
				// TODO variable assignments to null? !(a.getValue() instanceof NullLiteralExp) &&
				allMatchReferencedOutputDomainVariables(value);
	}

    /**
     * Parent pattern or null.
     */
    private CorePattern parentPattern(@NonNull Variable expV) {
		EObject eContainer = expV.eContainer();
		if (eContainer instanceof CorePattern)
			return (CorePattern) eContainer;
		return null;
	}
	
}
