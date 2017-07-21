def call(apiEndpoint, apiKey, componentID, pageID, inc, name) {
  String payLoad = """
{  
  "incident": {
    "name": "$name",
    "status": "resolved",
    "component_ids": [
      "$componentID"
    ]
  }
}
"""
  httpRequest(
    acceptType: 'APPLICATION_JSON',
    consoleLogResponseBody: false,
    contentType: 'APPLICATION_JSON',
    customHeaders: [[maskValue: true, name: 'Authorization', value: 'OAuth ' + apiKey]],
    httpMode: 'PATCH',
    requestBody: payLoad,
    responseHandle: 'NONE',
    url: apiEndpoint + 'pages/' + pageID + '/incidents/' + inc + '.json',
    validResponseCodes: '200'
  )
}