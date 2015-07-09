package doug.antlng.hello.ui.editors.hello;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class HelloPartitionScanner implements IPartitionTokenScanner {

	public static String HELLO = "__hello"; //$NON-NLS-1$

	private IDocument document;
	private Token fullToken = new Token(HELLO);
	private boolean eof;

	@Override
	public void setRange(IDocument document, int offset, int length) {
		this.document = document;
		this.eof = false;
	}

	@Override
	public IToken nextToken() {
		IToken token = eof ? Token.EOF : fullToken;
		eof = true;
		return token;
	}

	@Override
	public int getTokenOffset() {
		return 0;
	}

	@Override
	public int getTokenLength() {
		return document.getLength();
	}

	@Override
	public void setPartialRange(IDocument document, int offset, int length, String contentType, int partitionOffset) {
		this.document = document;
		this.eof = false;
	}

}
