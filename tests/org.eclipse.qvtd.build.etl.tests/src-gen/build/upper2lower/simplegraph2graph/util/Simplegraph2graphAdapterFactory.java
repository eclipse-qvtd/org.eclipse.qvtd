/**
 */
package build.upper2lower.simplegraph2graph.util;

import build.upper2lower.simplegraph2graph.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage
 * @generated
 */
public class Simplegraph2graphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Simplegraph2graphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simplegraph2graphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Simplegraph2graphPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Simplegraph2graphSwitch<@Nullable Adapter> modelSwitch =
		new Simplegraph2graphSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseGraph2Graph(Graph2Graph object) {
				return createGraph2GraphAdapter();
			}
			@Override
			public Adapter caseElement2Element(Element2Element object) {
				return createElement2ElementAdapter();
			}
			@Override
			public Adapter caseEdge2Edge(Edge2Edge object) {
				return createEdge2EdgeAdapter();
			}
			@Override
			public Adapter caseNode2Node(Node2Node object) {
				return createNode2NodeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link build.upper2lower.simplegraph2graph.Graph2Graph <em>Graph2 Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see build.upper2lower.simplegraph2graph.Graph2Graph
	 * @generated
	 */
	public Adapter createGraph2GraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link build.upper2lower.simplegraph2graph.Element2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see build.upper2lower.simplegraph2graph.Element2Element
	 * @generated
	 */
	public Adapter createElement2ElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link build.upper2lower.simplegraph2graph.Edge2Edge <em>Edge2 Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see build.upper2lower.simplegraph2graph.Edge2Edge
	 * @generated
	 */
	public Adapter createEdge2EdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link build.upper2lower.simplegraph2graph.Node2Node <em>Node2 Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see build.upper2lower.simplegraph2graph.Node2Node
	 * @generated
	 */
	public Adapter createNode2NodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Simplegraph2graphAdapterFactory
