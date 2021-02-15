build:  #build project
	mvnw clean package
run:
	java -jar target/app-1.0-SNAPSHOT-jar-with-dependencies.jar
update:
	mvnw versions:display-dependency-updates
    # просмотреть доступные обновления для плагинов
	mvnw versions:display-plugin-updates
    # просмотреть доступные обновления для всего, что вынесено в свойства
	mvnw versions:display-property-updates
    # выполнить обновление версий заданных в свойствах
	mvnw versions:update-properties