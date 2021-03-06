USE [cm7replication]
GO
DROP SCHEMA [cm7replication]
GO

USE [cm7replication]
GO
DROP USER [cm7replication]
GO

USE [master]
GO
DROP LOGIN [cm7replication]
GO

EXEC msdb.dbo.sp_delete_database_backuphistory @database_name = N'cm7replication'
GO
USE [master]
GO
ALTER DATABASE [cm7replication] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO
USE [master]
GO
DROP DATABASE [cm7replication]
GO
