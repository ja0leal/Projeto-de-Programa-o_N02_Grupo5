ALTER TABLE dbo.Diciplina
DROP CONSTRAINT Fk_Diciplina_Professor;
GO

ALTER TABLE dbo.Diciplina
DROP COLUMN IdProfessor;
GO

CREATE TABLE Turma(
	IdTurma INT IDENTITY(1,1) NOT NULL,
	Nome VARCHAR(20) NOT NULL,
	IdDiciplina INT NOT NULL,
	IdProfessor INT NOT NULL,

	CONSTRAINT Pk_Turma PRIMARY KEY (IdTurma),
	CONSTRAINT Fk_Turma_Diciplina FOREIGN KEY (IdDiciplina)
		REFERENCES dbo.Diciplina(IdDiciplina),
	CONSTRAINT Fk_Turma_Professor FOREIGN KEY (IdProfessor)
		REFERENCES dbo.Professores(IdProfessor)
)

CREATE TABLE AlunoTurma(
	IdAluno INT NOT NULL,
	IdTurma INT NOT NULL,

	CONSTRAINT Pk_AlunoTurma PRIMARY KEY (IdAluno, IdTurma),
	CONSTRAINT Fk_AlunoTurma_Aluno FOREIGN KEY (IdAluno)
		REFERENCES dbo.Aluno(IdAluno),
	CONSTRAINT Fk_AlunoTurma_Turma FOREIGN KEY (IdTurma)
		REFERENCES dbo.Turma(IdTurma)
)

