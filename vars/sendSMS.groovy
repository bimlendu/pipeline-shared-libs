def call(credentials, account, srcNo, dstNo, msg){
  String encoded_msg = java.net.URLEncoder.encode(msg)

  String payLoad = """
{
  "src":"$srcNo",
  "dst":"$dstNo", 
  "text": "$encoded_msg"
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