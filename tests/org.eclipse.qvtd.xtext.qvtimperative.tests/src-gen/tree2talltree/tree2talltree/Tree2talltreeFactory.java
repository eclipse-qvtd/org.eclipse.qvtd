/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package tree2talltree.tree2talltree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tree2talltree.tree2talltree.Tree2talltreePackage
 * @generated
 */
public interface Tree2talltreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Tree2talltreeFactory eINSTANCE = tree2talltree.tree2talltree.impl.Tree2talltreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Node2 Tall Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node2 Tall Node</em>'.
	 * @generated
	 */
	Node2TallNode createNode2TallNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Tree2talltreePackage getTree2talltreePackage();

} //Tree2talltreeFactory
