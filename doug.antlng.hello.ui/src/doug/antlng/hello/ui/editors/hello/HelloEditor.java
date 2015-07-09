package doug.antlng.hello.ui.editors.hello;

import org.eclipse.ui.editors.text.TextEditor;

public class HelloEditor extends TextEditor {

	private ColorManager colorManager = new ColorManager();

	public HelloEditor() {
		super();
		setSourceViewerConfiguration(new HelloConfiguration(colorManager));
		setDocumentProvider(new HelloDocumentProvider());
	}

	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
