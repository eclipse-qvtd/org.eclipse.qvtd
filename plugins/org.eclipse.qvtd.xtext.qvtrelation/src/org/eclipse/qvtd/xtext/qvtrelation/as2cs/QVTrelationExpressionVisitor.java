/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.as2cs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLExpressionVisitor;

public class QVTrelationExpressionVisitor extends EssentialOCLExpressionVisitor
{
	public static final Logger logger = Logger.getLogger(QVTrelationExpressionVisitor.class);

	public QVTrelationExpressionVisitor(@NonNull AS2CSConversion context, @Nullable Namespace scope) {
		super(context, scope);
	}

	@Override
	public ElementCS visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {   // FIXME see Bug 496148
		org.eclipse.ocl.pivot.Class scopeClass = context.getScope();
		org.eclipse.ocl.pivot.Package scopePackage = scopeClass != null ? PivotUtil.getPackage(scopeClass) : null;
		TypedTypeRefCS csRef = BaseCSFactory.eINSTANCE.createTypedTypeRefCS();
		Type type = PivotUtil.getUnspecializedTemplateableElement(object);
		PathNameCS csPathName = csRef.getOwnedPathName();
		if (csPathName == null) {
			PathNameCS csPathName2 = BaseCSFactory.eINSTANCE.createPathNameCS();
			csPathName = csPathName2;
			csRef.setOwnedPathName(csPathName);
		}
		context.refreshPathName(csPathName, type, context.getScope());
		csRef.setPivot(type);		// FIXME object ??
		if (!(type instanceof PrimitiveType)) {
			org.eclipse.ocl.pivot.Package objectPackage = PivotUtil.getPackage(type);
			if ((objectPackage != null) && (scopePackage != null) && objectPackage.eResource() != scopePackage.eResource()) {
				context.importNamespace(objectPackage, null);
			}
		}
		List<TemplateBinding> templateBindings = object.getOwnedBindings();
		if (templateBindings.isEmpty()) {
		}
		else {
			TemplateBindingCS csTemplateBinding = csRef.getOwnedBinding();
			if (csTemplateBinding == null) {
				csTemplateBinding = BaseCSFactory.eINSTANCE.createTemplateBindingCS();
				csRef.setOwnedBinding(csTemplateBinding);
			}
			List<TemplateParameterSubstitutionCS> csParameterSubstitutions = new ArrayList<TemplateParameterSubstitutionCS>();
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
					Type actual = templateParameterSubstitution.getActual();
					if (actual != null) {
						TemplateParameterSubstitutionCS csTemplateParameterSubstitution = BaseCSFactory.eINSTANCE.createTemplateParameterSubstitutionCS();
						TypeRefCS csParameterable = context.visitReference(TypeRefCS.class, actual, null);
						csTemplateParameterSubstitution.setOwnedActualParameter(csParameterable);
						csParameterSubstitutions.add(csTemplateParameterSubstitution);
						csTemplateParameterSubstitution.setPivot(templateParameterSubstitution);
					}
				}
			}
			context.refreshList(csTemplateBinding.getOwnedSubstitutions(), csParameterSubstitutions);
		}
		//		if (scopePackage == objectPackage) {
		return csRef;
		//		}
		// FIXME cascade paths wrt import aliases
		/*		QualifiedTypeRefCS qRef = BaseCSFactory.eINSTANCE.createQualifiedTypeRefCS();
		qRef.setNamespace(objectPackage);
		qRef.setElement(csRef);
		qRef.setPivot(object);
		return qRef;
		 */	}
}