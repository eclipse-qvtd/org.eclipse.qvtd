package org.eclipse.qvt.declarative.parser.qvt.environment;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;

@SuppressWarnings("restriction")		// FIXME awaiting Bugzilla 182994
public class QVTReflectionImpl extends UMLReflectionImpl
{
    /** Shared instance of the stateless reflection service. */
	public static final UMLReflectionImpl INSTANCE = new QVTReflectionImpl();

	@Override public String getName(Object object) {
		if (object == null)
			return "_null_named_object_";
		String name;
		if (object instanceof TypedElement<?>)
			name = ((TypedElement<?>)object).getName();
		else if (object instanceof ENamedElement)
			name = ((ENamedElement)object).getName(); 
		else if (object instanceof String)
			name = (String)object; 
		else
			name = "_unnamed_"; 
		if ((name == null) || "".equals(name))
			return "_null_name_";
		else
			return name;
	}

	@Override public String getQualifiedName(Object object) {
		if (object == null)
			return "_null_qualified_named_object_";
		String name;
		if (object instanceof TypedElement<?>)
			name = ((TypedElement<?>)object).getName();
		else if (object instanceof ENamedElement)
			name = ((ENamedElement)object).getName(); 
		else
			name = "_unnamed_";
		if (object instanceof EObject) {
	        EObject container = ((EObject) object).eContainer();
	        if (container != null) {
		        String scope = getQualifiedName(container);
		        if (object instanceof EStructuralFeature)   
		            scope += ".";
		        else
		        	scope += "::";
		        name = scope + name;
	        }
		}
		return name;
	}

	@Override
	public boolean isStatic(Object feature) {
		if (feature instanceof Function)
			return true;
		return super.isStatic(feature);
	}
}
