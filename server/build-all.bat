@echo off
REM ==========================================================================
REM  一键打包 admin + front 两个 Spring Boot 可执行模块
REM  依赖: 自动构建 otterwood-common / otterwood-service 库模块
REM  产物统一拷贝到: server\build\
REM    server\build\otterwood-admin.jar
REM    server\build\otterwood-front.jar
REM ==========================================================================
setlocal ENABLEDELAYEDEXPANSION
chcp 65001 >nul

cd /d "%~dp0"

set "BUILD_DIR=%cd%\build"
set "ADMIN_SRC=%cd%\otterwood-admin\target\otterwood-admin.jar"
set "FRONT_SRC=%cd%\otterwood-front\target\otterwood-front.jar"
set "ADMIN_DST=%BUILD_DIR%\otterwood-admin.jar"
set "FRONT_DST=%BUILD_DIR%\otterwood-front.jar"

echo [otterwood] 准备打包 otterwood-admin + otterwood-front ...
echo [otterwood] 工作目录: %cd%
echo [otterwood] 输出目录: %BUILD_DIR%
echo [otterwood] 执行: mvn -T 1C -pl otterwood-admin,otterwood-front -am -DskipTests clean package
echo.

call mvn -T 1C -pl otterwood-admin,otterwood-front -am -DskipTests clean package
if errorlevel 1 (
    echo.
    echo [otterwood][ERROR] 打包失败，请检查上方 Maven 输出。
    exit /b 1
)

REM 准备统一输出目录（不存在则创建）
if not exist "%BUILD_DIR%" (
    mkdir "%BUILD_DIR%"
)

REM 拷贝 admin jar
if exist "!ADMIN_SRC!" (
    copy /Y "!ADMIN_SRC!" "!ADMIN_DST!" >nul
    if errorlevel 1 (
        echo [otterwood][ERROR] 拷贝 admin jar 失败
        exit /b 2
    )
) else (
    echo [otterwood][ERROR] 未找到源文件: !ADMIN_SRC!
    exit /b 3
)

REM 拷贝 front jar
if exist "!FRONT_SRC!" (
    copy /Y "!FRONT_SRC!" "!FRONT_DST!" >nul
    if errorlevel 1 (
        echo [otterwood][ERROR] 拷贝 front jar 失败
        exit /b 4
    )
) else (
    echo [otterwood][ERROR] 未找到源文件: !FRONT_SRC!
    exit /b 5
)

echo.
echo [otterwood][OK] 打包并归集成功
echo [otterwood] admin 产物: !ADMIN_DST!
echo [otterwood] front 产物: !FRONT_DST!

echo.
echo [otterwood] 启动示例:
echo   java -jar "!ADMIN_DST!"
echo   java -jar "!FRONT_DST!"
endlocal
exit /b 0
