interface AlunoAddRequest {
    nome: string;
    senha: string;
    role: string;
}


document.addEventListener("DOMContentLoaded", () => {
    const btnAdicionar = document.getElementById("btnAdicionar");
    const inputNome = document.getElementById("inputNome");
    const inputSenha = document.getElementById("inputNome");
    const ddlRole = document.getElementById("inputNome");
    const erroInputNome = document.getElementById("erroInputNome");

    if (!(inputNome instanceof HTMLInputElement) ||
        !(btnAdicionar instanceof HTMLButtonElement) ||
        !(inputSenha instanceof HTMLInputElement) ||
        !(ddlRole instanceof HTMLSelectElement)){
        console.error('Falha ao carregar elementos do formulário de professor.');
        return;
    }


    btnAdicionar.addEventListener("click", async () => {
        inputNome.disabled = true;
        inputSenha.disabled = true;
        btnAdicionar.disabled = true;

        const nome = inputNome.value.trim();
        const senha = inputSenha.value.trim();

        if(nome === ""){
            // @ts-ignore
            erroInputNome?.innerText = "Insira um nome.";
        }else{
            // @ts-ignore
            erroInputNome?.innerText = "";
        }
        if(senha === ""){
            // @ts-ignore
            erroInputNome?.innerText = "Insira uma senha.";
        }else {
            // @ts-ignore
            erroInputNome?.innerText = "";
        }

        if(senha !== "" && nome !== ""){
            const data: AlunoAddRequest = {
                nome: nome,
                senha: senha,
                role: ddlRole.value
            };

            try {
                const response = await fetch('/api/aluno/add', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(data)
                })

                if (response.ok) { +
                    window.location.reload();
                } else {
                    if (response.status === 409) {
                        const errorMessage = await response.text();
                        alert(`Não foi possível adicionar: ${errorMessage}`);
                    } else {
                        alert(`Ocorreu um erro desconhecido (Status: ${response.status}).`);
                    }
                }
            } catch (error) {
                console.error('Falha ao adicionar professor:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                } else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }
        }
        inputNome.disabled = false;
        inputSenha.disabled = false;
        btnAdicionar.disabled = false;

    })
})