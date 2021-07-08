#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar Cadastro dos Funcion�rios com dados corretos, 
								para validar o funcionamento do sistema 

Esquema do Cen�rio: Cadastrar funcion�rios com sucesso 
Sistema dever� inserir os dados nos campos com sucesso
Dado Acessar a p�gina de cadastro 
E Informar o nome do Funcion�rio <nome>
E Informar a data de Admiss�o <data>
E Informar o CPF do Funcion�rio <CPF>
E Digitar o Resumo de Atividades <resumo>
Quando Solicitar o cadastro do funcion�rio
Ent�o Sistema informar� a mensagem de sucesso 

Exemplos: 
  | nome            | data         | CPF              | resumo                             |
  | "Jos� da Silva" | "28/06/2021" | "123.456.789.00" | "Conferir e organizar mercadorias" |
  | "Ana da Rocha"  | "20/05/2021" | "456.789.123.00" | "Organizar Prateleiras"            |

Cen�rio: Validar os campos obrigat�rios 
Sistema dever� verificar os campos em brancos
Dado Acessar a p�gina de cadastro 
Quando Solicitar o cadastro do funcion�rio
Ent�o Sistema informar� que precisam preencher todos os campos 