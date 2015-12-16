/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * A QVTimperativeDomainUsageAnalysis identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class QVTimperativeDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTimperativeVisitor<DomainUsage>
{
	/**
	 * The properties of the input models that are assigned by mappings and which cannot therefore
	 * be trusted to be loaded from the input models.
	 */
	private final @NonNull Set<Property> dirtyProperties = new HashSet<Property>();
	private final @NonNull Set<EReference> dirtyEReferences = new HashSet<EReference>();

	public QVTimperativeDomainUsageAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	private void analyzePropertyAssignments(@NonNull Transformation transformation) {
		for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof PropertyAssignment) {
				PropertyAssignment propertyAssignment = (PropertyAssignment)eObject;
				DomainUsage domainUsage = getUsage(propertyAssignment.getSlotExpression());
				if ((domainUsage == null) || !domainUsage.isEnforceable()) {
					Property targetProperty = propertyAssignment.getTargetProperty();
//					System.out.println("Dirty " + targetProperty + " for " + eObject);
					dirtyProperties.add(targetProperty);
					EObject eProperty = targetProperty.getESObject();
					if (eProperty instanceof EReference) {
						dirtyEReferences.add((EReference) eProperty);
					}
				}
			}
		}
		for (Property dirtyProperty : dirtyProperties) {
			if (!dirtyProperty.isIsTransient()) {
				System.out.println("Dirty " + dirtyProperty + " is not transient");
			}
			if (dirtyProperty.isIsReadOnly()) {
				System.out.println("Dirty " + dirtyProperty + " is readonly");
			}
			if (dirtyProperty.isIsRequired()) {
				System.out.println("Dirty " + dirtyProperty + " is required");
			}
		}
	}

	@Override
	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		Map<Element, DomainUsage> analysis = super.analyzeTransformation(transformation);
		analyzePropertyAssignments(transformation);
		return analysis;
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull EReference eReference) {
		return dirtyEReferences.contains(eReference);
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull Property property) {
		return dirtyProperties.contains(property);
	}

	@Override
	public @Nullable DomainUsage visitConnectionAssignment(@NonNull ConnectionAssignment object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getTargetVariable());
		return intersection(variableUsage, valueUsage);
	}

	@Override
	public @Nullable DomainUsage visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable DomainUsage visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable DomainUsage visitImperativeModel(@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable DomainUsage visitMapping(@NonNull Mapping object) {
		visitRule(object);
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		visit(object.getMappingStatement());
		return getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitMappingCall(@NonNull MappingCall object) {
		for (MappingCallBinding mappingCallBinding : object.getBinding()) {
			visit(mappingCallBinding);
		}
		return getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitMappingCallBinding(@NonNull MappingCallBinding object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getBoundVariable());
		return intersection(valueUsage, variableUsage);
	}

	@Override
	public @Nullable DomainUsage visitMappingLoop(@NonNull MappingLoop object) {
		DomainUsage sourceUsage = visit(object.getOwnedSource());
		for (Variable iterator : object.getOwnedIterators()) {
			if (iterator != null) {
				setUsage(iterator, sourceUsage);
			}
		}
		visit(object.getOwnedBody());
		return getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitMappingSequence(@NonNull MappingSequence object) {
		for (MappingStatement mappingStatement : object.getMappingStatements()) {
			visit(mappingStatement);
		}
		return getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitMappingStatement(@NonNull MappingStatement object) {
		return visitOCLExpression(object);
	}
	
	@Override
	public @Nullable DomainUsage visitVariableExp(@NonNull VariableExp object) {
		StandardLibraryInternal standardLibrary = context.getStandardLibrary();
		Type transformationType = standardLibrary.getLibraryType("Transformation");
		if ((transformationType != null) && object.getType().conformsTo(standardLibrary, transformationType)) {
			return getNoneUsage();
		}
		return super.visitVariableExp(object);
	}

	@Override
	public @Nullable DomainUsage visitVariablePredicate(@NonNull VariablePredicate object) {
		return visitPredicate(object);
	}
}
