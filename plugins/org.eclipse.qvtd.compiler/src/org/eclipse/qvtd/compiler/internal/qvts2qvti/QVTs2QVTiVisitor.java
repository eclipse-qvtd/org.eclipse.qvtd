/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MappingPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameReservation;

import com.google.common.collect.Iterables;

public class QVTs2QVTiVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable Element, @Nullable Object>
{
	public class EarliestPartitionComparator implements Comparator<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>
	{
		public @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> sort(@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses) {
			List<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> sortedPartitionAnalyses = new ArrayList<>();
			Iterables.addAll(sortedPartitionAnalyses, partitionAnalyses);
			Collections.sort(sortedPartitionAnalyses, this);
			return sortedPartitionAnalyses;
		}

		@Override
		public int compare(@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> o1, @NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> o2) {
			int i1 = o1.getPartition().getFirstPass();
			int i2 = o2.getPartition().getFirstPass();
			return i1 - i2;
		}
	}

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull QVTimperativeHelper helper;
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull Transformation qvtmTransformation;
	protected final @NonNull SymbolNameReservation symbolNameReservation;

	protected final @NonNull Transformation qvtiTransformation;
	protected final @NonNull Map<@NonNull TypedModel, @NonNull ImperativeTypedModel> qvtmTypedModel2qvtiTypedModel = new HashMap<>();
	protected final @NonNull List<@NonNull ImperativeTypedModel> checkableTypedModels = new ArrayList<>();
	protected final @NonNull List<@NonNull ImperativeTypedModel> checkableAndEnforceableTypedModels = new ArrayList<>();
	protected final @NonNull List<@NonNull ImperativeTypedModel> enforceableTypedModels = new ArrayList<>();
	protected final @NonNull Map<@NonNull Partition, @NonNull AbstractPartition2Mapping> partition2partition2mapping = new HashMap<>();
	private @Nullable Set<@NonNull String> reservedNames = null;
	private @NonNull Map<@NonNull Operation, @NonNull Operation> qvtmOperation2qvtiOperation = new HashMap<>();

	private final @NonNull Set<@NonNull Transformation> otherTransformations = new HashSet<>();	// Workaround Bug 481658
	private final @NonNull Map<@NonNull String, @NonNull Operation> name2operation = new HashMap<>();	// Workaround Bug 481658

	private /*@LazyNonNull*/ ImperativeTypedModel qvtiMiddleTypedModel = null;
	private @NonNull Map<@NonNull ClassDatum, @NonNull Function> classDatum2keyFunction = new HashMap<>();

	public QVTs2QVTiVisitor(@NonNull ScheduleManager scheduleManager, @NonNull ProblemHandler problemHandler, @NonNull QVTimperativeHelper helper, @NonNull Transformation qvtmTransformation, @NonNull SymbolNameReservation symbolNameReservation) {
		super(null);
		this.scheduleManager = scheduleManager;
		this.helper = helper;
		this.environmentFactory = helper.getEnvironmentFactory();
		this.problemHandler = problemHandler;
		this.qvtmTransformation = qvtmTransformation;
		this.symbolNameReservation = symbolNameReservation;
		String transformationName = qvtmTransformation.getName();
		assert transformationName != null;
		qvtiTransformation = helper.createTransformation(transformationName);
		createTypedModels();
		//		analyzeConnections();
	}

	private void accumulateOperations(@NonNull Transformation transformation) {
		if (otherTransformations.add(transformation)) {
			for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Operation) {
					Operation operation = (Operation) eObject;
					String name = String.valueOf(operation);
					name2operation.put(name, operation);
				}
			}
		}
	}

	/*	private void analyzeConnection(@NonNull Connection connection) {
		assert connection.isPassed();
		Region commonRegion = null;
		for (Node source : connection.getSources()) {
			Region sourceRegion = source.getRegion();
			if (commonRegion == null) {
				commonRegion = sourceRegion;
			}
			else {
				commonRegion = region2depth.getCommonRegion(commonRegion, sourceRegion);
			}
		}
		assert commonRegion != null;
		connection2commonRegion.put(connection, commonRegion);
		List<Connection> connections = region2connections.get(commonRegion);
		if (connections == null) {
			connections = new ArrayList<>();
			region2connections.put(commonRegion, connections);
		}
		connections.add(connection);
	}

	private void analyzeConnections() {
		for (Region region : regionOrdering.getRegionOrdering()) {
			if (region.isConnectionRegion()) {
				Connection connectionRegion = (Connection)region;
				if (connectionRegion.isPassed()) {
					analyzeConnection(connectionRegion);
				}
			}
		}
	} */

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	public @Nullable Operation create(@Nullable Operation pOperation) {
		if (pOperation == null) {
			return null;
		}
		Operation iOperation = qvtmOperation2qvtiOperation.get(pOperation);
		if (iOperation == null) {
			Transformation containingTransformation = QVTbaseUtil.basicGetContainingTransformation(pOperation);
			if (containingTransformation == qvtmTransformation) {
				iOperation = EcoreUtil.copy(pOperation);
				assert iOperation != null;
				qvtmOperation2qvtiOperation.put(pOperation, iOperation);
				qvtiTransformation.getOwnedOperations().add(iOperation);
			}
			else {					// FIXME Foreign queries ...
				// FIXME working around Bug 481658
				if (containingTransformation != null) {
					accumulateOperations(containingTransformation);
				}
				Operation otherOperation = name2operation.get(pOperation.toString());
				if (otherOperation != null) {
					iOperation = EcoreUtil.copy(pOperation);
					assert iOperation != null;
					qvtmOperation2qvtiOperation.put(pOperation, iOperation);
					qvtiTransformation.getOwnedOperations().add(iOperation);
				}
				else {
					iOperation = pOperation;
					qvtmOperation2qvtiOperation.put(pOperation, iOperation);
				}
			}
		}
		return iOperation;
	}

	private void createKeyFunctions(@NonNull Map<@NonNull ClassDatum, Set<@NonNull PropertyDatum>> keyedClassDatum2propertyDatums) {
		List<@NonNull ClassDatum> classDatums = new ArrayList<>(keyedClassDatum2propertyDatums.keySet());
		Collections.sort(classDatums, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull ClassDatum classDatum : classDatums) {
			org.eclipse.ocl.pivot.Class primaryClass = classDatum.getPrimaryClass();
			List<@NonNull PropertyDatum> propertyDatums = new ArrayList<>(keyedClassDatum2propertyDatums.get(classDatum));
			Collections.sort(propertyDatums, NameUtil.NAMEABLE_COMPARATOR);
			String functionName = scheduleManager.getNameGenerator().createKeyFunctionName(classDatum);
			List<@NonNull FunctionParameter> asParameters = new ArrayList<>();
			List<@NonNull ShadowPart> asShadowParts = new ArrayList<>();
			//
			//	One shadow part per key property datum
			//
			for (@NonNull PropertyDatum propertyDatum : propertyDatums) {
				Property keyProperty = QVTscheduleUtil.getReferredProperty(propertyDatum);
				FunctionParameter cParameter = helper.createFunctionParameter(keyProperty);
				asParameters.add(cParameter);
				ShadowPart asShadowPart = helper.createShadowPart(keyProperty, helper.createVariableExp(cParameter));
				asShadowParts.add(asShadowPart);
			}
			Collections.sort(asParameters, NameUtil.NAMEABLE_COMPARATOR);
			//
			//	One shadow part per uninitialized key property
			//
			/*			for (@NonNull Property asProperty : completeClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
				if (!asProperty.isIsImplicit() && !asProperty.isIsMany() && (asProperty != scheduleManager.getStandardLibraryHelper().getOclContainerProperty())) {
					boolean gotIt = false;
					for (@NonNull ShadowPart asShadowPart : asShadowParts) {
						if (asShadowPart.getReferredProperty() == asProperty) {
							gotIt = true;
							break;
						}
					}
					if (!gotIt) {
						ShadowPart asShadowPart = createShadowPart(asProperty, createNullLiteralExp());
						asShadowParts.add(asShadowPart);
					}
				}
			} */
			Function asFunction = helper.createFunction(functionName, primaryClass, true, asParameters);
			OCLExpression asShadowExp = helper.createShadowExp(primaryClass, asShadowParts);
			asFunction.setQueryExpression(asShadowExp);
			qvtiTransformation.getOwnedOperations().add(asFunction);
			classDatum2keyFunction.put(classDatum, asFunction);
		}
	}

	public void createPartition2Mapping(@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis) {
		Partition partition = partitionAnalysis.getPartition();
		AbstractPartition2Mapping partition2mapping = partition2partition2mapping.get(partition);
		assert partition2mapping == null : "Re-AbstractPartition2Mapping for " + partition;
		//		assert !region.isConnectionRegion();
		if (partition instanceof LoadingPartition) {
			String mappingName = partition.getSymbolName();
			assert mappingName != null;
			EntryPoint entryPoint = helper.createEntryPoint(mappingName);
			for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(qvtmTransformation)) {
				if (scheduleManager.isInput(typedModel) && !typedModel.isIsPrimitive()) {
					entryPoint.getCheckedTypedModels().add(qvtmTypedModel2qvtiTypedModel.get(typedModel));
				}
				if (scheduleManager.isOutput(typedModel)) {
					entryPoint.getEnforcedTypedModels().add(qvtmTypedModel2qvtiTypedModel.get(typedModel));
				}
			}
			partition2mapping = new LoadingPartition2Mapping(this, entryPoint, (LoadingPartition)partition);
		}
		else {
			String mappingName = partition.getSymbolName();
			assert mappingName != null;
			Mapping mapping = helper.createMapping(mappingName);
			partition2mapping = new BasicPartition2Mapping(this, mapping, (MappingPartitionAnalysis<?>) partitionAnalysis);
		}
		partition2mapping.synthesizeLocalStatements();
		partition2partition2mapping.put(partition, partition2mapping);
		qvtiTransformation.getRule().add(partition2mapping.getMapping());
		visitPartition(partition);
		//		for (@SuppressWarnings("null")@NonNull Region childRegion : region.getCalledRegions()) {
		//			if (region2region2mapping.get(childRegion) == null) {
		//				createRegion2Mapping(childRegion);
		//			}
		//		}
	}

	protected void createTypedModels() {
		for (TypedModel qvtmTypedModel : qvtmTransformation.getModelParameter()) {
			String typedModelName = qvtmTypedModel.getName();
			assert typedModelName != null;
			ImperativeTypedModel qvtiTypedModel = helper.createTypedModel(typedModelName);
			qvtiTypedModel.getUsedPackage().addAll(qvtmTypedModel.getUsedPackage());
			boolean isPrimitive = qvtmTypedModel.isIsPrimitive();
			boolean isTrace = qvtmTypedModel.isIsTrace();
			qvtiTypedModel.setIsPrimitive(isPrimitive);
			qvtiTypedModel.setIsTrace(isTrace);
			if (isTrace) {
				assert qvtiMiddleTypedModel == null;
				qvtiMiddleTypedModel = qvtiTypedModel;
			}
			qvtmTypedModel2qvtiTypedModel.put(qvtmTypedModel, qvtiTypedModel);
			qvtiTransformation.getModelParameter().add(qvtiTypedModel);
		}
		for (@NonNull Rule rule : QVTbaseUtil.getRule(qvtmTransformation)) {
			for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(rule)) {
				TypedModel typedModel = domain.getTypedModel();
				if (typedModel != null) {
					/*	if (scheduleManager.isInput(domain)) {
						ImperativeTypedModel checkableTypedModel = qvtmTypedModel2qvtiTypedModel.get(typedModel);
						if ((checkableTypedModel != null) && !checkableAndEnforceableTypedModels.contains(checkableTypedModel)) {
							checkableTypedModel.setIsChecked(true);
							if (enforceableTypedModels.contains(checkableTypedModel)) {
								checkableAndEnforceableTypedModels.add(checkableTypedModel);
								enforceableTypedModels.remove(checkableTypedModel);
							}
							else if (!checkableTypedModels.contains(checkableTypedModel)) {
								checkableTypedModels.add(checkableTypedModel);
							}
						}
					}
					if (scheduleManager.isOutput(domain)) {
						ImperativeTypedModel enforceableTypedModel = qvtmTypedModel2qvtiTypedModel.get(typedModel);
						if ((enforceableTypedModel != null) && !checkableAndEnforceableTypedModels.contains(enforceableTypedModel)) {
							enforceableTypedModel.setIsEnforced(true);
							if (checkableTypedModels.contains(enforceableTypedModel)) {
								checkableAndEnforceableTypedModels.add(enforceableTypedModel);
								checkableTypedModels.remove(enforceableTypedModel);
							}
							else if (!enforceableTypedModels.contains(enforceableTypedModel)) {
								enforceableTypedModels.add(enforceableTypedModel);
							}
						}
					} */
				}
			}
		}
	}

	protected @NonNull Map<@NonNull ClassDatum, Set<@NonNull PropertyDatum>> gatherKeyCalls(List<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> sortedPartitionAnalyses) {
		Map<@NonNull ClassDatum, Set<@NonNull PropertyDatum>> keyedClassDatum2propertyDatums = new HashMap<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : sortedPartitionAnalyses) {
			Partition partition = partitionAnalysis.getPartition();
			for (@NonNull Node node : partition.getPartialNodes()) {
				if (node instanceof KeyedValueNode) {
					KeyedValueNode keyedValueNode = (KeyedValueNode)node;
					ClassDatum classDatum = keyedValueNode.getClassDatumValue();
					assert classDatum != null;
					Set<@NonNull PropertyDatum> propertyDatums = new HashSet<>();
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(keyedValueNode)) {
						if (edge instanceof KeyPartEdge) {
							KeyPartEdge keyPartEdge = (KeyPartEdge)edge;
							PropertyDatum propertyDatum = QVTscheduleUtil.getReferredPart(keyPartEdge);
							assert propertyDatum.isKey();
							boolean wasAdded = propertyDatums.add(propertyDatum);
							assert wasAdded;

						}
					}
					Set<@NonNull PropertyDatum> oldPropertyDatums = keyedClassDatum2propertyDatums.put(classDatum, propertyDatums);
					assert (oldPropertyDatums == null) || oldPropertyDatums.equals(propertyDatums);
				}
			}
		}
		return keyedClassDatum2propertyDatums;
	}

	protected void gatherReservedPackageNames(@NonNull Set<@NonNull String> reservedNames, @NonNull Iterable<org.eclipse.ocl.pivot.Package> asPackages) {
		for (org.eclipse.ocl.pivot.Package asPackage : asPackages) {
			reservedNames.add(ClassUtil.nonNullState(asPackage.getName()));
			gatherReservedClassNames(reservedNames, asPackage.getOwnedClasses());
			gatherReservedPackageNames(reservedNames, asPackage.getOwnedPackages());
		}
	}

	protected void gatherReservedClassNames(@NonNull Set<@NonNull String> reservedNames, @NonNull Iterable<org.eclipse.ocl.pivot.Class> asClasses) {
		for (org.eclipse.ocl.pivot.Class asClass : asClasses) {
			reservedNames.add(ClassUtil.nonNullState(asClass.getName()));
		}
	}

	public @NonNull ConnectionManager getConnectionManager() {
		return scheduleManager.getConnectionManager();
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull Operation getEqualsOperation() {
		StandardLibrary standardLibrary = getStandardLibrary();
		org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
		Operation operation1 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
		assert operation1 != null;
		OperationId oclAnyEqualsId = operation1.getOperationId();
		return environmentFactory.getIdResolver().getOperation(oclAnyEqualsId);
	}

	public @NonNull Function getKeyFunction(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum2keyFunction.get(classDatum));
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	public @NonNull Operation getNotEqualsOperation() {
		StandardLibrary standardLibrary = getStandardLibrary();
		org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
		Operation operation1 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "<>");
		assert operation1 != null;
		OperationId oclAnyEqualsId = operation1.getOperationId();
		return environmentFactory.getIdResolver().getOperation(oclAnyEqualsId);
	}

	public @Nullable ImperativeTypedModel getQVTiTypedModel(@Nullable TypedModel qvtmTypedModel) {
		if (qvtmTypedModel == null) {
			assert qvtiMiddleTypedModel != null;
			return qvtiMiddleTypedModel;
		}
		return qvtmTypedModel2qvtiTypedModel.get(qvtmTypedModel);
	}

	public @NonNull AbstractPartition2Mapping getPartition2Mapping(@NonNull Partition partition) {
		Partition mergedPartition = QVTscheduleUtil.getMergedPartition(partition);
		AbstractPartition2Mapping region2mapping = partition2partition2mapping.get(mergedPartition);
		assert region2mapping != null : "No AbstractRegion2Mapping for " + mergedPartition;
		return region2mapping;
	}

	public @NonNull ProblemHandler getProblemHandler() {
		return problemHandler;
	}

	public @NonNull Set<@NonNull String> getReservedNames() {
		Set<@NonNull String> reservedNames2 = reservedNames;
		if (reservedNames2 == null) {
			reservedNames = reservedNames2 = new HashSet<>();
			org.eclipse.ocl.pivot.Package standardLibraryPackage = getStandardLibrary().getPackage();
			gatherReservedPackageNames(reservedNames2, Collections.singletonList(standardLibraryPackage));
			reservedNames2.add(ClassUtil.nonNull(qvtmTransformation.getName()));
			for (TypedModel typedModel : qvtmTransformation.getModelParameter()) {
				reservedNames2.add(ClassUtil.nonNullState(typedModel.getName()));
				gatherReservedPackageNames(reservedNames2, typedModel.getUsedPackage());
			}
			for (Operation operation : qvtmTransformation.getOwnedOperations()) {
				reservedNames2.add(ClassUtil.nonNull(operation.getName()));
			}
			for (Property property : qvtmTransformation.getOwnedProperties()) {
				reservedNames2.add(ClassUtil.nonNull(property.getName()));
			}
		}
		return reservedNames2;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	public @NonNull Transformation getTransformation() {
		return qvtiTransformation;
	}

	public @NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Object object) {
		return symbolNameReservation.reserveSymbolName(symbolNameBuilder, object);
	}

	//	private @NonNull Node selectHeadNode(@NonNull List<Node> headNodes) {
	//		return headNodes.get(0);			// FIXME best
	//	}

	@Override
	public @Nullable Element visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public Element visitEdge(@NonNull Edge edge) {
		return visiting(edge);
	}

	@Override
	public Element visitEdgeConnection(@NonNull EdgeConnection edgeConnection) {
		return visiting(edgeConnection);
	}

	/*	@Override
	public @Nullable Element visitLoadingRegion(@NonNull LoadingRegion loadingRegion) {
		AbstractPartition2Mapping region2mapping = getPartition2Mapping(scheduleManager.wipGetPartition(loadingRegion));
		Mapping mapping = region2mapping.getMapping();
		//		for (@SuppressWarnings("null")@NonNull List<Node> headNodes : rootContainmentRegion.getHeadNodeGroups()) {
		//			Node headNode = selectHeadNode(headNodes);
		//			Variable headVariable = region2mapping.getGuardVariable(headNode);
		//			getGuardPattern(mapping).getVariable().add(guardVariable);
		//		}
		return mapping;
	} */

	@Override
	public @Nullable Element visitMappingRegion(@NonNull MappingRegion mappingRegion) {
		//		AbstractPartition2Mapping partition2mapping = getPartition2Mapping(scheduleManager.wipGetPartition(mappingRegion));
		//		return partition2mapping.getMapping();
		return visiting(mappingRegion);
	}

	@Override
	public Element visitNavigableEdge(@NonNull NavigableEdge navigableEdge) {
		return visitEdge(navigableEdge);
	}

	@Override
	public Element visitNode(@NonNull Node node) {
		return visiting(node);
	}

	@Override
	public Element visitNodeConnection(@NonNull NodeConnection nodeConnection) {
		return visiting(nodeConnection);
	}

	@Override
	public @Nullable Element visitOperationRegion(@NonNull OperationRegion operationRegion) {
		return visiting(operationRegion);
	}

	@Override
	public @Nullable Element visitPartition(@NonNull Partition partition) {
		//	if (partition instanceof LoadingPartition) {
		AbstractPartition2Mapping partition2mapping = getPartition2Mapping(partition);
		return partition2mapping.getMapping();
		/* }
		if (partition instanceof AbstractPartialPartition) {
			AbstractPartition2Mapping partition2mapping = getPartition2Mapping(partition);
			return partition2mapping.getMapping();
		}
		Region r2 = partition.getOriginalRegion();
		Region r1 = scheduleManager.wipGetRegion(partition);
		if (r1 instanceof MappingRegion) {
			AbstractPartition2Mapping partition2mapping = getPartition2Mapping(partition);
			return partition2mapping.getMapping();

		}
		assert r1 == r2;
		return scheduleManager.wipGetRegion(partition).accept(this); */
	}

	@Override
	public Element visitRegion(@NonNull Region region) {
		return visiting(region);
	}

	@Override
	public @Nullable Element visitRootRegion(@NonNull RootRegion rootRegion) {
		RootPartitionAnalysis rootPartitionAnalysis = scheduleManager.getRootPartitionAnalysis(rootRegion);
		//		String name = rootRegion.getName();
		//
		//	List<@NonNull Partition> callablePartitions = new ArrayList<>();
		//	LoadingRegion loadingRegion = QVTscheduleUtil.getOwnedLoadingRegion(rootRegion);
		//	callableRegions.add(loadingRegion);
		//	for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(rootRegion)) {
		//		callablePartitions.add(scheduleManager.wipGetPartition(region));
		//	}
		//	Iterable<@NonNull Partition> partitions = rootPartition.getPartitions();
		Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> allPartitionAnalyses = CompilerUtil.gatherPartitionAnalyses(rootPartitionAnalysis, new ArrayList<>());
		//	assert Iterables.contains(partitions, scheduleManager.wipGetPartition(QVTscheduleUtil.getOwnedLoadingRegion(rootRegion)));

		List<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> sortedPartitionAnalyses = new EarliestPartitionComparator().sort(allPartitionAnalyses);
		Map<@NonNull ClassDatum, Set<@NonNull PropertyDatum>> keyedClassDatum2propertyDatums = gatherKeyCalls(sortedPartitionAnalyses);
		createKeyFunctions(keyedClassDatum2propertyDatums);
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : sortedPartitionAnalyses) {
			//			if (!region.isConnectionRegion()) {
			Partition partition = partitionAnalysis.getPartition();
			if (!CompilerUtil.isAbstract(partition)) {
				createPartition2Mapping(partitionAnalysis);
			}
			//			}
		}
		//		Region rootRegion = regionOrdering.getRootRegion();
		//		chainGraph = new ChainGraph(region2depth, rootRegion, regionOrdering.getSchedulableOrdering());
		//		@SuppressWarnings("null")@NonNull URI baseURI = qvtmTransformation.eResource().getURI();
		//		chainGraph.writeChainDOTfile(baseURI, "c");
		//		chainGraph.writeChainGraphMLfile(baseURI, "c");
		//

		/*		Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges = new HashMap<>();
		for (@SuppressWarnings("null")@NonNull Region region : sortedRegions) {
			AbstractRegion2Mapping region2Mapping = getRegion2Mapping(region);
			region2Mapping.computeRealizations(typedModel2property2realizedEdges);
		}
		boolean doDebug = QVTs2QVTiVisitor.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			for (TypedModel typedModel : typedModel2property2realizedEdges.keySet()) {
				Map<Property, List<NavigationEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
				for (Property property : property2realizedEdges.keySet()) {
					List<NavigationEdge> realizedEdges = property2realizedEdges.get(property);
					for (NavigationEdge realizedEdge : realizedEdges) {
						Region region = realizedEdge.getRegion();
						QVTs2QVTiVisitor.POLLED_PROPERTIES.println(typedModel + " enforced at " + region.getEarliestIndex()
						+ ".." + region.getLatestIndex() + " for " + property + " in " + region);
					}
				}
			}
		}
		for (@SuppressWarnings("null")@NonNull Region region : sortedRegions) {
			AbstractRegion2Mapping region2Mapping = getRegion2Mapping(region);
			region2Mapping.checkAndEnforceRealizations(typedModel2property2realizedEdges);
		} */
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : sortedPartitionAnalyses) {
			Partition partition = partitionAnalysis.getPartition();
			if (!CompilerUtil.isAbstract(partition)) {
				AbstractPartition2Mapping partition2Mapping = getPartition2Mapping(partition);
				partition2Mapping.synthesizeCallStatements();
			}
		}
		// Mappings are in schedule index order.
		//		ECollections.sort(qvtiTransformation.getRule(), NameUtil.NameableComparator.INSTANCE);
		/*		org.eclipse.ocl.pivot.Package rootPackage = PivotUtil.createPackage("", "yy", "zz", null);
		rootPackage.getOwnedClasses().add(qvtiTransformation);
		Model model = PivotUtil.createModel(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, null);
		model.getOwnedPackages().add(rootPackage);
		List<@NonNull Namespace> importedNamespaces = new ArrayList<>();
		for (@NonNull TypedModel typedModel : qvtmTypedModel2qvtiTypedModel.values()) {
			for (Namespace importedNamespace : ClassUtil.nullFree(typedModel.getUsedPackage())) {
				if (!importedNamespaces.contains(importedNamespace)) {
					importedNamespaces.add(importedNamespace);
				}
			}
		}
		Collections.sort(importedNamespaces, NameUtil.NAMEABLE_COMPARATOR);
		List<Import> ownedImports = model.getOwnedImports();
		for (@NonNull Namespace importedNamespace : importedNamespaces) {
			ownedImports.add(createImport(null, importedNamespace));
		} */
		return qvtiTransformation;
	}

	@Override
	public Element visitVariableNode(@NonNull VariableNode variableNode) {
		return visitNode(variableNode);
	}
}
