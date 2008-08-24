/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AbstractCreationFactory.java,v 1.3 2008/08/24 19:12:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.common;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonEditorDefinition;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public abstract class AbstractCreationFactory implements ICreationFactory
{
	private Language language = null;

	public void assignXmiIds(XMLResource resource) {
		XMIUtils.assignIds(resource, XMIUtils.uuidCreator, null);
	}

	public CommonTreeModelBuilder createTreeModelBuilder(boolean showAST) {
		return new CommonTreeModelBuilder(this, showAST);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> key) {
		if (key.isAssignableFrom(getClass()))
			return (T) this;
		return null;
	}
	
	public final String getEMOFExtension() {
		return QVTPreferences.getExtension(getEMOFExtensions());	
	}
	
	public final String getEcoreExtension() {
		return QVTPreferences.getExtension(getEcoreExtensions());	
	}

	public CommonEditorDefinition getEditorDefinition() {
		return getPlugin().getEditorDefinition();
	}

	@Override
	public String getErrorMarkerId() {
		return getProblemMarkerId();
	}

	@Override
	public String getInfoMarkerId() {
		return getProblemMarkerId();
	}

	public Language getLanguage() {
		if (language == null)
			language = LanguageRegistry.findLanguage(getLanguageName());
		return language;
	}

	public String getLanguageName() {
		return getPlugin().getLanguageName();
	}
	
	@Override
	public String getWarningMarkerId() {
		return getProblemMarkerId();
	}

	public final String getXMLExtension() {
		boolean generateEMOF = QVTPreferences.generateEMOF();
		return generateEMOF ? getEMOFExtension() : getEcoreExtension();
	}
}
