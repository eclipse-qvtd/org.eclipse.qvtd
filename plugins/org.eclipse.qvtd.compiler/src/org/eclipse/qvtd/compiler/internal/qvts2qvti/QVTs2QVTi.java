/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameReservation;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTi extends QVTimperativeHelper
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ProblemHandler problemHandler;

	public QVTs2QVTi(@NonNull ScheduleManager scheduleManager, @NonNull ProblemHandler problemHandler, @NonNull QVTimperativeEnvironmentFactory environmentFactory) {
		super(environmentFactory);
		this.scheduleManager = scheduleManager;
		this.problemHandler = problemHandler;
		assert scheduleManager.getEnvironmentFactory() == environmentFactory;
	}

	protected @NonNull Package getPackage(@NonNull ImperativeModel iModel, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		List<org.eclipse.ocl.pivot.@NonNull Package> iPackages;
		org.eclipse.ocl.pivot.Package asParentPackage = asPackage.getOwningPackage();
		if (asParentPackage != null) {
			org.eclipse.ocl.pivot.@NonNull Package iParentPackage = getPackage(iModel, asParentPackage);
			iPackages = QVTimperativeUtil.Internal.getOwnedPackagesList(iParentPackage);
		}
		else {
			iPackages = QVTimperativeUtil.Internal.getOwnedPackagesList(iModel);
		}
		String name = PivotUtil.getName(asPackage);
		org.eclipse.ocl.pivot.Package iPackage = NameUtil.getNameable(iPackages, name);
		if (iPackage == null) {
			iPackage = createPackage(name, asPackage.getNsPrefix(), asPackage.getURI());
			iPackages.add(iPackage);
		}
		return iPackage;
	}

	public @NonNull ProblemHandler getProblemHandler() {
		return problemHandler;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	protected @NonNull ImperativeTransformation getTransformation(@NonNull ImperativeModel iModel, @NonNull Transformation asTransformation) {
		org.eclipse.ocl.pivot.Package asParentPackage = ClassUtil.nonNullState(asTransformation.getOwningPackage());
		org.eclipse.ocl.pivot.@NonNull Package iParentPackage = getPackage(iModel, asParentPackage);
		List<org.eclipse.ocl.pivot.@NonNull Class> iClasses = QVTimperativeUtil.Internal.getOwnedClassesList(iParentPackage);
		String name = PivotUtil.getName(asTransformation);
		org.eclipse.ocl.pivot.Class iTransformation = NameUtil.getNameable(iClasses, name);
		if ((iTransformation == null) || !(iTransformation instanceof ImperativeTransformation)) {
			iTransformation = createTransformation(name);
			iClasses.add(iTransformation);
			Transformation2TracePackage transformation2TracePackage = scheduleManager.getTransformation2TracePackage(asTransformation);
			org.eclipse.ocl.pivot.Class transformationTraceClass = transformation2TracePackage.getTransformationTraceClass();
			((ImperativeTransformation)iTransformation).setContextType(transformationTraceClass);
			for (@NonNull TypedModel qvtmTypedModel : QVTbaseUtil.getModelParameters(asTransformation)) {
				TypedModel qvtiTypedModel = createTypedModel(PivotUtil.getName(qvtmTypedModel));
				qvtiTypedModel.getUsedPackage().addAll(qvtmTypedModel.getUsedPackage());
				qvtiTypedModel.setIsPrimitive(qvtmTypedModel.isIsPrimitive());
				qvtiTypedModel.setIsThis(qvtmTypedModel.isIsThis());
				qvtiTypedModel.setIsTrace(qvtmTypedModel.isIsTrace());
			}
		}
		return (ImperativeTransformation) iTransformation;
	}

	protected @NonNull TypedModel getTypedModel(@NonNull ImperativeTransformation iTransformation, @NonNull TypedModel asTypedModel) {
		TypedModel iTypedModel = NameUtil.getNameable(QVTimperativeUtil.getModelParameters(iTransformation), PivotUtil.getName(asTypedModel));
		if (iTypedModel == null) {
			iTypedModel = createTypedModel(PivotUtil.getName(asTypedModel));
			iTypedModel.getUsedPackage().addAll(asTypedModel.getUsedPackage());
			iTypedModel.setIsPrimitive(asTypedModel.isIsPrimitive());
			iTypedModel.setIsThis(asTypedModel.isIsThis());
			iTypedModel.setIsTrace(asTypedModel.isIsTrace());
			iTransformation.getModelParameter().add(iTypedModel);
		}
		return iTypedModel;
	}

	protected @NonNull Map<@NonNull TypedModel, @NonNull TypedModel> getTypedModels(@NonNull ImperativeTransformation iTransformation, @NonNull Transformation asTransformation) {
		@NonNull Map<@NonNull TypedModel, @NonNull TypedModel> asTypedModel2qvtiTypedModel = new HashMap<>();
		for (@NonNull TypedModel asTypedModel : QVTbaseUtil.getModelParameters(asTransformation)) {
			TypedModel iTypedModel = getTypedModel(iTransformation, asTypedModel);
			asTypedModel2qvtiTypedModel.put(asTypedModel, iTypedModel);
		}
		return asTypedModel2qvtiTypedModel;
	}

	public void resolveImports(@NonNull ImperativeModel model) {
		Set<@NonNull Namespace> importedNamespaces = new HashSet<@NonNull Namespace>();
		for (EObject eObject : new TreeIterable(model, false)) {
			if (eObject instanceof TypedModel) {
				for (Namespace importedNamespace : ClassUtil.nullFree(((TypedModel)eObject).getUsedPackage())) {
					if (!importedNamespaces.contains(importedNamespace)) {
						importedNamespaces.add(importedNamespace);
					}
				}
			}
			else if (eObject instanceof OperationCallExp) {
				Operation asOperation = ((OperationCallExp)eObject).getReferredOperation();
				if (asOperation != null) {
					org.eclipse.ocl.pivot.Class asClass = asOperation.getOwningClass();
					if (asClass != null) {
						org.eclipse.ocl.pivot.Package asPackage = asClass.getOwningPackage();
						if (asPackage != null) {
							importedNamespaces.add(asPackage);
						}
					}
				}
			}
			else if (eObject instanceof LoopExp) {
				Iteration asIteration = ((LoopExp)eObject).getReferredIteration();
				if (asIteration != null) {
					org.eclipse.ocl.pivot.Class asClass = asIteration.getOwningClass();
					if (asClass != null) {
						org.eclipse.ocl.pivot.Package asPackage = asClass.getOwningPackage();
						if (asPackage != null) {
							importedNamespaces.add(asPackage);
						}
					}
				}
			}
			else if (eObject instanceof PropertyCallExp) {
				Property asProperty = ((PropertyCallExp)eObject).getReferredProperty();
				if (asProperty != null) {
					org.eclipse.ocl.pivot.Class asClass = asProperty.getOwningClass();
					if (asClass != null) {
						org.eclipse.ocl.pivot.Package asPackage = asClass.getOwningPackage();
						if (asPackage != null) {
							importedNamespaces.add(asPackage);
						}
					}
				}
			}
			else if (eObject instanceof OppositePropertyCallExp) {
				Property asProperty = ((OppositePropertyCallExp)eObject).getReferredProperty();
				if (asProperty != null) {
					org.eclipse.ocl.pivot.Class asClass = asProperty.getOwningClass();
					if (asClass != null) {
						org.eclipse.ocl.pivot.Package asPackage = asClass.getOwningPackage();
						if (asPackage != null) {
							importedNamespaces.add(asPackage);
						}
					}
				}
			}
		}
		List<@NonNull Namespace> sortedImportedNamespaces = new ArrayList<@NonNull Namespace>(importedNamespaces);
		//			for (@NonNull TypedModel typedModel : ClassUtil.nullFree(qvtiTransformation.getModelParameter())) {
		//				for (Namespace importedNamespace : ClassUtil.nullFree(typedModel.getUsedPackage())) {
		//					if (!importedNamespaces.contains(importedNamespace)) {
		//						importedNamespaces.add(importedNamespace);
		//					}
		//				}
		//			}
		Collections.sort(sortedImportedNamespaces, NameUtil.NAMEABLE_COMPARATOR);
		List<Import> ownedImports = model.getOwnedImports();
		for (@NonNull Namespace importedNamespace : sortedImportedNamespaces) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("mm_");
			//			for (@NonNull String partialName : partialNames) {
			//				s.appendString("_");
			//				s.appendName(partialName);
			//			}
			s.appendName(importedNamespace.getName());
			s.appendName("MM");
			String name = model.reserveSymbolName(s, importedNamespace);
			ownedImports.add(createImport(name, importedNamespace));	// FIXME BUG 530025 bad aliases
		}
	}

	public @NonNull Model transform(@NonNull ImperativeModel model, @NonNull RootRegion rootRegion) {
		SymbolNameReservation symbolNameReservation = scheduleManager.getScheduleModel().getSymbolNameAdapter();
		Transformation asTransformation = QVTscheduleUtil.getReferredTransformation(rootRegion);
		ImperativeTransformation iTransformation = getTransformation(model, asTransformation);
		Map<@NonNull TypedModel, @NonNull TypedModel> asTypedModel2qvtiTypedModel = getTypedModels(iTransformation, asTransformation);
		QVTs2QVTiVisitor visitor = new QVTs2QVTiVisitor(this, symbolNameReservation, asTypedModel2qvtiTypedModel);
		rootRegion.accept(visitor);
		return model;
	}
}
