package com.lyf.plugin.getStringLength;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class SelectedTextInfoControlContribution 
			extends WorkbenchWindowControlContribution implements IEditorSelectionInfo, IEditorFocusInfo {

	private static final String SEL_FORMAT = "Sel : %d | %d";
	
	private final Agent agent = new Agent(this);

	private Label length_label;
	
	public SelectedTextInfoControlContribution() {
	}

	public SelectedTextInfoControlContribution(String id) {
		super(id);
	}

	@Override
	protected Control createControl(Composite parent) {
		agent.start(getWorkbenchWindow());

		Composite comp = new Composite(parent, SWT.NONE);
		FillLayout layout = new FillLayout();
		layout.type = SWT.HORIZONTAL;
		layout.spacing = 10;
		comp.setLayout(layout);
		
		length_label = new Label(comp, SWT.LEFT);
		length_label.setVisible(false);
		length_label.setText(String.format(SEL_FORMAT, 0, 0) + String.format(String.format("%%%ds", 10), " "));
		
		return comp;
	}

	@Override
	public void dispose() {
		agent.stop();
		super.dispose();
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	public void updateSelection(final ITextSelection selection) {
		final int len = selection.getLength();
		final int rln = (selection.getEndLine() - selection.getStartLine());
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				length_label.setVisible(true);
				length_label.setText(String.format(SEL_FORMAT, len, (rln > 0) ? rln + 1 : 0));
			}
		});
		
	}

	@Override
	public void updateFocus(final boolean focused) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				length_label.setVisible(focused);
			}
		});
	}
}