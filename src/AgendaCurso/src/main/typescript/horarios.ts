interface HorarioRequestAdd {
    sala: string;
    dia: number;
    horario: string;
    idTurma: number;
}

interface HorarioResponse {
    idHorario: number;
}

document.addEventListener("DOMContentLoaded", () => {
    const btnAdicionar = document.getElementById("btnAdicionar");
    const inputSala = document.getElementById("inputSala");
    const inputIdTurma = document.getElementById("inputIdTurma");
    const selectHorario = document.getElementById('inputHorario') as HTMLSelectElement;
    const selectDia = document.getElementById('inputDia') as HTMLSelectElement;
    const erroInputSala = document.getElementById("erroInputSala");
    const btnsDeletar = document.querySelectorAll(".btnDeletarHorario");

    if (!(inputSala instanceof HTMLInputElement) || !(btnAdicionar instanceof HTMLButtonElement)) {
        console.error('Falha ao carregar inputSala do formulário de turma.');
        return;
    }

    if (!(inputIdTurma instanceof HTMLInputElement) || !(btnAdicionar instanceof HTMLButtonElement)) {
        console.error('Falha ao carregar inputSala do formulário de turma.');
        return;
    }

    btnsDeletar.forEach(button => {
        if(!(button instanceof HTMLButtonElement)) {return;}
        button.addEventListener("click", async () => {
            const horarioId = button.dataset.id;
            if(!horarioId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            };

            try {
                const response = await fetch(`/api/horario/deletar/${horarioId}`, {
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

        if (inputSala.value.trim() === "") {
            //@ts-ignore
            erroInputSala.innerText = "Insira um nome";
            return
        } else {
            //@ts-ignore
            erroInputSala.innerText = "";
        }
        if (selectHorario.value === "0") {
            //@ts-ignore
            erroInputSala.innerText = "Selecione um horário";
            return
        } else {
            //@ts-ignore
            erroInputSala.innerText = "";
        }
        if (selectDia.value === "0") {
            //@ts-ignore
            erroInputSala.innerText = "Selecione um dia";
            return
        } else {
            //@ts-ignore
            erroInputSala.innerText = "";
        }

        selectHorario.disabled = true;
        selectDia.disabled = true;
        inputSala.disabled = true;
        btnAdicionar.disabled = true;

        const sala = inputSala.value.trim();
        const dia = Number(selectDia.value);
        const horario = selectHorario.value;
        const idTurma = Number(inputIdTurma.value);

        if (isNaN(dia)) {
            console.error("Dia inválido selecionado.");
            return;
        }

        const data: HorarioRequestAdd = {
            sala: sala,
            dia: dia,
            horario: horario,
            idTurma: idTurma
        }

        try {
            const response = await fetch("/api/horario/add", {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(data)
            })

            if (response.ok) {
                const novoHorario: HorarioResponse = await response.json();
                console.log(novoHorario.idHorario);

                if(novoHorario.idHorario == 0){
                    //@ts-ignore
                    erroInputSala.innerText = "Horário já ocupado.";
                }else{
                    //@ts-ignore
                    erroInputSala.innerText = "";
                    window.location.reload();
                }
            }


        } catch (error) {
            console.error('Falha ao adicionar professor:', error);
            if (error instanceof Error) {
                alert(`Ocorreu um erro: ${error.message}`);
            } else {
                alert('Ocorreu um erro desconhecido.');
            }
        } finally {
            selectHorario.disabled = true;
            selectDia.disabled = true;
            inputSala.disabled = true;
            btnAdicionar.disabled = true;
        }
    })
})

