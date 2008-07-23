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
package org.eclipse.qvt.declarative.importer.roseuml.ui;

import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.emf.importer.rose.ui.RoseDetailPage;
import org.eclipse.qvt.declarative.importer.roseuml.RoseUMLImporterPlugin;


/**
 * @since 2.1.0
 */
public class RoseUMLDetailPage extends RoseDetailPage
{
  public RoseUMLDetailPage(ModelImporter modelImporter, String pageName)
  {
    super(modelImporter, pageName);

    setTitle(RoseUMLImporterPlugin.INSTANCE.getString("_UI_RoseUMLModelImport_title"));
    setDescription(RoseUMLImporterPlugin.INSTANCE.getString(showGenModel() ?
      "_UI_RoseUMLModelImportNewProject_description" : "_UI_RoseUMLModelImportFile_description"));
  }
}