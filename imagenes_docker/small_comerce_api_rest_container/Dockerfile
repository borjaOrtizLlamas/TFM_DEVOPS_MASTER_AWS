FROM amd64/openjdk:8u232-jdk
EXPOSE 8080
RUN DEBIAN_FRONTEND=nointeractive apt-get update -y --no-install-recommends && \
apt-get install -y --no-install-recommends locales && \
locale-gen en_US.UTF-8 && \ 
apt-get install -y --no-install-recommends software-properties-common git maven
ADD small_commerce_api.jar /home/
VOLUME ["/var/log/"]
CMD ["java","-jar","/home/small_commerce_api.jar", "com.borja.Aplication"]