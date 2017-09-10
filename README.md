#vault-demo


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