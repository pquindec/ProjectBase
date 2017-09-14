USE Umbrella
GO
CREATE RULE r_Cedula
as @cedula LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
GO 
EXEC sp_addtype txtCodigos , 'varchar(10)', 'NOT NULL'
EXEC sp_addtype txtDescripciones , 'varchar(50)', 'NULL'
EXEC sp_addtype txtCedulas , 'varchar(10)', 'NOT NULL'
EXEC sp_addtype txtNombres , 'Varchar(50)', 'NOT NULL'
EXEC sp_addtype txtApellidos , 'Varchar(50)', 'NOT NULL'
EXEC sp_addtype txtUsuarios , 'Varchar(50)', 'NULL'
EXEC sp_addtype txtCorreo , 'Varchar(50)', 'NULL'
GO
EXEC sp_bindrule 'r_Cedula' , 'txtCedulas'

GO
ALTER TABLE Actividad
ADD CONSTRAINT FK_Codigo_Proceso
FOREIGN KEY (txtCodigo)
REFERENCES Proceso(txtCodigo)
GO
ALTER TABLE Perfil
ADD CONSTRAINT FK_Cedula_Usuario
FOREIGN KEY (txtId_Perfil)
REFERENCES Usuario(txtCedula)
GO
ALTER TABLE Opciones
ADD CONSTRAINT FK_Id_Perfil
FOREIGN KEY (txtId_Opciones)
REFERENCES Perfil(txtId_Perfil)
GO
ALTER TABLE Opciones
ADD CONSTRAINT FK_Id_Opciones
FOREIGN KEY (txtId_Opciones)
REFERENCES Opciones(txtId_Opciones)
GO
ALTER TABLE Procesos_R
ADD CONSTRAINT FK_Ced_Usuario
FOREIGN KEY (txtId_Procesos_R)
REFERENCES Usuario(txtCedula)
GO
ALTER TABLE Procesos_R
ADD CONSTRAINT FK_Cod_Proceso
FOREIGN KEY (txtId_Procesos_R)
REFERENCES Proceso(txtCodigo)
GO
ALTER TABLE Evidencia
ADD CONSTRAINT FK_Cedula
FOREIGN KEY (FK_Cedula)
REFERENCES Usuario(txtCedula)
GO
ALTER TABLE Evidencia
ADD CONSTRAINT FK_Codigo_Actividad
FOREIGN KEY (txtCodigo)
REFERENCES Actividad(txtCodigo)
GO
ALTER TABLE Evidencia
ADD CONSTRAINT FK_Id_Archivos
FOREIGN KEY (txtCodigo)
REFERENCES Archivos(txtId_Archivos)
GO
ALTER TABLE Archivos_R
ADD CONSTRAINT FK_Cedul_Usuario
FOREIGN KEY (txtId_Archivos)
REFERENCES Usuario(txtCedula)
GO
CREATE TABLE Usuario(
txtCedula varchar(10),
txtNombre varchar(50),
txtApellido varchar(50),
txtUsuario varchar(50),
txtContraseña varchar(50),
txtCorreo varchar(50),
txtTipo_Usuario varchar(50),
PRIMARY KEY (txtCedula)
)
GO
CREATE TABLE Perfil(
txtId_Perfil varchar(10),
txtTipo_Perfil varchar(50),
PRIMARY KEY (txtId_Perfil)
)
 GO

 CREATE TABLE Opciones(
 txtId_Opciones varchar(10),
 txtTipo_Opciones varchar(50),
 PRIMARY KEY (txtId_Opciones)
 )
 GO
 CREATE TABLE Procesos_R(
 txtId_Procesos_R varchar(10),
 PRIMARY KEY (txtId_Procesos_R)
 )
 GO
 CREATE TABLE Proceso(
 txtCodigo varchar(10),
 txtNombre varchar(50),
 txtInforme varchar(250),
 txtEvidencia varchar(250),
 PRIMARY KEY (txtCodigo)
 )
 GO
Create TABLE Evidencia(
 txtCodigo varchar(10),
 txtNombre varchar(50),
 txtEstado varchar(100),
 txtResolucion varchar(250),
 txtTipo_Evidencia varchar(30),
 FK_Cedula varchar(10),
 PRIMARY KEY (txtCodigo)
 )
 GO
 CREATE TABLE Actividad(
 txtCodigo varchar(10),
 txtDescripcion varchar(100),
 txtInforme varchar(250),
 txtResolucion varchar(250)
PRIMARY KEY (txtCodigo)
 )
 GO
 CREATE TABLE Archivos_R(
 txtId_Archivos varchar(10),
 PRIMARY KEY (txtId_Archivos)
 )
 GO
 CREATE TABLE Archivos(
 txtId_Archivos varchar(10),
 txtNombre varchar(50),
 txtDescrpcion varchar(200), 
 txtEstado varchar (150),
 PRIMARY KEY (txtId_Archivos)
 )
 Use Umbrella
GO
--LOGIN 
create login paul
with password='1234',
default_database=Umbrella
GO
--USUARIO
create user paul
for login paul
with default_schema=squema
GO
-- ESQUEMA
create schema squema authorization paul;
GO
--PRIVILEGIOS
GRANT CREATE PROC,EXECUTE,CREATE TABLE, CREATE ROLE, SELECT,INSERT,UPDATE,DELETE TO paul;
--Vista
GO
CREATE VIEW vistaUsuari as 
SELECT txtCedula,txtNombre,txtApellido,txtUsuario,txtContraseña,txtCorreo,txtTipo_Usuario,txtSustentacion FROM Usuario
GO
Alter View vistaEvidencia as
Select txtCodigo,txtNombre,txtEstado,txtResolucion,txtTipo_Evidencia,Fk_Cedula From Evidencia
GO
ALter Procedure TodosE(
@txtCodigo varchar(10),
@txtNombre varchar(50),
@txtEstado varchar(100),
@txtResolucion varchar(250),
@txt_tipoEvidecia varchar(30),
@Fk_Cedula varchar(10),
@StatementType nvarchar(20) = '')
as
begin
if @StatementType = 'Insertar'
Begin
insert into Evidencia(txtCodigo,txtNombre,txtEstado,txtResolucion,txtTipo_Evidencia,Fk_Cedula)
values(@txtCodigo,@txtNombre,@txtEstado,@txtResolucion,@txt_tipoEvidecia,@Fk_Cedula);
end
IF @StatementType = 'Actualizar'  
BEGIN  
UPDATE Evidencia
SET txtCodigo=@txtCodigo,txtNombre=@txtNombre,txtEstado=@txtEstado,
txtResolucion=@txtResolucion,txtTipo_Evidencia=@txt_tipoEvidecia,Fk_Cedula=@Fk_Cedula
WHERE txtCodigo=@txtCodigo
END
Else IF @StatementType = 'Eliminar'  
BEGIN
DELETE FROM Evidencia WHERE txtCodigo=@txtCodigo
END;
End
GO
Create PROCEDURE TodosU  (  
@txtCedula varchar(10),
@txtNombre varchar(50),
@txtApellido varchar(50),
@txtUsuario varchar(50),
@txtContraseña varchar(50),
@txtCorreo varchar(50),
@txtTipo_Usuario varchar(50),
@txtSustentacion varchar(100),
@StatementType nvarchar(20) = '')  
AS  
BEGIN  
IF @StatementType = 'Insertar'  
BEGIN  
insert into Usuario (txtCedula, txtNombre, txtApellido, txtUsuario, txtContraseña, 
		txtCorreo, txtTipo_Usuario, txtSustentacion) values (@txtCedula, @txtNombre, @txtApellido, @txtUsuario, @txtContraseña, 
		@txtCorreo, @txtTipo_Usuario,@txtSustentacion);
END  

IF @StatementType = 'Actualizar'  
BEGIN  
UPDATE Usuario
SET txtCedula=@txtCedula, txtNombre=@txtNombre , txtApellido=@txtApellido,
txtUsuario=@txtUsuario, txtContraseña=@txtContraseña, txtCorreo=@txtCorreo,
txtTipo_Usuario=@txtTipo_Usuario,txtSustentacion=@txtSustentacion
WHERE txtCedula=@txtCedula 
END  

Else IF @StatementType = 'Eliminar'  
BEGIN
DELETE FROM Usuario WHERE txtCedula=@txtCedula
END;
END
Select * From Evidencia
GO
