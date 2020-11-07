# text-editor
Vamos escrever um Editor de Texto (ET) que aceite os
comandos:
– Cancela caracter
– Cancela linha
– Imprime linha
O ET deverá ler um caractere de cada vez do texto de
entrada e produzir a impressão linha a linha, cada linha
contendo no máximo 70 caracteres de impressão.
O ET deverá utilizar o tipo abstrato de dados Pilha.

“#”: cancelar caractere anterior na linha sendo
editada.
– Ex.: CFM##EFETP# → CEFET

“\”: cancela todos os caracteres anteriores na linha
sendo editada.

“*”: salta a linha. Ex: DCCTIM*CEFET*
DCCTIM
CEFET

“~”: Indica fim dos dados de entrada
