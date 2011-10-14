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
package org.eclipse.qvt.declarative.ecore.QVTTemplate.util;

import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseVisitor;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;

public interface QVTTemplateVisitor<T> extends QVTBaseVisitor<T>
{
    T visitCollectionTemplateExp(CollectionTemplateExp collectionTemplateExp);
    T visitObjectTemplateExp(ObjectTemplateExp objectTemplateExp);
    T visitPropertyTemplateItem(PropertyTemplateItem propertyTemplateItem);
}
