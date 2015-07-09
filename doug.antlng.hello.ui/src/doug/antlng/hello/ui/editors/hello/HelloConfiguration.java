package doug.antlng.hello.ui.editors.hello;

import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class HelloConfiguration extends SourceViewerConfiguration {

	private final ColorManager colorManager;

	public HelloConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new HelloScanner(colorManager));
		reconciler.setDamager(dr, HelloPartitionScanner.HELLO);
		reconciler.setRepairer(dr, HelloPartitionScanner.HELLO);

		return reconciler;
	}

}
