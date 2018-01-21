/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameReservation;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTi extends QVTimperativeHelper
{
	protected final @NonNull ProblemHandler problemHandler;

	public QVTs2QVTi(@NonNull ProblemHandler problemHandler, @NonNull QVTbaseEnvironmentFactory environmentFactory) {
		super(environmentFactory);
		this.problemHandler = problemHandler;
	}

	protected void resolveImports(@NonNull Model model) {
		Set<@NonNull Namespace> importedNamespaces = new HashSet<@NonNull Namespace>();
		for (EObject eObject : new TreeIterable(model, false)) {
			if (eObject instanceof ImperativeTypedModel) {
				for (Namespace importedNamespace : ClassUtil.nullFree(((ImperativeTypedModel)eObject).getUsedPackage())) {
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
			ownedImports.add(createImport(/*null*/ "mm_" +importedNamespace.getName() + "MM" , importedNamespace));	// FIXME BUG 530025 bad aliases
		}
	}

	protected void resolveTransformation(@NonNull Model model, @NonNull ScheduledRegion scheduledRegion) {
		ScheduleManager scheduleManager = RegionUtil.getScheduleManager(scheduledRegion);
		SymbolNameReservation symbolNameReservation = scheduleManager.getScheduleModel().getSymbolNameAdapter();
		Transformation transformation = scheduleManager.getTransformation();
		QVTs2QVTiVisitor visitor = new QVTs2QVTiVisitor(scheduleManager, problemHandler, this, transformation, symbolNameReservation);
		Transformation qvtiTransformation = (Transformation)scheduledRegion.accept(visitor);
		NamedElement qvtiChild = qvtiTransformation;
		for (org.eclipse.ocl.pivot.Package qvtmPackage = transformation.getOwningPackage(); qvtmPackage != null; qvtmPackage = qvtmPackage.getOwningPackage()) {
			org.eclipse.ocl.pivot.@NonNull Package qvtiPackage = createPackage(ClassUtil.nonNull(qvtmPackage.getName()), qvtmPackage.getNsPrefix(), qvtmPackage.getURI());
			if (qvtiChild instanceof Transformation) {
				qvtiPackage.getOwnedClasses().add((Transformation)qvtiChild);
			}
			else {
				qvtiPackage.getOwnedPackages().add((org.eclipse.ocl.pivot.Package)qvtiChild);
			}
			qvtiChild = qvtiPackage;
		}
		model.getOwnedPackages().add((org.eclipse.ocl.pivot.Package)qvtiChild);
	}

	public @NonNull Model transform(@NonNull ScheduledRegion scheduledRegion) {
		Model model = PivotUtil.createModel(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, null);
		resolveTransformation(model, scheduledRegion);
		resolveImports(model);
		return model;
	}
}
