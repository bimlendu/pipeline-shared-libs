#!/usr/bin/groovy
import groovy.json.JsonSlurperClassic 

@NonCPS
def jsonParse(String json){
    new groovy.json.JsonSlurperClassic().parseText(json)
}