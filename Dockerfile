FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk11
COPY target/calculationApp.war /opt/jboss/wildfly/standalone/deployments/