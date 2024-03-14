/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.sirius;

import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramImportDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.provider.SiriusEditPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.collect.Iterables;

/**
 * The InitializeDiagramDialog determines the parameterisation for an (additional) diagram representation.
 * <p>
 * The dialog is seeded by a UI (multi-)selection, which determines the ResourceSEt containing the
 * models from which some or all elements are to be rendered in a diagram.
 * <p>
 * The dialog supports selection of the type of diagram, the root model element for the diagram,
 * and which elements are to be rendered.
 * <p>
 * The diagram can be shared with the standard primary representations.aird, or may be separated into a
 * secondary *.aird.
 */
public class InitializeDiagramDialog extends TitleAreaDialog
{
//	private static final Logger logger = Logger.getLogger(InitializeDiagramDialog.class);
	// This Dialog can be maintained using WindowBuilder although the buttons bar renders imperfectly.
	private static final @NonNull String emptyString = "«null»";
//	private static final @NonNull EObject zznullEObject = new NullEObject();
	private static final @NonNull EObject noSelectedEObject = new NoSelectedEObject();
	private static @NonNull Map<@NonNull EObject, @NonNull Set<@NonNull EObject>> emptyEObject2EObjectsEntry = new HashMap<>();
	static { emptyEObject2EObjectsEntry.put(noSelectedEObject, Collections.emptySet()); }
	private static @NonNull MapOfSetEntry<@NonNull String> emptyString2StringsEntry = new MapOfSetEntry<>(emptyString, Collections.emptySet());

	/**
	 * AIRDReader provides the SAX callbacks to support reading the
	 * viewpoint:DAnalysis.ownedViews.ownedRepresentationDescriptors.name attribute(s) in an aird file.
	 */
	protected static class AIRDReader extends DefaultHandler
	{
		public static final @NonNull String DAnalysisTag = "viewpoint:DAnalysis";
		public static final @NonNull String ownedViewsTag = "ownedViews";
		public static final @NonNull String ownedRepresentationDescriptorsTag = "ownedRepresentationDescriptors";
		public static final @NonNull String nameAttribute = "name";

		protected final @NonNull List<@NonNull String> diagramNames;

		private @NonNull Stack<@NonNull String> elements = new Stack<>();

		public AIRDReader() {
			this.diagramNames = new ArrayList<>();
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			elements.pop();
		}


		public @NonNull List<@NonNull String> getDiagramNames() {
			return diagramNames;
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			assert qName != null;
			int size = elements.size();
			if (ownedRepresentationDescriptorsTag.equals(qName)) {
				if (size >= 2) {		// Probably has an xmi:XMI
					if (ownedViewsTag.equals(elements.elementAt(size-1))) {
						if (DAnalysisTag.equals(elements.elementAt(size-2))) {
							String diagramName = attributes.getValue(nameAttribute);
							if (diagramName != null) {
								diagramNames.add(diagramName);
							}
						}
					}
				}
			}
			elements.push(qName);
		}
	}

	protected abstract class AbstractSelectionListener implements SelectionListener
	{
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
	}

	protected class CheckAllElementsSelectionListener extends AbstractSelectionListener
	{
		protected final boolean isSelected;

		public CheckAllElementsSelectionListener(boolean isSelected) {
			this.isSelected = isSelected;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (selectedRootModelElement != noSelectedEObject) {
				setDeepChecked(selectedRootModelElement, isSelected);
				refreshModelElementsRendering();
				refreshMessage(null);
			}
		}
	}

	protected class ExpandAllElementsSelectionListener extends AbstractSelectionListener
	{
		protected final boolean isExpanded;

		public ExpandAllElementsSelectionListener(boolean isExpanded) {
			this.isExpanded = isExpanded;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (selectedRootModelElement != noSelectedEObject) {
				setDeepExpanded(selectedRootModelElement, isExpanded);
				refreshModelElementsRendering();
				refreshMessage(null);
			}
		}
	}

	private static class LabelProviderComparator implements Comparator<@NonNull Notifier>
	{
		protected final @NonNull ILabelProvider labelProvider;
		private final @NonNull Map<@NonNull Notifier, @NonNull String> notifier2label = new HashMap<>();

		public LabelProviderComparator(@NonNull ILabelProvider labelProvider) {
			this.labelProvider = labelProvider;
		}

		@Override
		public int compare(@NonNull Notifier n1, @NonNull Notifier n2) {
			String s1 = getLabel(n1);
			String s2 = getLabel(n2);
			return s2.compareTo(s1);
		}

		protected @NonNull String getLabel(@NonNull Notifier notifier) {
			String label = notifier2label.get(notifier);
			if (label == null) {
				label = labelProvider.getText(notifier);
				assert label != null;
				notifier2label.put(notifier, label);
			}
			return label;
		}
	}

	@SuppressWarnings("serial")
	protected static class MapOfSetEntry<E> extends AbstractMap.SimpleEntry<@NonNull E, @NonNull Set<@NonNull E>>
	{
		public MapOfSetEntry(@NonNull E key, @NonNull Set<@NonNull E> value) {
			super(key, value);
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			@SuppressWarnings("null") @NonNull E key = getKey();
			s.append(key.toString());
			s.append(" => {");
			@SuppressWarnings("null") @NonNull Set<@NonNull E> values = getValue();
			for (@NonNull E value : values) {
				s.append(" ");
				s.append(value.toString());
			}
			s.append(" }");
			return s.toString();
		}
	}

	private static final class ModelElementDepthComparator extends LabelProviderComparator
	{
		public ModelElementDepthComparator(@NonNull ILabelProvider labelProvider) {
			super(labelProvider);
		}

		private final @NonNull Map<@NonNull Notifier, @NonNull Integer> notifier2depth = new HashMap<>();

		@Override
		public int compare(@NonNull Notifier n1, @NonNull Notifier n2) {
			int d1 = getDepth(n1);
			int d2 = getDepth(n2);
			int diff = d1 - d2;		// smallest first
			if (diff != 0) {
				return diff;
			}
			String s1 = getLabel(n1);
			String s2 = getLabel(n2);
			return s2.compareTo(s1);
		}

		private int getDepth(@NonNull Notifier notifier) {
			Integer depth = notifier2depth.get(notifier);
			if (depth == null) {
				int intDepth;
				if (notifier instanceof Resource) {
					intDepth = 0;
				}
				else if (notifier instanceof EObject) {
					EObject eObject = (EObject)notifier;
					intDepth = 1;
					while ((eObject = eObject.eContainer()) != null) {
						intDepth++;
					}
				}
				else {
					throw new IllegalStateException();
				}
				depth = Integer.valueOf(intDepth);
				notifier2depth.put(notifier, depth);
			}
			return depth.intValue();
		}
	}

	protected class ModelElementsTreeMouseListener implements MouseListener
	{
		public @Nullable TreeItem getTreeItem(MouseEvent e) {
			Object source = e.getSource();
			if (!(source instanceof Tree)) {
				return null;
			}
			Tree tree = (Tree)source;
			return tree.getItem(new Point(e.x, e.y));
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			TreeItem treeItem = getTreeItem(e);
			Object notifier = treeItem != null ? treeItem.getData() : null;
		//	System.out.println("mouseDoubleClick = " + labelProvider.getText(notifier));
		}

		@Override
		public void mouseDown(MouseEvent e) {
			TreeItem treeItem = getTreeItem(e);
			Object notifier = treeItem != null ? treeItem.getData() : null;
		//	System.out.println("mouseDown = " + labelProvider.getText(notifier));
		}

		@Override
		public void mouseUp(MouseEvent e) {
			TreeItem treeItem = getTreeItem(e);
			Object notifier = null;
			if (treeItem != null) {
				notifier = treeItem.getData();
				if (notifier != null) {
					setChecked(notifier, !treeItem.getChecked());
				}
			}
		//	System.out.println("mouseUp = " + labelProvider.getText(notifier));
			refreshModelElementsRendering();
			refreshMessage(statusText.getText());
		}
	}

	protected class ModelElementsTreeListener implements TreeListener
	{
		public @Nullable Object getTreeItemData(TreeEvent e) {
			Widget treeItem = e.item;
			if (treeItem == null) {
				return null;
			}
			return treeItem.getData();
		}

		@Override
		public void treeCollapsed(TreeEvent e) {
			String problemMessage = null;
			Object notifier = getTreeItemData(e);
			if (notifier != null) {
				setExpanded(notifier, false);
			}
			else {
				problemMessage = "No model element selection.";
			}
			refreshModelElementsRendering();
			refreshMessage(problemMessage);
		//	System.out.println("treeCollapsed = " + labelProvider.getText(notifier));
		}

		@Override
		public void treeExpanded(TreeEvent e) {
			String problemMessage = null;
			Object notifier = getTreeItemData(e);
			if (notifier != null) {
				setExpanded(notifier, true);
			}
			else {
				problemMessage = "No model element selection.";
			}
			refreshModelElementsRendering();
			refreshMessage(problemMessage);
		//	System.out.println("treeExpanded = " + labelProvider.getText(notifier));
		}
	}

	protected class ModelElementsTreeSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
		//	System.out.println("treeSelect = " + e + " " + labelProvider.getText(e.data));
			RepresentationDescription selectedRepresentationDescription2 = selectedRepresentationDescription;
			String problemMessage;
			TreeItem item = (TreeItem) e.item;
			Object data = item.getData();
			if (selectedRepresentationDescription2 == null) {
				problemMessage = "No diagram representation selected";
			}
			else if (data instanceof EObject) {
			//	EObject eObject = (EObject)data;
			//	setChecked(eObject, item.getChecked());
			//	if ((data != selectedRootModelElement) && (data != selectedRootableEObject2checkableEObjects.getKey())) {
				if (selectableRootableEObject2checkableEObjects.containsKey(data)) {
					problemMessage = setSelectedRootModelElement();
				//	selectedRootModelElement = eObject;
				//	checkedModelElements.add(eObject);
					refreshModelElements();
				}
				else {
					problemMessage = "Not a " + selectedRepresentationDescription2.getLabel() + " element";
				}
			} else {
				problemMessage = "Not a " + selectedRepresentationDescription2.getLabel() + " root element";
			}
//				refreshViewpoints();
//			refreshViewpointsRendering();
			refreshModelElementsRendering();
			refreshMessage(problemMessage);
//				System.out.println("Selected " + viewpointsTree.getSelection().length);
		}
	}

	private static final class NoSelectedEObject extends ENamedElementImpl
	{
		@Override
		public @NonNull String getName() {
			return "«no-selected-EObject»";
		}
	}

	protected class RepresentationDiagramNameTextModifyListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
			Text text = (Text)e.getSource();
			representationDiagramName = text.getText();
		//	System.out.println("Modified \"" + representationDiagramName + "\"");
			refreshMessage(null);
		}
	}

	protected class RepresentationFileNameTextModifyListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
			oldDiagramNames = null;
			Text text = (Text)e.getSource();
			representationFileURI = URI.createURI(text.getText());
	//	System.out.println("Modified \""); // + e.  getText() + "\"");
			refreshMessage(null);
		}
	}

	protected class SharedRepresentationSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			refreshRepresentationFileName();
			refreshMessage(null);
		}
	}

	protected class ShowAllElementsSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			refreshModelElements();
			refreshModelElementsRendering();
			refreshMessage(null);
		}
	}

	protected class ShowAllViewpointsSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			refreshViewpoints();
			refreshViewpointsRendering();
			refreshMessage(null);
		}
	}

	protected class ViewpointsTreeSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			String problemMessage = setSelectedRepresentationDescription();
		//	refreshViewpoints();
			refreshViewpointsRendering();
			refreshModelElements();
			refreshModelElementsRendering();
			refreshMessage(problemMessage);
//				System.out.println("Selected " + viewpointsTree.getSelection().length);
		}
	}

	// The 'input's.
	protected final Iterable<@NonNull EObject> modelEObjects;

	// The derived 'input's.
	private final @NonNull ComposedAdapterFactory adapterFactory;
	private final @NonNull ILabelProvider labelProvider;
	private final @NonNull Map<@NonNull Resource, @NonNull List<@NonNull EObject>> resource2elements;
	private final @NonNull URI modelURI;
	private final @NonNull Set<@NonNull EPackage> modelEPackages;
	private final @NonNull Set<@NonNull String> modelURIs;

	// The derived state
	private final @NonNull Map<@NonNull Viewpoint, @NonNull List<@NonNull RepresentationDescription>> allViewpoint2representationDescriptions;
	private final @NonNull Map<@NonNull String, @NonNull Set<@NonNull String>> allRootableDomainClass2domainClasses;
	private final @NonNull Set<@NonNull EObject> allRootableEObjects;
	private final @NonNull Map<@NonNull EObject, Set<@NonNull EObject>> allRootableEObject2checkableEObjects;
	private final @NonNull Map<@NonNull String, Set<@NonNull EObject>> allRootableDomainClass2EObjects;
	private final @NonNull Map<@NonNull EObject, Set<@NonNull Notifier>> allRootableEObject2ancestralModelElements;
	private @Nullable List<@NonNull String> oldDiagramNames = null;

	// The working state
	private @Nullable RepresentationDescription selectedRepresentationDescription = null;
	private Map.@NonNull Entry<@NonNull String, @NonNull Set<@NonNull String>> selectedRootableDomainClass2domainClasses = emptyString2StringsEntry;
	private final @NonNull Set<@NonNull EObject> checkedModelElements = new HashSet<>();
	private final @NonNull Set<@NonNull Object> expandedModelElements;// = new HashSet<>();
	//
	private @NonNull EObject selectedRootModelElement = noSelectedEObject;
	private @NonNull Map<@NonNull EObject, @NonNull Set<@NonNull EObject>> selectableRootableEObject2checkableEObjects = emptyEObject2EObjectsEntry;

	// The widgets
	private Button checkAllButton;
	private Button collapseAllButton;
	private Button expandAllButton;
	private Button uncheckAllButton;
	private Button okButton;
	private Button sharedRepresentationFileCheckButton;
	private Button showAllElementsCheckButton;
	private Button showAllViewpointsCheckButton;
	private Composite viewpointsComposite;
	private Text representationFileNameText;
	private Tree modelsElementsTree;
	private Tree viewpointsTree;
	private Text representationDiagramNameText;
	private Text statusText;
	private Label representationDiagramNameLabel;
	//
	private @Nullable Font defaultFont = null;
	private @Nullable Font boldFont = null;
	private @Nullable Font boldItalicFont = null;
	private @Nullable Font italicFont = null;

	// The 'output's for access post-dispose().
	private @NonNull String representationDiagramName = "new Diagram Name";
	private URI representationFileURI = null;
	private Text descriptionText;
	private LocalResourceManager localResourceManager;

	private final @NonNull Comparator<@NonNull RepresentationDescription> representationDescriptorComparator = new Comparator<@NonNull RepresentationDescription>() {
		@Override
		public int compare(@NonNull RepresentationDescription o1, @NonNull RepresentationDescription o2) {
			String l1 = getSafeLabel(o1);
			String l2 = getSafeLabel(o2);
			return l1.compareTo(l2);
		}
	};

	private final @NonNull Comparator<@NonNull Viewpoint> viewpointComparator = new Comparator<@NonNull Viewpoint>() {
		@Override
		public int compare(@NonNull Viewpoint o1, @NonNull Viewpoint o2) {
			String l1 = getSafeLabel(o1);
			String l2 = getSafeLabel(o2);
			return l1.compareTo(l2);
		}
	};

	public InitializeDiagramDialog(Shell parentShell, @NonNull Iterable<@NonNull EObject> modelEObjects) {
		super(parentShell);
		createResourceManager();
		setHelpAvailable(false);
		setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.TITLE);
		this.modelEObjects = modelEObjects;
		Iterables.addAll(this.checkedModelElements, modelEObjects);
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
//		adapterFactory.addAdapterFactory(new NoSelectedEObjectAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		this.resource2elements = new HashMap<>();
		Resource firstModelResource = null;
		for (@NonNull EObject eObject : modelEObjects) {
			Resource eResource = eObject.eResource();
			assert eResource != null;
			List<@NonNull EObject> elements = resource2elements.get(eResource);
			if (elements == null) {
				elements = new ArrayList<>();
				resource2elements.put(eResource, elements);
			}
			elements.add(eObject);
			if (firstModelResource == null) {
				firstModelResource = eResource;
			}
		}
		assert firstModelResource != null;
		URI uri = firstModelResource.getURI();
		assert uri != null;
		this.modelURI = uri;
		this.modelEPackages = new HashSet<>();
		this.modelURIs = new HashSet<>();
		Iterable<@NonNull Resource> allResources = resource2elements.keySet();
		for (Resource eResource : allResources) {
			for (TreeIterator<EObject> tit = eResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				EClass eClass = eObject.eClass();
				EPackage ePackage = eClass.getEPackage();
				assert ePackage != null;
				if (modelEPackages.add(ePackage)) {
					String nsURI = getSafeNsURI(ePackage);
					modelURIs.add(String.valueOf(nsURI));
				}
			}
		}
		this.allViewpoint2representationDescriptions = gatherRepresentationDescriptions();
		this.allRootableDomainClass2domainClasses = gatherDomainClasses(allViewpoint2representationDescriptions.keySet());
	//	this.allRootableDomainClasses = gatherRootableDomainClasses(allViewpoints);
		this.allRootableEObjects = gatherRootableEObjects(allRootableDomainClass2domainClasses.keySet());
		this.allRootableEObject2checkableEObjects = gatherRootableEObject2checkableEObjects(allRootableEObjects);
		this.allRootableDomainClass2EObjects = gatherCompatibleEObjects(allRootableEObjects);
		this.allRootableEObject2ancestralModelElements = gatherAncestralModelElements(allRootableEObjects);
	//	this.rootableEClasses = gatherRootableEClasses(rootableEObjects);
		this.expandedModelElements = gatherInitialExpansions(allRootableEObjects);
	//	printAllRepresentations();
	//	printAllModelElements();
	}

/*	@Override
	public boolean close() {
		assert getShell() != null;
	//	finalRepresentationDiagramName = representationDiagramNameText.getText();
	//	finalRepresentationFileURI = sharedRepresentationFileCheckButton.getSelection() ? null : URI.createURI(representationFileNameText.getText());
	//	finalCheckedElements = basicGetCheckedElements();
	//	finalRegistryRepresentationDescription = selectedRepresentationDescription;
		boolean closeStatus = super.close();
		assert getShell() == null;
		return closeStatus;
	} */

	/**
	 * Return the DomainClasses corresponding to selected EClasses for which there is no design DomainClass support. Returns null if all supported.
	 */
	protected @Nullable List<@NonNull String> computeMissingDomainClasses(@NonNull Set<@NonNull EClass> selectedEClasses, @NonNull Set<@NonNull String> designDomainClasses) {
		List<@NonNull String> missingDomainClasses = null;
		for (EClass selectedEClass : selectedEClasses) {
			String selectedDomainClass = getDomainClass(selectedEClass);
			boolean isCreateable = designDomainClasses.contains(selectedDomainClass);
			if (!isCreateable) {
				if (missingDomainClasses == null) {
					missingDomainClasses = new ArrayList<>();

				}
				missingDomainClasses.add(selectedDomainClass);
			}
		}
		return missingDomainClasses;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
	//	Composite parent = new Composite(zparent, SWT.NONE);
		Layout layout = parent.getLayout();
		if (layout instanceof GridLayout) {
			((GridLayout)layout).makeColumnsEqualWidth = false;
			((GridLayout)layout).numColumns++;
			((GridLayout)layout).marginHeight = 5;
		}
		Object layoutData = parent.getLayoutData();
		if (layoutData instanceof GridData) {
			((GridData)layoutData).horizontalAlignment = SWT.FILL;
			((GridData)layoutData).grabExcessHorizontalSpace = true;
		}

		statusText = new Text(parent, SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY);
	//	statusText.setEnabled(true);
		statusText.setEditable(false);
		GridData textLayoutData = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		textLayoutData.heightHint = 50;
		textLayoutData.widthHint = 50;
		statusText.setLayoutData(textLayoutData);

		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

		refreshMessage(null);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Initialize Diagram");
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(1, true);
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		gl_container.verticalSpacing = 2;
		container.setLayout(gl_container);

		SashForm overallSash = new SashForm(container, SWT.VERTICAL);
		overallSash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		SashForm representationSash = new SashForm(overallSash, SWT.NONE);

		Composite representationComposite = new Composite(representationSash, SWT.BORDER);
		GridLayout gl_representationComposite = new GridLayout(1, true);
		gl_representationComposite.marginWidth = 0;
		gl_representationComposite.verticalSpacing = 0;
		gl_representationComposite.marginHeight = 0;
		representationComposite.setLayout(gl_representationComposite);
		GridData gd_representationGroup = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_representationGroup.minimumHeight = 150;
		representationComposite.setLayoutData(gd_representationGroup);

		Composite diagramRepresentationComposite = new Composite(representationComposite, SWT.NONE);
		diagramRepresentationComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		GridLayout gl_diagramRepresentationComposite = new GridLayout(3, false);
		gl_diagramRepresentationComposite.marginWidth = 0;
		gl_diagramRepresentationComposite.marginBottom = 2;
		gl_diagramRepresentationComposite.marginHeight = 0;
		diagramRepresentationComposite.setLayout(gl_diagramRepresentationComposite);

		Label diagramRepresentationLabel = new Label(diagramRepresentationComposite, SWT.NONE);
		diagramRepresentationLabel.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
		diagramRepresentationLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		diagramRepresentationLabel.setText("Diagram Representation Selector");

		sharedRepresentationFileCheckButton = new Button(diagramRepresentationComposite, SWT.CHECK);
		sharedRepresentationFileCheckButton.setSelection(true);
		sharedRepresentationFileCheckButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sharedRepresentationFileCheckButton.setToolTipText("Use a shared representation, typically reprersentations.aird, for all diagrams, or a distinct representation for this model/diagram.");
		sharedRepresentationFileCheckButton.setText("Shared");

		showAllViewpointsCheckButton = new Button(diagramRepresentationComposite, SWT.CHECK);
		showAllViewpointsCheckButton.setToolTipText("Show not-applicable as well as applicable viewpoints.");
		showAllViewpointsCheckButton.setText("Show All");

		Composite representationFileNameComposite = new Composite(representationComposite, SWT.NONE);
		representationFileNameComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_representationFileNameComposite = new GridLayout(2, false);
		gl_representationFileNameComposite.marginWidth = 0;
		gl_representationFileNameComposite.verticalSpacing = 0;
		gl_representationFileNameComposite.marginHeight = 0;
		representationFileNameComposite.setLayout(gl_representationFileNameComposite);

		Label representationFileNameLabel = new Label(representationFileNameComposite, SWT.NONE);
		representationFileNameLabel.setToolTipText("The file name within which the graphical aspects of the diagram are persisted.");
		representationFileNameLabel.setText("Filename:");

		representationFileNameText = new Text(representationFileNameComposite, SWT.BORDER);
		representationFileNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		viewpointsComposite = new Composite(representationComposite, SWT.NONE);
		viewpointsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_viewpointsComposite = new GridLayout(2, false);
		gl_viewpointsComposite.marginWidth = 0;
		gl_viewpointsComposite.verticalSpacing = 0;
		gl_viewpointsComposite.marginHeight = 0;
		viewpointsComposite.setLayout(gl_viewpointsComposite);

		viewpointsTree = new Tree(viewpointsComposite, SWT.BORDER);
		viewpointsTree.setToolTipText("The available viewpoints (diagram families)\n  and their representations (diagram types)\\nBold for selected representation.\nWhite background for selectable representations.\nItalics for no possible URI compatibility.");
		viewpointsTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Composite representationDiagramNameComposite = new Composite(representationComposite, SWT.NONE);
		representationDiagramNameComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_representationDiagramNameComposite = new GridLayout(2, false);
		gl_representationDiagramNameComposite.marginWidth = 0;
		representationDiagramNameComposite.setLayout(gl_representationDiagramNameComposite);

		representationDiagramNameLabel = new Label(representationDiagramNameComposite, SWT.NONE);
		representationDiagramNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		representationDiagramNameLabel.setSize(81, 25);
		representationDiagramNameLabel.setText("Representation Name:");

		representationDiagramNameText = new Text(representationDiagramNameComposite, SWT.BORDER);
		representationDiagramNameText.setText(representationDiagramName);
		representationDiagramNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		descriptionText = new Text(representationSash, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		descriptionText.setBackground(getWhiteBackground());
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite modelsComposite = new Composite(overallSash, SWT.BORDER);
		modelsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_modelsComposite = new GridLayout(2, false);
		gl_modelsComposite.horizontalSpacing = 0;
		gl_modelsComposite.marginWidth = 0;
		gl_modelsComposite.marginHeight = 0;
		modelsComposite.setLayout(gl_modelsComposite);

		Composite modelsElementsComposite = new Composite(modelsComposite, SWT.NONE);
		modelsElementsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_modelsElementsComposite = new GridLayout(3, false);
		gl_modelsElementsComposite.verticalSpacing = 2;
		gl_modelsElementsComposite.marginWidth = 0;
		gl_modelsElementsComposite.marginHeight = 0;
		modelsElementsComposite.setLayout(gl_modelsElementsComposite);

		Composite modelElementsBannerComposite = new Composite(modelsElementsComposite, SWT.NONE);
		modelElementsBannerComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		modelElementsBannerComposite.setLayout(new GridLayout(2, false));

		Label modelsElementsLabel = new Label(modelElementsBannerComposite, SWT.NONE);
		modelsElementsLabel.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.BOLD)));
		modelsElementsLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		modelsElementsLabel.setText("Model(s) Elements Selector");
		new Label(modelElementsBannerComposite, SWT.NONE);

		showAllElementsCheckButton = new Button(modelsElementsComposite, SWT.CHECK);
		showAllElementsCheckButton.setText("Show All");
		new Label(modelsElementsComposite, SWT.NONE);

		modelsElementsTree = new Tree(modelsElementsComposite, SWT.BORDER | SWT.CHECK | SWT.MULTI);
		GridData gd_modelsElementsTree = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_modelsElementsTree.minimumHeight = 100;
		modelsElementsTree.setLayoutData(gd_modelsElementsTree);
		modelsElementsTree.setBounds(0, 0, 94, 94);
		modelsElementsTree.setToolTipText("Select from the models to be diagrammed\n  and their contained contents\nSelected root element in bold.\nNot-compatible representations in italics.");

		TreeItem treeItem = new TreeItem(modelsElementsTree, SWT.NONE);
		treeItem.setText("Initializing Model Elements ...");

		Composite modelButtons = new Composite(modelsComposite, SWT.NONE);
		modelButtons.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		modelButtons.setLayout(new GridLayout(1, false));

		checkAllButton = new Button(modelButtons, SWT.NONE);
		checkAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		checkAllButton.setText("Check All");
		checkAllButton.setToolTipText("Check all model elements transitively contained by the selected root model element.");

		uncheckAllButton = new Button(modelButtons, SWT.NONE);
		uncheckAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		uncheckAllButton.setText("Uncheck All");
		uncheckAllButton.setToolTipText("Uncheck all model elements transitively contained by the selected root model element.");

		expandAllButton = new Button(modelButtons, SWT.NONE);
		expandAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		expandAllButton.setText("Expand All");
		expandAllButton.setToolTipText("Expand all model elements transitively contained by the selected root model element.");

		collapseAllButton = new Button(modelButtons, SWT.NONE);
		collapseAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		collapseAllButton.setText("Collapse All");
		collapseAllButton.setToolTipText("Collapse all model elements transitively contained by the selected root model element.");

		overallSash.setWeights(new int[] {1, 1});
		representationSash.setWeights(new int[] {2, 1});

		resetRepresentationDescriptionSelection();
	//	printSelectedRepresentation();
	//	printSelectedRootModelElement();

		refreshRepresentationFileName();
		refreshViewpoints();
		refreshViewpointsRendering();
		refreshModelElements();
		refreshModelElementsRendering();
		//
		//	Add listeners once content stable
		//
		sharedRepresentationFileCheckButton.addSelectionListener(new SharedRepresentationSelectionListener());
		showAllViewpointsCheckButton.addSelectionListener(new ShowAllViewpointsSelectionListener());
		representationFileNameText.addModifyListener(new RepresentationFileNameTextModifyListener());
		viewpointsTree.addSelectionListener(new ViewpointsTreeSelectionListener());
		representationDiagramNameText.addModifyListener(new RepresentationDiagramNameTextModifyListener());
		showAllElementsCheckButton.addSelectionListener(new ShowAllElementsSelectionListener());
		modelsElementsTree.addMouseListener(new ModelElementsTreeMouseListener());
		modelsElementsTree.addSelectionListener(new ModelElementsTreeSelectionListener());
		modelsElementsTree.addTreeListener(new ModelElementsTreeListener());
		checkAllButton.addSelectionListener(new CheckAllElementsSelectionListener(true));
		uncheckAllButton.addSelectionListener(new CheckAllElementsSelectionListener(false));
		expandAllButton.addSelectionListener(new ExpandAllElementsSelectionListener(true));
		collapseAllButton.addSelectionListener(new ExpandAllElementsSelectionListener(false));
		return container;
	}

	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources());
	}

	protected @NonNull Map<@NonNull EObject, @NonNull Set<@NonNull Notifier>> gatherAncestralModelElements(@NonNull Iterable<@NonNull EObject> rootableEObjects) {
		Set<@NonNull Notifier> allAncestralModelElements = new HashSet<>();
		Map<@NonNull EObject, @NonNull Set<@NonNull Notifier>> rootableEObjects2ancestralModelElements = new HashMap<>();
		rootableEObjects2ancestralModelElements.put(noSelectedEObject, allAncestralModelElements);
		for (EObject rootableEObject : rootableEObjects) {
			Set<@NonNull Notifier> ancestralModelElements = new HashSet<>();
			rootableEObjects2ancestralModelElements.put(rootableEObject, ancestralModelElements);
			Resource eResource = rootableEObject.eResource();
			if (eResource != null) {
				ancestralModelElements.add(eResource);
				allAncestralModelElements.add(eResource);
			}
			for (EObject eObject = rootableEObject; eObject != null; eObject = eObject.eContainer()) {
				ancestralModelElements.add(eObject);
				allAncestralModelElements.add(eObject);
			}
		}
		return rootableEObjects2ancestralModelElements;
	}

	protected @NonNull Set<@NonNull EClass> gatherCheckedEClasses() {
		Set<@NonNull EClass> checkedEClasses = new HashSet<>();
		for (EObject eObject : checkedModelElements) {
			EClass eClass = eObject.eClass();
			assert eClass != null;
			checkedEClasses.add(eClass);
		}
		return checkedEClasses;
	}

protected @NonNull Map<@NonNull String, @NonNull Set<@NonNull EObject>> gatherCompatibleEObjects(@NonNull Set<@NonNull EObject> rootableEObjects) {
		Map<@NonNull String, @NonNull Set<@NonNull EObject>> rootableDomainClass2EObjects = new HashMap<>();
		for (EObject eObject : rootableEObjects) {
			EClass eClass = eObject.eClass();
			String domainClass = getDomainClass(eClass);
		//	if (rootableDomainClasses.contains(domainClass)) {
				Set<@NonNull EObject> rootableEObjects2 = rootableDomainClass2EObjects.get(domainClass);
				if (rootableEObjects2 == null) {
					rootableEObjects2 = new HashSet<>();
					rootableDomainClass2EObjects.put(domainClass, rootableEObjects2);
				}
				rootableEObjects2.add(eObject);
		//	}
		}
		return rootableDomainClass2EObjects;
	}

/*	protected @NonNull Set<@NonNull String> gatherRootableDomainClasses(@NonNull Iterable<@NonNull Viewpoint> viewpoints) {
		Set<@NonNull String> rootDomainClasses = new HashSet<>();
		for (Viewpoint viewpoint : viewpoints) {
			for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				assert representationDescription != null;
				String domainClass = getDomainClass(representationDescription);
				rootDomainClasses.add(domainClass);
			}
		}
		return rootDomainClasses;
	} */

	protected @NonNull Map<@NonNull String, @NonNull Set<@NonNull String>> gatherDomainClasses(@NonNull Iterable<@NonNull Viewpoint> viewpoints) {
		Map<@NonNull String, @NonNull Set<@NonNull String>> rootableDomainClass2domainClasses = new HashMap<>();
		for (Viewpoint viewpoint : viewpoints) {
			for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				assert representationDescription != null;
				String domainClass = getDomainClass(representationDescription);
				Set<@NonNull String> domainClasses = new HashSet<>();
			//	domainClasses.add(domainClass);
				rootableDomainClass2domainClasses.put(domainClass, domainClasses);
				gatherDomainClasses(representationDescription, domainClasses);
			}
		}
		return rootableDomainClass2domainClasses;
	}

/*	protected @NonNull Map<@NonNull String, @NonNull Set<@NonNull String>> gatherDomainClasses(@NonNull RepresentationDescription representationDescription) {
		Map<@NonNull String, @NonNull Set<@NonNull String>> selectedRootableDomainClass2domainClasses = new HashMap<>();
		Set<@NonNull String> domainClasses = new HashSet<>();
		selectedRootableDomainClass2domainClasses.put(getDomainClass(representationDescription), domainClasses);
		gatherDomainClasses(representationDescription, domainClasses);
		return selectedRootableDomainClass2domainClasses;
	} */

	protected void gatherDomainClasses(@NonNull RepresentationDescription representationDescription, @NonNull Set<@NonNull String> domainClasses) {
		DiagramDescription diagramDescription;
		if (representationDescription instanceof DiagramImportDescription) {
			diagramDescription = ((DiagramImportDescription)representationDescription).getImportedDiagram();
		}
		else if (representationDescription instanceof DiagramDescription) {
			diagramDescription = (DiagramDescription)representationDescription;
		}
		else {
			throw new UnsupportedOperationException("Unknown RepresentationDescription: " + representationDescription.getClass().getName());
		}
		String domainClass = diagramDescription.getDomainClass();
		if (domainClass != null) {
			domainClasses.add(domainClass);
		}
		gatherDomainClassesForContainerMapping(diagramDescription.getContainerMappings(), domainClasses);
		gatherDomainClassesForNodeMapping(diagramDescription.getNodeMappings(), domainClasses);
	//	gatherDomainClassesForNodeMapping(diagramDescription.getReusedMappings(), domainClasses);
		Layer layer = diagramDescription.getDefaultLayer();
		if (layer != null) {
			gatherDomainClassesForContainerMapping(layer.getContainerMappings(), domainClasses);
			gatherDomainClassesForNodeMapping(layer.getNodeMappings(), domainClasses);
		//	gatherDomainClassesForNodeMapping(layer.getReusedMappings(), domainClasses);
		}
	}

	protected void gatherDomainClassesForContainerMapping(Iterable<ContainerMapping> containerMappings, @NonNull Set<@NonNull String> domainClasses) {
		for (ContainerMapping containerMapping : containerMappings) {
			String domainClass = containerMapping.getDomainClass();
			if (domainClass != null) {
				domainClasses.add(domainClass);
			}
			gatherDomainClassesForNodeMapping(containerMapping.getBorderedNodeMappings(), domainClasses);
			gatherDomainClassesForNodeMapping(containerMapping.getReusedBorderedNodeMappings(), domainClasses);
			gatherDomainClassesForContainerMapping(containerMapping.getReusedContainerMappings(), domainClasses);
			gatherDomainClassesForNodeMapping(containerMapping.getReusedNodeMappings(), domainClasses);
			gatherDomainClassesForContainerMapping(containerMapping.getSubContainerMappings(), domainClasses);
			gatherDomainClassesForNodeMapping(containerMapping.getSubNodeMappings(), domainClasses);
		}
	}

	protected void gatherDomainClassesForNodeMapping(Iterable<NodeMapping> nodeMappings, @NonNull Set<@NonNull String> domainClasses) {
		for (NodeMapping nodeMapping : nodeMappings) {
			String domainClass = nodeMapping.getDomainClass();
			if (domainClass != null) {
				domainClasses.add(domainClass);
			}
			gatherDomainClassesForNodeMapping(nodeMapping.getBorderedNodeMappings(), domainClasses);
			gatherDomainClassesForNodeMapping(nodeMapping.getReusedBorderedNodeMappings(), domainClasses);
		}
	}

/*	protected void gatherExpandedElements(@NonNull TreeItem[] treeItems, @NonNull Set<Object> expanded) {
		for (TreeItem item : treeItems) {
			if (item.getExpanded()) {
				expanded.add(item.getData());
			}
			gatherExpandedElements(item.getItems(), expanded);
		}
	} */

	protected @NonNull Set<@NonNull Object> gatherInitialExpansions(@NonNull Iterable<@NonNull EObject> rootableEObjects) {
		Set<@NonNull Object> initialExpansions = new HashSet<>();
		for (EObject rootableEObject : rootableEObjects) {
			for (EObject eObject = rootableEObject; (eObject = eObject.eContainer()) != null; ) {
				initialExpansions.add(eObject);
				Resource eResource = eObject.eResource();
				if (eResource != null) {
					initialExpansions.add(eResource);
				}
			}
		}
		return initialExpansions;
	}

	protected @NonNull Map<@NonNull Viewpoint, @NonNull List<@NonNull RepresentationDescription>> gatherRepresentationDescriptions() {
		List<@NonNull Viewpoint> viewpoints = new ArrayList<>();
		ViewpointRegistry instance = ViewpointRegistry.getInstance();
		for (Viewpoint viewpoint : instance.getViewpoints()) {
			assert viewpoint != null;
			viewpoints.add(viewpoint);
		}
		Map<@NonNull Viewpoint, @NonNull List<@NonNull RepresentationDescription>> viewpoint2representationDescriptions = new HashMap<>();
		for (Viewpoint viewpoint : viewpoints) {
			List<@NonNull RepresentationDescription> representationDescriptions = new ArrayList<>();
			viewpoint2representationDescriptions.put(viewpoint, representationDescriptions);
			for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				assert representationDescription != null;
				representationDescriptions.add(representationDescription);
			}
			Collections.sort(representationDescriptions, representationDescriptorComparator);
		}
		return viewpoint2representationDescriptions;
	}

	/*	protected @NonNull Set<@NonNull EClass> gatherCheckedEClasses() {
			Set<@NonNull EClass> selectedEClasses = new HashSet<>();
			gatherCheckedEClasses(modelsElementsTree.getItems(), selectedEClasses);
			return selectedEClasses;
		}

		protected void gatherCheckedEClasses(TreeItem[] items, Set<EClass> eClasses) {
			for (TreeItem item : items) {
				Object object = item.getData();
				if ((object instanceof EObject) && item.getChecked()) {
					EClass eClass = ((EObject)object).eClass();
					eClasses.add(eClass);
				}
				gatherCheckedEClasses(item.getItems(), eClasses);
			}
		} */

		/*	protected @NonNull Set<@NonNull EClass> gatherRootableEClasses(@NonNull Set<@NonNull EObject> rootableEObjects2) {
		/ *	Map<@NonNull EClass, @NonNull String> eClass2domainClass = new HashMap<>();
			Set<@NonNull EClass> rootableEClasses = new HashSet<>();
			for (Resource resource : resource2elements.keySet()) {
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					EClass eClass = eObject.eClass();
					if (!eClass2domainClass.containsKey(eClass)) {
						String domainClass = getDomainClass(eClass);
						eClass2domainClass.put(eClass, domainClass);
						if (rootableDomainClasses.contains(domainClass)) {
							rootableEClasses.add(eClass);
						}
					}
				}
			}
			return rootableEClasses; * /
			Set<@NonNull EClass> rootableEClasses = new HashSet<>();
			for (EObject eObject : rootableEObjects2) {
				EClass eClass = eObject.eClass();
				rootableEClasses.add(eClass);
			}
			return rootableEClasses;
		} */

	/*	protected void zzgatherCheckedElements(@NonNull TreeItem treeItem, @NonNull List<@NonNull EObject> selectedElements) {
			if (treeItem.getChecked()) {
				Object data = treeItem.getData();
				if (data instanceof EObject) {
					selectedElements.add((EObject)data);
				}
			}
			for (TreeItem childItem : treeItem.getItems()) {
				zzgatherCheckedElements(childItem, selectedElements);
			}
		} */

		/*	protected @NonNull Set<@NonNull EClass> gatherRootableEClasses(@NonNull Set<@NonNull EObject> rootableEObjects2) {
		/ *	Map<@NonNull EClass, @NonNull String> eClass2domainClass = new HashMap<>();
			Set<@NonNull EClass> rootableEClasses = new HashSet<>();
			for (Resource resource : resource2elements.keySet()) {
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					EClass eClass = eObject.eClass();
					if (!eClass2domainClass.containsKey(eClass)) {
						String domainClass = getDomainClass(eClass);
						eClass2domainClass.put(eClass, domainClass);
						if (rootableDomainClasses.contains(domainClass)) {
							rootableEClasses.add(eClass);
						}
					}
				}
			}
			return rootableEClasses; * /
			Set<@NonNull EClass> rootableEClasses = new HashSet<>();
			for (EObject eObject : rootableEObjects2) {
				EClass eClass = eObject.eClass();
				rootableEClasses.add(eClass);
			}
			return rootableEClasses;
		} */

		protected @NonNull Set<@NonNull EObject> gatherRootableEObjects(@NonNull Set<@NonNull String> rootableDomainClasses) {
			@NonNull Set<@NonNull EObject> rootableEObjects = new HashSet<>();
			for (Resource resource : resource2elements.keySet()) {
				for (EObject eObject : resource.getContents()) {
					gatherRootableEObjects1(eObject, rootableDomainClasses, rootableEObjects);
				}
			}
			return rootableEObjects;
		}

	private void gatherRootableEObjects1(@NonNull EObject eObject, @NonNull Set<@NonNull String> rootableDomainClasses, @NonNull Set<@NonNull EObject> rootableEObjects) {
		EClass eClass = eObject.eClass();
		String domainClass = getDomainClass(eClass);
		if (rootableDomainClasses.contains(domainClass)) {
			rootableEObjects.add(eObject);
		}
		for (EObject childEObject : eObject.eContents()) {
			assert childEObject != null;
			gatherRootableEObjects1(childEObject, rootableDomainClasses, rootableEObjects);
		}
	}

	protected @NonNull Map<@NonNull EObject, @NonNull Set<@NonNull EObject>> gatherRootableEObject2checkableEObjects(@NonNull Set<@NonNull EObject> rootableEObjects) {
		Map<@NonNull EObject, @NonNull Set<@NonNull EObject>> rootableEObject2checkableEObjects = new HashMap<>();
		Set<@NonNull EObject> allCheckableEObjects = new HashSet<>();
		rootableEObject2checkableEObjects.put(noSelectedEObject, allCheckableEObjects);
		for (EObject eObject : rootableEObjects) {
			Set<@NonNull EObject> checkableEObjects = new HashSet<>();
			EClass eClass = eObject.eClass();
			String domainClass = getDomainClass(eClass);
			Set<@NonNull String> domainClasses = allRootableDomainClass2domainClasses.get(domainClass);
			assert domainClasses != null;
			rootableEObject2checkableEObjects.put(eObject, checkableEObjects);
			gatherRootableEObject2checkableEObjects2(eObject, domainClasses, checkableEObjects);
			allCheckableEObjects.addAll(checkableEObjects);
		}
		return rootableEObject2checkableEObjects;
	}

	/*	private void gatherRootableEObject2checkableEObjects1(@NonNull EObject parentEObject, @NonNull Set<@NonNull String> rootableDomainClasses, @NonNull Map<@NonNull EObject, Set<@NonNull EObject>> rootableEObject2checkableEObjects) {
		for (EObject eObject : parentEObject.eContents()) {
			EClass eClass = eObject.eClass();
			String domainClass = getDomainClass(eClass);
			if (!rootableDomainClasses.contains(domainClass)) {
				gatherRootableEObject2checkableEObjects1(eObject, rootableDomainClasses, rootableEObject2checkableEObjects);
			}
			else {
				Set<@NonNull EObject> checkableEObjects = new HashSet<>();
				rootableEObject2checkableEObjects.put(eObject, checkableEObjects);
				gatherRootableEObject2checkableEObjects2(eObject, checkableEObjects);
			}
		}
	} */
	private void gatherRootableEObject2checkableEObjects2(@NonNull EObject checkableEObject, @NonNull Set<@NonNull String> checkableDomainClasses, @NonNull Set<@NonNull EObject> checkableEObjects) {
		EClass eClass = checkableEObject.eClass();
		String domainClass = getDomainClass(eClass);
		if (checkableDomainClasses.contains(domainClass)) {
			checkableEObjects.add(checkableEObject);
			for (EObject eObject : checkableEObject.eContents()) {
				assert eObject != null;
				gatherRootableEObject2checkableEObjects2(eObject, checkableDomainClasses, checkableEObjects);
			}
		}
	}

	protected @NonNull String getDomainClass(EClass eClass) {
		return eClass.getEPackage().getName() + "." + eClass.getName();
	}

	protected @NonNull String getDomainClass(@NonNull RepresentationDescription representationDescription) {
		DiagramDescription diagramDescription;
		if (representationDescription instanceof DiagramImportDescription) {
			diagramDescription = ((DiagramImportDescription)representationDescription).getImportedDiagram();
		}
		else if (representationDescription instanceof DiagramDescription) {
			diagramDescription = (DiagramDescription)representationDescription;
		}
		else {
			throw new UnsupportedOperationException("Unknown RepresentationDescription: " + representationDescription.getClass().getName());
		}
		String domainClass = diagramDescription.getDomainClass();
		assert domainClass != null;
		return domainClass;
	}

	protected Map.@NonNull Entry<@NonNull String, @NonNull Set<@NonNull String>> getDomainClasses(@NonNull RepresentationDescription representationDescription) {
		String domainClass = getDomainClass(representationDescription);
		Set<@NonNull String> domainClasses = allRootableDomainClass2domainClasses.get(domainClass);
		assert domainClasses != null;
		return new MapOfSetEntry<@NonNull String>(domainClass, domainClasses);
	}

	protected Color getGreyBackground() {
		return representationDiagramNameLabel.getBackground();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(800, 800);
	}

	public RepresentationDescription getRegistryRepresentationDescription() {
	;;	assert getShell() == null;
		return selectedRepresentationDescription;
	}

	public String getRepresentationDiagramName() {
	//	assert getShell() == null;
		return representationDiagramName;
	}

	public @NonNull URI getRepresentationFileURI() {
		assert representationFileURI != null;
		return representationFileURI;
	}

	protected @NonNull String getSafeLabel(@NonNull RepresentationDescription representationDescription) {
		String label = representationDescription.getLabel();
		return label != null ? label : "";
	}

	protected @NonNull String getSafeNsURI(@NonNull EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		return nsURI != null ? nsURI : "";
	}

	protected @NonNull String getSafeLabel(@NonNull Viewpoint viewpoint) {
		String label = viewpoint.getLabel();
		return label != null ? label : "";
	}

	public @NonNull List<@NonNull URI> getSelectedCheckedElements() {
		assert getShell() == null;
		List<@NonNull URI> selectedCheckedElements = new ArrayList<>();
		if (selectedRootModelElement != noSelectedEObject) {
			selectedCheckedElements.add(EcoreUtil.getURI(selectedRootModelElement));
			getSelectedCheckedElements(selectedRootModelElement, selectedCheckedElements);
		}
		return selectedCheckedElements;
	}

	protected void getSelectedCheckedElements(@NonNull EObject eObject, @NonNull List<@NonNull URI> selectedCheckedElements) {
		for (EObject eChild : eObject.eContents()) {
			assert eChild != null;
			if (checkedModelElements.contains(eChild)) {
				selectedCheckedElements.add(EcoreUtil.getURI(eChild));
			}
			getSelectedCheckedElements(eChild, selectedCheckedElements);
		}
	}

	public @NonNull URI getSessionURI() {
	//	assert getShell() == null;
		return modelURI.trimSegments(1).appendSegment(ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME);
	}

	protected Color getWhiteBackground() {
		return viewpointsTree.getBackground();
	}

	protected boolean hasModelURI(@NonNull RepresentationDescription representationDescription) {
		for (EPackage metamodel : representationDescription.getMetamodel()) {
			assert metamodel != null;
			String nsURI = getSafeNsURI(metamodel);
			if (modelURIs.contains(nsURI)) {
				return true;
			}
		}
		return false;
	}

	protected void printAllModelElements() {
		ModelElementDepthComparator modelElementDepthComparator = new ModelElementDepthComparator(labelProvider);
		StringBuilder s = new StringBuilder();
		s.append("allRootableEObject2checkableEObjects =");
		List<@NonNull EObject> allRootableEObjects = new ArrayList<>(allRootableEObject2checkableEObjects.keySet());
		Collections.sort(allRootableEObjects, modelElementDepthComparator);
		for (Object modelElement : allRootableEObjects) {
			s.append("\n  " + labelProvider.getText(modelElement));
		//	EClass eClass = ((EObject)modelElement).eClass();
		//	s.append(" => " + getDomainClass(eClass));
			List<@NonNull EObject> checkableEObjects = new ArrayList<>(allRootableEObject2checkableEObjects.get(modelElement));
			Collections.sort(checkableEObjects, modelElementDepthComparator);
			for (Object checkableEObject : checkableEObjects) {
				s.append("\n    " + labelProvider.getText(checkableEObject));
			//	eClass = ((EObject)checkableEObject).eClass();
			//	s.append(" => " + getDomainClass(eClass));
			}
		}
		s.append("\nallRootableEObject2ancestralModelElements =");
		ArrayList<@NonNull EObject> modelElements = new ArrayList<>(allRootableEObject2ancestralModelElements.keySet());
		Collections.sort(modelElements, modelElementDepthComparator);
		for (@NonNull EObject modelElement : modelElements) {
			s.append("\n  " + labelProvider.getText(modelElement));
			if (!(modelElement instanceof NoSelectedEObject)) {
				EClass eClass = modelElement.eClass();
				s.append(" => " + getDomainClass(eClass));
			}
			List<@NonNull Notifier> ancestralModelElements = new ArrayList<>(allRootableEObject2ancestralModelElements.get(modelElement));
			Collections.sort(ancestralModelElements, modelElementDepthComparator);
			for (@NonNull Notifier ancestralModelElement : ancestralModelElements) {
				s.append("\n    " + labelProvider.getText(ancestralModelElement));
			}
		}
		System.out.println(s.toString());
	}

	protected void printAllRepresentations() {
		StringBuilder s = new StringBuilder();
		List<@NonNull Viewpoint> viewpoints = new ArrayList<>(allViewpoint2representationDescriptions.keySet());
		Collections.sort(viewpoints, viewpointComparator);
		s.append("allViewpoint2representationDescriptions =");
		for (@NonNull Viewpoint viewpoint : viewpoints) {
			s.append("\n  ");
			s.append(viewpoint.getLabel());
			List<@NonNull RepresentationDescription> representationDescriptions = allViewpoint2representationDescriptions.get(viewpoint);
			assert representationDescriptions != null;
			for (@NonNull RepresentationDescription representationDescription : representationDescriptions) {
				String domainClass = getDomainClass(representationDescription);
				s.append("\n    " + representationDescription.getLabel() + " => " + domainClass);
			}
		}
		System.out.println(s.toString());
	}

	protected void printSelectedRepresentation() {
		StringBuilder s = new StringBuilder();
		RepresentationDescription selectedRepresentationDescription2 = selectedRepresentationDescription;
		Map.Entry<@NonNull String, @NonNull Set<@NonNull String>> entry = selectedRootableDomainClass2domainClasses;
		if (selectedRepresentationDescription2 == null) {
			assert entry == emptyString2StringsEntry;
			s.append("selectedRepresentationDescription = null");
			s.append("\n  domainClass = null");
		}
		else {
			String domainClass = getDomainClass(selectedRepresentationDescription2);
			assert entry != emptyString2StringsEntry;
			assert entry.getKey() == domainClass;
			s.append("selectedRepresentationDescription = " + selectedRepresentationDescription2.getLabel());
			s.append("\n  domainClass = " + domainClass);
			s.append("\n  selectedRootableDomainClass2domainClasses =");
			s.append("\n    " + entry.getKey() + " :");
			for (@NonNull String domainClass2 : entry.getValue()) {
				s.append(" " + domainClass2);
			}
		}
		System.out.println(s.toString());
	}

	protected void printSelectedRootModelElement() {
		StringBuilder s = new StringBuilder();
		s.append("selectedRootModelElement = " + labelProvider.getText(selectedRootModelElement));
	/*	s.append("\n  selectedAncestralModelElements =");
		ArrayList<@NonNull Notifier> selectedAncestralModelElements = new ArrayList<>(this.selectedAncestralModelElements);
		Collections.sort(selectedAncestralModelElements, new LabelProviderComparator(labelProvider));
		for (Notifier notifier : selectedAncestralModelElements) {
			s.append("\n    " + labelProvider.getText(notifier));
		} */
	//	for (Map.Entry<@NonNull EObject, @NonNull Set<@NonNull EObject>> entry : selectedRootableEObject2checkableEObjects.entrySet()) {
	//	if (selectedRootableEObject2checkableEObjects != emptyEObject2EObjectsEntry) {
	//	Set<@NonNull EObject> checkableEObjects = selectableRootableEObject2checkableEObjects.get(selectedRootModelElement2);
	//	if (checkableEObjects != null) {
		//	EObject selectedRootableEObject = selectedRootModelElement2; //selectedRootableEObject2checkableEObjects.getKey();
		//	Set<@NonNull EObject> selectedCheckableEObjects = checkableEObjects; //selectedRootableEObject2checkableEObjects.getValue();
			s.append("\nselectableRootableEObject2checkableEObjects =");
		//	s.append("\n  " + (selectedRootableEObject == nullEObject ? selectedRootableEObject.toString() : labelProvider.getText(selectedRootableEObject)));
			for (@NonNull EObject rootableEObject : selectableRootableEObject2checkableEObjects.keySet()) {
				s.append("\n  " + /*(rootableEObject instanceof NoSelectedEObject ? rootableEObject.toString() :*/ labelProvider.getText(rootableEObject)/*)*/);
				Set<@NonNull EObject> checkableEObjects = selectableRootableEObject2checkableEObjects.get(rootableEObject);
				assert checkableEObjects != null;
				for (@NonNull EObject eObject : checkableEObjects) {
					s.append("\n    " + labelProvider.getText(eObject));
				}
			}
	//	}
		System.out.println(s.toString());
	}

	protected void refreshDescription() {
		StringBuilder s = new StringBuilder();
		for (TreeItem item : viewpointsTree.getSelection()) {
			if (s.length() > 0) {
				s.append("\n==================\n");
			}
			String documentation = null;
			Object data = item.getData();
			if (data instanceof Viewpoint) {
				Viewpoint viewpoint = (Viewpoint)data;
				s.append("*.");
				s.append(viewpoint.getModelFileExtension());
				s.append(" => ");
				s.append(viewpoint.eResource().getURI());
				s.append("\n-----------------\n");
				documentation = viewpoint.getEndUserDocumentation();
			}
			else if (data instanceof RepresentationDescription) {
				RepresentationDescription representationDescription = (RepresentationDescription)data;
				s.append("metamodel(s):");
				for (EPackage metamodel : representationDescription.getMetamodel()) {
					assert metamodel != null;
					String nsURI = getSafeNsURI(metamodel);
					s.append(" ");
					s.append(nsURI);
				}
				s.append("\n-----------------\n");
				documentation = representationDescription.getEndUserDocumentation();
			}
			if ((documentation == null) || documentation.trim().isEmpty()) {
				documentation = "<No end user documentation>";
			}
			s.append(documentation);
		}
		descriptionText.setText(s.toString());
	}

	protected @Nullable String refreshDiagramNames() {
		if (oldDiagramNames == null) {
			URI uri = getRepresentationFileURI();
			AIRDReader airdReader = new AIRDReader();
			if (URIConverter.INSTANCE.exists(uri, null)) {
				try {
					InputStream inputStream = URIConverter.INSTANCE.createInputStream(uri);
					SAXParserFactory factory = SAXParserFactory.newInstance();
					try {
						SAXParser saxParser = factory.newSAXParser();
						try {
							assert saxParser != null;
							saxParser.parse(inputStream, airdReader);
							oldDiagramNames = airdReader.getDiagramNames();
						} catch (IOException e) {
							return "Failed to read " + uri.toString() + "\n" + e.getLocalizedMessage();
						} catch (SAXException e) {
							return "Failed to parse " + uri.toString() + "\n" + e.getLocalizedMessage();
						}
					} catch (ParserConfigurationException | SAXException e) {
						return "Failed to prepare SAXParser\n" + e.getLocalizedMessage();
					}
				} catch (IOException e) {
					return "Failed to open " + uri.toString() + "\n" + e.getLocalizedMessage();
				}
			}
			else {
				oldDiagramNames = null;
			}
		}
		return null;
	}

	protected void refreshMessage(@Nullable String problemMessage) {
		refreshDescription();
		String warningMessage = null;
		String errorMessage = refreshDiagramNames();
		String representationDiagramName = representationDiagramNameText.getText();
		List<@NonNull String> oldDiagramNames2 = oldDiagramNames;
		if (errorMessage != null) {
		//	assert ;
		}
		else if ((oldDiagramNames2 != null) && oldDiagramNames2.contains(representationDiagramName)) {
			StringBuilder s = new StringBuilder();
			for (String name : oldDiagramNames2) {
				s.append(" \"" + name + "\"");
			}
			errorMessage = "Diagram name \"" + representationDiagramName + "\" is already in use.\nSelect a name other than: " + s.toString();
		}
		else if (selectedRepresentationDescription == null) {
			errorMessage = "No representation description selected.\nSelect a white-background representation in the Diagram Representation Selector.";
		}
		else if (selectedRootModelElement == noSelectedEObject) {
			errorMessage = "No root model element selected.\nSelect a white-background model element in the Model(s) Elements Selector.";
		}
	/*	else {
			List<EObject> selectedElements = basicGetSelectedElements();
			if (selectedElements.isEmpty()) {
				warningMessage = "No model elements selected.\nCheck at least one non-root element in the Model(s) Elements tree.";
			}
		} */
		if ((errorMessage == null) && (warningMessage == null)) {
			Set<EClass> selectedEClasses = gatherCheckedEClasses();
		//	gatherCheckedEClasses(modelsElementsTree.getItems(), selectedEClasses);
			for (TreeItem rootTreeItem : viewpointsTree.getItems()) {
				for (TreeItem treeItem : rootTreeItem.getItems()) {
					if (treeItem.getChecked()) {
						RepresentationDescription representationDescription = (RepresentationDescription)treeItem.getData();
						assert representationDescription != null;
						Set<@NonNull String> designDomainClasses = getDomainClasses(representationDescription).getValue();
						List<String> missingDomainClasses = computeMissingDomainClasses(selectedEClasses, designDomainClasses);
						if (missingDomainClasses != null) {
							Collections.sort(missingDomainClasses);
							StringBuilder s = new StringBuilder();
							s.append("Model element(s) from the following classes without design support are ignored:");
							 for (String domainClass : missingDomainClasses) {
								s.append(" ");
								s.append(domainClass);
							}
							warningMessage = s.toString();
						}
					}
				}
			}

		}
		okButton.setEnabled(errorMessage == null);
		if (errorMessage != null) {
			setErrorMessage(errorMessage);
		}
		else {
			setErrorMessage(null);
			if (warningMessage != null) {
				setMessage(warningMessage, IMessageProvider.WARNING);
			}
			else {
			//	setMessage("Select a diagram representation, then select a corresponding root model element\nthen check the models elements with which to initialize the diagram.");
				setMessage("Check the models elements with which to initialize the diagram.");
			}
		}
		if (problemMessage != null) {
			statusText.setText(problemMessage);
		}
		else {
			statusText.setText("");
		}
	}

	protected void refreshModelElements(/*@Nullable Set<Object> expanded*/) {
	//	if (expanded == null) {
	//		expanded = expandedModelElements;
	//	}
		for (TreeItem item : modelsElementsTree.getItems()) {
			item.dispose();
		}
		for (Resource resource : resource2elements.keySet()) {
			Image image = labelProvider.getImage(resource);
			String text = labelProvider.getText(resource);
			TreeItem rootTreeItem = new TreeItem(modelsElementsTree, SWT.NONE);
			rootTreeItem.setImage(image);
			rootTreeItem.setText(text);
			rootTreeItem.setData(resource);
			rootTreeItem.setBackground(getGreyBackground());
		//	setFont(rootTreeItem, SWT.ITALIC);
			Set<@NonNull EObject> explicit = new HashSet<>(resource2elements.get(resource));
			for (EObject eObject : resource.getContents()) {
				refreshModelElements(rootTreeItem, eObject, explicit);
			}
			rootTreeItem.setExpanded(expandedModelElements.contains(resource));
		}
	}

	protected void refreshModelElements(@NonNull TreeItem parentTreeItem, @NonNull EObject eObject, Set<@NonNull EObject> explicit) {
		boolean showAllElements = showAllElementsCheckButton.getSelection();
		Set<@NonNull Notifier> ancestralModelElements = allRootableEObject2ancestralModelElements.get(selectedRootModelElement);
		assert ancestralModelElements != null;
		boolean isAncestral = ancestralModelElements.contains(eObject);
	//	boolean isCheckable = selectedRootableEObject2checkableEObjects.getValue().contains(eObject);
		Set<@NonNull EObject> checkableEObjects = selectableRootableEObject2checkableEObjects.get(selectedRootModelElement);
	//	assert checkableEObjects != null;
		boolean isCheckable = (checkableEObjects != null) && (checkableEObjects.contains(eObject));
		boolean isRootable = selectableRootableEObject2checkableEObjects.containsKey(eObject);
		if (showAllElements || isCheckable || isRootable || isAncestral) {
			Image image = labelProvider.getImage(eObject);
			String text = labelProvider.getText(eObject);
			TreeItem treeItem = new TreeItem(parentTreeItem, SWT.NONE);
			treeItem.setImage(image);
			treeItem.setText(text);
			treeItem.setChecked(explicit.contains(eObject));
			treeItem.setData(eObject);
			for (EObject childEObject : eObject.eContents()) {
				assert childEObject != null;
				refreshModelElements(treeItem, childEObject, explicit);
			}
		}
	}

	protected void refreshModelElementsRendering() {
		boolean isEnabled = selectedRootModelElement != noSelectedEObject;
		checkAllButton.setEnabled(isEnabled);
		checkAllButton.setGrayed(!isEnabled);
		collapseAllButton.setEnabled(isEnabled);
		collapseAllButton.setGrayed(!isEnabled);
		expandAllButton.setEnabled(isEnabled);
		expandAllButton.setGrayed(!isEnabled);
		uncheckAllButton.setEnabled(isEnabled);
		uncheckAllButton.setGrayed(!isEnabled);
		for (TreeItem rootItem : modelsElementsTree.getItems()) {
			rootItem.setGrayed(true);
			for (TreeItem item : rootItem.getItems()) {
				refreshModelElementsRendering(item, false);
				item.setGrayed(true);
			}
		}
	}

	protected void refreshModelElementsRendering(TreeItem treeItem, boolean parentCanCreate) {
		EObject eObject = (EObject)treeItem.getData();
//		EClass eClass = eObject.eClass();
//		String domainClass = getDomainClass(eClass);
//		boolean isCreateable = selectedDomainClasses.contains(domainClass);
//		boolean isRootable = selectedRootableDomainClasses.contains(domainClass);
//		boolean isAncestor = selectedAncestralModelElements.contains(eObject);

        RepresentationDescription selectedRepresentationDescription2 = selectedRepresentationDescription;
		boolean rootCreate = !parentCanCreate && DialectManager.INSTANCE.canCreate(eObject, selectedRepresentationDescription2, false);

		Set<@NonNull Notifier> ancestralModelElements = allRootableEObject2ancestralModelElements.get(selectedRootModelElement);
		assert ancestralModelElements != null;
		Set<@NonNull EObject> checkableModelElements = allRootableEObject2checkableEObjects.get(selectedRootModelElement);
		assert checkableModelElements != null;


//		boolean isSelected = false; //!parentCanCreate && (eObject == selectedRootModelElement);
//        DiagramDescription diagramDescription = (DiagramDescription)selectedRepresentationDescription;
//        boolean canCreate = parentCanCreate || DialectManager.INSTANCE.canCreate(eObject, selectedRepresentationDescription, false);
		Color background = getGreyBackground();
		boolean isBold = false;
		boolean isItalic = false;
	//	boolean isGrayed = false;
		boolean isChecked = (selectedRootModelElement == eObject) || checkedModelElements.contains(eObject);
		boolean isCheckable = false;
		if (selectedRepresentationDescription == null) {
		//	isCreateable = allDomainClasses.contains(domainClass);
		//	isRootable = allRootableDomainClasses.contains(domainClass);
		//	assert !isCreateable;
		//	assert !isSelected;
		//	isGrayed = true;
		}
		else if (selectedRootModelElement == noSelectedEObject) {
		//	assert isSelected == false;
		//	isBold = isSelected;
		//	isItalic = !isCreateable;
		//	if (domainClass.equals(getDomainClass(selectedRepresentationDescription2))) {
		//		background = getWhiteBackground();
		//	}
		//	boolean isAncestralEObject = selectedAncestralModelElements.contains(eObject);
		//	boolean isRootableEObject = selectedRootableEObjects.contains(eObject);
		//	EObject selectedRootableEObject = selectedRootableEObject2checkableEObjects.getKey();
		//	if (eObject == selectedRootableEObject) {
			if (selectableRootableEObject2checkableEObjects.containsKey(eObject)) {
				background = getWhiteBackground();
			} else {
				if (!ancestralModelElements.contains(eObject)) {
					isItalic = true;
				}
			}
		//	isGrayed = true;
		}
		else {
		//	boolean isSelected = false; //!parentCanCreate && (eObject == selectedRootModelElement);
		//	isBold = isSelected;
		//	boolean isAncestralEObject = selectedAncestralModelElements.contains(eObject);
		//	isItalic = !isCreateable;
			Set<@NonNull EObject> checkableEObjects = selectableRootableEObject2checkableEObjects.get(selectedRootModelElement);
			assert checkableEObjects != null;
			if (selectedRootModelElement == eObject) {
				isBold = true;
				background = getWhiteBackground();
			}
			else if (ancestralModelElements.contains(eObject)) {
		//		isGrayed = true;
			}
			else if (checkableEObjects.contains(eObject)) {
//	else if (selctedRootableEObject2checkableEObjects.getValue().contains(eObject)) {
				background = getWhiteBackground();
			}
			else if (selectableRootableEObject2checkableEObjects.containsKey(eObject)) { //.contains(eObject)) {
//	else if (selctedRootableEObject2checkableEObjects.getValue().contains(eObject)) {
				background = getWhiteBackground();
			}
			else /*if (isRootable && isCreateable)*/ {
				isItalic = true;
		//		isGrayed = true;
			}
		//	if (isSelected)
		/*	if (!selectedDomainClasses.contains(domainClass)) {
			}
			else if ((selectedRootModelElement == null) && !domainClass.equals(getDomainClass(selectedRepresentationDescription2))) {
			}
			else if ((selectedRootModelElement != null) && !selectedDomainClasses.contains(domainClass)) {
			}
			else {
				background = getWhiteBackground();
			} */
			isCheckable = checkableModelElements.contains(eObject);
		}
		treeItem.setBackground(background);
		setFont(treeItem, (isItalic ? SWT.ITALIC : 0) | (isBold ? SWT.BOLD : 0));
        treeItem.setChecked(isChecked);
        treeItem.setGrayed(!isCheckable);
		for (TreeItem childItem : treeItem.getItems()) {
			refreshModelElementsRendering(childItem, rootCreate || parentCanCreate);
		}
		treeItem.setExpanded(expandedModelElements.contains(eObject));
	}

	protected void refreshRepresentationFileName() {
		boolean sharedRepresentationFile = sharedRepresentationFileCheckButton.getSelection();
	//	URI sessionURI;
		if (sharedRepresentationFile) {
			representationFileURI = modelURI.trimSegments(1).appendSegment(ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME);
		}
		else {
			representationFileURI = modelURI.trimFileExtension().appendFileExtension(SiriusUtil.SESSION_RESOURCE_EXTENSION);
		}
	//	representationFileName = String.valueOf(sessionURI);
		representationFileNameText.setEditable(!sharedRepresentationFile);
		representationFileNameText.setText(String.valueOf(representationFileURI));
		oldDiagramNames = null;
	}

	protected void refreshViewpoints() {
		for (TreeItem item : viewpointsTree.getItems()) {
			item.dispose();
		}
		Set<@NonNull EClass> checkedEClasses = gatherCheckedEClasses();
		boolean showAllViewpoints = showAllViewpointsCheckButton.getSelection();
		for (Viewpoint viewpoint : allViewpoint2representationDescriptions.keySet()) {
			boolean hasURI = false;
			@SuppressWarnings("null")
			List<@NonNull RepresentationDescription> representationDescriptions = new ArrayList<>(viewpoint.getOwnedRepresentations());
			representationDescriptions.sort(representationDescriptorComparator);
			for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				assert representationDescription != null;
				if (hasModelURI(representationDescription)) {
					hasURI = true;
				}
			}
			if (hasURI || showAllViewpoints) {
				boolean fromPlugin = ViewpointRegistry.getInstance().isFromPlugin(viewpoint);
				String decoratorPath = fromPlugin ? "icons/full/ovr16/plugin_ovr.gif" : "icons/full/decorator/folder_close.gif";
				ImageDescriptor decoratorDescriptor = SiriusEditPlugin.Implementation.getBundledImageDescriptor(decoratorPath);
				Image image = labelProvider.getImage(viewpoint);
				if ((image != null) && (decoratorDescriptor != null)) {
					DecorationOverlayIcon icon = new DecorationOverlayIcon(image, decoratorDescriptor, IDecoration.BOTTOM_LEFT);
					image = SiriusEditPlugin.getPlugin().getImage(icon);
				}
				String text = labelProvider.getText(viewpoint);
				TreeItem rootTreeItem = new TreeItem(viewpointsTree, SWT.NONE);
				rootTreeItem.setImage(image);
				rootTreeItem.setText(text);
				rootTreeItem.setData(viewpoint);
				rootTreeItem.setBackground(getGreyBackground());
				for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
					assert representationDescription != null;
					boolean isSelected = representationDescription == selectedRepresentationDescription;
					image = labelProvider.getImage(representationDescription);
					if ((image != null) && (decoratorDescriptor != null)) {
						DecorationOverlayIcon icon = new DecorationOverlayIcon(image, decoratorDescriptor, IDecoration.BOTTOM_LEFT);
						image = SiriusEditPlugin.getPlugin().getImage(icon);
					}
					text = labelProvider.getText(representationDescription);
					TreeItem treeItem = new TreeItem(rootTreeItem, SWT.NONE);
					treeItem.setImage(image);
					treeItem.setText(text);
					treeItem.setData(representationDescription);
					treeItem.setBackground(hasURI ? getWhiteBackground() : getGreyBackground());
					if (isSelected) {
						viewpointsTree.setSelection(treeItem);
					}
					if (hasURI) {
						Set<@NonNull String> designDomainClasses = getDomainClasses(representationDescription).getValue();
						List<@NonNull String> missingDomainClasses = computeMissingDomainClasses(checkedEClasses, designDomainClasses);
						treeItem.setChecked(missingDomainClasses == null);			// XXX
					}
				}
				rootTreeItem.setExpanded(true);
			}
		}
		refreshViewpointsRendering();
	}

	protected void refreshViewpointsRendering() {
		for (TreeItem viewpointItem : viewpointsTree.getItems()) {
			boolean hasURI = false;
			for (TreeItem representationDescriptionItem : viewpointItem.getItems()) {
				RepresentationDescription representationDescription  = (RepresentationDescription)representationDescriptionItem.getData();
				for (EPackage metamodel : representationDescription.getMetamodel()) {
					assert metamodel != null;
					String nsURI = getSafeNsURI(metamodel);
					if (modelURIs.contains(nsURI)) {
						hasURI = true;
						break;
					}
				}
			}
			setFont(viewpointItem, hasURI ? 0 : SWT.ITALIC);
			for (TreeItem representationDescriptionItem : viewpointItem.getItems()) {
				RepresentationDescription representationDescription  = (RepresentationDescription)representationDescriptionItem.getData();
				boolean isSelected = representationDescription == selectedRepresentationDescription;
				setFont(representationDescriptionItem, (isSelected ? SWT.BOLD : 0) | (hasURI ? 0 : SWT.ITALIC));
			}
		}
	}

	protected void resetRepresentationDescriptionSelection() {
		selectedRepresentationDescription = null;
	//	selectedDomainClasses = allDomainClasses;
		selectedRootableDomainClass2domainClasses = emptyString2StringsEntry; //allRootableDomainClass2domainClasses;
		resetRootModelElementSelection();
	}

	protected void resetRootModelElementSelection() {
		this.selectedRootModelElement = noSelectedEObject;
		RepresentationDescription selectedRepresentationDescription2 = selectedRepresentationDescription;
		if (selectedRepresentationDescription2 == null) {
			this.selectableRootableEObject2checkableEObjects = emptyEObject2EObjectsEntry; // gatherCompatibleEObjects(selectedRootableDomainClass2domainClasses.getValue()); //selectedRepresentationDescription != null ? selectedRootableDomainClasses : allRootableDomainClasses);
		}
		else {
		//	String domainClass = getDomainClass(selectedRepresentationDescription2);
			String domainClass = selectedRootableDomainClass2domainClasses.getKey();
		//	Set<@NonNull EObject> rootableEObjects = selectedRootableDomainClass2domainClasses.get(domainClass);
			Set<@NonNull EObject> rootableEObjects = allRootableDomainClass2EObjects.get(domainClass);
			assert rootableEObjects != null;
		//	Map<@NonNull String, @NonNull Set<@NonNull EObject>> compatibleEObjects = gatherCompatibleEObjects(rootableEObjects);
			assert rootableEObjects != null;
			Set<@NonNull Notifier> ancestralEObjects = new HashSet<>();
			//	Set<@NonNull EObject> checkableEObjects = new HashSet<>();
			this.selectableRootableEObject2checkableEObjects = new HashMap<>();
			for (@NonNull EObject rootableEObject : rootableEObjects) {
				ancestralEObjects.addAll(allRootableEObject2ancestralModelElements.get(rootableEObject));
			//	checkableEObjects.addAll(allRootableEObject2checkableEObjects.get(rootableEObject));
				Set<@NonNull EObject> checkableEObjects = allRootableEObject2checkableEObjects.get(rootableEObject);
				assert checkableEObjects != null;
				selectableRootableEObject2checkableEObjects.put(rootableEObject, checkableEObjects);
			}
		//	Set<@NonNull String> domainClasses = selectedRootableDomainClass2domainClasses.getValue();
		//	Set<@NonNull EObject> rootableEObjects = gatherRootableEObjects(domainClasses); //selectedRepresentationDescription != null ? selectedDomainClasses : allDomainClasses);
		//	Set<@NonNull EObject> selectedCheckableEObjects = gatherCompatibleEObjects(rootableEObjects); //selectedRepresentationDescription != null ? selectedDomainClasses : allDomainClasses);
		//	Set<@NonNull EObject> selectedRootableEObjects = allRootableDomainClass2EObjects.get(domainClass).getValue(); // gatherCompatibleEObjects(selectedRootableDomainClass2domainClasses.getValue()); //selectedRepresentationDescription != null ? selectedRootableDomainClasses : allRootableDomainClasses);
		//	this.selectedRootableEObject2checkableEObjects = allRootableDomainClass2EObjects.get(domainClass).getValue(); // gatherCompatibleEObjects(selectedRootableDomainClass2domainClasses.getValue()); //selectedRepresentationDescription != null ? selectedRootableDomainClasses : allRootableDomainClasses);
		//	this.selectedAncestralModelElements = gatherAncestralModelElements(selectedRootableEObjects);
		//	this.selectedRootableEObject2checkableEObjects = new MapOfSetEntry<>(nullEObject, rootableEObjects/*checkableEObjects*/); //emptyEObject2EObjectsEntry; // gatherCompatibleEObjects(selectedRootableDomainClass2domainClasses.getValue()); //selectedRepresentationDescription != null ? selectedRootableDomainClasses : allRootableDomainClasses);
		//	this.selectedAncestralModelElements = gatherAncestralModelElements(selectedRootableEObject2checkableEObjects.getValue());
		//	this.selectedAncestralModelElements = ancestralEObjects;
		}
	//	this.selectedAncestralModelElements = allAncestralModelElements;
	}

	protected void setChecked(@NonNull Object object, boolean isChecked) {
	//	System.out.println("setChecked = " + isChecked + " " + labelProvider.getText(object));
		if (object instanceof EObject) {			// Skip Notifier
			EObject eObject = (EObject)object;
			if (isChecked) {
				checkedModelElements.add(eObject);
			}
			else {
				checkedModelElements.remove(eObject);
			}
		}
	}

	protected void setDeepChecked(@NonNull EObject eObject, boolean isSelected) {
		setChecked(eObject, isSelected);
		for (EObject eChild : eObject.eContents()) {
			assert eChild != null;
			setDeepChecked(eChild, isSelected);
		}
	}

	protected void setDeepExpanded(@NonNull EObject eObject, boolean isExpanded) {
		setExpanded(eObject, isExpanded);
		for (EObject eChild : eObject.eContents()) {
			assert eChild != null;
			setDeepExpanded(eChild, isExpanded);
		}
	}

	protected void setExpanded(@NonNull Object object, boolean isExpanded) {
	//	System.out.println("setExpanded = " + isExpanded + " " + labelProvider.getText(object));
		if (object instanceof EObject) {			// Skip Notifier
			EObject eObject = (EObject)object;
			if (isExpanded) {
				expandedModelElements.add(eObject);
			}
			else {
				expandedModelElements.remove(eObject);
			}
		}
	}

	protected void setFont(@NonNull TreeItem treeItem, int fontFlags) {
		if (defaultFont == null) {
			defaultFont = treeItem.getFont();
		}
		boolean isBold = (fontFlags & SWT.BOLD) != 0;
		boolean isItalic = (fontFlags & SWT.ITALIC) != 0;
		Font newFont = isBold ? isItalic ? boldItalicFont : boldFont : isItalic ? italicFont : defaultFont;
		if (newFont == null) {
			FontDescriptor clonedFont = FontDescriptor.createFrom(defaultFont);
			FontDescriptor styledFont = clonedFont.setStyle(fontFlags);
			newFont = localResourceManager.create(styledFont);
			if (isBold) {
				if (isItalic) {
					boldItalicFont = newFont;
				}
				else {
					boldFont = newFont;
				}
			}
			else {
				if (isItalic) {
					italicFont = newFont;
				}
				else {
					assert defaultFont == newFont;
				}
			}
		}
		treeItem.setFont(newFont);
	}

	protected @Nullable String setSelectedRootModelElement() {
		try {
			TreeItem[] selection = modelsElementsTree.getSelection();
			if ((selection == null) || (selection.length <= 0)) {
				resetRootModelElementSelection();
				return null;
			}
			if (selectedRepresentationDescription == null) {
				resetRootModelElementSelection();
				return "No diagram representation selected";
			}
			Object data = selection[0].getData();
			if (!(data instanceof EObject)) {
				resetRootModelElementSelection();
				return "Not a model element";
			}
			EObject eObject = (EObject)data;
			boolean canCreate =  DialectManager.INSTANCE.canCreate(eObject, selectedRepresentationDescription, false);
			if (!canCreate) {
				resetRootModelElementSelection();
				assert selectedRepresentationDescription != null;
				return "Not a " + selectedRepresentationDescription.getLabel() + " root model element";
			}
			this.selectedRootModelElement = eObject;
		//	this.selectedAncestralModelElements = gatherAncestralModelElements(Collections.singleton(eObject));
		//	Set<@NonNull Notifier> ancestralModelElements = allRootableEObject2ancestralModelElements.get(eObject);
		//	assert ancestralModelElements != null;
		//	this.selectedAncestralModelElements = ancestralModelElements;
			return "";
		}
		finally {
		//	printSelectedRootModelElement();
		}
	}

	protected @Nullable String setSelectedRepresentationDescription() {
		try {
			TreeItem[] selection = viewpointsTree.getSelection();
			if ((selection == null) || (selection.length <= 0)) {
				resetRepresentationDescriptionSelection();
				return null;
			}
			Object data = selection[0].getData();
			if (!(data instanceof RepresentationDescription)) {
				resetRepresentationDescriptionSelection();
				return "Not a diagram representation description";
			}
			RepresentationDescription selectedRepresentationDescription = (RepresentationDescription)data;
			if (!hasModelURI(selectedRepresentationDescription)) {
				resetRepresentationDescriptionSelection();
				return "No metamodel commonality with models";
			}
			if (this.selectedRepresentationDescription != selectedRepresentationDescription) {
				this.selectedRepresentationDescription = selectedRepresentationDescription;
				this.selectedRootableDomainClass2domainClasses = getDomainClasses(selectedRepresentationDescription);
			//	this.selectedRootableDomainClasses = Collections.singleton(getDomainClass(selectedRepresentationDescription));
				this.resetRootModelElementSelection();
			}
			return "";
		}
		finally {
		//	printSelectedRepresentation();
		//	printSelectedRootModelElement();
		}
	}
}
