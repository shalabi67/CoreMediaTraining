USE [cm7mcaefeeder]
GO
DROP SCHEMA [cm7mcaefeeder]
GO

USE [cm7mcaefeeder]
GO
DROP USER [cm7mcaefeeder]
GO

USE [master]
GO
DROP LOGIN [cm7mcaefeeder]
GO

EXEC msdb.dbo.sp_delete_database_backuphistory @database_name = N'cm7mcaefeeder'
GO
USE [master]
GO
ALTER DATABASE [cm7mcaefeeder] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO
USE [master]
GO
DROP DATABASE [cm7mcaefeeder]
GO
