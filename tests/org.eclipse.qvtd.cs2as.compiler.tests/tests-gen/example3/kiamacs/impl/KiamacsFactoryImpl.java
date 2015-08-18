/**
 */
package example3.kiamacs.impl;

import example3.kiamacs.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KiamacsFactoryImpl extends EFactoryImpl implements KiamacsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KiamacsFactory init() {
		try {
			KiamacsFactory theKiamacsFactory = (KiamacsFactory)EPackage.Registry.INSTANCE.getEFactory(KiamacsPackage.eNS_URI);
			if (theKiamacsFactory != null) {
				return theKiamacsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KiamacsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KiamacsFactoryImpl() {
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
			case KiamacsPackage.TOP_CS: return createTopCS();
			case KiamacsPackage.PLUS_CS: return createPlusCS();
			case KiamacsPackage.NUM_CS: return createNumCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopCS createTopCS() {
		TopCSImpl topCS = new TopCSImpl();
		return topCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlusCS createPlusCS() {
		PlusCSImpl plusCS = new PlusCSImpl();
		return plusCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumCS createNumCS() {
		NumCSImpl numCS = new NumCSImpl();
		return numCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KiamacsPackage getKiamacsPackage() {
		return (KiamacsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KiamacsPackage getPackage() {
		return KiamacsPackage.eINSTANCE;
	}

} //KiamacsFactoryImpl
