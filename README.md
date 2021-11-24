## Qzone Wordpress Sync Bot

WIP but works.

### 配置文件(config.yml)

```yaml
rpc: https://<blog url here>/xmlrpc.php
username: <同步用WP账号>
password: <同步用WP密码>
post-type: <文章类型，默认用post，特别模板用shuoshuo>
title-prefix: '[说说同步]' # 所有的同步说说将被添加这个前缀
sync-mode: 0 # 0-黑名单，带有keyword的不同步， 1=白名单，带有keyword的同步
sync-mode-keyword: '[wp-sync-skip]' # keyword
```

### QQ账号文件(account.txt)

```plain
2908803755
```
填写QQ号就行

### Cookies文件(cookies.txt)

```plain
把你的QQ空间cookies粘贴在这里
```

### Make it works

* 确保你已安装 python3 
* 确保你已安装 Java11+
* 确保你已正确解压所有文件
* 确保你的站点没有禁用 XML-RPC
* 确保你的配置都正确 
* java -jar QzoneSync.jar
* 看看你的Blog！

### 特别鸣谢

https://github.com/zhyea/wordpress-client

https://github.com/SmartHypercube/Qzone-API

### 关于本项目

佛系开发，不考虑添加新功能，不接受任何建议，BUG修复随缘，就算你提到了我也不一定会修，能用就行。

MIT License
