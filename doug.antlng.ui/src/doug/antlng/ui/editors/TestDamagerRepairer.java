package doug.antlng.ui.editors;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;

public class TestDamagerRepairer implements IPresentationDamager, IPresentationRepairer {

	@Override
	public void setDocument(IDocument document) {
	}

	@Override
	public void createPresentation(TextPresentation presentation, ITypedRegion damage) {
		presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));
	}

	@Override
	public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent event, boolean documentPartitioningChanged) {
		return partition;
	}

}
