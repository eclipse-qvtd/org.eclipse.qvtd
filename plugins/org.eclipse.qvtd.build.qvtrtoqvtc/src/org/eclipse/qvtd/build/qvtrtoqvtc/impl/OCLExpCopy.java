package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ConnectionPointReference;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.DynamicBehavior;
import org.eclipse.ocl.examples.pivot.DynamicElement;
import org.eclipse.ocl.examples.pivot.DynamicProperty;
import org.eclipse.ocl.examples.pivot.DynamicType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.FinalState;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.MessageType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.NumericLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OperationTemplateParameter;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PackageableElement;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.Signal;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateParameterType;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Trigger;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.util.PivotSwitch;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;

/**
 * A set of operations to correctly copy an OCLExp
 * @generated
 */
public class OCLExpCopy extends PivotSwitch<Element> {

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
    public Element caseConstructorExp(ConstructorExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseConstructorPart(ConstructorPart in) {
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
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        EnumerationLiteral _referredEnumLiteral = in.getReferredEnumLiteral();
        if (_referredEnumLiteral != null)
            out.setReferredEnumLiteral((EnumerationLiteral) doSwitch(_referredEnumLiteral));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
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
    public Element caseNullLiteralExp(NullLiteralExp in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseOpaqueExpression(OpaqueExpression in) {
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
    public Element caseOperationTemplateParameter(OperationTemplateParameter in) {
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
    public Element caseRoot(Root in) {
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
    public Element caseTemplateParameterType(TemplateParameterType in) {
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
    public Element caseTypeExtension(TypeExtension in) {
	    throw new UnsupportedOperationException("Not implememnted yet");
    }
    
    /**
     * @generated
     */
    @Override 
    public Element caseTypeTemplateParameter(TypeTemplateParameter in) {
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
    public Element caseUnspecifiedType(UnspecifiedType in) {
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
        out.setIsStatic(in.isStatic());
        out.setName(in.getName());
        out.setIsRequired(in.isRequired());
        out.setImplicit(in.isImplicit());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));            
        Variable v = (Variable) in.getReferredVariable();
        assert v != null;
        out.setReferredVariable(transformation.getVariableTrace(v));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
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

