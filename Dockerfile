FROM ubuntu:latest

MAINTAINER stone (1453793807@qq.com)

# 替换阿里云的源
RUN echo '^^^^^^^^ BUILD rio/demo based on ubuntu ^^^^^^^^' && \
    echo '========> UPDATE apt-get source ...' && \
    echo 'deb http://mirrors.ustc.edu.cn/ubuntu/ xenial main restricted universe multiverse' > /etc/apt/sources.list && \
    echo 'deb http://mirrors.ustc.edu.cn/ubuntu/ xenial-security main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb http://mirrors.ustc.edu.cn/ubuntu/ xenial-updates main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb http://mirrors.ustc.edu.cn/ubuntu/ xenial-proposed main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb http://mirrors.ustc.edu.cn/ubuntu/ xenial-backports main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb-src http://mirrors.ustc.edu.cn/ubuntu/ xenial main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb-src http://mirrors.ustc.edu.cn/ubuntu/ xenial-security main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb-src http://mirrors.ustc.edu.cn/ubuntu/ xenial-updates main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb-src http://mirrors.ustc.edu.cn/ubuntu/ xenial-proposed main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb-src http://mirrors.ustc.edu.cn/ubuntu/ xenial-backports main restricted universe multiverse' >> /etc/apt/sources.list && \
    echo 'deb http://cn.archive.ubuntu.com/ubuntu bionic main multiverse restricted universe' >> /etc/apt/sources.list && \
    echo 'deb http://cn.archive.ubuntu.com/ubuntu bionic-updates main multiverse restricted universe' >> /etc/apt/sources.list && \
    echo 'deb http://cn.archive.ubuntu.com/ubuntu bionic-security main multiverse restricted universe' >> /etc/apt/sources.list && \
    echo 'deb http://cn.archive.ubuntu.com/ubuntu bionic-proposed main multiverse restricted universe' >> /etc/apt/sources.list && \
    # 更新 包管理
    apt-get update && \
    apt-get -y upgrade

WORKDIR /root
ADD ./jdk-13.0.2_linux-x64_bin.tar.gz ./

RUN echo '========> INSTALL jdk: 13' && \
    echo 'export JAVA_HOME=/root/jdk-13.0.2' >> .bashrc && \
    echo 'export CLASSPATH=.:${JAVA_HOME}/lib' >> .bashrc && \
    echo 'export PATH=${JAVA_HOME}/bin:$PATH' >> .bashrc && \
    bash -c "source .bashrc" && \
    bash -c "source /etc/profile"

ADD ./target/demo-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/root/app.jar"]