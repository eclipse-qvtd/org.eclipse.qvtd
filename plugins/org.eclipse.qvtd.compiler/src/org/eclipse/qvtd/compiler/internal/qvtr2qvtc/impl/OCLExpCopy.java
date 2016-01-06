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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.AssociationClassCallExp;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallOperationAction;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.ConnectionPointReference;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.DynamicBehavior;
import org.eclipse.ocl.pivot.DynamicElement;
import org.eclipse.ocl.pivot.DynamicProperty;
import org.eclipse.ocl.pivot.DynamicType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.FinalState;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.MessageType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Pseudostate;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.Region;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.SendSignalAction;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Signal;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StateMachine;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.Trigger;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.util.PivotSwitch;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;

/**
 * A set of operations to correctly copy an OCLExp
 * @generated
 */
public class OCLExpCopy extends PivotSwitch<@Nullable Element> {

    @NonNull private QvtrToQvtcTransformation transformation;
    
    public OCLExpCopy(@NonNull QvtrToQvtcTransformation transformation) {
        this.transformation = transformation;
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseAnnotation(Annotation in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseAnyType(AnyType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseAssociationClass(AssociationClass in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseAssociationClassCallExp(AssociationClassCallExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseBagType(BagType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseBooleanLiteralExp(BooleanLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseCallOperationAction(CallOperationAction in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseClass(Class in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseCollectionItem(CollectionItem in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseCollectionLiteralExp(CollectionLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseCollectionRange(CollectionRange in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseCollectionType(CollectionType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseComment(Comment in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseConnectionPointReference(ConnectionPointReference in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseConstraint(Constraint in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseShadowExp(ShadowExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseShadowPart(ShadowPart in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseDataType(DataType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseDetail(Detail in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseDynamicBehavior(DynamicBehavior in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseDynamicElement(DynamicElement in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseDynamicProperty(DynamicProperty in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseDynamicType(DynamicType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseElementExtension(ElementExtension in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseEnumLiteralExp(EnumLiteralExp in) {
	    final EnumLiteralExp out = PivotFactory.eINSTANCE.createEnumLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
//	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isIsRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        EnumerationLiteral _referredEnumLiteral = in.getReferredLiteral();
        if (_referredEnumLiteral != null)
            out.setReferredLiteral((EnumerationLiteral) doSwitch(_referredEnumLiteral));
        for (ElementExtension _extension : in.getOwnedExtensions()) {
            out.getOwnedExtensions().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotations()) {
            out.getOwnedAnnotations().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComments()) {
            out.getOwnedComments().add((Comment) doSwitch(_ownedComment));
        }
	    return out;
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseEnumeration(Enumeration in) {
        return in;
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseEnumerationLiteral(EnumerationLiteral in) {
        return in;
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseExpressionInOCL(ExpressionInOCL in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseFinalState(FinalState in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseIfExp(IfExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseImport(Import in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseIntegerLiteralExp(IntegerLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseInvalidLiteralExp(InvalidLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseInvalidType(InvalidType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseIterateExp(IterateExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseIteration(Iteration in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseIteratorExp(IteratorExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseLambdaType(LambdaType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseLetExp(LetExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseLibrary(Library in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseMessageExp(MessageExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseMessageType(MessageType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseModel(Model in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseNullLiteralExp(NullLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseOperation(Operation in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseOperationCallExp(OperationCallExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseOppositePropertyCallExp(OppositePropertyCallExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseOrderedSetType(OrderedSetType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element casePackage(Package in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseParameter(Parameter in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element casePrecedence(Precedence in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element casePrimitiveType(PrimitiveType in) {
        return in;
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseProfile(Profile in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseProfileApplication(ProfileApplication in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseProperty(Property in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element casePropertyCallExp(PropertyCallExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element casePseudostate(Pseudostate in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseRealLiteralExp(RealLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseRegion(Region in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseSelfType(SelfType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseSendSignalAction(SendSignalAction in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseSequenceType(SequenceType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseSetType(SetType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseSignal(Signal in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseState(State in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseStateExp(StateExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseStateMachine(StateMachine in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseStereotype(Stereotype in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseStereotypeExtender(StereotypeExtender in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseStringLiteralExp(StringLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTemplateBinding(TemplateBinding in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTemplateParameter(TemplateParameter in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTemplateParameterSubstitution(TemplateParameterSubstitution in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTemplateSignature(TemplateSignature in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTransition(Transition in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTrigger(Trigger in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTupleLiteralExp(TupleLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTupleLiteralPart(TupleLiteralPart in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTupleType(TupleType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseType(Type in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTypeExp(TypeExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseUnspecifiedValueExp(UnspecifiedValueExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseVariable(Variable in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseVariableExp(VariableExp in) {
        final VariableExp out = PivotFactory.eINSTANCE.createVariableExp();
        assert out != null;
        transformation.addOrphan(out);
//        out.setIsStatic(in.isStatic());
        out.setName(in.getName());
        out.setIsRequired(in.isIsRequired());
        out.setIsImplicit(in.isIsImplicit());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));            
        Variable v = (Variable) in.getReferredVariable();
        assert v != null;
        out.setReferredVariable(transformation.getVariableTrace(v));
        for (ElementExtension _extension : in.getOwnedExtensions()) {
            out.getOwnedExtensions().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotations()) {
            out.getOwnedAnnotations().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComments()) {
            out.getOwnedComments().add((Comment) doSwitch(_ownedComment));
        }
        return out;
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseVoidType(VoidType in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
}

