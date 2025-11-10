CREATE TABLE dbo.Horario (
	IdHorario INT IDENTITY(1,1) NOT NULL,
	IdDiciplina INT NOT NULL,
	HorarioInicio TIME NOT NULL,
	Sala VARCHAR(50) NOT NULL,

	CONSTRAINT Pk_Horario PRIMARY KEY (IdHorario),
	CONSTRAINT Fk_Horario_Diciplina FOREIGN KEY (IdDiciplina)
		REFERENCES dbo.Diciplina(IdDiciplina)
)

CREATE TABLE dbo.Diciplina(
	IdDiciplina INT IDENTITY(1,1) NOT NULL,
	Nome VARCHAR(100) NOT NULL,
	IdProfessor INT NOT NULL,

	CONSTRAINT Pk_Diciplina PRIMARY KEY (IdDiciplina),
	CONSTRAINT Fk_Diciplina_Professor FOREIGN KEY (IdProfessor)
		REFERENCES dbo.Professores(IdProfessor)
)

ALTER TABLE dbo.Horario
ADD DiaSemana TINYINT NOT NULL
