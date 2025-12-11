# 📱 GoalTracker App

Aplicativo Android desenvolvido com **Kotlin + Jetpack Compose**, focado em **arquitetura limpa, performance e estados reativos**.  
Permite criar, listar, atualizar e remover tarefas com uma interface moderna e responsiva.

---

## 🚀 Tecnologias Utilizadas

**Linguagem**
- Kotlin

**UI**
- Jetpack Compose  
- Material 3  
- Theming

**Arquitetura**
- MVVM  
- Clean Architecture  
- Repository Pattern  
- Use Cases

**Injeção de Dependências**
- Koin

**Reatividade e Concorrência**
- Kotlin Coroutines  
- StateFlow / MutableStateFlow

**Navegação**
- Navigation Compose

**Boas Práticas**
- Estados imutáveis  
- Regras de recomposição  
- Separação clara de camadas  
- Código limpo e performático

---

## 📋 Funcionalidades

✔ Criar nova tarefa  
✔ Editar tarefa existente  
✔ Marcar como concluída  
✔ Listar todas as tarefas  
✔ Excluir tarefa  
✔ Navegação entre telas usando Compose  
✔ Gerenciamento de estado com Flow  
✔ Arquitetura desacoplada e escalável  

---

## 📸 Screenshots

<table>
  <tr>
    <td align="center">
      <strong>Create Task</strong><br>
      <img width="1080" height="2220" alt="Screenshot_20251204_232055" src="https://github.com/user-attachments/assets/683241dd-8585-411b-be5a-650e37bba7e0" />
    </td>
    <td align="center">
      <strong>Task List</strong><br>
      <img width="1080" height="2220" alt="Screenshot_20251204_231958" src="https://github.com/user-attachments/assets/35a097de-2d4c-4925-b2ce-5cb961b8651b" />
    </td>
  </tr>
</table>

---

## 🧱 Estrutura do Projeto

/data
└── repositories
└── models

/domain
└── usecases

/presentation
└── screens
└── viewmodels

/di
└── koin modules



Focado em **separação de responsabilidades**, facilidade de testes e manutenção.

---

## 🧪 Como Rodar o Projeto

1. Clone o repositório:

git clone https://github.com/ApoloRossi/ToDoPerformanceApp.git

2. Abra no Android Studio Hedgehog (ou superior).

3. Rode o app:
Run → Run 'app'

🧩 Possíveis Melhorias Futuras

Persistência local com Room ou DataStore

Testes unitários com JUnit + MockK

Testes de UI com Compose Testing

Animações usando Compose Animation

Modularização completa (app/data/domain/presentation)
