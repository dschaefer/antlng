# lang
Multi-language framework for Eclipse based on Antlr 4

I have had a dream for a long time, since the early days when starting building the C++ parser for CDT.
I always wanted to use Antlr as a parser generator. But C++ is very hard on parser generators. It exhibits
all the bad behaviors that bring them to their knees. So I gave up and we hand coded the CDT's parsers (C and C++)
and everything has worked out in the end.

But I've never been satisfied. I want Eclipse to be an IDE that can be used for all langauges. But doing so
is a very difficult task. Xtext brought some hope, but it suffers the same fate that Antlr does. Languages that
are ambiguous or with complex rules are hard to do with grammar generators that use static analysis to determine
correctness, because it's a huge effort to make them correct, and in the end it doesn't really matter that much.

Then along came Antlr 4. And promised to make the grammar writer's life so much better. It defaults to doing the
right thing with tough grammars. It gives me real hope. And the collection of grammars that Terence Parr has
collected using Antlr 4 show that the toughest langauges are indeed possible.

That brings us back to Eclipse. The parser and lexer are just one small component of an IDE. You need an editor
with syntax and semantic highlighting, you need content assist, you need indexing search, and the list goes on.

The purpose of this project is to see if we can provide common implementations of these components that
leverage the fact you're using Antlr 4 for the lexer and parser. Write your grammer, hook up the parts that
are interesting, boom you have an IDE. We've gained a lot of experience building the CDT and JDT. Can we
help new languages and pass those lessons on to the community and make Eclipse the IDE for everything?

Let's see if we can make this dream come true.
