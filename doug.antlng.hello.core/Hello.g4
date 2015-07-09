grammar Hello;

@header {
package doug.antlng.hello.core;
}

@lexer::members {
public static final int WHITESPACE = 1;
public static final int COMMENTS = 2;
}

r : HELLO ID ';' ;

HELLO : 'hello' ;

ID : [a-z]+ ;

WS : [ \t\r\n]+ -> channel(WHITESPACE) ;

COMMENT : '//' .*? '\n' -> channel(COMMENTS) ;
