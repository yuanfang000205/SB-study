# RestFul介绍

**一种软件设计风格，标准简洁。优雅，有层次**

## URL定义

* 资源：互联网所有的事物都可称之为资源
* 资源操作：
  * GET 获取资源
  * POST 请求资源
  * PUT 更新资源
  * PATCH 更新资源(部分字段)
  * DELETE 删除资源

## 设计原则

```markdown
# 1）使用名词不使用动词
# 2）GET方法和查询参数不应该涉及状态改变
# 3）使用复数名词
# 4）使用子资源表达关系
# 5）使用Http头声明序列化格式
# 6）为集合提供过滤、排序、选择和分页功能
# 7）版本化API：/blog/api/v1   -----  一般在URL后使用?v
# 8）使用Http状态码处理错误
  ` 200	   -- OK 	 -- 一切正常
  ` 201    -- OK     --新资源创建成功
  ` 204    -- OK     --资源已经成功删除
  ` 304    --Not Modified   --客户端使用缓存数据
  ` 400    --Bad Request    --请求无效，需要附加细节如“JSON无效”
  ` 401    --Unauthorized   --请求需要用户验证
  ` 403    --Forbidden   	--服务器已经了解了请求，但是拒绝服务或该请求的访问是不允许的
  ` 404    --Not Found   	--没有发现该资源
  ` 422    --Unprocessable Entity    --只有服务器不能处理实体时使用，比如图像不能被格式化或者重要字段丢失
  ` 500    --Internal Server Error   --API开发者应避免此错误
  使用详细的错误包装错误：	状态码	数据	header头信息
  {
 "errors": [
 {
 "userMessage": "Sorry, the requested resource does not exist",
  "internalMessage": "No car found in the database",
 "code": 34,
 "more info": "http://dev.mwaysolutions.com/blog/api/v1/errors/12345"
  }
  ]
}
```

