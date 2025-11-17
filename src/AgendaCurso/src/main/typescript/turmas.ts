interface TurmaRequestAdd {
    nome: string;
    idDiciplina: string;
    idProfessor: string;
}

interface TurmaResponse {
    idTurma: number;
    nome: string;
    idDiciplina: number;
    idProfessor: number;
}

document.addEventListener("DOMContentLoaded", () => {
    const btnsDeletar = document.querySelectorAll(".btnDeletar");
    const btnAdicionar = document.getElementById("btnAdicionar");
    const inputNome = document.getElementById("inputNome");
    const selectDiciplina = document.getElementById('inputIdDiciplina') as HTMLSelectElement;
    const selectProfessor = document.getElementById('inputIdProfessor') as HTMLSelectElement;
    const erroInputNome = document.getElementById("erroInputNome");
    const sucessInputNome = document.getElementById("sucessInputNome");

    if (!(inputNome instanceof HTMLInputElement) || !(btnAdicionar instanceof HTMLButtonElement)) {
        console.error('Falha ao carregar elementos do formulário de professor.');
        return;
    }
    btnsDeletar.forEach(button => {
        if(!(button instanceof HTMLButtonElement)) {return;}
        button.addEventListener("click", async () => {
            const turmaId = button.dataset.id;
            if(!turmaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            };

            try {
                const response = await fetch(`/api/turma/deletar/${turmaId}`, {
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

    btnAdicionar.addEventListener("click", async (event) => {

        if (inputNome.value.trim() === "") {
            // @ts-ignore
            erroInputNome.innerText = "Insira um nome";
            return
        } else {
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
            const data: TurmaRequestAdd = {
                nome: nome,
                idDiciplina: idDiciplina,
                idProfessor: idProfessor
            }

            try{
                const response = await fetch("/api/turma/add",{
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(data)
                })

                if(response.ok){
                    const novaTurma: TurmaResponse = await response.json();
                    console.log(novaTurma.idTurma);
                }
                window.location.reload();

            }catch (error) {
                console.error('Falha ao adicionar professor:', error);
                if (error instanceof Error) {
                    alert(`Ocorreu um erro: ${error.message}`);
                } else {
                    alert('Ocorreu um erro desconhecido.');
                }
            }finally {
                selectProfessor.disabled = true;
                selectDiciplina.disabled = true;
                inputNome.disabled = true;
                btnAdicionar.disabled = true;
            }
        }
    })
})

