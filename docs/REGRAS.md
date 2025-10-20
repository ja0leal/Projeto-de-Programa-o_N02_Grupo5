# REGRAS DE NEGÓCIO — Módulo: Agenda de Cursos
v1.0 — Grupo 5 


## Regras principais
1. **Quem pode se inscrever/agir na agenda:** Ações são controladas por papel:
   - `ALUNO`: consulta agenda e solicita inscrições/inscrições relacionadas à turma.
   - `INSTRUTOR`: cria/edita suas aulas/turmas.
   - `ADMIN`: supervisiona agenda, aprova alterações e resolve conflitos.
   - Erro: `"Ação não autorizada para seu papel."`

2. **Inscrição / registro por curso/turma:** não permitir duplicidade de inscrição ativa (`user_id` + `course_id`) enquanto existir inscrição com `status != CANCELLED`.

3. **Pré-requisitos (se aplicável ao contexto de turmas):** quando um curso exigir pré-requisito, todos os pré-requisitos devem estar marcados como concluídos pelo usuário para que a inscrição seja permitida. Erro: `"Pré-requisitos não atendidos: [lista]"`

4. **Limite de vagas / capacidade (se o módulo incluir controle de vagas por turma):**
   - Se `enrolledCount < capacity` → `ENROLLED`.
   - Caso contrário → `WAITLISTED` (lista de espera).
   - Mensagem: `"Curso sem vagas. Você foi adicionado à lista de espera."`

5. **Lista de espera (FIFO):** ordenada por `createdAt`. Promoção automática ao liberar vaga (cancelamento ou aumento de `capacity`), promovendo o primeiro candidato elegível.

6. **Conflito de horário (regra central do módulo):**
   - `ClassSession` contém `startTime`, `endTime`, `location`.
   - Rejeitar inscrição ou aceitar edição que cause overlap com sessões onde o usuário já está `ENROLLED`.
   - Overlap detectado quando `!(a.end <= b.start || b.end <= a.start)`.
   - Erro: `"Conflito de horário com curso: <titulo>"`

7. **Validações ao criar/editar sessões:**
   - `startTime < endTime`.
   - Evitar duplicidade exata (`start, end, location`) na mesma turma.
   - Ao alterar/cancelar sessão, notificar inscritos e verificar se a mudança cria novos conflitos.

8. **Estados de inscrição / registro:**
   - `ENROLLED`, `WAITLISTED`, `CANCELLED`, `COMPLETED`.
   - Todas as transições devem ser auditadas (`who`, `when`, `reason`).

9. **Cancelamento e promoção da fila:**
   - Ao cancelar `ENROLLED`, dentro de uma mesma transação promover o primeiro `WAITLISTED` que atenda requisitos.
   - Se candidato promovido não atender requisitos (pré-reqs, etc.) → pular e tentar próximo; notificar os afetados.

10. **Pagamentos:** **fora do escopo principal** do módulo segundo o documento (não implementar agora), mas se futuramente necessário, usar `PENDING_PAYMENT` e só confirmar `ENROLLED` após pagamento confirmado. (Opcional)

11. **Concorrência e consistência:**
   - Métodos críticos (`enroll`, `cancel`, `promoteWaitlist`) com `@Transactional`.
   - Usar `@Version` (optimistic) ou locks (`SELECT ... FOR UPDATE`) sobre entidade de vaga/capacity se houver risco de inscrição concorrente.

12. **Notificações & logs:**
   - Enviar notificações internas em: inscrição realizada, colocado em espera, promovido, cancelado, alteração de sessão.
   - Registrar eventos em `audit_logs` para rastreabilidade.

## Testes sugeridos
- Inscrição válida (happy path).
- Falha por pré-requisito.
- Falha por conflito de horário (vários cenários de overlap).
- Curso/turma cheia → `WAITLISTED`.
- Cancelamento de `ENROLLED` → promoção correta da fila.
- Edição de sessão → notificações e detecção de novos conflitos.

## Histórico
- v1.0 — (20/10/2025) — Regras iniciais 

