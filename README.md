## Ambiente de desenvolvimento:
Windows 10
JDK 11 LTS
VS CODE (Java Extension Pack)
### Bibliotecas JAVA
GSON
## Problemas de Resolução na Opção 2 do menu
![Exemplo de exibição ideal](https://i.ibb.co/Fsr0904/Screenshot-2.png)
Caso a resolução da tabela na opção dois do menu fique estranha, é só alterar o parâmetro de **TAMANHO** código fonte, nos seguintes trechos, diminuindo de acordo com sua resolução de tela.

    Board board = new Board(TAMANHO);
    String tableString = board.setInitialBlock(new Table(board, TAMANHO, headersList, rowsList).tableToBlocks()).build().getPreview();




