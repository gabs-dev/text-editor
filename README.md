# text-editor
Vamos escrever um Editor de Texto (ET) que aceite os
comandos:<br/>
– Cancela caracter<br/>
– Cancela linha<br/>
– Imprime linha<br/>
O ET deverá ler um caractere de cada vez do texto de
entrada e produzir a impressão linha a linha, cada linha
contendo no máximo 70 caracteres de impressão.<br/>
O ET deverá utilizar o tipo abstrato de dados Pilha.<br/><br/>

“#”: cancelar caractere anterior na linha sendo
editada.<br/>
– Ex.: CFM##EFETP# → CEFET<br/><br/>

“\”: cancela todos os caracteres anteriores na linha
sendo editada.<br/><br/>

“*”: salta a linha. Ex: DCCTIM*CEFET*<br/>
DCCTIM<br/>
CEFET<br/><br/>

“~”: Indica fim dos dados de entrada
