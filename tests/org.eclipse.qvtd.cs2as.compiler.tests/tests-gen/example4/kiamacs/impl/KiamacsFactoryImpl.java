/**
 */
package example4.kiamacs.impl;

import example4.kiamacs.*;

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
			case KiamacsPackage.COMPOSITE_CS: return createCompositeCS();
			case KiamacsPackage.LEAF_CS: return createLeafCS();
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
	public CompositeCS createCompositeCS() {
		CompositeCSImpl compositeCS = new CompositeCSImpl();
		return compositeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeafCS createLeafCS() {
		LeafCSImpl leafCS = new LeafCSImpl();
		return leafCS;
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
