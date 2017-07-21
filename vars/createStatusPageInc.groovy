def call(String apiEndpoint, String apiKey, String componentID, String pageID, String msg, String name){
  String payLoad = """
{ 
  "incident": {
    "name": "$name",
    "message": "$msg",
    "status": "identified",
    "component_ids": [
      "$componentID"
    ]
  }
}
"""
  response = httpRequest(
    acceptType: 'APPLICATION_JSON',
    contentType: 'APPLICATION_JSON',
    consoleLogResponseBody: false,
    customHeaders: [
      [
        maskValue: true,
        name: 'Authorization',
        value: 'OAuth ' + apiKey
      ]
    ],
    httpMode: 'POST',
    requestBody: payLoad,
    responseHandle: 'LEAVE_OPEN',
    url: apiEndpoint + 'pages/' + pageID + '/incidents.json',
    validResponseCodes: '201'
  )

  r = jsonParse(response.content)
  response.close()
  inc = r['id']
  println('Created Incident ID: ' + inc)
  return inc
}