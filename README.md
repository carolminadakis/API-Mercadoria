# Projeto Spring Boot MVC: API-Mercadoria

API Rest criada para cadastramento de mercadorias, nas quais devem conter:

1- Nome da mercadoria;

2- Descrição;

3- Preço;

4- Quantidade.

Banco de Dados utilizado para armazenamentos de dados: MySQL

Na classe Controller possuímos os seguintes métodos: GET, POST, PUT e DELET.

Método POST faz é responsável pelo cadastramento das mercadorias, onde são necessários o preenchimento do nome, descrição, valor e quantidade da mercadoria,
não sendo permitido deixar nenhum campo nulo ou em branco.

Com o método GET, é possível buscarmos no banco de dados a lista de todas as mercadorias cadastradas, 
ou fazermos uma busca pelo ID de determinado produto.

Método PUT é requisitado quando precisamos alterar alguma informação da mercadoria já cadastrada anteriormente.

Finalizando temos o método DELET, que ao ser requisitado, por meio do ID da mercadoria, ele então deleta o produto do banco de dados. 
