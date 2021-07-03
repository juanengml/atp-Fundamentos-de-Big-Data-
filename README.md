# atp-Fundamentos-de-Big-Data-

Fundamentos de Big Data  - atp 

## Bases Utilizadas 

- https://datalake-operacoes-comerciais-abobora.s3.us-east-2.amazonaws.com/base_100_mil.csv 

- https://datalake-operacoes-comerciais-abobora.s3.us-east-2.amazonaws.com/base_inteira.csv

## COMO RODAR 

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao1 /juan.manoel/base_inteira.csv /juan.manoel/informacao1;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao2 /juan.manoel/base_inteira.csv /juan.manoel/informacao2;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao3 /juan.manoel/base_inteira.csv /juan.manoel/informacao3;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao4 /juan.manoel/base_inteira.csv /juan.manoel/informacao4;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao5 /juan.manoel/base_inteira.csv /juan.manoel/informacao5;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao6 /juan.manoel/base_inteira.csv /juan.manoel/informacao6;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao7 /juan.manoel/base_inteira.csv /juan.manoel/informacao7;

- yarn jar atp-juan-1.0-SNAPSHOT.jar com.pucpr.atp.juan.Informacao8 /juan.manoel/base_inteira.csv /juan.manoel/informacao8


### Dentro da pasta atp local

- hadoop fs -copyToLocal /juan.manoel/informacao1 .

- hadoop fs -copyToLocal /juan.manoel/informacao2 .

- hadoop fs -copyToLocal /juan.manoel/informacao3 .

- hadoop fs -copyToLocal /juan.manoel/informacao4 .

- hadoop fs -copyToLocal /juan.manoel/informacao5 .

- hadoop fs -copyToLocal /juan.manoel/informacao6 .

- hadoop fs -copyToLocal /juan.manoel/informacao7 .

- hadoop fs -copyToLocal /juan.manoel/informacao8 .


Copiar pastas do hadoop para o local

no terminal do hadoop usar o comando pwd e copiar o caminho da pasta que quer copiar

no terminal 

scp -r -P 2222 juan.manoel@localhost:{{ colar a pata do hadoop copiada acima }} .
Colocar o login do hadoop

mv {{ Nomedapasta }} Desktop/
