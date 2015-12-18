package org.eclipse.qvtd.build.etl.tests.UpperToLower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;

import build.upper2lower.simplegraph.SimplegraphPackage;

/**
 * UpperToLowerNormalizer normalises the results of the UpperToLower transformation.
 * 
 * Even though everything is ordered in the input/output model, the edges/incoming/outgoing lists cn be independently ordered, and only
 * the edges order is preserved in the middle model.
 */
public class UpperToLowerNormalizer implements ModelNormalizer
{
	public static final @NonNull UpperToLowerNormalizer INSTANCE = new UpperToLowerNormalizer();
	
	protected static class ElementComparator implements Comparator<EObject>
	{
		private final @NonNull EClass edgeClass;
		private final @NonNull EReference edgeSource;
		private final @NonNull EReference edgeTarget;
		private final @NonNull EAttribute nodeLabel;

		public ElementComparator(@NonNull EClass edgeClass, @NonNull EReference edgeSource, @NonNull EReference edgeTarget, @NonNull EAttribute nodeLabel) {
			this.edgeClass = edgeClass;
			this.edgeSource = edgeSource;
			this.edgeTarget = edgeTarget;
			this.nodeLabel = nodeLabel;
		}
		
		@Override
		public int compare(EObject o1, EObject o2) {
			String n1;
			String n2;
			if (edgeClass.isInstance(o1)) {
				if (!edgeClass.isInstance(o2)) {
					return 1;
				}
				n1 = (String) ((EObject)o1.eGet(edgeSource)).eGet(nodeLabel);
				n2 = (String) ((EObject)o2.eGet(edgeSource)).eGet(nodeLabel);
				if (ClassUtil.safeEquals(n1, n2)) {
					n1 = (String) ((EObject)o1.eGet(edgeTarget)).eGet(nodeLabel);
					n2 = (String) ((EObject)o2.eGet(edgeTarget)).eGet(nodeLabel);
				}
			}
			else {
				if (edgeClass.isInstance(o2)) {
					return -1;
				}
				n1 = (String) o1.eGet(nodeLabel);
				n2 = (String) o2.eGet(nodeLabel);
			}
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected class GraphNormalizer implements Normalizer
	{
		protected final @NonNull EObject graph;
		protected final @NonNull EReference graphElements;
		protected final @NonNull ElementComparator elementComparator;

		public GraphNormalizer(@NonNull EObject graph, @NonNull EReference graphElements, @NonNull ElementComparator elementComparator) {
			this.graph = graph;
			this.graphElements = graphElements;
			this.elementComparator = elementComparator;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			@SuppressWarnings("unchecked")
			EList<EObject> elements = (EList<EObject>) graph.eGet(graphElements);
			ECollections.sort(elements, elementComparator);
		}
	}
	
	protected class NodeNormalizer implements Normalizer
	{
		protected final @NonNull EObject node;
		protected final @NonNull EReference incoming;
		protected final @NonNull EReference outgoing;
		protected final @NonNull ElementComparator elementComparator;

		public NodeNormalizer(@NonNull EObject node, @NonNull EReference incoming, @NonNull EReference outgoing, @NonNull ElementComparator elementComparator) {
			this.node = node;
			this.incoming = incoming;
			this.outgoing = outgoing;
			this.elementComparator = elementComparator;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			@SuppressWarnings("unchecked")EList<EObject> incomingEdges = (EList<EObject>) node.eGet(incoming);
			ECollections.sort(incomingEdges, elementComparator);
			@SuppressWarnings("unchecked")EList<EObject> outgoingEdges = (EList<EObject>) node.eGet(outgoing);
			ECollections.sort(outgoingEdges, elementComparator);
		}
	}

	public @NonNull List<Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass graphClass = (EClass) ePackage.getEClassifier(SimplegraphPackage.Literals.GRAPH.getName());
		assert graphClass != null;
		EClass elementClass = (EClass) ePackage.getEClassifier(SimplegraphPackage.Literals.ELEMENT.getName());
		assert elementClass != null;
		EClass edgeClass = (EClass) ePackage.getEClassifier(SimplegraphPackage.Literals.EDGE.getName());
		assert edgeClass != null;
		EClass nodeClass = (EClass) ePackage.getEClassifier(SimplegraphPackage.Literals.NODE.getName());
		assert nodeClass != null;
		EReference graphElements = (EReference) graphClass.getEStructuralFeature(SimplegraphPackage.Literals.GRAPH__ELEMENT.getName());
		assert graphElements != null;
		EAttribute nodeLabel = (EAttribute) nodeClass.getEStructuralFeature(SimplegraphPackage.Literals.NODE__LABEL.getName());
		assert nodeLabel != null;
		EReference nodeIncoming = (EReference) nodeClass.getEStructuralFeature(SimplegraphPackage.Literals.NODE__INCOMING.getName());
		assert nodeIncoming != null;
		EReference nodeOutgoing = (EReference) nodeClass.getEStructuralFeature(SimplegraphPackage.Literals.NODE__OUTGOING.getName());
		assert nodeOutgoing != null;
		EReference edgeSource = (EReference) edgeClass.getEStructuralFeature(SimplegraphPackage.Literals.EDGE__SOURCE.getName());
		assert edgeSource != null;
		EReference edgeTarget = (EReference) edgeClass.getEStructuralFeature(SimplegraphPackage.Literals.EDGE__TARGET.getName());
		assert edgeTarget != null;
		ElementComparator elementComparator = new ElementComparator(edgeClass, edgeSource, edgeTarget, nodeLabel);
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			EClass eClass = eObject.eClass();
			if (graphClass.isSuperTypeOf(eClass)) {
				normalizers.add(new GraphNormalizer(eObject, graphElements, elementComparator));
			}
			if (nodeClass.isSuperTypeOf(eClass)) {
				normalizers.add(new NodeNormalizer(eObject, nodeIncoming, nodeOutgoing, elementComparator));
			}
		}
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}