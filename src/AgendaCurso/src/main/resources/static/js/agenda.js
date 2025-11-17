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
    const btnsEntrar = document.querySelectorAll(".btnEntrar");
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
                const response = yield fetch(`/api/turma/sairTurma/${turmaId}`, {
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
    btnsEntrar.forEach(button => {
        if (!(button instanceof HTMLButtonElement)) {
            return;
        }
        button.addEventListener("click", () => __awaiter(void 0, void 0, void 0, function* () {
            const diciplinaId = button.dataset.id;
            if (!diciplinaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            }
            const ddlTurma = document.getElementById("ddlEntrarTurma_" + diciplinaId);
            if (ddlTurma) {
                const idTurma = ddlTurma.value;
                if (idTurma != null && idTurma != "0") {
                    try {
                        const response = yield fetch(`/api/turma/entrarTurma/${idTurma}`, {
                            method: 'POST'
                        });
                        if (response.ok) {
                            +window.location.reload();
                        }
                        else {
                            if (response.status === 409) {
                                const errorMessage = yield response.text();
                                alert(`Não foi possível entrar: ${errorMessage}`);
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
                }
            }
        }));
    });
});
export {};
//# sourceMappingURL=agenda.js.map