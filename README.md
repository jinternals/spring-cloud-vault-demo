# vault-demo


#### How to setup vault:


*  Start vault server :

```
    vault server -config=vault.conf
```

*  Set vault address to VAULT_ADDR for cli use :    

```    
    export VAULT_ADDR=http://127.0.0.1:8200
```
    
*  Initilize vault :

```    
    vault init 
        or
    vault init -key-shares=5 -key-threshold=2
```
*  Unseal vault : 
 
```        
    vault unseal <token>
```    
*  Store some secret in vault : 
 
```    
  export VAULT_TOKEN=<root token generated during init pahse>
  vault write secret/vault-demo test=some-data
```  

*  Mount mysql : 

``` 
vault mount mysql
``` 
*  Setup mysql connection : 

``` 
vault write mysql/config/connection connection_url="root:machine@tcp(127.0.0.1:3306)/"
``` 
*  Setup role with script for  creation and the authorization : 

``` 
vault write mysql/roles/demo sql="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT,CREATE,ALTER,UPDATE,INDEX,INSERT,REFERENCES ON *.* TO '{{name}}'@'%';"

``` 
*  Read credentials from vault : 

``` 
vault read mysql/creds/demo
``` 