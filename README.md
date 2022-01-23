# storage-app

Даний проект це проста симуляція сховища фруктів і оформлення заказів на них. Для того, щоб запустити цей проект у себе потрібно в IntelliJ натиснути File -> New -> Project from Version Control -> в поле URL вставити https://github.com/DTyvoniuk/storage-app.git.

Використані технології :
- Java 11
- Spring Boot
- Spring Data
- Spring Web
- H2

Ендпоінти :
* POST /fruits - додати новий фрукт
* GET /fruits/{name} - інформація про фрукт по імені
* POST /orders - оформлення заказу
* GET /orders/{id} - інформація про заказ по його 
* GET /orders/history - всі оформленні закази
* GET /orders/available - закази, що були оформленні не більше як 10 хвилин тому
