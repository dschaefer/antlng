package doug.antlng.hello.ui.editors.hello;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class HelloDocumentProvider extends FileDocumentProvider {

	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		if (document != null) {
			IDocumentPartitioner partitioner = new FastPartitioner(new HelloPartitionScanner(),
					new String[] { HelloPartitionScanner.HELLO });
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}

}
