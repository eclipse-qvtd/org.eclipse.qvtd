/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.build.etl.qvtscheduling.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage
 * @generated
 */
public class QvtSchedulingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QvtSchedulingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtSchedulingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QvtSchedulingPackage.eINSTANCE;
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
	protected QvtSchedulingSwitch<Adapter> modelSwitch =
		new QvtSchedulingSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractDatum(AbstractDatum object) {
				return createAbstractDatumAdapter();
			}
			@Override
			public Adapter caseAbstractAction(AbstractAction object) {
				return createAbstractActionAdapter();
			}
			@Override
			public Adapter caseClassDatum(ClassDatum object) {
				return createClassDatumAdapter();
			}
			@Override
			public Adapter caseDataTypeDatum(DataTypeDatum object) {
				return createDataTypeDatumAdapter();
			}
			@Override
			public Adapter caseDistinctData(DistinctData object) {
				return createDistinctDataAdapter();
			}
			@Override
			public Adapter caseInputAction(InputAction object) {
				return createInputActionAdapter();
			}
			@Override
			public Adapter caseMappingAction(MappingAction object) {
				return createMappingActionAdapter();
			}
			@Override
			public Adapter caseMappingBinding(MappingBinding object) {
				return createMappingBindingAdapter();
			}
			@Override
			public Adapter caseOutputAction(OutputAction object) {
				return createOutputActionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum
	 * @generated
	 */
	public Adapter createAbstractDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction
	 * @generated
	 */
	public Adapter createAbstractActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum
	 * @generated
	 */
	public Adapter createClassDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DataTypeDatum <em>Data Type Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DataTypeDatum
	 * @generated
	 */
	public Adapter createDataTypeDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData <em>Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData
	 * @generated
	 */
	public Adapter createDistinctDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.InputAction <em>Input Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.InputAction
	 * @generated
	 */
	public Adapter createInputActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction
	 * @generated
	 */
	public Adapter createMappingActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding <em>Mapping Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding
	 * @generated
	 */
	public Adapter createMappingBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.OutputAction <em>Output Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.OutputAction
	 * @generated
	 */
	public Adapter createOutputActionAdapter() {
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

} //QvtSchedulingAdapterFactory
