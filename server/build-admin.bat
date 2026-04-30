@echo off
REM ==========================================================================
REM  一键打包 otterwood-admin（管理端后端）
REM  产物: server\otterwood-admin\target\otterwood-admin.jar
REM  运行: java -jar otterwood-admin.jar
REM ==========================================================================
setlocal ENABLEDELAYEDEXPANSION
chcp 65001 >nul

REM 切换到脚本所在目录（即 server 目录），保证使用根 pom
cd /d "%~dp0"

echo [otterwood] 准备打包 otterwood-admin ...
echo [otterwood] 工作目录: %cd%
echo [otterwood] 执行: mvn -pl otterwood-admin -am -DskipTests clean package
echo.

call mvn -pl otterwood-admin -am -DskipTests clean package
if errorlevel 1 (
    echo.
    echo [otterwood][ERROR] 打包失败，请检查上方 Maven 输出。
    exit /b 1
)

set "JAR=%cd%\otterwood-admin\target\otterwood-admin.jar"
if not exist "!JAR!" (
    echo.
    echo [otterwood][ERROR] 未找到产物: !JAR!
    exit /b 2
)

echo.
echo [otterwood][OK] 打包成功
echo [otterwood] 产物: !JAR!
echo [otterwood] 启动示例: java -jar "!JAR!"
endlocal
exit /b 0
