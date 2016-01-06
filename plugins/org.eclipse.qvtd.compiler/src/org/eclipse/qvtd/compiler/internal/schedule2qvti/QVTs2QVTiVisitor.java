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
package org.eclipse.qvtd.compiler.internal.schedule2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.scheduler.AbstractRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.CompositionRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.MappingRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.MergedRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.OperationRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.Region;
import org.eclipse.qvtd.compiler.internal.scheduler.Region2Depth;
import org.eclipse.qvtd.compiler.internal.scheduler.RegionOrdering;
import org.eclipse.qvtd.compiler.internal.scheduler.RootRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.ScheduledRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.Visitable;
import org.eclipse.qvtd.compiler.internal.scheduler.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTs2QVTiVisitor implements Visitor<Element>
{
	public static @NonNull Import createImport(@Nullable String name, @NonNull Namespace namespace) {
		Import asImport = PivotFactory.eINSTANCE.createImport();
		asImport.setName(name);
		asImport.setImportedNamespace(namespace);
		return asImport;
	}

	public static final @NonNull TracingOption POLLED_PROPERTIES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvti/polledProperties");
	
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull Transformation qvtpTransformation;
	protected final @NonNull RegionOrdering regionOrdering;

	protected final @NonNull Transformation qvtiTransformation;
	protected final @NonNull Map<TypedModel, TypedModel> qvtpTypedModel2qvtiTypedModel = new HashMap<TypedModel, TypedModel>();
	protected final @NonNull List<TypedModel> checkableTypedModels = new ArrayList<TypedModel>();
	protected final @NonNull List<TypedModel> checkableAndEnforceableTypedModels = new ArrayList<TypedModel>();
	protected final @NonNull List<TypedModel> enforceableTypedModels = new ArrayList<TypedModel>();
	protected final @NonNull Map<Region, AbstractRegion2Mapping> region2region2mapping = new HashMap<Region, AbstractRegion2Mapping>();
	private @Nullable Set<String> reservedNames = null;
	private @NonNull Map<Operation, Operation> qvtpOperation2qvtiOperation = new HashMap<Operation, Operation>();
	private final @NonNull Region2Depth region2depth = new Region2Depth();
	
	private final @NonNull Set<Transformation> otherTransformations = new HashSet<Transformation>();	// Workaround Bug 481658
	private final @NonNull Map<String, Operation> name2operation = new HashMap<String, Operation>();	// Workaround Bug 481658
	
	 /**
	  * Mapping from connection to the common Region that hosts the connection variable.
	  */
//	private final @NonNull Map<Connection, Region> connection2commonRegion = new HashMap<Connection, Region>();
	
	public QVTs2QVTiVisitor(@NonNull EnvironmentFactory environmentFactory, @NonNull Transformation qvtpTransformation, @NonNull RegionOrdering regionOrdering) {
		this.environmentFactory = environmentFactory;
		this.qvtpTransformation = qvtpTransformation;
		this.regionOrdering = regionOrdering;
		String transformationName = qvtpTransformation.getName();
		assert transformationName != null;
		qvtiTransformation = QVTimperativeUtil.createTransformation(transformationName);
		createTypedModels();
//		analyzeConnections();
	}

	private void accumulateOperations(@NonNull Transformation transformation) {
		if (otherTransformations.add(transformation)) {
			for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Operation) {
					Operation operation = (Operation) eObject;
					String name = operation.toString();
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
			connections = new ArrayList<Connection>();
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

	public @Nullable Operation create(@Nullable Operation pOperation) {
		if (pOperation == null) {
			return null;
		}
		Operation iOperation = qvtpOperation2qvtiOperation.get(pOperation);
		if (iOperation == null) {
			Transformation containingTransformation = QVTbaseUtil.getContainingTransformation(pOperation);
			if (containingTransformation == qvtpTransformation) {
				iOperation = EcoreUtil.copy(pOperation);
				qvtpOperation2qvtiOperation.put(pOperation, iOperation);
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
					qvtpOperation2qvtiOperation.put(pOperation, iOperation);
					qvtiTransformation.getOwnedOperations().add(iOperation);
				}
				else {
					iOperation = pOperation;
					qvtpOperation2qvtiOperation.put(pOperation, iOperation);
				}
			}
		}
		return iOperation;
	}
	
	public void createRegion2Mapping(@NonNull Region region) {
		AbstractRegion2Mapping region2mapping = region2region2mapping.get(region);
		assert region2mapping == null : "Re-AbstractRegion2Mapping for " + region;
//		assert !region.isConnectionRegion();
		if (region.isCompositionRegion()) {
			region2mapping = new CompositionRegion2Mapping(this, region);
		}
		else if (region.isRootRegion()) {
			region2mapping = new RootRegion2Mapping(this, region);
		}
		else {
			region2mapping = new BasicRegion2Mapping(this, region);
		}
		region2region2mapping.put(region, region2mapping);
		qvtiTransformation.getRule().add(region2mapping.getMapping());
		region.accept(this);
//		for (@SuppressWarnings("null")@NonNull Region childRegion : region.getCalledRegions()) {
//			if (region2region2mapping.get(childRegion) == null) {
//				createRegion2Mapping(childRegion);
//			}
//		}
	}

	protected void createTypedModels() {
		for (TypedModel qvtpTypedModel : qvtpTransformation.getModelParameter()) {
			String typedModelName = qvtpTypedModel.getName();
			assert typedModelName != null;
			TypedModel qvtiTypedModel = QVTimperativeUtil.createTypedModel(typedModelName);
			qvtiTypedModel.getUsedPackage().addAll(qvtpTypedModel.getUsedPackage());
			qvtpTypedModel2qvtiTypedModel.put(qvtpTypedModel, qvtiTypedModel);
			qvtiTransformation.getModelParameter().add(qvtiTypedModel);
		}
		for (Rule rule : qvtpTransformation.getRule()) {
			for (Domain domain : rule.getDomain()) {
				if (domain.isIsCheckable()) {
					TypedModel checkableTypedModel = qvtpTypedModel2qvtiTypedModel.get(domain.getTypedModel());
					if ((checkableTypedModel != null) && !checkableAndEnforceableTypedModels.contains(checkableTypedModel)) {
						if (enforceableTypedModels.contains(checkableTypedModel)) {
							checkableAndEnforceableTypedModels.add(checkableTypedModel);
							enforceableTypedModels.remove(checkableTypedModel);
						}
						else if (!checkableTypedModels.contains(checkableTypedModel)) {
							checkableTypedModels.add(checkableTypedModel);
						}
					}
				}
				if (domain.isIsEnforceable()) {
					TypedModel enforceableTypedModel = qvtpTypedModel2qvtiTypedModel.get(domain.getTypedModel());
					if ((enforceableTypedModel != null) && !checkableAndEnforceableTypedModels.contains(enforceableTypedModel)) {
						if (checkableTypedModels.contains(enforceableTypedModel)) {
							checkableAndEnforceableTypedModels.add(enforceableTypedModel);
							checkableTypedModels.remove(enforceableTypedModel);
						}
						else if (!enforceableTypedModels.contains(enforceableTypedModel)) {
							enforceableTypedModels.add(enforceableTypedModel);
						}
					}
				}
			}
		}
	}
	
//	public @NonNull ChainNode getChain(@NonNull Region region) {
//		return chainGraph.getChain(region);
//	}

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

	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}
	
	public @Nullable TypedModel getQVTiTypedModel(@Nullable TypedModel qvtpTypedModel) {
		TypedModel qvtiTypedModel = qvtpTypedModel2qvtiTypedModel.get(qvtpTypedModel);
		return qvtiTypedModel != null ? qvtiTypedModel : qvtpTypedModel;
	}

	public @NonNull Region2Depth getRegion2Depth() {
		return region2depth;
	}
	
	public @NonNull AbstractRegion2Mapping getRegion2Mapping(@NonNull Region region) {
		AbstractRegion2Mapping region2mapping = region2region2mapping.get(region);
		assert region2mapping != null : "No AbstractRegion2Mapping for " + region;
		return region2mapping;
	}

	public @NonNull Set<String> getReservedNames() {
		Set<String> reservedNames2 = reservedNames;
		if (reservedNames2 == null) {
			reservedNames = reservedNames2 = new HashSet<String>();
			reservedNames2.add(qvtpTransformation.getName());
			for (TypedModel typedModel : qvtpTransformation.getModelParameter()) {
				reservedNames2.add(typedModel.getName());
			}
			for (Operation operation : qvtpTransformation.getOwnedOperations()) {
				reservedNames2.add(operation.getName());
			}
			for (Property property : qvtpTransformation.getOwnedProperties()) {
				reservedNames2.add(property.getName());
			}
		}
		return reservedNames2;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	public @NonNull Transformation getTransformation() {
		return qvtiTransformation;
	}

//	private @NonNull Node selectHeadNode(@NonNull List<Node> headNodes) {
//		return headNodes.get(0);			// FIXME best
//	}

	@Override
	public @Nullable Element visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Element visitCompositionRegion(@NonNull CompositionRegion containmentRegion) {
		AbstractRegion2Mapping region2mapping = getRegion2Mapping(containmentRegion);
		Mapping mapping = region2mapping.getMapping();
/*		MappingStatement mappingStatement = null;
		for (@SuppressWarnings("null")@NonNull List<Node> headNodes : containmentRegion.getHeadNodeGroups()) {
			Node headNode = selectHeadNode(headNodes);
			Variable headVariable = region2mapping.getGuardVariable(headNode);
			for (NavigationEdge edge : AbstractEdge.getSortedEdges(headNode.getNavigationEdges())) {
				if (edge.getProperty().isIsMany()) {
					Node targetNode = edge.getTarget();
					Variable loopVariable = PivotUtil.createVariable(targetNode.getName(), targetNode.getClassDatumAnalysis().getCompleteClass().getPrimaryClass(), true, null);
					mapping.getBottomPattern().getVariable().add(loopVariable);
					MappingStatement loopStatement = null;
					for (Node calledNode : AbstractNode.getSortedTargets(targetNode.getPassedBindingTargets())) {
						Region calledRegion = calledNode.getRegion();
						Region2Mapping calledRegion2Mapping = getRegion2Mapping(calledRegion);
						Mapping calledMapping = calledRegion2Mapping.getMapping();
						VariableExp variableExp = PivotUtil.createVariableExp(loopVariable);
						Variable calledGuardVariable = calledRegion2Mapping.getGuardVariable(calledNode);
						MappingCallBinding mappingCallBinding = QVTimperativeUtil.createMappingCallBinding(calledGuardVariable, variableExp);
						MappingCall mappingCall = QVTimperativeUtil.createMappingCall(calledMapping, Collections.singletonList(mappingCallBinding));
						loopStatement = QVTimperativeUtil.addMappingStatement(loopStatement, mappingCall);
					}
					assert loopStatement != null;
					VariableExp headExp = PivotUtil.createVariableExp(headVariable);
					PropertyCallExp propertyCallExp = PivotUtil.createPropertyCallExp(headExp, edge.getProperty());
					MappingLoop mappingLoop = QVTimperativeUtil.createMappingLoop(propertyCallExp, loopVariable, loopStatement);
					mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingLoop);
				}
			}
		}
		if (mappingStatement !=  null) {
			mapping.setMappingStatement(mappingStatement);
		} */
		return mapping;
	}
	
	@Override
	public @Nullable Element visitMappingRegion(@NonNull MappingRegion mappingRegion) {
		AbstractRegion2Mapping region2mapping = getRegion2Mapping(mappingRegion);
		return region2mapping.getMapping();
	}

	@Override
	public @Nullable Element visitMergedRegion(@NonNull MergedRegion mergedRegion) {
		AbstractRegion2Mapping region2mapping = getRegion2Mapping(mergedRegion);
		Mapping mapping = region2mapping.getMapping();
		return mapping;
	}
	
	@Override
	public @Nullable Element visitOperationRegion(@NonNull OperationRegion operationRegion) {
		return visiting(operationRegion);
	}
	
	@Override
	public @Nullable Element visitRootCompositionRegion(@NonNull RootRegion rootContainmentRegion) {
		AbstractRegion2Mapping region2mapping = getRegion2Mapping(rootContainmentRegion);
		Mapping mapping = region2mapping.getMapping();
//		for (@SuppressWarnings("null")@NonNull List<Node> headNodes : rootContainmentRegion.getHeadNodeGroups()) {
//			Node headNode = selectHeadNode(headNodes);
//			Variable headVariable = region2mapping.getGuardVariable(headNode);
//			getGuardPattern(mapping).getVariable().add(guardVariable);
//		}
		return mapping;
	}
	
	@Override
	public @Nullable Element visitRootRegion(@NonNull ScheduledRegion scheduledRegion) {
//		String name = rootRegion.getName();
		org.eclipse.ocl.pivot.Package rootPackage = PivotUtil.createPackage("", "yy", "zz", null);
		//
		List<Region> callableRegions = new ArrayList<Region>();
		for (@SuppressWarnings("null")@NonNull Region region : scheduledRegion.getRegions()) {
			if (region.isOperationRegion()) {}
//			else if (region.isConnectionRegion()) {
//				callableRegions.add(region);
//			}
			else {
				callableRegions.add(region);
			}
		}

		List<Region> sortedRegions = AbstractRegion.EarliestRegionComparator.sort(callableRegions);
		for (@SuppressWarnings("null")@NonNull Region region : sortedRegions) {
//			if (!region.isConnectionRegion()) {
				createRegion2Mapping(region);
//			}
		}
//		Region rootRegion = regionOrdering.getRootRegion();
//		chainGraph = new ChainGraph(region2depth, rootRegion, regionOrdering.getSchedulableOrdering());
//		@SuppressWarnings("null")@NonNull URI baseURI = qvtpTransformation.eResource().getURI();
//		chainGraph.writeChainDOTfile(baseURI, "c");
//		chainGraph.writeChainGraphMLfile(baseURI, "c");
		//

/*		Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges = new HashMap<TypedModel, Map<Property, List<NavigationEdge>>>();
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
		for (@SuppressWarnings("null")@NonNull Region region : sortedRegions) {
//			if (!region.isConnectionRegion()) {
				AbstractRegion2Mapping region2Mapping = getRegion2Mapping(region);
				region2Mapping.createStatements();
//			}
		}
		rootPackage.getOwnedClasses().add(qvtiTransformation);
		ECollections.sort(qvtiTransformation.getRule(), NameUtil.NameableComparator.INSTANCE);
		Model model = PivotUtil.createModel(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, null);
		model.getOwnedPackages().add(rootPackage);
		List<Namespace> importedNamespaces = new ArrayList<Namespace>();
		for (TypedModel typedModel : qvtpTypedModel2qvtiTypedModel.values()) {
			if (typedModel != null) {
				for (Namespace importedNamespace : typedModel.getUsedPackage()) {
					if (!importedNamespaces.contains(importedNamespace)) {
						importedNamespaces.add(importedNamespace);
					}
				}
			}
		}
		Collections.sort(importedNamespaces, NameUtil.NAMEABLE_COMPARATOR);
		List<Import> ownedImports = model.getOwnedImports();
		for (@SuppressWarnings("null")@NonNull Namespace importedNamespace : importedNamespaces) {
			ownedImports.add(createImport(null, importedNamespace));
		}
		return model;
	}

}
