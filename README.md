# spring boot homework

#### How to run it:

**note**: `build_image.sh` will take a long time

```shell script
cd springboot
chmod +x script/build_image.sh
./script/build_image.sh
chmod +x script/start_apps.sh
./script/start_apps.sh
```

#### How to stop it:

```shell script
docker-compose -f script/docker-compose.yml down
```

#### Service port

|  service | port |
|  ------- | ---- |
|  eureka  | 3000 |
|  config  | 3001 |
|  gateway | 3002 |
|   user   | 3003 |
|   email  | 3004 |

