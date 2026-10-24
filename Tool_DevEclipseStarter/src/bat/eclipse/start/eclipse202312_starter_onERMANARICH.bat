@echo on
@echo Einige Tests vorab
@echo 1) Version der Shell: %COMSPEC%
@echo 2) aktuelles Verzeichnis: %~dp0
for /f %%i in ('"echo test_auf_zerlegung_OK"') do @echo FOR /F funktioniert? %%i
pause


@echo off
REM ####################################################################
REM ### START ECLIPSE PER BATCH
REM ### Zur Dokumentation der Lösung siehe eclipse_starter_onRECHNERXYZ_example.bat
REM ####################################################################
REM
REM ##################################################################
REM ### Umgebungsvariabeln sind nur für diese Eclipse-Session gültig
REM ##################################################################

REM Ohne BATCH ist das folgende Zeile
REM C:\java\eclipse\eclipse.exe -refresh -clean -data "C:\Workspace\Eclipse202312"  -vmargs -Xms7168m -Xmx7168m -Dfile.encoding=UTF-8  -vm "C:\java\openjdk-17.0.2_windows-x64_bin" -vmargs -Dfile.encoding=UTF-8

REM Pfad zu Eclipse, den zu verwendenden Workspace und die Java VM 
set MY_ECLIPSE=C:\java\eclipse\eclipse.exe
set MY_DATA=C:\Workspace\Eclipse202312
set MY_JAVA=C:\java\openjdk-17.0.2_windows-x64_bin\bin

REM Verwende den TRUSTSORE in Eclipse in der jeweils benoetigten .launch Datei, oder Eclipse selbst:   -Djavax.net.ssl.trustStore=${env_var:MY_TRUSTSTORE}
REM set MY_TRUSTSTORE=C:\java\jdk1.8.0_202\jre\lib\security\cacerts
set MY_TRUSTSTORE=C:\java\openjdk-17.0.2_windows-x64_bin\lib\security\cacerts

REM TODOGOON: Noch ncht genutzters DEFAULT-Projektalias... vielleicht für die Ermittlung der Java-Development-Tools 
set MY_PROJECTALIAS=DEV

REM Letztendlich der Repository Name, z.B. Projekt_Kernel02_JAZDummy wird direkt als Argument übergeben und ist nicht in den Umgebungsvariablen
REM Lokales Repository: "Basis"-Pfad 
set sRLZZZ=C:\1fgl\repo\Eclipse202312

REM Remote Repository: Host (ohne abschliessenden Slash)
set sRRHZZZ=github.com

REM Remote Repository: Account
set sRRACZZZ=firak01

REM Zusaetzliche "geheime" Umgebungsvariablen setzen. Dies passiert in der Batch, die nie ins gitHub Repository eingecheckt werden darf.
for /f "delims=" %%i in ('"%~dp0secret_starterZZZ.bat"') do set %%i

@echo off
@echo Variable: %sPATZZZ%
REM PAUSE

REM Eclipse starten
@echo off
REM Zeile aus dem Windows Link: C:\java\eclipse-jee-oxygen-3a-win32-x86_64\eclipse\eclipse.exe -refresh -clean -data C:\Workspace\EclipseOxygenWorkspace -vm c:\java\jre8\bin\javaw.exe -clean  -Xms2048m -Xmx2048m -vmargs -Dfile.encoding=UTF-8 -Duser.name="Fritz Lindhauer"

start "" "%MY_ECLIPSE%" -refresh -clean  ^
-data "%MY_DATA%"  ^
-vm "%MY_JAVA%" -Xms2048m -Xmx2048m  ^
-vmargs -Dfile.encoding=UTF-8 -Djavax.net.ssl.trustStore="%MY_TRUSTSTORE%" ^
-Duser.name="Fritz Lindhauer"

@echo off
REM das konsolenfenster schliessen. Was wichtig ist, falls ein aufrufendes Programm auf das Ende des Batch-Tasks wartet.
REM PAUSE
BREAK
exit