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
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.ClassRelationships;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.QVTp2QVTg;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.utilities.DOTStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphMLStringBuilder;

public abstract class SchedulerConstants
{
	public static final @NonNull List<Connection> EMPTY_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<Edge> EMPTY_EDGE_LIST = Collections.emptyList();
	//public static final @NonNull List<ExpressionEdge> EMPTY_EXPRESSION_EDGE_LIST = Collections.emptyList();
	public static final @NonNull Set<MappingRegion> EMPTY_MAPPING_REGION_SET = Collections.emptySet();
	public static final @NonNull List<NavigationEdge> EMPTY_NAVIGATION_EDGE_LIST = Collections.emptyList();
	public static final @NonNull List<Node> EMPTY_NODE_LIST = Collections.emptyList();
	public static final @NonNull List<Region> EMPTY_REGION_LIST = Collections.emptyList();
	public static final @NonNull List<SimpleEdge> EMPTY_SIMPLE_EDGE_LIST = Collections.emptyList();
	public static final @NonNull List<SimpleNode> EMPTY_SIMPLE_NODE_LIST = Collections.emptyList();
	public static final @NonNull List<TypedElement> EMPTY_TYPED_ELEMENT_LIST = Collections.emptyList();

	public static @NonNull String getMultiplicity(@NonNull TypedElement typedElement) {
		StringBuilder s = new StringBuilder();
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Number lower = collectionType.getLower();
			Number upper = collectionType.getUpper();
			StringUtil.appendMultiplicity(s, lower.intValue(), upper instanceof Unlimited ? -1 : upper.intValue(), collectionType.isIsNullFree());
		}
		else {
			s.append(typedElement.isIsRequired() ? "[1]" : "[?]");
		}
		return s.toString();
	}
	
	/**
	 * The DependencyGraph to be analyzed
	 */
	private final @NonNull Schedule dependencyGraph;
	private final @NonNull RootDomainUsageAnalysis domainAnalysis;
	private final @NonNull QVTp2QVTg qvtp2qvtg;
	@SuppressWarnings("unused")
	private final @NonNull DomainUsage inputUsage;
	private final @NonNull EnvironmentFactory environmentFactory;
	private final @NonNull Transformation transformation;

	private final @NonNull OperationId oclAnyEqualsId;
	private final @NonNull OperationId oclAnyOclAsSetId;
	private final @NonNull OperationId oclAnyOclAsTypeId;
	private final @NonNull OperationId oclAnyOclIsKindOfId;
	private final @NonNull OperationId oclElementOclContainerId;
	private final @NonNull ClassDatumAnalysis oclVoidClassDatumAnalysis;

	private final @NonNull Property oclContainerProperty;

	/**
	 * The extended analysis of each ClassDatum.
	 */
	private final @NonNull Map<ClassDatum, ClassDatumAnalysis> classDatum2classDatumAnalysis = new HashMap<ClassDatum, ClassDatumAnalysis>();

	/**
	 * The analysis of each class.	// FIXME domains
	 */
//	private final @NonNull Map<org.eclipse.ocl.pivot.Class, ClassDatum> class2classDatum = new HashMap<org.eclipse.ocl.pivot.Class, ClassDatum>();

	/**
	 * The PropertyDatum for each property.	// FIXME domains
	 */
	private final @NonNull Map<Property, PropertyDatum> property2propertyDatum = new HashMap<Property, PropertyDatum>();

	/**
	 * Property used as a navigation to cast to a specific type.
	 */
	private final @NonNull Map<Type, Property> type2castProperty = new HashMap<Type, Property>();

	/**
	 * Property used as a navigation to iterate collection elementse.
	 */
	private final @NonNull Map<Type, Property> type2iterateProperty = new HashMap<Type, Property>();
	
	/**
	 * Property used as an argument role identification.
	 */
	private final @NonNull Map<String, Property> name2argumentProperty = new HashMap<String, Property>();
	
	/**
	 * OPeration depency analyzer and analyses.
	 */
	private @Nullable DependencyAnalyzer dependencyAnalyzer = null;

	public SchedulerConstants(@NonNull EnvironmentFactory environmentFactory, @NonNull Schedule dependencyGraph, @NonNull RootDomainUsageAnalysis domainAnalysis, @NonNull QVTp2QVTg qvtp2qvtg) {
		this.environmentFactory = environmentFactory;
		this.dependencyGraph = dependencyGraph;
		this.domainAnalysis = domainAnalysis;
		this.qvtp2qvtg = qvtp2qvtg;
		this.transformation = ClassUtil.nonNullState(QVTbaseUtil.getContainingTransformation(((MappingAction)dependencyGraph.getActions().get(0)).getMapping()));
		//
		int checkableMask = ((DomainUsage.Internal)domainAnalysis.getCheckableUsage()).getMask();
		int enforceableMask = ((DomainUsage.Internal)domainAnalysis.getEnforceableUsage()).getMask();
		int inputMask = checkableMask & ~enforceableMask;
		this.inputUsage = domainAnalysis.getConstantUsage(inputMask);
		//
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
		org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
		Operation operation1 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
		assert operation1 != null;
		oclAnyEqualsId = operation1.getOperationId();
		Operation operation2 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclAsType");
		assert operation2 != null;
		oclAnyOclAsTypeId = operation2.getOperationId();
		Operation operation3 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclIsKindOf");
		assert operation3 != null;
		oclAnyOclIsKindOfId = operation3.getOperationId();
		Operation operation4 = NameUtil.getNameable(oclElementType.getOwnedOperations(), "oclContainer");
		assert operation4 != null;
		oclElementOclContainerId = operation4.getOperationId();
		Operation operation5 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclAsSet");
		assert operation5 != null;
		oclAnyOclAsSetId = operation5.getOperationId();
		oclVoidClassDatumAnalysis = getClassDatumAnalysis(standardLibrary.getOclVoidType(), domainAnalysis.getPrimitiveTypeModel());
		//
		Property candidateOclContainerProperty = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContainer");
		assert candidateOclContainerProperty != null : "OCL Standard Librarty has no OclElement::oclContainer property";
		oclContainerProperty = candidateOclContainerProperty;
		//
		//	Extract salient characteristics from the DependencyGraph.
		//
		analyzeDatums(dependencyGraph.getDatums());
	}

	private void analyzeDatums(/*@NonNull*/ List<? extends AbstractDatum> datums) {
		for (AbstractDatum abstractDatum : datums) {
			if (abstractDatum instanceof ClassDatum) {
				ClassDatum classDatum = (ClassDatum)abstractDatum;
//				class2classDatum.put(classDatum.getType(), classDatum);
				analyzeDatums(classDatum.getPropertyDatums());
			}
			else if (abstractDatum instanceof PropertyDatum) {
				PropertyDatum propertyDatum = (PropertyDatum)abstractDatum;
				property2propertyDatum.put(propertyDatum.getProperty(), propertyDatum);
			}
			analyzeDatums(abstractDatum.getSub());
		}
	}

	protected abstract @NonNull ClassDatumAnalysis createClassDatumAnalysis(@NonNull ClassDatum classDatum);

	public @NonNull Property getArgumentProperty(@NonNull String argumentName) {
		Property argumentProperty = name2argumentProperty.get(argumentName);
		if (argumentProperty == null) {
			argumentProperty = QVTimperativeUtil.createProperty(argumentName, getStandardLibrary().getOclAnyType(), true);
			name2argumentProperty.put(argumentName, argumentProperty);
		}
		return argumentProperty;
	}

	public @NonNull Property getCastProperty(@NonNull Type type) {
		Property castProperty = type2castProperty.get(type);
		if (castProperty == null) {
			castProperty = QVTimperativeUtil.createProperty("«cast»\\n" + type.toString(), type, true);
			type2castProperty.put(type, castProperty);
		}
		return castProperty;
	}

	public @NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)asTypedElement.getType();
		assert asType != null;
		Type elementType = QVTbaseUtil.getElementalType(asType);
		TypedModel typedModel;
		if (elementType instanceof DataType) {
			typedModel = getDomainAnalysis().getPrimitiveTypeModel();
		}
		else {
			DomainUsage domainUsage = getDomainUsage(asTypedElement);
			assert domainUsage != null;
			typedModel = domainUsage.getTypedModel();
			assert typedModel != null;
		}
		return qvtp2qvtg.getClassDatum(typedModel, asType);
	}

	public @NonNull ClassDatum getClassDatum(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull TypedModel typedModel) {
		return qvtp2qvtg.getClassDatum(typedModel, asType);
	}

	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull ClassDatum classDatum) {
		ClassDatumAnalysis classDatumAnalysis = classDatum2classDatumAnalysis.get(classDatum);
		if (classDatumAnalysis == null) {
			classDatumAnalysis = createClassDatumAnalysis(classDatum);
			classDatum2classDatumAnalysis.put(classDatum, classDatumAnalysis);
		}
		return classDatumAnalysis;
	}

//	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Element contextElement, @NonNull Type type) {
//		ClassDatum classDatum = getClassDatum(type);
//		DomainUsage usage = getDomainUsage(contextElement);
//		return getClassDatumAnalysis(classDatum, ClassUtil.nonNullState(usage));
//	}

/*	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Type type, @NonNull DomainUsage usage) {
		ClassDatum classDatum = getClassDatum(type);
//		DomainUsage usage = getDomainUsage(contextElement);
		return getClassDatumAnalysis(classDatum);
	} */

	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement) {
		ClassDatum classDatum = getClassDatum(typedElement);
//		DomainUsage usage = getDomainUsage(typedElement);
		return getClassDatumAnalysis(classDatum);
	}

	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull TypedModel typedModel) {
		ClassDatum classDatum = qvtp2qvtg.getClassDatum(typedModel, type);
		return getClassDatumAnalysis(classDatum);
	}

	public @NonNull Iterable<ClassDatumAnalysis> getClassDatumAnalyses() {
		return classDatum2classDatumAnalysis.values();
	}

	public @NonNull ClassRelationships getClassRelationships() {
		return qvtp2qvtg.getClassRelationships();
	}

//	@SuppressWarnings("null")
//	public @NonNull Set<ClassDatum> getClassDatums() {
//		return classDatum2classDatumAnalysis.keySet();
//	}

	public @NonNull DependencyAnalyzer getDependencyAnalyzer() {
		@Nullable
		DependencyAnalyzer dependencyAnalyzer2 = dependencyAnalyzer;
		if (dependencyAnalyzer2 == null) {
			dependencyAnalyzer = dependencyAnalyzer2 = new DependencyAnalyzer(this);
		}
		return dependencyAnalyzer2;
	}

	public @NonNull Schedule getDependencyGraph() {
		return dependencyGraph;
	}

	public @NonNull RootDomainUsageAnalysis getDomainAnalysis() {
		return domainAnalysis;
	}

	public @NonNull DomainUsage getDomainUsage(@NonNull Element element) {
		DomainUsageAnalysis analysis = domainAnalysis;
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation != null) {
			analysis = domainAnalysis.getAnalysis(operation);
		}
		return ClassUtil.nonNullState(analysis.getUsage(element));
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull Property getIterateProperty(@NonNull Type type) {
		Property iterateProperty = type2iterateProperty.get(type);
		if (iterateProperty == null) {
			iterateProperty = QVTimperativeUtil.createProperty("«iterate»", type, true);
			type2iterateProperty.put(type, iterateProperty);
		}
		return iterateProperty;
	}

	public @NonNull OperationId getOclAnyEqualsId() {
		return oclAnyEqualsId;
	}

	public @NonNull OperationId getOclAnyOclAsSetId() {
		return oclAnyOclAsSetId;
	}

	public @NonNull OperationId getOclAnyOclAsTypeId() {
		return oclAnyOclAsTypeId;
	}

	public @NonNull OperationId getOclAnyOclIsKindOfId() {
		return oclAnyOclIsKindOfId;
	}

	public @NonNull Property getOclContainerProperty() {
		return oclContainerProperty;
	}

	public @NonNull OperationId getOclElementOclContainerId() {
		return oclElementOclContainerId;
	}

	public @NonNull ClassDatumAnalysis getOclVoidClassDatumAnalysis() {
		return oclVoidClassDatumAnalysis;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull Property property) {
		return domainAnalysis.isDirty(property);
	}

	public boolean isKnown(@NonNull VariableDeclaration sourceVariable) {
		if (sourceVariable.eContainer() == null) {		// Synthetic variable
			return false;
		}
		DomainUsage usage = getDomainUsage(sourceVariable);
		assert usage != null;
		return !usage.isEnforceable();
	}

	public void writeCallDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		@SuppressWarnings("null")@NonNull URI baseURI = dependencyGraph.eResource().getURI();
		URI dotURI = URI.createURI(region.getName().replace("\n",  "_").replace("\\n",  "_c") + suffix + ".dot").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			DOTStringBuilder s = new DOTStringBuilder();
			region.toCallGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeCallGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		@SuppressWarnings("null")@NonNull URI baseURI = dependencyGraph.eResource().getURI();
		URI dotURI = URI.createURI(region.getName().replace("\n",  "_").replace("\\n",  "_c") + suffix + ".graphml").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			region.toCallGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeDOTfile(@NonNull Region region, @NonNull String suffix) {
		@SuppressWarnings("null")@NonNull URI baseURI = dependencyGraph.eResource().getURI();
		URI dotURI = URI.createURI(region.getName().replace("\n",  "_").replace("\\n",  "_").replace("::",  "_") + suffix + ".dot").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			DOTStringBuilder s = new DOTStringBuilder();
			region.toGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeGraphMLfile(@NonNull Region region, @NonNull String suffix) {
		@SuppressWarnings("null")@NonNull URI baseURI = dependencyGraph.eResource().getURI();
		URI dotURI = URI.createURI(region.getName().replace("\n",  "_").replace("\\n",  "_").replace("::",  "_") + suffix + ".graphml").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			region.toGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		@SuppressWarnings("null")@NonNull URI baseURI = dependencyGraph.eResource().getURI();
		URI dotURI = URI.createURI(region.getName().replace("\n",  "_").replace("\\n",  "_") + suffix + ".dot").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			DOTStringBuilder s = new DOTStringBuilder();
			region.toRegionGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeRegionGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		@SuppressWarnings("null")@NonNull URI baseURI = dependencyGraph.eResource().getURI();
		URI dotURI = URI.createURI(region.getName().replace("\n",  "_").replace("\\n",  "_") + suffix + ".graphml").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			region.toRegionGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}