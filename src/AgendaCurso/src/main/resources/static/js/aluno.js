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
    const btnAdicionar = document.getElementById("btnAdicionar");
    const inputNome = document.getElementById("inputNome");
    const inputSenha = document.getElementById("inputNome");
    const ddlRole = document.getElementById("ddlRole");
    const erroInputNome = document.getElementById("erroInputNome");
    if (!(inputNome instanceof HTMLInputElement) ||
        !(btnAdicionar instanceof HTMLButtonElement) ||
        !(inputSenha instanceof HTMLInputElement) ||
        !(ddlRole instanceof HTMLSelectElement)) {
        console.error('Falha ao carregar elementos do formulário de professor.');
        return;
    }
    btnAdicionar.addEventListener("click", () => __awaiter(void 0, void 0, void 0, function* () {
        inputNome.disabled = true;
        inputSenha.disabled = true;
        btnAdicionar.disabled = true;
        const nome = inputNome.value.trim();
        const senha = inputSenha.value.trim();
        if (nome === "") {
            // @ts-ignore
            erroInputNome === null || erroInputNome === void 0 ? void 0 : erroInputNome.innerText = "Insira um nome.";
        }
        else {
            // @ts-ignore
            erroInputNome === null || erroInputNome === void 0 ? void 0 : erroInputNome.innerText = "";
        }
        if (senha === "") {
            // @ts-ignore
            erroInputNome === null || erroInputNome === void 0 ? void 0 : erroInputNome.innerText = "Insira uma senha.";
        }
        else {
            // @ts-ignore
            erroInputNome === null || erroInputNome === void 0 ? void 0 : erroInputNome.innerText = "";
        }
        if (senha !== "" && nome !== "") {
            const data = {
                nome: nome,
                senha: senha,
                role: ddlRole.value
            };
            try {
                const response = yield fetch('/api/aluno/add', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(data)
                });
                if (response.ok) {
                    +window.location.reload();
                }
                else {
                    if (response.status === 409) {
                        const errorMessage = yield response.text();
                        alert(`Não foi possível adicionar: ${errorMessage}`);
                    }
                    else {
                        alert(`Ocorreu um erro desconhecido (Status: ${response.status}).`);
                    }
                }
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
        }
        inputNome.disabled = false;
        inputSenha.disabled = false;
        btnAdicionar.disabled = false;
    }));
});
export {};
//# sourceMappingURL=aluno.js.map