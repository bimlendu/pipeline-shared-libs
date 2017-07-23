def call(credentials, account, srcNo, dstNo, msg){
    String payLoad = """
{
  "src":"$srcNo",
  "dst":"$dstNo", 
  "text": "java.net.URLEncoder.encode(msg)"
}
"""

  httpRequest(
    acceptType: 'APPLICATION_JSON',
    contentType: 'APPLICATION_JSON',
    authentication: credentials,
    httpMode: 'POST',
    responseHandle: 'NONE',
    requestBody: payLoad,
    consoleLogResponseBody: false,
    url: "https://api.plivo.com/v1/Account/$account/Message/",
    validResponseCodes: '202'
  )
}