<h2 align=center>Challenge ONE Back End - Java</h2>

# Sprint 01: Crie seu próprio conversor de moeda

## História

Nesta oportunidade foi solicitado para nós Devs a criação de um conversor de moeda utilizando a linguagem Java. As características solicitadas por nosso cliente são as seguintes:

O conversor de moeda deveria:- Converter de Reais a Dólar- Converter de Reais a Euro- Converter de Reais a Libras Esterlinas- Converter de Reais a Peso argentino- Converter de Reais a Peso Chileno

Além de fazer que seja possível converter de forma inversa ou seja:

        - Converter de Dólar a Reais
        - Converter de Euro a Reais
        - Converter de Libras Esterlinas a Reais
        - Converter de Peso argentino a  Reais
        - Converter de Peso Chileno a Reais

Como desafio extra foi incentivado que se fizesse outro conversor, à nossa escolha, que suprisse uma necessidade que tivéssemos. Nisso resolvi implementar um conversor de sistemas numéricos,
variando entre Decimal, Binário, Octal e Hexadecimal, pois lembrei da necessidade que tive de fazer estas conversões durante o período passado na faculdade.

## Implementação

Para o conversor de moedas, fiz uso da API <a href="https://exchangeratesapi.io/">https://exchangeratesapi.io/</a> com o intuito de ter valores de conversão dinâmicos e atualizados.
Utilizei de telas de alerta para tratar erros possíveis, implementei um texto dinâmico da cifra que indicasse qual conversão estaria sendo feita e implementei uma navegação fluida entre as telas.

Para o conversor de sistemas numéricos, alterei um pouco a tela de conversão, oferecendo um textField dinâmico, e que permitisse copiar o resultado adquirido. Além disso, fiz um botão de inversão, 
para que facilmente pudesse ser feita a conversão de volta.

## Resultado
<a href="https://github.com/lauromaia/conversorOne/blob/main/out/artifacts/ConversorOne_jar/ConversorOne.jar?raw=true">
Download JAR<a>

## Tecnologias utilizadas

- Linguagem: Java 8
- IDE: <a href="https://www.jetbrains.com/idea/">IntelliJ IDEA</a>
- Inteface <a href="https://openjfx.io/">JavaFX</a> com o uso do <a href="https://gluonhq.com/products/scene-builder/">Scene Builder</a> 
- Exchange Rates API: <a href="https://exchangeratesapi.io/">https://exchangeratesapi.io/</a>

