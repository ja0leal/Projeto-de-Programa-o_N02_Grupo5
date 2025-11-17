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
        if(!(button instanceof HTMLButtonElement)) {return;}
        button.addEventListener("click", async () => {
            const diciplinaId = button.dataset.id;
            if(!diciplinaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            };

            try {
                const response = await fetch(`/api/diciplina/deletar/${diciplinaId}`, {
                    method: 'DELETE'
                })
                if (response.ok) { +
                    window.location.reload();
                } else {
                    if (response.status === 409) {
                        const errorMessage = await response.text();
                        alert(`Não foi possível excluir: ${errorMessage}`);
                    } else {
                        alert(`Ocorreu um erro desconhecido (Status: ${response.status}).`);
                    }
                }

            }catch (error) {
                console.error('Falha sair de turma:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                } else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }
        })
    })

    btnAdicionar.addEventListener("click", async () => {
        inputNome.disabled = true;
        btnAdicionar.disabled = true;
        const nome = inputNome.value;
        if(nome.trim() === ""){
            //@ts-ignore
            erroInputNome.innerText = "Insira um nome."
            inputNome.disabled = false;
            btnAdicionar.disabled = false;

        }else{
            //@ts-ignore
            erroInputNome.innerText = ""
            try{
                const response = await fetch(`/api/diciplina/add/${nome}`, {
                    method: 'POST',
                })

                if (response.ok) { +
                    window.location.reload();
                } else {
                    if (response.status === 409) {
                        const errorMessage = await response.text();
                        alert(`Não foi possível excluir: ${errorMessage}`);
                    } else {
                        alert(`Ocorreu um erro desconhecido (Status: ${response.status}).`);
                    }
                }

            }catch (error) {
                console.error('Falha ao adicionar diciplina:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                } else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }

        }
        inputNome.disabled = false;
        btnAdicionar.disabled = false;

    })
})