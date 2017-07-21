#!/usr/bin/groovy
import groovy.json.JsonSlurperClassic 

@NonCPS
def call(String json){
    new groovy.json.JsonSlurperClassic().parseText(json)
}