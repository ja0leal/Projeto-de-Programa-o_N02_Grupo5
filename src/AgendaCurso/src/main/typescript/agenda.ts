interface ProfessorResponse {
    idProfessor: number;
    nome: string;
}

document.addEventListener("DOMContentLoaded", () => {
    const btnsDeletar = document.querySelectorAll(".btnDeletar");
    const btnsEntrar = document.querySelectorAll(".btnEntrar");

    btnsDeletar.forEach(button => {
        if(!(button instanceof HTMLButtonElement)) {return;}
        button.addEventListener("click", async () => {
            const turmaId = button.dataset.id;
            if(!turmaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            };

            try {
                const response = await fetch(`/api/turma/sairTurma/${turmaId}`, {
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

    btnsEntrar.forEach(button => {
        if(!(button instanceof HTMLButtonElement)) {return;}
        button.addEventListener("click", async () => {
            const diciplinaId = button.dataset.id;
            if(!diciplinaId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            }

            const ddlTurma = document.getElementById("ddlEntrarTurma_" + diciplinaId) as HTMLSelectElement  ;
            if(ddlTurma) {
                const idTurma = ddlTurma.value;
                if(idTurma != null && idTurma != "0") {
                    try {
                        const response = await fetch(`/api/turma/entrarTurma/${idTurma}`, {
                            method: 'POST'
                        })
                        if (response.ok) { +
                            window.location.reload();
                        } else {
                            if (response.status === 409) {
                                const errorMessage = await response.text();
                                alert(`Não foi possível entrar: ${errorMessage}`);
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
                }
            }
        })
    })
})