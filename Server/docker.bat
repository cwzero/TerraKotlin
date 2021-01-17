@ECHO OFF
cmd /c "gradle dockerBuildImage"
docker-compose up
pause