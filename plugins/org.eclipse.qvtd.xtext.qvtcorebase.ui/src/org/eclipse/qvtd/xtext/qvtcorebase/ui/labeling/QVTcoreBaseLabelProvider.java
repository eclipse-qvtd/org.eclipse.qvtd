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
package org.eclipse.qvtd.xtext.qvtcorebase.ui.labeling;

import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtbase.ui.labeling.QVTbaseLabelProvider;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTcoreBaseLabelProvider extends QVTbaseLabelProvider
{
	public static final String QVTCOREBASE_UI_ICONS = "/org.eclipse.qvtd.xtext.qvtcorebase.ui/icons/";


	@Inject
	public QVTcoreBaseLabelProvider(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(Assignment ele) {
		return QVTCOREBASE_UI_ICONS + "Assignment.gif";
	}

	protected String image(BottomPattern ele) {
		return QVTCOREBASE_UI_ICONS + "BottomPattern.gif";
	}

	protected String image(CoreDomain ele) {
		return QVTCOREBASE_UI_ICONS + "CoreDomain.gif";
	}

	protected String image(CorePattern ele) {
		return QVTCOREBASE_UI_ICONS + "CorePattern.gif";
	}

//	protected String image(Direction ele) {
//		return QVTCOREBASE_UI_ICONS + "Direction.gif";
//	}

	protected String image(DomainCS ele) {
		return QVTCOREBASE_UI_ICONS + "CoreDomain.gif";
	}

	protected String image(EnforcementOperation ele) {
		return QVTCOREBASE_UI_ICONS + "EnforcementOperation.gif";
	}

	protected String image(GuardPattern ele) {
		return QVTCOREBASE_UI_ICONS + "GuardPattern.gif";
	}

	protected String image(PropertyAssignment ele) {
		return QVTCOREBASE_UI_ICONS + "PropertyAssignment.gif";
	}

	protected String image(RealizedVariable ele) {
		return QVTCOREBASE_UI_ICONS + "RealizedVariable.gif";
	}

	protected String image(VariableAssignment ele) {
		return QVTCOREBASE_UI_ICONS + "VariableAssignment.gif";
	}

	protected String text(BottomPattern ele) {
		return "«bottom»";
	}

	protected String text(CoreDomain ele) {
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

	protected String text(GuardPattern ele) {
		return "«guard»";
	}

	protected String text(Predicate ele) {
		return "«predicate»";
	}

	protected String text(PropertyAssignment ele) {
		assert ele != null;
		Namespace namespace = PivotUtil.getNamespace(ele.eContainer());
		if (namespace == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		s.append(PrettyPrinter.printName(ele.getSlotExpression(), namespace));
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

	protected String text(VariableAssignment ele) {
		assert ele != null;
		Namespace namespace = PivotUtil.getNamespace(ele.eContainer());
		if (namespace == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		Variable targetVariable = ele.getTargetVariable();
		s.append(PrettyPrinter.printName(targetVariable, namespace));
		s.append(" : ");
		if (targetVariable != null) {
			Type type = targetVariable.getType();
			if (type != null) {
				s.append(PrettyPrinter.printType(type, namespace));
			}
		}
		s.append(" := ");
		return s.toString();
	}
}
