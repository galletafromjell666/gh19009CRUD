FROM payara/server-full:5.2021.6-jdk11
ARG DB_USER
ARG DB_NAME
ARG DB_PASSWORD
USER root
RUN apt update && apt install -y wget inetutils-ping telnet postgresql-client
USER payara
RUN wget -O /$PAYARA_DIR/glassfish/lib/postgres.jar https://jdbc.postgresql.org/download/postgresql-42.3.6.jar
RUN echo "create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource  --property user=$DB_USER:password=$DB_PASSWORD:serverName=db:portNumber=5432:databaseName=$DB_NAME baches-pool"  >> $PREBOOT_COMMANDS
RUN echo "create-jdbc-resource --connectionpoolid baches-pool jbc/baches" >> $PREBOOT_COMMANDS
RUN echo "deploy $PAYARA_DIR/gh19009CRUD-1.0-SNAPSHOT.war" >> $POSTBOOT_COMMANDS
COPY /target/gh19009CRUD-1.0-SNAPSHOT.war $PAYARA_DIR
