/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.naming;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.naming.NestedNameManager;
import org.eclipse.ocl.examples.codegen.naming.SupportedExecutableNameManager;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * QVTiNestedNameManager provides QVTi-specific overrides for nested contexts.
 */
public class QVTiExecutableNameManager extends SupportedExecutableNameManager
{
	public QVTiExecutableNameManager(@NonNull ClassNameManager classNameManager, @NonNull NestedNameManager parentNameManager, @NonNull CGNamedElement cgScope, @Nullable TypedElement asOrigin) {
		super(classNameManager, parentNameManager, cgScope, asOrigin);
	}

	@Override
	public @NonNull CGFinalVariable createCGVariable(@NonNull VariableDeclaration asVariable) {
		EStructuralFeature eContainingFeature = asVariable.eContainingFeature();
		if (eContainingFeature == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			CGFinalVariable cgVariable = lazyGetQualifiedThisVariable();
			addVariable(asVariable, cgVariable);
			return cgVariable;
		}
		else if (eContainingFeature == QVTbasePackage.Literals.TYPED_MODEL__OWNED_CONTEXT) {
			CGFinalVariable cgVariable = super.createCGVariable(asVariable);
			cgVariable.setAst(asVariable);
			if (asVariable.isIsRequired()) {
				cgVariable.setNonInvalid();
				cgVariable.setRequired(true);
			}
			return cgVariable;
		}
		return super.createCGVariable(asVariable);
	}

	@Override
	protected @NonNull CGFinalVariable createQualifiedThisVariable() {
		Class asClass = classNameManager.getASClass();
		assert asClass instanceof Transformation;
		NameResolution rootThisName = getGlobalNameManager().getRootThisNameResolution();
		CGTypeId cgTypeId = analyzer.getCGTypeId(asClass.getTypeId());
		CGFinalVariable transformationVariable = analyzer.createCGFinalVariable(rootThisName, cgTypeId, true);
		transformationVariable.setNonInvalid();
		return transformationVariable;
	}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return (QVTiAnalyzer)super.getAnalyzer();
	}

	@Override
	public @Nullable CGValuedElement getBody() {
		if (cgScope instanceof CGMapping) {
			return ((CGMapping)cgScope).getOwnedBody();
		}
		else if (cgScope instanceof CGTransformation) {
			return null;
		}
		return super.getBody();
	}

	@Override
	public @NonNull QVTiGlobalNameManager getGlobalNameManager() {
		return (QVTiGlobalNameManager)super.getGlobalNameManager();
	}
}