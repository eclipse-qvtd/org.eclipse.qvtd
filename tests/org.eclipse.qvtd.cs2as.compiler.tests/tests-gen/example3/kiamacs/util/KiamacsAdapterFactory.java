/**
 */
package example3.kiamacs.util;

import example3.kiamacs.*;

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
 * @see example3.kiamacs.KiamacsPackage
 * @generated
 */
public class KiamacsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KiamacsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KiamacsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = KiamacsPackage.eINSTANCE;
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
	protected KiamacsSwitch<@Nullable Adapter> modelSwitch =
		new KiamacsSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseTopCS(TopCS object) {
				return createTopCSAdapter();
			}
			@Override
			public Adapter caseNodeCS(NodeCS object) {
				return createNodeCSAdapter();
			}
			@Override
			public Adapter casePlusCS(PlusCS object) {
				return createPlusCSAdapter();
			}
			@Override
			public Adapter caseNumCS(NumCS object) {
				return createNumCSAdapter();
			}
			@Override
			public Adapter caseBaseCS(BaseCS object) {
				return createBaseCSAdapter();
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
	 * Creates a new adapter for an object of class '{@link example3.kiamacs.TopCS <em>Top CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example3.kiamacs.TopCS
	 * @generated
	 */
	public Adapter createTopCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example3.kiamacs.NodeCS <em>Node CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example3.kiamacs.NodeCS
	 * @generated
	 */
	public Adapter createNodeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example3.kiamacs.PlusCS <em>Plus CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example3.kiamacs.PlusCS
	 * @generated
	 */
	public Adapter createPlusCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example3.kiamacs.NumCS <em>Num CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example3.kiamacs.NumCS
	 * @generated
	 */
	public Adapter createNumCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example3.kiamacs.BaseCS <em>Base CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example3.kiamacs.BaseCS
	 * @generated
	 */
	public Adapter createBaseCSAdapter() {
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

} //KiamacsAdapterFactory
