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
    const erroInputNome = document.getElementById("erroInputNome");
    if (!(inputNome instanceof HTMLInputElement) || !(btnAdicionar instanceof HTMLButtonElement)) {
        console.error('Falha ao carregar elementos do formulário de professor.');
        return;
    }
    btnsDeletar.forEach(button => {
        if (!(button instanceof HTMLButtonElement)) {
            return;
        }
        button.addEventListener("click", () => __awaiter(void 0, void 0, void 0, function* () {
            const diciplinaId = button.dataset.id;
            if (!diciplinaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            }
            ;
            try {
                const response = yield fetch(`/api/diciplina/deletar/${diciplinaId}`, {
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
    btnAdicionar.addEventListener("click", () => __awaiter(void 0, void 0, void 0, function* () {
        inputNome.disabled = true;
        btnAdicionar.disabled = true;
        const nome = inputNome.value;
        if (nome.trim() === "") {
            //@ts-ignore
            erroInputNome.innerText = "Insira um nome.";
            inputNome.disabled = false;
            btnAdicionar.disabled = false;
        }
        else {
            //@ts-ignore
            erroInputNome.innerText = "";
            try {
                const response = yield fetch(`/api/diciplina/add/${nome}`, {
                    method: 'POST',
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
                console.error('Falha ao adicionar diciplina:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                }
                else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }
        }
        inputNome.disabled = false;
        btnAdicionar.disabled = false;
    }));
});
export {};
//# sourceMappingURL=diciplina.js.map