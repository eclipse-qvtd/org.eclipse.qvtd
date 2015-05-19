/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.ui.labeling;

import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.xtext.qvtcorebase.ui.labeling.QVTcoreBaseLabelProvider;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTimperativeLabelProvider extends QVTcoreBaseLabelProvider {

	@Inject
	public QVTimperativeLabelProvider(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(Mapping ele) {
		return QVTCOREBASE_UI_ICONS + "Mapping.gif";
	}

	protected String image(MappingCall ele) {
		return "MappingCall.gif";
	}

	protected String text(MappingCall ele) {
		return NameUtil.getSafeName(ele.getReferredMapping());
	}

	protected String image(MappingCallBinding ele) {
		return "MappingCallBinding.gif";
	}

	protected String text(MappingCallBinding ele) {
		return NameUtil.getSafeName(ele.getBoundVariable());
	}

	protected String text(MappingLoop ele) {
		return "«for»";
	}

	protected String text(MappingSequence ele) {
		return "«sequence»";
	}

	protected String image(TopLevelCS ele) {
		return "QVTiModelFile.gif";
	}
}
