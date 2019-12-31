/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

/**
 * An AbstractQVTimperativeAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
@SuppressWarnings("deprecation")
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
	public @Nullable Boolean visitAddStatement(@NonNull AddStatement object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitAppendParameter(@NonNull AppendParameter object) {
		return visitConnectionVariable(object);
	}

	@Override
	public @Nullable Boolean visitAppendParameterBinding(@NonNull AppendParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitBufferStatement(@NonNull BufferStatement object) {
		return visitConnectionVariable(object);
	}

	@Override
	public @Nullable Boolean visitCheckStatement(@NonNull CheckStatement object) {
		return visitObservableStatement(object);
	}

	@Override
	public @Nullable Boolean visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitDeclareStatement(@NonNull DeclareStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitGuardParameter(@NonNull GuardParameter object) {
		return visitMappingParameter(object);
	}

	@Override
	public @Nullable Boolean visitGuardParameterBinding(@NonNull GuardParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitImperativeModel(@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Boolean visitImperativeTransformation(@NonNull ImperativeTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public @Nullable Boolean visitLoopParameterBinding(@NonNull LoopParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitLoopVariable(@NonNull LoopVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitMapping(@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Boolean visitMappingCall(@NonNull MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingLoop(@NonNull MappingLoop object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingParameter(@NonNull MappingParameter object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitMappingStatement(@NonNull MappingStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitNewStatement(@NonNull NewStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitObservableStatement(@NonNull ObservableStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitSetStatement(@NonNull SetStatement object) {
		return visitObservableStatement(object);
	}

	@Override
	public @Nullable Boolean visitSimpleParameter(@NonNull SimpleParameter object) {
		return visitMappingParameter(object);
	}

	@Override
	public @Nullable Boolean visitSimpleParameterBinding(@NonNull SimpleParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitStatement(@NonNull Statement object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitVariableStatement(@NonNull VariableStatement object) {
		return visitVariableDeclaration(object);
	}
}
