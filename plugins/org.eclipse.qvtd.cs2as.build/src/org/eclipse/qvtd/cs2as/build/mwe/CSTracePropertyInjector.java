package org.eclipse.qvtd.cs2as.build.mwe;

import java.io.IOException;

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

// TODO ideally we could be interesting in setting the TYPE of the trace property, so we point to something more
// specific than than an EObject
public class CSTracePropertyInjector extends AbstractWorkflowComponent2 {

	private String baseGenModelURI;
	private String targetGenModelURI;
	private ResourceSet rSet;
	private String tracePropName = "ast";
	
	
	@Override
	public void preInvoke() {
		super.preInvoke();
		if (baseGenModelURI == null) {
			baseGenModelURI = targetGenModelURI;
		}
	}
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		
		Resource targetResource = rSet.getResource(URI.createURI(targetGenModelURI), true);
		GenModel targetGenModel = (GenModel) targetResource.getContents().get(0);
		GenPackage targetGenPackage = targetGenModel.getGenPackages().get(0); // FIXME what if we have many ?
		EPackage targetEPackage = targetGenPackage.getEcorePackage();
		
		Resource baseResource = rSet.getResource(URI.createURI(baseGenModelURI), true);
		GenModel baseGenModel = (GenModel) baseResource.getContents().get(0);
		GenPackage baseGenPackage = baseGenModel.getGenPackages().get(0); // FIXME what if we have many ?
		EPackage baseEPackage = baseGenPackage.getEcorePackage();
		
		EClass traceClass = getTraceClass(baseEPackage);
		for (EClassifier eClassifier : targetEPackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (eClass.getESuperTypes().size() == 0
					&& eClass != traceClass) {
					eClass.getESuperTypes().add(traceClass);
				}
			}
		}
		
		baseGenPackage.reconcile();
		targetGenPackage.reconcile();
		
		try {
			targetResource.save(null);
			baseResource.save(null);
			targetEPackage.eResource().save(null);
			baseEPackage.eResource().save(null);
		} catch(IOException e) {
			issues.addError(e.getMessage());
		}
		
	}
		
	private EClass getTraceClass(EPackage ePackage) {
				
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if ("CSTrace".equals(eClass.getName())) {
					for (EReference eRef : eClass.getEReferences()) {
						if (tracePropName.equals(eRef.getName())) {
							return eClass;
						}
					}
				}
			}
		}
		
		// If not found we create it
		// FIXME solve the situation of having an already CSTrace class with no ast property
		
		EClass traceClass = EcoreFactory.eINSTANCE.createEClass();
		traceClass.setName("CSTrace");
		traceClass.setAbstract(true);
		EReference traceProp = EcoreFactory.eINSTANCE.createEReference();
		traceProp.setName(tracePropName);
		traceProp.setTransient(true);
		traceProp.setEType(EcorePackage.Literals.EOBJECT);
		
		traceClass.getEStructuralFeatures().add(traceProp);
		ePackage.getEClassifiers().add(traceClass);
		return traceClass;

		
	}
	
	@Mandatory
	public void setResourceSet(ResourceSet rSet) {
		this.rSet = rSet;
	}
		
	public void setBaseGenModel(String genModelURI) {
		this.baseGenModelURI = genModelURI;
	}
	
	@Mandatory
	public void setTargetGenModel(String genModelURI) {
		this.targetGenModelURI = genModelURI;
	}
	
	public void setTracePropertyName(String tracePropName) {
		this.tracePropName = tracePropName;
	}

}
