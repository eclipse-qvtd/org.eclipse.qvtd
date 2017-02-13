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

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootCompositionRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameReservation;

public class QVTs2QVTiVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable Element, @Nullable Object>
{
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull Transformation qvtpTransformation;
	protected final @NonNull SymbolNameReservation symbolNameReservation;

	protected final @NonNull Transformation qvtiTransformation;
	protected final @NonNull Map<@NonNull TypedModel, @NonNull ImperativeTypedModel> qvtpTypedModel2qvtiTypedModel = new HashMap<>();
	protected final @NonNull List<@NonNull ImperativeTypedModel> checkableTypedModels = new ArrayList<>();
	protected final @NonNull List<@NonNull ImperativeTypedModel> checkableAndEnforceableTypedModels = new ArrayList<>();
	protected final @NonNull List<@NonNull ImperativeTypedModel> enforceableTypedModels = new ArrayList<>();
	protected final @NonNull Map<@NonNull Region, @NonNull AbstractRegion2Mapping> region2region2mapping = new HashMap<>();
	private @Nullable Set<@NonNull String> reservedNames = null;
	private @NonNull Map<@NonNull Operation, @NonNull Operation> qvtpOperation2qvtiOperation = new HashMap<>();
	private final @NonNull Region2Depth region2depth = new Region2Depth();

	private final @NonNull Set<@NonNull Transformation> otherTransformations = new HashSet<>();	// Workaround Bug 481658
	private final @NonNull Map<@NonNull String, @NonNull Operation> name2operation = new HashMap<>();	// Workaround Bug 481658

	private /*@LazyNonNull*/ ImperativeTypedModel qvtiMiddleTypedModel = null;

	public QVTs2QVTiVisitor(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory, @NonNull Transformation qvtpTransformation, @NonNull SymbolNameReservation symbolNameReservation) {
		super(null);
		this.environmentFactory = environmentFactory;
		this.problemHandler = problemHandler;
		this.qvtpTransformation = qvtpTransformation;
		this.symbolNameReservation = symbolNameReservation;
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
		Operation iOperation = qvtpOperation2qvtiOperation.get(pOperation);
		if (iOperation == null) {
			Transformation containingTransformation = QVTbaseUtil.basicGetContainingTransformation(pOperation);
			if (containingTransformation == qvtpTransformation) {
				iOperation = EcoreUtil.copy(pOperation);
				assert iOperation != null;
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
					assert iOperation != null;
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
		if (region.isRootCompositionRegion()) {
			region2mapping = new RootRegion2Mapping(this, (RootCompositionRegion)region);
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
			ImperativeTypedModel qvtiTypedModel = QVTimperativeUtil.createTypedModel(typedModelName);
			qvtiTypedModel.getUsedPackage().addAll(qvtpTypedModel.getUsedPackage());
			if (QVTscheduleConstants.MIDDLE_DOMAIN_NAME.equals(typedModelName)) {
				assert qvtiMiddleTypedModel  == null;
				qvtiMiddleTypedModel = qvtiTypedModel;
			}
			qvtpTypedModel2qvtiTypedModel.put(qvtpTypedModel, qvtiTypedModel);
			qvtiTransformation.getModelParameter().add(qvtiTypedModel);
		}
		for (Rule rule : qvtpTransformation.getRule()) {
			for (Domain domain : rule.getDomain()) {
				if (domain.isIsCheckable()) {
					ImperativeTypedModel checkableTypedModel = qvtpTypedModel2qvtiTypedModel.get(QVTcoreUtil.getTypedModel(domain));
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
				if (domain.isIsEnforceable()) {
					ImperativeTypedModel enforceableTypedModel = qvtpTypedModel2qvtiTypedModel.get(QVTcoreUtil.getTypedModel(domain));
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
				}
			}
		}
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

	public @NonNull Operation getNotEqualsOperation() {
		StandardLibrary standardLibrary = getStandardLibrary();
		org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
		Operation operation1 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "<>");
		assert operation1 != null;
		OperationId oclAnyEqualsId = operation1.getOperationId();
		return environmentFactory.getIdResolver().getOperation(oclAnyEqualsId);
	}

	public @Nullable ImperativeTypedModel getQVTiTypedModel(@Nullable TypedModel qvtpTypedModel) {
		if (qvtpTypedModel == null) {
			assert qvtiMiddleTypedModel != null;
			return qvtiMiddleTypedModel;
		}
		return qvtpTypedModel2qvtiTypedModel.get(qvtpTypedModel);
	}

	public @NonNull Region2Depth getRegion2Depth() {
		return region2depth;
	}

	public @NonNull AbstractRegion2Mapping getRegion2Mapping(@NonNull Region region) {
		AbstractRegion2Mapping region2mapping = region2region2mapping.get(region);
		assert region2mapping != null : "No AbstractRegion2Mapping for " + region;
		return region2mapping;
	}

	public @NonNull Set<@NonNull String> getReservedNames() {
		Set<@NonNull String> reservedNames2 = reservedNames;
		if (reservedNames2 == null) {
			reservedNames = reservedNames2 = new HashSet<>();
			org.eclipse.ocl.pivot.Package standardLibraryPackage = getStandardLibrary().getPackage();
			gatherReservedPackageNames(reservedNames2, Collections.singletonList(standardLibraryPackage));
			reservedNames2.add(ClassUtil.nonNull(qvtpTransformation.getName()));
			for (TypedModel typedModel : qvtpTransformation.getModelParameter()) {
				reservedNames2.add(ClassUtil.nonNullState(typedModel.getName()));
				gatherReservedPackageNames(reservedNames2, typedModel.getUsedPackage());
			}
			for (Operation operation : qvtpTransformation.getOwnedOperations()) {
				reservedNames2.add(ClassUtil.nonNull(operation.getName()));
			}
			for (Property property : qvtpTransformation.getOwnedProperties()) {
				reservedNames2.add(ClassUtil.nonNull(property.getName()));
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

	@Override
	public @Nullable Element visitMappingRegion(@NonNull MappingRegion mappingRegion) {
		AbstractRegion2Mapping region2mapping = getRegion2Mapping(mappingRegion);
		return region2mapping.getMapping();
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
	public Element visitRegion(@NonNull Region region) {
		return visiting(region);
	}

	@Override
	public @Nullable Element visitRootCompositionRegion(@NonNull RootCompositionRegion rootCompositionRegion) {
		AbstractRegion2Mapping region2mapping = getRegion2Mapping(rootCompositionRegion);
		Mapping mapping = region2mapping.getMapping();
		//		for (@SuppressWarnings("null")@NonNull List<Node> headNodes : rootContainmentRegion.getHeadNodeGroups()) {
		//			Node headNode = selectHeadNode(headNodes);
		//			Variable headVariable = region2mapping.getGuardVariable(headNode);
		//			getGuardPattern(mapping).getVariable().add(guardVariable);
		//		}
		return mapping;
	}

	@Override
	public @Nullable Element visitScheduledRegion(@NonNull ScheduledRegion rootScheduledRegion) {
		//		String name = rootRegion.getName();
		//
		List<@NonNull Region> callableRegions = new ArrayList<>();
		for (@NonNull Region region : rootScheduledRegion.getRegions()) {
			if (region.isOperationRegion()) {}
			//			else if (region.isConnectionRegion()) {
			//				callableRegions.add(region);
			//			}
			else {
				callableRegions.add(region);
			}
		}

		List<@NonNull Region> sortedRegions = QVTscheduleUtil.EarliestRegionComparator.sort(callableRegions);
		for (@NonNull Region region : sortedRegions) {
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
		for (@NonNull Region region : sortedRegions) {
			//			if (!region.isConnectionRegion()) {
			AbstractRegion2Mapping region2Mapping = getRegion2Mapping(region);
			region2Mapping.createStatements();
			//			}
		}
		// Mappings are in schedule index order.
		//		ECollections.sort(qvtiTransformation.getRule(), NameUtil.NameableComparator.INSTANCE);
		/*		org.eclipse.ocl.pivot.Package rootPackage = PivotUtil.createPackage("", "yy", "zz", null);
		rootPackage.getOwnedClasses().add(qvtiTransformation);
		Model model = PivotUtil.createModel(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, null);
		model.getOwnedPackages().add(rootPackage);
		List<@NonNull Namespace> importedNamespaces = new ArrayList<>();
		for (@NonNull TypedModel typedModel : qvtpTypedModel2qvtiTypedModel.values()) {
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
