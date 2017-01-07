set THIS_DIR=%~dp0
cd %THIS_DIR%workspace\modules\editor-components\editor\target\editor
:: === Approve and Publish imported content ===
call bin\cm64 editor
:: ===
cd %THIS_DIR%
pause