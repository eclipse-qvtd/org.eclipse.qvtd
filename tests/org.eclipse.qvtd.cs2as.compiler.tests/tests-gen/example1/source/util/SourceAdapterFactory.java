/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.source.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import example1.source.PathElementCS;
import example1.source.PathNameCS;
import example1.source.SElement;
import example1.source.SRoot;
import example1.source.SourcePackage;
import example1.source.X;
import example1.source.Y;
import example1.source.Y1;
import example1.source.Y2;
import example1.source.Z;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see example1.source.SourcePackage
 * @generated
 */
public class SourceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SourcePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SourcePackage.eINSTANCE;
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
	protected SourceSwitch<@Nullable Adapter> modelSwitch =
		new SourceSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseX(X object) {
				return createXAdapter();
			}
			@Override
			public Adapter caseY(Y object) {
				return createYAdapter();
			}
			@Override
			public Adapter caseY1(Y1 object) {
				return createY1Adapter();
			}
			@Override
			public Adapter caseY2(Y2 object) {
				return createY2Adapter();
			}
			@Override
			public Adapter caseZ(Z object) {
				return createZAdapter();
			}
			@Override
			public Adapter caseSRoot(SRoot object) {
				return createSRootAdapter();
			}
			@Override
			public Adapter caseSElement(SElement object) {
				return createSElementAdapter();
			}
			@Override
			public Adapter casePathNameCS(PathNameCS object) {
				return createPathNameCSAdapter();
			}
			@Override
			public Adapter casePathElementCS(PathElementCS object) {
				return createPathElementCSAdapter();
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
	 * Creates a new adapter for an object of class '{@link example1.source.X <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.X
	 * @generated
	 */
	public Adapter createXAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.Y <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.Y
	 * @generated
	 */
	public Adapter createYAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.Y1 <em>Y1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.Y1
	 * @generated
	 */
	public Adapter createY1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.Y2 <em>Y2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.Y2
	 * @generated
	 */
	public Adapter createY2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.Z <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.Z
	 * @generated
	 */
	public Adapter createZAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.SRoot <em>SRoot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.SRoot
	 * @generated
	 */
	public Adapter createSRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.SElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.SElement
	 * @generated
	 */
	public Adapter createSElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.PathNameCS
	 * @generated
	 */
	public Adapter createPathNameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link example1.source.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see example1.source.PathElementCS
	 * @generated
	 */
	public Adapter createPathElementCSAdapter() {
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

} //SourceAdapterFactory
