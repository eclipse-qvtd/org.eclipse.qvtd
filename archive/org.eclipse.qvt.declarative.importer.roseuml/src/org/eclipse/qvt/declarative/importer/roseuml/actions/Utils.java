/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;

public class Utils
{   
	/**
	 * If ePackages contains a PrimitiveTypes and an EMOF package, move all classifiers from
	 * PrimitiveTypes to EMOF, change the EMOF nsURI to http://schema.omg.org/spec/mof/2.0/emof.xmi
	 * and remove PrimitiveTypes from ePackages.
	 * 
	 * @param ePackages
	 * @return true if conversion occurred
	 */
	public static boolean convertToTraditionalEMOF(List<EPackage> ePackages) {
		EPackage primitiveTypesPackage = Utils.findNamedElement(ePackages, "PrimitiveTypes");
		EPackage emofPackage = Utils.findNamedElement(ePackages, "EMOF");
		if ((primitiveTypesPackage == null) || (emofPackage == null))
			return false;
		emofPackage.getEClassifiers().addAll(primitiveTypesPackage.getEClassifiers());
		emofPackage.setNsURI(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
		ePackages.remove(primitiveTypesPackage);
		return true;
	}

    public static <T extends ENamedElement> T findNamedElement(List<? extends T> elements, String name) {
		for (T element : elements)
			if (name.equals(element.getName()))
				return element;
		return null;
	}
	  
    public static String formatDiagnostic(Diagnostic diagnostic, String prefix)
    {
        StringBuilder result = new StringBuilder();
        result.append(prefix);
//        result.append("Diagnostic ");
        switch (diagnostic.getSeverity())
        {
            case Diagnostic.OK: result.append("OK"); break;
            case Diagnostic.INFO: result.append("INFO"); break;
            case Diagnostic.WARNING: result.append("WARNING"); break;
            case Diagnostic.ERROR: result.append("ERROR"); break;
            case Diagnostic.CANCEL: result.append("CANCEL"); break;
            default: result.append(Integer.toHexString(diagnostic.getSeverity())); break;
        }
//        result.append(" source="); 
//        result.append(diagnostic.getSource());
        result.append(" code="); 
        result.append(diagnostic.getCode());
        result.append(' ');
        result.append(diagnostic.getMessage());
        List<?> data = diagnostic.getData();
        if ((data != null) && !data.isEmpty())
        {
            result.append(" data=");
            result.append(data);
        }
        List<Diagnostic> children = diagnostic.getChildren();
        if ((children != null) && !children.isEmpty())
        	for (Diagnostic child : children)
        	{
        		result.append('\n');
        		result.append(formatDiagnostic(child, prefix + "  "));
        	}
        return result.toString();
    }  

	public static <T extends ENamedElement> void sort(EList<T> eList) {
		List<T> list = new ArrayList<T>(eList);
		Collections.sort(list, new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		for (int i = 0; i < list.size(); i++) {
			eList.move(i, list.get(i));
		}
	}
}
