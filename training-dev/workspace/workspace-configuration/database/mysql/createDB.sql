-- DB config for MySql

CREATE SCHEMA cms CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON cms.*
 TO 'cms'@'localhost'
  IDENTIFIED BY 'cms';

CREATE SCHEMA mls CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON mls.*
 TO 'mls'@'localhost'
  IDENTIFIED BY 'mls';

CREATE SCHEMA rls CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON rls.*
 TO 'rls'@'localhost'
  IDENTIFIED BY 'rls';

CREATE SCHEMA external CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON external.*
 TO 'external'@'localhost'
  IDENTIFIED BY 'external';


