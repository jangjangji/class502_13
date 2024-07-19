package org.choongang.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
//Json은 틀을 정해 공통된 형식으로 보내는게 좋음
public class JSONData {
    private HttpStatus status = HttpStatus.OK; //200
    private boolean success = true;
    private Object message; // 실패이유 메세지 map 형태 일수도 있기떄문에 Object로 정의
    @NonNull
    private Object data; //데이터 형식은 다 있으니 상위로 선언

}
