/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.xtext.qvtcorebase.ui.labeling.QVTcoreBaseLabelProvider;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTcoreLabelProvider extends QVTcoreBaseLabelProvider {

	@Inject
	public QVTcoreLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(Mapping ele) {
		return QVTCOREBASE_UI_ICONS + "Mapping.gif";
	}

	protected String image(TopLevelCS ele) {
		return "QVTcModelFile.gif";
	}
}
