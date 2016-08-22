/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;

public abstract class AbstractNodeRole extends AbstractRole implements NodeRole
{
	protected AbstractNodeRole(@NonNull Phase phase) {
		super(phase);
	}

	//	@Override
	//	public @NonNull NodeRole asMatched() {
	//		throw new UnsupportedOperationException();
	//	}

	@Override
	public @NonNull AbstractNodeRole asPhase(@NonNull Phase phase) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull NodeRole asPredicated() {
		return asPhase(Phase.PREDICATED);
	}

	@Override
	public @NonNull NodeRole asSpeculated() {
		return asPhase(Phase.SPECULATED);
	}

	@Override
	public @NonNull NodeRole asSpeculation() {
		return asPhase(Phase.SPECULATION);
	}

	public @NonNull TypedNode createNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		Region region = sourceNode.getRegion();
		assert sourceNode.isClass();
		SchedulerConstants schedulerConstants = region.getSchedulerConstants();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
		assert type != null;
		Type elementType = PivotUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? schedulerConstants.getDomainAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatumAnalysis().getTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
		String name = source2targetProperty.getName();
		assert name != null;
		return new TypedNode(this, region, name, classDatumAnalysis);
	}

	@Override
	public @NonNull TypedNode createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return new TypedNode(this, region, name, classDatumAnalysis);
	}

	@Override
	public @NonNull TypedNode createNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
		return new TypedNode(this, region, name, typedElement);
	}

	public @NonNull VariableNode createNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
		return region.createVariableNode(this, variable);
	}

	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public boolean isComposed() {
		return false;
	}

	@Override
	public boolean isExplicitNull() {
		return false;
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isExtraGuardVariable() {
		return false;
	}

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public boolean isIterator() {
		return false;
	}

	@Override
	public boolean isMatched() {
		return false;
	}

	@Override
	public boolean isOperation() {
		return false;
	}

	@Override
	public boolean isPattern() {
		return false;
	}

	@Override
	public boolean isTrue() {
		return false;
	}

	@Override
	public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
		if (nodeRole == this) {
			return this;
		}
		throw new IllegalStateException(this + " cannot be merged with " + nodeRole);
	}
}