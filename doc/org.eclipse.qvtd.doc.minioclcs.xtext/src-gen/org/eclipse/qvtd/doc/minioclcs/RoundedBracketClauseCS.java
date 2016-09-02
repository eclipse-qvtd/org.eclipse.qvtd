/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rounded Bracket Clause CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.RoundedBracketClauseCS#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getRoundedBracketClauseCS()
 * @model
 * @generated
 */
public interface RoundedBracketClauseCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.minioclcs.ExpCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getRoundedBracketClauseCS_Args()
	 * @model containment="true"
	 * @generated
	 */
  EList<ExpCS> getArgs();

} // RoundedBracketClauseCS