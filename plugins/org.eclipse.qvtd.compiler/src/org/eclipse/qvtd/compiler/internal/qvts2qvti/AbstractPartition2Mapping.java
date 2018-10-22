/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public abstract class AbstractPartition2Mapping
{
	protected final @NonNull QVTs2QVTiVisitor visitor;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ConnectionManager connectionManager;
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull QVTimperativeHelper helper;
	//	protected final @NonNull Region region;
	protected final @NonNull Partition partition;
	@SuppressWarnings("unused")private final @NonNull String regionName;
	protected final @NonNull Mapping mapping;
	@SuppressWarnings("unused")private final @NonNull String mappingName;

	/**
	 * Mapping from QVTm/QVTr element to QVTs Node.
	 */
	private final @NonNull Map<@NonNull Element, @NonNull Node> element2node = new HashMap<>();

	/**
	 * Safe name for each node
	 */
	private final @NonNull Map<@NonNull Node, @NonNull String> node2name = new HashMap<>();

	/**
	 * Safe name for each node
	 */
	private final @NonNull Set<@NonNull String> names;

	/**
	 * The QVTi variable for each connection.
	 */
	protected Map<@NonNull NodeConnection, @NonNull ConnectionVariable> connection2variable = null;

	public AbstractPartition2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Partition partition) {
		this.visitor = visitor;
		this.scheduleManager = visitor.getScheduleManager();
		this.connectionManager = scheduleManager.getConnectionManager();
		this.environmentFactory = scheduleManager.getEnvironmentFactory();
		this.helper = new QVTimperativeHelper(environmentFactory);
		this.partition = partition;
		this.regionName = partition.getName();
		String mappingName = partition.getSymbolName();
		assert mappingName != null;
		this.mapping = helper.createMapping(mappingName);
		this.mappingName = mappingName;
		Region originalRegion = partition.getRegion();
		if (originalRegion instanceof RuleRegion) {
			this.mapping.setIsAbstract(((RuleRegion)originalRegion).getReferredRule().isIsAbstract());
		}
		this.names = new HashSet<>(visitor.getReservedNames());
		for (@NonNull Node node : partition.getPartialNodes()) {
			for (@NonNull Element element : node.getOriginatingElements()) {
				Node oldNode = element2node.put(element, node);
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
			if (asProperty == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
				return helper.createOperationCallExp(asSource, "oclContainer");
			}
			else if ((asType != null) && (asProperty == scheduleManager.getCastProperty(asType))) {
				return createOclAsTypeCallExp(asSource, asType);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		NavigationCallExp asNavigationCallExp = helper.createNavigationCallExp(asSource, asProperty);
		if (!asSource.isIsRequired()) {
			asNavigationCallExp.setIsSafe(true);
			asNavigationCallExp.setIsRequired(false);
		}
		return asNavigationCallExp;
	}

	protected void createAppendParameters() {
		List<@NonNull NodeConnection> intermediateConnections = QVTscheduleUtil.getIntermediateConnections(partition);
		if (intermediateConnections.size() > 0) {
			connection2variable = new HashMap<>();
			for (@NonNull NodeConnection connection : intermediateConnections) {
				AppendParameter connectionVariable = createAppendParameter(connection);
				connection2variable.put(connection, connectionVariable);
				mapping.getOwnedMappingParameters().add(connectionVariable);
			}
		}
	}

	public @NonNull MappingCall createMappingCall(@NonNull List<@NonNull MappingParameterBinding> mappingParameterBindings) {
		return helper.createMappingCall(getMapping(), mappingParameterBindings);
	}

	protected @NonNull CallExp createOclAsTypeCallExp(@NonNull OCLExpression asSource, @NonNull Type asType) {
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(asType);
		TypeExp asTypeExp = helper.createTypeExp(completeClass.getPrimaryClass());
		return helper.createOperationCallExp(asSource, "oclAsType", asTypeExp);
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
		IdResolver idResolver = environmentFactory.getIdResolver();
		Type asType = connectionManager.getSourcesType(connection, idResolver);
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

	protected @NonNull MetamodelManager getMetamodelManager() {
		return visitor.getMetamodelManager();
	}

	public @Nullable Node getNode(@Nullable Element qvtmElement) {
		if (qvtmElement instanceof VariableExp) {
			return getNode(((VariableExp)qvtmElement).getReferredVariable());
		}
		if (qvtmElement instanceof LetExp) {
			return getNode(((LetExp)qvtmElement).getOwnedIn());
		}
		if (qvtmElement instanceof OppositePropertyCallExp) {
			OppositePropertyCallExp propertyCallExp = (OppositePropertyCallExp)qvtmElement;
			Node sourceNode = getNode(propertyCallExp.getOwnedSource());
			if (sourceNode != null) {
				return sourceNode.getNavigableTarget(ClassUtil.nonNullState(propertyCallExp.getReferredProperty().getOpposite()));
			}
		}
		if (qvtmElement instanceof PropertyCallExp) {
			PropertyCallExp propertyCallExp = (PropertyCallExp)qvtmElement;
			Node sourceNode = getNode(propertyCallExp.getOwnedSource());
			if (sourceNode != null) {
				return sourceNode.getNavigableTarget(ClassUtil.nonNullState(propertyCallExp.getReferredProperty()));
			}
		}
		if (qvtmElement != null) {
			return element2node.get(qvtmElement);
		}
		else {
			return null;
		}
	}

	protected @NonNull Operation getObjectsOfKindOperation() {
		StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
		Type modelType = standardLibrary.getLibraryType("Model");
		OperationId objectsOfKindOperationId = modelType.getTypeId().getOperationId(1, "objectsOfKind", IdManager.getParametersId(TypeId.T_1));
		Operation objectsOfKindOperation = environmentFactory.getIdResolver().getOperation(objectsOfKindOperationId);
		return objectsOfKindOperation;
	}

	protected @NonNull Operation getOclIsKindOfOperation() {
		org.eclipse.ocl.pivot.Class oclAnyType = ((StandardLibraryInternal)visitor.getStandardLibrary()).getOclAnyType();
		Operation oclIsKindOfOperation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclIsKindOf");
		assert oclIsKindOfOperation != null;
		return oclIsKindOfOperation;
	}

	//	public @NonNull Region getRegion() {
	//		return region;
	//	}

	protected @NonNull Operation getRootObjectsOperation() {
		StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
		Type modelType = standardLibrary.getLibraryType("Model");
		OperationId rootObjectsOperationId = modelType.getTypeId().getOperationId(1, "rootObjects", IdManager.getParametersId());
		Operation rootObjectsOperation = environmentFactory.getIdResolver().getOperation(rootObjectsOperationId);
		return rootObjectsOperation;
	}

	protected @NonNull String getSafeName(@NonNull Node node) {
		String name = node2name.get(node);
		if (name == null) {
			name = getSafeName(QVTscheduleUtil.getName(node));
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

	public abstract void synthesizeCallStatements();
	public abstract void synthesizeLocalStatements();

	@Override
	public String toString() {
		return mapping.toString();
	}
}