grammar lang;

block                   : programElement*;
programElement          : statement|(expression SEMI_COLON?);
expression              : assignment|expressionLogicalOr;
statement               : 
    ((returnStatement|variableDeclaration) SEMI_COLON?) | 
    forStatement | 
    ifStatement;
variableDeclaration     : KW_VAR ID (ASSIGN expression)?;
assignment              : ID assignmentOp expression;
assignmentOp            :
    op=ASSIGN|
    op=ASSIGN_PLUS|
    op=ASSIGN_MINUS|
    op=ASSIGN_MULT|
    op=ASSIGN_DIV|
    op=ASSIGN_REM;
returnStatement         : KW_RETURN expression1;
forStatement            : 
    KW_FOR OPEN_PAR 
    init=expression? SEMI_COLON
    condition=expression? SEMI_COLON
    update=expression?
    CLOSE_PAR
    OPEN_BRACKET body=block CLOSE_BRACKET;
ifStatement             : 
    KW_IF OPEN_PAR condition=expression CLOSE_PAR
    trueBlock=blockOrSingle
    (KW_ELSE falseBlock=blockOrSingle)?;
blockOrSingle           : (OPEN_BRACKET content=block CLOSE_BRACKET)|content=block;

expressionLogicalOr     : expressionLogicalAnd (OP_OR expressionLogicalAnd)*;
expressionLogicalAnd    : expressionBitwiseOr (OP_AND expressionBitwiseOr)*;
expressionBitwiseOr     : expressionBitwiseXOr (OP_BOR expressionBitwiseXOr)*;
expressionBitwiseXOr    : expressionBitwiseAnd (OP_BXOR expressionBitwiseAnd)*;
expressionBitwiseAnd    : expressionEquality (OP_BAND expressionEquality)*;
expressionEquality      : 
    expressionComparison (expressionEqualityOp expressionComparison)*;
expressionEqualityOp    : op=OP_EQ|op=OP_INEQ|op=OP_SEQ|op=OP_SINEQ;

expressionComparison    : expression1 binaryComparisonOperand*;
binaryComparisonOperand : 
    (op=OP_LT|op=OP_LTE|op=OP_GT|op=OP_GTE|op=OP_IN|op=OP_INO) expression1;
expression1             : expression2 binaryAdditionOperand*;
binaryAdditionOperand   : binaryAdditionOperator expression2;
binaryAdditionOperator  : op=OP_PLUS|op=OP_MINUS;
expression2             : expression3 binaryMultOperand*;
binaryMultOperand       : binaryMultOperator expression3;
binaryMultOperator      : op=OP_MULT|op=OP_DIV|op=OP_REM;
expression3             : expression4 slotGetOrApply* slotSet?;
slotGetOrApply          : slotGet|apply;
slotGet                 : 
    (slotGetByStaticId | slotGetByDynamicId)
    (OP_PLUS_PLUS | OP_MINUS_MINUS)?;
slotGetByStaticId       : DOT ID;
slotGetByDynamicId      : sqBracketIndex;
slotSet                 : slotSetByStaticId | slotSetByDynamicId;
slotSetByStaticId       : DOT ID assignmentOp expression;
slotSetByDynamicId      : sqBracketIndex assignmentOp expression;
sqBracketIndex          : OPEN_SQ_BRACKET expression CLOSE_SQ_BRACKET;
expression4             : 
    identifier | string | number | bool | objectLiteral | arrayLiteral |
    functionLiteral | nativeObject | self | groupExpression | newInstance;
identifier              : ID (OP_PLUS_PLUS | OP_MINUS_MINUS)?;
string                  : STRING;
number                  : NUMBER;
bool                    : b=KW_TRUE|b=KW_FALSE;
objectLiteral           : 
    OPEN_BRACKET (objectLiteralSlot (COMMA objectLiteralSlot)*)? CLOSE_BRACKET;
objectLiteralSlot       : ID COLON expression;
arrayLiteral            : 
    OPEN_SQ_BRACKET (expression (COMMA expression)*)? CLOSE_SQ_BRACKET;
apply                   :
    OPEN_PAR (expression (COMMA expression)*)? CLOSE_PAR;
functionLiteral         : 
    KW_FUNCTION OPEN_PAR (ID (COMMA ID)*)? CLOSE_PAR
    OPEN_BRACKET body=block CLOSE_BRACKET;
nativeObject            : KW_NATIVE DOT ID;
self                    : KW_THIS;
groupExpression         : OPEN_PAR expression CLOSE_PAR;
newInstance             : KW_NEW expression apply;

KW_THIS: 'this';
KW_VAR: 'var';
KW_FUNCTION: 'function';
KW_NATIVE: 'native';
KW_RETURN: 'return';
KW_FOR: 'for';
KW_IF: 'if';
KW_ELSE: 'else';
KW_TRUE: 'true';
KW_FALSE: 'false';
KW_NEW: 'new';
OP_PLUS: '+';
OP_PLUS_PLUS: '++';
OP_MINUS: '-';
OP_MINUS_MINUS: '--';
OP_MULT: '*';
OP_DIV: '/';
OP_REM: '%';
OP_LT: '<';
OP_LTE: '<=';
OP_GT: '>';
OP_GTE: '>=';
OP_IN: 'in';
OP_INO: 'instanceof';
OP_OR: '||';
OP_AND: '&&';
OP_BOR: '|';
OP_BXOR: '^';
OP_BAND: '&';

OP_EQ: '==';
OP_INEQ: '!=';
OP_SEQ: '===';
OP_SINEQ: '!==';

DOT: '.';
COLON: ':';
SEMI_COLON: ';';
COMMA: ',';
ASSIGN: '=';
ASSIGN_PLUS: '+=';
ASSIGN_MINUS: '-=';
ASSIGN_MULT: '*=';
ASSIGN_DIV: '/=';
ASSIGN_REM: '%=';
OPEN_PAR:   '(';
CLOSE_PAR:   ')';
OPEN_BRACKET:   '{';
CLOSE_BRACKET:   '}';
OPEN_SQ_BRACKET:   '[';
CLOSE_SQ_BRACKET:   ']';
fragment DIGIT: [0-9];
fragment LETTER: [A-Z]|[a-z];
ID: (LETTER | '_') (LETTER | '_' | DIGIT)*;
STRING :  '"' (ESC | ~["\\])* '"';
fragment ESC:   '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX: [0-9a-fA-F];
NUMBER
    :   '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :   '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]
WS                  : [ \t\n\r]+ -> channel(2) ;
SINGLE_LINE_COMMENT : '//' ~('\r' | '\n')* -> skip;
MULTI_LINE_COMMENT  : '/*' .*? '*/' -> skip;