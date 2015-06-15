package doug.lang.ui.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

public class TestDocumentProvider extends TextFileDocumentProvider {

	@Override
	public IDocument getDocument(Object element) {
		IDocument doc = super.getDocument(element);
		return doc;
	}

}
