```sh
docker run --rm --init -it -p 443:443 -p 80:80 -p 22:22 \
-v /tmp/gitlab/config:/etc/gitlab \
-v /tmp/gitlab/logs:/var/log/gitlab \
-v /tmp/gitlab/data:/var/opt/gitlab \
gitlab/gitlab-ce:13.9.1-ce.0
```

