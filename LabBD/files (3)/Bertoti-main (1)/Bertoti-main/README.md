# Laboratorio de Banco de Dados III 👩‍💻

## ATIVIDADE 1

 [Atividade](./lab3/projeto1)
 
<img width="1216" height="624" alt="image" src="https://github.com/user-attachments/assets/7808e107-746c-4b9f-86ed-e5f45d340108" />

<img width="1100" height="543" alt="image" src="https://github.com/user-attachments/assets/7695aedc-4c15-4cb2-b7bd-e8cf10bdedac" />





# ENGENHARIA DE SOFTWARE 💻

## ATIVIDADE 1
"What precisely do we mean by software engineering? What distinguishes “software engineering” from “programming” or “computer science”? And why would Google have a unique perspective to add to the corpus of previous software engineering literature written over the past 50 years? The terms “programming” and “software engineering” have been used interchangeably for quite some time in our industry, although each term has a different emphasis and different implications. University students tend to study computer science and get jobs writing code as “programmers.” “Software engineering,” however, sounds more serious, as if it implies the application of some theoretical knowledge to build something real and precise. Mechanical engineers, civil engineers, aeronautical engineers, and those in other engineering disciplines all practice engineering. They all work in the real world and use the application of their theoretical knowledge to create something real. Software engineers also create “something real,” though it is less tangible than the things other engineers create. Unlike those more established engineering professions, current software engineering theory or practice is not nearly as rigorous. Aeronautical engineers must follow rigid guidelines and practices, because errors in their calculations can cause real damage; programming, on the whole, has traditionally not followed such rigorous practices. But, as software becomes more integrated into our lives, we must adopt and rely on more rigorous engineering methods. We hope this book helps others see a path toward more reliable software practices."

**R:** O trecho estabelece uma distinção fundamental entre programação, ciência da computação e engenharia de software, conceitos que frequentemente se confundem. Os autores questionam o verdadeiro significado de "engenharia de software" e por que essa prática merece um tratamento diferenciado.

O ponto central é que, diferentemente das engenharias tradicionais, como a mecânica ou a civil, que produzem objetos físicos previsíveis, o software possui uma natureza intangível e mutável. Um edifício ou uma ponte funcionam de maneira consistente em qualquer lugar, seguindo normas técnicas consolidadas. Já o software comporta-se de forma variável: o mesmo programa pode apresentar desempenhos diferentes dependendo do dispositivo, sistema operacional, qualidade da conexão ou número de usuários simultâneos.

Essa característica intangível e imprevisível torna o desenvolvimento de software um processo muito mais complexo e dinâmico. Os autores argumentam que, à medida que o software se torna essencial para a sociedade, precisamos adotar métodos de engenharia mais rigorosos e científicos. É um chamado para profissionalizar a área, tratando a engenharia de software com a mesma seriedade das engenharias estabelecidas, garantindo confiabilidade mesmo diante da volatilidade dos ambientes digitais.

---

## ATIVIDADE 2
"Programming Over Time
We propose that “software engineering” encompasses not just the act of writing code, but all of the tools and processes an organization uses to build and maintain that code over time. What practices can a software organization introduce that will best keep its code valuable over the long term? How can engineers make a codebase more sustainable and the software engineering discipline itself more rigorous? We don’t have fundamental answers to these questions, but we hope that Google’s collective experience over the past two decades illuminates possible paths toward finding those answers. One key insight we share in this book is that software engineering can be thought of as “programming integrated over time.” What practices can we introduce to our code to make it sustainable—able to react to necessary change—over its life cycle, from conception to introduction to maintenance to deprecation?
The book emphasizes three fundamental principles that we feel software organizations should keep in mind when designing, architecting, and writing their code:

Time and Change
-How code will need to adapt over the length of its life
-Scale and Growth
-How an organization will need to adapt as it evolves
-Trade-offs and Costs
How an organization makes decisions, based on the lessons of Time and Change and Scale and Growth"

**R:** Neste segundo trecho, os autores aprofundam o conceito que começaram a desenvolver anteriormente, trazendo uma definição bem clara do que seria engenharia de software na visão do Google.
A sacada principal é essa: engenharia de software não é só sentar e escrever código. É todo o ecossistema de ferramentas, processos e práticas que uma organização usa pra construir e, principalmente, **manter** esse código funcionando ao longo do tempo.
Eles trazem uma frase que resume tudo: engenharia de software é **"programação integrada ao longo do tempo"**. É pensar: eu escrevi o código hoje, mas e daqui a 2 anos? E quando precisar mudar? E quando a equipe crescer? O código vai continuar fazendo sentido? Vai ser fácil de modificar?
A questão central é sobre sustentabilidade, como fazer um código que consiga reagir às mudanças inevitáveis durante todo seu ciclo de vida, desde quando é só uma ideia até quando precisa ser descontinuado.

Pra organizar esse pensamento, o livro se estrutura em torno de três princípios fundamentais:
1. **Tempo e Mudança** -O software precisa evoluir constantemente, novas funcionalidades, tecnologias obsoletas e bugs emergem ao longo do tempo. A engenharia de software deve garantir que o código seja facilmente modificável no futuro, não apenas funcional hoje.
2. **Escala e Crescimento** - Conforme a organização cresce, o volume de código e desenvolvedores aumenta. O que funciona com poucos pode se tornar inviável com muitos. É preciso criar estruturas que permitam escalar sem perder qualidade.
3. **Trade-offs e Custos** - Toda decisão envolve compromissos: velocidade versus qualidade, flexibilidade versus complexidade. A engenharia madura avalia conscientemente esses trade-offs considerando longevidade, equipe e custos reais, buscando o sustentável, não apenas o possível.
---

## ATIVIDADE 3
**1. Monolito vs Microsserviços**
O dilema: Manter tudo em uma aplicação única ou dividir em serviços independentes?
Trade-offs envolvidos:

Monolito é mais simples de desenvolver, deployar e debugar. Tudo está junto, você consegue rastrear o fluxo facilmente, não precisa lidar com comunicação entre serviços, e as transações são diretas. Mas conforme o sistema cresce, fica mais difícil de manter, qualquer mudança pode afetar tudo, e você não consegue escalar partes específicas independentemente.
Microsserviços permitem que times trabalhem independentemente, você escala só o que precisa, pode usar tecnologias diferentes para problemas diferentes, e falhas ficam isoladas. Porém, a complexidade operacional explode - você precisa gerenciar comunicação entre serviços, latência de rede, consistência distribuída, monitoramento complexo, e deployments coordenados.

Na prática: Netflix usa microsserviços porque precisa escalar streaming independentemente de recomendações. Mas uma startup com 3 desenvolvedores provavelmente vai sofrer tentando gerenciar 20 microsserviços quando um monolito bem feito resolveria.


**2. Segurança vs Usabilidade**
O dilema: Tornar o sistema super seguro ou super fácil de usar?
Trade-offs envolvidos:

Segurança máxima significa autenticação de dois fatores, senhas complexas, timeout curto de sessão, criptografia em tudo, múltiplas confirmações para ações sensíveis. Seus dados estão protegidos, mas os usuários vão reclamar de tanta fricção - "por que preciso colocar senha de novo?" ou "essa senha precisa ter 20 caracteres?".
Usabilidade máxima é login social com um clique, sessões que nunca expiram, lembrar todas as preferências, zero barreiras. Os usuários adoram a experiência fluida, mas você aumenta drasticamente a superfície de ataque e os riscos de segurança.

Na prática: Um app bancário vai pesar mais pra segurança - melhor ter usuários incomodados que contas invadidas. Já um jogo casual mobile pode priorizar usabilidade - ninguém quer ficar colocando senha toda vez que abre o jogo. O truque é encontrar o equilíbrio: segurança onde importa, sem adicionar fricção desnecessária.


**3. Build vs Buy**
O dilema: Desenvolver uma solução própria ou usar algo pronto do mercado?
Trade-offs envolvidos:

Build (construir) te dá controle total, customização perfeita pro seu caso, sem dependência de terceiros, e você não paga licenças. Mas consome muito tempo e recursos, você precisa manter e evoluir a solução, tem que lidar com todos os bugs, e provavelmente vai reinventar a roda em muitos aspectos.
Buy (comprar) significa solução rápida, suporte profissional, atualizações automáticas e best practices embutidas. Você foca no seu core business em vez de problemas já resolvidos. Porém, você paga continuamente (custos de licença), fica preso ao vendor, tem menos flexibilidade pra customizar, e depende da roadmap de outra empresa.

Na prática: Não faz sentido construir seu próprio sistema de pagamentos quando Stripe existe. Mas o algoritmo de recomendação que é o diferencial competitivo da sua empresa? Aí talvez valha construir. Amazon construiu AWS porque precisava, mas usa serviços terceiros pra coisas como email marketing. A pergunta é sempre: "isso é core pro nosso negócio ou é commodity?" 


---

## ATIVIDADE 4
<img width="1035" height="549" alt="image" src="https://github.com/user-attachments/assets/d758dfbf-216b-416f-af94-a61f4b4a94f5" />


---

## ATIVIDADE 5
```java
import java.util.LinkedList;
import java.util.List;

public class Mercado {
   
    private List<Cliente> clientes = new LinkedList<>();
    
    public void addClientes(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public List<Cliente> buscarClienteNome(String nome) {
        List<Cliente> encontrados = new LinkedList<Cliente>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome))
                encontrados.add(cliente);  
        }
        return encontrados;
    }
    
    public Cliente buscarClienteCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;  
            }
        }
        return null;
    }
    
    public List<Cliente> verificarCartao(boolean possuiCartao) {
        List<Cliente> encontrados = new LinkedList<Cliente>();
        for (Cliente cliente : clientes) {
            if (cliente.isCartao() == possuiCartao) {
                encontrados.add(cliente);  
            }
        }
        return encontrados;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
}
```
```java
public class Cliente {
    private String nome;
    private String cpf;
    private boolean cartao;
    
    public Cliente(String nome, String cpf, boolean cartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartao = cartao;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public boolean isCartao() {
        return cartao;
    }
    
    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }
}
```

---

## ATIVIDADE 6
```java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Teste {
    @Test
    void test() {
        Mercado mercadinho = new Mercado();
        mercadinho.addClientes(new Cliente("Maria", "12345678910", true));
        assertEquals(1, mercadinho.getClientes().size());
        List<Cliente> clientesComCartao = mercadinho.verificarCartao(true);
        
        System.out.println("Clientes com cartão: " + clientesComCartao.size());
        List<Cliente> busca = mercadinho.buscarClienteNome("Maria");
        assertEquals("12345678910", busca.get(0).getCpf());
    }
}
```

## ATIVIDADE 7
  [Integração com SQLite](./engenhariadesoftware/Atividade7)

 ---

 ## ATIVIDADE 8
```java
package com.mariaeduarda;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws OllamaBaseException, IOException, InterruptedException {
        String host = "http://127.0.0.1:11434/";
        String modelName = "qwen3:1.7b";
        
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(60);
        
        String result = ollamaAPI.generate(modelName,"O que é Java?", false);
        System.out.println(result);
    }
}
```
