USE [cm7caefeeder]
GO
DROP SCHEMA [cm7caefeeder]
GO

USE [cm7caefeeder]
GO
DROP USER [cm7caefeeder]
GO

USE [master]
GO
DROP LOGIN [cm7caefeeder]
GO

EXEC msdb.dbo.sp_delete_database_backuphistory @database_name = N'cm7caefeeder'
GO
USE [master]
GO
ALTER DATABASE [cm7caefeeder] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO
USE [master]
GO
DROP DATABASE [cm7caefeeder]
GO
