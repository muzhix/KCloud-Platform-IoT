UPDATE `config_info` SET `data_id` = 'laokou-admin.yaml', `group_id` = 'LAOKOU_GROUP', `content` = '# jasypt\njasypt:\n  encryptor:\n    password: 5201314wumeihua\n\n# spring\nspring:\n  datasource:\n    dynamic:\n      # 默认false,建议线上关闭\n      p6spy: false\n      #设置严格模式,默认false不启动. 启动后在未匹配到指定数据源时候会抛出异常,不启动则使用默认数据源\n      strict: false\n      datasource:\n        # user:\n        #   driver-class-name: org.apache.shardingsphere.driver.ShardingSphereDriver\n        #   url: jdbc:shardingsphere:nacos:application-admin.yaml\n        # login_log:\n        #   driver-class-name: org.apache.shardingsphere.driver.ShardingSphereDriver\n        #   url: jdbc:shardingsphere:nacos:application-auth.yaml\n        master:\n          type: com.zaxxer.hikari.HikariDataSource\n          driver-class-name: com.mysql.cj.jdbc.Driver\n          url: jdbc:mysql://mysql.laokou.org:3306/kcloud_platform_alibaba?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true\n          username: ENC(OuDQnY2CK0z2t+sq1ihFaFHWve1KjJoRo1aPyAghuRAf9ad3BO6AjcJRA+1b/nZw)\n          password: ENC(XVR9OF604T3+2BINpvvCohjr7/KM/vuP3ZgYpu+FX/h3uogFI3sh26h8wHPBE+rj)\n          # https://blog.csdn.net/u014644574/article/details/123680515\n          hikari:\n            pool-name: HikariCP\n            connection-timeout: 180000\n            validation-timeout: 3000\n            idle-timeout: 180000\n            max-lifetime: 1800000\n            maximum-pool-size: 60\n            minimum-idle: 10\n            is-read-only: false\n  xxl-job:\n    admin:\n      address: http://xxl.job.laokou.org:9095/xxl-job-admin\n    executor:\n      app-name: laokou-admin\n      port: -1\n      log-path: ./logs/xxl-job/laokou-admin\n      access-token: yRagfkAddGXdTySYTFzhvMguinulMIMSCcXUbljWDhe\n      intentionalities: 7\n  default-config:\n    # 流程KEY\n    definition-key: \"Process_88888888\"\n    # 租户表\n    tenant-tables:\n      - boot_sys_audit_log\n      - boot_sys_dept\n      - boot_sys_dict\n      - boot_sys_menu\n      - boot_sys_message\n      - boot_sys_message_detail\n      - boot_sys_operate_log\n      - boot_sys_oss\n      - boot_sys_oss_log\n      - boot_sys_resource\n      - boot_sys_resource_audit\n      - boot_sys_role\n      - boot_sys_role_dept\n      - boot_sys_role_menu\n      - boot_sys_user\n      - boot_sys_user_role\n      - undo_log\n      - boot_sys_domain_event\n    domain-names:\n      - laokou.org\n      - laokouyun.org\n      - laokou.org.cn\n    tenant-prefix: \"tenant\"\n    graceful-shutdown-services:\n      - \"laokou-flowable\"\n      - \"laokou-admin\"\n      - \"laokou-auth\"\n# mybatis-plus\nmybatis-plus:\n  # 全局处理\n  global-config:\n    db-config:\n      column-format: \"`%s`\"\n  tenant:\n    ignore-tables:\n      - boot_sys_tenant\n      - boot_sys_source\n      - boot_sys_package_menu\n      - boot_sys_package\n      - boot_sys_login_log\n    enabled: true\n  slow-sql:\n    enabled: true\n  mapper-locations: classpath*:/mapper/**/*.xml\n  configuration:\n    log-impl: org.apache.ibatis.logging.nologging.NoLoggingImpl\n\ndubbo:\n  application:\n    id: laokou-admin\n    name: laokou-admin\n    qos-port: 33333\n  protocol:\n    id: dubbo\n    name: dubbo\n    port: -1\n  registry:\n    address: nacos://nacos.laokou.org:8848\n    username: nacos\n    group: DUBBO_GROUP\n    password: nacos\n    parameters:\n      namespace: a61abd4c-ef96-42a5-99a1-616adee531f3\n      register-consumer-url: true\n    protocol: nacos\n  metadata-report:\n    address: nacos://nacos.laokou.org:8848\n    username: nacos\n    group: DUBBO_GROUP\n    password: nacos\n    parameters:\n      namespace: a61abd4c-ef96-42a5-99a1-616adee531f3\n  config-center:\n    address: nacos://nacos.laokou.org:8848\n    username: nacos\n    group: DUBBO_GROUP\n    password: nacos\n    parameters:\n      namespace: a61abd4c-ef96-42a5-99a1-616adee531f3\n  consumer:\n    check: false\n    timeout: 5000', `md5` = 'a67131e0ac9954fac6eb5f31101b5c38', `gmt_create` = '2023-09-28 11:37:33', `gmt_modified` = '2024-02-25 16:39:51', `src_user` = 'nacos', `src_ip` = '0:0:0:0:0:0:0:1', `app_name` = 'laokou-admin', `tenant_id` = 'a61abd4c-ef96-42a5-99a1-616adee531f3', `c_desc` = '', `c_use` = '', `effect` = '', `type` = 'yaml', `c_schema` = '', `encrypted_data_key` = '' WHERE `id` = 2022;
