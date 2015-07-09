package doug.antlng.ui;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class DocumentStream implements CharStream {

	private final IDocument document;
	private int p;
	private int n;
	private int size;

	public DocumentStream(IDocument document, int offset, int length) {
		this.document = document;
		this.p = offset;
		this.n = offset + length;
		this.size = length;
	}

	@Override
	public void consume() {
		if (p >= n) {
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

		if (p + i - 1 >= n) {
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
		if (index <= p) {
			p = index; // just jump; don't update stream state (line, ...)
			return;
		}

		// seek forward, consume until p hits index or n (whichever comes first)
		index = Math.min(index, n);
		while (p < index) {
			consume();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String getSourceName() {
		return "<source>"; //$NON-NLS-1$
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
