interface ProfessorRequest {
    nome: string;
}

interface ProfessorResponse {
    idProfessor: number;
    nome: string;
}

document.addEventListener("DOMContentLoaded", () => {
    const btnAdicionar = document.getElementById("btnAdicionar");
    const inputNome = document.getElementById("inputNome");
    const erroInputNome = document.getElementById("erroInputNome");
    const sucessInputNome = document.getElementById("sucessInputNome");
    const btnsDeletar = document.querySelectorAll(".btnDeletar");

    if (!(inputNome instanceof HTMLInputElement) || !(btnAdicionar instanceof HTMLButtonElement)) {
        console.error('Falha ao carregar elementos do formulário de professor.');
        return;
    }

    btnsDeletar.forEach(button => {
        if(!(button instanceof HTMLButtonElement)) {return;}
        button.addEventListener("click", async () => {
            const professorId = button.dataset.id;
            if(!professorId) {
                console.error('Falha ao carregar elementos do professor.');
                return;
            };

            const data: ProfessorRequest = {
                nome: professorId
            };

            try {
                const response = await fetch('/api/professor/delete', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(data)
                })
                if (response.ok) {
                    window.location.reload();
                }

            }catch (error) {
                console.error('Falha ao adicionar professor:', error);
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
        if(erroInputNome){
            erroInputNome.style.display = "none";
        }
        btnAdicionar.innerHTML = "Carregando...";
        if(sucessInputNome){
            sucessInputNome.innerText = '';
        }

        const nome = inputNome.value.trim();
        if(nome ===''){
            if(erroInputNome){
                erroInputNome.innerText = "Insira um nome.";
                erroInputNome.style.display = "block";
            }
            inputNome.disabled = false;
            btnAdicionar.disabled = false;
            btnAdicionar.innerHTML = '<i class="fa-solid fa-plus"></i> <span>Adicionar</span>';
            return;
        }

        const professorData: ProfessorRequest = {
            nome: nome
        };

        try{
            const response = await fetch('/api/professor/add', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(professorData)
            })

            if(!response.ok){
                const erro = await response.json();
                alert(erro);
                throw new Error(erro);
            }

            const novoProfessor: ProfessorResponse = await response.json();
            console.log(novoProfessor.idProfessor);
            inputNome.value = '';
            window.location.reload();
            if(sucessInputNome){
                sucessInputNome.innerText = `Professor(a) ${novoProfessor.nome} adicionado(a) com sucesso`;
            }

        }catch (error) {
            console.error('Falha ao adicionar professor:', error);
            if (error instanceof Error) {
                alert(`Ocorreu um erro: ${error.message}`);
            } else {
                alert('Ocorreu um erro desconhecido.');
            }
        }
        inputNome.disabled = false;
        btnAdicionar.disabled = false;
        btnAdicionar.innerHTML = '<i class="fa-solid fa-plus"></i> <span>Adicionar</span>';
    })
})