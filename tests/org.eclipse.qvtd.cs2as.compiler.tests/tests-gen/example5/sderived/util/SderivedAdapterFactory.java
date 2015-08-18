/**
 */
package example5.sderived.util;

import example5.sbase.SElement;
import example5.sbase.X;
import example5.sbase.Y;

import example5.sderived.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see example5.sderived.SderivedPackage
 * @generated
 */
public class SderivedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SderivedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SderivedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SderivedPackage.eINSTANCE;
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
	protected SderivedSwitch<Adapter> modelSwitch =
		new SderivedSwitch<Adapter>() {
			@Override
			public Adapter caseX2(X2 object) {
				return createX2Adapter();
			}
			@Override
			public Adapter caseY2(Y2 object) {
				return createY2Adapter();
			}
			@Override
			public Adapter caseW(W object) {
				return createWAdapter();
			}
			@Override
			public Adapter caseSElement(SElement object) {
				return createSElementAdapter();
			}
			@Override
			public Adapter caseX(X object) {
				return createXAdapter();
			}
			@Override
			public Adapter caseY(Y object) {
				return createYAdapter();
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
	 * Creates a new adapter for an object of class '{@link example5.sderived.X2 <em>X2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example5.sderived.X2
	 * @generated
	 */
	public Adapter createX2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example5.sderived.Y2 <em>Y2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example5.sderived.Y2
	 * @generated
	 */
	public Adapter createY2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example5.sderived.W <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example5.sderived.W
	 * @generated
	 */
	public Adapter createWAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example5.sbase.SElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example5.sbase.SElement
	 * @generated
	 */
	public Adapter createSElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example5.sbase.X <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example5.sbase.X
	 * @generated
	 */
	public Adapter createXAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example5.sbase.Y <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example5.sbase.Y
	 * @generated
	 */
	public Adapter createYAdapter() {
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

} //SderivedAdapterFactory
