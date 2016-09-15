/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2XMIidVisitor;

/**
 * An AbstractQVTimperativeAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeAS2XMIidVisitor
	extends QVTbaseAS2XMIidVisitor
	implements QVTimperativeVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	@Override
	public @Nullable Boolean visitAccessStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AccessStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitCheckStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CheckStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitDeclareStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull DeclareStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitGuardVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitIfStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull IfStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Boolean visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Boolean visitImperativeTypedModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTypedModel object) {
		return visitTypedModel(object);
	}

	@Override
	public @Nullable Boolean visitInConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull InConnectionVariable object) {
		return visitConnectionVariable(object);
	}

	@Override
	public @Nullable Boolean visitInitializeStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull InitializeStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitLoopVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Boolean visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitOutConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OutConnectionVariable object) {
		return visitConnectionVariable(object);
	}

	@Override
	public @Nullable Boolean visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitVariableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableStatement object) {
		return visitVariableDeclaration(object);
	}
}
