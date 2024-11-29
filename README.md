## TỔNG QUAN VỀ ĐỀ TÀI
Trong ứng dụng sản phẩm hiện thực cho mini project lần này, em sẽ xây dựng một ứng
dụng thông minh cho phép người dùng có thể theo được nhiệt độ và độ ẩm theo thời gian
thực trong căn nhà của mình, với các cảm biến về nhiệt độ và độ ẩm được đặt ở các vị trí
thích hợp ở trong phòng.

• Các giá trị về nhiệt độ và độ ẩm không khí đo được sẽ được gửi trực tiếp và liên tục đến
Server Adafruit IO, sau đó các data này sẽ được Ádafruit gửi đến điện thoại thông minh
của chủ nhân căn nhà(trong project này, thiết bị sử dụng sẽ là điện thoại ảo) và hiển thị
ra màn hình của ứng dụng một cách trực quan.

• Việc tạo ra các giá trị về nhiệt độ và độ ẩm trong dự án này sẽ được **hiện thực bằng
công cụ Postman** với việc thiết lập ngưỡng giá trị cho phép cho nhiệt độ và độ ẩm. Sau
đó, sẽ tạo ra các giá trị ngẫu nhiên thuộc khoảng này và gửi đến **Adafruit thông qua API
của mỗi Feed cảm biến riêng biệt**.

• Ngoài ra, ứng dụng còn **hỗ trợ việc điều khiển thiết bị từ xa thông qua việc sử dụng
2 nút nhấn riêng biệt** để điều khiển 2 thiết bị thông minh trong ngôi nhà là: điều hòa
nhiệt độ và máy tạo độ ẩm không khí để có thể tác động trực tiếp đến nhiệt độ và
độ ẩm trong căn phòng khi nhiệt độ hoặc độ ẩm gây hại cho sức khỏe của con người ở bên
trong căn phòng.

• Bên cạnh đó thì với quyền admin của server Adaruit, chúng ta vẫn có thể **điều khiển
2 thiết bị nói trên với các nút nhấn ở Dashboard và việc điều khiển này sẽ được đồng bộ
với ứng dụng thông minh ở phía người dùng(Client)**.

## IMAGE DEMO SẢN PHẨM
![Giao diện app demo](https://github.com/vinhngtr/Internet_of_thing-IOT-/blob/Mini_project/giao_dien.PNG?raw=true)

[Báo cáo hoàn thiện sản phẩm](https://drive.google.com/file/d/1f5EM0vB0sJRjTm5rKLj_L6MhmLbMisxG/view?usp=sharing)
