# vault-mysql-spring-cloud-demo


#### How to setup vault:


####
   

*  Start vault and mysql server :

```
         docker-compose up -d
         docker-compose stop
         docker-compose rm -f
         
         ./config/install_vault.sh
         
```

*  Set vault address to VAULT_ADDR for cli use :    

```    
    export VAULT_ADDR=http://127.0.0.1:8200
```
    
*  Initilize vault :

```    
    ./vault operator init
```
*  Unseal vault : 
 
```        
    ./vault operator unseal <token>
```    
*  Store some secret in vault : 
 
```    
  export VAULT_TOKEN=<root token generated during init pahse>
  vault write secret/vault-demo test=some-data
```  

*  Mount mysql : 

``` 
    ./vault secrets enable database
``` 
*  Setup mysql connection : 

``` 
    ./vault write database/config/mysql-database \
        plugin_name=mysql-database-plugin \
        connection_url="{{username}}:{{password}}@tcp(mysql:3306)/" \
        allowed_roles="application" \
        username="root" \
        password="secret"
        
``` 
*  Setup role with script for creation and the authorization : 

``` 

    ./vault write database/roles/application \
        db_name=mysql-database \
        creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT,CREATE,ALTER,UPDATE,INDEX,INSERT,REFERENCES ON *.* TO '{{name}}'@'%';" \
        default_ttl="1h" \
        max_ttl="24h"
        
``` 
*  Read credentials from vault : 

``` 
    ./vault read database/creds/application
``` 