# Secret-Garden
一个基于RSA、MD5、SHA的加密信息传输系统
##注册
![mahua](http://ofmz75843.bkt.clouddn.com/register.JPG)
用户需要输入ID、用户名、密码（密码会通过用户下方选择的数字摘要算法进行加密，
密码以数字摘要的形式存储于数据库中）、选择使用的加密方式


##登录
![mahua](http://ofmz75843.bkt.clouddn.com/login.JPG)
* 用户输入注册成功后的ID和密码进行登录，用户输入的密码会再次以用户注册时选择的
数字摘要算法进行加密，将加密后的信息与数据库中存储的加密后的密码进行对比，如果
一致用户将进入首页面，如果不一致将弹出提示框

#首页面
![mahua](http://ofmz75843.bkt.clouddn.com/search)
用户登录成功即可进入首页面，该页面会显示用户的相关信息，即时将获取到的其他用户发送过来的密文告知用户
为了优化操作，这里暂时只显示最新一条消息

##查询公钥
![mahua](http://ofmz75843.bkt.clouddn.com/gongy.JPG)
如果用户想给其他用户发送密文，需要在此模块输入对方的ID来获取对方的公钥

##发送密文
![mahua](http://ofmz75843.bkt.clouddn.com/sendMsg)
用户选择密文接受方的ID并将密文发送过去


##关于作者

```javascript
  var ihubo = {
    nickName  : "BubbleM",
    site : "bubblelm@163.com"
  }
```
