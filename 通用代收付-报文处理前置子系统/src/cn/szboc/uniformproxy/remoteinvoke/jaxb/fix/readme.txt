

每次生成JAXB的bean后,都需要替换一下文件内容:

1, 替换package-info.java



2, 添加接口
每一支交易的request和response都要分别集成IGetRequestInfo接口和IGETResponseInfo接口