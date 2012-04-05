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
package org.eclipse.qvt.declarative.parser.qvt.environment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;

public class MoreEcoreForeignMethods
{   
    /**
     * Foreign method for {@link EClass#getEStructuralFeature(String)}
     * that accounts for possibility of underscore-escaped names.
     * 
     * @param cls a class
     * @param name a possibly underscore-escaped name of a feature
     * 
     * @return the matching feature, or <code>null</code> if none
     */
    public static EStructuralFeature getEStructuralFeature(EClass cls, String name) {
    	EStructuralFeature result = cls.getEStructuralFeature(name);
        
        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            // try the unescaped name
            result = cls.getEStructuralFeature(AbstractOCLAnalyzer.unescape(name));
        }
        
        return result;
    }
}
