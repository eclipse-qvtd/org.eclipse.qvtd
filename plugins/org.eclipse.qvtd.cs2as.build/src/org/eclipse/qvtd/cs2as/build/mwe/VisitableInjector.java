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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe2.runtime.Mandatory;

public class VisitableInjector extends AbstractWorkflowComponent2 {

	public static class VisitableInfo {
		private String baseGenModelURI;
		private String targetGenModelURI;
		private String className = "Visitable";
		private String instanceTypeName = "";
		private String mainPackageName;

		@Mandatory
		public void setTargetGenModel(String genModelURI) {
			this.targetGenModelURI = genModelURI;
		}

		public void setBaseGenModel(String genModelURI) {
			this.baseGenModelURI = genModelURI;
		}

		public void setVisitableClassName(String className) {
			this.className = className;
		}

		public void setMainPackageName(String mainPackage) {
			this.mainPackageName = mainPackage;
		}

		@Mandatory
		public void setVisitableInstanceTypeName(String instanceTypeName) {
			this.instanceTypeName = instanceTypeName;
		}
	}

	private ResourceSet rSet;

	private VisitableInfo visitableInfo;



	@Override
	public void preInvoke() {
		super.preInvoke();
		if (visitableInfo.baseGenModelURI == null) {
			visitableInfo.baseGenModelURI = visitableInfo.targetGenModelURI;
		}
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {

		try {
			EClass visitableClass = getVisitableClass(visitableInfo.baseGenModelURI);
			injectInterface(visitableInfo.targetGenModelURI, visitableClass);

		} catch(IOException e) {
			issues.addError(e.getMessage());
		}
	}

	private EPackage getMainPackage(GenModel targetGenModel, String mainPackageName) {

		if (mainPackageName == null) {
			GenPackage targetGenPackage = targetGenModel.getGenPackages().get(0); // FIXME what if we have many ?
			return targetGenPackage.getEcorePackage();
		} else {
			for (GenPackage gPackage : targetGenModel.getGenPackages()) {
				EPackage mainPackage = getMainPackage(gPackage, mainPackageName);
				if (mainPackage != null) {
					return mainPackage;
				}
			}
		}
		throw new IllegalStateException(MessageFormat.format("EPackage with name {0} not found in GenModel {1}", mainPackageName,targetGenModel.eResource().getURI()));
	}

	private EPackage getMainPackage(GenPackage targetGenPackage, String mainPackageName) {
		EPackage ePackage = targetGenPackage.getEcorePackage();
		if (mainPackageName.equals(ePackage.getName())) {
			return ePackage;
		} else {
			for (GenPackage nestedGPackage : targetGenPackage.getNestedGenPackages()) {
				EPackage mainPackage = getMainPackage(nestedGPackage, mainPackageName);
				if (mainPackage != null) {
					return mainPackage;
				}
			}
			return null;
		}
	}

	private void injectInterface(String genModelURI, EClass visitableClass) throws IOException {

		Resource targetResource = rSet.getResource(URI.createURI(genModelURI), true);
		GenModel targetGenModel = (GenModel) targetResource.getContents().get(0);
		boolean targetChanged = false;
		for (GenPackage gPackage : targetGenModel.getGenPackages()) {
			targetChanged |= injectInterface(gPackage, visitableClass);
		}
		if (targetChanged) {
			targetGenModel.reconcile();
			targetResource.save(null);
		}
	}
	private boolean injectInterface(GenPackage targetGenPackage, EClass visitableClass) throws IOException {

		EPackage targetEPackage = targetGenPackage.getEcorePackage();
		boolean targetChanged = false;
		for (EClassifier eClassifier : targetEPackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (eClass.getESuperTypes().size() == 0
						&& eClass != visitableClass) {
					eClass.getESuperTypes().add(visitableClass);
					targetChanged = true;
				}
			}
		}
		if (targetChanged) {
			targetEPackage.eResource().save(null);
		}
		return targetChanged;
	}
	private EClass getVisitableClass(String genModelURI) throws IOException {

		Resource resource = rSet.getResource(URI.createURI(genModelURI), true);
		GenModel genModel = (GenModel) resource.getContents().get(0);
		EPackage ePackage = getMainPackage(genModel, visitableInfo.mainPackageName);

		String className = visitableInfo.className;
		String instanceTypeName = visitableInfo.instanceTypeName;

		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (className.equals(eClass.getName())
						&& instanceTypeName.equals(eClass.getInstanceTypeName())) {
					return eClass;
				}
			}
		}

		// If not found we create it
		EClass visitableClass = EcoreFactory.eINSTANCE.createEClass();
		visitableClass.setName(className);
		visitableClass.setInstanceTypeName(instanceTypeName);
		visitableClass.setAbstract(true);
		visitableClass.setInterface(true);
		ePackage.getEClassifiers().add(visitableClass);


		ePackage.eResource().save(null);
		genModel.reconcile();
		resource.save(null);
		return visitableClass;
	}



	@Mandatory
	public void setResourceSet(ResourceSet rSet) {
		this.rSet = rSet;
	}

	@Mandatory
	public void setVisitableInfo(VisitableInfo csTraceInfo) {
		this.visitableInfo = csTraceInfo;
	}



}

