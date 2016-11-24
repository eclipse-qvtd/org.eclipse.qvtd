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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ContainmentAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameReservation;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;

public abstract class SchedulerConstants
{
	public static final @NonNull List<@NonNull Connection> EMPTY_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull EdgeConnection> EMPTY_EDGE_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull Edge> EMPTY_EDGE_LIST = Collections.emptyList();
	//public static final @NonNull List<ExpressionEdge> EMPTY_EXPRESSION_EDGE_LIST = Collections.emptyList();
	public static final @NonNull Set<@NonNull MappingRegion> EMPTY_MAPPING_REGION_SET = Collections.emptySet();
	public static final @NonNull List<@NonNull NavigableEdge> EMPTY_NAVIGATION_EDGE_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull Node> EMPTY_NODE_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull NodeConnection> EMPTY_NODE_CONNECTION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull Region> EMPTY_REGION_LIST = Collections.emptyList();
	public static final @NonNull List<@NonNull TypedElement> EMPTY_TYPED_ELEMENT_LIST = Collections.emptyList();

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

	private final @NonNull EnvironmentFactory environmentFactory;
	private final @NonNull Transformation transformation;
	private final @NonNull RootDomainUsageAnalysis domainAnalysis;
	private final @NonNull DatumCaches datumCaches;

	@SuppressWarnings("unused")
	private final @NonNull DomainUsage inputUsage;

	protected final @NonNull StandardLibraryHelper standardLibraryHelper;
	private final @NonNull ClassDatumAnalysis oclVoidClassDatumAnalysis;

	/**
	 * The extended analysis of each ClassDatum.
	 */
	private final @NonNull Map<ClassDatum, ClassDatumAnalysis> classDatum2classDatumAnalysis = new HashMap<ClassDatum, ClassDatumAnalysis>();

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
	 * Map reserving a unique symbol name per region or connection.
	 */
	private @NonNull SymbolNameReservation symbolNameReservation = new SymbolNameReservation();

	private /*@LazyNonNull */ DependencyAnalyzer dependencyAnalyzer = null;

	private /*@LazyNonNull*/ List<@NonNull Mapping> orderedMappings;	// Only ordered to improve determinacy

	protected SchedulerConstants(@NonNull EnvironmentFactory environmentFactory, @NonNull Transformation asTransformation) {
		this.environmentFactory = environmentFactory;
		this.transformation = asTransformation;
		this.domainAnalysis = new QVTcoreDomainUsageAnalysis(environmentFactory);
		domainAnalysis.analyzeTransformation(asTransformation);
		this.datumCaches = new DatumCaches(domainAnalysis);
		datumCaches.analyzeTransformation(asTransformation);
		//
		this.inputUsage = domainAnalysis.getInputUsage();
		//		int outputMask = ((DomainUsage.Internal)domainAnalysis.getOutputUsage()).getMask();
		//		int inputMask = checkableMask & ~enforceableMask;
		//		this.inputUsage = domainAnalysis.getConstantUsage(inputMask);
		//
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		this.standardLibraryHelper = new StandardLibraryHelper(standardLibrary);
		oclVoidClassDatumAnalysis = getClassDatumAnalysis(standardLibrary.getOclVoidType(), domainAnalysis.getPrimitiveTypeModel());
		//
	}

	protected abstract @NonNull ClassDatumAnalysis createClassDatumAnalysis(@NonNull ClassDatum classDatum);

	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum) {
		return datumCaches.getAllPropertyDatums(classDatum);
	}

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
		Type elementType = PivotUtil.getElementalType(asType);
		TypedModel typedModel;
		if (elementType instanceof DataType) {
			typedModel = getDomainAnalysis().getPrimitiveTypeModel();
		}
		else {
			DomainUsage domainUsage = getDomainUsage(asTypedElement);
			assert domainUsage != null;
			typedModel = domainUsage.getTypedModel(asTypedElement);
			assert typedModel != null;
		}
		return datumCaches.getClassDatum(typedModel, asType);
	}

	public @NonNull ClassDatum getClassDatum(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull TypedModel typedModel) {
		return datumCaches.getClassDatum(typedModel, asType);
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
		ClassDatum classDatum = datumCaches.getClassDatum(typedModel, type);
		return getClassDatumAnalysis(classDatum);
	}

	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull CompleteClass completeClass, @NonNull TypedModel typedModel) {
		ClassDatum classDatum = datumCaches.getClassDatum(typedModel, completeClass);
		return getClassDatumAnalysis(classDatum);
	}

	public @NonNull Iterable<ClassDatumAnalysis> getClassDatumAnalyses() {
		return classDatum2classDatumAnalysis.values();
	}

	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return datumCaches.getContainmentAnalysis();
	}

	public @NonNull DependencyAnalyzer getDependencyAnalyzer() {
		DependencyAnalyzer dependencyAnalyzer2 = dependencyAnalyzer;
		if (dependencyAnalyzer2 == null) {
			dependencyAnalyzer = dependencyAnalyzer2 = new DependencyAnalyzer(getContainmentAnalysis(), getDomainAnalysis());
		}
		return dependencyAnalyzer2;
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

	protected @NonNull URI getGraphsBaseURI() {
		return transformation.eResource().getURI().trimSegments(1).appendSegment("graphs").appendSegment("");
	}

	public @NonNull Property getIterateProperty(@NonNull Type type) {
		Property iterateProperty = type2iterateProperty.get(type);
		if (iterateProperty == null) {
			iterateProperty = QVTimperativeUtil.createProperty("«iterate»", type, true);
			type2iterateProperty.put(type, iterateProperty);
		}
		return iterateProperty;
	}

	public @NonNull ClassDatumAnalysis getOclVoidClassDatumAnalysis() {
		return oclVoidClassDatumAnalysis;
	}

	protected @NonNull Iterable<@NonNull Mapping> getOrderedMappings() {
		List<@NonNull Mapping> orderedMappings2 = orderedMappings;
		if (orderedMappings2 == null) {
			orderedMappings2 = orderedMappings = new ArrayList<>();
			for (@NonNull Rule rule : ClassUtil.nullFree(transformation.getRule())) {
				orderedMappings.add((Mapping)rule);
			}
			Collections.sort(orderedMappings2, NameUtil.NAMEABLE_COMPARATOR);
		}
		return orderedMappings2;
	}

	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		return datumCaches.getPropertyDatum(classDatum, property);
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return standardLibraryHelper;
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	public @NonNull SymbolNameReservation getSymbolNameReservation() {
		return symbolNameReservation;
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
		return !usage.isOutput();
	}

	public @NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Symbolable symbolable) {
		return symbolNameReservation.reserveSymbolName(symbolNameBuilder, symbolable);
	}

	public void writeCallDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		URI baseURI = getGraphsBaseURI();
		URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_c")*/ + suffix + ".dot").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			DOTStringBuilder s = new DOTStringBuilder();
			region.toCallGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
		}
	}

	public void writeCallGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		URI baseURI = getGraphsBaseURI();
		URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_c")*/ + suffix + ".graphml").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			region.toCallGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
		}
	}

	public void writeDOTfile(@NonNull Region region, @Nullable String suffix) {
		URI baseURI = getGraphsBaseURI();
		String symbolName = region.getSymbolName();
		if (suffix != null) {
			symbolName = symbolName + suffix;
		}
		URI dotURI = URI.createURI(symbolName + ".dot").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			DOTStringBuilder s = new DOTStringBuilder();
			region.toGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
		}
	}

	public void writeGraphMLfile(@NonNull Region region, @Nullable String suffix) {
		URI baseURI = getGraphsBaseURI();
		String symbolName = region.getSymbolName();
		if (suffix != null) {
			symbolName = symbolName + suffix;
		}
		URI dotURI = URI.createURI(symbolName + ".graphml").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			region.toGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
		}
	}

	public void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		URI baseURI = getGraphsBaseURI();
		URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_")*/ + suffix + ".dot").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			DOTStringBuilder s = new DOTStringBuilder();
			region.toRegionGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
		}
		for (@NonNull Region nestedRegion : region.getRegions()) {
			if (nestedRegion instanceof ScheduledRegion) {
				writeRegionDOTfile((@NonNull ScheduledRegion)nestedRegion, suffix);
			}
		}
	}

	public void writeRegionGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		URI baseURI = getGraphsBaseURI();
		URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_")*/ + suffix + ".graphml").resolve(baseURI);
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(dotURI);
			GraphMLStringBuilder s = new GraphMLStringBuilder();
			region.toRegionGraph(s);
			outputStream.write(s.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
		}
		for (@NonNull Region nestedRegion : region.getRegions()) {
			if (nestedRegion instanceof ScheduledRegion) {
				writeRegionGraphMLfile((@NonNull ScheduledRegion)nestedRegion, suffix);
			}
		}
	}
}