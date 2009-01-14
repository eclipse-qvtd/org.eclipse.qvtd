/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: QVTrPlugin.java,v 1.4 2009/01/14 20:42:49 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.imp.runtime.PluginBase;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonEditorDefinition;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonPlugin;

public class QVTrPlugin extends PluginBase implements ICommonPlugin
{
	public static final String kPluginID = "org.eclipse.qvt.declarative.editor.qvtrelation.ui";
	public static final String kLanguageName = "qvtr";

	/**
	 * The unique instance of this plugin class
	 */
	protected static QVTrPlugin sPlugin;

	public static QVTrPlugin getInstance() {
		// SMS 11 Jul 2007
		// Added conditional call to constructor in case the plugin
		// class has not been auto-started
		if (sPlugin == null)
			new QVTrPlugin();
		return sPlugin;
	}
	
	private CommonEditorDefinition editorDefinition = null;
	
	public QVTrPlugin() {
		super();
		sPlugin = this;
	}

	public CommonEditorDefinition getEditorDefinition() {
		if (editorDefinition == null)
			editorDefinition = CommonEditorDefinition.create(this, "model/" + kLanguageName + ".editor");
		return editorDefinition;
	}

	@Override
	public String getID() {
		return kPluginID;
	}

	@Override
	public String getLanguageID() {
		return kLanguageName;
	}
}
