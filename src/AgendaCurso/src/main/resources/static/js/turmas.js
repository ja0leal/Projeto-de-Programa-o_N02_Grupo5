var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
document.addEventListener("DOMContentLoaded", () => {
    const btnsDeletar = document.querySelectorAll(".btnDeletar");
    const btnAdicionar = document.getElementById("btnAdicionar");
    const inputNome = document.getElementById("inputNome");
    const selectDiciplina = document.getElementById('inputIdDiciplina');
    const selectProfessor = document.getElementById('inputIdProfessor');
    const erroInputNome = document.getElementById("erroInputNome");
    const sucessInputNome = document.getElementById("sucessInputNome");
    if (!(inputNome instanceof HTMLInputElement) || !(btnAdicionar instanceof HTMLButtonElement)) {
        console.error('Falha ao carregar elementos do formulário de professor.');
        return;
    }
    btnsDeletar.forEach(button => {
        if (!(button instanceof HTMLButtonElement)) {
            return;
        }
        button.addEventListener("click", () => __awaiter(void 0, void 0, void 0, function* () {
            const turmaId = button.dataset.id;
            if (!turmaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            }
            ;
            try {
                const response = yield fetch(`/api/turma/deletar/${turmaId}`, {
                    method: 'DELETE'
                });
                if (response.ok) {
                    +window.location.reload();
                }
                else {
                    if (response.status === 409) {
                        const errorMessage = yield response.text();
                        alert(`Não foi possível excluir: ${errorMessage}`);
                    }
                    else {
                        alert(`Ocorreu um erro desconhecido (Status: ${response.status}).`);
                    }
                }
            }
            catch (error) {
                console.error('Falha sair de turma:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                }
                else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }
        }));
    });
    btnAdicionar.addEventListener("click", (event) => __awaiter(void 0, void 0, void 0, function* () {
        if (inputNome.value.trim() === "") {
            // @ts-ignore
            erroInputNome.innerText = "Insira um nome";
            return;
        }
        else {
            // @ts-ignore
            erroInputNome.innerText = "";
        }
        if (selectDiciplina && selectProfessor) {
            selectProfessor.disabled = true;
            selectDiciplina.disabled = true;
            inputNome.disabled = true;
            btnAdicionar.disabled = true;
            const nome = inputNome.value.trim();
            const idDiciplina = selectDiciplina.value;
            const idProfessor = selectProfessor.value;
            const data = {
                nome: nome,
                idDiciplina: idDiciplina,
                idProfessor: idProfessor
            };
            try {
                const response = yield fetch("/api/turma/add", {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(data)
                });
                if (response.ok) {
                    const novaTurma = yield response.json();
                    console.log(novaTurma.idTurma);
                }
                window.location.reload();
            }
            catch (error) {
                console.error('Falha ao adicionar professor:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                }
                else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }
            finally {
                selectProfessor.disabled = true;
                selectDiciplina.disabled = true;
                inputNome.disabled = true;
                btnAdicionar.disabled = true;
            }
        }
    }));
});
export {};
//# sourceMappingURL=turmas.js.map