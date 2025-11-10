# Regras de Negócio – Módulo Agenda de Cursos

## Finalidade
Este documento descreve as regras de negócio que orientam o funcionamento do módulo Agenda de Cursos.  
Essas regras definem restrições, condições e comportamentos obrigatórios que garantem a integridade dos agendamentos e a correta gestão de cursos, instrutores, salas e alunos.

---

## Regras de Negócio

### 1. Agendamento
- **RN001** – Um curso não pode ser agendado em datas passadas.  
- **RN002** – Não é permitido conflito de horário entre cursos, instrutores ou salas.  
- **RN003** – Cada sala pode estar associada a apenas um curso por horário.  
- **RN004** – Alterações de horários devem ser validadas pelo administrador antes da confirmação.  
- **RN005** – Cancelamentos devem registrar o motivo, a data e o responsável pela ação.  

### 2. Participação e Inscrições
- **RN006** – Um aluno não pode estar inscrito em dois cursos com horários sobrepostos.  
- **RN007** – Apenas aulas confirmadas podem ser visualizadas pelos alunos.  
- **RN008** – Em caso de cancelamento de curso, o sistema deve notificar automaticamente os alunos e o instrutor envolvidos.  

### 3. Notificações e Alertas
- **RN009** – O sistema deve emitir alertas automáticos quando houver tentativa de agendamento com conflito de horário.  
- **RN010** – O sistema deve enviar avisos automáticos antes do início de cada curso.  

### 4. Relatórios e Controle
- **RN011** – O sistema deve gerar relatórios de ocupação da agenda por turma, instrutor e período.  
- **RN012** – O sistema deve registrar o histórico de alterações na agenda, incluindo criação, edição e cancelamento.  

### 5. Administração e Acesso
- **RN013** – Somente administradores autenticados podem aprovar alterações de horário e exclusões.  
- **RN014** – Usuários só podem visualizar ou alterar informações de acordo com seu perfil de acesso (aluno, instrutor ou administrador).  

---

## Versão 

**Versão:** 2.0 

---
