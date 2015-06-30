grammar Hello;

@header {
package doug.antlng.hello.core;
}

r : 'hello' ID ';' ;

ID : [a-z]+ ;

WS : [ \t\r\n]+ -> skip ;

COMMENT : '//' .*? '\n' -> skip ;
