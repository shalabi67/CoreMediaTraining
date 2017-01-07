set THIS_DIR=%~dp0
cd %THIS_DIR%workspace\modules\cmd-tools\cms-tools-application\target\cms-tools
:: === Approve and Publish imported content ===
call bin\cm64 approve -u admin -p admin -t /Sites /Themes /Settings
call bin\cm64 bulkpublish -u admin -p admin -a -b -c -f /Sites /Themes /Settings
:: ===
cd %THIS_DIR%
pause
