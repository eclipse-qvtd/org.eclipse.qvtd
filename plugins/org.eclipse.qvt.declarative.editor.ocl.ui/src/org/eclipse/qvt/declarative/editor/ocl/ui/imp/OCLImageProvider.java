package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.editor.util.ImageProvider;

public class OCLImageProvider implements ImageProvider {

	public String getImage(Object object) {
		if (object instanceof Constraint) {
			Constraint constraint = (Constraint) object;
			String stereotype = constraint.getStereotype();
			if (UMLReflection.INVARIANT.equals(stereotype))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/InvariantConstraint.gif";
			else if (UMLReflection.POSTCONDITION.equals(stereotype))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/PostconditionConstraint.gif";
			else if (UMLReflection.PRECONDITION.equals(stereotype))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/PreconditionConstraint.gif";
			else if (UMLReflection.DEFINITION.equals(stereotype))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/DefinitionConstraint.gif";
			else if (UMLReflection.DERIVATION.equals(stereotype))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/DerivationConstraint.gif";
			else if (UMLReflection.INITIAL.equals(stereotype))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/InitialConstraint.gif";
		}
		else if (object instanceof PrePostOrBodyDeclCS) {
			PrePostOrBodyDeclCS prePostOrBodyDeclCS = (PrePostOrBodyDeclCS) object;
			PrePostOrBodyEnum kind = prePostOrBodyDeclCS.getKind();
			if (kind == PrePostOrBodyEnum.PRE_LITERAL)
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/PreconditionConstraint.gif";
			else if (kind == PrePostOrBodyEnum.POST_LITERAL)
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/PostconditionConstraint.gif";
		}
		else if (object instanceof OperationCallExp) {
			OperationCallExp operationCall = (OperationCallExp) object;
			EOperation operation = operationCall.getReferredOperation();
			String name = operation != null ? operation.getName() : null;
			if (PredefinedType.PLUS_NAME.equals(name))
				return "/org.eclipse.ocl.ecore.edit/icons/full/obj16/PlusOperationCallExp.gif";
		}
		return null;
	}
}
