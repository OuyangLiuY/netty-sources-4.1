# Netty 

## 阅读源码技巧：

1. 官网+源码
2. 梳理流程脉络
3. 逐个攻破
4. 切记钻牛角尖

## Mark
```text
 // 内存slab高速着色
 // 43分钟
 // 内存释放
 // DefaultHandle
 问题: 
```
## 1、Netty本地导入IDEA编译

```sh
# 1.导入，使用4.1.42版本
git clone git@github.com:OuyangLiuY/netty-sources-4.1.git -b 4.1.42
# 2.项目配置JDK1.8
# 3.进入common目录，执行如下命令
mvn install -Dmaven.test.skip=true -Dcheckstyle.skip=true   -Denforcer.skip=true
# 4.刷新maven工程，build即可
```

## 2、Netty架构

Netty is *an asynchronous event-driven network application framework*
for rapid development of maintainable high performance protocol servers & clients.

Netty 是一个异步事件驱动的网络应用框架 用于快速开发可维护的高性能协议服务器和客户端

架构图：

![](.\images\netty-arch.png)

Netty is a NIO client server framework which enables quick and easy development of network applications such as protocol servers and clients. It greatly simplifies and streamlines network programming such as TCP and UDP socket server.

Netty 是一个 NIO 客户端服务器框架，可以快速轻松地开发网络应用程序，例如协议服务器和客户端。它极大地简化和精简了 TCP 和 UDP 套接字服务器等网络编程。

'Quick and easy' doesn't mean that a resulting application will suffer from a maintainability or a performance issue. Netty has been designed carefully with the experiences earned from the implementation of a lot of protocols such as FTP, SMTP, HTTP, and various binary and text-based legacy protocols. As a result, Netty has succeeded to find a way to achieve ease of development, performance, stability, and flexibility without a compromise.

“快速简便”并不意味着生成的应用程序会受到可维护性或性能问题的影响。Netty 是根据从许多协议（例如 FTP、SMTP、HTTP 以及各种基于二进制和文本的遗留协议）的实现中获得的经验而精心设计的。因此，Netty 成功地找到了一种方法，实现了易于开发的、可靠性、稳定性和灵活性，而不是一种折中方案。

特性：

由架构图可以看出，Netty主要分为3部分：

### 2.1、transport service

传输服务：

- Socket和Datagram（数据报）协议
- HTTP Tunnel（HTTP 隧道）
- In-VM Pipe（虚拟机内通道）

Socket和Datagram协议是大家平常使用最多的TCP和UDP协议，

HTTP Tunnel：就和在TCP/IP协议上构建PPTP隧道建立安全的VPN链接类似，HTTP隧道技术是在HTTP协议上构建一个隧道，使得原本只能用于HTTP通讯的HTTP端口能够承载其他各类通讯内容。

虚拟机内通道：JVM的管道，处理进程间通信，进程间常用通讯方式划分为 管道，共享内存，Socket

### 2.2、protocols support

Netty协议支持：

- HTTP&WebSocket
- SSL&StartTLS：加密协议
- Google Protobuf：google的序列化协议
- zlib/gzip Compression：zlib和gzip压缩
- Large File Transfer：超大文件传输
- RTSP：位于应用层的多媒体实时流传输协议
- Legacy Text Binary Protocols with Unit Testability：传统文本。具有单元测试性的二进制协议

### 2.3、core

Netty核心模块：

- Extensible Event Model：扩展事件模型
- Universal Communication API：通用的通信API
- Zero-Copy-Capable Rich Byte Buffer：支持零拷贝的富字节缓冲区

## 3、事件循环器模型推导

## 4、内存管理之分配

### 4.1、内存分配算法

思考：内存分配需要思考的问题？

1. 减少外碎片
2. 减少内碎片

#### 4.1.1、伙伴算法

注意：尽量减少外碎片，是将例如 16M内存分配成2048个块，没个块8KB，第一和第二个块组成了伙伴，依次内推，而且伙伴可以合并，假如合并成16KB,那么总共有1024个块，也是第一和第二个块组成了伙伴。

#### 4.1.2、slab算法

注意：尽量减少内碎片，为小内存而生，在伙伴算法基础上，将最小的块(8KB)分成N个小份，在满足需要内存的情况下分配尽量小块，但也不是无限分配，netty中最小的块是16byte。

### 4.2、内存分配之 jemalloc

看：jemalloc论文.pdf

### 4.3、Netty 内存分配原理



## 5、内存管理之释放



## 6、Netty 协议管理

netty协议出现的问题：

1. 粘包，拆包：

   解决方案：基于特殊标记(DelimiterBasedFrameDecoder)，固定大小传递(FixedLengthFrameDecoder)，基于长度字段（LengthFieldBasedFrameDecoder）

2. 线头阻塞：是http协议某个端口在请求，但是其他请求又来，那么就阻塞等待，

   解决方案：使用IO多路复用(多个端口)和线程池

## 7、总结
