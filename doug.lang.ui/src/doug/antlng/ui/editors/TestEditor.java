package doug.antlng.ui.editors;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

public class TestEditor extends TextEditor {

	private final static String EDITOR_MATCHING_BRACKETS = "matchingBrackets"; //$NON-NLS-1$
	private final static String EDITOR_MATCHING_BRACKETS_COLOR = "matchingBracketsColor"; //$NON-NLS-1$

	private ColorManager colorManager;

	public TestEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new TestConfiguration());
	}

	@Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		super.configureSourceViewerDecorationSupport(support);

		char[] matchChars = { '(', ')', '[', ']', '{', '}' };
		ICharacterPairMatcher matcher = new DefaultCharacterPairMatcher(matchChars);
		support.setCharacterPairMatcher(matcher);
		support.setMatchingCharacterPainterPreferenceKeys(EDITOR_MATCHING_BRACKETS, EDITOR_MATCHING_BRACKETS_COLOR);

		IPreferenceStore store = getPreferenceStore();
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		store.setDefault(EDITOR_MATCHING_BRACKETS_COLOR, "128,128,128"); //$NON-NLS-1$
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
