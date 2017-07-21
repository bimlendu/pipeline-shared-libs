#!/usr/bin/groovy

def call() {
  sh 'curl -s http://169.254.169.254/latest/dynamic/instance-identity/document | jq .region -r > region'
  String region=readFile('region').trim()
  return region
}