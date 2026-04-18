# 🧾 Sistema de Controle de Funcionários (CLI) - Java

## 📌 Sobre o projeto

Este projeto é um sistema de controle de funcionários desenvolvido em **Java puro (sem frameworks)**, executado via **linha de comando (CLI)**.

O objetivo é praticar conceitos fundamentais de programação orientada a objetos (POO), como:

* Herança
* Polimorfismo
* Encapsulamento
* Uso de enums
* Separação de responsabilidades (model/service)

---

## 🚀 Funcionalidades

* ✅ Cadastro de funcionários
* ✅ Geração automática de ID
* ✅ Listagem de funcionários
* ✅ Busca por ID
* ✅ Remoção de funcionário
* ✅ Cálculo de salário
* ✅ Validação de status (ATIVO, FÉRIAS, INATIVO)

---

## 🧠 Regras de negócio

* Funcionários **INATIVOS ou de FÉRIAS** não têm salário calculado
* Cada tipo de funcionário possui sua própria regra de cálculo:

  * CLT → salário base + bonificação
  * Freelancer por hora → horas trabalhadas × valor da hora
  * Freelancer por diária → dias trabalhados × valor da diária

---

## 🏗️ Estrutura do projeto

```
src/
 ├── model/
 │    ├── Funcionario.java
 │    ├── FuncionarioCLT.java
 │    ├── FuncionarioFreeLancer.java
 │    ├── FreelancerHora.java
 │    └── FreelancerDiaria.java
 │
 ├── enums/
 │    └── FuncionarioStatus.java
 │
 ├── service/
 │    ├── FuncionarioService.java
 │    └── FolhaPagamentoService.java
 │
 ├── view/
 │    └── Menu.java
 │
 └── Main.java
```

---

## ⚙️ Tecnologias utilizadas

* Java
* Programação orientada a objetos
* Estruturas de dados (`Map`, `List`)
* `AtomicInteger` para geração de IDs

---

## 💡 Aprendizados

Durante o desenvolvimento deste projeto foram aplicados:

* Uso de **polimorfismo** para evitar condicionais (`if/else`)
* Separação de responsabilidades entre `model` e `service`
* Uso de `Map` para otimizar buscas por ID (O(1))
* Boas práticas de organização de código em Java

---

## 📈 Melhorias futuras

* [ ] Persistência em arquivo `.txt`
* [ ] Interface gráfica (Swing ou JavaFX)
* [ ] Testes unitários
* [ ] Sistema de login
