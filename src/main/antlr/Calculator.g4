grammar Calculator;

stat : expr # Print
     ;

expr : '(' expr ')' # Parens
     | expr op=('*'|'/') expr # MulOrDiv
     | expr op=('+'|'-') expr # AddOrSub
     | number # IntOrFloat
     ;

number : INT
       | FLOAT
       ;

INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;

DIGIT : [0-9] ;

WS : [ ]+ -> skip;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;