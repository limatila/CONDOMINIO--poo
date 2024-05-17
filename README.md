# Condomínio
Um trabalho feito para entrega à UNIFAMETRO, na disciplina de POO disponibilizada pela mesma.
Se trata de um sistema de gerenciamento de usuários que fazem parte do "Condomínio Bela Vista"(fictício),
disponibilizando o correto manejamento de Comunicados, Reclamações, e Débitos a pagar de cada morador.

## Setup
- Clone este repositório na sua máquina, e abra ele com uma IDE adequada, preferivelmente Intellij IDEA ou VsCode.
- Importe o package condominio.*, e tenha acessa a todo o pacote já construído.

## Estrutura
Os principais usuários construídos se dividem em Morador, Funcionario e Admnistrador.
Estes devem estar devidamente autenticados por senha própria para poderem acessar suas funcionalidades.
Os Registros presentes no sistema incluem o de Débitos, o de Comunicados(+Ocorrencias) e o ReclameAqui (para reclamações dos Moradores).
Os arquivos principais do programa estão em <code>"src/main/java/condomino"</code>

### Morador
É capaz de pesquisar os débitos pendentes cadastrados no sistema,
além de poder registrar reclamações.

### Funcionario
Capaz de registrar Ocorrencias, por exemplo problemas dentro da parte técnica do condomínio.
Além disso, eles podem obter contato de Moradores.

### Administrador
Deve ter acesso completo ao sistema, podendo registrar, apagar, ver qualquer tipo de registro dentro do sistema.
Também é por meio dele que devem ser criados usuários novos (dos 3 tipos discutidos).

## Testes
Este projeto foi testado usando o framework JUnit 4, utilizando-se de Testes Unitários fornecido pelo mesmo.
Os testes estão presentes em <code>"src/test/java/"</code>
