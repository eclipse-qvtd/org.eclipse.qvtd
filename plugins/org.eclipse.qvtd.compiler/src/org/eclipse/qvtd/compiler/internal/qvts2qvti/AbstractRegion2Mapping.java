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
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
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
	protected Map<@NonNull NodeConnection, @NonNull ConnectionVariable> connection2variable = null;

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

	protected void createAddStatement(@NonNull ConnectionVariable connectionVariable, @NonNull OCLExpression childrenExpression) {
		AddStatement addStatement = helper.createAddStatement(connectionVariable, childrenExpression);
		mapping.getOwnedStatements().add(addStatement);
	}

	protected @NonNull AppendParameter createAppendParameter(@NonNull NodeConnection connection) {
		Type asType = getConnectionSourcesType(connection);
		String name = connection.getName();
		assert name != null;
		return helper.createAppendParameter(getSafeName(name), asType, true);
	}

	protected @NonNull CallExp createCallExp(@NonNull OCLExpression asSource, @NonNull Property asProperty) {
		if (asProperty.eContainer() == null) {
			Type asType = asProperty.getType();
			SchedulerConstants schedulerConstants = getRegion().getSchedulerConstants();
			if (asProperty == schedulerConstants.getStandardLibraryHelper().getOclContainerProperty()) {
				return helper.createOperationCallExp(asSource, "oclContainer");
			}
			else if ((asType != null) && (asProperty == schedulerConstants.getCastProperty(asType))) {
				return createOclAsTypeCallExp(asSource, asType);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		return helper.createNavigationCallExp(asSource, asProperty);
	}

	protected void createAppendParameters() {
		List<@NonNull NodeConnection> intermediateConnections = region.getIntermediateConnections();
		if (intermediateConnections.size() > 0) {
			connection2variable = new HashMap<>();
			for (@NonNull NodeConnection connection : intermediateConnections) {
				AppendParameter connectionVariable = createAppendParameter(connection);
				connection2variable.put(connection, connectionVariable);
				mapping.getOwnedParameters().add(connectionVariable);
			}
		}
	}

	protected @NonNull CallExp createOclAsTypeCallExp(@NonNull OCLExpression asSource, @NonNull Type asType) {
		SchedulerConstants schedulerConstants = getRegion().getSchedulerConstants();
		CompleteClass completeClass = schedulerConstants.getEnvironmentFactory().getCompleteModel().getCompleteClass(asType);
		TypeExp asTypeExp = helper.createTypeExp(completeClass.getPrimaryClass());
		return helper.createOperationCallExp(asSource, "oclAsType", asTypeExp);
	}

	public abstract void createStatements();

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

	public @NonNull ConnectionVariable getConnectionVariable(@NonNull NodeConnection connection) {
		assert connection2variable != null;
		ConnectionVariable connectionVariable = connection2variable.get(connection);
		assert connectionVariable != null;
		return connectionVariable;
	}

	//	protected @NonNull Iterable<Region> getEarliestFirstCalledRegions() {
	//		return AbstractRegion.EarliestRegionComparator.sort(region.getCalledRegions());
	//	}

	public abstract @NonNull List<@NonNull Node> getGuardNodes();

	public abstract @NonNull MappingParameter getGuardVariable(@NonNull Node node);

	public @NonNull Mapping getMapping() {
		return mapping;
	}

	protected @NonNull PivotMetamodelManager getMetamodelManager() {
		return visitor.getMetamodelManager();
	}

	public @Nullable Node getNode(@Nullable TypedElement qvtpTypedElement) {
		if (qvtpTypedElement instanceof VariableExp) {
			return getNode(((VariableExp)qvtpTypedElement).getReferredVariable());
		}
		if (qvtpTypedElement instanceof LetExp) {
			return getNode(((LetExp)qvtpTypedElement).getOwnedIn());
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

	@Override
	public String toString() {
		return mapping.toString();
	}

	public @NonNull MappingCall createMappingCall(@NonNull List<@NonNull MappingParameterBinding> mappingParameterBindings) {
		return QVTimperativeUtil.createMappingCall(getMapping(), mappingParameterBindings);
	}
}