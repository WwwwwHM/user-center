# 1. 基础镜像：使用 Nginx 轻量版本（Alpine 系统，体积最小）
FROM nginx:alpine

WORKDIR /usr/share/nginx/html/
USER root

# 4. 复制前端打包后的静态文件到 Nginx 服务目录
# 注意：前端项目打包后的目录是 dist（Umi/Vue/React 默认），若你的目录不同需修改
COPY ./dist /usr/share/nginx/html

# 5. 复制自定义 Nginx 配置文件（解决前端路由和 API 代理，关键！）
# 若不需要自定义配置，可删除这一行（但路由刷新会 404，API 无法转发）
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
# 6. 暴露 Nginx 端口（默认 80，前端服务端口）
EXPOSE 80

# 7. 启动 Nginx（前台运行，确保容器不退出）
CMD ["nginx", "-g", "daemon off;"]
