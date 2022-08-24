# vault-mysql-spring-cloud-demo


#### How to setup vault:


####
   

*  Start vault and mysql server :

```shell
    docker-compose up -d
    docker-compose stop
    docker-compose rm -f   
```

*  Install vault - we will use this as CLI :

```shell
    brew tap hashicorp/tap
    brew install hashicorp/tap/vault
```

*  Set vault address to VAULT_ADDR for cli use :    

``` shell
    export VAULT_ADDR=http://127.0.0.1:8200
```
    
*  Initilize vault :

``` shell
    vault operator init
```
*  Unseal vault : 
 
```shell    
    vault operator unseal <token>
```    
*  Store some secret in vault : 
 
```shell    
  export VAULT_TOKEN=<root token generated during init pahse>
```  

```shell   
  vault secrets enable -path=secret/ kv
  vault kv put secret/vault-demo some.username=root some.password=root
  vault kv get secret/vault-demo
```  

*  Mount mysql : 

```shell
    vault secrets enable database
``` 
*  Setup mysql connection : 

```shell
    vault write database/config/mysql-database \
        plugin_name=mysql-database-plugin \
        connection_url="{{username}}:{{password}}@tcp(mysql:3306)/" \
        allowed_roles="application" \
        username="root" \
        password="secret"
        
``` 
*  Setup role with script for creation and the authorization : 

```shell  
    vault write database/roles/application \
        db_name=mysql-database \
        creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT,CREATE,ALTER,UPDATE,INDEX,INSERT,REFERENCES ON *.* TO '{{name}}'@'%';" \
        default_ttl="1m" \
        max_ttl="2m"
``` 
*  Read credentials from vault : 

``` 
    vault read database/creds/application
``` 

* Create database name demo
``` 
    Create database demo;
``` 
