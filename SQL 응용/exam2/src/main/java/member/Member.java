package member;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@EqualsAndHashCode
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {
    @NonNull
    private String userId;
    @NonNull
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}
