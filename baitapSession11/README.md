# Session11 - Bài 1: Logging cơ bản với SLF4J và Lombok

Java 21, Spring Boot. Controller và Service dùng `@Slf4j` để ghi log trên console.

## Chạy ứng dụng

1. Mở project trong IntelliJ, chọn JDK 21 và tải lại Gradle.
2. Chạy `BaitapSession11Application`.
3. Mở cửa sổ Run/Console, rồi gọi API bằng Postman.

Spring Boot Web đã cung cấp SLF4J và Logback. build.gradle khai báo Lombok bằng compileOnly và annotationProcessor; annotation `@Slf4j` tự tạo biến logger tên `log`.

## Thử API

Chọn **POST → Body → raw → JSON**:

```text
POST http://localhost:8080/api/v1/patients
Content-Type: application/json
```

```json
{
  "name": "Nguyen Van An",
  "age": 30
}
```

API trả HTTP 200 và thông tin vừa tiếp nhận. Console xuất hiện hai log INFO từ Controller và Service:

```text
INFO ... PatientController : Nhận yêu cầu thêm bệnh nhân: Nguyen Van An
INFO ... PatientService    : Đã tiếp nhận bệnh nhân: Nguyen Van An
```

Đổi age thành 121 rồi gửi lại. Console có thêm log WARN:

```text
WARN ... PatientService : Tuổi bệnh nhân quá cao: name=Nguyen Van An, age=121
```

Điều kiện là **age > 120**: tuổi 120 không tạo WARN; tuổi 121 tạo WARN và vẫn được tiếp nhận với HTTP 200. Tên không được trống, tuổi phải được truyền và không âm; dữ liệu sai trả HTTP 400.

Ví dụ câu lệnh ghi log:

```java
log.info("Nhận yêu cầu thêm bệnh nhân: {}", patient.getName());
log.warn("Tuổi bệnh nhân quá cao: name={}, age={}", patient.getName(), patient.getAge());
```

Đây là API minh họa tiếp nhận dữ liệu và logging; dữ liệu trả về là thông tin của request. Build/cache được đặt ngoài project khi kiểm tra để giữ ít file nộp GitHub. Nếu IntelliJ tạo thêm build/.gradle/.idea thì bỏ các thư mục đó khi kéo thả lên GitHub.
