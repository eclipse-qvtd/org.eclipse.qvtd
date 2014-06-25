/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.build.etl.qvtscheduling.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtSchedulingFactoryImpl extends EFactoryImpl implements QvtSchedulingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QvtSchedulingFactory init() {
		try {
			QvtSchedulingFactory theQvtSchedulingFactory = (QvtSchedulingFactory)EPackage.Registry.INSTANCE.getEFactory(QvtSchedulingPackage.eNS_URI);
			if (theQvtSchedulingFactory != null) {
				return theQvtSchedulingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QvtSchedulingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtSchedulingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QvtSchedulingPackage.ABSTRACT_DATUM: return createAbstractDatum();
			case QvtSchedulingPackage.ABSTRACT_ACTION: return createAbstractAction();
			case QvtSchedulingPackage.CLASS_DATUM: return createClassDatum();
			case QvtSchedulingPackage.DATA_TYPE_DATUM: return createDataTypeDatum();
			case QvtSchedulingPackage.DISTINCT_DATA: return createDistinctData();
			case QvtSchedulingPackage.INPUT_ACTION: return createInputAction();
			case QvtSchedulingPackage.MAPPING_ACTION: return createMappingAction();
			case QvtSchedulingPackage.MAPPING_BINDING: return createMappingBinding();
			case QvtSchedulingPackage.OUTPUT_ACTION: return createOutputAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDatum createAbstractDatum() {
		AbstractDatumImpl abstractDatum = new AbstractDatumImpl();
		return abstractDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction createAbstractAction() {
		AbstractActionImpl abstractAction = new AbstractActionImpl();
		return abstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDatum createClassDatum() {
		ClassDatumImpl classDatum = new ClassDatumImpl();
		return classDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDatum createDataTypeDatum() {
		DataTypeDatumImpl dataTypeDatum = new DataTypeDatumImpl();
		return dataTypeDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctData createDistinctData() {
		DistinctDataImpl distinctData = new DistinctDataImpl();
		return distinctData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputAction createInputAction() {
		InputActionImpl inputAction = new InputActionImpl();
		return inputAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingAction createMappingAction() {
		MappingActionImpl mappingAction = new MappingActionImpl();
		return mappingAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBinding createMappingBinding() {
		MappingBindingImpl mappingBinding = new MappingBindingImpl();
		return mappingBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputAction createOutputAction() {
		OutputActionImpl outputAction = new OutputActionImpl();
		return outputAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtSchedulingPackage getQvtSchedulingPackage() {
		return (QvtSchedulingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QvtSchedulingPackage getPackage() {
		return QvtSchedulingPackage.eINSTANCE;
	}

} //QvtSchedulingFactoryImpl
