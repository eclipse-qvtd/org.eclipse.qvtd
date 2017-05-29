/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc.RelationComparator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

import com.google.common.collect.Lists;

public class RelationalTransformation2CoreTransformation extends QVTcoreHelper
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;
	private @Nullable Transformation coreTransformation = null;

	/**
	 * The per-relation conversions.
	 */
	private @NonNull Map<@NonNull RelationAnalysis, @NonNull Relation2Mappings> relationAnalysis2relation2mapping = new HashMap<>();

	public RelationalTransformation2CoreTransformation(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull TransformationAnalysis transformationAnalysis) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.transformationAnalysis = transformationAnalysis;
		this.relationalTransformation2tracePackage = qvtr2qvtc.getRelationalTransformation2TracePackage(transformationAnalysis);
	}

	public void addRelation2Mappings(@NonNull Relation2Mappings relation2mappings) {
		RelationAnalysis relationAnalysis = relation2mappings.getRelationAnalysis();
		relationAnalysis2relation2mapping.put(relationAnalysis, relation2mappings);
	}

	private @NonNull TypedModel createTypedModel(@NonNull Transformation coreTransformation, @Nullable String name, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> usedPackages) {
		TypedModel coreTypedModel =  QVTbaseFactory.eINSTANCE.createTypedModel();
		coreTypedModel.setName(name);
		coreTypedModel.getUsedPackage().addAll(usedPackages);
		coreTransformation.getModelParameter().add(coreTypedModel);
		return coreTypedModel;
	}

	public @NonNull Transformation getCoreTransformation() {
		return ClassUtil.nonNullState(coreTransformation);
	}

	public @NonNull Relation2Mappings getRelation2Mappings(@NonNull RelationAnalysis relationAnalysis) {
		return ClassUtil.nonNullState(relationAnalysis2relation2mapping.get(relationAnalysis));
	}

	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return relationalTransformation2tracePackage;
	}

	public @NonNull Transformation transform() {
		Transformation coreTransformation2 = this.coreTransformation;
		assert coreTransformation2 == null;
		RelationalTransformation relationalTransformation = transformationAnalysis.getTransformation();
		QVTr2QVTc qvtr2qvtc = transformationAnalysis.getQVTr2QVTc();
		//
		//	Create the core Transformation
		//
		this.coreTransformation = coreTransformation2 = createTransformation(QVTrelationUtil.getName(relationalTransformation));
		qvtr2qvtc.putGlobalTrace(coreTransformation2, relationalTransformation);
		//
		//	Create the null-named middle TypedModel
		//
		org.eclipse.ocl.pivot.@NonNull Package corePackage = relationalTransformation2tracePackage.getTracePackage();
		createTypedModel(coreTransformation2, null, Collections.singletonList(corePackage));
		//
		//	Create a non-middle TypedModel per model parameter
		//
		for (@NonNull TypedModel relationTypedModel : ClassUtil.nullFree(relationalTransformation.getModelParameter())) {
			TypedModel coreTypedModel = createTypedModel(coreTransformation2, relationTypedModel.getName(), ClassUtil.nullFree(relationTypedModel.getUsedPackage()));
			qvtr2qvtc.putTypedModel(relationTypedModel, coreTypedModel);
		}
		for (@NonNull TypedModel relationTypedModel : ClassUtil.nullFree(relationalTransformation.getModelParameter())) {
			if (relationTypedModel.getDependsOn().size() > 0) {
				TypedModel coreTypedModel = qvtr2qvtc.getCoreTypedModel(relationTypedModel);
				for (@NonNull TypedModel relationDependsOn : QVTrelationUtil.getDependsOns(relationTypedModel)) {
					coreTypedModel.getDependsOn().add(qvtr2qvtc.getCoreTypedModel(relationDependsOn));
				}
			}
		}
		return coreTransformation2;
	}

	/**
	 * Transform the contents of a single rTransformation to populate the already created cTransformation.
	 */
	public void transformContents() throws CompilerChainException {
		RelationalTransformation rTransformation = transformationAnalysis.getTransformation();
		Transformation cTransformation = getCoreTransformation();
		List<@NonNull Relation> rRelations = Lists.newArrayList(QVTrelationUtil.getOwnedRelations(rTransformation));
		Collections.sort(rRelations, new RelationComparator());
		Variable cThis = QVTbaseUtil.getContextVariable(standardLibrary, cTransformation);
		Variable rThis = QVTbaseUtil.getContextVariable(standardLibrary, rTransformation);
		//			putGlobalTrace(cThis, rThis);
		qvtr2qvtc.addTrace(rThis, cThis);
		//		UniqueArrayList<@NonNull TypedModel> rEnforceableTypedModels = new UniqueArrayList<>();		// FIXME not used
		//		for (@NonNull Relation rRelation : rRelations) {
		//			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
		//				if (rDomain.isIsEnforceable()) {
		//					rEnforceableTypedModels.add(QVTrelationUtil.getTypedModel(rDomain));
		//				}
		//			}
		//		}
		transformQueries();
		TransformationAnalysis rTransformationAnalysis = qvtr2qvtc.getTransformationAnalysis(rTransformation);
		for (@NonNull Relation rRelation : rRelations) {
			RelationAnalysis relationAnalysis = rTransformationAnalysis.getRelationAnalysis(rRelation);
			Relation2Mappings relation2mappings;
			if (rRelation.isIsAbstract()) {
				QVTr2QVTc.SYNTHESIS.println("abstract " + rRelation);
				relation2mappings = new Relation2AbstractMappings(this, relationAnalysis);
			}
			else if (rRelation.isIsTopLevel()) {
				QVTr2QVTc.SYNTHESIS.println("topLevel " + rRelation);
				relation2mappings = new TopRelation2Mappings(this, relationAnalysis);
			}
			else {
				relation2mappings = new NonTopRelation2Mappings(this, relationAnalysis);
			}
			relation2mappings.analyze();
			relationAnalysis2relation2mapping.put(relationAnalysis, relation2mappings);
		}
		for (@NonNull Relation2Mappings relation2mapping : relationAnalysis2relation2mapping.values()) {
			relation2mapping.synthesize();
		}
		CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedOperationsList(cTransformation));
		CompilerUtil.normalizeNameables(QVTbaseUtil.getRule(cTransformation));
	}

	protected void transformQueries() {
		RelationalTransformation rTransformation = transformationAnalysis.getTransformation();
		List<@NonNull Operation> cOperations = new ArrayList<>();
		for (@NonNull Operation rOperation : QVTbaseUtil.getOwnedOperations(rTransformation)) {
			Element cOperation = qvtr2qvtc.createCopy(rOperation);
			if (cOperation instanceof Operation) {
				cOperations.add((Operation) cOperation);
				qvtr2qvtc.putGlobalTrace(cOperation, rOperation);
			}
		}
		Transformation cTransformation = getCoreTransformation();
		cTransformation.getOwnedOperations().addAll(cOperations);
		for (@NonNull Operation cOperation : cOperations) {
			qvtr2qvtc.updateCopy(cOperation);
		}
	}
}
