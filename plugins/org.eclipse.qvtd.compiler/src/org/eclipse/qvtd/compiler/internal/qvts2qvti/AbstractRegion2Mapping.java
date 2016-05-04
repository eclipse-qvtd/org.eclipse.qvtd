/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public abstract class AbstractRegion2Mapping
{
	protected final @NonNull QVTs2QVTiVisitor visitor;
	protected final @NonNull QVTimperativeHelper helper;
	protected final @NonNull Region region;
	protected final @NonNull Mapping mapping;
	
	/**
	 * Mapping from QVTp expression to Schedule Node.
	 */
	private final @NonNull Map<@NonNull TypedElement, @NonNull Node> qvtp2node = new HashMap<@NonNull TypedElement, @NonNull Node>();
	
	/**
	 * Safe name for each node
	 */
	private final @NonNull Map<@NonNull Node, @NonNull String> node2name = new HashMap<@NonNull Node, @NonNull String>();
	
	/**
	 * Safe name for each node
	 */
	private final @NonNull Set<@NonNull String> names;

	/**
	 * The QVTi variable for each connection.
	 */
	protected Map<@NonNull NodeConnection, @NonNull Variable> connection2variable = null;

	public AbstractRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		this.visitor = visitor;
		this.helper = new QVTimperativeHelper(visitor.getEnvironmentFactory());
		this.region = region;
		String name = region.getSymbolName();
		assert name != null;
		this.mapping = QVTimperativeUtil.createMapping(name);
		this.names = new HashSet<@NonNull String>(visitor.getReservedNames());
		for (Node node : region.getNodes()) {
			for (TypedElement typedElement : node.getTypedElements()) {
				Node oldNode = qvtp2node.put(typedElement, node);
				assert (oldNode == null) || (oldNode == node);
			}
		}
	}
	
	protected @NonNull CallExp createCallExp(@NonNull OCLExpression asSource, @NonNull Property asProperty) {
		if (asProperty.eContainer() == null) {
			Type asType = asProperty.getType();
			SchedulerConstants schedulerConstants = getRegion().getSchedulerConstants();
			if (asProperty == schedulerConstants.getOclContainerProperty()) {
				return helper.createOperationCallExp(asSource, "oclContainer");
			}
			else if ((asType != null) && (asProperty == schedulerConstants.getCastProperty(asType))) {
				return createOclAsTypeCallExp(asSource, asType);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		return PivotUtil.createNavigationCallExp(asSource, asProperty);
	}

	protected void createConnectionAssignment(@NonNull ConnectionVariable connectionVariable, @NonNull OCLExpression childrenExpression) {
		ConnectionAssignment connectionAssignment = helper.createConnectionAssignment(connectionVariable, childrenExpression);
		mapping.getBottomPattern().getAssignment().add(connectionAssignment);
	}

	protected @NonNull ConnectionVariable createConnectionVariable(@NonNull NodeConnection connection) {
		Type asType = getConnectionSourcesType(connection);
		String name = connection.getName();
		assert name != null;
		return helper.createConnectionVariable(getSafeName(name), asType, null);
	}

	protected void createConnectionGuardVariables() {
		List<@NonNull NodeConnection> intermediateConnections = region.getIntermediateConnections();
		if (intermediateConnections.size() > 0) {
			connection2variable = new HashMap<@NonNull NodeConnection, @NonNull Variable>();
			for (@NonNull NodeConnection connection : intermediateConnections) {
				ConnectionVariable connectionVariable = createConnectionVariable(connection);
				connection2variable.put(connection, connectionVariable);
				mapping.getGuardPattern().getVariable().add(connectionVariable);
			}
		}
	}

	protected @NonNull CallExp createOclAsTypeCallExp(@NonNull OCLExpression asSource, @NonNull Type asType) {
		SchedulerConstants schedulerConstants = getRegion().getSchedulerConstants();
		CompleteClass completeClass = schedulerConstants.getEnvironmentFactory().getCompleteModel().getCompleteClass(asType);
		TypeExp asTypeExp = helper.createTypeExp(completeClass.getPrimaryClass());
		return helper.createOperationCallExp(asSource, "oclAsType", asTypeExp);
	}

/*	protected @NonNull OperationCallExp createOperationCallExp(@NonNull OCLExpression asSource, @NonNull Operation asOperation, /*@NonNull* / OCLExpression... asArguments) {
		PivotMetamodelManager metamodelManager = getMetamodelManager();
		StandardLibraryInternal standardLibrary = metamodelManager.getStandardLibrary();
		@NonNull Operation asBestOperation = asOperation;
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)asSource.getType();
		assert asType != null;
		org.eclipse.ocl.pivot.Class sourceType1 = PivotUtil.getUnspecializedTemplateableElement(asType);
		for (Operation asOverrideOperation : metamodelManager.getFinalAnalysis().getOverrides(asOperation)) {
			if (asOverrideOperation.getOwningClass().conformsTo(standardLibrary, sourceType1)) {		// FIXME arguments, generic method
				asBestOperation = asOverrideOperation;
			}
		}
		OperationCallExp asCallExp = PivotUtil.createOperationCallExp(asSource, asBestOperation, asArguments);
		Type formalType = asBestOperation.getType();
		if ((formalType instanceof TemplateParameter) || ((formalType instanceof TemplateableElement) && (((TemplateableElement)formalType).getUnspecializedElement() != null))) {
			assert formalType != null;
			Type sourceType2 = asSource.getType();
			Type sourceTypeValue = asSource.getTypeValue();
			Type returnType = null;
			if (sourceType2 != null) {
				if (asBestOperation.isIsTypeof()) {
					returnType = metamodelManager.specializeType(formalType, asCallExp, sourceType2, null);
				}
				else {
					returnType = metamodelManager.specializeType(formalType, asCallExp, sourceType2, sourceTypeValue);
				}
			}
			asCallExp.setType(returnType);
		}
		return asCallExp;
	}

	// FIXME Unify two createOperationCallExp's 
	protected @NonNull OperationCallExp createOperationCallExp(@Nullable OCLExpression asSource, @NonNull Operation asOperation, @NonNull List<OCLExpression> asArguments) {
		Type formalType = asOperation.getType();
		OperationCallExp asCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asCallExp.setReferredOperation(asOperation);
		asCallExp.setOwnedSource(asSource);
		asCallExp.getOwnedArguments().addAll(asArguments);
		asCallExp.setIsRequired(asOperation.isIsRequired());

		Type sourceType = null;
		Type sourceTypeValue = null;
		if (asSource != null) {
			sourceType = asSource.getType();
			sourceTypeValue = asSource.getTypeValue();
		}
		Type returnType = null;
		if ((formalType != null) && (sourceType != null)) {
			PivotMetamodelManager metamodelManager = getMetamodelManager();
			if (asOperation.isIsTypeof()) {
				returnType = metamodelManager.specializeType(formalType, asCallExp, sourceType, null);
			}
			else {
				returnType = metamodelManager.specializeType(formalType, asCallExp, sourceType, sourceTypeValue);
			}
		}
		asCallExp.setType(returnType);
		return asCallExp;
	} */

	public abstract void createStatements();

/*	private @NonNull OCLExpression createUnrealizedVariableExp(@NonNull Node node) {	// FIXME redundant
		Variable variable = node2variable.get(node);
		if (variable == null) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			BottomPattern bottomPattern = mapping/*getArea(classDatumAnalysis.getDomainUsage())* /.getBottomPattern();
			OCLExpression initExpression = getExpression(node);
			
			variable = PivotUtil.createVariable(getName(node), classDatumAnalysis.getCompleteClass().getPrimaryClass(), true, initExpression);
			bottomPattern.getVariable().add(variable);
			node2variable.put(node, variable);
		}
		return PivotUtil.createVariableExp(variable);
	} */

	protected @NonNull Variable createVariable(@NonNull Node node) {
		Type asType = node.getClassDatumAnalysis().getCompleteClass().getPrimaryClass();
		assert asType != null;
		return PivotUtil.createVariable(getSafeName(node), asType, true, null);
	}

	protected int getCollectionDepth(@NonNull Type type) {
		if (type instanceof CollectionType) {
			Type elementType = ((CollectionType)type).getElementType();
			assert elementType != null;
			return getCollectionDepth(elementType) + 1;
		}
		return 0;
	}

	protected @NonNull Type getConnectionSourcesType(@NonNull NodeConnection connection) {
		IdResolver idResolver = visitor.getEnvironmentFactory().getIdResolver();
		Type asType = connection.getSourcesType(idResolver);
		assert asType != null;
		return asType;
	}

	public @NonNull Variable getConnectionVariable(@NonNull NodeConnection connection) {
		assert connection2variable != null;
		Variable connectionVariable = connection2variable.get(connection);
		assert connectionVariable != null;
		return connectionVariable;
	}

//	protected @NonNull Iterable<Region> getEarliestFirstCalledRegions() {
//		return AbstractRegion.EarliestRegionComparator.sort(region.getCalledRegions());
//	}

	public abstract @NonNull List<@NonNull Node> getGuardNodes();

	public abstract @NonNull Variable getGuardVariable(@NonNull Node node);

/*	private @Nullable OCLExpression getInitExpression(@NonNull Node node) {		
		List<Edge> incomingEdges = node.getIncomingEdges();
		if (incomingEdges != null) {
			for (Edge edge : incomingEdges) {
				EdgeRole edgeRole = edge.getEdgeRole();
				if (edgeRole.isNavigation() && edgeRole.isLoaded()) {
					OCLExpression source = edge.getSource());
					if (source != null) {
						return createPropertyCallExp(source, ((NavigationEdge)edge).getProperty());
					}
				}
			}
		}
		return null;
	} */

	public @NonNull Mapping getMapping() {
		return mapping;
	}

	protected @NonNull PivotMetamodelManager getMetamodelManager() {
		return (PivotMetamodelManager)visitor.getMetamodelManager();
	}
	
	public @Nullable Node getNode(@Nullable TypedElement qvtpTypedElement) {
		if (qvtpTypedElement instanceof VariableExp) {
			return getNode(((VariableExp)qvtpTypedElement).getReferredVariable());
		}
		if (qvtpTypedElement instanceof OppositePropertyCallExp) {
			OppositePropertyCallExp propertyCallExp = (OppositePropertyCallExp)qvtpTypedElement;
			Node sourceNode = getNode(propertyCallExp.getOwnedSource());
			if (sourceNode != null) {
				return sourceNode.getNavigationTarget(ClassUtil.nonNullState(propertyCallExp.getReferredProperty().getOpposite()));
			}
		}
		if (qvtpTypedElement instanceof PropertyCallExp) {
			PropertyCallExp propertyCallExp = (PropertyCallExp)qvtpTypedElement;
			Node sourceNode = getNode(propertyCallExp.getOwnedSource());
			if (sourceNode != null) {
				return sourceNode.getNavigationTarget(ClassUtil.nonNullState(propertyCallExp.getReferredProperty()));
			}
		}
		if (qvtpTypedElement != null) {
			return qvtp2node.get(qvtpTypedElement);
		}
		else {
			return null;
		}
	}

	protected @NonNull Operation getObjectsOfKindOperation() {
		StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
		Type modelType = standardLibrary.getLibraryType("Model");
		OperationId objectsOfKindOperationId = modelType.getTypeId().getOperationId(1, "objectsOfKind", IdManager.getParametersId(TypeId.T_1));
		Operation objectsOfKindOperation = visitor.getEnvironmentFactory().getIdResolver().getOperation(objectsOfKindOperationId);
		return objectsOfKindOperation;
	}

	protected @NonNull Operation getOclIsKindOfOperation() {
		org.eclipse.ocl.pivot.Class oclAnyType = ((StandardLibraryInternal)visitor.getStandardLibrary()).getOclAnyType();
		Operation oclIsKindOfOperation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclIsKindOf");
		assert oclIsKindOfOperation != null;
		return oclIsKindOfOperation;
	}

	public @NonNull Region getRegion() {
		return region;
	}

	protected @NonNull Operation getRootObjectsOperation() {
		StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
		Type modelType = standardLibrary.getLibraryType("Model");
		OperationId rootObjectsOperationId = modelType.getTypeId().getOperationId(1, "rootObjects", IdManager.getParametersId());
		Operation rootObjectsOperation = visitor.getEnvironmentFactory().getIdResolver().getOperation(rootObjectsOperationId);
		return rootObjectsOperation;
	}

	protected @NonNull String getSafeName(@NonNull Node node) {
		String name = node2name.get(node);
		if (name == null) {
			name = getSafeName(node.getName());
		}
		return name;
	}

	protected @NonNull String getSafeName(@NonNull String rawName) {
		String stem = rawName; //StringUtil.convertToOCLString(rawName);
		String name = stem;
		assert name != null;
		int suffix = 1;
		while (names.contains(name)) {
			name = stem + suffix++;
		}
		names.add(name);
		return name;
	}

	protected @NonNull Operation getSelectByKindOperation() {
		org.eclipse.ocl.pivot.Class collectionType = ((StandardLibraryInternal)visitor.getStandardLibrary()).getCollectionType();
		Operation selectByKindOperation = NameUtil.getNameable(collectionType.getOwnedOperations(), "selectByKind");
		assert selectByKindOperation != null;
		return selectByKindOperation;
	}

	public boolean isInfinite() {
		return false;
	}

	// FIXME temporary backward compatibility
	protected void setLegacyIsPolled(@NonNull Mapping calledMapping, @NonNull MappingCallBinding mappingCallBinding) {
/*		for (Domain domain : calledMapping.getDomain()) {
			if (domain instanceof ImperativeDomain) {
				ImperativeDomain imperativeDomain = (ImperativeDomain)domain;
				if (imperativeDomain.getCheckedProperties().size() > 0) {
					mappingCallBinding.setIsPolled(true);
					return;
				}
			}
		} */
	}

	@Override
	public String toString() {
		return mapping.toString();
	}

	public @NonNull MappingCall createMappingCall(@NonNull List<@NonNull MappingCallBinding> mappingCallBindings) {
		return QVTimperativeUtil.createMappingCall(getMapping(), mappingCallBindings);
	}
}