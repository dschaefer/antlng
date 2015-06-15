grammar Hello;

@header {
package doug.lang.hello.core;
}

r : 'hello' ID ;

ID : [a-z]+ ;

WS : [ \t\r\n]+ -> skip ;
