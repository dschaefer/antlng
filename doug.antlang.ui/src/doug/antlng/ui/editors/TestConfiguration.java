package doug.antlng.ui.editors;

import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class TestConfiguration extends TextSourceViewerConfiguration {

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		String defaultType = "__dftl_partition_content_type"; //$NON-NLS-1$
		TestDamagerRepairer dr = new TestDamagerRepairer();
		reconciler.setDamager(dr, defaultType);
		reconciler.setRepairer(dr, defaultType);
		return reconciler;
	}

}
