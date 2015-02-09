/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.build.qvtschedule.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTscheduleFactoryImpl extends EFactoryImpl implements QVTscheduleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTscheduleFactory init() {
		try {
			QVTscheduleFactory theQVTscheduleFactory = (QVTscheduleFactory)EPackage.Registry.INSTANCE.getEFactory(QVTschedulePackage.eNS_URI);
			if (theQVTscheduleFactory != null) {
				return theQVTscheduleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTscheduleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTscheduleFactoryImpl() {
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
			case QVTschedulePackage.CLASS_DATUM: return createClassDatum();
			case QVTschedulePackage.DATA_PARAMETER: return createDataParameter();
			case QVTschedulePackage.INPUT_ACTION: return createInputAction();
			case QVTschedulePackage.MAPPING_ACTION: return createMappingAction();
			case QVTschedulePackage.OUTPUT_ACTION: return createOutputAction();
			case QVTschedulePackage.PARAMETER_DERIVATION: return createParameterDerivation();
			case QVTschedulePackage.PROPERTY_DATUM: return createPropertyDatum();
			case QVTschedulePackage.SCHEDULE: return createSchedule();
			case QVTschedulePackage.SECONDARY_PARAMETER: return createSecondaryParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public DataParameter createDataParameter() {
		DataParameterImpl dataParameter = new DataParameterImpl();
		return dataParameter;
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
	public OutputAction createOutputAction() {
		OutputActionImpl outputAction = new OutputActionImpl();
		return outputAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDerivation createParameterDerivation() {
		ParameterDerivationImpl parameterDerivation = new ParameterDerivationImpl();
		return parameterDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyDatum createPropertyDatum() {
		PropertyDatumImpl propertyDatum = new PropertyDatumImpl();
		return propertyDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedule createSchedule() {
		ScheduleImpl schedule = new ScheduleImpl();
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondaryParameter createSecondaryParameter() {
		SecondaryParameterImpl secondaryParameter = new SecondaryParameterImpl();
		return secondaryParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTschedulePackage getQVTschedulePackage() {
		return (QVTschedulePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTschedulePackage getPackage() {
		return QVTschedulePackage.eINSTANCE;
	}

} //QVTscheduleFactoryImpl
