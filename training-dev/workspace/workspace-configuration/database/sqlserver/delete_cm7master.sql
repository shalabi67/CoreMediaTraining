USE [cm7master]
GO
DROP SCHEMA [cm7master]
GO

USE [cm7master]
GO
DROP USER [cm7master]
GO

USE [master]
GO
DROP LOGIN [cm7master]
GO

EXEC msdb.dbo.sp_delete_database_backuphistory @database_name = N'cm7master'
GO
USE [master]
GO
ALTER DATABASE [cm7master] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO
USE [master]
GO
DROP DATABASE [cm7master]
GO
