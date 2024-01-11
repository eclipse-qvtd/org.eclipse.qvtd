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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ColorDescriptor;
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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
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

/**
 * The InitializeDiagramDialog is seeded by a UI (multi-)selection and prepares the configuration for
 * the creation of an (additional) diagram representation.
 */
public class InitializeDiagramDialog extends TitleAreaDialog
{

	protected abstract class AbstractSelectionListener implements SelectionListener
	{
		protected void setDeepChecked(@NonNull TreeItem[] items, boolean isSelected) {
			for (TreeItem item : items) {
				item.setChecked(isSelected);
				setDeepChecked(item.getItems(), isSelected);
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
	}

	protected class UncheckAllElementsSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			setDeepChecked(modelsElementsTree.getItems(), false);
			refreshMessage();
		}
	}

	protected class ModelElementsTreeMouseListener implements MouseListener
	{
		@Override
		public void mouseDoubleClick(MouseEvent e) {
	//		System.out.println("mouseDoubleClick = " + e);
		}

		@Override
		public void mouseDown(MouseEvent e) {
	//		System.out.println("mouseDown = " + e);
		}

		@Override
		public void mouseUp(MouseEvent e) {
	//		System.out.println("mouseUp = " + e);
			refreshModelElementsRendering();
			refreshMessage();
		}
	}

	protected class ModelElementsTreeSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			TreeItem[] selection = modelsElementsTree.getSelection();
			Object data;
			if ((selection != null) && (selection.length > 0) && ((data = selection[0].getData()) instanceof EObject)) {
				selectedRootModelElement = (EObject)data;
			}
			else {
				selectedRootModelElement = null;
			}
//				refreshViewpoints();
//			refreshViewpointsRendering();
			refreshModelElementsRendering();
			refreshMessage();
//				System.out.println("Selected " + viewpointsTree.getSelection().length);
		}
	}

	protected class CheckAllElementsSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			setDeepChecked(modelsElementsTree.getItems(), true);
			refreshMessage();
		}
	}

	protected class SharedRepresentationSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			refreshRepresentationFileName();
			refreshMessage();
		}
	}

	protected class ShowAllElementsSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			refreshModelElements();
			refreshModelElementsRendering();
			refreshMessage();
		}
	}

	protected class ShowAllViewpointsSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			refreshViewpoints();
			refreshViewpointsRendering();
			refreshMessage();
		}
	}

	protected class ViewpointsTreeSelectionListener extends AbstractSelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			TreeItem[] selection = viewpointsTree.getSelection();
			Object data;
			RepresentationDescription selectedRepresentationDescription = null;
			if ((selection != null) && (selection.length > 0) && ((data = selection[0].getData()) instanceof RepresentationDescription)) {
				selectedRepresentationDescription = (RepresentationDescription)data;
			}
			setSelectedRepresentationDescription(selectedRepresentationDescription);
//				refreshViewpoints();
			refreshViewpointsRendering();
			refreshModelElementsRendering();
			refreshMessage();
//				System.out.println("Selected " + viewpointsTree.getSelection().length);
		}
	}

	// The 'input's.
	protected final Iterable<@NonNull EObject> modelEObjects;

	// The derived 'input's.
	private final ComposedAdapterFactory adapterFactory;
	private final ILabelProvider labelProvider;
	private final Map<@NonNull Resource, @NonNull List<@NonNull EObject>> resource2elements;
	private final URI modelURI;
	private final Set<EPackage> modelEPackages;
	private final Set<String> modelURIs;

	// The widgets
	private Button okButton;
	private Button sharedRepresentationFileCheckButton;
	private Button showAllViewpointsCheckButton;
	private Composite viewpointsComposite;
	private Text representationFileNameText;
	private Tree modelsElementsTree;
	private Tree viewpointsTree;
	private Text representationDiagramNameText;
	private Text statusText;

	// The working state
	private @Nullable EObject selectedRootModelElement = null;
	private @Nullable RepresentationDescription selectedRepresentationDescription = null;
	private @Nullable Set<@NonNull String> createableDomainClasses = null;
	private @Nullable Font defaultFont = null;
	private @Nullable Font boldFont = null;
	private @Nullable Font boldItalicFont = null;
	private @Nullable Font italicFont = null;

	// The 'output's for access post-dispose().
	private String finalRepresentationDiagramName = null;
	private URI finalRepresentationFileURI = null;
	private List<@NonNull EObject> finalSelectedElements = null;
	private RepresentationDescription finalRegistryRepresentationDescription = null;
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
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
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
		this.modelURI = firstModelResource.getURI();
		this.modelEPackages = new HashSet<>();
		this.modelURIs = new HashSet<>();
		for (Resource eResource : resource2elements.keySet()) {
			for (TreeIterator<EObject> tit = eResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				EClass eClass = eObject.eClass();
				EPackage ePackage = eClass.getEPackage();
				assert ePackage != null;
				if (modelEPackages.add(ePackage)) {
					String nsURI = getSafeNsURI(ePackage);
					modelURIs.add(nsURI.toString());
				}
			}
		}
	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources());
	}

	public @Nullable RepresentationDescription basicGetRegistryRepresentationDescription() {
		assert getShell() != null;
		TreeItem[] selection = viewpointsTree.getSelection();
		if ((selection == null) || (selection.length != 1)) {
	//		System.out.println("Selected3 null ");
			return null;
		}
	//	System.out.println("Selected3 " + selection.length);
		Object data = selection[0].getData();
		if (!(data instanceof RepresentationDescription)) {
			return null;
		}
		return (RepresentationDescription)data;
	}

	protected @NonNull List<@NonNull EObject> basicGetSelectedElements() {
		assert getShell() != null;
		List<@NonNull EObject> selectedElements = new ArrayList<>();
		for (TreeItem rootItem : modelsElementsTree.getItems()) {
			for (TreeItem childItem : rootItem.getItems()) {
				gatherSelectedElements(childItem, selectedElements);
			}
		}
		return selectedElements;
	}

	@Override
	public boolean close() {
		assert getShell() != null;
		finalRepresentationDiagramName = representationDiagramNameText.getText();
		finalRepresentationFileURI = sharedRepresentationFileCheckButton.getSelection() ? null : URI.createURI(representationFileNameText.getText());
		finalSelectedElements = basicGetSelectedElements();
		finalRegistryRepresentationDescription = basicGetRegistryRepresentationDescription();
		boolean closeStatus = super.close();
		assert getShell() == null;
		return closeStatus;
	}

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
		Layout layout = parent.getLayout();
		if (layout instanceof GridLayout) {
			((GridLayout)layout).makeColumnsEqualWidth = false;
			((GridLayout)layout).numColumns++;
		}
		Object layoutData = parent.getLayoutData();
		if (layoutData instanceof GridData) {
			((GridData)layoutData).horizontalAlignment = SWT.FILL;
			((GridData)layoutData).grabExcessHorizontalSpace = true;
		}

		statusText = new Text(parent, SWT.NONE);
		statusText.setEnabled(false);
		statusText.setEditable(false);
		statusText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

		refreshMessage();
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
	//	SelectionListener defaultSelectionListener = new AbstractSelectionListener();
		setTitle("Initialize Diagram");
		Composite container = (Composite) super.createDialogArea(parent);
	//	Composite container = new Composite(parent, SWT.NONE);

	//	setControl(container);
		GridLayout gl_container = new GridLayout(1, true);
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		gl_container.verticalSpacing = 2;
		container.setLayout(gl_container);

		SashForm overallSash = new SashForm(container, SWT.VERTICAL);
		overallSash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

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

		Button showAllElementsCheckButton = new Button(modelsElementsComposite, SWT.CHECK);
		showAllElementsCheckButton.setText("Show All");
		showAllElementsCheckButton.addSelectionListener(new ShowAllElementsSelectionListener());
		new Label(modelsElementsComposite, SWT.NONE);

		modelsElementsTree = new Tree(modelsElementsComposite, SWT.BORDER | SWT.CHECK | SWT.MULTI);
		GridData gd_modelsElementsTree = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_modelsElementsTree.minimumHeight = 100;
		modelsElementsTree.setLayoutData(gd_modelsElementsTree);
		modelsElementsTree.setBounds(0, 0, 94, 94);
		modelsElementsTree.addSelectionListener(new ModelElementsTreeSelectionListener());
		modelsElementsTree.setToolTipText("Select from the models to be diagrammed\n  and their contained contents\nSelected root element in bold.\nNot-compatible representations in italics.");
		modelsElementsTree.addMouseListener(new ModelElementsTreeMouseListener());

		TreeItem treeItem = new TreeItem(modelsElementsTree, SWT.NONE);
		treeItem.setText("Initializing Model Elements ...");

		Composite modelButtons = new Composite(modelsComposite, SWT.NONE);
		modelButtons.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		modelButtons.setLayout(new GridLayout(1, false));

		Button checkAllButton = new Button(modelButtons, SWT.NONE);
		checkAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		checkAllButton.setText("Check All");
		checkAllButton.addSelectionListener(new CheckAllElementsSelectionListener());
		checkAllButton.setToolTipText("Check all model elements transitively contained by the selectred root model element.");

		Button uncheckAllButton = new Button(modelButtons, SWT.NONE);
		uncheckAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		uncheckAllButton.setText("Uncheck All");
		uncheckAllButton.addSelectionListener(new UncheckAllElementsSelectionListener());
		uncheckAllButton.setToolTipText("Uncheck all model elements transitively contained by the selectred root model element.");

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
		sharedRepresentationFileCheckButton.addSelectionListener(new SharedRepresentationSelectionListener());

		showAllViewpointsCheckButton = new Button(diagramRepresentationComposite, SWT.CHECK);
		showAllViewpointsCheckButton.setToolTipText("Show not-applicable as well as applicable viewpoints.");
		showAllViewpointsCheckButton.setText("Show All");
		showAllViewpointsCheckButton.addSelectionListener(new ShowAllViewpointsSelectionListener());

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
		viewpointsTree.setToolTipText("The available viewpoints (diagram families)\n  and their representations (diagram types)\nSelected representation in bold.\nNot-applicable representations in italics.");
		viewpointsTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		viewpointsTree.addSelectionListener(new ViewpointsTreeSelectionListener());

		Composite representationDiagramNameComposite = new Composite(representationComposite, SWT.NONE);
		representationDiagramNameComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_representationDiagramNameComposite = new GridLayout(2, false);
		gl_representationDiagramNameComposite.marginWidth = 0;
		representationDiagramNameComposite.setLayout(gl_representationDiagramNameComposite);

		Label representationDiagramNameLabel = new Label(representationDiagramNameComposite, SWT.NONE);
		representationDiagramNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		representationDiagramNameLabel.setSize(81, 25);
		representationDiagramNameLabel.setText("Representation Name:");

		representationDiagramNameText = new Text(representationDiagramNameComposite, SWT.BORDER);
		representationDiagramNameText.setText("new Diagram Name");
		representationDiagramNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		descriptionText = new Text(representationSash, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		descriptionText.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		overallSash.setWeights(new int[] {1, 1});
		representationSash.setWeights(new int[] {2, 1});

		refreshRepresentationFileName();
		refreshViewpoints();
		refreshViewpointsRendering();
		refreshModelElements();
		refreshModelElementsRendering();
		if (okButton != null) {
			refreshMessage();
		}
		return container;
	}

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

	protected void gatherSelectedEClasses(TreeItem[] items, Set<EClass> eClasses) {
		for (TreeItem item : items) {
			Object object = item.getData();
			if ((object instanceof EObject) && item.getChecked()) {
				EClass eClass = ((EObject)object).eClass();
				eClasses.add(eClass);
			}
			gatherSelectedEClasses(item.getItems(), eClasses);
		}
	}

	protected void gatherSelectedElements(@NonNull TreeItem treeItem, @NonNull List<@NonNull EObject> selectedElements) {
		if (treeItem.getChecked()) {
			Object data = treeItem.getData();
			if (data instanceof EObject) {
				selectedElements.add((EObject)data);
			}
		}
		for (TreeItem childItem : treeItem.getItems()) {
			gatherSelectedElements(childItem, selectedElements);
		}
	}

	protected @NonNull String getDomainClass(@NonNull EClass selectedEClass) {
		return selectedEClass.getEPackage().getName() + "." + selectedEClass.getName();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(800, 800);
	}

	public RepresentationDescription getRegistryRepresentationDescription() {
		assert getShell() == null;
		return finalRegistryRepresentationDescription;
	}

	public String getRepresentationDiagramName() {
		assert getShell() == null;
		return finalRepresentationDiagramName;
	}

	public URI getRepresentationFileURI() {
		assert getShell() == null;
		return finalRepresentationFileURI;
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

	public List<@NonNull EObject> getSelectedElements() {
		assert getShell() == null;
		return finalSelectedElements;
	}

	public @NonNull URI getSessionURI() {
		assert getShell() == null;
		return modelURI.trimSegments(1).appendSegment(ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME);
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

	protected void refreshMessage() {
		refreshDescription();
		String errorMessage = null;
		String warningMessage = null;
		RepresentationDescription finalRegistryRepresentationDescription = basicGetRegistryRepresentationDescription();
		if (finalRegistryRepresentationDescription == null) {
			errorMessage = "No unique representation description selected.\nSelect exactly one leaf representation in the Diagram Representation tree.";
		}
		else {
			List<EObject> selectedElements = basicGetSelectedElements();
			if (selectedElements.isEmpty()) {
				warningMessage = "No model elements selected.\nCheck at least one non-root element in the Model(s) Elements tree.";
			}
		}
		if ((errorMessage == null) && (warningMessage == null)) {
			Set<EClass> selectedEClasses = new HashSet<>();
			gatherSelectedEClasses(modelsElementsTree.getItems(), selectedEClasses);
			for (TreeItem rootTreeItem : viewpointsTree.getItems()) {
				for (TreeItem treeItem : rootTreeItem.getItems()) {
					if (treeItem.getChecked()) {
						RepresentationDescription representationDescription = (RepresentationDescription)treeItem.getData();
						Set<String> designDomainClasses = new HashSet<>();
						gatherDomainClasses(representationDescription, designDomainClasses);
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
				setMessage("Select a diagram representation, then select a corresponding root model element\nthen check the models elements with which to initialize the diagram.");
			}
		}
	}

	protected void refreshModelElements() {
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
			Set<@NonNull EObject> explicit = new HashSet<>(resource2elements.get(resource));
			for (EObject eObject : resource.getContents()) {
				refreshModelElements(rootTreeItem, eObject, explicit);
			}
			rootTreeItem.setExpanded(true);
		}
	}

	protected void refreshModelElements(@NonNull TreeItem parentTreeItem, @NonNull EObject eObject, Set<@NonNull EObject> explicit) {
		Image image = labelProvider.getImage(eObject);
		String text = labelProvider.getText(eObject);
		TreeItem treeItem = new TreeItem(parentTreeItem, SWT.NONE);
		treeItem.setImage(image);
		treeItem.setText(text);
		treeItem.setChecked(explicit.contains(eObject));
		treeItem.setData(eObject);
	/*	treeItem.addListener(SWT.Selection, new Listener()
			{
				@Override
				public void handleEvent(Event event) {
					System.out.println("Selected = " + getSelectedElements());
				}
			}); */
		for (EObject childEObject : eObject.eContents()) {
			assert childEObject != null;
			refreshModelElements(treeItem, childEObject, explicit);
		}
	}

	protected void refreshModelElementsRendering() {
		for (TreeItem rootItem : modelsElementsTree.getItems()) {
			for (TreeItem item : rootItem.getItems()) {
				refreshModelElementsRendering(item, false);
			}
		}
	}

	protected void refreshModelElementsRendering(TreeItem treeItem, boolean parentCanCreate) {
		EObject eObject = (EObject)treeItem.getData();
		EClass eClass = eObject.eClass();
		String domainClass = getDomainClass(eClass);
		boolean isCreateable = (createableDomainClasses != null) && createableDomainClasses.contains(domainClass);

        boolean rootCreate = !parentCanCreate && DialectManager.INSTANCE.canCreate(eObject, selectedRepresentationDescription, false);



		boolean isSelected = !parentCanCreate && (eObject == selectedRootModelElement);
//        DiagramDescription diagramDescription = (DiagramDescription)selectedRepresentationDescription;
//        boolean canCreate = parentCanCreate || DialectManager.INSTANCE.canCreate(eObject, selectedRepresentationDescription, false);
        setFont(treeItem, (isCreateable ? 0 : SWT.ITALIC) | (isSelected ? SWT.BOLD : 0));
        treeItem.setGrayed(!isCreateable);
		for (TreeItem childItem : treeItem.getItems()) {
			refreshModelElementsRendering(childItem, rootCreate || parentCanCreate);
		}
	}

	protected void refreshRepresentationFileName() {
		boolean sharedRepresentationFile = sharedRepresentationFileCheckButton.getSelection();
		URI sessionURI;
		if (sharedRepresentationFile) {
			sessionURI = modelURI.trimSegments(1).appendSegment(ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME);
		}
		else {
			sessionURI = modelURI.trimFileExtension().appendFileExtension(SiriusUtil.SESSION_RESOURCE_EXTENSION);
		}
		representationFileNameText.setEditable(!sharedRepresentationFile);
		representationFileNameText.setText(String.valueOf(sessionURI));
	}

	protected void refreshViewpoints() {
		for (TreeItem item : viewpointsTree.getItems()) {
			item.dispose();
		}
		boolean showAllViewpoints = showAllViewpointsCheckButton.getSelection();
		ViewpointRegistry instance = ViewpointRegistry.getInstance();
		@SuppressWarnings("null") List<@NonNull Viewpoint> allViewpoints = new ArrayList<>(instance.getViewpoints());
		allViewpoints.sort(viewpointComparator);
		Set<EClass> selectedEClasses = new HashSet<>();
		gatherSelectedEClasses(modelsElementsTree.getItems(), selectedEClasses);
		for (Viewpoint viewpoint : allViewpoints) {
			boolean hasURI = false;
			List<RepresentationDescription> representationDescriptions = new ArrayList<>(viewpoint.getOwnedRepresentations());
			representationDescriptions.sort(representationDescriptorComparator);
			for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				for (EPackage metamodel : representationDescription.getMetamodel()) {
					assert metamodel != null;
					String nsURI = getSafeNsURI(metamodel);
					if (modelURIs.contains(nsURI)) {
						hasURI = true;
					}
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
					if (isSelected) {
						viewpointsTree.setSelection(treeItem);
					}
					if (hasURI) {
						Set<String> designDomainClasses = new HashSet<>();
						gatherDomainClasses(representationDescription, designDomainClasses);
						List<String> missingDomainClasses = computeMissingDomainClasses(selectedEClasses, designDomainClasses);
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
		//	Viewpoint viewpoint = (Viewpoint)viewpointItem.getData();
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
		//	Set<EClass> selectedEClasses = new HashSet<>();
		//	gatherSelectedEClasses(modelsElementsTree.getItems(), selectedEClasses);
			for (TreeItem representationDescriptionItem : viewpointItem.getItems()) {
				RepresentationDescription representationDescription  = (RepresentationDescription)representationDescriptionItem.getData();
				boolean isSelected = representationDescription == selectedRepresentationDescription;
				int fontFlags = 0;
				if (hasURI) {
				//	Set<String> designDomainClasses = new HashSet<>();
				//	gatherDomainClasses(representationDescription, designDomainClasses);
				//	List<String> missingDomainClasses = computeMissingDomainClasses(selectedEClasses, designDomainClasses);
				//	representationDescriptionItem.setChecked(missingDomainClasses == null);
					if (isSelected) {
						fontFlags = SWT.BOLD;
					}
				}
				else {
					fontFlags = (isSelected ? SWT.BOLD : 0) | SWT.ITALIC;
				}
				setFont(representationDescriptionItem, fontFlags);
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

	protected void setSelectedRepresentationDescription(@Nullable RepresentationDescription selectedRepresentationDescription) {
		this.selectedRepresentationDescription = selectedRepresentationDescription;
		if (selectedRepresentationDescription == null) {
			createableDomainClasses = null;
		}
		else {
			createableDomainClasses = new HashSet<>();
			gatherDomainClasses(selectedRepresentationDescription, createableDomainClasses);
		}
	}
}
