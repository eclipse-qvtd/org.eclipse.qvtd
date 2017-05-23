/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.build.mwe;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe2.runtime.Mandatory;

public class CSTracePropertyInjector extends AbstractWorkflowComponent2 {

	public static class ASTraceInfo {
		private String genModelURI;
		private String traceClassName;

		@Mandatory
		public void setTargetGenModel(String genModelURI) {
			this.genModelURI = genModelURI;
		}

		@Mandatory
		public void setTargetTypeName(String className) {
			this.traceClassName = className;
		}
	}

	public static class CSTraceInfo {
		private String baseGenModelURI;
		private String targetGenModelURI;
		private String traceClassName = "CSTrace";
		private String tracePropName = "ast";

		@Mandatory
		public void setTargetGenModel(String genModelURI) {
			this.targetGenModelURI = genModelURI;
		}

		public void setBaseGenModel(String genModelURI) {
			this.baseGenModelURI = genModelURI;
		}

		public void setTracePropertyName(String tracePropName) {
			this.tracePropName = tracePropName;
		}

		public void setTraceClassName(String traceClassName) {
			this.traceClassName = traceClassName;
		}
	}

	private ResourceSet rSet;

	private CSTraceInfo csTraceInfo;
	private ASTraceInfo asTraceType;


	@Override
	public void preInvoke() {
		super.preInvoke();
		if (csTraceInfo.baseGenModelURI == null) {
			csTraceInfo.baseGenModelURI = csTraceInfo.targetGenModelURI;
		}
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {

		try {
			EClass traceClass = getCSTraceClass(csTraceInfo.baseGenModelURI);
			Resource targetResource = rSet.getResource(URI.createURI(csTraceInfo.targetGenModelURI), true);
			GenModel targetGenModel = (GenModel) targetResource.getContents().get(0);
			GenPackage targetGenPackage = targetGenModel.getGenPackages().get(0); // FIXME what if we have many ?
			EPackage targetEPackage = targetGenPackage.getEcorePackage();

			boolean targetChanged = false;
			for (EClassifier eClassifier : targetEPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (eClass.getESuperTypes().size() == 0
							&& eClass != traceClass) {
						eClass.getESuperTypes().add(traceClass);
						targetChanged = true;
					}
				}
			}

			if (targetChanged) {
				targetEPackage.eResource().save(null);
				targetGenModel.reconcile();
				targetResource.save(null);
			}
		} catch(IOException e) {
			issues.addError(e.getMessage());
		}
	}

	private EClass getCSTraceClass(String genModelURI) throws IOException {

		Resource resource = rSet.getResource(URI.createURI(genModelURI), true);
		GenModel genModel = (GenModel) resource.getContents().get(0);
		GenPackage baseGenPackage = genModel.getGenPackages().get(0); // FIXME what if we have many ?
		EPackage ePackage = baseGenPackage.getEcorePackage();

		String traceClassName = csTraceInfo.traceClassName;
		String tracePropName = csTraceInfo.tracePropName;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (traceClassName.equals(eClass.getName())) {
					for (EReference eRef : eClass.getEReferences()) {
						if (tracePropName.equals(eRef.getName())) {
							return eClass;
						}
					}
				}
			}
		}

		// If not found we create it
		// FIXME solve the situation of having an already "traceClassName" class with no ast property
		EClass traceClass = EcoreFactory.eINSTANCE.createEClass();
		traceClass.setName(traceClassName);
		traceClass.setAbstract(true);
		EReference traceProp = EcoreFactory.eINSTANCE.createEReference();
		traceProp.setName(tracePropName);
		traceProp.setTransient(true);
		if (asTraceType == null) {
			traceProp.setEType(EcorePackage.Literals.EOBJECT);
		} else {
			Resource asResource = rSet.getResource(URI.createURI(asTraceType.genModelURI), true);
			GenModel asGenModel = (GenModel) asResource.getContents().get(0);
			GenPackage asGenPackage = asGenModel.getGenPackages().get(0); // FIXME what if we have many ?
			EPackage asEPackage = asGenPackage.getEcorePackage();
			traceProp.setEType(getASTraceClass(asEPackage));
			List<GenPackage> usedGenPackages = genModel.getUsedGenPackages();
			if (!usedGenPackages.contains(asGenPackage)) {
				usedGenPackages.add(asGenPackage);
			}
		}


		traceClass.getEStructuralFeatures().add(traceProp);
		ePackage.getEClassifiers().add(traceClass);


		ePackage.eResource().save(null);
		genModel.reconcile();
		resource.save(null);
		return traceClass;
	}

	private EClass getASTraceClass(EPackage ePackage, boolean isNestedPackage) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (asTraceType.traceClassName.equals(eClass.getName())) {
					return eClass;
				}
			}
		}
		for (EPackage nestedPackage : ePackage.getESubpackages()) {
			EClass asTraceClass = getASTraceClass(nestedPackage, true);
			if (asTraceClass != null) {
				return asTraceClass;
			}
		}
		if (isNestedPackage) {
			return null;
		} else {
			throw new IllegalStateException(MessageFormat.format("AS class with name {0} not found in the EPackage of {1}", asTraceType.traceClassName,asTraceType.genModelURI));
		}
	}

	private EClass getASTraceClass(EPackage ePackage) {
		return getASTraceClass(ePackage, false);
	}

	@Mandatory
	public void setResourceSet(ResourceSet rSet) {
		this.rSet = rSet;
	}

	@Mandatory
	public void setCSTraceInfo(CSTraceInfo csTraceInfo) {
		this.csTraceInfo = csTraceInfo;
	}

	public void setASTraceType(ASTraceInfo asTraceInfo) {
		this.asTraceType = asTraceInfo;
	}

}
