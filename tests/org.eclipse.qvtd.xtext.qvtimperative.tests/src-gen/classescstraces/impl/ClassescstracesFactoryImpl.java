/**
 */
package classescstraces.impl;

import classescstraces.*;

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
public class ClassescstracesFactoryImpl extends EFactoryImpl implements ClassescstracesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassescstracesFactory init() {
		try {
			ClassescstracesFactory theClassescstracesFactory = (ClassescstracesFactory)EPackage.Registry.INSTANCE.getEFactory(ClassescstracesPackage.eNS_URI);
			if (theClassescstracesFactory != null) {
				return theClassescstracesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassescstracesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassescstracesFactoryImpl() {
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
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE: return createPackageCS2Package();
			case ClassescstracesPackage.CLASS_CS2_CLASS: return createClassCS2Class();
			case ClassescstracesPackage.ROOT_CS2_ROOT: return createRootCS2Root();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS2Package createPackageCS2Package() {
		PackageCS2PackageImpl packageCS2Package = new PackageCS2PackageImpl();
		return packageCS2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS2Class createClassCS2Class() {
		ClassCS2ClassImpl classCS2Class = new ClassCS2ClassImpl();
		return classCS2Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootCS2Root createRootCS2Root() {
		RootCS2RootImpl rootCS2Root = new RootCS2RootImpl();
		return rootCS2Root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassescstracesPackage getClassescstracesPackage() {
		return (ClassescstracesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassescstracesPackage getPackage() {
		return ClassescstracesPackage.eINSTANCE;
	}

} //ClassescstracesFactoryImpl
