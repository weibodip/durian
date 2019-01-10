grammar Expression;

stat : expr # Print
     ;

expr : '(' expr ')' # Parens
     | expr op=('*'|'/') expr # MulOrDiv
     | expr op=('+'|'-') expr # AddOrSub
     | method '(' METRIC ')' # Aggregate
     | number # IntOrFloat
     ;

method : 'sum'
       | 'avg'
       | 'max'
       | 'min'
       ;


METRIC : CHAR+ (DIGIT | CHAR)*;

number : INT
       | FLOAT
       ;

INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;

CHAR : [a-zA-Z_] ;
DIGIT : [0-9] ;

WS : [ ]+ -> skip;