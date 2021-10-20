## Hệ thống quản lý máy bay

@author

_______
Java
![img.png](img.png)

## Cấu trúc folder

+ src
    + [Model]()
    + [Service]()
    + [Handle]()
    + [Controller]()
    + [databaseTest]()

### Handle:

giao tiếp, JSP ?

### Controller:

validate requests -> trả về kết quả.

### Service:

Logic

### Model:

- Chứa các thực thể

### databaseTest:

- file DDL

### Sequence Diagram

## Tổng hợp file :

**Visual paradigm, Docs, ...**
[Link Drive](https://drive.google.com/drive/folders/1MnRWlYfC0M3rlI0FgNvf4DlWtERSRKzT?usp=sharing)
##END
để hiểu hơn về Cấu trúc thư mục :

**TestModel** ở trong folder **Models**, là 1 model bình thường.

**TestDAO** ở DAO, implement **DAO** : Create, Read, UpDate, Delete ( các câu query vào database);

**TestService** ở **Service**, Là logic : ví dụ kiểm tra testString có chứa các kí tự đặc biệt hay không, add nếu không thì add vào csdl, nếu không thì trả về lỗi.

**TestController** nhận các requests, trả về kết quả.