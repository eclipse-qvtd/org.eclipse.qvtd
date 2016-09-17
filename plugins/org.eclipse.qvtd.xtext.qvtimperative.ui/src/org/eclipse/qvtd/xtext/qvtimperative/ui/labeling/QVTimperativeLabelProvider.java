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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.xtext.qvtbase.ui.labeling.QVTbaseLabelProvider;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTimperativeLabelProvider extends QVTbaseLabelProvider
{
	public static final String QVTIMPERATIVE_UI_ICONS = "/org.eclipse.qvtd.xtext.qvtimperative.ui/icons/";

	@Inject
	public QVTimperativeLabelProvider(org.eclipse.emf.edit.ui.provider.@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	//	protected String image(Direction ele) {
	//		return QVTCOREBASE_UI_ICONS + "Direction.gif";
	//	}

	protected String image(DomainCS ele) {
		return QVTIMPERATIVE_UI_ICONS + "CoreDomain.gif";
	}

	protected String image(ImperativeDomain ele) {
		return QVTIMPERATIVE_UI_ICONS + "CoreDomain.gif";
	}

	protected String image(Mapping ele) {
		return QVTIMPERATIVE_UI_ICONS + "Mapping.gif";
	}

	protected String image(MappingCall ele) {
		return "MappingCall.gif";
	}

	protected String image(MappingCallBinding ele) {
		return "MappingCallBinding.gif";
	}

	protected String image(NewStatement ele) {
		return QVTIMPERATIVE_UI_ICONS + "NewStatement.gif";
	}

	protected String image(DeclareStatement ele) {
		return QVTIMPERATIVE_UI_ICONS + "CheckVariableStatement.gif";
	}

	protected String image(SetStatement ele) {
		return QVTIMPERATIVE_UI_ICONS + "SetStatement.gif";
	}

	protected String image(TopLevelCS ele) {
		return "QVTiModelFile.gif";
	}

	protected String text(ImperativeDomain ele) {
		StringBuilder s = new StringBuilder();
		if (ele.isIsCheckable()) {
			s.append("«checkable» ");
		}
		if (ele.isIsEnforceable()) {
			s.append("«enforceable» ");
		}
		appendName(s, ele);
		return s.toString();
	}

	protected String text(DomainCS ele) {
		return NameUtil.getSafeName(ele);
	}

	protected String text(MappingCall ele) {
		return NameUtil.getSafeName(ele.getReferredMapping());
	}

	protected String text(MappingCallBinding ele) {
		return NameUtil.getSafeName(ele.getBoundVariable());
	}

	protected String text(MappingLoop ele) {
		return "«for»";
	}

	protected String text(Predicate ele) {
		return "«predicate»";
	}

	protected String text(DeclareStatement ele) {
		assert ele != null;
		Namespace namespace = PivotUtil.getNamespace(ele.eContainer());
		if (namespace == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		s.append(PrettyPrinter.printName(ele, namespace));
		s.append(" : ");
		Type type = ele.getType();
		if (type != null) {
			s.append(PrettyPrinter.printType(type, namespace));
		}
		s.append(" := ");
		return s.toString();
	}

	protected String text(SetStatement ele) {
		assert ele != null;
		Namespace namespace = PivotUtil.getNamespace(ele.eContainer());
		if (namespace == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		VariableDeclaration targetVariable = ele.getTargetVariable();
		if (targetVariable != null) {
			s.append(PrettyPrinter.printName(targetVariable, namespace));
		}
		Property targetProperty = ele.getTargetProperty();
		s.append(".");
		if (targetProperty != null) {
			s.append(NameUtil.getSafeName(targetProperty));
		}
		s.append(" : ");
		if (targetProperty != null) {
			Type type = targetProperty.getType();
			if (type != null) {
				s.append(PrettyPrinter.printType(type, namespace));
			}
		}
		s.append(" := ");
		return s.toString();
	}
}
