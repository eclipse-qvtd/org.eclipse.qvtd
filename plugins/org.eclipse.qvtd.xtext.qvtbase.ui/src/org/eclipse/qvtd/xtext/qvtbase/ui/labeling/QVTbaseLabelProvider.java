package org.eclipse.qvtd.xtext.qvtbase.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;
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

	@Inject
	public QVTbaseLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(Domain ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/Domain.gif";
	}

	protected String image(Function ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/Function.gif";
	}

	protected String image(FunctionParameter ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/FunctionParameter.gif";
	}

	protected String image(Pattern ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/Pattern.gif";
	}

	protected String image(Predicate ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/Predicate.gif";
	}

	protected String image(Rule ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/Rule.gif";
	}

	protected String image(Transformation ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/Transformation.gif";
	}

	protected String image(TypedModel ele) {
		return "/org.eclipse.qvtd.xtext.qvtbase.ui/icons/TypedModel.gif";
	}

	protected String text(Domain ele) {
		return ele.getName();
	}

	protected String text(Rule ele) {
		return ele.getName();
	}

	protected String text(Transformation ele) {
		return ele.getName();
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
