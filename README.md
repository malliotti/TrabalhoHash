# Trabalho Hash
Trabalho 2 - Algoritmos e Programação 3

#Objetivo
Neste trabalho, seu objetivo é recuperar rapidamente os dados relativos a uma rota de ônibus da cidade de Porto
Alegre, e demonstrar que o uso de uma tabela hash é mais eficiente que uma lista encadeada para esta aplicação.
Tarefas
1. Implementar uma tabela hash utilizando Robin Hood Hashing.
2. Armazenar os dados das rotas de ônibus de Porto Alege na tabela criada.
3. Mostrar quanto o uso da tabela hash acelera o processamento em relação ao uso de uma lista encadeada.
Os dados para as rotas de ônibus de Porto Alegre, atualizados em Agosto de 2016, podem ser encontrados em
http://datapoa.com.br/storage/f/2016-08-29T18%3A00%3A48.089Z/outputfiles.zip

#Robin Hood Hashing

O método Robin Hood Hashing é uma forma de probe linear porém ele acelera o tempo médio a consultas ao
agrupar os elementos o mais próximo possível de onde deveriam ser inseridos.
A função de inserção (Algoritmo 1) procura por um slot disponível na tabela a partir do ponto onde o elemento
deveria ser inserido, e, caso o elemento sendo inserido estiver em uma posição mais longe de onde deveria, em relação
ao elemento que já está na tabela, eles são trocados, com o novo elemento entrando no lugar do antigo, e o antigo
elemento passa a ser o novo elemento a ser inserido.
Dessa forma, a consulta (Algoritmo 2) pode ser acelerada, não sendo necessário procurar por toda a tabela, uma
vez que basta que a distância seja maior que a distância do elemento na tabela para que o elemento não exista na
tabela.
A remoção (Algoritmo 3) de um elemento da tabela não pode ser realizada “fisicamente”, uma vez que o elemento
na tabela contém a distância que foi utilizada para incluí-lo e ela é importante. No entanto, a remoção lógica, além
de simples e eficiente é suficiente para que o slot esteja novamente disponível, e possa ser utilizado novamente (ao
contrário dos probes linear e quadrático).

#Algoritmo 1 Inserção em uma Robin Hood Hash
    função insere (key, value)
        se tabela.cheia()
    rehash()
    h = hash(key)
    entrada = HashEntry(key, value, h)
    i = mod(h & 0x7ffffff, tabela.length)
    enquanto ! livre(tabela[i])
    se entrada.probe < tabela[i].probe
       swap(entrada, tabela[i])
    senao
       incerementa entrada.probe
    i = mod(i + 1, tabela.length)
    tabela.set(i, entrada)
    
#Algoritmo 2 Consulta em uma Robin Hood Hash
    function consulta(key) -> value
         h = hash(key)
         i = mod(h & 0x7ffffff, tabela.length)
         probe = 0
         enquanto ! livre(tabela) e probe <= tabela[i].probe
             se tabela[i].hash == h e tabela[i].key == key
                retorna tabela[i].value
             i = mod(i + 1, tabela.length)
             probe = probe + 1
        retorna NULL
        
#Algoritmo 3 Remoção em uma Robin Hood Hash
    function remove(key)
        elemento = localiza_elemento(key)
        se valid(elemento)
            elemento.removido = TRUE

