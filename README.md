<h2 align="center">Тестовое задание Junior Python Developer (Выполнено на стеке Java)</h2>
<hr>
<h3>Общее описание</h3>

<h5>Реализовать REST API согласно описанию, приведённому ниже.</h5>
<h5>Для реализации использовать связку Python+SQLAlchemy+Flask
Готовые библиотеки для реализации API (flask-restless, и т. д.) не использовать!<h5>
<h5>Обработчики HTTP запросов должны быть реализованы самостоятельно!
Результат выполнения задания разместить на любом git хостинге (github, gitlab, bitbucket)<h5>
<h5>Результат выполнения задания должен содержать инструкции по установке и запуску ПО,
при необходимости скрипты развёртывания.<h5>
<h3>Описание REST API:</h3>
<h4>API предоставляет доступ к набору сущностей Article
Сущность содержит следующие поля:<h4>
<h5>id: integer, — идентификатор статьи<h5>
<h5>author: string — автор<h5>
<h5>created: isodatetime — дата, время создания статьи, присваивается автоматически при
создании записи<h5>
<h5>updated: isodatetime — дата, время обновления статьи, присваивается автоматически при
создании и обновлении записи<h5>
<h5>content: text — содержимое статьи<h5>
<h4>В качестве транспортного протокола API используется протокол HTTP
API возвращает и принимает данные в формате JSON<h4>
<h3>Список вызовов:<h3>
<h5>URL HTTP метод Описание<h5>
<h5>/api/articles GET Получить список статей<h5>
<h5>/api/articles POST Добавить статью<h5>
<h5>/api/articles/<id> GET Получить данные статьи с идентификатором id<h5>
<h5>/api/articles/<id> PUT, PATCH Обновить данные статьи с идентификатором id,<h5>
<h5>допускается частичное обновление
/api/articles/<id> DELETE Удалить статью и идентификатором id<h5>
<h3>Описание вызовов:<h3>
<h5>GET /api/articles<h5>
<h5>Коды возврата: 200<h5>
<h5>Принимаемые данные: нет<h5>
<h5>Возвращаемые данные:<h5>
<h5>{
<h5>"objects": [<h5>
<h5>{<h5>
<h5>"author": "Pushkin A.S.",<h5>
<h5> "content": "Я помню чудное мгновенье",<h5>
<h5> "created": "2019-01-28T10:09:39",<h5>
<h5> "id": 1,<h5>
<h5>"updated": "2019-01-28T10:09:39"<h5>
<h5> },<h5>
<h5>{<h5>
<h5>"author": "Pushkin A.S.",<h5>
<h5> "content": "Я помню чудное мгновенье",<h5>
<h5>"created": "2019-01-28T10:09:39",<h5>
<h5>"id": 2,<h5>
<h5>"updated": "2019-01-28T10:09:39"<h5>
<h5> }<h5>
<h5>]<h5>
}<h5>
<h5>POST /api/articles<h5>
<h5>Коды возврата: 200, 400 — при некорректных входных данных<h5>
<h5>Принимаемые данные:<h5>
<h5>{
<h5> "author": "Pushkin A.S.",<h5>
<h5> "content": "Я помню чудное мгновенье",<h5>
}<h5>
<h5>Возвращаемые данные:<h5>
<h5>{
<h5> "author": "Pushkin A.S.",<h5>
<h5> "content": "Я помню чудное мгновенье",<h5>
<h5>"created": "2019-01-28T10:09:39",<h5>
<h5> "id": 2,<h5>
<h5> "updated": "2019-01-28T10:09:39"<h5>
}<h5>
<h5>GET /articles/id <h5>
<h5>Коды возврата: 200, 404 — при отсутствии сущности<h5>
<h5>Принимаемые данные: нет<h5>
<h5>Возвращаемые данные:<h5>
<h5>{
<h5>"author": "Pushkin A.S.",<h5>
<h5>"content": "Я помню чудное мгновенье",<h5>
<h5>"created": "2019-01-28T10:09:39",<h5>
<h5>"id": 2,<h5>
<h5>"updated": "2019-01-28T10:09:39"<h5>
}<h5>
<h5>PUT /articles/<id><h5>
<h5>PATCH /articles/<id><h5>
<h5>Допускается частичное обновление полей сущности<h5>
<h5>Коды возврата: 200, 404 — при отсутствии сущности<h5>
<h5>Принимаемые данные:<h5>
<h5>{
 "author": "Pushkin A.S.",
 "content": "Я помню чудное мгновенье",
}<h5>
<h5>Возвращаемые данные:<h5>
<h5>{
 "author": "Pushkin A.S.",
 "content": "Я помню чудное мгновенье",
 "created": "2019-01-28T10:09:39",
 "id": 2,
 "updated": "2019-01-28T10:09:39"
}<h5>
<h5>DELETE /articles/id<h5>
<h5>Коды возврата: 200, 404 — при отсутствии сущности<h5>
<h5>Принимаемые данные: нет<h5>
<h5>Возвращаемые данные:<h5>
<h5>{
 "message": "ok"
}<h5>
<h3>Обработка ошибок:<h3>
<h5>Ошибки должны возвращаться стандартными HTTP кодами<h5>
<h5>Тело ответа должно содержать JSON содержащий ключ «message» с текстовым описанием<h5>
<h5>ошибки.<h5>
<h5>Пример:<h5>
<h5>Запрос:<h5>
<h5>GET /api/articles/100500<h5>
<h5>Ответ:<h5>
<h5>404,<h5>
<h5>{<h5>
<h5>"message": "article 100500 not found"<h5>
<h5>}<h5>
