package com.lyf.plugin.getStringLength;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class SelectedTextInfoControlContribution extends
		WorkbenchWindowControlContribution {

	private Label length_label;
	private int length = 0;
	
	private Agent agent = new Agent(this);

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
		length_label.setText(" Sel:                     ");

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

	public void updateLength(int len) {
		length = len;
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				length_label.setText(" Sel: "+ length);
			}
		});
	}
}