package doug.antlng.hello.ui.editors.hello;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.RGB;

import doug.antlng.hello.core.HelloLexer;
import doug.antlng.ui.DocumentStream;

public class HelloScanner implements ITokenScanner {

	private HelloLexer lexer;
	private org.antlr.v4.runtime.Token token;

	private Token defaultToken = new Token(new TextAttribute(null));
	private Token helloToken;
	private Token idToken;

	public HelloScanner(ColorManager colorManager) {
		this.helloToken = new Token(new TextAttribute(colorManager.getColor(new RGB(200, 0, 0))));
		this.idToken = new Token(new TextAttribute(colorManager.getColor(new RGB(0, 150, 0))));
	}

	@Override
	public void setRange(IDocument document, int offset, int length) {
		DocumentStream docStream = new DocumentStream(document, offset, length);
		lexer = new HelloLexer(docStream);
	}

	@Override
	public IToken nextToken() {
		token = lexer.nextToken();
		switch (token.getType()) {
		case org.antlr.v4.runtime.Token.EOF:
			return Token.EOF;
		case HelloLexer.HELLO:
			return helloToken;
		case HelloLexer.ID:
			return idToken;
		default:
			return defaultToken;
		}
	}

	@Override
	public int getTokenOffset() {
		return token.getStartIndex();
	}

	@Override
	public int getTokenLength() {
		return token.getStopIndex() - token.getStartIndex() + 1;
	}

}
