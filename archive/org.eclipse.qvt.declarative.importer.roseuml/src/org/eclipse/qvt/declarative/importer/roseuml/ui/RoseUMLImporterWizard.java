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

import org.eclipse.emf.converter.ModelConverter;
import org.eclipse.emf.importer.rose.ui.RoseImporterWizard;
import org.eclipse.emf.importer.ui.contribution.base.ModelImporterPackagePage;
import org.eclipse.qvt.declarative.importer.roseuml.RoseUMLImporter;


/**
 */
public class RoseUMLImporterWizard extends RoseImporterWizard
{
  @Override
  protected ModelConverter createModelConverter()
  {
    return new RoseUMLImporter();
  }

  @Override
  public void addPages()
  {
    RoseUMLDetailPage detailPage = new RoseUMLDetailPage(getModelImporter(), "RoseUMLModel");
    addPage(detailPage);

    ModelImporterPackagePage packagePage = new ModelImporterPackagePage(getModelImporter(), "RoseUMLPackages");
    packagePage.setShowReferencedGenModels(true);
    addPage(packagePage);
  }
}
