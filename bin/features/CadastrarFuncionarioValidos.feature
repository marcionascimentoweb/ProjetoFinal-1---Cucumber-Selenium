#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar Cadastro dos Funcionários com dados corretos, 
								para validar o funcionamento do sistema 

Esquema do Cenário: Cadastrar funcionários com sucesso 
Sistema deverá inserir os dados nos campos com sucesso
Dado Acessar a página de cadastro 
E Informar o nome do Funcionário <nome>
E Informar a data de Admissão <data>
E Informar o CPF do Funcionário <CPF>
E Digitar o Resumo de Atividades <resumo>
Quando Solicitar o cadastro do funcionário
Então Sistema informará a mensagem de sucesso 

Exemplos: 
  | nome            | data         | CPF              | resumo                             |
  | "José da Silva" | "28/06/2021" | "123.456.789.00" | "Conferir e organizar mercadorias" |
  | "Ana da Rocha"  | "20/05/2021" | "456.789.123.00" | "Organizar Prateleiras"            |

Cenário: Validar os campos obrigatórios 
Sistema deverá verificar os campos em brancos
Dado Acessar a página de cadastro 
Quando Solicitar o cadastro do funcionário
Então Sistema informará que precisam preencher todos os campos 