# ==================== 阶段 1：构建阶段（使用 Maven 镜像编译打包）====================
# 基础镜像：包含 JDK 8 和 Maven，用于编译代码
FROM maven:3.8.8-openjdk-8 AS builder

# 设置工作目录（容器内的目录）
WORKDIR /app

# 复制 Maven 配置文件（pom.xml），优先复制以利用 Docker 缓存
# 只有 pom.xml 变更时，才会重新下载依赖
COPY pom.xml .

# 复制项目所有源代码到工作目录
COPY src ./src

# 编译打包：生成可执行 Jar 包（-DskipTests 跳过测试，加速构建）
RUN mvn package -DskipTests

CMD ["java -jar .\user-center-backend-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod"]
