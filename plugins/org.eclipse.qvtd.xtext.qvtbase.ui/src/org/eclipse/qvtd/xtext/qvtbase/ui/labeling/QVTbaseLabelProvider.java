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
package org.eclipse.qvtd.xtext.qvtbase.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTbaseLabelProvider extends EssentialOCLLabelProvider
{
	public static final String QVTBASE_UI_ICONS = "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/";

	@Inject
	public QVTbaseLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(Domain ele) {
		return QVTBASE_UI_ICONS + "Domain.gif";
	}

	protected String image(Function ele) {
		return QVTBASE_UI_ICONS + "Function.gif";
	}

	protected String image(FunctionParameter ele) {
		return QVTBASE_UI_ICONS + "FunctionParameter.gif";
	}

	protected String image(Pattern ele) {
		return QVTBASE_UI_ICONS + "Pattern.gif";
	}

	protected String image(Predicate ele) {
		return QVTBASE_UI_ICONS + "Predicate.gif";
	}

	protected String image(Rule ele) {
		return QVTBASE_UI_ICONS + "Rule.gif";
	}

	protected String image(Transformation ele) {
		return QVTBASE_UI_ICONS + "Transformation.gif";
	}

	protected String image(TypedModel ele) {
		return QVTBASE_UI_ICONS + "TypedModel.gif";
	}

	protected String text(Domain ele) {
		return NameUtil.getSafeName(ele);
	}

	protected String text(FunctionParameter ele) {
		return NameUtil.getSafeName(ele);
	}

	protected String text(Rule ele) {
		return NameUtil.getSafeName(ele);
	}

	protected String text(Transformation ele) {
		return NameUtil.getSafeName(ele);
	}

	protected String text(TypedModel ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele);
		s.append("{");
		String prefix = "";
		for (NamedElement usedPackage : ele.getUsedPackage()) {
			s.append(prefix);
			appendName(s, usedPackage);
			prefix = ",";
		}
		s.append("}");
		return s.toString();
	}
}
