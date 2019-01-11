grammar Predicate;

stat : predicate # Statement
     ;

predicate : '(' predicate ')'                                       # Parens
     | predicate 'AND' predicate                                    # And
     | predicate 'OR' predicate                                     # Or
     | number op = ('<' | '>' | '<=' | '>=' | '=' | '!=') number    # Comparison
     ;

number : INT
       | FLOAT
       | 'NaN'
       ;

INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;

DIGIT : [0-9] ;

WS : [ ]+ -> skip;

LT : '<' ;
GT : '>' ;
ELT : '<=' ;
GLT : '>=' ;
EQ : '=' ;
NEQ : '!=' ;