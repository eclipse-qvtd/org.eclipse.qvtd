package org.eclipse.qvtd.xml.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.xml.Attribute;
import org.eclipse.qvtd.xml.Characters;
import org.eclipse.qvtd.xml.ClassAttribute;
import org.eclipse.qvtd.xml.ClassElement;
import org.eclipse.qvtd.xml.Document;
import org.eclipse.qvtd.xml.Element;
import org.eclipse.qvtd.xml.Node;

/**
 * Class owning methods used for service: umlx. The service methods
 * should be prefixed by umlx to avoid conflict with other services.
 */
public class XMLServices
{
	private static final @NonNull String XMLNS_PREFIX_COLON = ExtendedMetaData.XMLNS_PREFIX + ":";

	public XMLServices() {}

	private void gatherElements(@NonNull Node node, List<@NonNull Element> candidates) {
		if (node instanceof Element) {
			candidates.add((Element) node);
		}
		for (Node child : node.getChildren()) {
			if (child instanceof Element) {
				gatherElements(child, candidates);
			}
		}
	}

	private String getEPackagePrefix(EObject context, @NonNull EPackage ePackage) {
		EObject root = EcoreUtil.getRootContainer(context);
		if (!(root instanceof Document)) {
			return ePackage.getNsPrefix();
		}
		String nsURI = ePackage.getNsURI();
		if (nsURI == null) {
			return ePackage.getNsPrefix();
		}
		for (Node childNode : ((Document)root).getChildren()) {
			for (Node grandChildNode : childNode.getChildren()) {
				if (grandChildNode instanceof Attribute) {
					Attribute attribute = (Attribute) grandChildNode;
					String prefix = getXmlnsPrefix(attribute);
					if ((prefix != null) && nsURI.equals(attribute.getValue())) {
						return prefix;
					}
				}
			}
		}
		return ePackage.getNsPrefix();
	}

	private @Nullable String getXmlnsPrefix(@NonNull Attribute attribute) {
		String name = attribute.getName();
		if (name.startsWith(XMLNS_PREFIX_COLON)) {
			return name.substring(XMLNS_PREFIX_COLON.length());
		}
		return null;
	}

	private @Nullable String getXsiType(@NonNull Element element) {
		for (Node node : element.getChildren()) {
			if (node instanceof Attribute) {
				@NonNull Attribute attribute = (@NonNull Attribute) node;
				if (isXsiType(attribute)) {
					return attribute.getValue();
				}
			}
		}
		return null;
	}

	private boolean isXsiType(@NonNull Attribute attribute) {
		String name = attribute.getName();
		//		int colonIndex = name.indexOf(':');
		//		if (colonIndex < 0) {
		//			return false;		// Ignores the ridiculous cause of xsi/xmi as the default xlmns
		//		}
		return "xmi:type".equals(name) || "xsi:type".equals(name);	// FIXME use xmlns configs
	}

	public @NonNull String xmlAttributeLabel(EObject context) {
		if (context instanceof Attribute) {
			Attribute attribute = (Attribute)context;
			return attribute.getName() + " = " + attribute.getValue();
		}
		return "«xmlAttributeLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	}

	public @NonNull Collection<EObject> xmlAttributeSemanticsCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Element) {
			Element element = (Element)context;
			for (Node child : element.getChildren()) {
				if (child instanceof Attribute) {
					if (!(child instanceof ClassAttribute) && !isXsiType((Attribute)child)) {
						candidates.add(child);
					}
				}
			}
		}
		else {
			candidates.add(context);
		}
		return candidates;
	}

	public @NonNull String xmlCharactersLabel(EObject context) {
		if (context instanceof Characters) {
			Characters characters = (Characters)context;
			return characters.getData();
		}
		return "«xmlCharactersLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	}

	public @NonNull Collection<EObject> xmlCharactersSemanticsCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Element) {
			Element element = (Element)context;
			for (Node child : element.getChildren()) {
				if (child instanceof Characters) {
					candidates.add(child);
				}
			}
		}
		else {
			candidates.add(context);
		}
		return candidates;
	}

	/*	public @NonNull String xmlDocumentLabel(EObject context) {
		if (context instanceof Document) {
			Document document = (Document)context;
			return String.valueOf(document.eResource().getURI());
		}
		return "«xmlDocumentLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	/*	public @NonNull Collection<EObject> xmlDocumentSemanticsCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Document) {
			candidates.add(context);
		}
		return candidates;
	} */

	public @NonNull String xmlElement2ElementContainmentBeginLabel(EObject context) {
		if (context instanceof ClassElement) {
			Element element = (Element)context;
			EObject container = context.eContainer();
			if (container instanceof ClassElement) {
				ClassElement parent = (ClassElement)container;
				EClass eClass = parent.getEcoreClass();
				if (eClass != null) {
					EStructuralFeature eFeature = eClass.getEStructuralFeature(element.getQName());
					if (eFeature instanceof EReference) {
						EReference eReference = (EReference)eFeature;
						return eReference.getName();
					}
				}
			}
		}
		else if (context instanceof Element) {
			Element element = (Element)context;
			return String.valueOf(element.getQName());
		}
		return "";
	}

	public @NonNull String xmlElement2ElementContainmentEndLabel(EObject context) {
		if (context instanceof ClassElement) {
			Element element = (Element)context;
			EObject container = context.eContainer();
			if (container instanceof ClassElement) {
				ClassElement parent = (ClassElement)container;
				EClass eClass = parent.getEcoreClass();
				if (eClass != null) {
					EStructuralFeature eFeature = eClass.getEStructuralFeature(element.getQName());
					if (eFeature instanceof EReference) {
						EReference eReference = (EReference)eFeature;
						EReference eOpposite = eReference.getEOpposite();
						if (eOpposite != null) {
							String string = eOpposite.getName();
							if (string.endsWith("appliedProperty")) {
								getClass();
							}
							return string;
						}
					}
				}
			}
		}
		return "";
	}

	public @NonNull Collection<EObject> xmlElement2ElementContainmentTargetFinderExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Element) {
			if (context.eContainer() instanceof Element) {
				candidates.add(context.eContainer());
			}
		}
		return candidates;
	}

	/*	public @NonNull Collection<EObject> xmlElement2ElementReference1TargetFinderExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Element) {
			Element element = (Element)context;
			for (Node child : element.getChildren()) {
				if (child instanceof ClassAttribute) {
					List<EObject> eObjects = ((ClassAttribute)child).getEObjects();
					if (eObjects != null) {
						EReference eReference = ((ClassAttribute)child).getEcoreReference();
						EReference eOpposite = eReference.getEOpposite();
						if (eOpposite == null) {
							//	for (EObject eObject : eObjects) {
							//		if (eObject instanceof Element) {
							//			candidates.add(eObject);
							//		}
							//	}
							candidates.add(child);		// FIXME a distinct pseudo-object per eObject
						}
					}
				}
			}
		}
		return candidates;
	} */

	/*	public @NonNull Collection<EObject> xmlElement2ElementReference2TargetFinderExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Element) {
			Element element = (Element)context;
			for (Node child : element.getChildren()) {
				if (child instanceof ClassAttribute) {
					List<EObject> eObjects = ((ClassAttribute)child).getEObjects();
					if (eObjects != null) {
						EReference eReference = ((ClassAttribute)child).getEcoreReference();
						EReference eOpposite = eReference.getEOpposite();
						if ((eOpposite != null) && (System.identityHashCode(eReference) < System.identityHashCode(eOpposite))) {
							//	for (EObject eObject : eObjects) {
							//		if (eObject instanceof Element) {
							//			candidates.add(eObject);
							//		}
							//	}
							candidates.add(child);		// FIXME a distinct pseudo-object per eObject
						}
					}
				}
			}
		}
		return candidates;
	} */

	public @NonNull Collection<EObject> xmlElement2ElementReference1SemanticCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Document) {
			List<Element> elements = new ArrayList<>();
			gatherElements((Document) context, elements);
			for (Element element : elements) {
				for (Node child : element.getChildren()) {
					if (child instanceof ClassAttribute) {
						List<EObject> eObjects = ((ClassAttribute)child).getEObjects();
						if (eObjects != null) {
							EReference eReference = ((ClassAttribute)child).getEcoreReference();
							if (eReference != null) {
								EReference eOpposite = eReference.getEOpposite();
								if (eOpposite == null) {
									//	for (EObject eObject : eObjects) {
									//		if (eObject instanceof Element) {
									//			candidates.add(eObject);
									//		}
									//	}
									candidates.add(child);		// FIXME a distinct pseudo-object per eObject
								}
							}
						}
					}
				}
			}
		}
		return candidates;
	}

	public @NonNull Collection<EObject> xmlElement2ElementReference2SemanticCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof Document) {
			List<Element> elements = new ArrayList<>();
			gatherElements((Document) context, elements);
			for (Element element : elements) {
				for (Node child : element.getChildren()) {
					if (child instanceof ClassAttribute) {
						List<EObject> eObjects = ((ClassAttribute)child).getEObjects();
						if (eObjects != null) {
							EReference eReference = ((ClassAttribute)child).getEcoreReference();
							if (eReference != null) {
								EReference eOpposite = eReference.getEOpposite();
								if ((eOpposite != null) && (System.identityHashCode(eReference) < System.identityHashCode(eOpposite))) {
									//	for (EObject eObject : eObjects) {
									//		if (eObject instanceof Element) {
									//			candidates.add(eObject);
									//		}
									//	}
									candidates.add(child);		// FIXME a distinct pseudo-object per eObject
								}
							}
						}
					}
				}
			}
		}
		return candidates;
	}

	/*	public @NonNull String xmlElement2ElementEndLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			EObject container = context.eContainer();
			if (container instanceof ClassElement) {
				ClassElement parent = (ClassElement)container;
				EStructuralFeature eFeature = parent.getEcoreClass().getEStructuralFeature(element.getQName());
				if (eFeature instanceof EReference) {
					EReference eReference = (EReference)eFeature;
					EReference eOpposite = eReference.getEOpposite();
					if (eOpposite != null) {
						return eOpposite.getName();
					}
				}
			}
			return "";
		}
		return "«xmlElement2ElementEndLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	/*	public @NonNull String xmlElement2ElementLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			return "e2e_" + String.valueOf(element.getQName());
		}
		return "«xmlElement2ElementLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	/*	public @NonNull String xmlElement2ElementEndLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			EObject container = context.eContainer();
			if (container instanceof ClassElement) {
				ClassElement parent = (ClassElement)container;
				EStructuralFeature eFeature = parent.getEcoreClass().getEStructuralFeature(element.getQName());
				if (eFeature instanceof EReference) {
					EReference eReference = (EReference)eFeature;
					EReference eOpposite = eReference.getEOpposite();
					if (eOpposite != null) {
						return eOpposite.getName();
					}
				}
			}
			return "";
		}
		return "«xmlElement2ElementEndLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	/*	public @NonNull String xmlElement2ElementLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			return "e2e_" + String.valueOf(element.getQName());
		}
		return "«xmlElement2ElementLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	public @NonNull String xmlElement2ElementReferenceBeginLabel(EObject context) {
		if (context instanceof ClassAttribute) {
			EReference eReference = ((ClassAttribute)context).getEcoreReference();
			EReference eOpposite = eReference.getEOpposite();
			if (eOpposite != null) {
				return eOpposite.getName();
			}
		}
		return "";
	}

	public @NonNull String xmlElement2ElementReferenceEndLabel(EObject context) {
		if (context instanceof ClassAttribute) {
			EReference eReference = ((ClassAttribute)context).getEcoreReference();
			return eReference.getName();
		}
		return "";
	}

	public @NonNull EObject xmlElement2ElementReferenceSourceFinderExpression(EObject context) {
		return context.eContainer();
	}

	public @NonNull EObject xmlElement2ElementReferenceTargetFinderExpression(EObject context) {
		return ((ClassAttribute)context).getEObjects().get(0);
	}



	/*	public @NonNull String xmlElement2ElementEndLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			EObject container = context.eContainer();
			if (container instanceof ClassElement) {
				ClassElement parent = (ClassElement)container;
				EStructuralFeature eFeature = parent.getEcoreClass().getEStructuralFeature(element.getQName());
				if (eFeature instanceof EReference) {
					EReference eReference = (EReference)eFeature;
					EReference eOpposite = eReference.getEOpposite();
					if (eOpposite != null) {
						return eOpposite.getName();
					}
				}
			}
			return "";
		}
		return "«xmlElement2ElementEndLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	/*	public @NonNull String xmlElement2ElementLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			return "e2e_" + String.valueOf(element.getQName());
		}
		return "«xmlElement2ElementLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	} */

	public @NonNull String xmlElementLabel(EObject context) {
		if (context instanceof Element) {
			Element element = (Element)context;
			String xsiType = getXsiType(element);
			if (xsiType != null) {
				return xsiType;
			}
			EClassifier eClassifier = element.getEcoreClassifier();
			if (eClassifier != null) {
				return getEPackagePrefix(context, eClassifier.getEPackage()) + ":" + eClassifier.getName();
			}
			return String.valueOf(element.getQName());
		}
		return "«xmlElementLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	}

	public @NonNull Collection<? extends EObject> xmlElementSemanticsCandidatesExpression(EObject context) {
		List<Element> candidates = new ArrayList<>();
		if (context instanceof Document) {
			Document document = (Document)context;
			gatherElements(document, candidates);
		}
		return candidates;
	}
}
