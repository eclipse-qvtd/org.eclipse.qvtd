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
	    final Annotation out = PivotFactory.eINSTANCE.createAnnotation();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Element _ownedContent : in.getOwnedContent()) {
            out.getOwnedContent().add((Element) doSwitch(_ownedContent));
        }
        for (Detail _ownedDetail : in.getOwnedDetail()) {
            out.getOwnedDetail().add((Detail) doSwitch(_ownedDetail));
        }
        for (Element _reference : in.getReference()) {
            out.getReference().add((Element) doSwitch(_reference));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseAnyType(AnyType in) {
	    final AnyType out = PivotFactory.eINSTANCE.createAnyType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseAssociationClass(AssociationClass in) {
	    final AssociationClass out = PivotFactory.eINSTANCE.createAssociationClass();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
        for (Property _unownedAttribute : in.getUnownedAttribute()) {
            out.getUnownedAttribute().add((Property) doSwitch(_unownedAttribute));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseAssociationClassCallExp(AssociationClassCallExp in) {
	    final AssociationClassCallExp out = PivotFactory.eINSTANCE.createAssociationClassCallExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _source = in.getSource();
        if (_source != null)
            out.setSource((OCLExpression) doSwitch(_source));
        Property _navigationSource = in.getNavigationSource();
        if (_navigationSource != null)
            out.setNavigationSource((Property) doSwitch(_navigationSource));
        AssociationClass _referredAssociationClass = in.getReferredAssociationClass();
        if (_referredAssociationClass != null)
            out.setReferredAssociationClass((AssociationClass) doSwitch(_referredAssociationClass));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (OCLExpression _qualifier : in.getQualifier()) {
            out.getQualifier().add((OCLExpression) doSwitch(_qualifier));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseBagType(BagType in) {
	    final BagType out = PivotFactory.eINSTANCE.createBagType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        Type _elementType = in.getElementType();
        if (_elementType != null)
            out.setElementType((Type) doSwitch(_elementType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseBooleanLiteralExp(BooleanLiteralExp in) {
	    final BooleanLiteralExp out = PivotFactory.eINSTANCE.createBooleanLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setBooleanSymbol(in.isBooleanSymbol());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseCallOperationAction(CallOperationAction in) {
	    final CallOperationAction out = PivotFactory.eINSTANCE.createCallOperationAction();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        Operation _operation = in.getOperation();
        if (_operation != null)
            out.setOperation((Operation) doSwitch(_operation));
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
    public Element caseClass(Class in) {
	    final Class out = PivotFactory.eINSTANCE.createClass();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseCollectionItem(CollectionItem in) {
	    final CollectionItem out = PivotFactory.eINSTANCE.createCollectionItem();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _item = in.getItem();
        if (_item != null)
            out.setItem((OCLExpression) doSwitch(_item));
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
    public Element caseCollectionLiteralExp(CollectionLiteralExp in) {
	    final CollectionLiteralExp out = PivotFactory.eINSTANCE.createCollectionLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setKind(in.getKind());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (CollectionLiteralPart _part : in.getPart()) {
            out.getPart().add((CollectionLiteralPart) doSwitch(_part));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseCollectionRange(CollectionRange in) {
	    final CollectionRange out = PivotFactory.eINSTANCE.createCollectionRange();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _first = in.getFirst();
        if (_first != null)
            out.setFirst((OCLExpression) doSwitch(_first));
        OCLExpression _last = in.getLast();
        if (_last != null)
            out.setLast((OCLExpression) doSwitch(_last));
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
    public Element caseCollectionType(CollectionType in) {
	    final CollectionType out = PivotFactory.eINSTANCE.createCollectionType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        Type _elementType = in.getElementType();
        if (_elementType != null)
            out.setElementType((Type) doSwitch(_elementType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseComment(Comment in) {
	    final Comment out = PivotFactory.eINSTANCE.createComment();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setBody(in.getBody());
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Element _annotatedElement : in.getAnnotatedElement()) {
            out.getAnnotatedElement().add((Element) doSwitch(_annotatedElement));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseConnectionPointReference(ConnectionPointReference in) {
	    final ConnectionPointReference out = PivotFactory.eINSTANCE.createConnectionPointReference();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        Region _container = in.getContainer();
        if (_container != null)
            out.setContainer((Region) doSwitch(_container));
        State _state = in.getState();
        if (_state != null)
            out.setState((State) doSwitch(_state));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Transition _incoming : in.getIncoming()) {
            out.getIncoming().add((Transition) doSwitch(_incoming));
        }
        for (Transition _outgoing : in.getOutgoing()) {
            out.getOutgoing().add((Transition) doSwitch(_outgoing));
        }
        for (Pseudostate _entry : in.getEntry()) {
            out.getEntry().add((Pseudostate) doSwitch(_entry));
        }
        for (Pseudostate _exit : in.getExit()) {
            out.getExit().add((Pseudostate) doSwitch(_exit));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseConstraint(Constraint in) {
	    final Constraint out = PivotFactory.eINSTANCE.createConstraint();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsCallable(in.isCallable());
        State _owningState = in.getOwningState();
        if (_owningState != null)
            out.setOwningState((State) doSwitch(_owningState));
        OpaqueExpression _specification = in.getSpecification();
        if (_specification != null)
            out.setSpecification((OpaqueExpression) doSwitch(_specification));
        Transition _transition = in.getTransition();
        if (_transition != null)
            out.setTransition((Transition) doSwitch(_transition));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Element _constrainedElement : in.getConstrainedElement()) {
            out.getConstrainedElement().add((Element) doSwitch(_constrainedElement));
        }
        for (Constraint _redefinedConstraint : in.getRedefinedConstraint()) {
            out.getRedefinedConstraint().add((Constraint) doSwitch(_redefinedConstraint));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseConstructorExp(ConstructorExp in) {
	    final ConstructorExp out = PivotFactory.eINSTANCE.createConstructorExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setValue(in.getValue());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (ConstructorPart _part : in.getPart()) {
            out.getPart().add((ConstructorPart) doSwitch(_part));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseConstructorPart(ConstructorPart in) {
	    final ConstructorPart out = PivotFactory.eINSTANCE.createConstructorPart();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _initExpression = in.getInitExpression();
        if (_initExpression != null)
            out.setInitExpression((OCLExpression) doSwitch(_initExpression));
        Property _referredProperty = in.getReferredProperty();
        if (_referredProperty != null)
            out.setReferredProperty((Property) doSwitch(_referredProperty));
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
    public Element caseDataType(DataType in) {
	    final DataType out = PivotFactory.eINSTANCE.createDataType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseDetail(Detail in) {
	    final Detail out = PivotFactory.eINSTANCE.createDetail();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.getValue().addAll(in.getValue());
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
    public Element caseDynamicBehavior(DynamicBehavior in) {
	    final DynamicBehavior out = PivotFactory.eINSTANCE.createDynamicBehavior();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Transition _transition = in.getTransition();
        if (_transition != null)
            out.setTransition((Transition) doSwitch(_transition));
        Type _metaType = in.getMetaType();
        if (_metaType != null)
            out.setMetaType((Type) doSwitch(_metaType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
        for (DynamicProperty _ownedProperty : in.getOwnedProperty()) {
            out.getOwnedProperty().add((DynamicProperty) doSwitch(_ownedProperty));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseDynamicElement(DynamicElement in) {
	    final DynamicElement out = PivotFactory.eINSTANCE.createDynamicElement();
	    assert out != null;
	    transformation.addOrphan(out);
        Type _metaType = in.getMetaType();
        if (_metaType != null)
            out.setMetaType((Type) doSwitch(_metaType));
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
    public Element caseDynamicProperty(DynamicProperty in) {
	    final DynamicProperty out = PivotFactory.eINSTANCE.createDynamicProperty();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setDefault(in.getDefault());
        Property _referredProperty = in.getReferredProperty();
        if (_referredProperty != null)
            out.setReferredProperty((Property) doSwitch(_referredProperty));
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
    public Element caseDynamicType(DynamicType in) {
	    final DynamicType out = PivotFactory.eINSTANCE.createDynamicType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _metaType = in.getMetaType();
        if (_metaType != null)
            out.setMetaType((Type) doSwitch(_metaType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (DynamicProperty _ownedProperty : in.getOwnedProperty()) {
            out.getOwnedProperty().add((DynamicProperty) doSwitch(_ownedProperty));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseElementExtension(ElementExtension in) {
	    final ElementExtension out = PivotFactory.eINSTANCE.createElementExtension();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsApplied(in.isApplied());
	    out.setIsRequired(in.isRequired());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Element _base = in.getBase();
        if (_base != null)
            out.setBase((Element) doSwitch(_base));
        Stereotype _stereotype = in.getStereotype();
        if (_stereotype != null)
            out.setStereotype((Stereotype) doSwitch(_stereotype));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
	    return out;    
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
	    final Enumeration out = PivotFactory.eINSTANCE.createEnumeration();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
        for (EnumerationLiteral _ownedLiteral : in.getOwnedLiteral()) {
            out.getOwnedLiteral().add((EnumerationLiteral) doSwitch(_ownedLiteral));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseEnumerationLiteral(EnumerationLiteral in) {
	    final EnumerationLiteral out = PivotFactory.eINSTANCE.createEnumerationLiteral();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setValue(in.getValue());
        Enumeration _enumeration = in.getEnumeration();
        if (_enumeration != null)
            out.setEnumeration((Enumeration) doSwitch(_enumeration));
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
    public Element caseExpressionInOCL(ExpressionInOCL in) {
	    final ExpressionInOCL out = PivotFactory.eINSTANCE.createExpressionInOCL();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        ExpressionInOCL _ownedExpressionInOCL = in.getOwnedExpressionInOCL();
        if (_ownedExpressionInOCL != null)
            out.setOwnedExpressionInOCL((ExpressionInOCL) doSwitch(_ownedExpressionInOCL));
        OCLExpression _bodyExpression = in.getBodyExpression();
        if (_bodyExpression != null)
            out.setBodyExpression((OCLExpression) doSwitch(_bodyExpression));
        Variable _contextVariable = in.getContextVariable();
        if (_contextVariable != null)
            out.setContextVariable((Variable) doSwitch(_contextVariable));
        Variable _resultVariable = in.getResultVariable();
        if (_resultVariable != null)
            out.setResultVariable((Variable) doSwitch(_resultVariable));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Variable _parameterVariable : in.getParameterVariable()) {
            out.getParameterVariable().add((Variable) doSwitch(_parameterVariable));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseFinalState(FinalState in) {
	    final FinalState out = PivotFactory.eINSTANCE.createFinalState();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsSubmachineState(in.isSubmachineState());
        Region _container = in.getContainer();
        if (_container != null)
            out.setContainer((Region) doSwitch(_container));
        Behavior _doActivity = in.getDoActivity();
        if (_doActivity != null)
            out.setDoActivity((Behavior) doSwitch(_doActivity));
        Behavior _entry = in.getEntry();
        if (_entry != null)
            out.setEntry((Behavior) doSwitch(_entry));
        Behavior _exit = in.getExit();
        if (_exit != null)
            out.setExit((Behavior) doSwitch(_exit));
        State _redefinedState = in.getRedefinedState();
        if (_redefinedState != null)
            out.setRedefinedState((State) doSwitch(_redefinedState));
        Constraint _stateInvariant = in.getStateInvariant();
        if (_stateInvariant != null)
            out.setStateInvariant((Constraint) doSwitch(_stateInvariant));
        StateMachine _submachine = in.getSubmachine();
        if (_submachine != null)
            out.setSubmachine((StateMachine) doSwitch(_submachine));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Transition _incoming : in.getIncoming()) {
            out.getIncoming().add((Transition) doSwitch(_incoming));
        }
        for (Transition _outgoing : in.getOutgoing()) {
            out.getOutgoing().add((Transition) doSwitch(_outgoing));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (ConnectionPointReference _connection : in.getConnection()) {
            out.getConnection().add((ConnectionPointReference) doSwitch(_connection));
        }
        for (Pseudostate _connectionPoint : in.getConnectionPoint()) {
            out.getConnectionPoint().add((Pseudostate) doSwitch(_connectionPoint));
        }
        for (Trigger _deferrableTrigger : in.getDeferrableTrigger()) {
            out.getDeferrableTrigger().add((Trigger) doSwitch(_deferrableTrigger));
        }
        for (Region _region : in.getRegion()) {
            out.getRegion().add((Region) doSwitch(_region));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseIfExp(IfExp in) {
	    final IfExp out = PivotFactory.eINSTANCE.createIfExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _condition = in.getCondition();
        if (_condition != null)
            out.setCondition((OCLExpression) doSwitch(_condition));
        OCLExpression _elseExpression = in.getElseExpression();
        if (_elseExpression != null)
            out.setElseExpression((OCLExpression) doSwitch(_elseExpression));
        OCLExpression _thenExpression = in.getThenExpression();
        if (_thenExpression != null)
            out.setThenExpression((OCLExpression) doSwitch(_thenExpression));
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
    public Element caseImport(Import in) {
	    final Import out = PivotFactory.eINSTANCE.createImport();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        Namespace _importedNamespace = in.getImportedNamespace();
        if (_importedNamespace != null)
            out.setImportedNamespace((Namespace) doSwitch(_importedNamespace));
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
    public Element caseIntegerLiteralExp(IntegerLiteralExp in) {
	    final IntegerLiteralExp out = PivotFactory.eINSTANCE.createIntegerLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setIntegerSymbol(in.getIntegerSymbol());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseInvalidLiteralExp(InvalidLiteralExp in) {
	    final InvalidLiteralExp out = PivotFactory.eINSTANCE.createInvalidLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseInvalidType(InvalidType in) {
	    final InvalidType out = PivotFactory.eINSTANCE.createInvalidType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseIterateExp(IterateExp in) {
	    final IterateExp out = PivotFactory.eINSTANCE.createIterateExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _source = in.getSource();
        if (_source != null)
            out.setSource((OCLExpression) doSwitch(_source));
        OCLExpression _body = in.getBody();
        if (_body != null)
            out.setBody((OCLExpression) doSwitch(_body));
        Iteration _referredIteration = in.getReferredIteration();
        if (_referredIteration != null)
            out.setReferredIteration((Iteration) doSwitch(_referredIteration));
        Variable _result = in.getResult();
        if (_result != null)
            out.setResult((Variable) doSwitch(_result));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Variable _iterator : in.getIterator()) {
            out.getIterator().add((Variable) doSwitch(_iterator));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseIteration(Iteration in) {
	    final Iteration out = PivotFactory.eINSTANCE.createIteration();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplementation(in.getImplementation());
	    out.setImplementationClass(in.getImplementationClass());
	    out.setIsInvalidating(in.isInvalidating());
	    out.setIsValidating(in.isValidating());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        OpaqueExpression _bodyExpression = in.getBodyExpression();
        if (_bodyExpression != null)
            out.setBodyExpression((OpaqueExpression) doSwitch(_bodyExpression));
        Type _owningType = in.getOwningType();
        if (_owningType != null)
            out.setOwningType((Type) doSwitch(_owningType));
        Precedence _precedence = in.getPrecedence();
        if (_precedence != null)
            out.setPrecedence((Precedence) doSwitch(_precedence));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (Parameter _ownedParameter : in.getOwnedParameter()) {
            out.getOwnedParameter().add((Parameter) doSwitch(_ownedParameter));
        }
        for (Constraint _postcondition : in.getPostcondition()) {
            out.getPostcondition().add((Constraint) doSwitch(_postcondition));
        }
        for (Constraint _precondition : in.getPrecondition()) {
            out.getPrecondition().add((Constraint) doSwitch(_precondition));
        }
        for (Type _raisedException : in.getRaisedException()) {
            out.getRaisedException().add((Type) doSwitch(_raisedException));
        }
        for (Operation _redefinedOperation : in.getRedefinedOperation()) {
            out.getRedefinedOperation().add((Operation) doSwitch(_redefinedOperation));
        }
        for (Parameter _ownedAccumulator : in.getOwnedAccumulator()) {
            out.getOwnedAccumulator().add((Parameter) doSwitch(_ownedAccumulator));
        }
        for (Parameter _ownedIterator : in.getOwnedIterator()) {
            out.getOwnedIterator().add((Parameter) doSwitch(_ownedIterator));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseIteratorExp(IteratorExp in) {
	    final IteratorExp out = PivotFactory.eINSTANCE.createIteratorExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _source = in.getSource();
        if (_source != null)
            out.setSource((OCLExpression) doSwitch(_source));
        OCLExpression _body = in.getBody();
        if (_body != null)
            out.setBody((OCLExpression) doSwitch(_body));
        Iteration _referredIteration = in.getReferredIteration();
        if (_referredIteration != null)
            out.setReferredIteration((Iteration) doSwitch(_referredIteration));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Variable _iterator : in.getIterator()) {
            out.getIterator().add((Variable) doSwitch(_iterator));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseLambdaType(LambdaType in) {
	    final LambdaType out = PivotFactory.eINSTANCE.createLambdaType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        Type _contextType = in.getContextType();
        if (_contextType != null)
            out.setContextType((Type) doSwitch(_contextType));
        Type _resultType = in.getResultType();
        if (_resultType != null)
            out.setResultType((Type) doSwitch(_resultType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
        for (Type _parameterType : in.getParameterType()) {
            out.getParameterType().add((Type) doSwitch(_parameterType));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseLetExp(LetExp in) {
	    final LetExp out = PivotFactory.eINSTANCE.createLetExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _in = in.getIn();
        if (_in != null)
            out.setIn((OCLExpression) doSwitch(_in));
        Variable _variable = in.getVariable();
        if (_variable != null)
            out.setVariable((Variable) doSwitch(_variable));
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
    public Element caseLibrary(Library in) {
	    final Library out = PivotFactory.eINSTANCE.createLibrary();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setNsPrefix(in.getNsPrefix());
	    out.setNsURI(in.getNsURI());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        Package _nestingPackage = in.getNestingPackage();
        if (_nestingPackage != null)
            out.setNestingPackage((Package) doSwitch(_nestingPackage));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (Package _importedPackage : in.getImportedPackage()) {
            out.getImportedPackage().add((Package) doSwitch(_importedPackage));
        }
        for (Package _nestedPackage : in.getNestedPackage()) {
            out.getNestedPackage().add((Package) doSwitch(_nestedPackage));
        }
        for (Type _ownedType : in.getOwnedType()) {
            out.getOwnedType().add((Type) doSwitch(_ownedType));
        }
        for (ProfileApplication _profileApplication : in.getProfileApplication()) {
            out.getProfileApplication().add((ProfileApplication) doSwitch(_profileApplication));
        }
        for (Precedence _ownedPrecedence : in.getOwnedPrecedence()) {
            out.getOwnedPrecedence().add((Precedence) doSwitch(_ownedPrecedence));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseMessageExp(MessageExp in) {
	    final MessageExp out = PivotFactory.eINSTANCE.createMessageExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        CallOperationAction _calledOperation = in.getCalledOperation();
        if (_calledOperation != null)
            out.setCalledOperation((CallOperationAction) doSwitch(_calledOperation));
        SendSignalAction _sentSignal = in.getSentSignal();
        if (_sentSignal != null)
            out.setSentSignal((SendSignalAction) doSwitch(_sentSignal));
        OCLExpression _target = in.getTarget();
        if (_target != null)
            out.setTarget((OCLExpression) doSwitch(_target));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (OCLExpression _argument : in.getArgument()) {
            out.getArgument().add((OCLExpression) doSwitch(_argument));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseMessageType(MessageType in) {
	    final MessageType out = PivotFactory.eINSTANCE.createMessageType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Operation _referredOperation = in.getReferredOperation();
        if (_referredOperation != null)
            out.setReferredOperation((Operation) doSwitch(_referredOperation));
        Signal _referredSignal = in.getReferredSignal();
        if (_referredSignal != null)
            out.setReferredSignal((Signal) doSwitch(_referredSignal));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseNullLiteralExp(NullLiteralExp in) {
	    final NullLiteralExp out = PivotFactory.eINSTANCE.createNullLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseOpaqueExpression(OpaqueExpression in) {
	    final OpaqueExpression out = PivotFactory.eINSTANCE.createOpaqueExpression();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.getBody().addAll(in.getBody());
        out.getLanguage().addAll(in.getLanguage());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        ExpressionInOCL _ownedExpressionInOCL = in.getOwnedExpressionInOCL();
        if (_ownedExpressionInOCL != null)
            out.setOwnedExpressionInOCL((ExpressionInOCL) doSwitch(_ownedExpressionInOCL));
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
    public Element caseOperation(Operation in) {
	    final Operation out = PivotFactory.eINSTANCE.createOperation();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplementation(in.getImplementation());
	    out.setImplementationClass(in.getImplementationClass());
	    out.setIsInvalidating(in.isInvalidating());
	    out.setIsValidating(in.isValidating());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        OpaqueExpression _bodyExpression = in.getBodyExpression();
        if (_bodyExpression != null)
            out.setBodyExpression((OpaqueExpression) doSwitch(_bodyExpression));
        Type _owningType = in.getOwningType();
        if (_owningType != null)
            out.setOwningType((Type) doSwitch(_owningType));
        Precedence _precedence = in.getPrecedence();
        if (_precedence != null)
            out.setPrecedence((Precedence) doSwitch(_precedence));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (Parameter _ownedParameter : in.getOwnedParameter()) {
            out.getOwnedParameter().add((Parameter) doSwitch(_ownedParameter));
        }
        for (Constraint _postcondition : in.getPostcondition()) {
            out.getPostcondition().add((Constraint) doSwitch(_postcondition));
        }
        for (Constraint _precondition : in.getPrecondition()) {
            out.getPrecondition().add((Constraint) doSwitch(_precondition));
        }
        for (Type _raisedException : in.getRaisedException()) {
            out.getRaisedException().add((Type) doSwitch(_raisedException));
        }
        for (Operation _redefinedOperation : in.getRedefinedOperation()) {
            out.getRedefinedOperation().add((Operation) doSwitch(_redefinedOperation));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseOperationCallExp(OperationCallExp in) {
	    final OperationCallExp out = PivotFactory.eINSTANCE.createOperationCallExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _source = in.getSource();
        if (_source != null)
            out.setSource((OCLExpression) doSwitch(_source));
        Operation _referredOperation = in.getReferredOperation();
        if (_referredOperation != null)
            out.setReferredOperation((Operation) doSwitch(_referredOperation));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (OCLExpression _argument : in.getArgument()) {
            out.getArgument().add((OCLExpression) doSwitch(_argument));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseOperationTemplateParameter(OperationTemplateParameter in) {
	    final OperationTemplateParameter out = PivotFactory.eINSTANCE.createOperationTemplateParameter();
	    assert out != null;
	    transformation.addOrphan(out);
        ParameterableElement _default = in.getDefault();
        if (_default != null)
            out.setDefault((ParameterableElement) doSwitch(_default));
        ParameterableElement _ownedDefault = in.getOwnedDefault();
        if (_ownedDefault != null)
            out.setOwnedDefault((ParameterableElement) doSwitch(_ownedDefault));
        ParameterableElement _ownedParameteredElement = in.getOwnedParameteredElement();
        if (_ownedParameteredElement != null)
            out.setOwnedParameteredElement((ParameterableElement) doSwitch(_ownedParameteredElement));
        ParameterableElement _parameteredElement = in.getParameteredElement();
        if (_parameteredElement != null)
            out.setParameteredElement((ParameterableElement) doSwitch(_parameteredElement));
        TemplateSignature _signature = in.getSignature();
        if (_signature != null)
            out.setSignature((TemplateSignature) doSwitch(_signature));
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
    public Element caseOppositePropertyCallExp(OppositePropertyCallExp in) {
	    final OppositePropertyCallExp out = PivotFactory.eINSTANCE.createOppositePropertyCallExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _source = in.getSource();
        if (_source != null)
            out.setSource((OCLExpression) doSwitch(_source));
        Property _navigationSource = in.getNavigationSource();
        if (_navigationSource != null)
            out.setNavigationSource((Property) doSwitch(_navigationSource));
        Property _referredProperty = in.getReferredProperty();
        if (_referredProperty != null)
            out.setReferredProperty((Property) doSwitch(_referredProperty));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (OCLExpression _qualifier : in.getQualifier()) {
            out.getQualifier().add((OCLExpression) doSwitch(_qualifier));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseOrderedSetType(OrderedSetType in) {
	    final OrderedSetType out = PivotFactory.eINSTANCE.createOrderedSetType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        Type _elementType = in.getElementType();
        if (_elementType != null)
            out.setElementType((Type) doSwitch(_elementType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element casePackage(Package in) {
	    final Package out = PivotFactory.eINSTANCE.createPackage();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setNsPrefix(in.getNsPrefix());
	    out.setNsURI(in.getNsURI());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        Package _nestingPackage = in.getNestingPackage();
        if (_nestingPackage != null)
            out.setNestingPackage((Package) doSwitch(_nestingPackage));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (Package _importedPackage : in.getImportedPackage()) {
            out.getImportedPackage().add((Package) doSwitch(_importedPackage));
        }
        for (Package _nestedPackage : in.getNestedPackage()) {
            out.getNestedPackage().add((Package) doSwitch(_nestedPackage));
        }
        for (Type _ownedType : in.getOwnedType()) {
            out.getOwnedType().add((Type) doSwitch(_ownedType));
        }
        for (ProfileApplication _profileApplication : in.getProfileApplication()) {
            out.getProfileApplication().add((ProfileApplication) doSwitch(_profileApplication));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseParameter(Parameter in) {
	    final Parameter out = PivotFactory.eINSTANCE.createParameter();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        Operation _operation = in.getOperation();
        if (_operation != null)
            out.setOperation((Operation) doSwitch(_operation));
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
    public Element casePrecedence(Precedence in) {
	    final Precedence out = PivotFactory.eINSTANCE.createPrecedence();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setAssociativity(in.getAssociativity());
	    out.setOrder(in.getOrder());
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
    public Element casePrimitiveType(PrimitiveType in) {
        return in;
    }
    /**
     * @generated
     */
    @Override 
    public Element caseProfile(Profile in) {
	    final Profile out = PivotFactory.eINSTANCE.createProfile();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setNsPrefix(in.getNsPrefix());
	    out.setNsURI(in.getNsURI());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        Package _nestingPackage = in.getNestingPackage();
        if (_nestingPackage != null)
            out.setNestingPackage((Package) doSwitch(_nestingPackage));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (Package _importedPackage : in.getImportedPackage()) {
            out.getImportedPackage().add((Package) doSwitch(_importedPackage));
        }
        for (Package _nestedPackage : in.getNestedPackage()) {
            out.getNestedPackage().add((Package) doSwitch(_nestedPackage));
        }
        for (Type _ownedType : in.getOwnedType()) {
            out.getOwnedType().add((Type) doSwitch(_ownedType));
        }
        for (ProfileApplication _profileApplication : in.getProfileApplication()) {
            out.getProfileApplication().add((ProfileApplication) doSwitch(_profileApplication));
        }
        for (ProfileApplication _application : in.getApplication()) {
            out.getApplication().add((ProfileApplication) doSwitch(_application));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseProfileApplication(ProfileApplication in) {
	    final ProfileApplication out = PivotFactory.eINSTANCE.createProfileApplication();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStrict(in.isStrict());
        Profile _appliedProfile = in.getAppliedProfile();
        if (_appliedProfile != null)
            out.setAppliedProfile((Profile) doSwitch(_appliedProfile));
        Package _applyingPackage = in.getApplyingPackage();
        if (_applyingPackage != null)
            out.setApplyingPackage((Package) doSwitch(_applyingPackage));
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
    public Element caseProperty(Property in) {
	    final Property out = PivotFactory.eINSTANCE.createProperty();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplementation(in.getImplementation());
	    out.setImplementationClass(in.getImplementationClass());
	    out.setDefault(in.getDefault());
	    out.setImplicit(in.isImplicit());
	    out.setIsComposite(in.isComposite());
	    out.setIsDerived(in.isDerived());
	    out.setIsID(in.isID());
	    out.setIsReadOnly(in.isReadOnly());
	    out.setIsResolveProxies(in.isResolveProxies());
	    out.setIsTransient(in.isTransient());
	    out.setIsUnsettable(in.isUnsettable());
	    out.setIsVolatile(in.isVolatile());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        AssociationClass _associationClass = in.getAssociationClass();
        if (_associationClass != null)
            out.setAssociationClass((AssociationClass) doSwitch(_associationClass));
        OpaqueExpression _defaultExpression = in.getDefaultExpression();
        if (_defaultExpression != null)
            out.setDefaultExpression((OpaqueExpression) doSwitch(_defaultExpression));
        Property _opposite = in.getOpposite();
        if (_opposite != null)
            out.setOpposite((Property) doSwitch(_opposite));
        Type _owningType = in.getOwningType();
        if (_owningType != null)
            out.setOwningType((Type) doSwitch(_owningType));
        Property _referredProperty = in.getReferredProperty();
        if (_referredProperty != null)
            out.setReferredProperty((Property) doSwitch(_referredProperty));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Property _keys : in.getKeys()) {
            out.getKeys().add((Property) doSwitch(_keys));
        }
        for (Property _redefinedProperty : in.getRedefinedProperty()) {
            out.getRedefinedProperty().add((Property) doSwitch(_redefinedProperty));
        }
        for (Property _subsettedProperty : in.getSubsettedProperty()) {
            out.getSubsettedProperty().add((Property) doSwitch(_subsettedProperty));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element casePropertyCallExp(PropertyCallExp in) {
	    final PropertyCallExp out = PivotFactory.eINSTANCE.createPropertyCallExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _source = in.getSource();
        if (_source != null)
            out.setSource((OCLExpression) doSwitch(_source));
        Property _navigationSource = in.getNavigationSource();
        if (_navigationSource != null)
            out.setNavigationSource((Property) doSwitch(_navigationSource));
        Property _referredProperty = in.getReferredProperty();
        if (_referredProperty != null)
            out.setReferredProperty((Property) doSwitch(_referredProperty));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (OCLExpression _qualifier : in.getQualifier()) {
            out.getQualifier().add((OCLExpression) doSwitch(_qualifier));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element casePseudostate(Pseudostate in) {
	    final Pseudostate out = PivotFactory.eINSTANCE.createPseudostate();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setKind(in.getKind());
        Region _container = in.getContainer();
        if (_container != null)
            out.setContainer((Region) doSwitch(_container));
        State _state = in.getState();
        if (_state != null)
            out.setState((State) doSwitch(_state));
        StateMachine _stateMachine = in.getStateMachine();
        if (_stateMachine != null)
            out.setStateMachine((StateMachine) doSwitch(_stateMachine));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Transition _incoming : in.getIncoming()) {
            out.getIncoming().add((Transition) doSwitch(_incoming));
        }
        for (Transition _outgoing : in.getOutgoing()) {
            out.getOutgoing().add((Transition) doSwitch(_outgoing));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseRealLiteralExp(RealLiteralExp in) {
	    final RealLiteralExp out = PivotFactory.eINSTANCE.createRealLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setRealSymbol(in.getRealSymbol());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseRegion(Region in) {
	    final Region out = PivotFactory.eINSTANCE.createRegion();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        Region _extendedRegion = in.getExtendedRegion();
        if (_extendedRegion != null)
            out.setExtendedRegion((Region) doSwitch(_extendedRegion));
        State _state = in.getState();
        if (_state != null)
            out.setState((State) doSwitch(_state));
        StateMachine _stateMachine = in.getStateMachine();
        if (_stateMachine != null)
            out.setStateMachine((StateMachine) doSwitch(_stateMachine));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Vertex _subvertex : in.getSubvertex()) {
            out.getSubvertex().add((Vertex) doSwitch(_subvertex));
        }
        for (Transition _transition : in.getTransition()) {
            out.getTransition().add((Transition) doSwitch(_transition));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseRoot(Root in) {
	    final Root out = PivotFactory.eINSTANCE.createRoot();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setExternalURI(in.getExternalURI());
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Import _imports : in.getImports()) {
            out.getImports().add((Import) doSwitch(_imports));
        }
        for (Package _nestedPackage : in.getNestedPackage()) {
            out.getNestedPackage().add((Package) doSwitch(_nestedPackage));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseSelfType(SelfType in) {
	    final SelfType out = PivotFactory.eINSTANCE.createSelfType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseSendSignalAction(SendSignalAction in) {
	    final SendSignalAction out = PivotFactory.eINSTANCE.createSendSignalAction();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        Signal _signal = in.getSignal();
        if (_signal != null)
            out.setSignal((Signal) doSwitch(_signal));
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
    public Element caseSequenceType(SequenceType in) {
	    final SequenceType out = PivotFactory.eINSTANCE.createSequenceType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        Type _elementType = in.getElementType();
        if (_elementType != null)
            out.setElementType((Type) doSwitch(_elementType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseSetType(SetType in) {
	    final SetType out = PivotFactory.eINSTANCE.createSetType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        Type _elementType = in.getElementType();
        if (_elementType != null)
            out.setElementType((Type) doSwitch(_elementType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseSignal(Signal in) {
	    final Signal out = PivotFactory.eINSTANCE.createSignal();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
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
    public Element caseState(State in) {
	    final State out = PivotFactory.eINSTANCE.createState();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsSubmachineState(in.isSubmachineState());
        Region _container = in.getContainer();
        if (_container != null)
            out.setContainer((Region) doSwitch(_container));
        Behavior _doActivity = in.getDoActivity();
        if (_doActivity != null)
            out.setDoActivity((Behavior) doSwitch(_doActivity));
        Behavior _entry = in.getEntry();
        if (_entry != null)
            out.setEntry((Behavior) doSwitch(_entry));
        Behavior _exit = in.getExit();
        if (_exit != null)
            out.setExit((Behavior) doSwitch(_exit));
        State _redefinedState = in.getRedefinedState();
        if (_redefinedState != null)
            out.setRedefinedState((State) doSwitch(_redefinedState));
        Constraint _stateInvariant = in.getStateInvariant();
        if (_stateInvariant != null)
            out.setStateInvariant((Constraint) doSwitch(_stateInvariant));
        StateMachine _submachine = in.getSubmachine();
        if (_submachine != null)
            out.setSubmachine((StateMachine) doSwitch(_submachine));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Transition _incoming : in.getIncoming()) {
            out.getIncoming().add((Transition) doSwitch(_incoming));
        }
        for (Transition _outgoing : in.getOutgoing()) {
            out.getOutgoing().add((Transition) doSwitch(_outgoing));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (ConnectionPointReference _connection : in.getConnection()) {
            out.getConnection().add((ConnectionPointReference) doSwitch(_connection));
        }
        for (Pseudostate _connectionPoint : in.getConnectionPoint()) {
            out.getConnectionPoint().add((Pseudostate) doSwitch(_connectionPoint));
        }
        for (Trigger _deferrableTrigger : in.getDeferrableTrigger()) {
            out.getDeferrableTrigger().add((Trigger) doSwitch(_deferrableTrigger));
        }
        for (Region _region : in.getRegion()) {
            out.getRegion().add((Region) doSwitch(_region));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseStateExp(StateExp in) {
	    final StateExp out = PivotFactory.eINSTANCE.createStateExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        State _referredState = in.getReferredState();
        if (_referredState != null)
            out.setReferredState((State) doSwitch(_referredState));
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
    public Element caseStateMachine(StateMachine in) {
	    final StateMachine out = PivotFactory.eINSTANCE.createStateMachine();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Transition _transition = in.getTransition();
        if (_transition != null)
            out.setTransition((Transition) doSwitch(_transition));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
        for (Pseudostate _connectionPoint : in.getConnectionPoint()) {
            out.getConnectionPoint().add((Pseudostate) doSwitch(_connectionPoint));
        }
        for (StateMachine _extendedStateMachine : in.getExtendedStateMachine()) {
            out.getExtendedStateMachine().add((StateMachine) doSwitch(_extendedStateMachine));
        }
        for (Region _region : in.getRegion()) {
            out.getRegion().add((Region) doSwitch(_region));
        }
        for (State _submachineState : in.getSubmachineState()) {
            out.getSubmachineState().add((State) doSwitch(_submachineState));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseStereotype(Stereotype in) {
	    final Stereotype out = PivotFactory.eINSTANCE.createStereotype();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
        for (TypeExtension _extensionOfs : in.getExtensionOfs()) {
            out.getExtensionOfs().add((TypeExtension) doSwitch(_extensionOfs));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseStringLiteralExp(StringLiteralExp in) {
	    final StringLiteralExp out = PivotFactory.eINSTANCE.createStringLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setStringSymbol(in.getStringSymbol());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseTemplateBinding(TemplateBinding in) {
	    final TemplateBinding out = PivotFactory.eINSTANCE.createTemplateBinding();
	    assert out != null;
	    transformation.addOrphan(out);
        TemplateableElement _boundElement = in.getBoundElement();
        if (_boundElement != null)
            out.setBoundElement((TemplateableElement) doSwitch(_boundElement));
        TemplateSignature _signature = in.getSignature();
        if (_signature != null)
            out.setSignature((TemplateSignature) doSwitch(_signature));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateParameterSubstitution _parameterSubstitution : in.getParameterSubstitution()) {
            out.getParameterSubstitution().add((TemplateParameterSubstitution) doSwitch(_parameterSubstitution));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseTemplateParameter(TemplateParameter in) {
	    final TemplateParameter out = PivotFactory.eINSTANCE.createTemplateParameter();
	    assert out != null;
	    transformation.addOrphan(out);
        ParameterableElement _default = in.getDefault();
        if (_default != null)
            out.setDefault((ParameterableElement) doSwitch(_default));
        ParameterableElement _ownedDefault = in.getOwnedDefault();
        if (_ownedDefault != null)
            out.setOwnedDefault((ParameterableElement) doSwitch(_ownedDefault));
        ParameterableElement _ownedParameteredElement = in.getOwnedParameteredElement();
        if (_ownedParameteredElement != null)
            out.setOwnedParameteredElement((ParameterableElement) doSwitch(_ownedParameteredElement));
        ParameterableElement _parameteredElement = in.getParameteredElement();
        if (_parameteredElement != null)
            out.setParameteredElement((ParameterableElement) doSwitch(_parameteredElement));
        TemplateSignature _signature = in.getSignature();
        if (_signature != null)
            out.setSignature((TemplateSignature) doSwitch(_signature));
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
    public Element caseTemplateParameterSubstitution(TemplateParameterSubstitution in) {
	    final TemplateParameterSubstitution out = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
	    assert out != null;
	    transformation.addOrphan(out);
        ParameterableElement _actual = in.getActual();
        if (_actual != null)
            out.setActual((ParameterableElement) doSwitch(_actual));
        TemplateParameter _formal = in.getFormal();
        if (_formal != null)
            out.setFormal((TemplateParameter) doSwitch(_formal));
        ParameterableElement _ownedActual = in.getOwnedActual();
        if (_ownedActual != null)
            out.setOwnedActual((ParameterableElement) doSwitch(_ownedActual));
        TemplateBinding _templateBinding = in.getTemplateBinding();
        if (_templateBinding != null)
            out.setTemplateBinding((TemplateBinding) doSwitch(_templateBinding));
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
    public Element caseTemplateParameterType(TemplateParameterType in) {
	    final TemplateParameterType out = PivotFactory.eINSTANCE.createTemplateParameterType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setSpecification(in.getSpecification());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseTemplateSignature(TemplateSignature in) {
	    final TemplateSignature out = PivotFactory.eINSTANCE.createTemplateSignature();
	    assert out != null;
	    transformation.addOrphan(out);
        TemplateableElement _template = in.getTemplate();
        if (_template != null)
            out.setTemplate((TemplateableElement) doSwitch(_template));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateParameter _ownedParameter : in.getOwnedParameter()) {
            out.getOwnedParameter().add((TemplateParameter) doSwitch(_ownedParameter));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseTransition(Transition in) {
	    final Transition out = PivotFactory.eINSTANCE.createTransition();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setKind(in.getKind());
        Region _container = in.getContainer();
        if (_container != null)
            out.setContainer((Region) doSwitch(_container));
        Behavior _effect = in.getEffect();
        if (_effect != null)
            out.setEffect((Behavior) doSwitch(_effect));
        Constraint _guard = in.getGuard();
        if (_guard != null)
            out.setGuard((Constraint) doSwitch(_guard));
        Vertex _source = in.getSource();
        if (_source != null)
            out.setSource((Vertex) doSwitch(_source));
        Vertex _target = in.getTarget();
        if (_target != null)
            out.setTarget((Vertex) doSwitch(_target));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Trigger _trigger : in.getTrigger()) {
            out.getTrigger().add((Trigger) doSwitch(_trigger));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseTrigger(Trigger in) {
	    final Trigger out = PivotFactory.eINSTANCE.createTrigger();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        State _state = in.getState();
        if (_state != null)
            out.setState((State) doSwitch(_state));
        Transition _transition = in.getTransition();
        if (_transition != null)
            out.setTransition((Transition) doSwitch(_transition));
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
    public Element caseTupleLiteralExp(TupleLiteralExp in) {
	    final TupleLiteralExp out = PivotFactory.eINSTANCE.createTupleLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TupleLiteralPart _part : in.getPart()) {
            out.getPart().add((TupleLiteralPart) doSwitch(_part));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseTupleLiteralPart(TupleLiteralPart in) {
	    final TupleLiteralPart out = PivotFactory.eINSTANCE.createTupleLiteralPart();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _initExpression = in.getInitExpression();
        if (_initExpression != null)
            out.setInitExpression((OCLExpression) doSwitch(_initExpression));
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
    public Element caseTupleType(TupleType in) {
	    final TupleType out = PivotFactory.eINSTANCE.createTupleType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _behavioralType = in.getBehavioralType();
        if (_behavioralType != null)
            out.setBehavioralType((Type) doSwitch(_behavioralType));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseType(Type in) {
	    final Type out = PivotFactory.eINSTANCE.createType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseTypeExp(TypeExp in) {
	    final TypeExp out = PivotFactory.eINSTANCE.createTypeExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        Type _referredType = in.getReferredType();
        if (_referredType != null)
            out.setReferredType((Type) doSwitch(_referredType));
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
    public Element caseTypeExtension(TypeExtension in) {
	    final TypeExtension out = PivotFactory.eINSTANCE.createTypeExtension();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsRequired(in.isRequired());
        Stereotype _stereotype = in.getStereotype();
        if (_stereotype != null)
            out.setStereotype((Stereotype) doSwitch(_stereotype));
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseTypeTemplateParameter(TypeTemplateParameter in) {
	    final TypeTemplateParameter out = PivotFactory.eINSTANCE.createTypeTemplateParameter();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setAllowSubstitutable(in.isAllowSubstitutable());
        ParameterableElement _default = in.getDefault();
        if (_default != null)
            out.setDefault((ParameterableElement) doSwitch(_default));
        ParameterableElement _ownedDefault = in.getOwnedDefault();
        if (_ownedDefault != null)
            out.setOwnedDefault((ParameterableElement) doSwitch(_ownedDefault));
        ParameterableElement _ownedParameteredElement = in.getOwnedParameteredElement();
        if (_ownedParameteredElement != null)
            out.setOwnedParameteredElement((ParameterableElement) doSwitch(_ownedParameteredElement));
        ParameterableElement _parameteredElement = in.getParameteredElement();
        if (_parameteredElement != null)
            out.setParameteredElement((ParameterableElement) doSwitch(_parameteredElement));
        TemplateSignature _signature = in.getSignature();
        if (_signature != null)
            out.setSignature((TemplateSignature) doSwitch(_signature));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (Type _constrainingType : in.getConstrainingType()) {
            out.getConstrainingType().add((Type) doSwitch(_constrainingType));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp in) {
	    final UnlimitedNaturalLiteralExp out = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setUnlimitedNaturalSymbol(in.getUnlimitedNaturalSymbol());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseUnspecifiedType(UnspecifiedType in) {
	    final UnspecifiedType out = PivotFactory.eINSTANCE.createUnspecifiedType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        Type _lowerBound = in.getLowerBound();
        if (_lowerBound != null)
            out.setLowerBound((Type) doSwitch(_lowerBound));
        Type _upperBound = in.getUpperBound();
        if (_upperBound != null)
            out.setUpperBound((Type) doSwitch(_upperBound));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
    /**
     * @generated
     */
    @Override 
    public Element caseUnspecifiedValueExp(UnspecifiedValueExp in) {
	    final UnspecifiedValueExp out = PivotFactory.eINSTANCE.createUnspecifiedValueExp();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
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
    public Element caseVariable(Variable in) {
	    final Variable out = PivotFactory.eINSTANCE.createVariable();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
        Type _type = in.getType();
        if (_type != null)
            out.setType((Type) doSwitch(_type));
        OCLExpression _initExpression = in.getInitExpression();
        if (_initExpression != null)
            out.setInitExpression((OCLExpression) doSwitch(_initExpression));
        Parameter _representedParameter = in.getRepresentedParameter();
        if (_representedParameter != null)
            out.setRepresentedParameter((Parameter) doSwitch(_representedParameter));
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
	    final VoidType out = PivotFactory.eINSTANCE.createVoidType();
	    assert out != null;
	    transformation.addOrphan(out);
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        TemplateSignature _ownedTemplateSignature = in.getOwnedTemplateSignature();
        if (_ownedTemplateSignature != null)
            out.setOwnedTemplateSignature((TemplateSignature) doSwitch(_ownedTemplateSignature));
        TemplateableElement _unspecializedElement = in.getUnspecializedElement();
        if (_unspecializedElement != null)
            out.setUnspecializedElement((TemplateableElement) doSwitch(_unspecializedElement));
        TemplateParameter _owningTemplateParameter = in.getOwningTemplateParameter();
        if (_owningTemplateParameter != null)
            out.setOwningTemplateParameter((TemplateParameter) doSwitch(_owningTemplateParameter));
        TemplateParameter _templateParameter = in.getTemplateParameter();
        if (_templateParameter != null)
            out.setTemplateParameter((TemplateParameter) doSwitch(_templateParameter));
        Package _package = in.getPackage();
        if (_package != null)
            out.setPackage((Package) doSwitch(_package));
        for (ElementExtension _extension : in.getExtension()) {
            out.getExtension().add((ElementExtension) doSwitch(_extension));
        }
        for (Element _ownedAnnotation : in.getOwnedAnnotation()) {
            out.getOwnedAnnotation().add((Element) doSwitch(_ownedAnnotation));
        }
        for (Comment _ownedComment : in.getOwnedComment()) {
            out.getOwnedComment().add((Comment) doSwitch(_ownedComment));
        }
        for (TemplateBinding _templateBinding : in.getTemplateBinding()) {
            out.getTemplateBinding().add((TemplateBinding) doSwitch(_templateBinding));
        }
        for (TypeExtension _extendedBys : in.getExtendedBys()) {
            out.getExtendedBys().add((TypeExtension) doSwitch(_extendedBys));
        }
        for (Property _ownedAttribute : in.getOwnedAttribute()) {
            out.getOwnedAttribute().add((Property) doSwitch(_ownedAttribute));
        }
        for (Constraint _ownedInvariant : in.getOwnedInvariant()) {
            out.getOwnedInvariant().add((Constraint) doSwitch(_ownedInvariant));
        }
        for (Operation _ownedOperation : in.getOwnedOperation()) {
            out.getOwnedOperation().add((Operation) doSwitch(_ownedOperation));
        }
        for (Type _superClass : in.getSuperClass()) {
            out.getSuperClass().add((Type) doSwitch(_superClass));
        }
        for (Constraint _ownedRule : in.getOwnedRule()) {
            out.getOwnedRule().add((Constraint) doSwitch(_ownedRule));
        }
        for (Class _nestedType : in.getNestedType()) {
            out.getNestedType().add((Class) doSwitch(_nestedType));
        }
        for (Behavior _ownedBehavior : in.getOwnedBehavior()) {
            out.getOwnedBehavior().add((Behavior) doSwitch(_ownedBehavior));
        }
	    return out;    
    }
}

