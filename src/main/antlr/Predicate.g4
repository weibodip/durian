grammar Predicate;

root: statement ';'? EOF;

statement: predicateList;

predicateList:
  predicate (booleanOperator predicate)*
  ;

predicate:
  '(' predicateList ')'                   # PredicateParenthesisGroup
  | comparisonClause                      # ComparisonPredicate
  ;

booleanOperator: OR | AND;

comparisonClause:
  literal comparisonOperator literal;

literal:
  INTEGER_LITERAL         # IntegerLiteral
  | FLOATING_POINT_LITERAL  # FloatingPointLiteral
  ;

comparisonOperator: '<' | '>' | '<>' | '<=' | '>=' | '=' | '!=';

// Keywords
AND: A N D;
OR: O R;

INTEGER_LITERAL : SIGN? DIGIT+;
FLOATING_POINT_LITERAL : SIGN? DIGIT+ '.' DIGIT* | SIGN? DIGIT* '.' DIGIT+;

WHITESPACE: [ \t\n]+ -> skip;

LINE_COMMENT: '--' ~[\r\n]* -> channel(HIDDEN);

fragment SIGN: [+-];

fragment DIGIT : [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];