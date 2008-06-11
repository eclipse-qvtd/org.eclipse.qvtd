package org.eclipse.qvt.declarative.relations.atlvm.utils;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.relations.atlvm.ATLVMCompiler;

public class ASMEMFModelUtils {
	
	public static EPackage getMetamodel (Resource resource){
		EPackage result = null;
		result = resource.getContents().get(0).eClass().getEPackage();
		return result;
	}
	
	public static String getManageableURI (EPackage ePackage) {
		return "uri:" +  ePackage.getNsURI(); //$NON-NLS-1$
	}
	
	public static ASMEMFModel getASMEMFModelFrom (EPackage ePackage) {
		try {
			ASMEMFModel result = ASMEMFModel.loadASMEMFModel(
					ePackage.getName(), ASMEMFModel.createMOF(null), getManageableURI(ePackage), null);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static ASMEMFModel getASMEMFModelFrom (Resource resource, String name) throws Exception {
		resource.load(Collections.EMPTY_MAP);
		EPackage metamodelPackage = getMetamodel(resource);
		ASMEMFModel metamodel = getASMEMFModelFrom(metamodelPackage);
		return ASMEMFModel.loadASMEMFModel(name, metamodel, resource.getURI(), null);
	}
	
	public static ASMEMFModel getASMEMFModelFrom (IFile file, String name) throws Exception {
		if (file.exists()) {
			URI fileURI = URI.createFileURI(file.getLocation().toString());
			Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(fileURI);
			Resource resource = factory.createResource(fileURI);
			return getASMEMFModelFrom(resource, name);
		}
		throw new IllegalArgumentException("file invalid: "+file);
	}

}
