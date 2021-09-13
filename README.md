Gatling demostore
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

To test it out, simply execute the following command:

    $mvn gatling:test -Dgatling.simulationClass=angularapp.AngularAppSimulation for angular app or
    $mvn gatling:test -Dgatling.simulationClass=gatlingdemostore.DemostoreSimulation for the gatlingdemostore

or simply:

    $mvn gatling:test
