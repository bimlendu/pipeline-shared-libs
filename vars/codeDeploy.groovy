def call(appName, groupName, bucket, key, waitFor){
  _sh 'aws --output text --region ' + getAWSRegion() + ' deploy create-deployment --application-name ' + appName + ' --deployment-group-name ' + groupName + ' --s3-location bucket=' + bucket + ',bundleType=zip,key=' + key + ' --file-exists-behavior=OVERWRITE --query "deploymentId" > deployID'
            
  String deployID=readFile('deployID').trim()
    
  timeout(time: waitFor, unit: 'MINUTES'){
    awaitDeploymentCompletion(deployID)
  }
}