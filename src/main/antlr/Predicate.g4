grammar Predicate;

stat : predicate # Statement
     ;

predicate : '(' predicate ')'                                       # Parens
     | predicate AND predicate                                    # And
     | predicate OR predicate                                     # Or
     | number op = ('<' | '>' | '<=' | '>=' | '=' | '!=') number    # Comparison
     ;

number : INT
       | FLOAT
       | 'NaN'
       ;

AND: A N D;
OR: O R;

INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;

A : [aA];
D : [dD];
N : [nN];
O : [oO];
R : [rR];

DIGIT : [0-9] ;

WS : [ ]+ -> skip;

LT : '<' ;
GT : '>' ;
ELT : '<=' ;
EGT : '>=' ;
EQ : '=' ;
NEQ : '!=' ;