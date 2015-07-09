package doug.antlng.ui;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class DocumentStream implements CharStream {

	private final IDocument document;
	private final String name;
	private int p = 0;

	public DocumentStream(IDocument document, String name) {
		this.document = document;
		this.name = name;
	}

	@Override
	public void consume() {
		if (p >= document.getLength()) {
			assert LA(1) == EOF;
			throw new IllegalStateException("cannot consume EOF"); //$NON-NLS-1$
		}

		p++;
	}

	@Override
	public int LA(int i) {
		if (i == 0) {
			return 0; // undefined
		}

		if (i < 0) {
			i++;
			if (p + i - 1 < 0) {
				return EOF; // invalid; no char before first char
			}
		}

		if (p + i - 1 >= document.getLength()) {
			return EOF;
		}

		try {
			return document.getChar(p + i - 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return EOF;
		}
	}

	@Override
	public int index() {
		return p;
	}

	@Override
	public void seek(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return document.getLength();
	}

	@Override
	public String getSourceName() {
		return name;
	}

	@Override
	public String getText(Interval interval) {
		try {
			return document.get(interval.a, interval.length());
		} catch (BadLocationException e) {
			e.printStackTrace();
			return ""; //$NON-NLS-1$
		}
	}

	// mark and release do nothing as the document has all the characters
	@Override
	public int mark() {
		return -1;
	}

	@Override
	public void release(int marker) {
	}

}
